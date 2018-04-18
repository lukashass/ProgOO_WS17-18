import acm.program.ConsoleProgram;

public class TemperatureConverter extends ConsoleProgram {
	public void run() {
		println("What do you want me to do?\n" + "(1) Convert Celsius to Fahrenheit\n"
				+ "(2) Convert Fahrenheit to Celsius");
		int mode = readInt("Mode: ");

		// asking for and converting temperature until sentinel
		while (true) {
			double temp = readDouble("Temperature: ");

			// sentinel
			if (temp == -1337) {
				break;
			}

			if (mode == 1) {
				// "temp * 1.8" is evaluated first because "*" has higher precedence than "+"

				// "(already evaluated) + 32.0" is evaluated next because there is no operator
				// with higher "*" precedence than "+" left to evaluate
				temp = temp * 1.8 + 32.0;
			} else {
				// "5.0 / 9.0" is evaluated first. "/" has the precedence as "*" but java
				// evaluates left-right

				// "temp - 32.0" is evaluated next because parenthesis assign the term "temp" to
				// the oparator "-"

				// "(already evaluated) * (already evaluated)" is evaluated last
				temp = 5.0 / 9.0 * (temp - 32.0);
			}
			println(temp);
		}
		println("Goodbye!");
	}
}
