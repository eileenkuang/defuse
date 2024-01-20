//Authors: Eileen Kuang & Lillian Li
//Date: January 18, 2024
//Title: 7 Minute Meltdown (BombMenu class)
//Description: Class to make Bomb Menu

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BombMenu {

	// hover variables
	public boolean hoverCrypto = false;
	public boolean hoverKey = false;
	public boolean hoverMagic = false;
	public boolean hoverRhythmic = false;

	public boolean hoverDefuse = false;
	public boolean hoverGiveUp = false;

	// how many puzzles are solved
	public static boolean solveCrypto = false;
	public static boolean solveKey = false;
	public static boolean solveRhythmic = false;
	public static boolean solveMagic = false;

	// the background
	public ImageIcon backgroundIcon;
	public Image backgroundImage;
	public final int BACKGROUND_WIDTH = GamePanel.GAME_WIDTH;
	public final int BACKGROUND_HEIGHT = GamePanel.GAME_HEIGHT;

	// timer box
	public ImageIcon timerIcon = new ImageIcon("timerbox.png");
	public Image timerImage = timerIcon.getImage();
	public GeneralButton timerBox = new GeneralButton(260, 230, (int) (742 / 1.5), (int) (336 / 1.5), timerImage);

	// defuse button
	public ImageIcon defuseUnclickedIcon = new ImageIcon("defusebutton.png");
	public Image defuseUnclickedImage = defuseUnclickedIcon.getImage();
	public ImageIcon defuseHoveredIcon = new ImageIcon("defusebuttonclicked.png");
	public Image defuseHoveredImage = defuseHoveredIcon.getImage();
	public GeneralButton defuseButton = new GeneralButton(345, 470, (int) (658 / 2.2), (int) (230 / 2.2),
			defuseUnclickedImage, defuseHoveredImage);

	// give up button
	public ImageIcon giveUnclickedIcon = new ImageIcon("giveup.png");
	public Image giveUnclickedImage = giveUnclickedIcon.getImage();
	public ImageIcon giveHoveredIcon = new ImageIcon("giveupclicked.png");
	public Image giveHoveredImage = giveHoveredIcon.getImage();
	public GeneralButton giveUpButton = new GeneralButton(15, 620, (int) (669 / 3.5), (int) (232 / 3.5),
			giveUnclickedImage, giveHoveredImage);

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

	// magic button
	public ImageIcon magicUnclickedRedIcon = new ImageIcon("labyrinthbutton.png");
	public Image magicUnclickedRedImage = magicUnclickedRedIcon.getImage();
	public ImageIcon magicHoveredRedIcon = new ImageIcon("labyrinthbuttonclicked.png");
	public Image magicHoveredRedImage = magicHoveredRedIcon.getImage();

	public ImageIcon magicUnclickedGreenIcon = new ImageIcon("labyrinthbuttonsolved.png");
	public Image magicUnclickedGreenImage = magicUnclickedGreenIcon.getImage();
	public ImageIcon magicHoveredGreenIcon = new ImageIcon("labyrinthbuttonsolvedclicked.png");
	public Image magicHoveredGreenImage = magicHoveredGreenIcon.getImage();

	public BombButton magic = new BombButton(30, 420, magicUnclickedRedImage, magicHoveredRedImage,
			magicUnclickedGreenImage, magicHoveredGreenImage);

	// rhythmic button
	public ImageIcon rhythmicUnclickedRedIcon = new ImageIcon("rhythmicbutton.png");
	public Image rhythmicUnclickedRedImage = rhythmicUnclickedRedIcon.getImage();
	public ImageIcon rhythmicHoveredRedIcon = new ImageIcon("rhythmicbuttonclicked.png");
	public Image rhythmicHoveredRedImage = rhythmicHoveredRedIcon.getImage();

	public ImageIcon rhythmicUnclickedGreenIcon = new ImageIcon("rhythmicbuttonsolved.png");
	public Image rhythmicUnclickedGreenImage = rhythmicUnclickedGreenIcon.getImage();
	public ImageIcon rhythmicHoveredGreenIcon = new ImageIcon("rhythmicbuttonsolvedclicked.png");
	public Image rhythmicHoveredGreenImage = rhythmicHoveredGreenIcon.getImage();

	public BombButton rhythmic = new BombButton(630, 420, rhythmicUnclickedRedImage, rhythmicHoveredRedImage,
			rhythmicUnclickedGreenImage, rhythmicHoveredGreenImage);

	// the codes
	public static ImageIcon a = new ImageIcon("codeA.png");
	public static Image letterA = a.getImage();
	public static ImageIcon ampersand = new ImageIcon("codeAmpersand.png");
	public static Image symbolAmpersand = ampersand.getImage();
	public static ImageIcon asterisk = new ImageIcon("codeAsterisk.png");
	public static Image symbolAsterisk = asterisk.getImage();
	public static ImageIcon at = new ImageIcon("codeAt.png");
	public static Image symbolAt = at.getImage();
	public static ImageIcon h = new ImageIcon("codeH.png");
	public static Image letterH = h.getImage();
	public static ImageIcon percent = new ImageIcon("codePercent.png");
	public static Image symbolPercent = percent.getImage();
	public static String code = "";
	public static int codeInt1 = (int) (Math.random() * (6 - 1 + 1)) + 1;
	public static int codeInt2 = (int) (Math.random() * (6 - 1 + 1)) + 1;
	public static int codeInt3 = (int) (Math.random() * (6 - 1 + 1)) + 1;
	public static int codeInt4 = (int) (Math.random() * (6 - 1 + 1)) + 1;
	public String defuseInput = ""; //user's code input
	public int cursorLocation=0;
	public String currentKey=""; //correct code
	public boolean wrongCodeEntered=false; //if the wrong code is entered and defuse is pressed

	// defuse code
	public ImageIcon icon1 = new ImageIcon("defusecode.png");
	public Image defuseCodeUnclicked = icon1.getImage();
	public ImageIcon icon2 = new ImageIcon("defusecodeclicked.png");
	public Image defuseCodeClicked = icon2.getImage();
	public GeneralButton defuseCode = new GeneralButton(325, 130, (int)(1024/3), (int)(244/3), defuseCodeUnclicked, defuseCodeClicked);
	
	public boolean defuseCodeHover=false;
	public boolean defuseCodeClick=false;
	
	//if the game needs to restart
	public static boolean restart = false;
	
	// Constructor
	public BombMenu() {
		code += codeSymbol(codeInt1);
		code += codeSymbol(codeInt2);
		code += codeSymbol(codeInt3);
		code += codeSymbol(codeInt4);

		// background
		backgroundIcon = new ImageIcon("bombmenubackground.jpeg");
		backgroundImage = backgroundIcon.getImage();
	}
	
	//Resets/restarts the game
	public void reset() {
		//reset code and input
		code="";
		defuseInput="";
		
		//generate 4 random symbols for the code
		codeInt1 = (int) (Math.random() * (6 - 1 + 1)) + 1;
		codeInt2 = (int) (Math.random() * (6 - 1 + 1)) + 1;
		codeInt3 = (int) (Math.random() * (6 - 1 + 1)) + 1;
		codeInt4 = (int) (Math.random() * (6 - 1 + 1)) + 1;
		code += codeSymbol(codeInt1);
		code += codeSymbol(codeInt2);
		code += codeSymbol(codeInt3);
		code += codeSymbol(codeInt4);
		cursorLocation=0;
		
		//set all variables to false
		solveCrypto=false;
		solveKey=false;
		solveRhythmic=false;
		solveMagic=false;
	}

	//Returns the symbol corresponding to the number passed in
	public String codeSymbol(int codeInt) {
		if (codeInt == 1) {
			return "A";
		} else if (codeInt == 2) {
			return "&";
		} else if (codeInt == 3) {
			return "*";
		} else if (codeInt == 4) {
			return "@";
		} else if (codeInt == 5) {
			return "H";
		} else {
			return "%";
		}
	}

	//Returns the image corresponding to the number passed in
	public static Image codeImage(int codeInt) {
		if (codeInt == 1) {
			return letterA;
		} else if (codeInt == 2) {
			return symbolAmpersand;
		} else if (codeInt == 3) {
			return symbolAsterisk;
		} else if (codeInt == 4) {
			return symbolAt;
		} else if (codeInt == 5) {
			return letterH;
		} else {
			return symbolPercent;
		}
	}

	// Draws to the screen
	public void draw(Graphics g) {
		//if the game is restarted
		if(restart) {
			CountTimer.reset();
			reset();
			CryptoMain.reset();
			KeyMain.reset();
			MagicMain.reset();
			restart=false;
		}
		
		g.drawImage(backgroundImage, 0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null); // draw background
		
		//draw each puzzle button
		crypto.draw(g, hoverCrypto, solveCrypto);
		key.draw(g, hoverKey, solveKey);
		magic.draw(g, hoverMagic, solveMagic);
		rhythmic.draw(g, hoverRhythmic, solveRhythmic);
		
		//draw other buttons on the screen
		defuseButton.draw(g, hoverDefuse);
		giveUpButton.draw(g, hoverGiveUp);
		
		//draw the timer box
		timerBox.draw(g, false);
		
		//if the code box is clicked
		if(defuseCodeClick) {
			defuseCode.draw(g, true);
		}
		else {
			defuseCode.draw(g, defuseCodeHover);
		}
		
		//draws what the user types for the defuse code
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 30)); 
		if(defuseInput.length()>=1) {
			g.drawString(defuseInput.substring(0,1),440,170);
		}
		if(defuseInput.length()>=2) {
			g.drawString(defuseInput.substring(1,2),495,170);
		}
		if(defuseInput.length()>=3) {
			g.drawString(defuseInput.substring(2,3),555,170);
		}
		if(defuseInput.length()>=4) {
			g.drawString(defuseInput.substring(3,4),610,170);
		}
		
		//if the user presses defuse and the wrong code is entered, the screen turns red
		if(wrongCodeEntered) {
			g.setColor(new Color(255, 0, 0, 100)); // make it partially transparent
			g.fillRect(0, 0, GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT);
		}
		
	}// end of draw method

	// Detects when keys are typed
	public void keyTyped(KeyEvent e) {
		//if the defuse code box is being accessed
		if(defuseCodeClick) {
			if(e.getKeyChar()=='\b') { //if the user presses backspace, delete the most recent letter
				currentKey="";
				defuseInput=defuseInput.substring(0,cursorLocation-1);
				if(cursorLocation>1) {
					cursorLocation-=1;
				}
			}
			else if(!(e.getKeyChar()=='\n')){ //check to make sure the key is not enter
				currentKey=String.valueOf(e.getKeyChar());
				if(cursorLocation<4) {
					defuseInput+=currentKey;
					cursorLocation++;
				}
				else {//if cursorLocation==4
					defuseInput=defuseInput.substring(0,cursorLocation-1)+currentKey;
				}
			}
		}
	}// end of keyTyped method

	// Detects the mouse clicking the screen
	public void mouseClicked(MouseEvent e) {
		wrongCodeEntered=false; //resets the screen from being red
		
		// checks for the buttons being pressed on the Bomb Menu and sets the variables
		// to false/true to edit what is being shown on the screen
		if (crypto.intersects(e.getX(), e.getY(), 1, 1) && !timerBox.intersects(e.getX(), e.getY(), 1, 1) && !defuseCode.intersects(e.getX(), e.getY(), 1, 1)) {
			GamePanel.onlyShowBombMenu = false;
			GamePanel.onlyShowCrypto = true;
			hoverCrypto = false;
		}
		if (key.intersects(e.getX(), e.getY(), 1, 1) && !timerBox.intersects(e.getX(), e.getY(), 1, 1) && !defuseCode.intersects(e.getX(), e.getY(), 1, 1)) {
			GamePanel.onlyShowBombMenu = false;
			GamePanel.onlyShowKey = true;
			hoverKey = false;
		}
		if (magic.intersects(e.getX(), e.getY(), 1, 1) && !hoverDefuse && !hoverGiveUp) {
			GamePanel.onlyShowBombMenu = false;
			GamePanel.onlyShowMagic = true;
			hoverMagic = false;
		}
		if (rhythmic.intersects(e.getX(), e.getY(), 1, 1) && !hoverDefuse) {
			GamePanel.onlyShowBombMenu = false;
			GamePanel.onlyShowRhythmic = true;
			hoverRhythmic = false;
		}
		if (defuseButton.intersects(e.getX(), e.getY(), 1, 1)) {
			if (defuseInput.equals(code)) { //if the code is correct, the user wins
				GamePanel.stopMusic(); //stop the background music
				GamePanel.loopMusic(GamePanel.winMusic); //cheer sound effect
				GamePanel.onlyShowBombMenu = false;
				GamePanel.onlyShowEndMenu = true;
				EndMenu.win=true;
				EndMenu.lose=false;
				restart=true; //resets the game
			}
			else { //if the user inputed the wrong code
				GamePanel.soundEffect(GamePanel.wrongCode); 
				GamePanel.onlyShowBombMenu = false;
				GamePanel.onlyShowEndMenu = true;
				EndMenu.win=false;
				EndMenu.lose=true;
				restart=true; //resets the game
			}
		}
		if (giveUpButton.intersects(e.getX(), e.getY(), 1, 1)) { //if the user clicks give up
			GamePanel.soundEffect(GamePanel.wrongCode);
			GamePanel.onlyShowBombMenu = false;
			GamePanel.onlyShowEndMenu = true;
			EndMenu.lose=true;
			EndMenu.win=false;
			restart=true; //resets the game
		}
		if(defuseCode.intersects(e.getX(), e.getY(), 1, 1)) { //if the user clicks on the defuse code box
			defuseCodeClick=true;
		}
		else {
			defuseCodeClick=false;
		}
	}// end of mouseClicked method

	// Detects the mouse being moved
	public void mouseMoved(MouseEvent e) {
		// checks for buttons being hovered over on the Bomb Menu and sets variables to
		// true/false depending on what should be shown on the screen
		if (crypto.intersects(e.getX(), e.getY(), 1, 1) && !timerBox.intersects(e.getX(), e.getY(), 1, 1) && !defuseCode.intersects(e.getX(), e.getY(), 1, 1))
			hoverCrypto = true;
		else
			hoverCrypto = false;
		if (key.intersects(e.getX(), e.getY(), 1, 1) && !timerBox.intersects(e.getX(), e.getY(), 1, 1) && !defuseCode.intersects(e.getX(), e.getY(), 1, 1))
			hoverKey = true;
		else
			hoverKey = false;
		if (magic.intersects(e.getX(), e.getY(), 1, 1) && !hoverDefuse && !hoverGiveUp)
			hoverMagic = true;
		else
			hoverMagic = false;
		if (rhythmic.intersects(e.getX(), e.getY(), 1, 1) && !hoverDefuse)
			hoverRhythmic = true;
		else
			hoverRhythmic = false;
		if (defuseButton.intersects(e.getX(), e.getY(), 1, 1))
			hoverDefuse = true;
		else
			hoverDefuse = false;
		if (giveUpButton.intersects(e.getX(), e.getY(), 1, 1))
			hoverGiveUp = true;
		else
			hoverGiveUp = false;
		if(defuseCode.intersects(e.getX(), e.getY(), 1, 1))
			defuseCodeHover=true;
		else
			defuseCodeHover=false;		
	}

}
