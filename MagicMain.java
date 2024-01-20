//Authors: Eileen Kuang & Lillian Li
//Date: January 18, 2024
//Title: 7 Minute Meltdown (MagicMain class)
//Description: Class for the Magic Mortal puzzle

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;

public class MagicMain {
	
	// Variable declarations
	public ImageIcon backgroundIcon;
	public Image backgroundImage;
	public ImageIcon submitIcon;
	public Image submitImage;
	public ImageIcon hoverIcon;
	public Image hoverImage;
	public ImageIcon winIcon;
	public Image winImage;
	public GeneralButton submit;
	public HintButton hint;
	public QuitButton quit = new QuitButton();
	public ImageIcon backUnclickedIcon = new ImageIcon("endscreenbackunclicked.png");
	public Image backUnclickedImage = backUnclickedIcon.getImage();
	public ImageIcon backHoveredIcon = new ImageIcon("endscreenbackhovered.png");
	public Image backHoveredImage = backHoveredIcon.getImage();
	public GeneralButton backButton = new GeneralButton(380, 540, (int) (433 / 2), (int) (166 / 2), backUnclickedImage,
			backHoveredImage);
	public boolean backHover = false;
	
	public static int version;
	public int count=0;
	
	public static boolean answer1bool = false;
	public static boolean answer2bool = false;
	public static boolean answer3bool = false;
	public static boolean answer4bool = false;
	public boolean intOrNot;
	public boolean delete1;
	public boolean delete2;
	public boolean delete3;
	public boolean delete4;
	public static boolean hovering = false;
	public static boolean colour = false;
	public static boolean hintUsed = false;
	public static boolean hoverQuit = false;
	public static boolean hoverHint = false;
	public static File fontFile; // custom font
	
	// array of answers
	public static int[] answer = new int[4];
	public int[] puzzle1 = {8, 5, 7, 9};
	public int[] puzzle2 = {2, 7, 5, 8}; 
	public int[] puzzle3 = {6, 5, 8, 4};
	public int[] puzzle4 = {3, 5, 2, 6};
	
	// constructor, initializes all images and buttons
	public MagicMain(){
		
		reset();
		backgroundIcon = new ImageIcon("magicbackground.png");
		backgroundImage = backgroundIcon.getImage();
		submitIcon = new ImageIcon("submitbutton.png");
		submitImage = submitIcon.getImage();
		hoverIcon = new ImageIcon("hoversubmit.png");
		hoverImage = hoverIcon.getImage();
		winIcon = new ImageIcon("magicwin.png");
		winImage = winIcon.getImage();
		fontFile = new File("HelpMe.ttf"); // font path
		
		hint = new HintButton();
		submit = new GeneralButton(740, 460, 160, 70, submitImage, hoverImage);
		
	}
	
	public static void reset() {
		
		answer1bool = false;
		answer2bool = false;
		answer3bool = false;
		answer4bool = false;
		hovering = false;
		colour = false;
		hintUsed = false;
		hoverQuit = false;
		hoverHint = false;
		for(int i=0; i<4; i++) {
			answer[i] = 0;
		}
		version = (int)(Math.random()*4+1);
	}
	
