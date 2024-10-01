public class Person {
	private String firstName;
	private String lastName;
	private String phoneNumber;

	public Person(String firstName, String lastName, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String toString() {
		return firstName + " " + lastName + " " + phoneNumber;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person p = (Person) obj;
			return firstName.equals(p.firstName) && lastName.equals(p.lastName);
		}
		return false;
	}
}