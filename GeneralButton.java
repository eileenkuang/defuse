import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GeneralButton extends Rectangle{
	
	Image unclicked;
	Image hovered;
	int buttonWidth;
	int buttonHeight;
	int xCoord;
	int yCoord;

	public GeneralButton(int x, int y, int width, int height, Image unclick, Image hover) {
		super(x, y, width, height);
		unclicked=unclick;
		hovered=hover;
		buttonWidth=width;
		buttonHeight=height;
		xCoord=x;
		yCoord=y;
	}
	
	public GeneralButton(int x, int y, int w, int h, Image img) {
		super(x,y,w,h);
		unclicked=img;
		xCoord=x;
		yCoord=y;
		buttonWidth=w;
		buttonHeight=h;
	}

	public void draw(Graphics g, boolean hovering) {
		if (hovering) {
			g.drawImage(hovered, xCoord, yCoord, buttonWidth, buttonHeight, null);
		}
		else {
			g.drawImage(unclicked, xCoord, yCoord, buttonWidth, buttonHeight, null);
		}
			
	}

}// end of GeneralButton class
