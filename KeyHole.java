import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyHole extends Rectangle {
	
	//the key
	public ImageIcon keyIcon;
	public Image keyImage;
	public static final int HOLE_WIDTH=328/6;
	public static final int HOLE_HEIGHT=445/6;

	public KeyHole() {
		super(0,0,HOLE_WIDTH,HOLE_HEIGHT);
		keyIcon = new ImageIcon("keyhole.png");
		keyImage = keyIcon.getImage();
	}

	public void draw(Graphics g) {
		g.drawImage(keyImage, x, y, HOLE_WIDTH, HOLE_HEIGHT, null);
	}

}// end of KeyPlayer class
