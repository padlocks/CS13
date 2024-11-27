import java.util.LinkedList;
import java.util.NoSuchElementException;

class Deque<T> {
	private final LinkedList<T> list = new LinkedList<>();

	public void addFirst(T item) {
		list.addFirst(item);
	}

	public void addLast(T item) {
		list.addLast(item);
	}

	public T removeFirst() {
		if (list.isEmpty()) {
			throw new NoSuchElementException("Deque is empty");
		}
		return list.removeFirst();
	}

	public T removeLast() {
		if (list.isEmpty()) {
			throw new NoSuchElementException("Deque is empty");
		}
		return list.removeLast();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}
}