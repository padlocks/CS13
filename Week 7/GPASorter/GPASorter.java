import java.util.Scanner;

public class GPASorter {
	static StudentManager studentManager = new StudentManager();
	static Scanner scanner = new Scanner(System.in);
	static String input = "";

	public static void main(String[] args) {
		Student studentOne = new Student("One", 3.5);
		Student studentTwo = new Student("Two", 2.3);
		Student studentThree = new Student("Three", 2.7);
		Student studentFour = new Student("Four", 3.2);
		Student studentFive = new Student("Five", 3.8);

		studentManager.addStudent(studentOne);
		studentManager.addStudent(studentTwo);
		studentManager.addStudent(studentThree);
		studentManager.addStudent(studentFour);
		studentManager.addStudent(studentFive);

		studentManager.sortStudents();

		System.out.println(studentManager);

		// Scanner input loop to add students via console
		while (true) {
			System.out.println("Enter student name and GPA (like John 3.0), 'exit' to exit.");
			input = scanner.nextLine();

			if (input.equals("exit")) {
				break;
			}

			String[] parts = input.split(" ");
			Student student = new Student(parts[0], Double.parseDouble(parts[1]));
			studentManager.addStudent(student);
			studentManager.sortStudents();
			System.out.println(studentManager);
		}
	}
}