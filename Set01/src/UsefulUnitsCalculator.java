import acm.program.ConsoleProgram;

public class UsefulUnitsCalculator extends ConsoleProgram {

	public void run() {
		double input = readDouble("Enter a measurement: ");
		println(input / 2.4);
		println(input * 2.4);
	}

}
