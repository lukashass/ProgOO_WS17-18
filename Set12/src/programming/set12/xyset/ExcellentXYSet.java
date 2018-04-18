package programming.set12.xyset;

/**
 * Implementation of a set.
 * 
 * @author lukas
 *
 * @param <E>
 *            Type of the elements in the set.
 */
public class ExcellentXYSet<E> implements XYSet<E> {

	ZeldaList<E> storage;

	/**
	 * Creates a new set.
	 */
	public ExcellentXYSet() {
		storage = new ZeldaList<E>();
	}

	@Override
	public boolean add(E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		if (storage.contains(element)) {
			return false;
		}
		storage.add(element);
		return true;
	}

	@Override
	public boolean remove(E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		return storage.remove(element);
	}

	@Override
	public boolean contains(E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		return storage.contains(element);
	}

	@Override
	public void clear() {
		storage.clear();
	}

	@Override
	public int size() {
		return storage.size();
	}

}

/**
 * A linked list implementation that stores non-null values.
 *
 * @param <T>
 *            data type of elements that can be put into the list.
 */
class ZeldaList<T> {

	/** The list's head element. */
	private ZeldaElement<T> listHead = null;
	/** Current size of the list. */
	private int size = 0;

	//////////////////////////////////////////////////////////////////////////////////////
	// The Methods We Need

	/**
	 * Adds the given value to the end of the list.
	 * 
	 * @param value
	 *            the value to add. If {@code value == null}, nothing happens.
	 */
	public void add(T value) {
		add(size(), value);
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
		if (index < 0 || value == null) {
			// Negative indices or null values are not allowed
			return;
		}

		// Create a new list element
		ZeldaElement<T> newElement = new ZeldaElement<>();
		newElement.setValue(value);

		if (index == 0) {
			// Replace the list head (not that this also works fine if we don't have
			// a list head)
			newElement.setNextElement(listHead);
			listHead = newElement;
		} else {
			ZeldaElement<T> prevElement = listElementAt(index - 1);
			if (prevElement != null) {
				newElement.setNextElement(prevElement.getNextElement());
				prevElement.setNextElement(newElement);
			} else {
				return;
			}
		}

		// Increase the size counter
		size++;
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
		// We don't support null values
		if (value == null) {
			return false;
		}

		// If we don't have a list, we don't have the value
		if (listHead == null) {
			return false;
		}

		// If the list head contains a value, we need a new list head
		if (listHead.getValue().equals(value)) {
			listHead = listHead.getNextElement();
			size--;
			return true;
		}

		// Iterate over the list and check if the next element contains the value
		// we're looking for
		ZeldaElement<T> currElement = listHead;
		while (currElement.getNextElement() != null && !currElement.getNextElement().getValue().equals(value)) {
			currElement = currElement.getNextElement();
		}

		// At this point, the next element is either null or contains the value we're
		// looking for
		if (currElement.getNextElement() == null) {
			return false;
		} else {
			currElement.setNextElement(currElement.getNextElement().getNextElement());
			size--;
			return true;
		}
	}

	/**
	 * Removes all elements from the list.
	 */
	public void clear() {
		// Simply get rid of the head element and reset the size
		listHead = null;
		size = 0;
	}

	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return number of elements.
	 */
	public int size() {
		return size;
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
		if (index < 0) {
			// Negative indices are not allowed.
			return null;
		}

		ZeldaElement<T> element = listElementAt(index);

		if (element == null) {
			return null;
		} else {
			return element.getValue();
		}
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
		if (index < 0 || value == null) {
			// Negative indices are not allowed.
			return null;
		}

		ZeldaElement<T> element = listElementAt(index);

		if (element == null) {
			return null;
		} else {
			T oldValue = element.getValue();
			element.setValue(value);
			return oldValue;
		}
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
		if (value == null) {
			// Null values are not allowed
			return -1;
		}

		ZeldaElement<T> currElement = listHead;
		for (int i = 0; currElement != null; i++) {
			if (currElement.getValue().equals(value)) {
				return i;
			} else {
				currElement = currElement.getNextElement();
			}
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
		// The list contains the given value if its index is at least 0
		return indexOf(value) >= 0;
	}

	/**
	 * Checks if the list contains any elements.
	 * 
	 * @return {@code true} if the list is empty, {@code false} if it isn't.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// Helper Methods

	/**
	 * Returns the list element at the given index, which may be {@code null}.
	 * 
	 * @param index
	 *            the 0-based index.
	 * @return the element at the given index, if any.
	 */
	private ZeldaElement<T> listElementAt(int index) {
		ZeldaElement<T> currElement = listHead;
		for (int i = 1; i <= index && currElement != null; i++) {
			// Advance to the next element, if there is one
			currElement = currElement.getNextElement();
		}

		return currElement;
	}

}

/**
 * A linked list element that stores a value and a link to the next element, if
 * any.
 *
 * @param <T>
 *            data type of the value that can be stored in this element.
 */
class ZeldaElement<T> {

	/** The vaue this element holds. */
	private T value = null;
	/** Link to the next element. */
	private ZeldaElement<T> nextElement = null;

	/**
	 * Returns the value this element holds.
	 * 
	 * @return the value.
	 */
	public T getValue() {
		return value;
	}

	/**
	 * Sets the value this element holds.
	 * 
	 * @param value
	 *            the new value.
	 */
	public void setValue(T value) {
		this.value = value;
	}

	/**
	 * Returns the link to the next element, if any.
	 * 
	 * @return link to the next element, or {@code null} if there is no next
	 *         element.
	 */
	public ZeldaElement<T> getNextElement() {
		return nextElement;
	}

	/**
	 * Sets the next element.
	 * 
	 * @param nextElement
	 *            the new next element.
	 */
	public void setNextElement(ZeldaElement<T> nextElement) {
		this.nextElement = nextElement;
	}

}
