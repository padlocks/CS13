public class Truck extends Vehicle {
	private int cargo = 0;

	public Truck(String brand, int speed) {
		super(brand, speed);
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println(brand + " is loaded with " + cargo + " lbs of cargo.");
	}

	public void loadCargo(int amount){
		cargo += amount;
		System.out.println(brand + " is loading " + cargo + " lbs of cargo.");
	}
}