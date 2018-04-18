import acm.program.ConsoleProgram;

/**
 * A program calculating bank account balance after first and second year
 * according to the user's input of initial balance and interest rate.
 */
public class Interest extends ConsoleProgram{
	public void run() {
		double balance = readDouble("Please enter a starting balance: ");
		double rate = readDouble("Please enter an annual interest rate: ");
		
		// calc and print first year balance
		balance = balance + balance * rate / 100;
		println("The balance after the first year is " + balance);
		
		// calc and print second year balance
		balance = balance + balance * rate / 100;
		println("The balance after the second year is "  + balance);
	}
}