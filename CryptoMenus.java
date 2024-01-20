//Authors: Eileen Kuang & Lillian Li
//Date: January 18, 2024
//Title: 7 Minute Meltdown (CryptoMenus class)
//Description: Class that runs the menu shown after the user has won CryptoCipher

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class CryptoMenus extends Rectangle {

	// hint images
	public ImageIcon hint1Icon = new ImageIcon("phrase1hint.png");
	public Image hint1Image = hint1Icon.getImage();
	public ImageIcon hint2Icon = new ImageIcon("phrase2hint.png");
	public Image hint2Image = hint2Icon.getImage();
	public ImageIcon hint3Icon = new ImageIcon("phrase3hint.png");
	public Image hint3Image = hint3Icon.getImage();

	// end screen image
	public ImageIcon endIcon = new ImageIcon("cryptoendscreen.png");
	public Image endImage = endIcon.getImage();

	// end screen button
	public ImageIcon backUnclickedIcon = new ImageIcon("endscreenbackunclicked.png");
	public Image backUnclickedImage = backUnclickedIcon.getImage();
	public ImageIcon backHoveredIcon = new ImageIcon("endscreenbackhovered.png");
	public Image backHoveredImage = backHoveredIcon.getImage();
	public GeneralButton backButton = new GeneralButton(380, 540, (int)(433/2), (int)(166/2), backUnclickedImage, backHoveredImage);
	public boolean backHover = false;

	// Constructor
	public CryptoMenus() {
		super(0, 0, GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT);
	}

	// Draws to the screen
	public void draw(Graphics g) {
		//draw end screen for CryptoCipher
		if (BombMenu.solveCrypto) {
			g.setColor(new Color(64, 64, 64, 220)); // make it partially transparent
			g.fillRect(0, 0, GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT);
			g.drawImage(endImage, 10, 40, (int) (666 * 1.45), (int) (375 * 1.45), null);
			g.drawImage(BombMenu.codeImage(BombMenu.codeInt1), 430, 395, (int) (200/1.75), (int) (217/1.75), null);
			backButton.draw(g, backHover);
		}
		//draw hint for CryptoCipher depending on the phrase being used
		if (CryptoMain.showHint) {
			if (CryptoMain.phrase == 1) {
				g.drawImage(hint1Image, 15, 70, (int) (395 / 5), (int) (306 / 5), null);
			} else if (CryptoMain.phrase == 2) {
				g.drawImage(hint2Image, 15, 70, (int) (399 / 5), (int) (308 / 5), null);
			} else if (CryptoMain.phrase == 3) {
				g.drawImage(hint3Image, 15, 70, (int) (378 / 5), (int) (300 / 5), null);
			}
		}
	}

	//Detects mouse clicks
	public void mouseClicked(MouseEvent e) {
		if (BombMenu.solveCrypto) {
			if (backButton.intersects(e.getX(), e.getY(), 1, 1)) { //back button
				GamePanel.onlyShowCrypto = false;
				GamePanel.onlyShowBombMenu = true;
				backHover=false;
			}
		}
	}

	//Detects when the mouse moves/hovers
	public void mouseMoved(MouseEvent e) {
		if (BombMenu.solveCrypto) {
			if (backButton.intersects(e.getX(), e.getY(), 1, 1)) { //back button
				backHover=true;
			}
			else {
				backHover=false;
			}
		}
	}

}
