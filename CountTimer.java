//Authors: Eileen Kuang & Lillian Li
//Date: January 11, 2024
//Title: 7 Minute Meltdown (CountTimer class)
//Description: Class helps control and display the countdown timer

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;

public class CountTimer {

	// Variable declarations
	public static int elapsedTime; // start timer from 7 minutes
	public static int seconds;
	public static int minutes;
	public static int counter;
	public static long lastTime;
	public static boolean penalty = false;
	public static boolean begin = false;
	public String seconds_string = String.format("%02d", seconds);
	public String minutes_string = String.format("%02d", minutes);
	public static File fontFile; // custom title font
	public ImageIcon timerIcon = new ImageIcon("timerbox.png");
	public Image timerImage = timerIcon.getImage();
	public GeneralButton timerBox = new GeneralButton(440, 5, 120, 60, timerImage);

	// constructor; starts the timer
	public CountTimer() {
		
		fontFile = new File("DS-DIGI.TTF"); // font path
		reset();
		
	}
	
	// draws border and customizes fonts
	public void draw(Graphics g, boolean menu) {
		
		// if started and player has not won or lost yet
		if(begin) {
			
			// sets lastTime to the first time user begins playing
			if(counter == 0) {
	
				lastTime = System.currentTimeMillis();
							
			}
				
			// flashes red
			if(penalty) {
				g.setColor(new Color(255, 0, 0, 100)); // make it partially transparent
	            g.fillRect(0, 0, GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT);
			}
			
			// formatting for bomb menu
			if(menu) {
				
				// formatting
				try {
					g.setFont(Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(105f));
				} catch (FontFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				g.setColor(new Color(28, 36, 25));
				g.drawString(minutes_string + ":" + seconds_string, 390, 370);
				start();
				
			}
			else { // formatting for mini games
				
				// formatting
				try {
					g.setFont(Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(35f));
				} catch (FontFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				timerBox.draw(g, false);
				g.setColor(new Color(28, 36, 25));
				g.drawString(minutes_string + ":" + seconds_string, 460, 45);
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
			else if(counter <1){ // accounts for every time the timer begins/restarts
			
				seconds = 0;
				minutes = 7;
				seconds_string = String.format("%02d", seconds);

				minutes_string = String.format("%02d", minutes);
								
				lastTime = System.currentTimeMillis();						
				
			}
			counter++;
			
		}
		
		if(counter == 419) {
			
			EndMenu.win = false;
			EndMenu.lose = true; // time ran out, user loses
			
		}
		
	}
	
	public static void reset() {
		
		elapsedTime = 0; // start timer from 7 minutes
		seconds = 0;
		minutes = 7;
		counter = 0;
		lastTime = 0;
		penalty = false;
		begin = true;
		
	}
	

}