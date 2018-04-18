package programming.set6.date;

import acm.program.ConsoleProgram;

public class Main extends ConsoleProgram {
	@Override
	public void run() {
		Date date = new Date(1900, 5, 30);
		Date date2 = new Date(1900, 5, 25);
		println(date.sameYearDiff(date2));
	}

}
