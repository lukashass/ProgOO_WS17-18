import acm.program.ConsoleProgram;

public class Assignment1 extends ConsoleProgram {
	public void run() {
		println(1 + 6 * 3 % 10 / 5 + 3 + 7 + 10 / 100 / 10);
		println((((1 + (((6 * 3) % 10) / 5)) + 3) + 7) + ((10 / 100) / 10));

		println(0 / 100);

		println(true || !!false && true != false);
		println((true || ((!(!false)) && (true != false))));

		println(~(1 << +2 & 1 + -(5 & 3)));
		println(~((1 << (+2)) & (1 + (-(5 & 3)))));

		println(2 * Math.PI);

		println(Math.sin((1 + 1) * Math.PI));
		println(Math.sin(2 * Math.PI));
		println(-2.1234567 * Math.pow(10, -16));
	}
}
