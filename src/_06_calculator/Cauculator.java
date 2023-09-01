package _06_calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

;

public class Cauculator implements ActionListener {
	 JFrame frame = new JFrame();
	 JPanel panel = new JPanel();
	 JButton added = new JButton();
	 JButton subed = new JButton();
	 JButton multed = new JButton();
	 JButton dived = new JButton();
	 JLabel label = new JLabel();
	 JTextField field = new JTextField(10);
	 JTextField field1 = new JTextField(10);
	 int A;
	 
	 void run(){
	    frame.setVisible(true);
	   frame.setTitle("Calculator");
	  added.addActionListener(this);
	  subed.addActionListener(this);
	  multed.addActionListener(this);
	  dived.addActionListener(this);
label.setText("answer: ");
	   panel.add(field);

	   panel.add(field1);
	   added.setText("add");
	   subed.setText("sub");
	   multed.setText("mult");
	   dived.setText("div");
	    
	    panel.add(added);
	    panel.add(subed);
	    panel.add(multed);
	    panel.add(dived);
	    panel.add(label);
	    frame.add(panel);

		frame.pack();
	    }
	  
	  int add(int x, int y) {
	A = x + y;
	return A;
	  }
	  
	  int sub(int x, int y) {
	A = x - y;
	return A;
	  }
	  
	  int mult(int x, int y) {
	A = x*y;
	return A;
	  }
	  
	 int div(int x, int y) {	
	A = x/y;
	return A;
	  }

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		String x = field.getText();
		int a = Integer.parseInt(x);
		String y = field1.getText();
		int b = Integer.parseInt(y);
		if( buttonPressed == added) {
	
			label.setText(add(a,b)+"");
			
		}
		if( buttonPressed == subed) {
			label.setText(sub(a,b)+"");
		}
		if( buttonPressed == multed) {
			label.setText(mult(a,b)+"");
		}
		if( buttonPressed == dived) {
			label.setText(div(a,b)+"");
		}
	}


}
