package Farben;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorSchool implements ActionListener {
	// Frames
	JFrame frame = new JFrame();
	// Buttons
	JButton democrat = new JButton();
	JButton republican = new JButton();
	JButton libertarian = new JButton();
	JButton green = new JButton();
	// Other Stuff
	JPanel panel = new JPanel();

	public static void main(String[] args) {
		new ColorSchool().run();
	}

	// Use run method to create GUIs
	public void run() {
		// Democrats
		democrat.setBackground(new Color(0, 0, 255));
		democrat.setOpaque(true);
		democrat.setText("red");
		// Republicans
		republican.setBackground(new Color(255, 0, 0));
		republican.setOpaque(true);
		republican.setText("yellow");
		// Libertarians
		libertarian.setBackground(new Color(255, 255, 0));
		libertarian.setOpaque(true);
		libertarian.setText("blue");
		// Green
		green.setBackground(new Color(0, 255, 0));
		green.setOpaque(true);
		green.setText("green");
		// Boring GUI stuff
		panel.add(democrat);
		panel.add(republican);
		panel.add(libertarian);
		panel.add(green);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
		// Action Listeners
		democrat.addActionListener(this);
		republican.addActionListener(this);
		libertarian.addActionListener(this);
		green.addActionListener(this);
		test();
	}

	String answer = null;
	String type;

	public void test() {
		int color = new Random().nextInt(3);
		int textornot = new Random().nextInt(1);

		// Colors
		if (color == 0) {
			answer = "green";
		}
		if (color == 1) {
			answer = "blue";
		}
		if (color == 2) {
			answer = "yellow";
		}
		if (color == 3) {
			answer = "red";
		}
		// Types
		if (textornot == 0) {
			type = "color";
		} else {
			type = "text";
		}
		speak("Click on the " + type + " " + answer);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Buttons organized on left-right political spectrum
		if ((JButton) e.getSource() == green) {
			speak("This color is green.");
			if ((type.equals("color") && answer.equals("green")) || (type.equals("text") && answer.equals("green"))) {
				speak("Correct!");
			} else {
				speak("Congratulations you failed the colors test and are now being held back in kindergarten");
			}
		}
		if ((JButton) e.getSource() == democrat) {
			speak("This color is blue.");
			if ((type.equals("color") && answer.equals("blue")) || (type.equals("text") && answer.equals("yellow"))) {
				speak("                   Correct!");
			} else {
				speak("Congratulations you failed the colors test and are now being held back in kindergarten");
			}
		}
		if ((JButton) e.getSource() == libertarian) {
			speak("This color is yellow.");
			if ((type.equals("color") && answer.equals("yellow")) || (type.equals("text") && answer.equals("red"))) {
				speak("Correct!");
			} else {
				speak("Congratulations you failed the colors test and are now being held back in kindergarten");
			}
		}
		if ((JButton) e.getSource() == republican) {
			speak("This color is red.");
			if ((type.equals("color") && answer.equals("red")) || (type.equals("text") && answer.equals("blue"))) {
				speak("Correct!");
			} else {
				speak("Congratulations you failed the colors test and are now being held back in kindergarten");
			}
		}
	}

	void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
