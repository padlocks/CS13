import java.util.Stack;

public class ShuntingYard {
    public static String convertToPostfix(String infix) throws IllegalArgumentException {
        // Resultant postfix expression
        StringBuilder postfix = new StringBuilder();
        // Stack to hold operators and parentheses
        Stack<Character> stack = new Stack<>();

        // Iterate over each character in the infix expression
        for (char token : infix.toCharArray()) {
            if (Character.isLetterOrDigit(token)) {
                // Append operands directly to the postfix expression
                postfix.append(token);
            } else if (token == '(') {
                // Push '(' onto the stack
                stack.push(token);
            } else if (token == ')') {
                // Pop from the stack until '(' is found
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                // If no matching '(', throw an exception
                if (stack.isEmpty() || stack.pop() != '(') {
                    throw new IllegalArgumentException("Mismatched parentheses");
                }
            } else if (Operator.isOperator(token)) {
                // Handle operators
                while (!stack.isEmpty() && Operator.isOperator(stack.peek())
                        && ((Operator.isRightAssociative(token) && Operator.getPrecedence(token) < Operator.getPrecedence(stack.peek()))
                        || (!Operator.isRightAssociative(token) && Operator.getPrecedence(token) <= Operator.getPrecedence(stack.peek())))) {
                    postfix.append(stack.pop());
                }
                // Push the current operator onto the stack
                stack.push(token);
            } else {
                // Throw an exception for invalid characters
                throw new IllegalArgumentException("Invalid character: " + token);
            }
        }

        // Pop any remaining operators from the stack
        while (!stack.isEmpty()) {
            char top = stack.pop();
            if (top == '(' || top == ')') {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            postfix.append(top);
        }

        return postfix.toString();
    }
}
