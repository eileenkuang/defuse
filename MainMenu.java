import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.ImageIcon;

public class MainMenu {
	
	// Variable declarations
	
	// background
	public ImageIcon backgroundIcon;
	public Image backgroundImage;
	public final int BACKGROUND_WIDTH = GamePanel.GAME_WIDTH;
	public final int BACKGROUND_HEIGHT = GamePanel.GAME_HEIGHT;
	public PlayButton play;
	public InstructionsButton ins;
	public boolean playHover = false;
	public boolean insHover = false;
	
	public MainMenu(){
		
		backgroundIcon = new ImageIcon("mainbackground.png");
		backgroundImage = backgroundIcon.getImage();
		play = new PlayButton();
		ins = new InstructionsButton();
		
	}
	
	public void draw(Graphics g) {
		
		g.drawString("WELCOME TO EIUHASLKJFD!!!!!!!", 400, 300);
		
		if(playHover) {
			
			
			
		}
		
		if(insHover) {
			
		}
		
	}// end of draw method
	
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
		
	}//end of mouseClicked method
	
	public void mouseReleased(MouseEvent e) {
		
	}//end of mouseReleased method
	
	public void mousePressed(MouseEvent e) {
		
	}//end of mousePressed method

	public void mouseMoved(MouseEvent e) {
		if (play.intersects(e.getX(), e.getY(), 1, 1))
			playHover = true;
		else 
			playHover = false;
		if(ins.intersects(e.getX(), e.getY(), 1, 1))
			insHover =true;
		else
			insHover=false;
	}// end of mouseMoved method
}
