package programming.set9.zelda;

/**
 * Implementation of LinkedList.
 * 
 * @author lukas
 *
 * @param <T>
 *            Type of list content.
 */
public class ZeldaList<T> {

	ZeldaElement<T> head = null;

	/**
	 * Adds the given value to the end of the list.
	 * 
	 * @param value
	 *            the value to add. If {@code value == null}, nothing happens.
	 */
	public void add(T value) {
		if (value != null) {

			// handles adding if list is empty
			if (head == null) {
				head = new ZeldaElement<>();
				head.setValue(value);
				return;
			}

			// handles adding to non empty list
			ZeldaElement<T> current = head;
			// iterate to the last element in the list
			while (current.getNextElement() != null) {
				current = current.getNextElement();
			}
			// set a new element at the end
			current.setNextElement(new ZeldaElement<>());
			current.getNextElement().setValue(value);
		}
	}

	/**
	 * Inserts the given value into the list at the given index. The element that
	 * was at that index previously ends up at {@code index + 1} after this method.
	 * 
	 * @param index
	 *            the index to insert the value at, with
	 *            {@code 0 <= index <= getSize()}. If this condition is not met,
	 *            nothing happens.
	 * @param value
	 *            the value to insert. If this is {@code null}, nothing happens.
	 */
	public void add(int index, T value) {
		if (value != null && index >= 0 && index <= size()) {
			// adding in first element
			if (index == 0) {
				ZeldaElement<T> temp = head;
				head = new ZeldaElement<>();
				head.setValue(value);
				head.setNextElement(temp);
				return;
			}

			// all others
			ZeldaElement<T> current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.getNextElement();
			}
			ZeldaElement<T> temp = current.getNextElement();
			current.setNextElement(new ZeldaElement<>());
			current.getNextElement().setValue(value);
			current.getNextElement().setNextElement(temp);
		}
	}

	/**
	 * Removes the given value from the list if it's in there somewhere.
	 * 
	 * @param value
	 *            the value to remove. If this is {@code null}, nothing is removed.
	 * @return {@code true} if the value was found and removed, {@code false}
	 *         otherwise.
	 */
	public boolean remove(T value) {

		// check for empty list
		if (head == null || value == null) {
			return false;
		}

		// remove first element
		if (head.getValue() == value) {
			head = head.getNextElement();
			return true;
		}

		// remove others
		ZeldaElement<T> current = head;
		// search for value in list
		while (true) {

			// stop at end of list
			if (current.getNextElement() == null) {
				break;
			}
			// check if next element
			if (current.getNextElement().getValue().equals(value)) {
				current.setNextElement(current.getNextElement().getNextElement());
				return true;
			}
			current = current.getNextElement();
		}
		return false;
	}

	/**
	 * Removes all elements from the list.
	 */
	public void clear() {
		head = null;
	}

	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return number of elements.
	 */
	public int size() {

		// empty list
		if (head == null) {
			return 0;
		}

		// non empty list
		int i = 1;
		ZeldaElement<T> current = head;
		// iterate to end of list
		while (current.getNextElement() != null) {
			current = current.getNextElement();
			i++;
		}
		return i;
	}

	/**
	 * Returns the value at the given index in the list.
	 * 
	 * @param index
	 *            the index of the element whose value to return.
	 * @return the value at the given index, or {@code null} if the index is
	 *         invalid.
	 */
	public T get(int index) {
		if (index < 0 || head == null) {
			return null;
		}

		ZeldaElement<T> current = head;

		// iterate to index
		for (int i = 0; i < index; i++) {

			// check if end of list
			if (current.getNextElement() == null) {
				return null;
			}
			current = current.getNextElement();
		}
		return current.getValue();
	}

	/**
	 * Sets the value at the given index.
	 * 
	 * @param index
	 *            index of the value to reset.
	 * @param value
	 *            the new value. If this is {@code null}, nothing happens.
	 * @return the old value at the index, or {@code null} if the index was invalid
	 *         or the new value is {@code null}.
	 */
	public T set(int index, T value) {
		if (index < 0 || head == null || value == null) {
			return null;
		}

		ZeldaElement<T> current = head;

		// iterate to index
		for (int i = 0; i < index; i++) {

			// check if end of list
			if (current.getNextElement() == null) {
				return null;
			}
			current = current.getNextElement();
		}

		// save old value
		T res = current.getValue();

		current.setValue(value);
		return res;
	}

	/**
	 * Returns the smallest index where the given value appears in the list, if it
	 * does.
	 * 
	 * @param value
	 *            the value to look for.
	 * @return the value's index or -1 if {@code value == null} or if the value is
	 *         not in the list.
	 */
	public int indexOf(T value) {

		// empty list
		if (head == null) {
			return -1;
		}

		int i = 0;
		ZeldaElement<T> current = head;
		while (true) {

			if (current.getValue() == value) {
				return i;
			}

			// stop at end of list
			if (current.getNextElement() == null) {
				break;
			}

			current = current.getNextElement();
			i++;
		}
		return -1;
	}

	/**
	 * Checks if the given value appears anywhere in the list.
	 * 
	 * @param value
	 *            the value to search for.
	 * @return {@code true} if the value appears in the list, {@code false} if it
	 *         doesn't or if it is {@code null}.
	 */
	public boolean contains(T value) {
		if (head == null || value == null) {
			return false;
		}

		ZeldaElement<T> current = head;
		while (true) {
			if (current.getValue() == value) {
				return true;
			}
			// stop at end of list
			if (current.getNextElement() == null) {
				break;
			}
			current = current.getNextElement();
		}
		return false;
	}

	/**
	 * Checks if the list contains any elements.
	 * 
	 * @return {@code true} if the list is empty, {@code false} if it isn't.
	 */
	public boolean isEmpty() {
		return head == null ? true : false;
	}

}
