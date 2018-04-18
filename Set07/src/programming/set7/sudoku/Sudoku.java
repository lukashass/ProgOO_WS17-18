package programming.set7.sudoku;

/**
 * simple sudoku representation.
 * 
 * @author lukas
 *
 */
public class Sudoku extends NumberBoard {
	/**
	 * creates a new 9 by 9 grid for sudoku.
	 */
	public Sudoku() {
		super(9, 9);
	}

	@Override
	public void setValueAt(int row, int col, int value) {

		// only set valid sudoku values
		if (value == EMPTY || value >= 1 && value <= 9) {
			super.setValueAt(row, col, value);
		}
	}

	/**
	 * checks whether the sudoku board's current state is valid or not.
	 * 
	 * @return {@code true} when board is valid and {@code false} when not.
	 */
	public boolean isValid() {
		return isValidColumns() && isValidRows() && isValidSubgrids();
	}

	/**
	 * checks whether the sudoku board's rows are valid or not.
	 * 
	 * @return {@code true} when rows are valid and {@code false} when not.
	 */
	private boolean isValidRows() {
		// iterate each row
		for (int t = 0; t < 9; t++) {

			// iterate all values for a row
			for (int i = 0; i < 9; i++) {

				// iterate (all) other values for a value
				for (int j = i + 1; j < 9; j++) {
					if (getValueAt(t, i) != EMPTY && getValueAt(t, i) == getValueAt(t, j)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * checks whether the sudoku board's columns are valid or not.
	 * 
	 * @return {@code true} when columns are valid and {@code false} when not.
	 */
	private boolean isValidColumns() {
		// iterate each column
		for (int t = 0; t < 9; t++) {

			// iterate all values for a column
			for (int i = 0; i < 9; i++) {

				// iterate (all) other values for a value
				for (int j = i + 1; j < 9; j++) {
					if (getValueAt(i, t) != EMPTY && getValueAt(i, t) == getValueAt(j, t)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * checks whether the sudoku board's subgrids are valid or not.
	 * 
	 * @return {@code true} when subgrids are valid and {@code false} when not.
	 */
	private boolean isValidSubgrids() {
		// iterate subgrids
		for (int t = 0; t < 3; t++) {
			for (int s = 0; s < 3; s++) {

				// iterate every value of a subgrid
				for (int i = t * 3; i < (t + 1) * 3; i++) {
					for (int j = s * 3; j < (s + 1) * 3; j++) {

						// iterate (all) other values for a value
						for (int k = i + 1; k < (t + 1) * 3; k++) {
							for (int l = j + 1; l < (s + 1) * 3; l++) {

								if (getValueAt(i, j) != EMPTY && getValueAt(i, j) == getValueAt(k, l)) {
									return false;
								}
							}
						}
					}
				}
			}
		}
		return true;
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				result += getValueAt(i, j) == EMPTY ? " " : getValueAt(i, j) + " ";
			}
			result += "\n";
		}
		return result;
	}
}
