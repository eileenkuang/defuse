//Authors: Eileen Kuang & Lillian Li
//Date: January 22, 2024
//Title: 7 Minute Meltdown (KeyHole class)
//Description: Is used to create the key hole that allows the user to win

import java.awt.*;
import javax.swing.*;

public class KeyHole extends Rectangle {

	// the key
	public ImageIcon keyIcon;
	public Image keyImage;

	// hole size
	public static final int HOLE_WIDTH = 328 / 6;
	public static final int HOLE_HEIGHT = 445 / 6;

	// Constructor
	public KeyHole() {
		super(0, 0, HOLE_WIDTH, HOLE_HEIGHT);
		keyIcon = new ImageIcon("keyhole.png");
		keyImage = keyIcon.getImage();
	}

	// Draws to the screen
	public void draw(Graphics g) {
		g.drawImage(keyImage, x, y, HOLE_WIDTH, HOLE_HEIGHT, null);
	}

}// end of KeyHole class
