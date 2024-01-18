//Authors: Eileen Kuang & Lillian Li
//Date: January 18, 2024
//Title: 7 Minute Meltdown (InstructionsButton class)
//Description: Class for the button to display instructions on main menu

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InstructionsButton extends Rectangle {

	// variable declarations
	public ImageIcon ins = new ImageIcon("rulesbutton.png");
	public Image insImage = ins.getImage();
	public ImageIcon hover = new ImageIcon("ruleshover.png");
	public Image hoverImage = hover.getImage();

	// button size
	public static final int BUTTON_WIDTH = 250;
	public static final int BUTTON_HEIGHT = 100;

	// constructor; creates rectangle
	public InstructionsButton(int x, int y) {

		super(x, y, BUTTON_WIDTH, BUTTON_HEIGHT);

	}

	// draws proper picture to screen (draws a darker picture when hovered)
	public void draw(Graphics g, boolean hovered) {

		if (GamePanel.onlyShowMainMenu) {

			if (hovered) {
				g.drawImage(hoverImage, x, y, BUTTON_WIDTH, BUTTON_HEIGHT, null);
			} else {
				g.drawImage(insImage, x, y, BUTTON_WIDTH, BUTTON_HEIGHT, null);
			}

		}
	}

}// end of InstructionsButton class