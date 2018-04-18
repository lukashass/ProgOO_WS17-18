package programming.set10.rug;

import acm.graphics.GCompound;
import acm.graphics.GLine;

/**
 * Implementation of a simple star.
 * 
 * @author lukas
 *
 */
public class Star extends GCompound {

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
