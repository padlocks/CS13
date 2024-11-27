public class ServiceCenterSimulation {

    public static void main(String[] args) {

        // 1. Create instances of Queue, Priority Queue, and Deque

        SimpleQueue<Customer> regularQueue = new SimpleQueue<>();

        PriorityQueue<Customer> vipQueue = new PriorityQueue<>();

        Deque<Customer> specialDeque = new Deque<>();



        // 2. Add customers to the respective structures

        regularQueue.enqueue(new Customer("Alice", "Regular", -1));

        vipQueue.enqueue(new Customer("Bob", "VIP", 1));

        specialDeque.addFirst(new Customer("Charlie", "Special", -1));



        // 3. Serve customers and demonstrate behavior

        System.out.println("Serving Regular Queue:");

        while (!regularQueue.isEmpty()) {

            System.out.println(regularQueue.dequeue());

        }



        System.out.println("Serving VIP Priority Queue:");

        while (!vipQueue.isEmpty()) {

            System.out.println(vipQueue.dequeue());

        }



        System.out.println("Serving Special Deque:");

        while (!specialDeque.isEmpty()) {

            System.out.println(specialDeque.removeFirst());

        }

    }

}