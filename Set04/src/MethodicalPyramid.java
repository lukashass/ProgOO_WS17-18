import java.awt.Color;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class MethodicalPyramid extends GraphicsProgram {
	public void run() {
		int numberOfLayers = 4;
		for (int i = 0; i < numberOfLayers; i++) {
			drawLayer(i, numberOfLayers, layerColor(i, numberOfLayers));
		}
		layerColor(6, 6);
	}

	/**
	 * Returns the color to be used for bricks in the given layer.
	 * 
	 * @param layerIndex
	 *            index of the layer whose color to return. {@code 0} is the bottom
	 *            layer, {@code numberOfLayers - 1} is the top layer.
	 * @param numberOfLayers
	 *            the number of layers in the pyramid.
	 * @return the color to be used for the given layer, or {@code null} if
	 *         {@code layerIndex} is invalid.
	 */
	public Color layerColor(int layerIndex, int numberOfLayers) {
		if (layerIndex < 0 || layerIndex >= numberOfLayers) {
			return null;
		}
		double grade;
		if (numberOfLayers == 1) {
			grade = 0;
		} else {
			grade = (220.0 / (numberOfLayers - 1.0)) * layerIndex;
		}
		return new Color(255, (int) grade, (int) grade);
	}

	/**
	 * Draws the given layer with bricks filled with the given color. If
	 * {@code layerIndex} is invalid, no bricks at all should be drawn.
	 * 
	 * @param layerIndex
	 *            index of the layer to draw. {@code 0} is the bottom layer,
	 *            {@code numberOfLayers - 1} is the top layer.
	 * @param numberOfLayers
	 *            the number of layers in the pyramid.
	 * @param layerColor
	 *            color the layer's bricks should be filled with.
	 */
	public void drawLayer(int layerIndex, int numberOfLayers, Color layerColor) {
		if (layerIndex >= 0) {
			int brickX = 50;
			int brickY = 20;
			int y = numberOfLayers * brickY - layerIndex * brickY + 50;
			for (int i = 0; i < numberOfLayers - layerIndex; i++) {
				int x = layerIndex * brickX / 2 + i * brickX + 50;
				GRect brick = new GRect(x, y, brickX, brickY);
				brick.setFilled(true);
				brick.setFillColor(layerColor);
				add(brick);
			}
		}
	}
}
