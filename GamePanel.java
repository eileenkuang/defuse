import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//imports required for audio
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class GamePanel extends JPanel implements Runnable, KeyListener {

	// dimensions of window
	public static final int GAME_WIDTH = 1000;
	public static final int GAME_HEIGHT = 700;

	// declare objects
	public Thread gameThread;
	public Image image;
	public Graphics graphics;
	public static Clip clip; // initiate Clip object to play music
	//menus
	public MainMenu mainMenu;
	public BombMenu bombMenu;
	public EndMenu endMenu;
	//puzzles
	public CryptoMain crypto;
	public RhythmicMain rhythmic;
	public KeyMain key;
	public LingMain ling;
	
	//other variables
	public static boolean showMainMenu=true;
	public static boolean showBombMenu=false;
	public static boolean showEndMenu=false;
	public static boolean showCrypto=false;
	public static boolean showRhythmic=false;
	public static boolean showKey=false;
	public static boolean showLing=false;
	
	public static boolean onlyShowMainMenu=showMainMenu && !showBombMenu && !showEndMenu && !showCrypto && !showRhythmic && !showKey && !showLing;
	public static boolean onlyShowBombMenu=!showMainMenu && showBombMenu && !showEndMenu && !showCrypto && !showRhythmic && !showKey && !showLing;
	public static boolean onlyShowEndMenu=!showMainMenu && !showBombMenu && showEndMenu && !showCrypto && !showRhythmic && !showKey && !showLing;
	public static boolean onlyShowCrypto=!showMainMenu && !showBombMenu && !showEndMenu && showCrypto && !showRhythmic && !showKey && !showLing;
	public static boolean onlyShowRhythmic=!showMainMenu && !showBombMenu && !showEndMenu && !showCrypto && showRhythmic && !showKey && !showLing;
	public static boolean onlyShowKey=!showMainMenu && !showBombMenu && !showEndMenu && !showCrypto && !showRhythmic && showKey && !showLing;
	public static boolean onlyShowLing=!showMainMenu && !showBombMenu && !showEndMenu && !showCrypto && !showRhythmic && !showKey && showLing;

	public GamePanel() {
		// instantiate objects
		mainMenu=new MainMenu();
		bombMenu=new BombMenu();
		endMenu=new EndMenu();
		rhythmic=new RhythmicMain();
		key=new KeyMain();
		ling=new LingMain();
		
		// set up/start the game
		this.setFocusable(true); // make everything in this class appear on the screen
		this.addKeyListener(this); // start listening for keyboard input
		this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
		gameThread = new Thread(this);
		gameThread.start();
	}

	public void paint(Graphics g) {
		// use double buffering to draw images
		image = createImage(GAME_WIDTH, GAME_HEIGHT); // draw off screen
		graphics = image.getGraphics();
		draw(graphics);// update the positions of everything on the screen
		g.drawImage(image, 0, 0, this); // move the image on the screen
	}

	public void draw(Graphics g) {
		if(onlyShowMainMenu) {
			mainMenu.draw(g);
		}
		else if(onlyShowBombMenu) {
			bombMenu.draw(g);
		}
		else if(onlyShowEndMenu) {
			endMenu.draw(g);
		}
		else if(onlyShowCrypto) {
			crypto.draw(g);
		}
		else if(onlyShowRhythmic) {
			rhythmic.draw(g);
		}
		else if(onlyShowKey) {
			key.draw(g);
		}
		else if(onlyShowLing) {
			ling.draw(g);
		}
	}

	public void move() {
		if(onlyShowMainMenu) {
			mainMenu.move();
		}
		else if(onlyShowBombMenu) {
			bombMenu.move();
		}
		else if(onlyShowEndMenu) {
			endMenu.move();
		}
		else if(onlyShowCrypto) {
			crypto.move();
		}
		else if(onlyShowRhythmic) {
			rhythmic.move();
		}
		else if(onlyShowKey) {
			key.move();
		}
		else if(onlyShowLing) {
			ling.move();
		}
	}

	public void keyPressed(KeyEvent e) {
		if(onlyShowMainMenu) {
			mainMenu.keyPressed(e);
		}
		else if(onlyShowBombMenu) {
			bombMenu.keyPressed(e);
		}
		else if(onlyShowEndMenu) {
			endMenu.keyPressed(e);
		}
		else if(onlyShowCrypto) {
			crypto.keyPressed(e);
		}
		else if(onlyShowRhythmic) {
			rhythmic.keyPressed(e);
		}
		else if(onlyShowKey) {
			key.keyPressed(e);
		}
		else if(onlyShowLing) {
			ling.keyPressed(e);
		}
	}// end of keyPressed method

	public void keyReleased(KeyEvent e) {
		if(onlyShowMainMenu) {
			mainMenu.keyReleased(e);
		}
		else if(onlyShowBombMenu) {
			bombMenu.keyReleased(e);
		}
		else if(onlyShowEndMenu) {
			endMenu.keyReleased(e);
		}
		else if(onlyShowCrypto) {
			crypto.keyReleased(e);
		}
		else if(onlyShowRhythmic) {
			rhythmic.keyReleased(e);
		}
		else if(onlyShowKey) {
			key.keyReleased(e);
		}
		else if(onlyShowLing) {
			ling.keyReleased(e);
		}
	}// end of keyReleased method

	public void keyTyped(KeyEvent e) {
		if(onlyShowMainMenu) {
			mainMenu.keyTyped(e);
		}
		else if(onlyShowBombMenu) {
			bombMenu.keyTyped(e);
		}
		else if(onlyShowEndMenu) {
			endMenu.keyTyped(e);
		}
		else if(onlyShowCrypto) {
			crypto.keyTyped(e);
		}
		else if(onlyShowRhythmic) {
			rhythmic.keyTyped(e);
		}
		else if(onlyShowKey) {
			key.keyTyped(e);
		}
		else if(onlyShowLing) {
			ling.keyTyped(e);
		}
	}// end of keyTyped method

	public void mouseEntered(MouseEvent e) {
		if(onlyShowMainMenu) {
			mainMenu.mouseEntered(e);
		}
		else if(onlyShowBombMenu) {
			bombMenu.mouseEntered(e);
		}
		else if(onlyShowEndMenu) {
			endMenu.mouseEntered(e);
		}
		else if(onlyShowCrypto) {
			crypto.mouseEntered(e);
		}
		else if(onlyShowRhythmic) {
			rhythmic.mouseEntered(e);
		}
		else if(onlyShowKey) {
			key.mouseEntered(e);
		}
		else if(onlyShowLing) {
			ling.mouseEntered(e);
		}
	}// end of mouseEntered method

	public void mouseExited(MouseEvent e) {
		if(onlyShowMainMenu) {
			mainMenu.mouseExited(e);
		}
		else if(onlyShowBombMenu) {
			bombMenu.mouseExited(e);
		}
		else if(onlyShowEndMenu) {
			endMenu.mouseExited(e);
		}
		else if(onlyShowCrypto) {
			crypto.mouseExited(e);
		}
		else if(onlyShowRhythmic) {
			rhythmic.mouseExited(e);
		}
		else if(onlyShowKey) {
			key.mouseExited(e);
		}
		else if(onlyShowLing) {
			ling.mouseExited(e);
		}
	}// end of mouseExited method

	public void loopMusic(String file) {
		try {
			File musicPath = new File(file);
			if (musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				clip = AudioSystem.getClip(); // create object to play the clip
				clip.open(audioInput);
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				clip.start();
			} else {
				System.out.println("Can't find file");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}// end of loopMusic method

	public static void soundEffect(String file) { // plays music once
		try {
			File musicPath = new File(file);
			if (musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip2 = AudioSystem.getClip(); // create object to play the clip
				clip2.open(audioInput);
				clip2.start();
			} else {
				System.out.println("Can't find file");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}// end of soundEffect method

	public static void stopMusic() {
		clip.stop();
	}// end of stopMusic method
	
	public void run() {
		// slows down the running of the CPU
		long lastTime = System.nanoTime();
		double amountOfTicks = 60;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long now;

		while (true) { // infinite game loop
			now = System.nanoTime();
			delta = delta + (now - lastTime) / ns;
			lastTime = now;

			// only move objects around and update screen if enough time has passed
			if (delta >= 1) {
				move();
				repaint();
				delta--;
			}
		}
	}// end of run method

}// end of GamePanel class
