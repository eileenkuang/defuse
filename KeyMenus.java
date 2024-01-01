import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class KeyMenus extends Rectangle{
	
	public ImageIcon hintIcon= new ImageIcon("keyHintReveal.png");
	public Image hintImage= hintIcon.getImage();
	
	public KeyMenus() {
		super(0, 0, GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT);
	}
	
	public void draw(Graphics g) {
		if(KeyMain.win) {
			g.setColor(new Color(64, 64, 64, 220)); // make it partially transparent
			g.fillRect(0, 0, GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT);
			
			g.setColor(new Color(117, 176, 192));
			g.setFont(new Font("Monospaced", Font.BOLD, 50));
			g.drawString("KEYQUEST ODYSSEY COMPLETE", GamePanel.GAME_WIDTH - 750, 600);
		}
		if(KeyMain.showHint) {			
			g.setColor(new Color(117, 176, 192));
			g.setFont(new Font("Monospaced", Font.BOLD, 50));
			g.drawImage(hintImage, 15, 70, (int)(925/5), (int)(161/5), null);
		}
		
	}

}
