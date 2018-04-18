import java.awt.Color;

import acm.graphics.GArc;
import acm.program.GraphicsProgram;

public class Rainbow extends GraphicsProgram {
	public void run() {
		setBackground(Color.CYAN);

		// using loop to get 7 arcs
		// the 7th will be set to the same color as the background
		for (int i = 0; i < 7; i++) {
			// creating new arc
			// shrinking and centering it according to its index
			GArc arc = new GArc(20 + i, 20 + i, 500 - 2 * i, 500, 0, 180);

			if (i == 6) {
				arc.setColor(Color.CYAN);
			} else {
				// creating and applying a random color
				arc.setColor(new Color((int) (Math.random() * 255.0), (int) (Math.random() * 255.0),
						(int) (Math.random() * 255.0)));
			}
			arc.isFilled();
			add(arc);
		}
	}
}