import java.awt.Color;

import acm.graphics.GOval;
import acm.graphics.GPoint;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * approximates PI and draw a fancy circle.
 * 
 * @author lukas
 *
 */
public class PiApproximator extends GraphicsProgram {

	private static final int POINTS = 10000;

	@Override
	public void run() {
		GRect rect = new GRect(0, 0, 400, 400);
		add(rect);

		int count = 0;
		for (int i = 0; i < POINTS; i++) {
			GPoint point = randomPoint();
			GOval oval = new GOval(200 + point.getX() * 200, 200 + point.getY() * 200, 1, 1);
			if (isInCircle(point)) {
				oval.setColor(Color.BLUE);
				count++;
			}
			add(oval);
		}
		println((double) count / POINTS * 4.0);
	}

	/**
	 * Randomly generates a new point whose x and y coordinates lie between -1 and
	 * 1.
	 * 
	 * @return random point.
	 */
	public GPoint randomPoint() {
		RandomGenerator rnd = new RandomGenerator();
		return new GPoint(rnd.nextDouble(-1, 1), rnd.nextDouble(-1, 1));
	}

	/**
	 * Checks if the point with the given coordinates is inside the circle with
	 * radius 1 centered at the coordinate system's origin.
	 * 
	 * @param unitPoint
	 *            the point to check.
	 * @return {@code true} if the point is inside the circle, {@code false} if it's
	 *         not.
	 */
	public boolean isInCircle(GPoint unitPoint) {
		if (Math.sqrt(Math.pow(unitPoint.getX(), 2) + Math.pow(unitPoint.getY(), 2)) < 1.0) {
			return true;
		}
		return false;
	}
}
