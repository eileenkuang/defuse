//Authors: Eileen Kuang & Lillian Li
//Date: January 22, 2024
//Title: 7 Minute Meltdown (EndMenu class)
//Description: Class to make end menus (changes based on if the user wins or loses)

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EndMenu {

	// Variables
	public static boolean lose = false;
	public static boolean win = false;
	public boolean mainMenuHover = false;
	public boolean playAgainHover = false;
	public boolean mainMusic = false;
	public boolean playMusic = false;

	// lose screen
	public ImageIcon loseIcon = new ImageIcon("fail.png");
	public Image fail = loseIcon.getImage();
	public ImageIcon winIcon = new ImageIcon("succeed.png");
	public Image succeed = winIcon.getImage();

	// play again button
	public ImageIcon icon1 = new ImageIcon("playagain.png");
	public Image playUnclicked = icon1.getImage();
	public ImageIcon icon2 = new ImageIcon("playagainhovered.png");
	public Image playHovered = icon2.getImage();
	public GeneralButton playAgain = new GeneralButton(200, 520, (int) (579 / 2), (int) (145 / 2), playUnclicked,
			playHovered);

	//return to main menu button
	public ImageIcon icon3 = new ImageIcon("mainmenubutton.png");
	public Image mainMenuUnclicked = icon3.getImage();
	public ImageIcon icon4 = new ImageIcon("mainmenubuttonhovered.png");
	public Image mainMenuHovered = icon4.getImage();
	public GeneralButton mainMenu = new GeneralButton(520, 520, (int) (578 / 2), (int) (145 / 2), mainMenuUnclicked,
			mainMenuHovered);

	// Constructor
	public EndMenu() {

	}

	// Draws to the screen
	public void draw(Graphics g) {
		if (win) { //if the user has won
			g.drawImage(succeed, 0, 0, GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT, null);
			win = false;
		} else { //if the user failed or gave up
			g.drawImage(fail, 0, 0, GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT, null);
			lose = false;
		}
		//draw buttons
		mainMenu.draw(g, mainMenuHover);
		playAgain.draw(g, playAgainHover);

	}// end of draw method

	// Detects the mouse clicking the screen
	public void mouseClicked(MouseEvent e) {
		if (playAgain.intersects(e.getX(), e.getY(), 1, 1)) { //if user clicks play again
			GamePanel.onlyShowBombMenu=true;
			GamePanel.onlyShowEndMenu=false;
			playAgainHover=false;
			GamePanel.stopMusic(); //stop the applause sound effect
			GamePanel.loopMusic(GamePanel.backgroundMusic);//start music again
		}
		if (mainMenu.intersects(e.getX(), e.getY(), 1, 1)) { //if user clicks main menu
			GamePanel.onlyShowMainMenu=true;
			GamePanel.onlyShowEndMenu=false;
			mainMenuHover=false;
			GamePanel.stopMusic(); //stop the applause sound effect
			GamePanel.loopMusic(GamePanel.backgroundMusic);//start music again
		}
	}// end of mouseClicked method

	public void mouseMoved(MouseEvent e) {
		if (playAgain.intersects(e.getX(), e.getY(), 1, 1)) { //if user hovers over play again
			playAgainHover=true;
			if(!playMusic) {
				GamePanel.soundEffect(GamePanel.hover);
				playMusic=true;
			}
		}
		else {
			playAgainHover=false;
			playMusic=false;
		}
		if (mainMenu.intersects(e.getX(), e.getY(), 1, 1)) { //if user hovers over main menu
			mainMenuHover=true;
			if(!mainMusic) {
				GamePanel.soundEffect(GamePanel.hover);
				mainMusic=true;
			}
		}
		else {
			mainMenuHover=false;
			mainMusic = false;
		}
	}
}// end of EndMenu class
