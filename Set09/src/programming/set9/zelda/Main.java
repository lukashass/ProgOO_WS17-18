package programming.set9.zelda;

import acm.program.ConsoleProgram;

public class Main extends ConsoleProgram {
	@Override
	public void run() {

		ZeldaList<Integer> list = new ZeldaList<>();
		list.add(1);
		list.add(12);
		list.add(13);
		list.add(14);
		list.add(98);
		list.add(76);
		println(list.get(4));
		println(list.size());
		println(list.set(4, 88));
		println(list.get(4));
		println(list.indexOf(76));
		println(list.contains(77));
		println(list.remove(88));
		println(list.size());
		println(list.remove(76));
		println(list.size());
		println(list.remove(1));
		println(list.size());
		println(list.remove(12));
		println(list.size());
		println(list.get(4));
		list.add(0, 2);
		println(list.get(1));

	}
}
