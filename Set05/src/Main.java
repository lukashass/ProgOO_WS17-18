import acm.program.ConsoleProgram;

public class Main extends ConsoleProgram {
	@Override
	public void run() {
		ComplexNumber num = new ComplexNumber(42, 32);
		ComplexNumber print = num.conjugate();
		println(print);
	}
}
