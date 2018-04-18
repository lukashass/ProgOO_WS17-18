import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class GoldenRectangles extends GraphicsProgram {

	// golden ratio
	private static final double PHI = 1.618;

	public void run() {
		double width = readInt("width= ");
		int n = readInt("n= ");
		double widthOld = width;
		double posX = 0.0;
		double posY = 0.0;

		// repeat n times
		for (int i = 0; i < n; i++) {
			GRect rekt;
			double height = width / PHI;

			// changing origin of rectangle
			if (i % 4 == 1) {
				posX = posX + widthOld - height;
			}
			if (i % 4 == 2) {
				posY = posY + widthOld - height;
			}

			// rectangle in portrait or landscape
			if (i % 2 == 0) {
				rekt = new GRect(posX, posY, width, height);
			} else {
				rekt = new GRect(posX, posY, height, width);
			}

			add(rekt);
			widthOld = width;
			width = height;
		}
	}
}