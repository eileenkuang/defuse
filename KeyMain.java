import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;

public class KeyMain {

	// variables
	public static boolean win = false;
	public static boolean showHint = false;
	public static boolean hoverHint = false;
	public static boolean hintUsed = false;
	public static boolean hoverQuit = false;

	// objects
	public KeyPlayer player = new KeyPlayer();
	public KeyHole hole = new KeyHole();
	public HintButton hint = new HintButton();
	public QuitButton quit = new QuitButton();
	public KeyObstacles obstacle1 = new KeyObstacles();
	public KeyObstacles obstacle2 = new KeyObstacles();
	public KeyObstacles obstacle3 = new KeyObstacles();
	public KeyObstacles obstacle4 = new KeyObstacles();
	public KeyObstacles obstacle5 = new KeyObstacles();
	public KeyObstacles obstacle6 = new KeyObstacles();
	public KeyObstacles obstacle7 = new KeyObstacles();
	public KeyObstacles obstacle8 = new KeyObstacles();
	public KeyMenus keyMenu = new KeyMenus();

	// the background
	public ImageIcon backgroundIcon;
	public Image backgroundImage;
	public final int BACKGROUND_WIDTH = GamePanel.GAME_WIDTH;
	public final int BACKGROUND_HEIGHT = GamePanel.GAME_HEIGHT;

	public KeyMain() {
		backgroundIcon = new ImageIcon("keybackground.png");
		backgroundImage = backgroundIcon.getImage();
		reset();
	}

	public void reset() {
		player.x = 10;
		player.y = 350;
		
		hole.x = GamePanel.GAME_WIDTH - KeyHole.HOLE_WIDTH - 5;
		hole.y = (int) (Math.random() * (GamePanel.GAME_HEIGHT - KeyHole.HOLE_HEIGHT - 0 + 1)) + 0;
		
		hint.x = 10;
		hint.y = 10;
		
		quit.x=10;
		quit.y=640;

		obstacle1.x = 150;
		obstacle1.y = 0;

		obstacle2.x = 250;
		obstacle2.y = -200;

		obstacle3.x = 350;
		obstacle3.y = 200;

		obstacle4.x = 450;
		obstacle4.y = 600;

		obstacle5.x = 550;
		obstacle5.y = -500;

		obstacle6.x = 650;
		obstacle6.y = 500;

		obstacle7.x = 750;
		obstacle7.y = 300;

		obstacle8.x = 850;
		obstacle8.y = -900;
	}

	public void hit() {
		player.x = 10;
		player.y = 350;
		hole.y = (int) (Math.random() * (GamePanel.GAME_HEIGHT - KeyHole.HOLE_HEIGHT - 0 + 1)) + 0;
	}

	public void draw(Graphics g) {
		g.drawImage(backgroundImage, 0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null); // draw background
		player.draw(g);
		hole.draw(g);
		hint.draw(g);
		quit.draw(g);
		obstacle1.draw(g);
		obstacle2.draw(g);
		obstacle3.draw(g);
		obstacle4.draw(g);
		obstacle5.draw(g);
		obstacle6.draw(g);
		obstacle7.draw(g);
		obstacle8.draw(g);
		if (win || showHint) {
			keyMenu.draw(g);
		}
	}// end of draw method

	public void move() {
		if (!win) {
			if (player.intersects(obstacle1) || player.intersects(obstacle2) || player.intersects(obstacle3)
					|| player.intersects(obstacle4) || player.intersects(obstacle5) || player.intersects(obstacle6)
					|| player.intersects(obstacle7) || player.intersects(obstacle8)) {
				hit();
			}
			if (player.intersects(hole)) {
				win = true;
			}
			player.move();
			player.checkCollision();
			obstacle1.move();
			obstacle2.move();
			obstacle3.move();
			obstacle4.move();
			obstacle5.move();
			obstacle6.move();
			obstacle7.move();
			obstacle8.move();
		}
	}// end of move method

	public void keyPressed(KeyEvent e) {
		if (!win) {
			player.keyPressed(e);
		}
	}// end of keyPressed method

	public void keyReleased(KeyEvent e) {
		if (!win) {
			player.keyReleased(e);
		}
	}// end of keyReleased method

	public void mouseClicked(MouseEvent e) {
		if (hint.intersects(e.getX(), e.getY(), 1, 1)) {
			hintUsed = true;
			showHint = true;
		}
	}// end of mouseClicked method

	public void mouseMoved(MouseEvent e) {
		if (hint.intersects(e.getX(), e.getY(), 1, 1))
			hoverHint = true;
		else 
			hoverHint = false;
		if(quit.intersects(e.getX(), e.getY(), 1, 1))
			hoverQuit=true;
		else
			hoverQuit=false;
	}// end of mouseMoved method
}
