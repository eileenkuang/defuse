//Authors: Eileen Kuang & Lillian Li
//Date: January 22, 2024
//Title: 7 Minute Meltdown (CryptoKeyboard class)
//Description: Class to create symbol keyboard on the screen during the CryptoCipher puzzle

import java.awt.*;
import javax.swing.*;

public class CryptoKeyboard extends Rectangle {

	// each key
	public ImageIcon keyIconUnclicked;
	public Image keyImageUnclicked;
	public ImageIcon keyIconClicked;
	public Image keyImageClicked;
	public static final int KEY_WIDTH = (int) (236 / 2.5);
	public static final int KEY_HEIGHT = (int) (223 / 2.5);

	// Constructor
	public CryptoKeyboard(int x, int y, String unclickFile, String hoverFile) {
		super(x, y, KEY_WIDTH, KEY_HEIGHT);
		// the key image
		keyIconUnclicked = new ImageIcon(unclickFile);
		keyImageUnclicked = keyIconUnclicked.getImage();
		keyIconClicked = new ImageIcon(hoverFile);
		keyImageClicked = keyIconClicked.getImage();
	}

	// Draws to the screen
	public void draw(Graphics g, boolean hovering) {
		if(hovering) //if the key is being hovered over
			g.drawImage(keyImageClicked, x, y, KEY_WIDTH, KEY_HEIGHT, null);
		else
			g.drawImage(keyImageUnclicked, x, y, KEY_WIDTH, KEY_HEIGHT, null);
	}// end of draw method

}// end of CryptoKeyboard class
