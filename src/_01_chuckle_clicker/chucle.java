package _01_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class chucle implements ActionListener {
	  JButton button1 = new JButton();
	  JButton button2 = new JButton();
public static void main(String[] args) {
	chucle makeabuttons = new chucle();
	makeabuttons.makeButtons();
}
  void makeButtons() {
	  JFrame jaframe = new JFrame();
	  jaframe.setVisible(true);
	  JPanel panel = new JPanel();
	  button1.setText("joke");
	  button2.setText("punchline");
	  button1.addActionListener(this);
	  button2.addActionListener(this);
	  jaframe.add(panel);
	  panel.add(button1);
	  panel.add(button2);
	  jaframe.pack();
  }
@Override
public void actionPerformed(ActionEvent e) {
	JButton buttonPressed = (JButton) e.getSource();
	
	if(e.getSource() == button1) {
		JOptionPane.showMessageDialog(null, "what did the ocean say to the beach?");
	}

	if(e.getSource() == button2) {
		JOptionPane.showMessageDialog(null, "nothing, it just waved.");
	}
}
  
}
