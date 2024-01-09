import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BombButton extends Rectangle {

	public static final int BUTTON_WIDTH = (int) (547 / 1.6);
	public static final int BUTTON_HEIGHT = (int) (392 / 1.6);

	public Image unclickedImageRed;
	public Image hoveredImageRed;
	public Image unclickedImageGreen;
	public Image hoveredImageGreen;

	public BombButton(int x, int y, Image imageUnclickedRed, Image imageHoveredRed, Image imageUnclickedGreen, Image imageHoveredGreen) {
		super(x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
		unclickedImageRed = imageUnclickedRed;
		hoveredImageRed = imageHoveredRed;
		unclickedImageGreen = imageUnclickedGreen;
		hoveredImageGreen = imageHoveredGreen;
	}

	public void draw(Graphics g, boolean hovered, boolean solved) {
		if (hovered) {
			if(solved)
				g.drawImage(hoveredImageGreen, x, y, BUTTON_WIDTH, BUTTON_HEIGHT, null);
			else
				g.drawImage(hoveredImageRed, x, y, BUTTON_WIDTH, BUTTON_HEIGHT, null);
		}
		else {
			if(solved)
				g.drawImage(unclickedImageGreen, x, y, BUTTON_WIDTH, BUTTON_HEIGHT, null);
			else
				g.drawImage(unclickedImageRed, x, y, BUTTON_WIDTH, BUTTON_HEIGHT, null);
		}
			
	}

}// end of BombButton class
