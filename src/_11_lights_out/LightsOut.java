package _11_lights_out;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * Lights Out is a puzzle game with a grid of lights that are either on (light
 * gray) or off (white). Pressing any light will toggle it and its adjacent
 * lights. The goal of the game is to switch all the lights off.
 * 
 * Follow the instructions below to create your own version of Lights Out
 * 
 * 
 */
public class LightsOut implements MouseListener {
	JFrame frame = new JFrame();
	JPanel gamePanel = new JPanel();
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JLabel label4 = new JLabel();
	JLabel label5 = new JLabel();
	JLabel label6 = new JLabel();
	JLabel label7 = new JLabel();
	JLabel label8 = new JLabel();
	JLabel label9 = new JLabel();
	JLabel label10 = new JLabel();
	JLabel label11 = new JLabel();
	JLabel label12 = new JLabel();
	public LightsOut() {

		/** PART 1. CREATE YOUR LIGHT BOARD **/
		//1. Make your gamePanel a 5x5 grid with setLayout(new GridLayout(5, 5));
		
		gamePanel.setLayout(new GridLayout(5, 5));
			//2. Add 25 JLabels to your gamePanel (these are your lights)
		label1.setText("1");
		label1.setBackground(Color.gray);
		label1.addMouseListener(this);
		gamePanel.add(label1);
		
		label2.setText("2");
		label2.setBackground(Color.gray);
		label2.addMouseListener(this);
		gamePanel.add(label2);
		
		label3.setText("3");
		label3.setBackground(Color.gray);
		label3.addMouseListener(this);
		gamePanel.add(label3);
		
		label4.setText("4");
		label4.setBackground(Color.gray);
		label4.addMouseListener(this);
		gamePanel.add(label4);
		
		label5.setText("5");
		label5.setBackground(Color.gray);
		label5.addMouseListener(this);
		gamePanel.add(label5);
		
		label6.setText("6");
		label6.setBackground(Color.gray);
		label6.addMouseListener(this);
		gamePanel.add(label6);
		
		label7.setText("7");
		label7.setBackground(Color.gray);
		label7.addMouseListener(this);
		gamePanel.add(label7);
	
		label8.setText("8");
		label8.setBackground(Color.gray);
		label8.addMouseListener(this);
		gamePanel.add(label8);
		
		label9.setText("9");
		label9.setBackground(Color.gray);
		label9.addMouseListener(this);
		gamePanel.add(label9);
		
		label10.setText("10");
		label10.setBackground(Color.gray);
		label10.addMouseListener(this);
		gamePanel.add(label10);
		JLabel label11 = new JLabel();
		label11.setText("11");
		label11.setBackground(Color.gray);
		label11.addMouseListener(this);
		gamePanel.add(label11);
		
		label12.setText("12");
		label12.setBackground(Color.gray);
		label12.addMouseListener(this);
		gamePanel.add(label12);
			//3. Use setText() to add a position number to each light (0-24).

			//4. Set the background of each light to LIGHT_GRAY
			// - you will also have to set the background to opaque.
			// - Use light.setOpaque(true);

			//5. Add a mouseListener to each light
		
		
		//6. Add your panel to a frame
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(gamePanel);
		frame.setSize(500,500);
		frame.pack();
		//7. Set the size of the frame

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		/** PART 2: TOGGLE NEIGHBORING LIGHTS **/
		// 1. Get the light that was clicked on `(JLabel) e.getSource`
		JLabel	labelclicked = (JLabel) e.getSource();
		// 2. Get the number (position) of the light
		if( labelclicked == label1) {
			makeMove(1);
			label1.setOpaque(true);
		}
		if( labelclicked == label2) {
			makeMove(2);
			label2.setOpaque(true);
		}
		if( labelclicked == label3) {
			makeMove(3);
			label3.setOpaque(true);
		}
		if( labelclicked == label4) {
			makeMove(4);
			label4.setOpaque(true);
		}
		if( labelclicked == label5) {
			makeMove(5);
			label5.setOpaque(true);
		}
		if( labelclicked == label6) {
			makeMove(6);
			label6.setOpaque(true);
		}
		if( labelclicked == label7) {
			makeMove(7);
			label7.setOpaque(true);
		}
		if( labelclicked == label8) {
			makeMove(8);
			label8.setOpaque(true);
		}
		if( labelclicked == label9) {
			makeMove(9);
			label9.setOpaque(true);
		}
		if( labelclicked == label10) {
			makeMove(10);
			label10.setOpaque(true);
		}
		if( labelclicked == label11) {
			makeMove(11);
			label11.setOpaque(true);
		}
		if( labelclicked == label12) {
			makeMove(12);
			label12.setOpaque(true);
		}
		// 3. Now use the makeMove method to code which lights turn on and off.

		// 4.Check if the player has won (e.g. all the lights are off)
		// ---- HINT: use `getLightAtPosition` to get the light at each position
		// ---------- use 'getBackground' to get the light color

		/** PART 3: RANDOMIZE YOUR BOARD **/
		// Now that your game works can you make the game start with some lights on?

	}

	void makeMove(int pos) {
		toggle((JLabel) gamePanel.getComponent(pos));
		if (pos >= 5) {
			toggle((JLabel) gamePanel.getComponent(pos - 5));
		}
		if ((pos + 1) % 5 != 0) {
			toggle((JLabel) gamePanel.getComponent(pos + 1));
		}
		if (pos % 5 != 0) {
			toggle((JLabel) gamePanel.getComponent(pos - 1));
		}
		if (pos + 5 <= 24) {
			toggle((JLabel) gamePanel.getComponent(pos + 5));
		}
	}

	JLabel getLightAtPosition(int lightPosition) {
		return (JLabel) gamePanel.getComponent(lightPosition);
	}

	void toggle(JLabel label) {
		if (label.getBackground() == Color.WHITE) {
			label.setBackground(Color.LIGHT_GRAY);

		} else {
			label.setBackground(Color.WHITE);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
	}
}
