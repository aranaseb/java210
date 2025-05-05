package model;

import model.PriorityList;

/**
 * This interface describes an abstract data type to store elements where
 * indexes represent priorities and the priorities can change in several ways.
 * 
 * @author Rick Mercer and Sebastian Arana
 * @param <Type> The type of all elements stored in this collection
 */
public class LinkedPriorityList<Type> implements PriorityList<Type> {

	private class Node {
		private Type data;

		private Node next;

		public Node(Type element, Node link) {
			data = element;
			next = link;
		}
	}

	private Node first;
	private int n;

	// Create an empty list with zero elements
	public LinkedPriorityList() {
		first = null;
		n = 0;
	}

	/**
	 * Return the number of elements currently in this PriorityList
	 * 
	 * @return The number of elements in this PriorityList
	 */
	public int size() {
		return n;
	}

	/**
	 * Return true if there are zero elements in this PriorityList
	 * 
	 * @return true if size() == 0 or false if size() > 0
	 */
	public boolean isEmpty() {
		return n == 0;
	}

	/**
	 * If possible, insert the element at the given index. If index is out of the
	 * valid range of 0..size(), throw new IllegalArgumentException(); When size is
	 * 3, the only possible values for index are 0, 1, 2, and 3 because you can add
	 * an element as the new last, at index size().
	 * 
	 * @param index The index of the element to insert.
	 * @param el    The element to insert
	 * @throws IllegalArgumentException
	 */
	public void insertElementAt(int index, Type el) throws IllegalArgumentException {
		if (index < 0 || index > n) {
			throw new IllegalArgumentException();
		}
		if (index == 0) {
			first = new Node(el, first);
		} else {
			Node current = first;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			if (index == n) {
				current.next = new Node(el, null);
			} else {
				Node temp = current.next;
				current.next = new Node(el, temp);
			}
		}
		n++;
	}

	/**
	 * If possible, return a reference to the element at the given index. If index
	 * is out of the valid range of 0..size()-1, throw new
	 * IllegalArgumentException();. When size is 3, the only possible values for the
	 * parameter index are 0, 1, and 2.
	 * 
	 * @param index The index where the element to retrieve should be.
	 * @return A reference to the element at index index.
	 * @throws IllegalArgumentException
	 */
	public Type getElementAt(int index) throws IllegalArgumentException {
		if (index < 0 || index > n - 1) {
			throw new IllegalArgumentException();
		}
		Node current = first;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.data;
	}

	/**
	 * If possible, remove the element at the given index. If index is out of the
	 * valid range of 0..size()-1, throw new IllegalArgumentException(); When size
	 * is 3, the only possible values for the parameter index are 0, 1, and 2.
	 * 
	 * @param index The index of the element to remove. All other elements must
	 *              remain in the list in contiguous memory.
	 * @throws IllegalArgumentException
	 */
	public void removeElementAt(int index) throws IllegalArgumentException {
		if (index < 0 || index > n - 1) {
			throw new IllegalArgumentException();
		}
		Node current = first;
		for (int i = 0; i < index - 1; i++) {
			current = current.next;
		}
		current.next = current.next.next;
		n--;
	}

	/**
	 * If possible, swap the element located at index with the element at index + 1.
	 * An attempt to lower the priority of an element at index size()-1 has no
	 * effect. All other element must remain in the list. If index is out of the
	 * valid range of 0..size()-1, throw new IllegalArgumentException(); When size
	 * is 3, the only possible values for the parameter index are 0, 1, and 2.
	 * 
	 * @param index The index of the element to be changed with one next to it.
	 * @throws IllegalArgumentException
	 */
	public void lowerPriorityOf(int index) throws IllegalArgumentException {
		if (index < 0 || index > n - 1) {
			throw new IllegalArgumentException();
		}
		if (index != n - 1) {
			Node current = first;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			Type temp = current.data;
			current.data = current.next.data;
			current.next.data = temp;
		}
	}

	/**
	 * If possible, swap the element located at index with the element at index-1.
	 * An attempt to raise the priority at index 0 has no effect and this method
	 * does not throw an IllegalArgumentException. If index is out of the valid
	 * range of 0..size()-1, throw new IllegalArgumentException();. When size is 3,
	 * the only possible values for for the parameter index are 0, 1, and 2.
	 * 
	 * @param index The index of the element to be changed with one next to it.
	 * @throws IllegalArgumentException
	 */
	public void raisePriorityOf(int index) throws IllegalArgumentException {
		if (index < 0 || index > n - 1) {
			throw new IllegalArgumentException();
		}
		if (index != 0) {
			Node current = first;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			Type temp = current.data;
			current.data = current.next.data;
			current.next.data = temp;
		}
	}

	/**
	 * Return a copy of all elements as an array of Objects that is the size of this
	 * PriorityList and in the same order. If there are no elements in this list,
	 * return new Object[0]; A change to the return value must not affect this
	 * PriorityList object.
	 * 
	 * @return An array of Objects where capacity == size()
	 */
	public Object[] toArray() {
		Type[] result = (Type[]) new Object[n];
		Node current = first;
		for (int i = 0; i < n; i++) {
			result[i] = current.data;
			current = current.next;
		}
		return result;
	}

	/**
	 * If possible, move the element at the given index to the end of this list. An
	 * attempt to move the last element to the last has no effect. If the index is
	 * out of the valid range 0..size()-1 throw new IllegalArgumentException(); When
	 * size is 3, the only possible values for the parameter index are 0, 1, and 2.
	 * 
	 * @param index The index of the element to be changed to be the last index.
	 * @throws IllegalArgumentException
	 */
	public void moveToLast(int index) throws IllegalArgumentException {
		if (index < 0 || index > n - 1) {
			throw new IllegalArgumentException();
		}
		if (index != n - 1) {
			Node atIndex = first;
			for (int i = 0; i < index; i++) {
				atIndex = atIndex.next;
			}
			insertElementAt(n, atIndex.data);
			removeElementAt(index);
		}
	}

	/**
	 * If possible, move the element at the given index to the front of this list An
	 * attempt to move the top element to the top has no effect. If the index is out
	 * of the valid range of 0..size()-1, throw new IllegalArgumentException(); When
	 * size is 3, the only possible values for the parameter index are 0, 1, and 2.
	 * 
	 * @param index The index of the element to be changed to the first index.
	 * @throws IllegalArgumentException
	 */
	public void moveToTop(int index) throws IllegalArgumentException {
		if (index < 0 || index > n - 1) {
			throw new IllegalArgumentException();
		}
		if (index != 0) {
			Node atIndex = first;
			for (int i = 0; i < index; i++) {
				atIndex = atIndex.next;
			}
			insertElementAt(0, atIndex.data);
			removeElementAt(index + 1);
		}
	}

}