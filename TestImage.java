import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestImage extends Rectangle {

	public int speed = (int)(Math.random()*(12-4+1))+4;
	
	//the key
	public static final int OBSTACLE_WIDTH=281/4;
	public static final int OBSTACLE_HEIGHT=886/4;
	public int column;

	public TestImage() {
		super(0,0,OBSTACLE_WIDTH,OBSTACLE_HEIGHT);
	}

	public void move() {
		if(y>=GamePanel.GAME_HEIGHT) {
			y=0-((int)(Math.random()*(700-443+1))+443);
			speed=(int)(Math.random()*(12-4+1))+4;
		}
		else {
			y = y + speed;
		}
	}

	public void draw(Graphics g) {
	}

}// end of KeyPlayer class
