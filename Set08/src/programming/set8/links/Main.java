package programming.set8.links;

import acm.program.ConsoleProgram;

public class Main extends ConsoleProgram {
	@Override
	public void run() {
		// ArrayList<Integer> al = new ArrayList<>();
		LinkedElement<String> headElement = new LinkedElement<>("test");

		// This example is less good than other, possibly better examples
		headElement.add("Kiel");
		headElement.add("is");
		headElement.add("fuckin");
		headElement.add("amazing");
		headElement.add("1");
		headElement.add("2");
		headElement.add("3");
		headElement.set(7, "doo");
		// headElement.add("about");
		// headElement.add("to");
		// headElement.add("witness");
		// headElement.add("another");
		// headElement.add("sunny");
		// headElement.add("day!");
		// println(headElement.remove(6).get(0));

		for (int i = 0; i < 9; i++) {

			println(headElement.get(i)); // prints "Kiel"
		}
		// headElement = headElement.remove(0);
		// headElement.set(6, "rainy");
		println(headElement.firstIndexOf("1")); // prints "rainy"
		println("");

		println(headElement.firstIndexOf("1")); // prints "rainy"

	}
}
