import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;

public class CryptoMain {
	
	//miscellaneous variables
	int phrase;
	int cursorLocation=1;

	// the background
	public ImageIcon backgroundIcon=new ImageIcon("oldpaper.png");
	public Image backgroundImage= backgroundIcon.getImage();
	public final int BACKGROUND_WIDTH = GamePanel.GAME_WIDTH;
	public final int BACKGROUND_HEIGHT = GamePanel.GAME_HEIGHT;
	
	//the phrases
	public ImageIcon phrase1=new ImageIcon("crypto1.png");
	
	//all the keys (not being hovered)
	public CryptoKeyboard aHouse = new CryptoKeyboard(100, 450, "a-house.png");
	public CryptoKeyboard cPerson = new CryptoKeyboard(200,450,"c-person.png");
	public CryptoKeyboard dMail = new CryptoKeyboard(300,450,"d-mail.png");
	public CryptoKeyboard eSettings= new CryptoKeyboard(400,450,"e-settings.png");
	public CryptoKeyboard iHeart= new CryptoKeyboard(500,450,"i-heart.png");
	public CryptoKeyboard kStar = new CryptoKeyboard(600,450,"k-star.png");
	public CryptoKeyboard nProton = new CryptoKeyboard(700,450,"n-proton.png");
	public CryptoKeyboard oShopping= new CryptoKeyboard(800,450,"o-shopping.png");
	public CryptoKeyboard pLock= new CryptoKeyboard(300,550,"p-lock.png");
	public CryptoKeyboard rCall= new CryptoKeyboard(400,550,"r-call.png");
	public CryptoKeyboard sCap= new CryptoKeyboard(500,550,"s-cap.png");
	public CryptoKeyboard uBell= new CryptoKeyboard(600,550,"u-bell.png");
	
	//all the keys (being hovered)
	
	
	//whether the keys are hovered over
	public boolean aHover=false;
	public boolean cHover=false;
	public boolean dHover=false;
	public boolean eHover=false;
	public boolean iHover=false;
	public boolean kHover=false;
	public boolean nHover=false;
	public boolean oHover=false;
	public boolean pHover=false;
	public boolean rHover=false;
	public boolean sHover=false;
	public boolean uHover=false;
	
	//whether the keys are clicked
	public boolean aClick=false;
	public boolean cClick=false;
	public boolean dClick=false;
	public boolean eClick=false;
	public boolean iClick=false;
	public boolean kClick=false;
	public boolean nClick=false;
	public boolean oClick=false;
	public boolean pClick=false;
	public boolean rClick=false;
	public boolean sClick=false;
	public boolean uClick=false;

	public CryptoMain() {
		reset();
	}

	public void reset() {
		//generate a new phrase from 1 to 5
		phrase = (int) (Math.random()*(5-1+1))+1;
	}

	public void draw(Graphics g) {
		g.drawImage(backgroundImage, 0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null); // draw background
		
		//draw phrase
		if(phrase==1) {
			if(aClick) {//draw house symbol
				
			}
		}
		
		//draw symbols inputted by the user based on where their "cursor" is (region will light up)
		if(cursorLocation==1) {
			
		}
		
		//draw keys
		aHouse.draw(g);
		cPerson.draw(g);
		dMail.draw(g);
		eSettings.draw(g);
		iHeart.draw(g);
		kStar.draw(g);
		nProton.draw(g);
		oShopping.draw(g);
		pLock.draw(g);
		rCall.draw(g);
		sCap.draw(g);
		uBell.draw(g);
		
		//hovered keys
		if(aHover) {
			
		}
		
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
		if (aHouse.intersects(e.getX(), e.getY(), 1, 1)) {
			aClick=true;
			cClick=dClick=eClick=iClick=kClick=nClick=oClick=pClick=rClick=sClick=false;
		}

	}// end of mouseClicked method

	public void mouseReleased(MouseEvent e) {

	}// end of mouseReleased method

	public void mousePressed(MouseEvent e) {

	}// end of mousePressed method
	
	public void mouseDragged(MouseEvent e) {
		
	}
	
	public void mouseMoved(MouseEvent e) {
		if (aHouse.intersects(e.getX(), e.getY(), 1, 1)) {
			aHover=true;
			cHover=dHover=eHover=iHover=kHover=nHover=oHover=pHover=rHover=sHover=false;
		}
		else if (cPerson.intersects(e.getX(), e.getY(), 1, 1)) {
			
		}
	}

}
