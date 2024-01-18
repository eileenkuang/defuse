//Authors: Eileen Kuang & Lillian Li
//Date: January 18, 2024
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
	public QuitButton quit = new QuitButton();
	public ImageIcon winIcon = new ImageIcon("rhythmicwin.png");
	public Image winImage = winIcon.getImage();
	public ImageIcon backUnclickedIcon = new ImageIcon("endscreenbackunclicked.png");
	public Image backUnclickedImage = backUnclickedIcon.getImage();
	public ImageIcon backHoveredIcon = new ImageIcon("endscreenbackhovered.png");
	public Image backHoveredImage = backHoveredIcon.getImage();
	public GeneralButton backButton = new GeneralButton(380, 540, (int) (433 / 2), (int) (166 / 2), backUnclickedImage,
			backHoveredImage);

	// checks
	public boolean seqOrNot = true;
	public boolean yflash = false;
	public boolean rflash = false;
	public boolean gflash = false;
	public boolean bflash = false;
	public static boolean hoverQuit = false;
	public boolean backHover = false;
	
	// sequence variables
	int[] sequence = new int[12];
	int[] answerSeq = new int[12];
	public int choice = 0;
	public int turn = 0;
	public int flashIndex = 1;
	static long lastTime;

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

		quit.draw(g);

	    if (yflash) {
	        yellow.draw(g, yflash);
	        red.draw(g, rflash);
	        green.draw(g, gflash);
	        blue.draw(g, bflash);
	        
	    } else if (rflash) {
	        yellow.draw(g, yflash);
	        red.draw(g, rflash);
	        green.draw(g, gflash);
	        blue.draw(g, bflash);

	    } else if (gflash) {
	        yellow.draw(g, yflash);
	        red.draw(g, rflash);
	        green.draw(g, gflash);
	        blue.draw(g, bflash);

	    } else if (bflash) {
	        yellow.draw(g, yflash);
	        red.draw(g, rflash);
	        green.draw(g, gflash);
	        blue.draw(g, bflash);

	    } else {
	        yellow.draw(g, yflash);
	        red.draw(g, rflash);
	        green.draw(g, gflash);
	        blue.draw(g, bflash);
	    }
	    
	    sleep(300);
		yflash = false;
		rflash = false;
		gflash = false;
		bflash = false;
		
		if(BombMenu.solveRhythmic) {
			
	    	g.setColor(new Color(0, 0, 0, 100)); // make it partially transparent
			g.fillRect(0, 0, GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT);
			g.drawImage(winImage, 10, 40, (int)(666*1.45),(int)(375*1.45), null); // draw background
			g.drawImage(BombMenu.codeImage(BombMenu.codeInt4), 430, 395, (int) (200 / 1.75), (int) (217 / 1.75), null);
	    	backButton.draw(g, backHover);
	    	
	    }
	    
	}// end of draw method

	// sleeps program for a certain number of milliseconds
	static void sleep(int m) {
		
		lastTime = System.currentTimeMillis();
		
		while(System.currentTimeMillis() >= lastTime) {
			
			if(System.currentTimeMillis()>= lastTime+m) {
				
				break;
				
			}
			
		}
				
	} // end of draw method


	// generates randomized sequence for lights
	public void generateSequence() {

		if(seqOrNot) {
			
			// loop to generate sequence
			for(int i=0; i<12; i++) {
				
				sequence[i]=(int)(Math.random()*4+1);
				
				flashSequence(i);
				
				sleep(500);
				
			}
			
			seqOrNot = false;
		
		}
			
	}
	
	// flashes sequence
	public void flashSequence(int i) {
		
		switch(sequence[i]) {
		
		case 1:
			yflash = true;
			choice = 1;
			turn++;
			break;
		case 2:
			rflash = true;
			choice = 2;
			turn++;
			break;
		case 3:
			gflash = true;
			choice = 3;
			turn++;
			break;
		case 4:
			bflash = true;
			choice = 4;
			turn++;
			break;
		
			
		}
			
	}
	
	// checks correct sequence or not
	public boolean check() {
		
		for(int i=0; i < flashIndex; i++) {
			
			if(answerSeq[i] != sequence[i]) {
				
				return false;
				
			}
			
		}
		
		return true;
		
	}
	
	public void lose() {
		yflash = true;
		rflash = true;
		gflash = true;
		bflash = true;
		generateSequence();
		
	}
	
	public void passOrNot(boolean win) {
		
		if(win) {
			
			// draw win screen
		}
		else {
			generateSequence();
		}
		
	}

	// will detect when and where mouse clicks to detect user sequence
	public void mouseClicked(MouseEvent e) {

		if(!BombMenu.solveRhythmic) {
			
			// click quit button
			if(quit.intersects(e.getX(), e.getY(), 1, 1)) {
				GamePanel.onlyShowBombMenu = true;
				GamePanel.onlyShowRhythmic = false;
				hoverQuit = false;
			}
		
			if(!seqOrNot) {
				
				if (yellow.intersects(e.getX(), e.getY(), 1, 1)) {
					
					yflash = true;
					choice = 1;
					turn++;
							
				}	
				else if(red.intersects(e.getX(), e.getY(), 1, 1)) {
					
					rflash = true;
					choice = 2;
					turn++;
	
				}
				else if(green.intersects(e.getX(), e.getY(), 1, 1)) {
					
					gflash = true;
					choice = 3;
					turn++;
	
				}
				else if(blue.intersects(e.getX(), e.getY(), 1, 1)) {
					
					bflash = true;
					choice = 4;
					turn++;
					
				}
				
			}
			
		} else {
			
			if(backButton.intersects(e.getX(), e.getY(), 1, 1)) {
				
				GamePanel.onlyShowBombMenu = true;
				GamePanel.onlyShowRhythmic = false;
				backHover=false;
				
			}
			
		}
		
	}// end of mouseClicked method
	
	// moves any moving graphics
	public void mouseMoved(MouseEvent e) {

		if(!BombMenu.solveRhythmic) {
			// hover over quit button
			if(quit.intersects(e.getX(), e.getY(), 1, 1))
				hoverQuit = true;
			else 
				hoverQuit = false;
		}
		else {
		
			if(backButton.intersects(e.getX(), e.getY(), 1, 1)) 
				backHover=true;
			else
				backHover=false;
			
		}
		
	}// end of move method

	// detects key presses
	public void keyPressed(KeyEvent e) {

		seqOrNot = true;
				
		if(e.getKeyChar() == 'q' || e.getKeyChar() == 'Q') {
			
			BombMenu.solveRhythmic = true;
			
		}
		else {
			generateSequence();
		}
		
		
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
