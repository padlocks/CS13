
import java.util.LinkedList;
import java.util.NoSuchElementException;

class SimpleQueue<T> {
	private final LinkedList<T> list = new LinkedList<>();

	public void enqueue(T item) {
		list.addLast(item);
	}

	public T dequeue() {
		if (list.isEmpty()) {
			throw new NoSuchElementException("Queue is empty");
		}
		return list.removeFirst();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}
}