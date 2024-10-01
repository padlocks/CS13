public class Tractor extends Vehicle {
	private int cargo = 0;

	public Tractor(String brand, int speed) {
		super(brand, speed);
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println(brand + " is pulling " + cargo + " lbs of cargo.");
	}

	public void pullCargo(int amount) {
		cargo += amount;
		System.out.println(brand + " is pulling " + cargo + " lbs of cargo.");
	}
}