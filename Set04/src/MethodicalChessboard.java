import java.awt.Color;

import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class MethodicalChessboard extends GraphicsProgram {

	int sqSize = 50;
	int offset = 50;

	public void run() {
		drawChessboard();

		// rooks
		drawPiece(0, 7, 3, 0);
		drawPiece(7, 7, 3, 0);
		drawPiece(0, 0, 3, 1);
		drawPiece(7, 0, 3, 1);

		// knights
		drawPiece(1, 7, 1, 0);
		drawPiece(6, 7, 1, 0);
		drawPiece(1, 0, 1, 1);
		drawPiece(6, 0, 1, 1);

		// bishops
		drawPiece(2, 7, 2, 0);
		drawPiece(5, 7, 2, 0);
		drawPiece(2, 0, 2, 1);
		drawPiece(5, 0, 2, 1);

		// queens
		drawPiece(3, 7, 4, 0);
		drawPiece(3, 0, 4, 1);

		// kings
		drawPiece(4, 7, 5, 0);
		drawPiece(4, 0, 5, 1);

		// pawns
		for (int i = 0; i < 8; i++) {
			drawPiece(i, 6, 0, 0);
		}
		for (int i = 0; i < 8; i++) {
			drawPiece(i, 1, 0, 1);
		}

	}

	public void drawChessboard() {
		int boardSize = 8;
		// drawing board
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				// only draw black squares
				if ((i + j) % 2 == 1) {
					drawSquare(i, j, Color.gray);
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

	/**
	 * Draws the square identified by {@code x} and {@code y} in the color
	 * {@code color}.
	 * 
	 * @param x
	 *            file index, between 0 and 7.
	 * @param y
	 *            rank index, between 0 and 7.
	 * @param color
	 *            the color to fill the square with.
	 */
	public void drawSquare(int x, int y, Color color) {
		GRect rect = new GRect(x * sqSize + offset, y * sqSize + offset, sqSize, sqSize);
		rect.setFilled(true);
		rect.setFillColor(color);
		add(rect);
	}

	/**
	 * Draws a specific chess {@code piece} of a {@code player} at the position of a
	 * specific square identified by {@code x} and {@code y}. Pieces are: 0 pawn, 1
	 * Knight, 2 Bishop, 3 Rook, 4 Queen, 5 King
	 * 
	 * @param x
	 *            file index, between 0 and 7.
	 * @param y
	 *            rank index, between 0 and 7.
	 * @param piece
	 *            0 for a pawn, 1 for a knight, 2 for a bishop, 3 for a rook, 4 for
	 *            a queen, 5 for a king.
	 * @param player
	 *            0 for white, 1 for black.
	 */
	public void drawPiece(int x, int y, int piece, int player) {
		String pieceStr = "";
		if (player == 0) {
			switch (piece) {
			case 0:
				pieceStr = "\u2659";
				break;
			case 1:
				pieceStr = "\u2658";

				break;
			case 2:
				pieceStr = "\u2657";

				break;
			case 3:
				pieceStr = "\u2656";

				break;
			case 4:
				pieceStr = "\u2655";

				break;
			case 5:
				pieceStr = "\u2654";

				break;

			default:
				break;
			}
		} else {
			switch (piece) {
			case 0:
				pieceStr = "\u265F";
				break;
			case 1:
				pieceStr = "\u265E";

				break;
			case 2:
				pieceStr = "\u265D";

				break;
			case 3:
				pieceStr = "\u265C";

				break;
			case 4:
				pieceStr = "\u265B";

				break;
			case 5:
				pieceStr = "\u265A";

				break;

			default:
				break;
			}
		}
		GLabel pieceLabel = new GLabel(pieceStr);
		pieceLabel.setFont("SansSerif-44");
		pieceLabel.setLocation(x * sqSize + offset + (sqSize - pieceLabel.getWidth()) / 2,
				y * sqSize + offset * 2 - (sqSize - pieceLabel.getWidth()) / 2);
		add(pieceLabel);

	}
}
