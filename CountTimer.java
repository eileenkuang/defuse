//Authors: Eileen Kuang & Lillian Li
//Date: January 18, 2024
//Title: 7 Minute Meltdown (CountTimer class)
//Description: Class helps control and display the countdown timer

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CountTimer {

	// Variable declarations
	public int elapsedTime = 0; // start timer from 7 minutes
	public int seconds = 0;
	public int minutes = 7;
	public int counter = 0;
	public long lastTime = 0;
	public static boolean penalty = false;
	public boolean begin = false;
	public String seconds_string = String.format("%02d", seconds);
	public String minutes_string = String.format("%02d", minutes);

	// constructor; starts the timer
	public CountTimer() {

	}
	
	// draws border and customizes fonts
	public void draw(Graphics g, boolean menu) {

		// if started and player has not won or lost yet
		if(begin && !EndMenu.lose && !EndMenu.win) {
			
			// sets lastTime to the first time user begins playing
			if(counter == 0) {
				
				lastTime = System.currentTimeMillis();
				
			}
					
			counter++;
			
			if(penalty) {
				g.setColor(new Color(255, 0, 0, 100)); // make it partially transparent
				g.fillRect(0, 0, GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT);
			}

			// formatting for bomb menu
			if(menu) {
				
				// formatting
				g.setFont(new Font("Verdana", Font.PLAIN, 80));
				g.setColor(Color.black);
				g.drawString(minutes_string + ":" + seconds_string, 400, 350);
				start();
				
			}
			else { // formatting for mini games
				
				// formatting
				g.setFont(new Font("Verdana", Font.PLAIN, 35));
				g.setColor(Color.white);
				g.drawString(minutes_string + ":" + seconds_string, 500, 50);
				start();
							
			}
						
		}
			
	}

	// starts counting time and handles time deductions
	public void start() {
		
		if(elapsedTime<=420) { // if seven minutes hasn't passed yet
			
			if(System.currentTimeMillis()>=lastTime+1000) {
				
				// if penalty is true, deducts 30 seconds
				if(penalty == true) {
					
					elapsedTime = elapsedTime + 30;
					penalty = false;
					
				}
								
				seconds = 59-(elapsedTime % 60);

				if(elapsedTime%60 == 0) {
					
					minutes--;
					
				}
				
				seconds_string = String.format("%02d", seconds);

				minutes_string = String.format("%02d", minutes);
				
				elapsedTime++;
				
				// resets last time
				lastTime = System.currentTimeMillis();
				
				
			}
			
		}
		else if(elapsedTime > 420) {
			
			EndMenu.lose = true; // time ran out, user loses
			GamePanel.onlyShowEndMenu=true;
			GamePanel.onlyShowBombMenu=false;
			GamePanel.onlyShowCrypto=false;
			GamePanel.onlyShowKey=false;
			GamePanel.onlyShowRhythmic=false;
			
		}
		
	}
	

}
