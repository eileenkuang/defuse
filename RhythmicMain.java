//Authors: Eileen Kuang & Lillian Li
//Date: January 11, 2024
//Title: 7 Minute Meltdown (RhythmicMain class)
//Description: Class for the Rhythmic Recall mini game!

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class RhythmicMain {

	// Variable declarations

	// dimensions
	public final int BACKGROUND_WIDTH = GamePanel.GAME_WIDTH;
	public final int BACKGROUND_HEIGHT = GamePanel.GAME_HEIGHT;

	// background images
	public ImageIcon backgroundIcon = new ImageIcon("rhythmicbackground.png");
	public Image backgroundImage = backgroundIcon.getImage();

	// buttons
	public RhythmicLight yellow;
	public RhythmicLight red;
	public RhythmicLight blue;
	public RhythmicLight green;

	// checks
	public boolean seqOrNot;
	public boolean flash = false;

	// sequence variables
	int[] sequence1 = new int[12];

	// constructor, set up location of all buttons
	public RhythmicMain() {

		yellow = new RhythmicLight(250, 100, "yellowlight.png", "yellowdark.png");
		red = new RhythmicLight(250, 360, "redlight.png", "reddark.png");
		green = new RhythmicLight(510, 100, "greenlight.png", "greendark.png");
		blue = new RhythmicLight(510, 360, "bluelight.png", "bluedark.png");

	}

	// draws all images
	public void draw(Graphics g) {

		g.drawImage(backgroundImage, 0, 0, GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT, null); // draw background
		yellow.draw(g, flash);
		red.draw(g, flash);
		green.draw(g, flash);
		blue.draw(g, flash);

	}// end of draw method

	// generates randomized sequence for lights
	public void generateSequence() {

	}

	// will detect when and where mouse clicks to detect user sequence
	public void mouseClicked(MouseEvent e) {

	}// end of mouseClicked method

	// moves any moving graphics
	public void move() {

	}// end of move method

	// detects key presses
	public void keyPressed(KeyEvent e) {

	}// end of keyPressed method

	// detects key releases
	public void keyReleased(KeyEvent e) {

	}// end of keyReleased method

	// detects keys being typed
	public void keyTyped(KeyEvent e) {

	}// end of keyTyped method

	// detects the mouse entering the screen
	public void mouseEntered(MouseEvent e) {

	}// end of mouseEntered method

	// detects the mouse exiting the screen
	public void mouseExited(MouseEvent e) {

	}// end of mouseExited method

	// detects the mouse being released
	public void mouseReleased(MouseEvent e) {

	}// end of mouseReleased method

	// detects the mouse being pressed
	public void mousePressed(MouseEvent e) {

	}// end of mousePressed method

}