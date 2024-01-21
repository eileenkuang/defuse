//Authors: Eileen Kuang & Lillian Li
//Date: January 22, 2024
//Title: 7 Minute Meltdown (RhythmicMain class)
//Description: Class for the Rhythmic Recall mini game!

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class RhythmicMain {

	// Variable declarations

	// dimensions
	public final int BACKGROUND_WIDTH = GamePanel.GAME_WIDTH;
	public final int BACKGROUND_HEIGHT = GamePanel.GAME_HEIGHT;

	// background images
	public ImageIcon backgroundIcon = new ImageIcon("rhythmicbackground.png");
	public Image backgroundImage = backgroundIcon.getImage();

	// buttons
	public RhythmicLight yellow;
	public RhythmicLight red;
	public RhythmicLight blue;
	public RhythmicLight green;
	public QuitButton quit = new QuitButton();
	public ImageIcon winIcon = new ImageIcon("rhythmicwin.png");
	public Image winImage = winIcon.getImage();
	public ImageIcon backUnclickedIcon = new ImageIcon("endscreenbackunclicked.png");
	public Image backUnclickedImage = backUnclickedIcon.getImage();
	public ImageIcon backHoveredIcon = new ImageIcon("endscreenbackhovered.png");
	public Image backHoveredImage = backHoveredIcon.getImage();
	public GeneralButton backButton = new GeneralButton(380, 540, (int) (433 / 2), (int) (166 / 2), backUnclickedImage,
			backHoveredImage);
	public ImageIcon beginIcon = new ImageIcon("rhythmicbegin.png");
	public Image beginImage = beginIcon.getImage();
	public ImageIcon beginHoverIcon = new ImageIcon("beginhover.png");
	public Image beginHover = beginHoverIcon.getImage();
	public GeneralButton begin = new GeneralButton(820, 300, 150, 60, beginImage, beginHover);

	// checks
	public static boolean seqOrNot = true;
	public static boolean yflash = false;
	public static boolean rflash = false;
	public static boolean gflash = false;
	public static boolean bflash = false;
	public static boolean hoverQuit = false;
	public boolean backHover = false;
	public boolean hoveringBegin = false;
	public static boolean beginBool = false;

	// sequence variables
	int[] sequence = new int[12];
	int[] answerSeq = new int[12];
	public static int index = 0;
	public static int max = 1;
	private static int win = 0;

	// constructor, set up location of all buttons
	public RhythmicMain() {

		yellow = new RhythmicLight(250, 100, "yellowlight.png", "yellowdark.png");
		red = new RhythmicLight(250, 360, "redlight.png", "reddark.png");
		green = new RhythmicLight(510, 100, "greenlight.png", "greendark.png");
		blue = new RhythmicLight(510, 360, "bluelight.png", "bluedark.png");

	}

	// draws all images
	public void draw(Graphics g) {

		g.drawImage(backgroundImage, 0, 0, GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT, null); // draw background

		quit.draw(g);
		begin.draw(g, hoveringBegin);

		yellow.draw(g, yflash);
		red.draw(g, rflash);
		green.draw(g, gflash);
		blue.draw(g, bflash);

		// if player presses begin the sequence
		if (beginBool) {

			begin.draw(g, hoveringBegin);

			if (max <= 10) {

				// if sequence should be playing and hasn't played all the indices yet
				if (seqOrNot && index <= max) {

					answerSeq = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }; // reset answer array

					if (index < max) {

						sequence[max - 1] = (int) (Math.random() * 4 + 1);

						// no colours flash multiple times consecutively
						if (max != 1 && sequence[max - 1] == sequence[max - 2]) {

							while (sequence[max - 1] == sequence[max - 2]) {
								sequence[max - 1] = (int) (Math.random() * 4 + 1);
							}

						}

					}

					// flashes correct colour based on value in the array
					switch (sequence[index]) {

					case 1:
						yflash = true;
						break;
					case 2:
						rflash = true;
						break;
					case 3:
						gflash = true;
						break;
					case 4:
						bflash = true;
						break;

					}

					// automatically flashes on and off based on boolean
					if (yflash) {
						yellow.draw(g, yflash);
						red.draw(g, rflash);
						green.draw(g, gflash);
						blue.draw(g, bflash);
						sleep(600);
						GamePanel.soundEffect("rhythmic1.wav");

					} else if (rflash) {
						red.draw(g, rflash);
						yellow.draw(g, yflash);
						green.draw(g, gflash);
						blue.draw(g, bflash);
						sleep(600);
						GamePanel.soundEffect("rhythmic2.wav");

					} else if (gflash) {
						green.draw(g, gflash);
						yellow.draw(g, yflash);
						red.draw(g, rflash);
						blue.draw(g, bflash);
						sleep(600);
						GamePanel.soundEffect("rhythmic3.wav");

					} else if (bflash) {
						blue.draw(g, bflash);
						yellow.draw(g, yflash);
						red.draw(g, rflash);
						green.draw(g, gflash);
						sleep(600);
						GamePanel.soundEffect("rhythmic4.wav");
					} else {
						yellow.draw(g, yflash);
						red.draw(g, rflash);
						green.draw(g, gflash);
						blue.draw(g, bflash);
					}

					index++;

				}

				// when sequence has finished playing and needs to wait for user input
				if (index > max && seqOrNot) {

					sleep(500);
					index = 0;
					seqOrNot = false;

				}

				// waits for user input then checks each input
				if (!seqOrNot && index < max) {

					if (answerSeq[index] == 0) {

						if (yflash) {
							yellow.draw(g, yflash);
							red.draw(g, rflash);
							green.draw(g, gflash);
							blue.draw(g, bflash);
							answerSeq[index] = 1;
							sleep(100);
							GamePanel.soundEffect("rhythmic1.wav");

						} else if (rflash) {
							yellow.draw(g, yflash);
							red.draw(g, rflash);
							green.draw(g, gflash);
							blue.draw(g, bflash);
							answerSeq[index] = 2;
							sleep(100);
							GamePanel.soundEffect("rhythmic2.wav");

						} else if (gflash) {
							yellow.draw(g, yflash);
							red.draw(g, rflash);
							green.draw(g, gflash);
							blue.draw(g, bflash);
							answerSeq[index] = 3;
							sleep(100);
							GamePanel.soundEffect("rhythmic3.wav");

						} else if (bflash) {
							yellow.draw(g, yflash);
							red.draw(g, rflash);
							green.draw(g, gflash);
							blue.draw(g, bflash);
							answerSeq[index] = 4;
							sleep(100);
							GamePanel.soundEffect("rhythmic4.wav");

						} else {
							yellow.draw(g, yflash);
							red.draw(g, rflash);
							green.draw(g, gflash);
							blue.draw(g, bflash);
						}

						sleep(200);

					}

					// if user has inputed something, flash to screen then check answer
					if (answerSeq[index] != 0) {

						if (!check()) { // if answer is incorrect, restart

							if (yflash) {
								yellow.draw(g, yflash);
								red.draw(g, rflash);
								green.draw(g, gflash);
								blue.draw(g, bflash);
								answerSeq[index] = 1;
								sleep(200);
								GamePanel.soundEffect("rhythmic1.wav");

							} else if (rflash) {
								yellow.draw(g, yflash);
								red.draw(g, rflash);
								green.draw(g, gflash);
								blue.draw(g, bflash);
								answerSeq[index] = 2;
								sleep(200);
								GamePanel.soundEffect("rhythmic2.wav");

							} else if (gflash) {
								yellow.draw(g, yflash);
								red.draw(g, rflash);
								green.draw(g, gflash);
								blue.draw(g, bflash);
								answerSeq[index] = 3;
								sleep(200);
								GamePanel.soundEffect("rhythmic3.wav");

							} else if (bflash) {
								yellow.draw(g, yflash);
								red.draw(g, rflash);
								green.draw(g, gflash);
								blue.draw(g, bflash);
								answerSeq[index] = 4;
								sleep(200);
								GamePanel.soundEffect("rhythmic4.wav");

							} else {
								yellow.draw(g, yflash);
								red.draw(g, rflash);
								green.draw(g, gflash);
								blue.draw(g, bflash);
							}

							lose();

						}

						else { // if answer is correct, allow user to keep inputting

							index++;

						}

					}

					if (index == max) { // if user is correct for the entire turn
						sleep(400);
						seqOrNot = true;
						max++;
						index = 0;
					}

				}

			}

			else {

				BombMenu.solveRhythmic = true;

			}

		}
		// if user wins the game
		if (BombMenu.solveRhythmic) {

			g.setColor(new Color(0, 0, 0, 100)); // make it partially transparent
			g.fillRect(0, 0, GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT);
			g.drawImage(winImage, 0, 0, (int) (669 * 1.45), (int) (373 * 1.45), null); // draw background
			g.drawImage(BombMenu.codeImage(BombMenu.codeInt4), 430, 395, (int) (200 / 1.75), (int) (217 / 1.75), null);
			winSound();
			backButton.draw(g, backHover);

		}

	}// end of draw method

	public static void reset() {

		index = 0;
		win = 0;
		beginBool = false;
		seqOrNot = true;
		max = 1;

	}

	// plays win sound once while draws the win screen
	public void winSound() {

		if (win == 0)
			GamePanel.soundEffect(GamePanel.right); // sound effect

		win++;

	}

	// sleeps program for a certain number of milliseconds
	static void sleep(int m) {

		try {
			Thread.sleep(m);
			yflash = false;
			rflash = false;
			gflash = false;
			bflash = false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} // end of draw method

	// checks correct sequence or not
	public boolean check() {

		if (answerSeq[index] != sequence[index]) {

			return false;

		} else {

			return true;

		}

	}

	// when user presses the sequence wrong, plays music and regenerates a new
	// pattern
	public void lose() {

		GamePanel.soundEffect("rhythmicerror.wav");
		seqOrNot = true;
		index = 0;
		max = 1;
		sequence = new int[10];
		sleep(1200);

	}

	// will detect when and where mouse clicks to detect user sequence
	public void mouseClicked(MouseEvent e) {

		if (!BombMenu.solveRhythmic) {

			// click quit button
			if (quit.intersects(e.getX(), e.getY(), 1, 1)) {
				GamePanel.onlyShowBombMenu = true;
				GamePanel.onlyShowRhythmic = false;
				hoverQuit = false;
			}

			if (begin.intersects(e.getX(), e.getY(), 1, 1)) {

				beginBool = true;
				seqOrNot = true;

			}

			if (!seqOrNot) {

				if (yellow.intersects(e.getX(), e.getY(), 1, 1)) {

					yflash = true;

				} else if (red.intersects(e.getX(), e.getY(), 1, 1)) {

					rflash = true;

				} else if (green.intersects(e.getX(), e.getY(), 1, 1)) {

					gflash = true;

				} else if (blue.intersects(e.getX(), e.getY(), 1, 1)) {

					bflash = true;

				}

			}

		} else {

			if (backButton.intersects(e.getX(), e.getY(), 1, 1)) {

				GamePanel.onlyShowBombMenu = true;
				GamePanel.onlyShowRhythmic = false;
				backHover = false;

			}

		}

	}// end of mouseClicked method

	// moves any moving graphics
	public void mouseMoved(MouseEvent e) {

		if (!BombMenu.solveRhythmic) {
			// hover over quit button
			if (quit.intersects(e.getX(), e.getY(), 1, 1))
				hoverQuit = true;
			else
				hoverQuit = false;

			if (begin.intersects(e.getX(), e.getY(), 1, 1))
				hoveringBegin = true;
			else
				hoveringBegin = false;

		} else {

			if (backButton.intersects(e.getX(), e.getY(), 1, 1))
				backHover = true;
			else
				backHover = false;

		}

	}// end of move method

	// detects key presses
	public void keyPressed(KeyEvent e) {

	}// end of keyPressed method

	// detects key releases
	public void keyReleased(KeyEvent e) {

	}// end of keyReleased method

	// detects keys being typed
	public void keyTyped(KeyEvent e) {

	}// end of keyTyped method

	// detects the mouse entering the screen
	public void mouseEntered(MouseEvent e) {

	}// end of mouseEntered method

	// detects the mouse exiting the screen
	public void mouseExited(MouseEvent e) {

	}// end of mouseExited method

	// detects the mouse being released
	public void mouseReleased(MouseEvent e) {

	}// end of mouseReleased method

	// detects the mouse being pressed
	public void mousePressed(MouseEvent e) {

	}// end of mousePressed method

} // end of Rhythmic Main class