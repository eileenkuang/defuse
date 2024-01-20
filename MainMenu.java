//Authors: Eileen Kuang & Lillian Li
//Date: January 18, 2024
//Title: 7 Minute Meltdown (MainMenu class)
//Description: Class to display the main menu options for user

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class MainMenu {

	// Variable declarations

	// background
	public ImageIcon mainBackgroundIcon= new ImageIcon("mainbackground.png");;
	public Image mainBackgroundImage= mainBackgroundIcon.getImage();;
	
	//buttons
	public PlayButton play= new PlayButton(370, 300);
	public InstructionsButton ins = new InstructionsButton(370, 440);
	public ImageIcon backUnclickedIcon=new ImageIcon("backinstructions.png");
	public Image backButtonUnclicked = backUnclickedIcon.getImage();
	public ImageIcon backHoveredIcon=new ImageIcon("backinstructionshovered.png");
	public Image backButtonHovered = backHoveredIcon.getImage();
	public GeneralButton back = new GeneralButton(425, 560, (int)(307/1.75), (int)(126/1.75), backButtonUnclicked, backButtonHovered);
	public boolean playHover = false;
	public boolean insHover = false;
	public boolean backHover = false;
	public boolean showInstructions=false;
	public boolean playMusic=false;
	public boolean rulesMusic=false;
	
	
	//instructions background
	public ImageIcon instructionsIcon = new ImageIcon("instructions.png");
	public Image instructionsImage = instructionsIcon.getImage();
	

	// constructor
	public MainMenu() {

	}

	// draw background, play button, instructions button to screen
	public void draw(Graphics g) {
		if(showInstructions) {
			g.drawImage(instructionsImage, 0, 0, GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT, null); // draw instructions
			back.draw(g, backHover);
		}
		else {
			g.drawImage(mainBackgroundImage, 0, 0, GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT, null); // draw background
			play.draw(g, playHover);
			ins.draw(g, insHover);
		}
		

	}// end of draw method

	// check when mouse is hovering over a button
	public void mouseMoved(MouseEvent e) {		
		if(!showInstructions) {
			if (play.intersects(e.getX(), e.getY(), 1, 1)) {
				playHover = true;
				if(!playMusic) {
					GamePanel.soundEffect(GamePanel.hover);
					playMusic=true;
				}
			} else {
				playHover = false;
				playMusic=false;
			}
			if (ins.intersects(e.getX(), e.getY(), 1, 1)) {
				insHover = true;
				if(!rulesMusic) {
					GamePanel.soundEffect(GamePanel.hover);
					rulesMusic=true;
				}
			} else {
				rulesMusic=false;
				insHover = false;
			}
		}
		else {
			if(back.intersects(e.getX(), e.getY(), 1, 1)) {
				backHover=true;
			}
			else {
				backHover=false;
			}
		}
		

	}// end of mouseMoved method

	// check when mouse clicks a button & switches to the according page
	public void mouseClicked(MouseEvent e) {
		if(!showInstructions) {
			if (play.intersects(e.getX(), e.getY(), 1, 1)) {
				GamePanel.onlyShowMainMenu = false;
				GamePanel.onlyShowBombMenu = true;
				playHover = false;
			}
			if (ins.intersects(e.getX(), e.getY(), 1, 1)) {
				showInstructions=true;
				insHover=false;
			}
		}
		else {
			if(back.intersects(e.getX(), e.getY(), 1, 1)) {
				showInstructions=false;
				backHover=false;
			}
		}
		

	}// end of mouseClicked method

}