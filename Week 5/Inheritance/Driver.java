public class Driver {
	public static void main(String[] args) {
		Car car = new Car("Toyota", 120, 4);
		Motorcycle bike = new Motorcycle("Harley-Davidson", 80);
		
		car.displayInfo();
		car.accelerate();
		car.honk();
		
		bike.displayInfo();
		bike.accelerate();

		Truck truck = new Truck("Ford", 50);
		truck.loadCargo(50);
		truck.displayInfo();

		Tractor tractor = new Tractor("CAT", 30);
		tractor.pullCargo(50);
		tractor.displayInfo();
	}
}