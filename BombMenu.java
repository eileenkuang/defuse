//Authors: Eileen Kuang & Lillian Li
//Date: January 11, 2024
//Title: 7 Minute Meltdown (BombMenu class)
//Description: Class to make Bomb Menu

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BombMenu extends Rectangle {

	// hover variables
	public boolean hoverCrypto = false;
	public boolean hoverKey = false;
	public boolean hoverLing = false;
	public boolean hoverRhythmic = false;

	public boolean hoverDefuse = false;
	public boolean hoverGiveUp = false;

	// how many puzzles are solved
	public static boolean solveCrypto = false;
	public static boolean solveKey = false;
	public static boolean solveRhythmic = false;
	public static boolean solveLing = false;

	// the background
	public ImageIcon backgroundIcon;
	public Image backgroundImage;
	public final int BACKGROUND_WIDTH = GamePanel.GAME_WIDTH;
	public final int BACKGROUND_HEIGHT = GamePanel.GAME_HEIGHT;

	// timer box
	public ImageIcon timerIcon = new ImageIcon("timerbox.png");
	public Image timerImage = timerIcon.getImage();
	public GeneralButton timerBox = new GeneralButton(250, 200, (int) (742 / 1.5), (int) (336 / 1.5), timerImage);

	// defuse button
	public ImageIcon defuseUnclickedIcon = new ImageIcon("defusebutton.png");
	public Image defuseUnclickedImage = defuseUnclickedIcon.getImage();
	public ImageIcon defuseHoveredIcon = new ImageIcon("defusebuttonclicked.png");
	public Image defuseHoveredImage = defuseHoveredIcon.getImage();
	public GeneralButton defuseButton = new GeneralButton(345, 440, (int) (658 / 2.2), (int) (230 / 2.2),
			defuseUnclickedImage, defuseHoveredImage);

	// give up button
	public ImageIcon giveUnclickedIcon = new ImageIcon("giveup.png");
	public Image giveUnclickedImage = giveUnclickedIcon.getImage();
	public ImageIcon giveHoveredIcon = new ImageIcon("giveupclicked.png");
	public Image giveHoveredImage = giveHoveredIcon.getImage();
	public GeneralButton giveUpButton = new GeneralButton(15, 620, (int) (669 / 3.5), (int) (232 / 3.5),
			giveUnclickedImage, giveHoveredImage);

	// cryptocipher button
	public ImageIcon cryptoUnclickedRedIcon = new ImageIcon("cryptobutton.png");
	public Image cryptoUnclickedRedImage = cryptoUnclickedRedIcon.getImage();
	public ImageIcon cryptoHoveredRedIcon = new ImageIcon("cryptobuttonclicked.png");
	public Image cryptoHoveredRedImage = cryptoHoveredRedIcon.getImage();

	public ImageIcon cryptoUnclickedGreenIcon = new ImageIcon("cryptobuttonsolved.png");
	public Image cryptoUnclickedGreenImage = cryptoUnclickedGreenIcon.getImage();
	public ImageIcon cryptoHoveredGreenIcon = new ImageIcon("cryptobuttonsolvedclicked.png");
	public Image cryptoHoveredGreenImage = cryptoHoveredGreenIcon.getImage();

	public BombButton crypto = new BombButton(30, 30, cryptoUnclickedRedImage, cryptoHoveredRedImage,
			cryptoUnclickedGreenImage, cryptoHoveredGreenImage);

	// keyquest button
	public ImageIcon keyUnclickedRedIcon = new ImageIcon("keybutton.png");
	public Image keyUnclickedRedImage = keyUnclickedRedIcon.getImage();
	public ImageIcon keyHoveredRedIcon = new ImageIcon("keybuttonclicked.png");
	public Image keyHoveredRedImage = keyHoveredRedIcon.getImage();

	public ImageIcon keyUnclickedGreenIcon = new ImageIcon("keybuttonsolved.png");
	public Image keyUnclickedGreenImage = keyUnclickedGreenIcon.getImage();
	public ImageIcon keyHoveredGreenIcon = new ImageIcon("keybuttonsolvedclicked.png");
	public Image keyHoveredGreenImage = keyHoveredGreenIcon.getImage();

	public BombButton key = new BombButton(630, 30, keyUnclickedRedImage, keyHoveredRedImage, keyUnclickedGreenImage,
			keyHoveredGreenImage);

	// linguistic button
	public ImageIcon lingUnclickedRedIcon = new ImageIcon("labyrinthbutton.png");
	public Image lingUnclickedRedImage = lingUnclickedRedIcon.getImage();
	public ImageIcon lingHoveredRedIcon = new ImageIcon("labyrinthbuttonclicked.png");
	public Image lingHoveredRedImage = lingHoveredRedIcon.getImage();

	public ImageIcon lingUnclickedGreenIcon = new ImageIcon("labyrinthbuttonsolved.png");
	public Image lingUnclickedGreenImage = lingUnclickedGreenIcon.getImage();
	public ImageIcon lingHoveredGreenIcon = new ImageIcon("labyrinthbuttonsolvedclicked.png");
	public Image lingHoveredGreenImage = lingHoveredGreenIcon.getImage();

	public BombButton ling = new BombButton(30, 420, lingUnclickedRedImage, lingHoveredRedImage,
			lingUnclickedGreenImage, lingHoveredGreenImage);

	// rhythmic button
	public ImageIcon rhythmicUnclickedRedIcon = new ImageIcon("rhythmicbutton.png");
	public Image rhythmicUnclickedRedImage = rhythmicUnclickedRedIcon.getImage();
	public ImageIcon rhythmicHoveredRedIcon = new ImageIcon("rhythmicbuttonclicked.png");
	public Image rhythmicHoveredRedImage = rhythmicHoveredRedIcon.getImage();

	public ImageIcon rhythmicUnclickedGreenIcon = new ImageIcon("rhythmicbutton.png");
	public Image rhythmicUnclickedGreenImage = rhythmicUnclickedGreenIcon.getImage();
	public ImageIcon rhythmicHoveredGreenIcon = new ImageIcon("rhythmicbuttonclicked.png");
	public Image rhythmicHoveredGreenImage = rhythmicHoveredGreenIcon.getImage();

	public BombButton rhythmic = new BombButton(630, 420, rhythmicUnclickedRedImage, rhythmicHoveredRedImage,
			rhythmicUnclickedGreenImage, rhythmicHoveredGreenImage);

	// Constructor
	public BombMenu() {
		super();

		// background
		backgroundIcon = new ImageIcon("bombmenubackground.jpg");
		backgroundImage = backgroundIcon.getImage();
	}

	// Draws to the screen
	public void draw(Graphics g) {
		g.drawImage(backgroundImage, 0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null); // draw background
		crypto.draw(g, hoverCrypto, solveCrypto);
		key.draw(g, hoverKey, solveKey);
		ling.draw(g, hoverLing, solveLing);
		rhythmic.draw(g, hoverRhythmic, solveRhythmic);
		defuseButton.draw(g, hoverDefuse);
		giveUpButton.draw(g, hoverGiveUp);
		timerBox.draw(g, false);
	}// end of draw method

	// For moving graphics
	public void move() {

	}// end of move method

	// Detects when keys are pressed
	public void keyPressed(KeyEvent e) {

	}// end of keyPressed method

	// Detects when keys are released
	public void keyReleased(KeyEvent e) {

	}// end of keyReleased method

	// Detects when keys are typed
	public void keyTyped(KeyEvent e) {

	}// end of keyTyped method

	// Detects the mouse entering the screen
	public void mouseEntered(MouseEvent e) {

	}// end of mouseEntered method

	// Detects the mouse exiting the screen
	public void mouseExited(MouseEvent e) {

	}// end of mouseExited method

	// Detects the mouse clicking the screen
	public void mouseClicked(MouseEvent e) {
		// checks for the buttons being pressed on the Bomb Menu and sets the variables
		// to false/true to edit what is being shown on the screen
		if (crypto.intersects(e.getX(), e.getY(), 1, 1) && !timerBox.intersects(e.getX(), e.getY(), 1, 1)) {
			GamePanel.onlyShowBombMenu = false;
			GamePanel.onlyShowCrypto = true;
			hoverCrypto = false;
		}
		if (key.intersects(e.getX(), e.getY(), 1, 1) && !timerBox.intersects(e.getX(), e.getY(), 1, 1)) {
			GamePanel.onlyShowBombMenu = false;
			GamePanel.onlyShowKey = true;
			hoverKey = false;
		}
		if (ling.intersects(e.getX(), e.getY(), 1, 1) && !hoverDefuse && !hoverGiveUp) {
			GamePanel.onlyShowBombMenu = false;
			GamePanel.onlyShowLing = true;
			hoverLing = false;
		}
		if (rhythmic.intersects(e.getX(), e.getY(), 1, 1) && !hoverDefuse) {
			GamePanel.onlyShowBombMenu = false;
			GamePanel.onlyShowRhythmic = true;
			hoverRhythmic = false;
		}
		if (defuseButton.intersects(e.getX(), e.getY(), 1, 1)) {
			if (solveCrypto && solveKey && solveLing && solveRhythmic) {
				GamePanel.onlyShowBombMenu = false;
				GamePanel.onlyShowEndMenu = true;
			}
		}
		if (giveUpButton.intersects(e.getX(), e.getY(), 1, 1)) {
			GamePanel.onlyShowBombMenu = false;
			GamePanel.onlyShowEndMenu = true;
		}
	}// end of mouseClicked method

	// Detects the mouse being released
	public void mouseReleased(MouseEvent e) {

	}// end of mouseReleased method

	// Detects the mouse being pressed
	public void mousePressed(MouseEvent e) {

	}// end of mousePressed method

	// Detects the mouse being moved
	public void mouseMoved(MouseEvent e) {
		// checks for buttons being hovered over on the Bomb Menu and sets variables to
		// true/false depending on what should be shown on the screen
		if (crypto.intersects(e.getX(), e.getY(), 1, 1) && !timerBox.intersects(e.getX(), e.getY(), 1, 1))
			hoverCrypto = true;
		else
			hoverCrypto = false;
		if (key.intersects(e.getX(), e.getY(), 1, 1) && !timerBox.intersects(e.getX(), e.getY(), 1, 1))
			hoverKey = true;
		else
			hoverKey = false;
		if (ling.intersects(e.getX(), e.getY(), 1, 1) && !hoverDefuse && !hoverGiveUp)
			hoverLing = true;
		else
			hoverLing = false;
		if (rhythmic.intersects(e.getX(), e.getY(), 1, 1) && !hoverDefuse)
			hoverRhythmic = true;
		else
			hoverRhythmic = false;
		if (defuseButton.intersects(e.getX(), e.getY(), 1, 1))
			hoverDefuse = true;
		else
			hoverDefuse = false;
		if (giveUpButton.intersects(e.getX(), e.getY(), 1, 1))
			hoverGiveUp = true;
		else
			hoverGiveUp = false;
	}

}
