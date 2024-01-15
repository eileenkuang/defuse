//Authors: Eileen Kuang & Lillian Li
//Date: January 11, 2024
//Title: 7 Minute Meltdown (CountTimer class)
//Description: Class helps control and display the countdown timer

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CountTimer {

	// Variable declarations
	JLabel timeLabel = new JLabel();
	int elapsedTime = 420000; // start timer from 7 minutes
	int seconds = 0;
	int minutes = 0;
	String seconds_string = String.format("%02d", seconds);
	String minutes_string = String.format("%02d", minutes);
	Timer timer = new Timer(1000, new ActionListener() { // create timer object

		public void actionPerformed(ActionEvent e) {

			elapsedTime = elapsedTime - 1000;
			minutes = (elapsedTime / 60000) % 60;
			seconds = (elapsedTime / 1000) % 60;
			seconds_string = String.format("%02d", seconds); // formatting so single digit values print with a 0
			minutes_string = String.format("%02d", minutes);
			timeLabel.setText(minutes_string + ":" + seconds_string);

		}

	});

	// constructor; starts the timer
	public CountTimer(boolean begin) {

		if (begin) {

			start();

		}

	}

	// starts timer
	public void start() {

		timer.start();

	}

	// if mistake is made or hint is prompted, penalty is called in game panel
	public void penalty() {

		seconds -= 10;

	}

	// draws border and customizes fonts
	public void draw(Graphics g) {

		// formatting
		timeLabel.setText(minutes_string + ":" + seconds_string);
		timeLabel.setBounds(100, 100, 200, 100);
		timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);

	}

}
