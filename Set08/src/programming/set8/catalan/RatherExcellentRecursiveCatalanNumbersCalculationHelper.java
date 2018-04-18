package programming.set8.catalan;

import java.util.ArrayList;

/**
 * Calculating catalan numbers and get stats.
 * 
 * @author lukas
 *
 */
public class RatherExcellentRecursiveCatalanNumbersCalculationHelper {

	private int calls;
	private int stackDepth;
	private int maxStackDepth;

	// list to hold number of calls to individual catalan numbers
	private ArrayList<Integer> callsList;

	/**
	 * Initialize variables.
	 * 
	 * @param n
	 *            size if callsList.
	 */
	private void init(int n) {
		calls = 0;
		stackDepth = 0;
		maxStackDepth = 0;
		callsList = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			callsList.add(0);
		}
	}

	/**
	 * Calculate Catalan number C(n) and collect statistics along the way.
	 * 
	 * @param n
	 *            which Catalan number to calculate.
	 * @return the calculated Catalan number.
	 * @throws IllegalArgumentException
	 *             if n < 0.
	 */
	public int catalan(int n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}

		// reset
		init(n);

		// helper method for recursion
		return catalanHelper(n);
	}

	/**
	 * Returns the total number of Catalan numbers computed to compute the one
	 * requested by the user.
	 * 
	 * @return number of calculated Catalan numbers.
	 * @throws IllegalStateException
	 *             if this method is called before {@link #catalan(int)} was called.
	 */
	public int getCalculatedCatalanNumbersCount() {
		if (callsList == null) {
			throw new IllegalStateException();
		}
		return calls;
	}

	/**
	 * Returns the number of times the given Catalan number was computed to compute
	 * the one requested by the user.
	 * 
	 * @param i
	 *            the Catalan number whose computation statistics to return.
	 * @return how often C(i) was computed.
	 * @throws IllegalStateException
	 *             if this method is called before {@link #catalan(int)} was called.
	 * @throws IllegalArgumentException
	 *             if the index i is invalid.
	 */
	public int getCalculatedCatalanNumberCount(int i) {
		if (callsList == null) {
			throw new IllegalStateException();
		}
		if (i < 0 || i >= callsList.size()) {
			throw new IllegalArgumentException();
		}
		return callsList.get(i);
	}

	/**
	 * Returns the maximum stack depth encountered while computing the requested
	 * Catalan number.
	 * 
	 * @return maximum stack depth.
	 */
	public int getMaximumStackDepth() {
		return maxStackDepth;
	}

	/**
	 * Helper method to recursively calculate the catalan number.
	 * 
	 * @param n
	 *            which Catalan number to calculate.
	 * @return the calculated Catalan number.
	 */
	private int catalanHelper(int n) {

		// update statistics
		stackDepth++;

		if (stackDepth > maxStackDepth) {
			maxStackDepth = stackDepth;
		}

		calls++;
		callsList.set(n, callsList.get(n) + 1);

		// compute catalan number
		if (n == 0) {
			stackDepth--;
			return 1;
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += catalanHelper(i) * catalanHelper(n - 1 - i);
		}
		stackDepth--;
		return sum;
	}
}
