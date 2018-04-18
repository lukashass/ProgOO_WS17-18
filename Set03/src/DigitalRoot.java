import acm.program.ConsoleProgram;

public class DigitalRoot extends ConsoleProgram {
	public void run() {
		int n = readInt("n: ");

		// check whether n is valid
		if (n > 0) {
			int dsum;

			// sum digits a least once
			do {
				dsum = 0;

				// sum digits
				while (n > 0) {
					dsum += n % 10;
					n /= 10;
				}
				n = dsum;
			} while (n >= 10); // continue summing digits long as n isn't a digital root

			println(dsum);

		} else {
			println("Error");
		}
	}
}