//Authors: Eileen Kuang & Lillian Li
//Date: January 22, 2024
//Title: 7 Minute Meltdown (GeneralButton class)
//Description: Is used to create buttons/graphics that don't fall into any of the other button classes

import java.awt.*;

public class GeneralButton extends Rectangle {

	// Variable declarations
	public Image unclicked;
	public Image hovered;
	public int buttonWidth;
	public int buttonHeight;
	public int xCoord;
	public int yCoord;

	// Constructor that creates a button that can be clicked
	public GeneralButton(int x, int y, int width, int height, Image unclick, Image hover) {
		super(x, y, width, height);
		unclicked = unclick;
		hovered = hover;
		buttonWidth = width;
		buttonHeight = height;
		xCoord = x;
		yCoord = y;
	}

	// Constructor that creates a Rectangle object that cannot be clicked
	public GeneralButton(int x, int y, int width, int height, Image img) {
		super(x, y, width, height);
		unclicked = img;
		xCoord = x;
		yCoord = y;
		buttonWidth = width;
		buttonHeight = height;
	}

	// Draws to the screen
	public void draw(Graphics g, boolean hovering) {
		if (hovering) { //if the button is being hovered over
			g.drawImage(hovered, xCoord, yCoord, buttonWidth, buttonHeight, null);
		} else {
			g.drawImage(unclicked, xCoord, yCoord, buttonWidth, buttonHeight, null);
		}

	}

}// end of GeneralButton class
