//Authors: Eileen Kuang & Lillian Li
//Date: January 11, 2024
//Title: 7 Minute Meltdown (CryptoKeyboard class)
//Description: Class to create symbol keyboard on the screen during the CryptoCipher puzzle

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CryptoKeyboard extends Rectangle{

	//each key
	public ImageIcon keyIcon;
	public Image keyImage;
	public static final int KEY_WIDTH = (int)(236 / 2.5);
	public static final int KEY_HEIGHT = (int)(223 / 2.5);

	//Constructor
	public CryptoKeyboard(int x, int y, String fileName) {
		super(x,y,KEY_WIDTH,KEY_HEIGHT);
		//the key image
		keyIcon = new ImageIcon(fileName);
		keyImage = keyIcon.getImage();
	}

	//Draws to the screen
	public void draw(Graphics g) {
		g.drawImage(keyImage, x, y, KEY_WIDTH, KEY_HEIGHT, null);
	}// end of draw method

}//end of CryptoKeyboard class
