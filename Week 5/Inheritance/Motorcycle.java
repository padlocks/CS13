public class Motorcycle extends Vehicle {
	public Motorcycle(String brand, int speed) {
		super(brand, speed);
	}

    @Override
	public void accelerate() {
		speed += 20;
		System.out.println(brand + " is accelerating faster! New speed: " + speed + " km/h");
	}
}