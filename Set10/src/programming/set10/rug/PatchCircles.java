package programming.set10.rug;

import acm.graphics.GCompound;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.util.RandomGenerator;

/**
 * Implementation of a patch with circles in it.
 * 
 * @author lukas
 *
 */
public class PatchCircles extends GCompound {

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

		GRect rect = new GRect(size, size);
		rect.setFilled(true);
		rect.setColor(rnd.nextColor());
		add(rect);

		for (int i = 0; i < 10; i++) {
			int x = rnd.nextInt(size);
			int y = rnd.nextInt(size);
			GOval oval = new GOval(x, y, rnd.nextInt(size - x), rnd.nextInt(size - y));
			oval.setFilled(rnd.nextBoolean(0.8));
			oval.setFillColor(rnd.nextColor());
			add(oval);
		}
	}
}
