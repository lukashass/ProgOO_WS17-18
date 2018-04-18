import acm.program.ConsoleProgram;

public class Add3Integers extends ConsoleProgram {

	public void run() {
		int n1 = readInt("Enter n1: ");
		int n2 = readInt("Enter n2: ");
		int n3 = readInt("Enter n3: ");
		int total = n1 + n2 + n3;
		println("The total is " + total + ".");
	}

}
