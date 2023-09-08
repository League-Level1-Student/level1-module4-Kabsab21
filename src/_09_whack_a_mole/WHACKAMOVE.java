package _09_whack_a_mole;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WHACKAMOVE implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	
	public static void main(String[] args) {
		WHACKAMOLE mole = new WHACKAMOLE();
		
	}
	
 void run() {
	button1.addActionListener(this);
	button2.addActionListener(this);
	button3.addActionListener(this);
	panel.add(button1);
	panel.add(button2);
	panel.add(button3);
	frame.add(panel);
	frame.setTitle("torchure");
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
 }
 void drawButton(int rand) {
	 if(rand == 0) {
		 button1.setText("wack'a mole");
		 
	 }
	 
	 if(rand == 1) {
		 button2.setText("wack'a mole");
		 
	 }
	 
	 if(rand == 2) {
		 button3.setText("wack'a mole");
		 
	 }
	
		 
	 }
 
 public void actionPerformed(ActionEvent e) {
	 JButton buttonPressed = (JButton) e.getSource();
	 if(buttonPressed == button1) {
		 button1.setText("");
	 }
	 if(buttonPressed == button2) {
		 button2.setText("");
	 }
	 if(buttonPressed == button2) {
		 button2.setText("");
	 }
 }
 
 }



