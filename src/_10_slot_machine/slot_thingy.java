package _10_slot_machine;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.Random;

import javax.print.DocFlavor.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class slot_thingy implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JButton button = new JButton();
	
	void run() {
		frame.setVisible(true);
		frame.setTitle("SLOT MACHINE");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.setText("SPIN!");
		button.addActionListener(this);
		frame.add(panel);
		panel.add(button);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		
		frame.pack();
	}
	
	public static void main(String[] args) {
		slot_thingy fjksjfhrwer = new slot_thingy();
		fjksjfhrwer.run();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	JButton pressed = (JButton) e.getSource();
	if(button == pressed) {
		try {
			setReel();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
		
	}
	public void setReel() throws MalformedURLException {
		Random r = new Random();
		int rr = r.nextInt(6);
		if(rr == 0) {
			System.out.println("0");
			label1.setIcon( createLabelImage("cherry.jpeg"));
			label2.setIcon( createLabelImage("cherry.jpeg"));
			label3.setIcon( createLabelImage("cherry.jpeg"));
			JOptionPane.showMessageDialog(null, "YOU WINNNNN!");
		}
		if(rr == 1) {
			System.out.println("0");
			label1.setIcon( createLabelImage("cherry.jpeg"));
			label1.setIcon( createLabelImage("lime.jpeg"));
			label1.setIcon( createLabelImage("orange.jpeg"));
			
		}
		if(rr == 2) {
			System.out.println("0");
			label1.setIcon( createLabelImage("orange.jpeg"));
			label2.setIcon( createLabelImage("cherry.jpeg"));
			label1.setIcon( createLabelImage("lime.jpeg"));
			
		}
		if(rr == 3) {
			System.out.println("0");
			label1.setIcon( createLabelImage("lime.jpeg"));
			label1.setIcon( createLabelImage("orange.jpeg"));
			label3.setIcon( createLabelImage("cherry.jpeg"));
		
		}
		
		if(rr == 4) {
			System.out.println("1");
			label1.setIcon( createLabelImage("orange.jpeg"));
			label2.setIcon(createLabelImage("orange.jpeg"));
			label3.setIcon( createLabelImage("orange.jpeg"));
			JOptionPane.showMessageDialog(null, "YOU WINNNNN!");
			}
		if(rr == 5) {
			System.out.println("2");
			label1.setIcon( createLabelImage("lime.jpeg"));
			label2.setIcon(createLabelImage("lime.jpeg"));
			label3.setIcon( createLabelImage("lime.jpeg"));
			JOptionPane.showMessageDialog(null, "YOU WINNNNN!");
			}
		
	}
	
	private Icon createLabelImage(String fileName) throws MalformedURLException{
        java.net.URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return null;
	}
	ImageIcon icon = new ImageIcon(imageURL);
	Image name = icon.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
	Icon ic = new ImageIcon(name);
	
	return ic;
}
	
}
