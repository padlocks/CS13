public class Student implements Comparable<Student> {
	private final String name;
	private final double gpa;

	public Student(String name, double gpa) {
		this.name = name;
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public double getGPA() {
		return gpa;
	}

	@Override
	public int compareTo(Student other) {
		int BEFORE = -1;
		int EQUAL = 0;
		int AFTER = 1;

		// Highest to lowest
		if (this.gpa < other.gpa) {
			return AFTER;
		} else if (this.gpa > other.gpa) {
			return BEFORE;
		} else {
			return EQUAL;
		}
	}

	@Override
	public String toString() {
		return name + " (" + gpa + ")";
	}
}