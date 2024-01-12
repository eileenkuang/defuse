//Authors: Eileen Kuang & Lillian Li
//Date: January 11, 2024
//Title: 7 Minute Meltdown (MainMenu class)
//Description: Class to display the main menu options for user

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class MainMenu {

	// Variable declarations

	// background
	public ImageIcon mainBackgroundIcon;
	public Image mainBackgroundImage;
	public PlayButton play;
	public InstructionsButton ins;
	public boolean playHover = false;
	public boolean insHover = false;

	// constructor; initializes images
	public MainMenu() {

		mainBackgroundIcon = new ImageIcon("mainbackground.png");
		mainBackgroundImage = mainBackgroundIcon.getImage();
		play = new PlayButton(370, 300);
		ins = new InstructionsButton(370, 440);

	}

	// draw background, play button, instructions button to screen
	public void draw(Graphics g) {

		g.drawImage(mainBackgroundImage, 0, 0, GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT, null); // draw background
		play.draw(g, playHover);
		ins.draw(g, insHover);

	}// end of draw method

	// check when mouse is hovering over a button
	public void mouseMoved(MouseEvent e) {

		if (play.intersects(e.getX(), e.getY(), 1, 1)) {
			playHover = true;
		} else {
			playHover = false;
		}
		if (ins.intersects(e.getX(), e.getY(), 1, 1)) {
			insHover = true;
		} else
			insHover = false;

	}// end of mouseMoved method

	// check when mouse clicks a button & switches to the according page
	public void mouseClicked(MouseEvent e) {

		if (play.intersects(e.getX(), e.getY(), 1, 1)) {
			GamePanel.onlyShowMainMenu = false;
			GamePanel.onlyShowBombMenu = true;
		}
		if (ins.intersects(e.getX(), e.getY(), 1, 1)) {
			GamePanel.onlyShowMainMenu = false;
			// show instructions
		}

	}// end of mouseClicked method

}