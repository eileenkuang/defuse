//Authors: Eileen Kuang & Lillian Li
//Date: January 18, 2024
//Title: 7 Minute Meltdown (HintButton class)
//Description: Is used to create buttons that reveal hints

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HintButton extends Rectangle {

	// variables
	public ImageIcon hintUnclickedIcon = new ImageIcon("hintunclicked.png");
	public Image hintUnclickedImage = hintUnclickedIcon.getImage();
	public ImageIcon hintHoveredIcon = new ImageIcon("hinthovered.png");
	public Image hintHoveredImage = hintHoveredIcon.getImage();
	public ImageIcon hintUsedIcon = new ImageIcon("hintused.png");
	public Image hintUsedImage = hintUsedIcon.getImage();
	public static final int HINT_WIDTH = 418 / 3;
	public static final int HINT_HEIGHT = 151 / 3;

	// Constructor
	public HintButton() {
		super(10, 10, HINT_WIDTH, HINT_HEIGHT);
	}

	// Draws to the screen
	public void draw(Graphics g, boolean hintUsed) {
		if (hintUsed) { // if the hint has been used
			g.drawImage(hintUsedImage, x, y, HINT_WIDTH, HINT_HEIGHT, null);
		} else if (KeyMain.hoverHint || CryptoMain.hoverHint || MagicMain.hoverHint) { // if the hint button is being hovered
			g.drawImage(hintHoveredImage, x, y, HINT_WIDTH, HINT_HEIGHT, null);
		} else {
			g.drawImage(hintUnclickedImage, x, y, HINT_WIDTH, HINT_HEIGHT, null);
		}
	}

}// end of HintButton class