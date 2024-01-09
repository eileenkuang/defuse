import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CryptoKeyboard extends Rectangle{

	//each key
	public ImageIcon keyIcon;
	public Image keyImage;
	public static final int KEY_WIDTH = (int)(236 / 2.5);
	public static final int KEY_HEIGHT = (int)(223 / 2.5);

	public CryptoKeyboard(int x, int y, String fileName) {
		super(x,y,KEY_WIDTH,KEY_HEIGHT);
		keyIcon = new ImageIcon(fileName);
		keyImage = keyIcon.getImage();
	}

	public void draw(Graphics g) {
		g.drawImage(keyImage, x, y, KEY_WIDTH, KEY_HEIGHT, null);
	}// end of draw method

	public void move() {

	}// end of move method

	public void keyPressed(KeyEvent e) {

	}// end of keyPressed method

	public void keyReleased(KeyEvent e) {

	}// end of keyReleased method

	public void keyTyped(KeyEvent e) {

	}// end of keyTyped method

	public void mouseEntered(MouseEvent e) {

	}// end of mouseEntered method

	public void mouseExited(MouseEvent e) {

	}// end of mouseExited method

	public void mouseClicked(MouseEvent e) {

	}// end of mouseClicked method

	public void mouseReleased(MouseEvent e) {

	}// end of mouseReleased method

	public void mousePressed(MouseEvent e) {

	}// end of mousePressed method
	
	public void mouseDragged(MouseEvent e) {
		
	}
	
	public void mouseMoved(MouseEvent e) {
		
	}

}
