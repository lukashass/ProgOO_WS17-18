import acm.program.ConsoleProgram;

public class PowerSet extends ConsoleProgram {
	public void run() {
		int n;

		while (true) {
			n = readInt("Enter N (0 <= N <= 10): ");
			if (n >= 0 && n <= 10) {
				break;
			}
			println("N is invalid. Try again!");
		}

		int end = 2 << n;
		for (int i = 0; i < end; i++) {

			String set = "";
			int j = 0;

			do {
				if (((i >> j) & 1) == 1) {
					if (set == "") {
						set += j;
					} else {
						set += ", " + j;
					}
				}
				j++;
			} while ((i >> j) != 0);

			println(set);
		}
	}
}
