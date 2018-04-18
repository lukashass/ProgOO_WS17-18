package programming.set7.sudoku;

import acm.program.ConsoleProgram;

public class Main extends ConsoleProgram {
	@Override
	public void run() {
		Sudoku sudoku = new Sudoku();
		sudoku.setValueAt(0, 1, 1);
		sudoku.setValueAt(0, 2, 2);
		sudoku.setValueAt(0, 3, 3);
		sudoku.setValueAt(8, 4, 4);
		sudoku.setValueAt(8, 8, 5);
		println(sudoku);
		boolean test = sudoku.isValid();
		print(test);
	}
}
