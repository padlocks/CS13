import java.util.Arrays;

public class Student {
	private final String name;
	private final int[] grades;

	public Student(String name, int[] grades) {
		this.name = name;
		this.grades = grades;
	}

	public double calculateAverage() {
		int total = 0;
		for (int grade : grades) {
			total += grade;
		}

		return total / grades.length;
	}

	public void displayStudentInfo() {
		String str = String.format("%s, Grades: %s", this.name, Arrays.toString(this.grades));
		System.out.println(str);
	}
}