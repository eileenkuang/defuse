//Authors: Eileen Kuang & Lillian Li
//Date: January 18, 2024
//Title: 7 Minute Meltdown (PlayButton class)
//Description: Class for the button to begin the game on main menu

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PlayButton extends Rectangle {

	// variable declarations
	public ImageIcon play = new ImageIcon("playbutton.png");
	public Image playImage = play.getImage();
	public ImageIcon hover = new ImageIcon("playhover.png");
	public Image hoverImage = hover.getImage();
	public static final int BUTTON_WIDTH = 250;
	public static final int BUTTON_HEIGHT = 100;

	// constructor; creates rectangle
	public PlayButton(int x, int y) {

		super(x, y, BUTTON_WIDTH, BUTTON_HEIGHT);

	}

	// draws proper picture to screen (draws a darker picture when hovered)
	public void draw(Graphics g, boolean hovered) {

		if (GamePanel.onlyShowMainMenu) {

			if (hovered) {
				g.drawImage(hoverImage, x, y, BUTTON_WIDTH, BUTTON_HEIGHT, null);
			} else {
				g.drawImage(playImage, x, y, BUTTON_WIDTH, BUTTON_HEIGHT, null);
			}

		}

	}
}// end of Playbutton class