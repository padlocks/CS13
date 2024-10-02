import java.util.ArrayList;
import java.util.Collections;

public class StudentManager {
	ArrayList<Student> students = new ArrayList<>();

	public void addStudent(Student student) {
		students.add(student);
	}

	public void sortStudents() {
		Collections.sort(students);
	}

	@Override
	public String toString() {
		return String.format("StudentManager: %s", students);
	}
}