
public class Assignment1b {
	public int hailstoneLength(int n) {

		// the user of this method could possibly call with a wrong argument.
		if (n <= 0) {
			throw new IllegalArgumentException("n was supposed to be > 0");
		}

		return compute(n);
	}

	private int compute(int n) {

		// even() or odd() could potentially call this method with wrong argument
		// (precondition).
		assert n > 0 : "n = " + n + ", not > 0!";

		if (n == 1) {
			return 0;
		} else if (n % 2 == 0) {
			return 1 + even(n);
		} else {

			// we checked for even numbers before so this should be odd (invariant).
			assert n % 2 == 1 : "n % 2 = " + n % 2 + ", not 1!";

			return 1 + odd(n);
		}
	}

	private int even(int n) {

		// compute() could potentially call this method with odd n.
		assert n % 2 == 0 : "n % 2 = " + n % 2 + ", not 0!";

		return compute(n / 2);
	}

	private int odd(int n) {
		return compute(3 * n + 1);
	}
}
