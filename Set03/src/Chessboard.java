import java.awt.Color;

import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Chessboard extends GraphicsProgram {
	public void run() {
		int sqSize = 40;
		int offset = 40;
		int boardSize = 8;
		// drawing board
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				// only draw black squares
				if ((i + j) % 2 == 1) {
					GRect rect = new GRect(i * sqSize + offset, j * sqSize + offset, sqSize, sqSize);
					rect.setFilled(true);
					rect.setFillColor(Color.gray);
					add(rect);
				}

			}
		}
		// left side labels
		for (int i = 0; i < boardSize; i++) {
			GLabel label = new GLabel(Integer.toString(8 - i));
			label.setLocation(offset - 20, i * sqSize + offset + sqSize / 2 - label.getY() / 2);
			add(label);
		}
		// right side labels
		for (int i = 0; i < boardSize; i++) {
			GLabel label = new GLabel(Integer.toString(8 - i));
			label.setLocation(offset + 20 + boardSize * sqSize, i * sqSize + offset + sqSize / 2 - label.getY() / 2);
			add(label);
		}
		// upper side labels
		for (int i = 0; i < boardSize; i++) {
			GLabel label = new GLabel(Character.toString((char) (65 + i)));
			label.setLocation(i * sqSize + offset + sqSize / 2 - label.getX() / 2, offset / 2);
			add(label);
		}
		// lower side labels
		for (int i = 0; i < boardSize; i++) {
			GLabel label = new GLabel(Character.toString((char) (65 + i)));
			label.setLocation(i * sqSize + offset + sqSize / 2 - label.getX() / 2, offset + 20 + boardSize * sqSize);
			add(label);
		}
	}
}
