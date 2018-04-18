package programming.set10.rug;

import acm.graphics.GCompound;
import acm.graphics.GRect;
import acm.util.RandomGenerator;

/**
 * Implementation of a patch with rectangles in it.
 * 
 * @author lukas
 *
 */
public class PatchRects extends GCompound {
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

		GRect background = new GRect(size, size);
		background.setFilled(true);
		background.setFillColor(rnd.nextColor());
		add(background);

		for (int i = 0; i < 10; i++) {
			int x = rnd.nextInt(size);
			int y = rnd.nextInt(size);
			GRect rect = new GRect(x, y, rnd.nextInt(size - x), rnd.nextInt(size - y));
			rect.setFilled(rnd.nextBoolean(0.8));
			rect.setFillColor(rnd.nextColor());
			add(rect);
		}
	}

}
