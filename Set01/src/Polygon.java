import acm.graphics.GLine;
import acm.program.GraphicsProgram;

public class Polygon extends GraphicsProgram {
	public void run() {
		int radius = 100;
		int n = readInt("n=");
		for (int i = 0; i < n; i++) {
			double x = Math.sin(i * 2 * Math.PI / n) * radius;
			double y = Math.cos(i * 2 * Math.PI / n) * radius;
			double x1 = Math.sin((i + 1) * 2 * Math.PI / n) * radius;
			double y1 = Math.cos((i + 1) * 2 * Math.PI / n) * radius;
			add(new GLine(radius + x, radius + y, radius + x1, radius + y1));
		}
	}
}
