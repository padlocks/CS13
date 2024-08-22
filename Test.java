import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		System.out.println("Hello World");

		Scanner scanner = new Scanner(System.in);
		System.out.println('Enter number of students: ');
		int n = scanner.nextInt();

		int[] grades = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.println('Enter grade for student ' + (i + 1) + ': ');
			grades[i] = scanner.nextInt();
		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += grades[i];
		}

		System.out.println('Average grade: ' + sum / n);
	}
}