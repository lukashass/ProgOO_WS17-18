import acm.program.ConsoleProgram;

public class Regex extends ConsoleProgram {
	@Override
	public void run() {
		while (true) {
			String in = readLine("test: ");
			println(in.matches("(′m′ )*′mm′( ′m′)*"));
		}
	}
}
