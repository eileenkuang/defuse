import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyHint extends Rectangle {
	
	//the key
	public ImageIcon hintUnclickedIcon= new ImageIcon("hintunclicked.png");
	public Image hintUnclickedImage= hintUnclickedIcon.getImage();
	public ImageIcon hintHoveredIcon=new ImageIcon("hinthovered.png");
	public Image hintHoveredImage=hintHoveredIcon.getImage();
	public ImageIcon hintUsedIcon=new ImageIcon("hintused.png");
	public Image hintUsedImage=hintUsedIcon.getImage();
	public static final int HINT_WIDTH=418/3;
	public static final int HINT_HEIGHT=151/3;

	public KeyHint() {
		super(0,0,HINT_WIDTH,HINT_HEIGHT);
	}

	public void draw(Graphics g) {
		if(KeyMain.hintUsed) {
			g.drawImage(hintUsedImage, x, y, HINT_WIDTH, HINT_HEIGHT, null);
		}
		else if(KeyMain.hoverHint) {
			g.drawImage(hintHoveredImage, x, y, HINT_WIDTH, HINT_HEIGHT, null);
		}
		else {
			g.drawImage(hintUnclickedImage, x, y, HINT_WIDTH, HINT_HEIGHT, null);
		}
		
	}

}// end of KeyPlayer class