	// draws all shapes and images to screen
	public void draw(Graphics g) {
		
		g.drawImage(backgroundImage, 0, 0, GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT, null); // draw background

		submit.draw(g, hovering);
		quit.draw(g);

		// draw borders
		g.setColor(Color.black);
		g.drawRect(300, 150, 90, 90); // first row
		g.drawRect(450, 150, 90, 90);
		g.drawRect(600, 150, 90, 90); 
		g.drawRect(300, 290, 90, 90); // second row
		g.drawRect(450, 290, 90, 90);
		g.drawRect(600, 290, 90, 90);
		g.drawRect(300, 430, 90, 90); // third row
		g.drawRect(450, 430, 90, 90);
		g.drawRect(600, 430, 90, 90);
		
		if(version == 1) {
			
			// fill rectangles with white
			g.setColor(new Color(186, 90, 90));
			g.fillRect(300, 150, 90, 90); // answer 1
			g.setColor(Color.white);
			g.fillRect(450, 150, 90, 90);
			g.fillRect(600, 150, 90, 90); 
			g.fillRect(300, 290, 90, 90); 
			g.setColor(new Color(186, 90, 90));
			g.fillRect(450, 290, 90, 90); // answer 2
			g.fillRect(600, 290, 90, 90); // answer 3
			g.setColor(Color.white);
			g.fillRect(300, 430, 90, 90); 
			g.setColor(new Color(186, 90, 90));
			g.fillRect(450, 430, 90, 90); // answer 4
			g.setColor(Color.white);
			g.fillRect(600, 430, 90, 90);
			
			g.setColor(Color.black);
			try {
				g.setFont(Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(30f));
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawString("1", 490, 200);
			g.drawString("6", 640, 200);
			g.drawString("3", 340, 340);
			g.drawString("4", 340, 480);
			g.drawString("2", 640, 480);
			
			g.setColor(Color.white);
			
			if(answer1bool) {
				
				g.setColor(new Color(154, 0, 0));
				g.fillRect(300, 150, 90, 90); // answer 1
				
				if(intOrNot) {
					
					g.setColor(Color.white);
					
					if(!delete1) {
						if(!String.valueOf(answer[0]).equals("0"))
							g.drawString(String.valueOf(answer[0]), 340, 200);
					}
					if(!delete2) {
						if(!String.valueOf(answer[1]).equals("0"))
							g.drawString(String.valueOf(answer[1]), 490, 340);
					}
					if(!delete3) {
						if(!String.valueOf(answer[2]).equals("0"))
							g.drawString(String.valueOf(answer[2]), 640, 340);
					}
					if(!delete4) {
						if(!String.valueOf(answer[3]).equals("0"))
							g.drawString(String.valueOf(answer[3]), 490, 480);	
					}
					
				}
				
			}
			else if(answer2bool) {
				
				g.setColor(new Color(154, 0, 0));
				g.fillRect(450, 290, 90, 90); // answer 2
				
				if(intOrNot) {
					
					g.setColor(Color.white);
					
					if(!delete1) {
						if(!String.valueOf(answer[0]).equals("0"))
							g.drawString(String.valueOf(answer[0]), 340, 200);
					}
					if(!delete2) {
						if(!String.valueOf(answer[1]).equals("0"))
							g.drawString(String.valueOf(answer[1]), 490, 340);
					}
					if(!delete3) {
						if(!String.valueOf(answer[2]).equals("0"))
							g.drawString(String.valueOf(answer[2]), 640, 340);
					}
					if(!delete4) {
						if(!String.valueOf(answer[3]).equals("0"))
							g.drawString(String.valueOf(answer[3]), 490, 480);	
					}
					
				}
				
			}
			else if(answer3bool) {
				
				g.setColor(new Color(154, 0, 0));
				g.fillRect(600, 290, 90, 90); // answer 3
				
				if(intOrNot) {
					
					g.setColor(Color.white);
					
					if(!delete1) {
						if(!String.valueOf(answer[0]).equals("0"))
							g.drawString(String.valueOf(answer[0]), 340, 200);
					}
					if(!delete2) {
						if(!String.valueOf(answer[1]).equals("0"))
							g.drawString(String.valueOf(answer[1]), 490, 340);
					}
					if(!delete3) {
						if(!String.valueOf(answer[2]).equals("0"))
							g.drawString(String.valueOf(answer[2]), 640, 340);
					}
					if(!delete4) {
						if(!String.valueOf(answer[3]).equals("0"))
							g.drawString(String.valueOf(answer[3]), 490, 480);	
					}
					
				}
				
			}
			else if(answer4bool) {
				
				g.setColor(new Color(154, 0, 0));
				g.fillRect(450, 430, 90, 90); // answer 4
				
				if(intOrNot) {
					
					g.setColor(Color.white);
					
					if(!delete1) {
						if(!String.valueOf(answer[0]).equals("0"))
							g.drawString(String.valueOf(answer[0]), 340, 200);
					}
					if(!delete2) {
						if(!String.valueOf(answer[1]).equals("0"))
							g.drawString(String.valueOf(answer[1]), 490, 340);
					}
					if(!delete3) {
						if(!String.valueOf(answer[2]).equals("0"))
							g.drawString(String.valueOf(answer[2]), 640, 340);
					}
					if(!delete4) {
						if(!String.valueOf(answer[3]).equals("0"))
							g.drawString(String.valueOf(answer[3]), 490, 480);	
					}
					
				}
			
			}
			
			
		} // end of version 1
		
		if(version == 2) {
			
			// fill rectangles with white
			g.setColor(new Color(186, 90, 90));
			g.fillRect(300, 150, 90, 90); // answer 1
			g.fillRect(450, 150, 90, 90); // answer 2
			g.setColor(Color.white);
			g.fillRect(600, 150, 90, 90); 
			g.fillRect(300, 290, 90, 90); 
			g.setColor(new Color(186, 90, 90));
			g.fillRect(450, 290, 90, 90); // answer 3
			g.setColor(Color.white);
			g.fillRect(600, 290, 90, 90); 
			g.fillRect(300, 430, 90, 90); 
			g.fillRect(450, 430, 90, 90); 
			g.setColor(new Color(186, 90, 90));
			g.fillRect(600, 430, 90, 90); // answer 4
			
			try {
				g.setFont(Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(30f));
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.setColor(Color.black);
			g.drawString("6", 640, 200);
			g.drawString("9", 340, 340);
			g.drawString("1", 640, 340);
			g.drawString("4", 340, 480);
			g.drawString("3", 490, 480);
			
			g.setColor(Color.white);
			
			if(answer1bool) {
				
				g.setColor(new Color(154, 0, 0));
				g.fillRect(300, 150, 90, 90); // answer 1
				
				if(intOrNot) {
					
					g.setColor(Color.white);
					
					if(!delete1) {
						if(!String.valueOf(answer[0]).equals("0"))
							g.drawString(String.valueOf(answer[0]), 340, 200);
					}
					if(!delete2) {
						if(!String.valueOf(answer[1]).equals("0"))
							g.drawString(String.valueOf(answer[1]), 490, 200);
					}
					if(!delete3) {
						if(!String.valueOf(answer[2]).equals("0"))
							g.drawString(String.valueOf(answer[2]), 490, 340);
					}
					if(!delete4) {
						if(!String.valueOf(answer[3]).equals("0"))
							g.drawString(String.valueOf(answer[3]), 640, 480);	
					}
					
				}
				
			}
			else if(answer2bool) {
				
				g.setColor(new Color(154, 0, 0));
				g.fillRect(450, 150, 90, 90); // answer 2
				
				if(intOrNot) {
					
					g.setColor(Color.white);
					
					if(!delete1) {
						if(!String.valueOf(answer[0]).equals("0"))
							g.drawString(String.valueOf(answer[0]), 340, 200);
					}
					if(!delete2) {
						if(!String.valueOf(answer[1]).equals("0"))
							g.drawString(String.valueOf(answer[1]), 490, 200);
					}
					if(!delete3) {
						if(!String.valueOf(answer[2]).equals("0"))
							g.drawString(String.valueOf(answer[2]), 490, 340);
					}
					if(!delete4) {
						if(!String.valueOf(answer[3]).equals("0"))
							g.drawString(String.valueOf(answer[3]), 640, 480);	
					}
					
				}
				
			}
			else if(answer3bool) {
				
				g.setColor(new Color(154, 0, 0));
				g.fillRect(450, 290, 90, 90); // answer 3
				
				if(intOrNot) {
					
					g.setColor(Color.white);
					
					if(!delete1) {
						if(!String.valueOf(answer[0]).equals("0"))
							g.drawString(String.valueOf(answer[0]), 340, 200);
					}
					if(!delete2) {
						if(!String.valueOf(answer[1]).equals("0"))
							g.drawString(String.valueOf(answer[1]), 490, 200);
					}
					if(!delete3) {
						if(!String.valueOf(answer[2]).equals("0"))
							g.drawString(String.valueOf(answer[2]), 490, 340);
					}
					if(!delete4) {
						if(!String.valueOf(answer[3]).equals("0"))
							g.drawString(String.valueOf(answer[3]), 640, 480);	
					}
					
				}
				
			}
			else if(answer4bool) {
				
				g.setColor(new Color(154, 0, 0));
				g.fillRect(600, 430, 90, 90); // answer 4
				
				if(intOrNot) {
					
					g.setColor(Color.white);
					
					if(!delete1) {
						if(!String.valueOf(answer[0]).equals("0"))
							g.drawString(String.valueOf(answer[0]), 340, 200);
					}
					if(!delete2) {
						if(!String.valueOf(answer[1]).equals("0"))
							g.drawString(String.valueOf(answer[1]), 490, 200);
					}
					if(!delete3) {
						if(!String.valueOf(answer[2]).equals("0"))
							g.drawString(String.valueOf(answer[2]), 490, 340);
					}
					if(!delete4) {
						if(!String.valueOf(answer[3]).equals("0"))
							g.drawString(String.valueOf(answer[3]), 640, 480);	
					}
					
				}
			
			}
			
			
		} // end of version 2
		
		if(version == 3) {
			
			// fill rectangles with white
			g.setColor(new Color(186, 90, 90));
			g.fillRect(300, 150, 90, 90); // answer 1
			g.setColor(Color.white);
			g.fillRect(450, 150, 90, 90);
			g.fillRect(600, 150, 90, 90); 
			g.fillRect(300, 290, 90, 90); 
			g.setColor(new Color(186, 90, 90));
			g.fillRect(450, 290, 90, 90); // answer 2
			g.setColor(Color.white);
			g.fillRect(600, 290, 90, 90); 
			g.setColor(new Color(186, 90, 90));
			g.fillRect(300, 430, 90, 90); // answer 3
			g.setColor(Color.white);
			g.fillRect(450, 430, 90, 90); 
			g.setColor(new Color(186, 90, 90));
			g.fillRect(600, 430, 90, 90); // answer 4
			
			try {
				g.setFont(Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(30f));
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.setColor(Color.black);
			g.drawString("7", 490, 200);
			g.drawString("2", 640, 200);
			g.drawString("1", 340, 340);
			g.drawString("9", 640, 340);
			g.drawString("3", 490, 480);
			
			g.setColor(Color.white);
			
			if(answer1bool) {
				
				g.setColor(new Color(154, 0, 0));
				g.fillRect(300, 150, 90, 90); // answer 1
				
				if(intOrNot) {
					
					g.setColor(Color.white);
					
					if(!delete1) {
						if(!String.valueOf(answer[0]).equals("0"))
							g.drawString(String.valueOf(answer[0]), 340, 200);
					}
					if(!delete2) {
						if(!String.valueOf(answer[1]).equals("0"))
							g.drawString(String.valueOf(answer[1]), 490, 340);
					}
					if(!delete3) {
						if(!String.valueOf(answer[2]).equals("0"))
							g.drawString(String.valueOf(answer[2]), 340, 480);
					}
					if(!delete4) {
						if(!String.valueOf(answer[3]).equals("0"))
							g.drawString(String.valueOf(answer[3]), 640, 480);	
					}
					
				}
				
			}
			else if(answer2bool) {
				
				g.setColor(new Color(154, 0, 0));
				g.fillRect(450, 290, 90, 90); // answer 2
				
				if(intOrNot) {
					
					g.setColor(Color.white);
					
					if(!delete1) {
						if(!String.valueOf(answer[0]).equals("0"))
							g.drawString(String.valueOf(answer[0]), 340, 200);
					}
					if(!delete2) {
						if(!String.valueOf(answer[1]).equals("0"))
							g.drawString(String.valueOf(answer[1]), 490, 340);
					}
					if(!delete3) {
						if(!String.valueOf(answer[2]).equals("0"))
							g.drawString(String.valueOf(answer[2]), 340, 480);
					}
					if(!delete4) {
						if(!String.valueOf(answer[3]).equals("0"))
							g.drawString(String.valueOf(answer[3]), 640, 480);	
					}
					
				}
				
			}
			else if(answer3bool) {
				
				g.setColor(new Color(154, 0, 0));
				g.fillRect(300, 430, 90, 90); // answer 3
				
				if(intOrNot) {
					
					g.setColor(Color.white);
					
					if(!delete1) {
						if(!String.valueOf(answer[0]).equals("0"))
							g.drawString(String.valueOf(answer[0]), 340, 200);
					}
					if(!delete2) {
						if(!String.valueOf(answer[1]).equals("0"))
							g.drawString(String.valueOf(answer[1]), 490, 340);
					}
					if(!delete3) {
						if(!String.valueOf(answer[2]).equals("0"))
							g.drawString(String.valueOf(answer[2]), 340, 480);
					}
					if(!delete4) {
						if(!String.valueOf(answer[3]).equals("0"))
							g.drawString(String.valueOf(answer[3]), 640, 480);	
					}
					
				}
				
			}
			else if(answer4bool) {
				
				g.setColor(new Color(154, 0, 0));
				g.fillRect(600, 430, 90, 90); // answer 4
				
				if(intOrNot) {
					
					g.setColor(Color.white);
					
					if(!delete1) {
						if(!String.valueOf(answer[0]).equals("0"))
							g.drawString(String.valueOf(answer[0]), 340, 200);
					}
					if(!delete2) {
						if(!String.valueOf(answer[1]).equals("0"))
							g.drawString(String.valueOf(answer[1]), 490, 340);
					}
					if(!delete3) {
						if(!String.valueOf(answer[2]).equals("0"))
							g.drawString(String.valueOf(answer[2]), 340, 480);
					}
					if(!delete4) {
						if(!String.valueOf(answer[3]).equals("0"))
							g.drawString(String.valueOf(answer[3]), 640, 480);	
					}
					
				}
			
			}
			
			
		} // end of version 3
		
		if(version == 4) {
			
			// fill rectangles with white
			g.setColor(Color.white);
			g.fillRect(300, 150, 90, 90);
			g.setColor(new Color(186, 90, 90));
			g.fillRect(450, 150, 90, 90); // answer 1
			g.setColor(Color.white);
			g.fillRect(600, 150, 90, 90); 
			g.fillRect(300, 290, 90, 90); 
			g.setColor(new Color(186, 90, 90));
			g.fillRect(450, 290, 90, 90); // answer 2
			g.setColor(Color.white);
			g.fillRect(600, 290, 90, 90); 
			g.setColor(new Color(186, 90, 90));
			g.fillRect(300, 430, 90, 90); // answer 3
			g.setColor(Color.white);
			g.fillRect(450, 430, 90, 90); 
			g.setColor(new Color(186, 90, 90));
			g.fillRect(600, 430, 90, 90); // answer 4
			
			try {
				g.setFont(Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(30f));
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.setColor(Color.black);
			g.drawString("4", 340, 200);
			g.drawString("8", 640, 200);
			g.drawString("9", 340, 340);
			g.drawString("1", 640, 340);
			g.drawString("7", 490, 480);
			
			g.setColor(Color.white);
			
			if(answer1bool) {
				
				g.setColor(new Color(154, 0, 0));
				g.fillRect(450, 150, 90, 90); // answer 1
				
				if(intOrNot) {
					
					g.setColor(Color.white);
					
					if(!delete1) {
						if(!String.valueOf(answer[0]).equals("0"))
							g.drawString(String.valueOf(answer[0]), 490, 200);
					}
					if(!delete2) {
						if(!String.valueOf(answer[1]).equals("0"))
							g.drawString(String.valueOf(answer[1]), 490, 340);
					}
					if(!delete3) {
						if(!String.valueOf(answer[2]).equals("0"))
							g.drawString(String.valueOf(answer[2]), 340, 480);
					}
					if(!delete4) {
						if(!String.valueOf(answer[3]).equals("0"))
							g.drawString(String.valueOf(answer[3]), 640, 480);	
					}
					
				}
				
			}
			else if(answer2bool) {
				
				g.setColor(new Color(154, 0, 0));
				g.fillRect(450, 290, 90, 90); // answer 2
				
				if(intOrNot) {
					
					g.setColor(Color.white);
					
					if(!delete1) {
						if(!String.valueOf(answer[0]).equals("0"))
							g.drawString(String.valueOf(answer[0]), 490, 200);
					}
					if(!delete2) {
						if(!String.valueOf(answer[1]).equals("0"))
							g.drawString(String.valueOf(answer[1]), 490, 340);
					}
					if(!delete3) {
						if(!String.valueOf(answer[2]).equals("0"))
							g.drawString(String.valueOf(answer[2]), 340, 480);
					}
					if(!delete4) {
						if(!String.valueOf(answer[3]).equals("0"))
							g.drawString(String.valueOf(answer[3]), 640, 480);	
					}
					
				}
				
			}
			else if(answer3bool) {
				
				g.setColor(new Color(154, 0, 0));
				g.fillRect(300, 430, 90, 90); // answer 3
				
				if(intOrNot) {
					
					g.setColor(Color.white);
					
					if(!delete1) {
						if(!String.valueOf(answer[0]).equals("0"))
							g.drawString(String.valueOf(answer[0]), 490, 200);
					}
					if(!delete2) {
						if(!String.valueOf(answer[1]).equals("0"))
							g.drawString(String.valueOf(answer[1]), 490, 340);
					}
					if(!delete3) {
						if(!String.valueOf(answer[2]).equals("0"))
							g.drawString(String.valueOf(answer[2]), 340, 480);
					}
					if(!delete4) {
						if(!String.valueOf(answer[3]).equals("0"))
							g.drawString(String.valueOf(answer[3]), 640, 480);	
					}
					
				}
				
			}
			else if(answer4bool) {
				
				g.setColor(new Color(154, 0, 0));
				g.fillRect(600, 430, 90, 90); // answer 4
				
				if(intOrNot) {
					
					g.setColor(Color.white);
					
					if(!delete1) {
						if(!String.valueOf(answer[0]).equals("0"))
							g.drawString(String.valueOf(answer[0]), 490, 200);
					}
					if(!delete2) {
						if(!String.valueOf(answer[1]).equals("0"))
							g.drawString(String.valueOf(answer[1]), 490, 340);
					}
					if(!delete3) {
						if(!String.valueOf(answer[2]).equals("0"))
							g.drawString(String.valueOf(answer[2]), 340, 480);
					}
					if(!delete4) {
						if(!String.valueOf(answer[3]).equals("0"))
							g.drawString(String.valueOf(answer[3]), 640, 480);	
					}
					
				}
			
			}
			
			
		} // end of version 4
		
		
		hint.draw(g, hintUsed);

		if(hintUsed) {
			
			// USE IMAGE FOR HINT
			g.setColor(Color.white);
			g.drawString("15...", 10, 100);

		}
		
		if(BombMenu.solveMagic) {
			g.setColor(new Color(0, 0, 0, 100)); // make it partially transparent
			g.fillRect(0, 0, GamePanel.GAME_WIDTH, GamePanel.GAME_HEIGHT);
			g.drawImage(winImage, 0, 0, (int)(669*1.45),(int)(373*1.45), null); // draw background
			g.drawImage(BombMenu.codeImage(BombMenu.codeInt3), 430, 395, (int) (200 / 1.75), (int) (217 / 1.75), null);
			backButton.draw(g, backHover);
		}
		
	}// end of draw method
	
	// checks when/where user clicks mouse
	public void mouseClicked(MouseEvent e) {
		
		if(!BombMenu.solveMagic) {
			
			// quit button
			if(quit.intersects(e.getX(), e.getY(), 1, 1)) {
				
				GamePanel.onlyShowBombMenu = true;
				GamePanel.onlyShowMagic = false;
				hoverQuit = false;
				
			}
			if(hint.intersects(e.getX(), e.getY(), 1, 1)) {
				
				hintUsed = true;
				
			}
			
			if(submit.intersects(e.getX(), e.getY(), 1, 1)) {
				
				checkAnswer();
				
			}
			

			// version 1 grid
			if(version == 1) {

				if(e.getX() >= 300 && e.getX() <= 390 && e.getY() >= 150 && e.getY() <= 240) { // click within box parameters
					
					answer1bool = true;
					answer2bool = false;
					answer3bool = false;
					answer4bool = false;
					
				}
				else if(e.getX() >= 450 && e.getX() <= 540 && e.getY() >= 290 && e.getY() <= 380) { // click within box parameters
					
					answer1bool = false;
					answer2bool = true;
					answer3bool = false;
					answer4bool = false;
					
				}
				else if(e.getX() >= 600 && e.getX() <= 690 && e.getY() >= 290 && e.getY() <= 380) { // click within box parameters
					
					answer1bool = false;
					answer2bool = false;
					answer3bool = true;
					answer4bool = false;
		
				}
				else if(e.getX() >= 450 && e.getX() <= 540 && e.getY() >= 430 && e.getY() <= 520) { // click within box parameters
					
					answer1bool = false;
					answer2bool = false;
					answer3bool = false;
					answer4bool = true;
					
				}
				
			}
			
			// version 2 grid
			if(version == 2) {

				if(e.getX() >= 300 && e.getX() <= 390 && e.getY() >= 150 && e.getY() <= 240) { // click within box parameters
					
					answer1bool = true;
					answer2bool = false;
					answer3bool = false;
					answer4bool = false;
					
				}
				else if(e.getX() >= 450 && e.getX() <= 540 && e.getY() >= 150 && e.getY() <= 240) { // click within box parameters
					
					answer1bool = false;
					answer2bool = true;
					answer3bool = false;
					answer4bool = false;
					
				}
				else if(e.getX() >= 450 && e.getX() <= 540 && e.getY() >= 290 && e.getY() <= 380) { // click within box parameters
					
					answer1bool = false;
					answer2bool = false;
					answer3bool = true;
					answer4bool = false;
		
				}
				else if(e.getX() >= 600 && e.getX() <= 690 && e.getY() >= 430 && e.getY() <= 520) { // click within box parameters
					
					answer1bool = false;
					answer2bool = false;
					answer3bool = false;
					answer4bool = true;
					
				}
						
			}
			
			// version 3 grid
			if(version == 3) {

				if(e.getX() >= 300 && e.getX() <= 390 && e.getY() >= 150 && e.getY() <= 240) { // click within box parameters
					
					answer1bool = true;
					answer2bool = false;
					answer3bool = false;
					answer4bool = false;
					
				}
				else if(e.getX() >= 450 && e.getX() <= 540 && e.getY() >= 290 && e.getY() <= 380) { // click within box parameters
					
					answer1bool = false;
					answer2bool = true;
					answer3bool = false;
					answer4bool = false;
					
				}
				else if(e.getX() >= 300 && e.getX() <= 390 && e.getY() >= 430 && e.getY() <= 520) { // click within box parameters
					
					answer1bool = false;
					answer2bool = false;
					answer3bool = true;
					answer4bool = false;
		
				}
				else if(e.getX() >= 600 && e.getX() <= 690 && e.getY() >= 430 && e.getY() <= 520) { // click within box parameters
					
					answer1bool = false;
					answer2bool = false;
					answer3bool = false;
					answer4bool = true;
					
				}
						
			}
			
			// version 4 grid
			if(version == 4) {

				if(e.getX() >= 450 && e.getX() <= 540 && e.getY() >= 150 && e.getY() <= 240) { // click within box parameters
					
					answer1bool = true;
					answer2bool = false;
					answer3bool = false;
					answer4bool = false;
					
				}
				else if(e.getX() >= 450 && e.getX() <= 540 && e.getY() >= 290 && e.getY() <= 380) { // click within box parameters
					
					answer1bool = false;
					answer2bool = true;
					answer3bool = false;
					answer4bool = false;
					
				}
				else if(e.getX() >= 300 && e.getX() <= 390 && e.getY() >= 430 && e.getY() <= 520) { // click within box parameters
					
					answer1bool = false;
					answer2bool = false;
					answer3bool = true;
					answer4bool = false;
		
				}
				else if(e.getX() >= 600 && e.getX() <= 690 && e.getY() >= 430 && e.getY() <= 520) { // click within box parameters
					
					answer1bool = false;
					answer2bool = false;
					answer3bool = false;
					answer4bool = true;
					
				}
						
			}
			
		}
		else {
			
			if(backButton.intersects(e.getX(), e.getY(), 1, 1)) {
				
				GamePanel.onlyShowBombMenu = true;
				GamePanel.onlyShowMagic = false;
				GamePanel.soundEffect(GamePanel.right); //sound effect
				backHover = false;
				
			}
			
		}
				
		
	} // end of mouseClciked method
	
	// checks when/what user types in, only accepts integers 1-9
	public void keyTyped(KeyEvent e) {
		
		if (answer1bool) {

	        if (Character.isDigit(e.getKeyChar()) && e.getKeyChar()-'0' != 0) {
	        	
	            answer[0] = e.getKeyChar() - '0';
	            intOrNot = true;
	            delete1 = false;
	            
	        } else if (e.getKeyChar() == '\b') { // Backspace is pressed

	        	delete1 = true; // draws no string to screen
	        	
	        } 
	        
	    }
		
		else if (answer2bool) {

	        if (Character.isDigit(e.getKeyChar()) && e.getKeyChar()-'0' != 0) {
	        	
	            answer[1] = e.getKeyChar() - '0';
	            intOrNot = true;
	            delete2 = false;
	            
	        } else if (e.getKeyChar() == '\b') { // Backspace is pressed

	        	delete2 = true; // draws no string to screen
	        	
	        } 
	        
	    }
		else if (answer3bool) {

	        if (Character.isDigit(e.getKeyChar()) && e.getKeyChar()-'0' != 0) {
	        	
	            answer[2] = e.getKeyChar() - '0';
	            intOrNot = true;
	            delete3 = false;
	            
	        } else if (e.getKeyChar() == '\b') { // Backspace is pressed

	        	delete3 = true; // draws no string to screen
	        	
	        } 
	        
	    }
		else if (answer4bool) {

	        if (Character.isDigit(e.getKeyChar()) && e.getKeyChar()-'0' != 0) {
	        	
	            answer[3] = e.getKeyChar() - '0';
	            intOrNot = true;
	            delete4 = false;
	            
	        } else if (e.getKeyChar() == '\b') { // Backspace is pressed

	        	delete4 = true; // draws no string to screen
	        	
	        } 
	        
		}
		
		// potentially add arrow navigation feature
		
	}// end of keyTyped method
	
	// checks user answer
	public void checkAnswer() {
		
		// compare answer[i] to appropriate correct answers
		for(int i=0; i<4; i++) {
			
			switch(version) {
				
			case 1:
				if(answer[i]==puzzle1[i])
					count++;
				break;
			case 2:
				if(answer[i]==puzzle2[i])
					count++;
				break;
			case 3:
				if(answer[i]==puzzle3[i])
					count++;
				break;
			case 4:
				if(answer[i]==puzzle4[i])
					count++;
				break;
				
			}
			
		}
		
		if (count==4) {
			
			BombMenu.solveMagic = true;
			
		}
		
	}
	
	// checks when/where mouse is moved
	public void mouseMoved(MouseEvent e) {

		if(!BombMenu.solveMagic) {
			
			// hover over submit button
			if(submit.intersects(e.getX(), e.getY(), 1, 1))	
				hovering = true;
			else 	
				hovering = false;
			
			// hover over quit button
			if(quit.intersects(e.getX(), e.getY(), 1, 1))
				hoverQuit = true;
			else 
				hoverQuit = false;
			
			if(hint.intersects(e.getX(), e.getY(), 1, 1))
				hoverHint = true;
			else 
				hoverHint = false;
			
		}
		else {
			if(backButton.intersects(e.getX(), e.getY(), 1, 1)) 
				backHover = true;
			else
				backHover = false;
		}
		
	}// end of mouseMoved method
	
	// detects key releases
	public void keyReleased(KeyEvent e) {

	}// end of keyReleased method

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
}