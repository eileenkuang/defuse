import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QuitButton extends Rectangle {
	
	//the key
	public ImageIcon quitUnclickedIcon= new ImageIcon("quitunclicked.png");
	public Image quitUnclickedImage= quitUnclickedIcon.getImage();
	public ImageIcon quitHoveredIcon=new ImageIcon("quithovered.png");
	public Image quitHoveredImage=quitHoveredIcon.getImage();
	public static final int QUIT_WIDTH=418/3;
	public static final int QUIT_HEIGHT=151/3;

	public QuitButton() {
		super(0,0,QUIT_WIDTH,QUIT_HEIGHT);
	}

	public void draw(Graphics g) {
		if(GamePanel.onlyShowKey) {
			if(KeyMain.hoverQuit) {
				g.drawImage(quitHoveredImage, x, y, QUIT_WIDTH, QUIT_HEIGHT, null);
			}
			else {
				g.drawImage(quitUnclickedImage, x, y, QUIT_WIDTH, QUIT_HEIGHT, null);
			}
		}
		
		
	}

}// end of KeyPlayer class
