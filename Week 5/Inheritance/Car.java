public class Car extends Vehicle {
	private final int doors;

	public Car(String brand, int speed, int doors) {
		super(brand, speed);
		this.doors = doors;
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Number of doors: " + doors);
	}

	public void honk() {
		System.out.println(brand + " is honking!");
	}
}