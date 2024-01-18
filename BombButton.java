//Authors: Eileen Kuang & Lillian Li
//Date: January 18, 2024
//Title: 7 Minute Meltdown (BombButton class)
//Description: Class to make buttons on the Bomb Menu

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BombButton extends Rectangle {

	// width and height
	public static final int BUTTON_WIDTH = (int) (547 / 1.6);
	public static final int BUTTON_HEIGHT = (int) (392 / 1.6);

	// images
	public Image unclickedImageRed;
	public Image hoveredImageRed;
	public Image unclickedImageGreen;
	public Image hoveredImageGreen;

	// Constructor
	public BombButton(int x, int y, Image imageUnclickedRed, Image imageHoveredRed, Image imageUnclickedGreen,
			Image imageHoveredGreen) {
		super(x, y, BUTTON_WIDTH, BUTTON_HEIGHT);

		// images
		unclickedImageRed = imageUnclickedRed;
		hoveredImageRed = imageHoveredRed;
		unclickedImageGreen = imageUnclickedGreen;
		hoveredImageGreen = imageHoveredGreen;
	}

	// Draws to the screen
	public void draw(Graphics g, boolean hovered, boolean solved) {
		if (hovered) { // if the button is being hovered over
			if (solved) // if the puzzle has been solved
				g.drawImage(hoveredImageGreen, x, y, BUTTON_WIDTH, BUTTON_HEIGHT, null);
			else
				g.drawImage(hoveredImageRed, x, y, BUTTON_WIDTH, BUTTON_HEIGHT, null);
		} else { // if the button is not being hovered
			if (solved) // if the puzzle has been solved
				g.drawImage(unclickedImageGreen, x, y, BUTTON_WIDTH, BUTTON_HEIGHT, null);
			else
				g.drawImage(unclickedImageRed, x, y, BUTTON_WIDTH, BUTTON_HEIGHT, null);
		}

	}

}// end of BombButton class
