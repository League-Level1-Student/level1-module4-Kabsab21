package _02_jeopardy;


/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import game_tools.Sound;


/* Check out the Jeopardy Handout to see what the end result should look like: http://bit.ly/1bvnvd4 */

public class Jeopardy implements ActionListener {
	private JButton firstButton;
	private JButton secondButton;
	private JButton thirdButton, fourthButton;
	private JButton fiveButton;
	private JPanel quizPanel;
	private int score = 0;
	private JLabel scoreBox = new JLabel("0");
	private int buttonCount = 0;
	private Sound jeopardyThemeClip;



	public void run() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quizPanel = new JPanel();
		frame.setLayout(new BorderLayout());

		// 1. Make the frame show up
		frame.setVisible(true);
		// 2. Give your frame a title
		frame.setTitle("Jeopardy");
		// 3. Create a JPanel variable to hold the header using the createHeader method
		JPanel headerholder = createHeader("topic");
		// 4. Add the header component to the quizPanel
		quizPanel.add(headerholder);
		// 5. Add the quizPanel to the frame
		frame.add(quizPanel);
		// 6. Use the createButton method to set the value of firstButton
		firstButton = createButton("$200");
		// 7. Add the firstButton to the quizPanel
		quizPanel.add(firstButton);
		// 8. Write the code to complete the createButton() method below. Check that your
		// game looks like Figure 1 in the Jeopardy Handout - http://bit.ly/1bvnvd4.
		
		// 9. Use the secondButton variable to hold a button using the createButton
		// method
		secondButton = createButton("$400");
		// 10. Add the secondButton to the quizPanel
		quizPanel.add(secondButton);
		// 11. Add action listeners to the buttons (2 lines of code)
		firstButton.addActionListener(this);
		secondButton.addActionListener(this);

		// 12. Write the code to complete the actionPerformed() method below
thirdButton = createButton("$600");
quizPanel.add(thirdButton);
thirdButton.addActionListener(this);
		// 13. Add buttons so that you have $200, $400, $600, $800 and $1000 questions
fourthButton = createButton("$800");
quizPanel.add(fourthButton);
fourthButton.addActionListener(this);

fiveButton = createButton("$1000");
quizPanel.add(fiveButton);
fiveButton.addActionListener(this);
		 /*
		 * [optional] Use the showImage or playSound methods when the user answers a
		 * question
		 */
		
		frame.pack();
		quizPanel.setLayout(new GridLayout(buttonCount + 1, 3));
		frame.add(makeScorePanel(), BorderLayout.NORTH);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().height,
				Toolkit.getDefaultToolkit().getScreenSize().width);
	}


	private JButton createButton(String dollarAmount) {
		
		// Create a new JButton
		JButton button = new JButton();
		// Set the text of the button to the dollarAmount
		button.setText(dollarAmount);
		// Increment the buttonCount (this should make the layout vertical)
		buttonCount++;
		// Return your new button instead of the temporary button

		return  button;
	}

	@Override
    public void actionPerformed(ActionEvent e) {
		
		// Remove this temporary message after testing:
	//	JOptionPane.showMessageDialog(null, "pressed " + ((JButton) e.getSource()).getText() + " button");

		JButton buttonPressed = (JButton) e.getSource();
		// If the buttonPressed was the firstButton
		if(e.getSource() == firstButton) {
		 askQuestion("the answer to this question is 1", "1",200);
		 firstButton.setText("");
		}
		if(e.getSource() == secondButton) {
			 askQuestion("the answer to this question is very difficult", "very difficult",400);
			 secondButton.setText("");

			}
			// Call the askQuestion() method
		if(e.getSource() == thirdButton) {
			 askQuestion("the answer to this question is a real mystery", "a real mystery",600);
			 thirdButton.setText("");

			}
		// Complete the code in the askQuestion() method. When you play the game, the score should change.
		if(e.getSource() == fourthButton) {
			 askQuestion("the answer to this question is more complex than jesus", "more complex than jesus",800);
			 fourthButton.setText("");

			}
		if(e.getSource() == fiveButton) {
			 askQuestion("the answer to this question is a literally impossible", "literally impossible",1000);
			 fiveButton.setText("");

			}
		// If the buttonPressed was the secondButton

			// Call the askQuestion() method with a harder question

		// Clear the text on the button that was pressed (set the button text to nothing)

	}

	private void askQuestion(String question, String correctAnswer, int prizeMoney) {
		
		// Use the playJeopardyTheme() method to play music while the use thinks of an answer
		
		// Remove this temporary message and replace it with a pop-up that asks the user the question
		String answer = JOptionPane.showInputDialog(null, question);
		
		// Stop the theme music when they have entered their response.
	
		// If the answer is correct
		if(answer.equals(correctAnswer)) {
		    score = score + prizeMoney;
		  	updateScore();
			JOptionPane.showMessageDialog(null, "You are correcft");
		} else {
			score = score - prizeMoney;
			updateScore();
			JOptionPane.showMessageDialog(null, "You arento  correcft");
		}
			// Increase the score by the prizeMoney
	
			// Pop up a message to tell the user they were correct

		// Otherwise

			// Decrement the score by the prizeMoney

			// Pop up a message to tell the user they were wrong and give them the correct answer

		// Call the updateScore() method

	}

	public void playJeopardyTheme() {
		String fileName = "_02_jeopardy/jeopardy.wav";
		jeopardyThemeClip = new Sound(fileName);
		jeopardyThemeClip.play();
	}

	public void stopJeopardyTheme() {
		jeopardyThemeClip.stop();
	}

	private Component makeScorePanel() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("score:"));
		panel.add(scoreBox);
		panel.setBackground(Color.CYAN);
		return panel;
	}

	private void updateScore() {
		scoreBox.setText("$" + score);
	}

	private JPanel createHeader(String topicName) {
		JPanel panelj = new JPanel();
		panelj.setLayout(new BoxLayout(panelj, BoxLayout.PAGE_AXIS));
		JLabel l1 = new JLabel(topicName);
		l1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelj.add(l1);
		return panelj;
	}

	void showCorrectImage() {
		showImage("correct.jpg");
	}

	void showIncorrectImage() {
		showImage("incorrect.jpg");
	}

	private void showImage(String fileName) {
		JFrame frame = new JFrame();
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		JLabel image = new JLabel(icon);
		frame.add(image);
		frame.setVisible(true);
		frame.pack();
	}
}
