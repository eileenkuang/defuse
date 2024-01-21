//Authors: Eileen Kuang & Lillian Li
//Date: January 22, 2024
//Title: 7 Minute Meltdown (KeyMenus class)
//Description: Is used to create the win menu for the KeyQuest Odyssey puzzle

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

public class KeyMenus extends Rectangle {

	// Variables
	public ImageIcon hintIcon = new ImageIcon("keyHintReveal.png");
	public Image hintImage = hintIcon.getImage();

	// end screen image
	public ImageIcon endIcon = new ImageIcon("keyendscreen.png");
	public Image endImage = endIcon.getImage();

	// end screen button
	public ImageIcon backUnclickedIcon = new ImageIcon("endscreenbackunclicked.png");
	public Image backUnclickedImage = backUnclickedIcon.getImage();
	public ImageIcon backHoveredIcon = new ImageIcon("endscreenbackhovered.png");
	public Image backHoveredImage = backHoveredIcon.getImage();
	public GeneralButton backButton = new GeneralButton(380, 540, (int) (433 / 2), (int) (166 / 2), backUnclickedImage,
			backHoveredImage);
	public boolean backHover = false;

	// Constructor
	public KeyMenus() {
		super(0, 0, GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT);
	}

	// Draws to the screen
	public void draw(Graphics g) {
		if (BombMenu.solveKey) {
			g.setColor(new Color(64, 64, 64, 220)); // make it partially transparent
			g.fillRect(0, 0, GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT);
			g.drawImage(endImage, 10, 40, (int) (666 * 1.45), (int) (375 * 1.45), null);
			g.drawImage(BombMenu.codeImage(BombMenu.codeInt2), 430, 395, (int) (200 / 1.75), (int) (217 / 1.75), null);
			backButton.draw(g, backHover);
		}
		if (KeyMain.showHint) {
			g.drawImage(hintImage, 15, 70, (int) (925 / 5), (int) (161 / 5), null);
		}

	}

	// Detects mouse clicks
	public void mouseClicked(MouseEvent e) {
		if (BombMenu.solveKey) {
			if (backButton.intersects(e.getX(), e.getY(), 1, 1)) { //back button is clicked
				GamePanel.onlyShowKey = false;
				GamePanel.onlyShowBombMenu = true;
				backHover = false;
			}
		}
	}

	// Detects mouse movement/hovering
	public void mouseMoved(MouseEvent e) {
		if (BombMenu.solveKey) {
			if (backButton.intersects(e.getX(), e.getY(), 1, 1)) { //back button is hovered over
				backHover = true;
			} else {
				backHover = false;
			}
		}
	}

} // end of KeyMenus class
