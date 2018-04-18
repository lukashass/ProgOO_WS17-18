package programming.set9.morses;

import acm.program.ConsoleProgram;

public class Main extends ConsoleProgram {
	@Override
	public void run() {
		String morse = MorseCoder.encode("THIS JUMßBLED MESS");
		println(morse);
		println(MorseCoder.decode(morse));
		println(MorseCoder.decode("- .... .. ...\n" + ".--- ..- -- -... .-.. . -..\n" + "-- . ... ..."));
		println(MorseCoder.decode("- .... .. ... \n" + ".--- ..- -- ... ... -... .-.. . -.. \n" + "-- . ... ..."));
	}
}
