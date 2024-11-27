import java.util.NoSuchElementException;

class PriorityQueue<T extends Comparable<T>> {
	private final java.util.PriorityQueue<T> queue = new java.util.PriorityQueue<>();

	public void enqueue(T item) {
		queue.add(item);
	}

	public T dequeue() {
		if (queue.isEmpty()) {
			throw new NoSuchElementException("Priority Queue is empty");
		}
		return queue.poll();
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}
}