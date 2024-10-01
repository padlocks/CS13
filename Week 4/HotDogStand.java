
public class HotDogStand {
	final private int ID;
	private String address;
	private int countSold;
	private static double cost = 1.25;
	private static double price = 5.00;

	public HotDogStand(int ID, String address) {
		this.ID = ID;
		this.address = address;
	}

	public int gitID() {
		return this.ID;
	}

	public int getCountSold() {
		return this.countSold;
	}

	public void setAddress(String newAddress) {
		this.address = newAddress;
	}

	public void order(int count) {
		this.countSold += count;
	}

	public double netIncome() {
		return this.countSold * (price - cost);
	}

	public String toString() {
		return String.format("ID#: %d\nAddress: %s\nHotdogs sold: %d\nNet Income: %.2f", ID, address, countSold, netIncome());
	}
}	
