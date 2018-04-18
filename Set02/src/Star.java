import acm.graphics.GLine;
import acm.program.GraphicsProgram;

public class Star extends GraphicsProgram {
	public void run() {
		int n = readInt("Number of Points: ");
		int radiusOut = readInt("Outer radius: ");
		int radiusIn = readInt("Inner radius: ");
		
		// n equal angles of a full circle
		double circleSliced = 2 * Math.PI / n;
		
		// offset for circle on which the inner point are
		double offset = circleSliced / 2;

		for (int i = 0; i < n; i++) {
			// outer point of the star
			double x = Math.sin(i * circleSliced) * radiusOut;
			double y = Math.cos(i * circleSliced) * radiusOut;
			
			// inner point of the star
			double xIn = Math.sin(i * circleSliced + offset) * radiusIn;
			double yIn = Math.cos(i * circleSliced + offset) * radiusIn;
			
			// next outer point of the star
			double x1 = Math.sin((i + 1) * circleSliced) * radiusOut;
			double y1 = Math.cos((i + 1) * circleSliced) * radiusOut;
			
			// add lines to the canvas
			add(new GLine(radiusOut + x, radiusOut + y, radiusOut + xIn, radiusOut + yIn));
			add(new GLine(radiusOut + xIn, radiusOut + yIn, radiusOut + x1, radiusOut + y1));
		}
	}
}
