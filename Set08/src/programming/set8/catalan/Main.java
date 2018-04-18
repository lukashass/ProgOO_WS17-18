package programming.set8.catalan;

import acm.program.ConsoleProgram;

public class Main extends ConsoleProgram {
	@Override
	public void run() {
		RatherExcellentRecursiveCatalanNumbersCalculationHelper cat = new RatherExcellentRecursiveCatalanNumbersCalculationHelper();
		println(cat.getCalculatedCatalanNumberCount(3));

		println(cat.catalan(3));
		println(cat.getCalculatedCatalanNumbersCount());
		println(cat.getCalculatedCatalanNumberCount(3));
		println(cat.getMaximumStackDepth());

		println(cat.catalan(2));
		println(cat.getCalculatedCatalanNumbersCount());
		println(cat.getCalculatedCatalanNumberCount(0));
		println(cat.getMaximumStackDepth());
	}
}
