package _05_fortune_teller;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import game_tools.Sound;

public class FortuneTeller extends JPanel implements Runnable, MouseListener {

    JFrame frame = new JFrame();

    int frameWidth = 500;
    int frameHeight = 500;

    FortuneTeller() throws Exception {
        // 1. Choose an image for your fortune teller and put it in your default package
        fortuneTellerImage = ImageIO.read(getClass().getResource("fortune teller.png"));
        
        // 2. Adjust the frameWidth and frameHeight variables to fit your image nicely (doesn’t need a new line of code)
        
        // 3. Complete the begin() method in the FortuneTellerRunner class
        
        // 4. add a mouse listener to the frame
        frame.addMouseListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        
        // 5. Print the mouseX variable
        System.out.println(mouseX+" "+ mouseY);
        // 6. Add the mouseY variable to the previous line so that it prints out too (no new line)
        
        // 7. Adjust your secret location co-ordinates here:
        int secretLocationX = 100;
        int secretLocationY = 100;
        
        // If the mouse co-ordinates and secret location are close, we'll let them ask a question.
        if (areClose(mouseX, secretLocationX) && areClose(mouseY, secretLocationY)) {
            // 8. Find a spooky sound and put it in your _05_fortune_teller package (freesound.org)
              play("creepy-noise.wav");
            System.out.println("dfsd");
            // 9. Play the sound
        if( mouseX == secretLocationX &&  mouseY == secretLocationY) {
        	JOptionPane.showMessageDialog(null, "congrats, you found the secret location, (clapping)");
        }
            // 10. Insert your completed Magic 8 ball code here
            int rando = new Random().nextInt(4);
          	System.out.println(rando);
        	JOptionPane.showInputDialog(null, "enter a yes or no question into the 8ball");
         	if( rando == 0) {
       		JOptionPane.showMessageDialog(null, "yeah.");
       	}
       	if( rando == 1) {
       		JOptionPane.showMessageDialog(null, "def not loser.");
        	}
       	if( rando == 2) {
        		JOptionPane.showMessageDialog(null, "so theres this thing called google. you should use it to the best of your abilities");
      	}
        	if( rando == 3) {
         		JOptionPane.showMessageDialog(null, "your gay.");
          	}
      }

    }

    private boolean areClose(int mouseX, int secretLocationX) {
        return mouseX < secretLocationX + 15 && mouseX > secretLocationX - 15;
    }

    private void pause(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**************** don't worry about the stuff under here *******************/

    BufferedImage fortuneTellerImage;

    @Override
    public void run() {
        frame.add(this);
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static synchronized void play(final String fileName)
    {
        Sound sound = new Sound("_05_fortune_teller/" + fileName);
        sound.play();
    }

    private void showAnotherImage(String imageName) {
        try {
            fortuneTellerImage = ImageIO.read(getClass().getResource(imageName));
        } catch (Exception e) {
            System.err.println("Couldn't find this image: " + imageName);
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(fortuneTellerImage, 0, 0, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}




