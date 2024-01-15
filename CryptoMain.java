//Authors: Eileen Kuang & Lillian Li
//Date: January 11, 2024
//Title: 7 Minute Meltdown (CryptoMain class)
//Description: Class that runs most of the CryptoCipher puzzle processes

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class CryptoMain {

	// hint and quit buttons
	public HintButton hint = new HintButton();
	public QuitButton quit = new QuitButton();

	// coordinates of symbols and spotlight for each cursor position
	public static int x1;
	public static int y1;
	public static int x2;
	public static int y2;
	public static int x3;
	public static int y3;
	public static int x4;
	public static int y4;
	public static int x5;
	public static int y5;
	public static int x6;
	public static int y6;

	// miscellaneous variables
	public static int phrase;
	public static int cursorLocation = 1;
	public static boolean showHint = false;
	public static boolean hoverHint = false;
	public static boolean hintUsed = false;
	public static boolean hoverQuit = false;

	// spotlight
	public CryptoSpotlight spotlight1;
	public CryptoSpotlight spotlight2;
	public CryptoSpotlight spotlight3;
	public CryptoSpotlight spotlight4;
	public CryptoSpotlight spotlight5;
	public CryptoSpotlight spotlight6;

	// the background
	public ImageIcon backgroundIcon = new ImageIcon("oldpaper.png");
	public Image backgroundImage = backgroundIcon.getImage();
	public final int BACKGROUND_WIDTH = GamePanel.GAME_WIDTH;
	public final int BACKGROUND_HEIGHT = GamePanel.GAME_HEIGHT;

	// the phrases
	public ImageIcon phrase1Icon = new ImageIcon("cryptophrase1.png");
	public Image phrase1 = phrase1Icon.getImage();
	public ImageIcon phrase2Icon = new ImageIcon("cryptophrase2.png");
	public Image phrase2 = phrase2Icon.getImage();

	// the symbols that appear on the screen
	public ImageIcon houseIcon = new ImageIcon("a-housesymbol.png");
	public Image house = houseIcon.getImage();
	public ImageIcon personIcon = new ImageIcon("c-personsymbol.png");
	public Image person = personIcon.getImage();
	public ImageIcon mailIcon = new ImageIcon("d-mailsymbol.png");
	public Image mail = mailIcon.getImage();
	public ImageIcon settingsIcon = new ImageIcon("e-settingssymbol.png");
	public Image settings = settingsIcon.getImage();
	public ImageIcon heartIcon = new ImageIcon("i-heartsymbol.png");
	public Image heart = heartIcon.getImage();
	public ImageIcon starIcon = new ImageIcon("k-starsymbol.png");
	public Image star = starIcon.getImage();
	public ImageIcon protonIcon = new ImageIcon("n-protonsymbol.png");
	public Image proton = protonIcon.getImage();
	public ImageIcon shoppingIcon = new ImageIcon("o-shoppingsymbol.png");
	public Image shopping = shoppingIcon.getImage();
	public ImageIcon lockIcon = new ImageIcon("p-locksymbol.png");
	public Image lock = lockIcon.getImage();
	public ImageIcon callIcon = new ImageIcon("r-callsymbol.png");
	public Image call = callIcon.getImage();
	public ImageIcon capIcon = new ImageIcon("s-capsymbol.png");
	public Image cap = capIcon.getImage();
	public ImageIcon bellIcon = new ImageIcon("u-bellsymbol.png");
	public Image bell = bellIcon.getImage();

	// all the keys
	public CryptoKeyboard aHouse = new CryptoKeyboard(100, 450, "a-house.png", "a-houseclicked.png");
	public CryptoKeyboard cPerson = new CryptoKeyboard(200, 450, "c-person.png", "c-personclicked.png");
	public CryptoKeyboard dMail = new CryptoKeyboard(300, 450, "d-mail.png", "d-mailclicked.png");
	public CryptoKeyboard eSettings = new CryptoKeyboard(400, 450, "e-settings.png", "e-settingsclicked.png");
	public CryptoKeyboard iHeart = new CryptoKeyboard(500, 450, "i-heart.png", "i-heartclicked.png");
	public CryptoKeyboard kStar = new CryptoKeyboard(600, 450, "k-star.png", "k-starclicked.png");
	public CryptoKeyboard nProton = new CryptoKeyboard(700, 450, "n-proton.png", "n-protonclicked.png");
	public CryptoKeyboard oShopping = new CryptoKeyboard(800, 450, "o-shopping.png", "o-shoppingclicked.png");
	public CryptoKeyboard pLock = new CryptoKeyboard(300, 550, "p-lock.png", "p-lockclicked.png");
	public CryptoKeyboard rCall = new CryptoKeyboard(400, 550, "r-call.png", "r-callclicked.png");
	public CryptoKeyboard sCap = new CryptoKeyboard(500, 550, "s-cap.png", "s-capclicked.png");
	public CryptoKeyboard uBell = new CryptoKeyboard(600, 550, "u-bell.png", "u-bellclicked.png");
	public CryptoKeyboard backspace = new CryptoKeyboard(700, 600, "cryptobackspace.png", "cryptobackspaceclicked.png");

	// all the keys (being hovered)

	// whether the keys are hovered over
	public boolean aHover = false;
	public boolean cHover = false;
	public boolean dHover = false;
	public boolean eHover = false;
	public boolean iHover = false;
	public boolean kHover = false;
	public boolean nHover = false;
	public boolean oHover = false;
	public boolean pHover = false;
	public boolean rHover = false;
	public boolean sHover = false;
	public boolean uHover = false;
	public boolean backspaceHover = false;

	// whether the keys are clicked
	public boolean[] aClick = new boolean[7];
	public boolean[] cClick = new boolean[7];
	public boolean[] dClick = new boolean[7];
	public boolean[] eClick = new boolean[7];
	public boolean[] iClick = new boolean[7];
	public boolean[] kClick = new boolean[7];
	public boolean[] nClick = new boolean[7];
	public boolean[] oClick = new boolean[7];
	public boolean[] pClick = new boolean[7];
	public boolean[] rClick = new boolean[7];
	public boolean[] sClick = new boolean[7];
	public boolean[] uClick = new boolean[7];
	public boolean[] backspaceClick = new boolean[7];

	// Constructor
	public CryptoMain() {
		reset();
	}

	// Resets (restarts) the game
	public void reset() {
		// generate a new phrase from 1 to 5
		phrase = (int) (Math.random() * (5 - 1 + 1)) + 1;
		phrase = 2; // for testing

		// set coordinates of each spot depending on the random phrase generated
		if (phrase == 1) {
			x1 = 430;
			y1 = 90;
			x2 = 770;
			y2 = 90;
			x3 = 100;
			y3 = 250;
			x4 = 180;
			y4 = 250;
			x5 = 330;
			y5 = 250;
			x6 = 750;
			y6 = 250;
		} else if (phrase == 2) {
			x1 = 125;
			y1 = 100;
			x2 = 350;
			y2 = 100;
			x3 = 630;
			y3 = 100;
			x4 = 710;
			y4 = 100;
			x5 = 535;
			y5 = 270;
			x6 = 680;
			y6 = 270;
		}
	}

	// Draws to the screen
	public void draw(Graphics g) {

		g.drawImage(backgroundImage, 0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null); // draw background

		// spotlights to show where the cursor is
		spotlight1 = new CryptoSpotlight(x1, y1);
		spotlight2 = new CryptoSpotlight(x2, y2);
		spotlight3 = new CryptoSpotlight(x3, y3);
		spotlight4 = new CryptoSpotlight(x4, y4);
		spotlight5 = new CryptoSpotlight(x5, y5);
		spotlight6 = new CryptoSpotlight(x6, y6);

		// draw spotlights
		spotlight1.draw(g, 1);
		spotlight2.draw(g, 2);
		spotlight3.draw(g, 3);
		spotlight4.draw(g, 4);
		spotlight5.draw(g, 5);
		spotlight6.draw(g, 6);

		// draw phrase and icons inputted by the user
		if (phrase == 1) {
			g.drawImage(phrase1, 90, 80, 818, 305, null); // draw phrase
		}
		else if(phrase==2) {
			g.drawImage(phrase2, 120, 80, 763, 327, null); // draw phrase
		}

		if (aClick[1])
			g.drawImage(house, x1, y1, 138 / 2, 138 / 2, null);
		else if (cClick[1])
			g.drawImage(person, x1, y1, 138 / 2, 138 / 2, null);
		else if (dClick[1])
			g.drawImage(mail, x1, y1, 138 / 2, 138 / 2, null);
		else if (eClick[1])
			g.drawImage(settings, x1, y1, 138 / 2, 138 / 2, null);
		else if (iClick[1])
			g.drawImage(heart, x1, y1, 138 / 2, 138 / 2, null);
		else if (kClick[1])
			g.drawImage(star, x1, y1, 138 / 2, 138 / 2, null);
		else if (nClick[1])
			g.drawImage(proton, x1, y1, 138 / 2, 138 / 2, null);
		else if (oClick[1])
			g.drawImage(shopping, x1, y1, 138 / 2, 138 / 2, null);
		else if (pClick[1])
			g.drawImage(lock, x1, y1, 138 / 2, 138 / 2, null);
		else if (rClick[1])
			g.drawImage(call, x1, y1, 138 / 2, 138 / 2, null);
		else if (sClick[1])
			g.drawImage(cap, x1, y1, 138 / 2, 138 / 2, null);
		else if (uClick[1])
			g.drawImage(bell, x1, y1, 138 / 2, 138 / 2, null);
		else if (backspaceClick[1]) {

		}
		if (aClick[2])
			g.drawImage(house, x2, y2, 138 / 2, 138 / 2, null);
		else if (cClick[2])
			g.drawImage(person, x2, y2, 138 / 2, 138 / 2, null);
		else if (dClick[2])
			g.drawImage(mail, x2, y2, 138 / 2, 138 / 2, null);
		else if (eClick[2])
			g.drawImage(settings, x2, y2, 138 / 2, 138 / 2, null);
		else if (iClick[2])
			g.drawImage(heart, x2, y2, 138 / 2, 138 / 2, null);
		else if (kClick[2])
			g.drawImage(star, x2, y2, 138 / 2, 138 / 2, null);
		else if (nClick[2])
			g.drawImage(proton, x2, y2, 138 / 2, 138 / 2, null);
		else if (oClick[2])
			g.drawImage(shopping, x2, y2, 138 / 2, 138 / 2, null);
		else if (pClick[2])
			g.drawImage(lock, x2, y2, 138 / 2, 138 / 2, null);
		else if (rClick[2])
			g.drawImage(call, x2, y2, 138 / 2, 138 / 2, null);
		else if (sClick[2])
			g.drawImage(cap, x2, y2, 138 / 2, 138 / 2, null);
		else if (uClick[2])
			g.drawImage(bell, x2, y2, 138 / 2, 138 / 2, null);
		else if (backspaceClick[2]) {

		}
		if (aClick[3])
			g.drawImage(house, x3, y3, 138 / 2, 138 / 2, null);
		else if (cClick[3])
			g.drawImage(person, x3, y3, 138 / 2, 138 / 2, null);
		else if (dClick[3])
			g.drawImage(mail, x3, y3, 138 / 2, 138 / 2, null);
		else if (eClick[3])
			g.drawImage(settings, x3, y3, 138 / 2, 138 / 2, null);
		else if (iClick[3])
			g.drawImage(heart, x3, y3, 138 / 2, 138 / 2, null);
		else if (kClick[3])
			g.drawImage(star, x3, y3, 138 / 2, 138 / 2, null);
		else if (nClick[3])
			g.drawImage(proton, x3, y3, 138 / 2, 138 / 2, null);
		else if (oClick[3])
			g.drawImage(shopping, x3, y3, 138 / 2, 138 / 2, null);
		else if (pClick[3])
			g.drawImage(lock, x3, y3, 138 / 2, 138 / 2, null);
		else if (rClick[3])
			g.drawImage(call, x3, y3, 138 / 2, 138 / 2, null);
		else if (sClick[3])
			g.drawImage(cap, x3, y3, 138 / 2, 138 / 2, null);
		else if (uClick[3])
			g.drawImage(bell, x3, y3, 138 / 2, 138 / 2, null);
		else if (backspaceClick[3]) {

		}
		if (aClick[4])
			g.drawImage(house, x4, y4, 138 / 2, 138 / 2, null);
		else if (cClick[4])
			g.drawImage(person, x4, y4, 138 / 2, 138 / 2, null);
		else if (dClick[4])
			g.drawImage(mail, x4, y4, 138 / 2, 138 / 2, null);
		else if (eClick[4])
			g.drawImage(settings, x4, y4, 138 / 2, 138 / 2, null);
		else if (iClick[4])
			g.drawImage(heart, x4, y4, 138 / 2, 138 / 2, null);
		else if (kClick[4])
			g.drawImage(star, x4, y4, 138 / 2, 138 / 2, null);
		else if (nClick[4])
			g.drawImage(proton, x4, y4, 138 / 2, 138 / 2, null);
		else if (oClick[4])
			g.drawImage(shopping, x4, y4, 138 / 2, 138 / 2, null);
		else if (pClick[4])
			g.drawImage(lock, x4, y4, 138 / 2, 138 / 2, null);
		else if (rClick[4])
			g.drawImage(call, x4, y4, 138 / 2, 138 / 2, null);
		else if (sClick[4])
			g.drawImage(cap, x4, y4, 138 / 2, 138 / 2, null);
		else if (uClick[4])
			g.drawImage(bell, x4, y4, 138 / 2, 138 / 2, null);
		else if (backspaceClick[4]) {

		}
		if (aClick[5])
			g.drawImage(house, x5, y5, 138 / 2, 138 / 2, null);
		else if (cClick[5])
			g.drawImage(person, x5, y5, 138 / 2, 138 / 2, null);
		else if (dClick[5])
			g.drawImage(mail, x5, y5, 138 / 2, 138 / 2, null);
		else if (eClick[5])
			g.drawImage(settings, x5, y5, 138 / 2, 138 / 2, null);
		else if (iClick[5])
			g.drawImage(heart, x5, y5, 138 / 2, 138 / 2, null);
		else if (kClick[5])
			g.drawImage(star, x5, y5, 138 / 2, 138 / 2, null);
		else if (nClick[5])
			g.drawImage(proton, x5, y5, 138 / 2, 138 / 2, null);
		else if (oClick[5])
			g.drawImage(shopping, x5, y5, 138 / 2, 138 / 2, null);
		else if (pClick[5])
			g.drawImage(lock, x5, y5, 138 / 2, 138 / 2, null);
		else if (rClick[5])
			g.drawImage(call, x5, y5, 138 / 2, 138 / 2, null);
		else if (sClick[5])
			g.drawImage(cap, x5, y5, 138 / 2, 138 / 2, null);
		else if (uClick[5])
			g.drawImage(bell, x5, y5, 138 / 2, 138 / 2, null);
		else if (backspaceClick[5]) {

		}
		if (aClick[6])
			g.drawImage(house, x6, y6, 138 / 2, 138 / 2, null);
		else if (cClick[6])
			g.drawImage(person, x6, y6, 138 / 2, 138 / 2, null);
		else if (dClick[6])
			g.drawImage(mail, x6, y6, 138 / 2, 138 / 2, null);
		else if (eClick[6])
			g.drawImage(settings, x6, y6, 138 / 2, 138 / 2, null);
		else if (iClick[6])
			g.drawImage(heart, x6, y6, 138 / 2, 138 / 2, null);
		else if (kClick[6])
			g.drawImage(star, x6, y6, 138 / 2, 138 / 2, null);
		else if (nClick[6])
			g.drawImage(proton, x6, y6, 138 / 2, 138 / 2, null);
		else if (oClick[6])
			g.drawImage(shopping, x6, y6, 138 / 2, 138 / 2, null);
		else if (pClick[6])
			g.drawImage(lock, x6, y6, 138 / 2, 138 / 2, null);
		else if (rClick[6])
			g.drawImage(call, x6, y6, 138 / 2, 138 / 2, null);
		else if (sClick[6])
			g.drawImage(cap, x6, y6, 138 / 2, 138 / 2, null);
		else if (uClick[6])
			g.drawImage(bell, x6, y6, 138 / 2, 138 / 2, null);
		else if (backspaceClick[6]) {

		}

		// draw keys
		aHouse.draw(g, aHover);
		cPerson.draw(g, cHover);
		dMail.draw(g, dHover);
		eSettings.draw(g, eHover);
		iHeart.draw(g, iHover);
		kStar.draw(g, kHover);
		nProton.draw(g, nHover);
		oShopping.draw(g, oHover);
		pLock.draw(g, pHover);
		rCall.draw(g, rHover);
		sCap.draw(g, sHover);
		uBell.draw(g, uHover);
		backspace.draw(g, backspaceHover);
		
		hint.draw(g, hintUsed);
		quit.draw(g);

		if (BombMenu.solveCrypto) {
			g.setColor(new Color(64, 64, 64, 220)); // make it partially transparent
			g.fillRect(0, 0, GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT);

			g.setColor(new Color(117, 176, 192));
			g.setFont(new Font("Monospaced", Font.BOLD, 50));
			g.drawString("CRYPTOCIPHER COMPLETE", GamePanel.GAME_WIDTH - 750, 600);
		}
		if (showHint) {
			g.setColor(new Color(117, 176, 192));
			g.setFont(new Font("Monospaced", Font.BOLD, 50));
		}

	}// end of draw method

	// Moves any moving graphics
	public void move() {

	}// end of move method

	// Detects key presses
	public void keyPressed(KeyEvent e) {

	}// end of keyPressed method

	// Detects key releases
	public void keyReleased(KeyEvent e) {

	}// end of keyReleased method

	// Detects typed keys
	public void keyTyped(KeyEvent e) {

	}// end of keyTyped method

	// Detects the mouse entering the screen
	public void mouseEntered(MouseEvent e) {

	}// end of mouseEntered method

	// Detects the mouse exiting the screen
	public void mouseExited(MouseEvent e) {

	}// end of mouseExited method

	// Detects the mouse clicking the screen
	public void mouseClicked(MouseEvent e) {
		if (hint.intersects(e.getX(), e.getY(), 1, 1)) {
			hintUsed = true;
			showHint = true;
		}
		if (quit.intersects(e.getX(), e.getY(), 1, 1)) {
			GamePanel.onlyShowCrypto = false;
			GamePanel.onlyShowBombMenu = true;
			// ensures that buttons reset
			hoverQuit = false;
			hoverHint = false;
		}

		// change variables based on which icon is clicked on the screen
		if (cursorLocation == 1) {
			if (aHouse.intersects(e.getX(), e.getY(), 1, 1)) {
				aClick[1] = true;
				cClick[1] = dClick[1] = eClick[1] = iClick[1] = kClick[1] = nClick[1] = oClick[1] = pClick[1] = rClick[1] = sClick[1] = uClick[1] = backspaceClick[1] = false;
			}
			if (cPerson.intersects(e.getX(), e.getY(), 1, 1)) {
				cClick[1] = true;
				aClick[1] = dClick[1] = eClick[1] = iClick[1] = kClick[1] = nClick[1] = oClick[1] = pClick[1] = rClick[1] = sClick[1] = uClick[1] = backspaceClick[1] = false;
			}
			if (dMail.intersects(e.getX(), e.getY(), 1, 1)) {
				dClick[1] = true;
				aClick[1] = cClick[1] = eClick[1] = iClick[1] = kClick[1] = nClick[1] = oClick[1] = pClick[1] = rClick[1] = sClick[1] = uClick[1] = backspaceClick[1] = false;
			}
			if (eSettings.intersects(e.getX(), e.getY(), 1, 1)) {
				eClick[1] = true;
				aClick[1] = cClick[1] = dClick[1] = iClick[1] = kClick[1] = nClick[1] = oClick[1] = pClick[1] = rClick[1] = sClick[1] = uClick[1] = backspaceClick[1] = false;
			}
			if (iHeart.intersects(e.getX(), e.getY(), 1, 1)) {
				iClick[1] = true;
				aClick[1] = cClick[1] = dClick[1] = eClick[1] = kClick[1] = nClick[1] = oClick[1] = pClick[1] = rClick[1] = sClick[1] = uClick[1] = backspaceClick[1] = false;
			}
			if (kStar.intersects(e.getX(), e.getY(), 1, 1)) {
				kClick[1] = true;
				aClick[1] = cClick[1] = dClick[1] = eClick[1] = iClick[1] = nClick[1] = oClick[1] = pClick[1] = rClick[1] = sClick[1] = uClick[1] = backspaceClick[1] = false;
			}
			if (nProton.intersects(e.getX(), e.getY(), 1, 1)) {
				nClick[1] = true;
				aClick[1] = cClick[1] = dClick[1] = eClick[1] = iClick[1] = kClick[1] = oClick[1] = pClick[1] = rClick[1] = sClick[1] = uClick[1] = backspaceClick[1] = false;
			}
			if (oShopping.intersects(e.getX(), e.getY(), 1, 1)) {
				oClick[1] = true;
				aClick[1] = cClick[1] = dClick[1] = eClick[1] = iClick[1] = kClick[1] = nClick[1] = pClick[1] = rClick[1] = sClick[1] = uClick[1] = backspaceClick[1] = false;
			}
			if (pLock.intersects(e.getX(), e.getY(), 1, 1)) {
				pClick[1] = true;
				aClick[1] = cClick[1] = dClick[1] = eClick[1] = iClick[1] = kClick[1] = nClick[1] = oClick[1] = rClick[1] = sClick[1] = uClick[1] = backspaceClick[1] = false;
			}
			if (rCall.intersects(e.getX(), e.getY(), 1, 1)) {
				rClick[1] = true;
				aClick[1] = cClick[1] = dClick[1] = eClick[1] = iClick[1] = kClick[1] = nClick[1] = oClick[1] = pClick[1] = sClick[1] = uClick[1] = backspaceClick[1] = false;
			}
			if (sCap.intersects(e.getX(), e.getY(), 1, 1)) {
				sClick[1] = true;
				aClick[1] = cClick[1] = dClick[1] = eClick[1] = iClick[1] = kClick[1] = nClick[1] = oClick[1] = pClick[1] = rClick[1] = uClick[1] = backspaceClick[1] = false;
			}
			if (uBell.intersects(e.getX(), e.getY(), 1, 1)) {
				uClick[1] = true;
				aClick[1] = cClick[1] = dClick[1] = eClick[1] = iClick[1] = kClick[1] = nClick[1] = oClick[1] = pClick[1] = rClick[1] = sClick[1] = backspaceClick[1] = false;
			}
			if (backspace.intersects(e.getX(), e.getY(), 1, 1)) {
				backspaceClick[1] = true;
				aClick[1] = cClick[1] = dClick[1] = eClick[1] = iClick[1] = kClick[1] = nClick[1] = oClick[1] = pClick[1] = rClick[1] = sClick[1] = uClick[1] = false;
			}
		} else if (cursorLocation == 2) {
			if (aHouse.intersects(e.getX(), e.getY(), 1, 1)) {
				aClick[2] = true;
				cClick[2] = dClick[2] = eClick[2] = iClick[2] = kClick[2] = nClick[2] = oClick[2] = pClick[2] = rClick[2] = sClick[2] = uClick[2] = backspaceClick[2] = false;
			}
			if (cPerson.intersects(e.getX(), e.getY(), 1, 1)) {
				cClick[2] = true;
				aClick[2] = dClick[2] = eClick[2] = iClick[2] = kClick[2] = nClick[2] = oClick[2] = pClick[2] = rClick[2] = sClick[2] = uClick[2] = backspaceClick[2] = false;
			}
			if (dMail.intersects(e.getX(), e.getY(), 1, 1)) {
				dClick[2] = true;
				aClick[2] = cClick[2] = eClick[2] = iClick[2] = kClick[2] = nClick[2] = oClick[2] = pClick[2] = rClick[2] = sClick[2] = uClick[2] = backspaceClick[2] = false;
			}
			if (eSettings.intersects(e.getX(), e.getY(), 1, 1)) {
				eClick[2] = true;
				aClick[2] = cClick[2] = dClick[2] = iClick[2] = kClick[2] = nClick[2] = oClick[2] = pClick[2] = rClick[2] = sClick[2] = uClick[2] = backspaceClick[2] = false;
			}
			if (iHeart.intersects(e.getX(), e.getY(), 1, 1)) {
				iClick[2] = true;
				aClick[2] = cClick[2] = dClick[2] = eClick[2] = kClick[2] = nClick[2] = oClick[2] = pClick[2] = rClick[2] = sClick[2] = uClick[2] = backspaceClick[2] = false;
			}
			if (kStar.intersects(e.getX(), e.getY(), 1, 1)) {
				kClick[2] = true;
				aClick[2] = cClick[2] = dClick[2] = eClick[2] = iClick[2] = nClick[2] = oClick[2] = pClick[2] = rClick[2] = sClick[2] = uClick[2] = backspaceClick[2] = false;
			}
			if (nProton.intersects(e.getX(), e.getY(), 1, 1)) {
				nClick[2] = true;
				aClick[2] = cClick[2] = dClick[2] = eClick[2] = iClick[2] = kClick[2] = oClick[2] = pClick[2] = rClick[2] = sClick[2] = uClick[2] = backspaceClick[2] = false;
			}
			if (oShopping.intersects(e.getX(), e.getY(), 1, 1)) {
				oClick[2] = true;
				aClick[2] = cClick[2] = dClick[2] = eClick[2] = iClick[2] = kClick[2] = nClick[2] = pClick[2] = rClick[2] = sClick[2] = uClick[2] = backspaceClick[2] = false;
			}
			if (pLock.intersects(e.getX(), e.getY(), 1, 1)) {
				pClick[2] = true;
				aClick[2] = cClick[2] = dClick[2] = eClick[2] = iClick[2] = kClick[2] = nClick[2] = oClick[2] = rClick[2] = sClick[2] = uClick[2] = backspaceClick[2] = false;
			}
			if (rCall.intersects(e.getX(), e.getY(), 1, 1)) {
				rClick[2] = true;
				aClick[2] = cClick[2] = dClick[2] = eClick[2] = iClick[2] = kClick[2] = nClick[2] = oClick[2] = pClick[2] = sClick[2] = uClick[2] = backspaceClick[2] = false;
			}
			if (sCap.intersects(e.getX(), e.getY(), 1, 1)) {
				sClick[2] = true;
				aClick[2] = cClick[2] = dClick[2] = eClick[2] = iClick[2] = kClick[2] = nClick[2] = oClick[2] = pClick[2] = rClick[2] = uClick[2] = backspaceClick[2] = false;
			}
			if (uBell.intersects(e.getX(), e.getY(), 1, 1)) {
				uClick[2] = true;
				aClick[2] = cClick[2] = dClick[2] = eClick[2] = iClick[2] = kClick[2] = nClick[2] = oClick[2] = pClick[2] = rClick[2] = sClick[2] = backspaceClick[2] = false;
			}
			if (backspace.intersects(e.getX(), e.getY(), 1, 1)) {
				backspaceClick[2] = true;
				aClick[2] = cClick[2] = dClick[2] = eClick[2] = iClick[2] = kClick[2] = nClick[2] = oClick[2] = pClick[2] = rClick[2] = sClick[2] = uClick[2] = false;
			}
		} else if (cursorLocation == 3) {
			if (aHouse.intersects(e.getX(), e.getY(), 1, 1)) {
				aClick[3] = true;
				cClick[3] = dClick[3] = eClick[3] = iClick[3] = kClick[3] = nClick[3] = oClick[3] = pClick[3] = rClick[3] = sClick[3] = uClick[3] = backspaceClick[3] = false;
			}
			if (cPerson.intersects(e.getX(), e.getY(), 1, 1)) {
				cClick[3] = true;
				aClick[3] = dClick[3] = eClick[3] = iClick[3] = kClick[3] = nClick[3] = oClick[3] = pClick[3] = rClick[3] = sClick[3] = uClick[3] = backspaceClick[3] = false;
			}
			if (dMail.intersects(e.getX(), e.getY(), 1, 1)) {
				dClick[3] = true;
				aClick[3] = cClick[3] = eClick[3] = iClick[3] = kClick[3] = nClick[3] = oClick[3] = pClick[3] = rClick[3] = sClick[3] = uClick[3] = backspaceClick[3] = false;
			}
			if (eSettings.intersects(e.getX(), e.getY(), 1, 1)) {
				eClick[3] = true;
				aClick[3] = cClick[3] = dClick[3] = iClick[3] = kClick[3] = nClick[3] = oClick[3] = pClick[3] = rClick[3] = sClick[3] = uClick[3] = backspaceClick[3] = false;
			}
			if (iHeart.intersects(e.getX(), e.getY(), 1, 1)) {
				iClick[3] = true;
				aClick[3] = cClick[3] = dClick[3] = eClick[3] = kClick[3] = nClick[3] = oClick[3] = pClick[3] = rClick[3] = sClick[3] = uClick[3] = backspaceClick[3] = false;
			}
			if (kStar.intersects(e.getX(), e.getY(), 1, 1)) {
				kClick[3] = true;
				aClick[3] = cClick[3] = dClick[3] = eClick[3] = iClick[3] = nClick[3] = oClick[3] = pClick[3] = rClick[3] = sClick[3] = uClick[3] = backspaceClick[3] = false;
			}
			if (nProton.intersects(e.getX(), e.getY(), 1, 1)) {
				nClick[3] = true;
				aClick[3] = cClick[3] = dClick[3] = eClick[3] = iClick[3] = kClick[3] = oClick[3] = pClick[3] = rClick[3] = sClick[3] = uClick[3] = backspaceClick[3] = false;
			}
			if (oShopping.intersects(e.getX(), e.getY(), 1, 1)) {
				oClick[3] = true;
				aClick[3] = cClick[3] = dClick[3] = eClick[3] = iClick[3] = kClick[3] = nClick[3] = pClick[3] = rClick[3] = sClick[3] = uClick[3] = backspaceClick[3] = false;
			}
			if (pLock.intersects(e.getX(), e.getY(), 1, 1)) {
				pClick[3] = true;
				aClick[3] = cClick[3] = dClick[3] = eClick[3] = iClick[3] = kClick[3] = nClick[3] = oClick[3] = rClick[3] = sClick[3] = uClick[3] = backspaceClick[3] = false;
			}
			if (rCall.intersects(e.getX(), e.getY(), 1, 1)) {
				rClick[3] = true;
				aClick[3] = cClick[3] = dClick[3] = eClick[3] = iClick[3] = kClick[3] = nClick[3] = oClick[3] = pClick[3] = sClick[3] = uClick[3] = backspaceClick[3] = false;
			}
			if (sCap.intersects(e.getX(), e.getY(), 1, 1)) {
				sClick[3] = true;
				aClick[3] = cClick[3] = dClick[3] = eClick[3] = iClick[3] = kClick[3] = nClick[3] = oClick[3] = pClick[3] = rClick[3] = uClick[3] = backspaceClick[3] = false;
			}
			if (uBell.intersects(e.getX(), e.getY(), 1, 1)) {
				uClick[3] = true;
				aClick[3] = cClick[3] = dClick[3] = eClick[3] = iClick[3] = kClick[3] = nClick[3] = oClick[3] = pClick[3] = rClick[3] = sClick[3] = backspaceClick[3] = false;
			}
			if (backspace.intersects(e.getX(), e.getY(), 1, 1)) {
				backspaceClick[3] = true;
				aClick[3] = cClick[3] = dClick[3] = eClick[3] = iClick[3] = kClick[3] = nClick[3] = oClick[3] = pClick[3] = rClick[3] = sClick[3] = uClick[3] = false;
			}
		} else if (cursorLocation == 4) {
			if (aHouse.intersects(e.getX(), e.getY(), 1, 1)) {
				aClick[4] = true;
				cClick[4] = dClick[4] = eClick[4] = iClick[4] = kClick[4] = nClick[4] = oClick[4] = pClick[4] = rClick[4] = sClick[4] = uClick[4] = backspaceClick[4] = false;
			}
			if (cPerson.intersects(e.getX(), e.getY(), 1, 1)) {
				cClick[4] = true;
				aClick[4] = dClick[4] = eClick[4] = iClick[4] = kClick[4] = nClick[4] = oClick[4] = pClick[4] = rClick[4] = sClick[4] = uClick[4] = backspaceClick[4] = false;
			}
			if (dMail.intersects(e.getX(), e.getY(), 1, 1)) {
				dClick[4] = true;
				aClick[4] = cClick[4] = eClick[4] = iClick[4] = kClick[4] = nClick[4] = oClick[4] = pClick[4] = rClick[4] = sClick[4] = uClick[4] = backspaceClick[4] = false;
			}
			if (eSettings.intersects(e.getX(), e.getY(), 1, 1)) {
				eClick[4] = true;
				aClick[4] = cClick[4] = dClick[4] = iClick[4] = kClick[4] = nClick[4] = oClick[4] = pClick[4] = rClick[4] = sClick[4] = uClick[4] = backspaceClick[4] = false;
			}
			if (iHeart.intersects(e.getX(), e.getY(), 1, 1)) {
				iClick[4] = true;
				aClick[4] = cClick[4] = dClick[4] = eClick[4] = kClick[4] = nClick[4] = oClick[4] = pClick[4] = rClick[4] = sClick[4] = uClick[4] = backspaceClick[4] = false;
			}
			if (kStar.intersects(e.getX(), e.getY(), 1, 1)) {
				kClick[4] = true;
				aClick[4] = cClick[4] = dClick[4] = eClick[4] = iClick[4] = nClick[4] = oClick[4] = pClick[4] = rClick[4] = sClick[4] = uClick[4] = backspaceClick[4] = false;
			}
			if (nProton.intersects(e.getX(), e.getY(), 1, 1)) {
				nClick[4] = true;
				aClick[4] = cClick[4] = dClick[4] = eClick[4] = iClick[4] = kClick[4] = oClick[4] = pClick[4] = rClick[4] = sClick[4] = uClick[4] = backspaceClick[4] = false;
			}
			if (oShopping.intersects(e.getX(), e.getY(), 1, 1)) {
				oClick[4] = true;
				aClick[4] = cClick[4] = dClick[4] = eClick[4] = iClick[4] = kClick[4] = nClick[4] = pClick[4] = rClick[4] = sClick[4] = uClick[4] = backspaceClick[4] = false;
			}
			if (pLock.intersects(e.getX(), e.getY(), 1, 1)) {
				pClick[4] = true;
				aClick[4] = cClick[4] = dClick[4] = eClick[4] = iClick[4] = kClick[4] = nClick[4] = oClick[4] = rClick[4] = sClick[4] = uClick[4] = backspaceClick[4] = false;
			}
			if (rCall.intersects(e.getX(), e.getY(), 1, 1)) {
				rClick[4] = true;
				aClick[4] = cClick[4] = dClick[4] = eClick[4] = iClick[4] = kClick[4] = nClick[4] = oClick[4] = pClick[4] = sClick[4] = uClick[4] = backspaceClick[4] = false;
			}
			if (sCap.intersects(e.getX(), e.getY(), 1, 1)) {
				sClick[4] = true;
				aClick[4] = cClick[4] = dClick[4] = eClick[4] = iClick[4] = kClick[4] = nClick[4] = oClick[4] = pClick[4] = rClick[4] = uClick[4] = backspaceClick[4] = false;
			}
			if (uBell.intersects(e.getX(), e.getY(), 1, 1)) {
				uClick[4] = true;
				aClick[4] = cClick[4] = dClick[4] = eClick[4] = iClick[4] = kClick[4] = nClick[4] = oClick[4] = pClick[4] = rClick[4] = sClick[4] = backspaceClick[4] = false;
			}
			if (backspace.intersects(e.getX(), e.getY(), 1, 1)) {
				backspaceClick[4] = true;
				aClick[4] = cClick[4] = dClick[4] = eClick[4] = iClick[4] = kClick[4] = nClick[4] = oClick[4] = pClick[4] = rClick[4] = sClick[4] = uClick[4] = false;
			}
		} else if (cursorLocation == 5) {
			if (aHouse.intersects(e.getX(), e.getY(), 1, 1)) {
				aClick[5] = true;
				cClick[5] = dClick[5] = eClick[5] = iClick[5] = kClick[5] = nClick[5] = oClick[5] = pClick[5] = rClick[5] = sClick[5] = uClick[5] = backspaceClick[5] = false;
			}
			if (cPerson.intersects(e.getX(), e.getY(), 1, 1)) {
				cClick[5] = true;
				aClick[5] = dClick[5] = eClick[5] = iClick[5] = kClick[5] = nClick[5] = oClick[5] = pClick[5] = rClick[5] = sClick[5] = uClick[5] = backspaceClick[5] = false;
			}
			if (dMail.intersects(e.getX(), e.getY(), 1, 1)) {
				dClick[5] = true;
				aClick[5] = cClick[5] = eClick[5] = iClick[5] = kClick[5] = nClick[5] = oClick[5] = pClick[5] = rClick[5] = sClick[5] = uClick[5] = backspaceClick[5] = false;
			}
			if (eSettings.intersects(e.getX(), e.getY(), 1, 1)) {
				eClick[5] = true;
				aClick[5] = cClick[5] = dClick[5] = iClick[5] = kClick[5] = nClick[5] = oClick[5] = pClick[5] = rClick[5] = sClick[5] = uClick[5] = backspaceClick[5] = false;
			}
			if (iHeart.intersects(e.getX(), e.getY(), 1, 1)) {
				iClick[5] = true;
				aClick[5] = cClick[5] = dClick[5] = eClick[5] = kClick[5] = nClick[5] = oClick[5] = pClick[5] = rClick[5] = sClick[5] = uClick[5] = backspaceClick[5] = false;
			}
			if (kStar.intersects(e.getX(), e.getY(), 1, 1)) {
				kClick[5] = true;
				aClick[5] = cClick[5] = dClick[5] = eClick[5] = iClick[5] = nClick[5] = oClick[5] = pClick[5] = rClick[5] = sClick[5] = uClick[5] = backspaceClick[5] = false;
			}
			if (nProton.intersects(e.getX(), e.getY(), 1, 1)) {
				nClick[5] = true;
				aClick[5] = cClick[5] = dClick[5] = eClick[5] = iClick[5] = kClick[5] = oClick[5] = pClick[5] = rClick[5] = sClick[5] = uClick[5] = backspaceClick[5] = false;
			}
			if (oShopping.intersects(e.getX(), e.getY(), 1, 1)) {
				oClick[5] = true;
				aClick[5] = cClick[5] = dClick[5] = eClick[5] = iClick[5] = kClick[5] = nClick[5] = pClick[5] = rClick[5] = sClick[5] = uClick[5] = backspaceClick[5] = false;
			}
			if (pLock.intersects(e.getX(), e.getY(), 1, 1)) {
				pClick[5] = true;
				aClick[5] = cClick[5] = dClick[5] = eClick[5] = iClick[5] = kClick[5] = nClick[5] = oClick[5] = rClick[5] = sClick[5] = uClick[5] = backspaceClick[5] = false;
			}
			if (rCall.intersects(e.getX(), e.getY(), 1, 1)) {
				rClick[5] = true;
				aClick[5] = cClick[5] = dClick[5] = eClick[5] = iClick[5] = kClick[5] = nClick[5] = oClick[5] = pClick[5] = sClick[5] = uClick[5] = backspaceClick[5] = false;
			}
			if (sCap.intersects(e.getX(), e.getY(), 1, 1)) {
				sClick[5] = true;
				aClick[5] = cClick[5] = dClick[5] = eClick[5] = iClick[5] = kClick[5] = nClick[5] = oClick[5] = pClick[5] = rClick[5] = uClick[5] = backspaceClick[5] = false;
			}
			if (uBell.intersects(e.getX(), e.getY(), 1, 1)) {
				uClick[5] = true;
				aClick[5] = cClick[5] = dClick[5] = eClick[5] = iClick[5] = kClick[5] = nClick[5] = oClick[5] = pClick[5] = rClick[5] = sClick[5] = backspaceClick[5] = false;
			}
			if (backspace.intersects(e.getX(), e.getY(), 1, 1)) {
				backspaceClick[5] = true;
				aClick[5] = cClick[5] = dClick[5] = eClick[5] = iClick[5] = kClick[5] = nClick[5] = oClick[5] = pClick[5] = rClick[5] = sClick[5] = uClick[5] = false;
			}
		} else if (cursorLocation == 6) {
			if (aHouse.intersects(e.getX(), e.getY(), 1, 1)) {
				aClick[6] = true;
				cClick[6] = dClick[6] = eClick[6] = iClick[6] = kClick[6] = nClick[6] = oClick[6] = pClick[6] = rClick[6] = sClick[6] = uClick[6] = backspaceClick[6] = false;
			}
			if (cPerson.intersects(e.getX(), e.getY(), 1, 1)) {
				cClick[6] = true;
				aClick[6] = dClick[6] = eClick[6] = iClick[6] = kClick[6] = nClick[6] = oClick[6] = pClick[6] = rClick[6] = sClick[6] = uClick[6] = backspaceClick[6] = false;
			}
			if (dMail.intersects(e.getX(), e.getY(), 1, 1)) {
				dClick[6] = true;
				aClick[6] = cClick[6] = eClick[6] = iClick[6] = kClick[6] = nClick[6] = oClick[6] = pClick[6] = rClick[6] = sClick[6] = uClick[6] = backspaceClick[6] = false;
			}
			if (eSettings.intersects(e.getX(), e.getY(), 1, 1)) {
				eClick[6] = true;
				aClick[6] = cClick[6] = dClick[6] = iClick[6] = kClick[6] = nClick[6] = oClick[6] = pClick[6] = rClick[6] = sClick[6] = uClick[6] = backspaceClick[6] = false;
			}
			if (iHeart.intersects(e.getX(), e.getY(), 1, 1)) {
				iClick[6] = true;
				aClick[6] = cClick[6] = dClick[6] = eClick[6] = kClick[6] = nClick[6] = oClick[6] = pClick[6] = rClick[6] = sClick[6] = uClick[6] = backspaceClick[6] = false;
			}
			if (kStar.intersects(e.getX(), e.getY(), 1, 1)) {
				kClick[6] = true;
				aClick[6] = cClick[6] = dClick[6] = eClick[6] = iClick[6] = nClick[6] = oClick[6] = pClick[6] = rClick[6] = sClick[6] = uClick[6] = backspaceClick[6] = false;
			}
			if (nProton.intersects(e.getX(), e.getY(), 1, 1)) {
				nClick[6] = true;
				aClick[6] = cClick[6] = dClick[6] = eClick[6] = iClick[6] = kClick[6] = oClick[6] = pClick[6] = rClick[6] = sClick[6] = uClick[6] = backspaceClick[6] = false;
			}
			if (oShopping.intersects(e.getX(), e.getY(), 1, 1)) {
				oClick[6] = true;
				aClick[6] = cClick[6] = dClick[6] = eClick[6] = iClick[6] = kClick[6] = nClick[6] = pClick[6] = rClick[6] = sClick[6] = uClick[6] = backspaceClick[6] = false;
			}
			if (pLock.intersects(e.getX(), e.getY(), 1, 1)) {
				pClick[6] = true;
				aClick[6] = cClick[6] = dClick[6] = eClick[6] = iClick[6] = kClick[6] = nClick[6] = oClick[6] = rClick[6] = sClick[6] = uClick[6] = backspaceClick[6] = false;
			}
			if (rCall.intersects(e.getX(), e.getY(), 1, 1)) {
				rClick[6] = true;
				aClick[6] = cClick[6] = dClick[6] = eClick[6] = iClick[6] = kClick[6] = nClick[6] = oClick[6] = pClick[6] = sClick[6] = uClick[6] = backspaceClick[6] = false;
			}
			if (sCap.intersects(e.getX(), e.getY(), 1, 1)) {
				sClick[6] = true;
				aClick[6] = cClick[6] = dClick[6] = eClick[6] = iClick[6] = kClick[6] = nClick[6] = oClick[6] = pClick[6] = rClick[6] = uClick[6] = backspaceClick[6] = false;
			}
			if (uBell.intersects(e.getX(), e.getY(), 1, 1)) {
				uClick[6] = true;
				aClick[6] = cClick[6] = dClick[6] = eClick[6] = iClick[6] = kClick[6] = nClick[6] = oClick[6] = pClick[6] = rClick[6] = sClick[6] = backspaceClick[6] = false;
			}
			if (backspace.intersects(e.getX(), e.getY(), 1, 1)) {
				backspaceClick[6] = true;
				aClick[6] = cClick[6] = dClick[6] = eClick[6] = iClick[6] = kClick[6] = nClick[6] = oClick[6] = pClick[6] = rClick[6] = sClick[6] = uClick[6] = false;
			}
		}

		// check if user is correct
		if (phrase==1 && sClick[1] && aClick[2] && sClick[3] && eClick[4] && eClick[5] && nClick[6]) {
			BombMenu.solveCrypto = true;
			// ensures that buttons reset
			hoverQuit = false;
			hoverHint = false;
		}
		if(phrase==2 && sClick[1] && rClick[2] && dClick[3] && iClick[4] && aClick[5] && kClick[6]) {
			BombMenu.solveCrypto = true;
			// ensures that buttons reset
			hoverQuit = false;
			hoverHint = false;
		}

		// adjust cursor location based on which spot is clicked on the screen
		if (spotlight1.intersects(e.getX(), e.getY(), 1, 1))
			cursorLocation = 1;
		else if (spotlight2.intersects(e.getX(), e.getY(), 1, 1))
			cursorLocation = 2;
		else if (spotlight3.intersects(e.getX(), e.getY(), 1, 1))
			cursorLocation = 3;
		else if (spotlight4.intersects(e.getX(), e.getY(), 1, 1))
			cursorLocation = 4;
		else if (spotlight5.intersects(e.getX(), e.getY(), 1, 1))
			cursorLocation = 5;
		else if (spotlight6.intersects(e.getX(), e.getY(), 1, 1))
			cursorLocation = 6;

	}// end of mouseClicked method

	// Detects the mouse being released
	public void mouseReleased(MouseEvent e) {

	}// end of mouseReleased method

	// Detects the mouse being pressed
	public void mousePressed(MouseEvent e) {

	}// end of mousePressed method

	// Detects the mouse being dragged
	public void mouseDragged(MouseEvent e) {

	}

	// Detects the mouse being moved across the screen
	public void mouseMoved(MouseEvent e) {
		// hint and quit buttons
		if (hint.intersects(e.getX(), e.getY(), 1, 1))
			hoverHint = true;
		else
			hoverHint = false;
		if (quit.intersects(e.getX(), e.getY(), 1, 1))
			hoverQuit = true;
		else
			hoverQuit = false;
		
		// hover feature
		if (aHouse.intersects(e.getX(), e.getY(), 1, 1)) {
			aHover = true;
			cHover = dHover = eHover = iHover = kHover = nHover = oHover = pHover = rHover = sHover = uHover = backspaceHover = false;
		} else if (cPerson.intersects(e.getX(), e.getY(), 1, 1)) {
			cHover = true;
			aHover = dHover = eHover = iHover = kHover = nHover = oHover = pHover = rHover = sHover = uHover = backspaceHover = false;
		}
		else if(dMail.intersects(e.getX(), e.getY(), 1, 1)) {
			dHover = true;
			aHover = cHover = eHover = iHover = kHover = nHover = oHover = pHover = rHover = sHover = uHover = backspaceHover = false;
		}
		else if(eSettings.intersects(e.getX(), e.getY(), 1, 1)) {
			eHover = true;
			aHover = cHover = dHover = iHover = kHover = nHover = oHover = pHover = rHover = sHover = uHover = backspaceHover = false;
		}
		else if(iHeart.intersects(e.getX(), e.getY(), 1, 1)) {
			iHover = true;
			aHover = cHover = dHover = eHover = kHover = nHover = oHover = pHover = rHover = sHover = uHover = backspaceHover = false;
		}
		else if(kStar.intersects(e.getX(), e.getY(), 1, 1)) {
			kHover = true;
			aHover = cHover = dHover = eHover = iHover = nHover = oHover = pHover = rHover = sHover = uHover = backspaceHover = false;
		}
		else if(nProton.intersects(e.getX(), e.getY(), 1, 1)) {
			nHover = true;
			aHover = cHover = dHover = eHover = iHover = kHover = oHover = pHover = rHover = sHover = uHover = backspaceHover = false;
		}
		else if(oShopping.intersects(e.getX(), e.getY(), 1, 1)) {
			oHover = true;
			aHover = cHover = dHover = eHover = iHover = kHover = nHover = pHover = rHover = sHover = uHover = backspaceHover = false;
		}
		else if(pLock.intersects(e.getX(), e.getY(), 1, 1)) {
			pHover = true;
			aHover = cHover = dHover = eHover = iHover = kHover = nHover = oHover = rHover = sHover = uHover = backspaceHover = false;
		}
		else if(rCall.intersects(e.getX(), e.getY(), 1, 1)) {
			rHover = true;
			aHover = cHover = dHover = eHover = iHover = kHover = nHover = oHover = pHover = sHover = uHover = backspaceHover = false;
		}
		else if(sCap.intersects(e.getX(), e.getY(), 1, 1)) {
			sHover = true;
			aHover = cHover = dHover = eHover = iHover = kHover = nHover = oHover = pHover = rHover = uHover = backspaceHover = false;
		}
		else if(uBell.intersects(e.getX(), e.getY(), 1, 1)) {
			uHover = true;
			aHover = cHover = dHover = eHover = iHover = kHover = nHover = oHover = pHover = rHover = sHover = backspaceHover = false;
		}
		else if(backspace.intersects(e.getX(), e.getY(), 1, 1)) {
			backspaceHover = true;
			aHover = cHover = dHover = eHover = iHover = kHover = nHover = oHover = pHover = rHover = sHover = uHover = false;
		}
		else {
			aHover = cHover = dHover = eHover = iHover = kHover = nHover = oHover = pHover = rHover = sHover = uHover = backspaceHover = false;
		}

	}

}
