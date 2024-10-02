package com.padlocks;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Evaluator {
	// State variables
	private static final Map<String, Class<?>> compiledClasses = new HashMap<>();
	private static final Map<String, Method> compiledMethods = new HashMap<>();
	private static final Map<String, Variable> storedVariables = new HashMap<>();

	public static void evaluateInput(String input) throws Exception {
		// Imports
		if (isImport(input)) {
			handleImport(input);
		// Classes
		} else if (isClass(input)) {
			evaluateClass(input);
		// Methods
		} else if (isMethod(input)) {
			evaluateMethod(input);
		// Expressions
		} else if (isExpression(input)) {
			evaluateExpression(input);
		// Statements
		} else {
			evaluateStatement(input);
		}
	}

	private static boolean isImport(String input) {
		return input.startsWith("import ");
	}

	private static void handleImport(String input) throws Exception {
		// Crude implementation of import handling, revisit this later
		String className = input.substring(input.lastIndexOf(' ') + 1, input.length() - 1).trim();
		String fileName = className.replace('.', '/') + ".java";
		compile(fileName, input);
		loadCompiledClass(className);
	}

	private static boolean isExpression(String input) {
		return !input.endsWith(";");
	}

	private static boolean isClass(String input) {
		return input.startsWith("class ") || 
		input.startsWith("public class ") || 
		input.startsWith("private class ") || 
		input.startsWith("protected class ");
	}

	private static boolean isMethod(String input) {
		return (input.startsWith("public ") || input.startsWith("private ") || input.startsWith("protected ")) && input.contains("(") && input.contains(")");
	}

	private static Object evaluateExpression(String input) throws Exception {
		String className = "ExpressionEvaluator";
		String methodName = "eval";
		String code = "import java.lang.*; public class " + className + " { public static Object " + methodName + "() { return " + input + "; } }";
		Object result = compileAndExecute(className, methodName, code);
		if (result != null) {
			System.out.println("Result: " + result);
			return result;
		}

		return null;
	}

	private static void evaluateStatement(String input) throws Exception {
		if (input.contains("=")) {
			handleVariableDeclaration(input);
		} else if (input.contains("(") && input.contains(")")) {
			handleMethodInvocation(input);
		}
	}

	private static void handleVariableDeclaration(String input) throws Exception {
		String[] tokens = input.split("=");
		String variableName = tokens[0].split(" ")[1].trim();
		String variableType = tokens[0].split(" ")[0].trim();
		String value = tokens[1].replace(";", "").trim();
		
		// Parse the value and store the variable
		Object parsedValue = evaluateVariable(value);

		Variable newVariable = new Variable(variableName, variableType, parsedValue);
		storedVariables.put(variableName, newVariable);
	}

	private static Object evaluateVariable(String value) throws Exception {
		// Check if variable is equal to a method call
		if (value.contains("new ")) {
			return handleClassInstantiation(value);
		}
		else if (value.contains("(") && value.contains(")")) {
			return handleMethodInvocation(value);
		} else {
			return evaluateExpression(value);
		}
	}

	private static Object handleClassInstantiation(String input) throws Exception {
		String className = input.substring(input.indexOf("new ") + 4, input.indexOf("(")).trim();
		String[] arguments = input.substring(input.indexOf('(') + 1, input.indexOf(')')).split(",");
		Object[] args = arguments.length == 1 && arguments[0].trim().isEmpty() 
			? new Object[0] 
			: Arrays.stream(arguments)
				.map(arg -> storedVariables.get(arg.trim()).getValue())
				.toArray();
		// Check if the class is already compiled locally
		if (compiledClasses.containsKey(className)) {
			Class<?> clazz = compiledClasses.get(className);
			return clazz.getDeclaredConstructor().newInstance(args);
		}
		else {
			Class<?> clazz = Class.forName(className);
			return clazz.getDeclaredConstructor().newInstance(args);
		}
	}

	private static Object handleMethodInvocation(String input) throws Exception {
		// Find the position of the dot to separate variable and method
		int dotIndex = input.indexOf(".");
		
		// If there's a dot, it's a method call on an instance variable
		if (dotIndex != -1) {
			String variableName = input.substring(0, dotIndex).trim();
			String methodCall = input.substring(dotIndex + 1).trim();
			
			// Extract the method name and arguments
			String methodName = methodCall.substring(0, methodCall.indexOf("("));
			String argsString = methodCall.substring(methodCall.indexOf("(") + 1, methodCall.indexOf(")"));
			String[] arguments = argsString.split(",");
			
			// Retrieve the instance from stored variables
			Object instance = storedVariables.get(variableName).getValue();
			Object[] args = arguments.length == 1 && arguments[0].trim().isEmpty() 
				? new Object[0] 
				: Arrays.stream(arguments)
					.map(arg -> storedVariables.get(arg.trim()).getValue())
					.toArray();
			
			// Find the method in the instance's class
			Method method = findMethod(methodName, args, instance.getClass());
			
			// Invoke the method on the instance
			if (method != null) {
				Object result = method.invoke(instance, args);
				System.out.println("Result: " + result);
				return result;
			}
		} else {
			// Extract the method name
			String methodName = input.replace("(", "").replace(")", "").replace(";", "");
			
			// Extract arguments between parentheses and split them by comma
			String[] arguments = input.substring(input.indexOf('(') + 1, input.indexOf(')')).split(",");
			Object[] args = arguments.length == 1 && arguments[0].trim().isEmpty() 
				? new Object[0] 
				: Arrays.stream(arguments)
					.map(arg -> storedVariables.get(arg.trim()).getValue())
					.toArray();

			// Find the method based on the name and arguments
			Method method = findMethod(methodName, args, null);
			
			if (method != null) {
				Class<?> declaringClass = method.getDeclaringClass();
				
				// Check if the method is static
				if (Modifier.isStatic(method.getModifiers())) {
					// Static method: invoke without instance
					Object result = method.invoke(null, args);
					System.out.println("Result: " + result);
					return result;
				} else {
					// Non-static method: instantiate the class and invoke the method on the instance
					Object instance = declaringClass.getDeclaredConstructor().newInstance();
					Object result = method.invoke(instance, args);
					System.out.println("Result: " + result);
					return result;
				}
			} else {
				// If method not found, dynamically compile and execute the code
				String className = "DynamicMethodEvaluator";
				String code = "import java.lang.*; public class " + className + " { public static void eval() { " + input + " } }";
				return compileAndExecute(className, "eval", code);
			}
		}
		
		// No method found
		return null;
	}

	private static Method findMethod(String methodName, Object[] args, Class<?> clazz) {
		if (clazz == null) {
			Method method = compiledMethods.get("MethodEvaluator." + methodName);
			if (method == null) {
				for (Class<?> importedClass : compiledClasses.values()) {
					try {
						method = importedClass.getMethod(methodName, Arrays.stream(args).map(Object::getClass).toArray(Class<?>[]::new));
						break;
					} catch (NoSuchMethodException e) {
						// Method not found in this class, continue searching
					}
				}
			}
			return method;
		}
		else {
			try {
				return clazz.getMethod(methodName, Arrays.stream(args).map(Object::getClass).toArray(Class<?>[]::new));
			} catch (NoSuchMethodException e) {
				return null; // Method not found
			}
		}
	}

	private static void evaluateMethod(String input) throws Exception {
		String className = "MethodEvaluator";
		String methodName = input.substring(0, input.indexOf('(')).trim();
		methodName = methodName.substring(methodName.lastIndexOf(' ') + 1);
		
		// Create method code, injecting stored variables
		StringBuilder methodCode = new StringBuilder();
		for (Map.Entry<String, Variable> entry : storedVariables.entrySet()) {
			methodCode.append("static ").append(entry.getValue().getType()).append(entry.getKey())
					.append(" = ").append(entry.getValue().getValue()).append("; ");
		}
		methodCode.append(input);
		
		// Compile and execute the method
		String code = "import java.lang.*; public class " + className + " { " + methodCode.toString() + " }";
		compile(className + ".java", code);
		loadCompiledClass(className);
		Method method = compiledClasses.get(className).getMethod(methodName);
		compiledMethods.put(className + "." + methodName, method);
	}


	private static void evaluateClass(String input) throws Exception {
		String className = input.substring(input.indexOf("class") + 5, input.indexOf("{")).trim();
		compile(className + ".java", input.trim());
		loadCompiledClass(className);
	}

	private static void compile(String fileName, String code) throws Exception {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
		File sourceFile = new File(fileName);
		try (Writer writer = new FileWriter(sourceFile)) {
			writer.write(code);
		}
		Iterable<? extends JavaFileObject> fileObjects = fileManager.getJavaFileObjectsFromFiles(Arrays.asList(sourceFile));
		boolean compilationSuccess = compiler.getTask(null, fileManager, null, null, null, fileObjects).call();
		if (!compilationSuccess) {
			throw new RuntimeException("Compilation failed.");
		}
	}

	private static Object compileAndExecute(String className, String methodName, String code) throws Exception {
		compile(className + ".java", code);
		loadCompiledClass(className);
		Method method = compiledClasses.get(className).getMethod(methodName);
		return method.invoke(null);
	}

	private static void loadCompiledClass(String className) throws Exception {
		URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{new File("").toURI().toURL()});
		Class<?> compiledClass = Class.forName(className, true, classLoader);
		compiledClasses.put(className, compiledClass);
		for (Method method : compiledClass.getDeclaredMethods()) {
			compiledMethods.put(className + "." + method.getName(), method);
		}
	}
}
