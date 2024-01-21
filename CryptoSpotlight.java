//Authors: Eileen Kuang & Lillian Li
//Date: January 22, 2024
//Title: 7 Minute Meltdown (CryptoSpotlight class)
//Description: Class to create yellow boxes that let the user know which box their "cursor" is on

import java.awt.*;

public class CryptoSpotlight extends Rectangle {

	// Colors
	public Color yellow = new Color(225, 248, 143, 150);
	public Color transparent = new Color(0, 0, 0, 0);

	// Constructor
	public CryptoSpotlight(int x, int y) {
		super(x, y, 80, 70);
	}

	// Draws to the screen
	public void draw(Graphics g, int spotlightNum) {

		// yellow rectangle if that's where the cursor is
		if (CryptoMain.cursorLocation == spotlightNum)
			g.setColor(yellow);
		else
			g.setColor(transparent);
		g.fillRect(x, y, 80, 70);

	}// end of draw method

}// end of CryptoSpotlight class
