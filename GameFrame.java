import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {
	GamePanel panel;

	public GameFrame() {
		panel = new GamePanel(); // run GamePanel constructor
		this.add(panel);
		this.setTitle("Defuse!"); // set title for frame
		this.setResizable(false); // frame can't change size

		this.setBackground(new Color(76, 74, 123));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X button will stop program execution
		this.pack();// makes components fit in window
		this.setVisible(true); // makes window visible to user
		this.setLocationRelativeTo(null);// set window in middle of screen
	}// end of GameFrame constructor
}
