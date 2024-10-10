public class Testing {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();

		list.add(10);
		list.add(12);
		list.add(5);

		System.out.println(list.get(0)); // 10

		list.remove(1);

		System.out.println(list.get(1)); // 5
		System.out.println(list.indexOf(5)); // 1
		System.out.println(list.contains(10)); // true
		
		list.insert(1, 15);
		System.out.println(list.get(1)); // 15
		System.out.println(list.get(2)); // 5
	}
}