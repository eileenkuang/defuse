//Authors: Eileen Kuang & Lillian Li
//Date: January 11, 2024
//Title: 7 Minute Meltdown (RhythmicLight class)
//Description: Class for all buttons for the Rhythmic Recall mini game

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RhythmicLight extends Rectangle {

	// variable declarations
	public static final int BUTTON_WIDTH = 250;
	public static final int BUTTON_HEIGHT = 250;
	public ImageIcon lightIcon;
	public Image lightImage;
	public ImageIcon darkIcon;
	public Image darkImage;

	// Constructor
	public RhythmicLight(int x, int y, String light, String dark) {

		super(x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
		lightIcon = new ImageIcon(light);
		lightImage = lightIcon.getImage();
		darkIcon = new ImageIcon(dark);
		darkImage = darkIcon.getImage();

	}

	// Draws to the screen
	public void draw(Graphics g, boolean isDark) {

		if (GamePanel.onlyShowRhythmic) { // if the Rhythmic Recall puzzle is being played

			if (isDark) {
				g.drawImage(lightImage, x, y, BUTTON_WIDTH, BUTTON_HEIGHT, null);
			} else {
				g.drawImage(darkImage, x, y, BUTTON_WIDTH, BUTTON_HEIGHT, null);
			}

		}

	}
}// end of RhythmicLight class