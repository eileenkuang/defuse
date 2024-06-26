//Authors: Eileen Kuang & Lillian Li
//Date: January 22, 2024
//Title: 7 Minute Meltdown (QuitButton class)
//Description: Is used to create buttons that allow the user to quit the game

import java.awt.*;
import javax.swing.*;

public class QuitButton extends Rectangle {

	// variables
	public ImageIcon quitUnclickedIcon = new ImageIcon("quitunclicked.png");
	public Image quitUnclickedImage = quitUnclickedIcon.getImage();
	public ImageIcon quitHoveredIcon = new ImageIcon("quithovered.png");
	public Image quitHoveredImage = quitHoveredIcon.getImage();
	public static final int QUIT_WIDTH = 418 / 3;
	public static final int QUIT_HEIGHT = 151 / 3;

	// Constructor
	public QuitButton() {
		super(10, 640, QUIT_WIDTH, QUIT_HEIGHT);
	}

	// Draws to the screen
	public void draw(Graphics g) {
		if (KeyMain.hoverQuit || CryptoMain.hoverQuit || MagicMain.hoverQuit || RhythmicMain.hoverQuit) {
			g.drawImage(quitHoveredImage, x, y, QUIT_WIDTH, QUIT_HEIGHT, null);
		} else {
			g.drawImage(quitUnclickedImage, x, y, QUIT_WIDTH, QUIT_HEIGHT, null);
		}

	}

}// end of QuitButton class
