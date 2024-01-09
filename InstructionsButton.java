import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InstructionsButton extends Rectangle {
	
	// variable declarations
	public ImageIcon ins= new ImageIcon("play.png");
	public Image insImage = ins.getImage();
	public ImageIcon hover =new ImageIcon("playhover.png");
	public Image hoverImage = hover.getImage();
	public static final int IN_WIDTH=500;
	public static final int IN_HEIGHT=500;

	public InstructionsButton() {
		
		super(0,0,IN_WIDTH,IN_HEIGHT);
		
	}

	public void draw(Graphics g) {
		
		if(GamePanel.onlyShowMainMenu) {
			
			g.drawImage(insImage, x, y, IN_WIDTH, IN_HEIGHT, null);
			
		}
		
	}

}// end of InstructionsButton class
