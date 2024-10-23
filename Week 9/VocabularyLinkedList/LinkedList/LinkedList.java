package LinkedList;

import java.util.Iterator;
import java.util.function.Predicate;

public class LinkedList<T extends Comparable<T>> implements Iterable<T> {
	// package only scope references
	Node<T> head;
	Node<T> tail;
	int size;

	// Constructor
	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public void add(T data) {
		if(head == null) {
			head = new Node<>(data);
			tail = head;
		} else {
			tail.next = new Node<>(data);
			tail = tail.next;
		}
		size++;
	}

	public T get(int index) {
		Node<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.data;
	}

	public void remove(int index) {
		if (index == 0) {
			head = head.next;
			size--;
			return;
		}

		Node<T> current = head;
		for (int i = 0; i < index - 1; i++) {
			current = current.next;
		}

		current.next = current.next.next;
		if (current.next == null) {
			tail = current;
		}
		size--;
	}

	public int indexOf(T data) {
		Node<T> current = head;
		int index = 0;
		while (current != null) {
			if (current.data.equals(data)) {
			return index;
			}
			current = current.next;
			index++;
		}
		return -1;
	}

	public boolean contains(T data) {
		Node<T> current = head;
		while (current != null) {
			if (current.data.equals(data)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public void insert(int index, T data) {
		if (index == 0) {
			// Insert at the beginning
			Node<T> newNode = new Node<>(data);
			// Old head is now the next node
			newNode.next = head;
			// New node is now the head
			head = newNode;
			size++;
			return;
		}

		Node<T> current = head;
		for (int i = 0; i < index - 1; i++) {
			// Move to the node before the index
			current = current.next;
		}

		// Insert the new node
		Node<T> newNode = new Node<>(data);
		// New node points to the next node
		newNode.next = current.next;
		// Current node points to the new node
		current.next = newNode;
		// If the new node is the last node, update the tail
		if (newNode.next == null) {
			tail = newNode;
		}
		size++;
	}

	public void addToHead(T data) {
		insert(0, data);
	}

	public int size() {
		return size;
	}

	/**
	 * Helper Classes and Methods - DO NOT MODIFY OR REMOVE
	 */

	// Return an iterator for the list
	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator<>(head);
	}

	// Sort a linked list
	public void sort() {
		LinkedListSorter<T> sorter = new LinkedListSorter<>();
		head = sorter.sort(head);
	}

	// Remove elements based on a predicate.
	public void removeIf(Predicate<T> filter) {
		LinkedListFilter<T> linkedListFilter = new LinkedListFilter<>();
		linkedListFilter.removeIf(this, filter);
	}

	// Return a sublist.
	public LinkedList<T> subList(int fromIndex, int toIndex) {
		LinkedListSublister<T> sublists = new LinkedListSublister<>();
		return sublists.subList(this, fromIndex, toIndex);
	}
}
