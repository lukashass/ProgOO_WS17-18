package programming.set10.rug;

import acm.graphics.GCompound;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.util.RandomGenerator;

/**
 * Implementation of a patch with stars in it.
 * 
 * @author lukas
 *
 */
public class PatchStars extends GCompound {

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

		GRect rect = new GRect(size, size);
		rect.setFilled(true);
		rect.setFillColor(rnd.nextColor());
		add(rect);

		for (int i = 0; i < 6; i++) {
			int bounds = rnd.nextInt(size);
			Star star = new Star(rnd.nextInt(10) + 4, bounds);
			GOval oval = new GOval(bounds, bounds);
			oval.setFilled(true);
			oval.setFillColor(rnd.nextColor());
			int x = rnd.nextInt(size - bounds);
			int y = rnd.nextInt(size - bounds);
			add(oval, x, y);
			add(star, x, y);
		}
	}

}
