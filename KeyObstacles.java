//Authors: Eileen Kuang & Lillian Li
//Date: January 18, 2024
//Title: 7 Minute Meltdown (KeyObstacles class)
//Description: Is used to create rocks that fall during the KeyQuest Odyssey puzzle

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyObstacles extends Rectangle {

	//general variables
	public int speed = (int) (Math.random() * (12 - 4 + 1)) + 4;

	// the rock
	public ImageIcon keyIcon;
	public Image keyImage;
	public static final int OBSTACLE_WIDTH = 281 / 4;
	public static final int OBSTACLE_HEIGHT = 886 / 4;

	// Constructor
	public KeyObstacles() {
		super(0, 0, OBSTACLE_WIDTH, OBSTACLE_HEIGHT);
		keyIcon = new ImageIcon("keyobstacle.png");
		keyImage = keyIcon.getImage();
	}

	// Updates the position of the rocks onscreen
	public void move() {
		if (y >= GamePanel.GAME_HEIGHT) {
			y = 0 - ((int) (Math.random() * (700 - 443 + 1)) + 443);
			speed = (int) (Math.random() * (12 - 4 + 1)) + 4;
		} else {
			y = y + speed;
		}
	}

	// Draws to the screen
	public void draw(Graphics g) {
		g.drawImage(keyImage, x, y, OBSTACLE_WIDTH, OBSTACLE_HEIGHT, null); //draw the obstacle
	}

}
