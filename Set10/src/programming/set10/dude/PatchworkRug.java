package programming.set10.dude;

import acm.graphics.GCompound;
import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * GraphicsProgram drawing a rug.
 * 
 * @author lukas
 *
 */
public class PatchworkRug extends GraphicsProgram {

	static int whichPatch = 0;
	static final int SIZE = 100;

	@Override
	public void run() {
		int rows = readInt("rows: ");
		int columns = readInt("columns: ");
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

		// cycle through available patches.
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

/**
 * Implementation of a patch with circles in it.
 * 
 * @author lukas
 *
 */
class PatchCircles extends GCompound {

	private int size;

	/**
	 * Creates a new patch.
	 * 
	 * @param size
	 *            Size of the patch.
	 */
	public PatchCircles(int size) {
		this.size = size;
		drawCircles();
	}

	/**
	 * Draws a bounding box and 10 random circles.
	 */
	private void drawCircles() {
		RandomGenerator rnd = RandomGenerator.getInstance();

		// bounding box.
		GRect rect = new GRect(size, size);
		rect.setFilled(true);
		rect.setColor(rnd.nextColor());
		add(rect);

		for (int i = 0; i < 10; i++) {
			int x = rnd.nextInt(size);
			int y = rnd.nextInt(size);

			// create new oval with random origin and size
			GOval oval = new GOval(x, y, rnd.nextInt(size - x), rnd.nextInt(size - y));
			// make 80 percent of ovals filled.
			oval.setFilled(rnd.nextBoolean(0.8));
			oval.setFillColor(rnd.nextColor());
			add(oval);
		}
	}
}

/**
 * Implementation of a patch with stars in it.
 * 
 * @author lukas
 *
 */
class PatchStars extends GCompound {

	private int size;

	/**
	 * Creates a new patch.
	 * 
	 * @param size
	 *            Size of the patch.
	 */
	public PatchStars(int size) {
		this.size = size;
		drawStripes();
	}

	/**
	 * Draws a bounding box and 6 random stars.
	 */
	private void drawStripes() {
		RandomGenerator rnd = RandomGenerator.getInstance();

		// bounding box.
		GRect rect = new GRect(size, size);
		rect.setFilled(true);
		rect.setFillColor(rnd.nextColor());
		add(rect);

		for (int i = 0; i < 6; i++) {
			int bounds = rnd.nextInt(size);

			// star with random radius and 4 to 13 points.
			Star star = new Star(rnd.nextInt(10) + 4, bounds);

			// circle the same size of the star.
			GOval oval = new GOval(bounds, bounds);
			oval.setFilled(true);
			oval.setFillColor(rnd.nextColor());

			// adding star on top of circle in the same position.
			int x = rnd.nextInt(size - bounds);
			int y = rnd.nextInt(size - bounds);
			add(oval, x, y);
			add(star, x, y);
		}
	}

}

/**
 * Implementation of a patch with rectangles in it.
 * 
 * @author lukas
 *
 */
class PatchRects extends GCompound {
	private int size;

	/**
	 * Creates a new patch.
	 * 
	 * @param size
	 *            Size of the patch.
	 */
	public PatchRects(int size) {
		this.size = size;
		drawRects();
	}

	/**
	 * Draws a bounding box and 6 random rectangles.
	 */
	private void drawRects() {
		RandomGenerator rnd = RandomGenerator.getInstance();

		// bounding box.
		GRect background = new GRect(size, size);
		background.setFilled(true);
		background.setFillColor(rnd.nextColor());
		add(background);

		for (int i = 0; i < 10; i++) {
			int x = rnd.nextInt(size);
			int y = rnd.nextInt(size);

			// create new rectangle with random origin and size
			GRect rect = new GRect(x, y, rnd.nextInt(size - x), rnd.nextInt(size - y));

			// make 80 percent of rectangles filled.
			rect.setFilled(rnd.nextBoolean(0.8));
			rect.setFillColor(rnd.nextColor());
			add(rect);
		}
	}

}

/**
 * Implementation of a simple star.
 * 
 * @author lukas
 *
 */
class Star extends GCompound {

	private int radius;

	/**
	 * Creates a new star.
	 * 
	 * @param n
	 *            Number of points.
	 * @param bounds
	 *            Size of the star.
	 */
	public Star(int n, int bounds) {
		this.radius = bounds / 2;
		drawStar(n);
	}

	/**
	 * Draws the star.
	 * 
	 * @param n
	 *            Number of points.
	 */
	private void drawStar(int n) {

		int radiusIn = radius - radius / 3;

		// n equal angles of a full circle
		double circleSliced = 2 * Math.PI / n;

		// offset for circle on which the inner point are
		double offset = circleSliced / 2;

		for (int i = 0; i < n; i++) {
			// outer point of the star
			double x = Math.sin(i * circleSliced) * radius;
			double y = Math.cos(i * circleSliced) * radius;

			// inner point of the star
			double xIn = Math.sin(i * circleSliced + offset) * radiusIn;
			double yIn = Math.cos(i * circleSliced + offset) * radiusIn;

			// next outer point of the star
			double x1 = Math.sin((i + 1) * circleSliced) * radius;
			double y1 = Math.cos((i + 1) * circleSliced) * radius;

			// add lines to the canvas
			add(new GLine(radius + x, radius + y, radius + xIn, radius + yIn));
			add(new GLine(radius + xIn, radius + yIn, radius + x1, radius + y1));
		}
	}
}