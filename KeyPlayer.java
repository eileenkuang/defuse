import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyPlayer extends Rectangle {

	public int yVelocity;
	public int xVelocity;
	public final int SPEED = 3;

	// the key
	public ImageIcon keyIcon;
	public Image keyImage;
	public static final int KEY_WIDTH = 516 / 7;
	public static final int KEY_HEIGHT = 483 / 7;

	public KeyPlayer() {
		super(0,0,KEY_WIDTH,KEY_HEIGHT);
		keyIcon = new ImageIcon("playerkey.png");
		keyImage = keyIcon.getImage();
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D') {
			setXDirection(SPEED);
			move();
		}

		if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
			setXDirection(SPEED * -1);
			move();
		}

		if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W') {
			setYDirection(SPEED * -1);
			move();
		}

		if (e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
			setYDirection(SPEED);
			move();
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D') {
			setXDirection(0);
			move();
		}

		if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A') {
			setXDirection(0);
			move();
		}

		if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W') {
			setYDirection(0);
			move();
		}

		if (e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
			setYDirection(0);
			move();
		}
	}

	public void setYDirection(int yDirection) {
		yVelocity = yDirection;
	}

	public void setXDirection(int xDirection) {
		xVelocity = xDirection;
	}

	public void move() {
		y = y + yVelocity;
		x = x + xVelocity;

	}
	
	public void checkCollision() {
		if (y <= 0) {
			y = 0;
		}
		if (y >= GamePanel.GAME_HEIGHT - KEY_HEIGHT) {
			y = GamePanel.GAME_HEIGHT - KEY_HEIGHT;
		}
		if (x <= 0) {
			x = 0;
		}
		if (x + KEY_WIDTH >= GamePanel.GAME_WIDTH) {
			x = GamePanel.GAME_WIDTH - KEY_WIDTH;
		}
	}

	public void draw(Graphics g) {
		g.drawImage(keyImage, x, y, KEY_WIDTH, KEY_HEIGHT, null);
	}
	
	

}// end of KeyPlayer class
