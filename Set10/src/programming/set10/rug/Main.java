package programming.set10.rug;

import acm.graphics.GCompound;
import acm.program.GraphicsProgram;

/**
 * GraphicsProgram drawing a rug.
 * 
 * @author lukas
 *
 */
public class Main extends GraphicsProgram {

	static int whichPatch = 0;
	static final int SIZE = 100;

	@Override
	public void run() {
		// int rows = readInt("rows: ");
		// int columns = readInt("columns: ");
		int rows = 3;
		int columns = 3;
		drawRug(rows, columns);
	}

	/**
	 * Draw the whole rug.
	 * 
	 * @param rows
	 *            Number of patches in a row.
	 * @param columns
	 *            Number of patches in a column.
	 */
	private void drawRug(int rows, int columns) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				drawPatch(i, j);
			}

		}
	}

	/**
	 * Draw one patch.
	 * 
	 * @param i
	 *            Index of row to draw in.
	 * @param j
	 *            Index of column to draw in.
	 */
	private void drawPatch(int i, int j) {

		GCompound patch = null;

		switch (whichPatch % 3) {
		case 0:
			patch = new PatchCircles(SIZE);

			break;
		case 1:
			patch = new PatchStars(SIZE);

			break;
		case 2:
			patch = new PatchRects(SIZE);

			break;

		default:
			assert false : "i shouldnt be here?";
			break;
		}
		add(patch, j * SIZE, i * SIZE);
		whichPatch++;
	}
}
