import acm.program.ConsoleProgram;

public class Fibonacci extends ConsoleProgram {
	public void run() {
		int n = readInt("n= ");

		// check whether n is valid
		if (n > 0) {

			// exception for the first fibonacci
			if (n == 1) {
				println(1);
				return;
			}

			int first = 0;
			int second = 1;
			int res = 0;

			// repeat n-1 times since the first fibonacci isn't in here
			for (int i = 1; i < n; i++) {
				res = first + second;
				first = second;
				second = res;
			}

			println(res);
		} else {
			println("Error");
		}
	}
}