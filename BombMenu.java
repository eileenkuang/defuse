import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BombMenu extends Rectangle {

	// hovers
	public boolean hoverCrypto = false;
	public boolean hoverKey = false;
	public boolean hoverLing = false;
	public boolean hoverRhythmic = false;

	public boolean hoverDefuse = false;

	// how many puzzles are solved
	public static boolean solveCrypto = true;
	public static boolean solveKey = true;
	public static boolean solveRhythmic = true;
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

	public BombMenu() {
		super();

		// background
		backgroundIcon = new ImageIcon("bombmenubackground.jpg");
		backgroundImage = backgroundIcon.getImage();
	}

	public void draw(Graphics g) {
		g.drawImage(backgroundImage, 0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null); // draw background
		crypto.draw(g, hoverCrypto, solveCrypto);
		key.draw(g, hoverKey, solveKey);
		ling.draw(g, hoverLing, solveLing);
		rhythmic.draw(g, hoverRhythmic, solveRhythmic);
		defuseButton.draw(g, hoverDefuse);
		timerBox.draw(g,false);
	}// end of draw method

	public void move() {

	}// end of move method

	public void keyPressed(KeyEvent e) {

	}// end of keyPressed method

	public void keyReleased(KeyEvent e) {

	}// end of keyReleased method

	public void keyTyped(KeyEvent e) {

	}// end of keyTyped method

	public void mouseEntered(MouseEvent e) {

	}// end of mouseEntered method

	public void mouseExited(MouseEvent e) {

	}// end of mouseExited method

	public void mouseClicked(MouseEvent e) {

	}// end of mouseClicked method

	public void mouseReleased(MouseEvent e) {

	}// end of mouseReleased method

	public void mousePressed(MouseEvent e) {

	}// end of mousePressed method

	public void mouseMoved(MouseEvent e) {
		if (crypto.intersects(e.getX(), e.getY(), 1, 1) && !timerBox.intersects(e.getX(), e.getY(), 1, 1))
			hoverCrypto = true;
		else
			hoverCrypto = false;
		if (key.intersects(e.getX(), e.getY(), 1, 1) && !timerBox.intersects(e.getX(), e.getY(), 1, 1))
			hoverKey = true;
		else
			hoverKey = false;
		if (ling.intersects(e.getX(), e.getY(), 1, 1) && !hoverDefuse)
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
	}

}
