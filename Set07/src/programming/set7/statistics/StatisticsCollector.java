package programming.set7.statistics;

import java.util.ArrayList;

/**
 * can keep track of a list of numbers and calculate statistical things.
 * 
 * @author lukas
 *
 */
public class StatisticsCollector {
	private ArrayList<Double> collection = new ArrayList<Double>();

	/**
	 * adds an item to the list.
	 * 
	 * @param item
	 *            item to add to the list.
	 */
	public void addItem(double item) {
		collection.add(item);
	}

	/**
	 * returns the number of items in the list.
	 * 
	 * @return number of items in the list.
	 */
	public int getCount() {
		return collection.size();
	}

	/**
	 * returns the sum of all items in the list.
	 * 
	 * @return sum of all items in the list.
	 */
	public double getSum() {
		double sum = 0;
		for (int i = 0; i < collection.size(); i++) {
			sum += collection.get(i);
		}
		return sum;
	}

	/**
	 * returns the smallest item in the list.
	 * 
	 * @return smallest item in the list.
	 */
	public double getMinimum() {
		if (collection.isEmpty()) {
			return Double.POSITIVE_INFINITY;
		}
		double min = collection.get(0);
		for (int i = 1; i < collection.size(); i++) {
			if (collection.get(i) < min) {
				min = collection.get(i);
			}
		}
		return min;

	}

	/**
	 * returns the biggest item in the list.
	 * 
	 * @return biggest item in the list.
	 */
	public double getMaximum() {
		if (collection.isEmpty()) {
			return Double.NEGATIVE_INFINITY;
		}
		double max = collection.get(0);
		for (int i = 1; i < collection.size(); i++) {
			if (collection.get(i) > max) {
				max = collection.get(i);
			}
		}
		return max;
	}

	/**
	 * returns the average of all items in the list.
	 * 
	 * @return average of all items in the list.
	 */
	public double getAverage() {
		if (collection.isEmpty()) {
			return 0;
		}
		double sum = 0;
		for (int i = 0; i < collection.size(); i++) {

			sum += collection.get(i);

		}
		return sum / collection.size();
	}

	/**
	 * returns the standard deviation of all items added thus far.
	 * 
	 * @return standard deviation of all items added thus far.
	 */
	public double getStandardDeviation() {
		if (collection.isEmpty()) {
			return 0;
		}
		double sum = 0;
		for (int i = 0; i < collection.size(); i++) {

			sum += Math.pow(collection.get(i) - getAverage(), 2);

		}
		return Math.sqrt(sum / collection.size());
	}
}
