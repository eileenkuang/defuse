import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PlayButton extends Rectangle {
	
	// variable declarations
	public ImageIcon play= new ImageIcon("play.png");
	public Image playImage = play.getImage();
	public ImageIcon hover =new ImageIcon("playhover.png");
	public Image hoverImage = hover.getImage();
	public static final int HINT_WIDTH=418/3;
	public static final int HINT_HEIGHT=151/3;

	public PlayButton() {
		super(0,0,HINT_WIDTH,HINT_HEIGHT);
	}

	public void draw(Graphics g) {
		
		if(GamePanel.onlyShowMainMenu) {
			
			g.drawImage(playImage, x, y, HINT_WIDTH, HINT_HEIGHT, null);
			
		}
		
	}

}// end of Playbutton class
