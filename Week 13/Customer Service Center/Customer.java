class Customer implements Comparable<Customer> {
	private final String name;
	private final String type;
	private final int priority;

	public Customer(String name, String type, int priority) {
		this.name = name;
		this.type = type;
		this.priority = priority;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getPriority() {
		return priority;
	}

	@Override
	public int compareTo(Customer other) {
		return Integer.compare(this.priority, other.priority);
	}

	@Override
	public String toString() {
		return "Customer{name='" + name + "', type='" + type + "', priority=" + priority + '}';
	}
}
