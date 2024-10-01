public class Vehicle {
	protected String brand;
	protected int speed;

	public Vehicle(String brand, int speed) {
		this.brand = brand;
		this.speed = speed;
	}

	public void displayInfo() {
		System.out.println("Brand: " + brand);
		System.out.println("Speed: " + speed + " km/h");
	}

	public void accelerate() {
		speed += 10;
		System.out.println(brand + " is accelerating. New speed: " + speed + " km/h");
	}
}