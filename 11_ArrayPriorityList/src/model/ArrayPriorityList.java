package model;

/**
 * This interface describes an abstract data type to store elements where
 * indexes represent priorities and the priorities can change in several ways.
 * 
 * @author Rick Mercer and Sebastian Arana
 * @param <E> The type of all elements stored in this collection
 */
public class ArrayPriorityList<Type> implements PriorityList<Type> {

	private Object[] data;
	private int n;

	public ArrayPriorityList() {
		data = new Object[20];
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
		if (index < 0 || index > size()) {
			throw new IllegalArgumentException();
		} else {
			for (int i = size(); i >= index; i--) {
				data[i + 1] = data[i];
			}
			data[index] = el;
			n++;
		}
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
		if (index < 0 || index > size() - 1) {
			throw new IllegalArgumentException();
		} else {
			return (Type) (data[index]);
		}
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
		if (index < 0 || index > size() - 1) {
			throw new IllegalArgumentException();
		} else {
			for (int i = index; i <= size(); i++) {
				data[i] = data[i + 1];
			}
			data[size()] = null;
			n--;
		}
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
		if (index < 0 || index > size() - 1) {
			throw new IllegalArgumentException();
		} else if (index < size() - 1) {
			Object temp = data[index + 1];
			data[index + 1] = data[index];
			data[index] = temp;
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
		if (index < 0 || index > size() - 1) {
			throw new IllegalArgumentException();
		} else if (index > 0) {
			Object temp = data[index - 1];
			data[index - 1] = data[index];
			data[index] = temp;
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
		Object[] arr = new Object[size()];
		for (int i = 0; i < size(); i++) {
			arr[i] = data[i];
		}
		return arr;
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
		if (index < 0 || index > size() - 1) {
			throw new IllegalArgumentException();
		} else if (index < size() - 1) {
			Object temp = data[index];
			removeElementAt(index);
			insertElementAt(size(), (Type) temp);
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
		if (index < 0 || index > size() - 1) {
			throw new IllegalArgumentException();
		} else if (index > 0) {
			Object temp = data[index];
			removeElementAt(index);
			insertElementAt(0, (Type) temp);
		}
	}

}