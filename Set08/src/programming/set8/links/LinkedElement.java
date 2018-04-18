package programming.set8.links;

/**
 * linked list.
 * 
 * @author lukas
 *
 * @param <T>
 *            type of value.
 */
public class LinkedElement<T> {

	private T value;
	private LinkedElement<T> link;

	/**
	 * creates new linked element.
	 * 
	 * @param value
	 *            value of the new element.
	 */
	public LinkedElement(T value) {
		this.value = value;
	}

	/**
	 * Returns the value of the i-th linked element, assuming the current element to
	 * be at index 0.
	 * 
	 * @param i
	 *            0-based index of the element whose value to return.
	 * @return the i-th element's value, or {@code null} if there is no element with
	 *         that index.
	 */
	public T get(int i) {

		// check for non existent elements
		if (i < 0 || i > 0 && link == null) {
			return null;
		}

		T res = value;
		if (i != 0) {
			res = link.get(--i);
		}
		return res;
	}

	/**
	 * Sets the value of the i-th linked element to the given value. If there is no
	 * i-th linked element, nothing happens.
	 * 
	 * @param i
	 *            0-based index of the element whose value to set.
	 * @param newVal
	 *            the new value to set.
	 */
	public void set(int i, T newVal) {

		// go one deeper if not there yet
		if (i > 0) {

			// only set when possible
			if (link != null) {
				link.set(--i, newVal);
			}

		} else {
			value = newVal;
		}

	}

	// /**
	// * Sets the value of the i-th linked element to the given value. If there is
	// no
	// * i-th linked element, nothing happens.
	// *
	// * @param i
	// * 0-based index of the element whose value to set.
	// * @param newVal
	// * the new value to set.
	// */
	// public void addI(int i, T newVal) {
	// if (i - 1 > 0) {
	// link.set(--i, newVal);
	// } else {
	// LinkedElement<T> tempLink = link;
	// link = new LinkedElement<T>(newVal);
	// link.link = tempLink;
	// }
	//
	// }

	/**
	 * Returns the index of the first occurrence of a linked element carrying the
	 * given value in the list.
	 * 
	 * @param val
	 *            the value to search for.
	 * @return index where the value was found, or -1 if it's not in any of the
	 *         linked elements.
	 */
	public int firstIndexOf(T val) {
		int i = -1;

		// start returning if value was found
		if (value == val) {
			return i + 1;
		}

		// go one deeper if not there yet
		if (link != null) {
			i = link.firstIndexOf(val);
		}

		// increase the return value each time to count index
		if (i > -1) {
			return i + 1;
		}

		// if nothing was found
		return -1;
	}

	/**
	 * Adds a new linked element holding the given value at the end of the linked
	 * elements.
	 * 
	 * @param newVal
	 *            the new value.
	 */
	public void add(T newVal) {
		if (link == null) {
			link = new LinkedElement<T>(newVal);
		} else {
			link.add(newVal);
		}
	}

	/**
	 * Removes the i-th element from the linked elements. If {@code i == 0}, this
	 * will effectively remove the head element. Thus, this method returns the
	 * linked element that is the new head element.
	 * 
	 * @param i
	 *            index of the element to remove.
	 * @return the new head element.
	 */
	public LinkedElement<T> remove(int i) {

		// remove the first linked element
		if (i == 0 && firstIndexOf(this.value) == 0) { // this is ambiguous ffs

			this.value = (this.link == null) ? null : this.link.value;
			this.link = (this.link == null) ? null : this.link.link;

			return this;
		}

		// go one deeper if not there yet
		if (i > 0) {

			if (link != null) {
				link.remove(--i);
			}
		} else {

			// assign new link by skipping the current one
			this.link = (this.link == null) ? null : this.link.link;
		}

		// return the (old) head element
		return this;

	}
}