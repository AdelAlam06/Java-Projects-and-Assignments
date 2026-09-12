import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/* Main class that creates a player object (which is a rectangle) and a circle object. The player class moves based on mouse clicks
 * and every 5 clicks there is a "boost" that the user will click in order to give themselves an extra distance boost to finish line.
 * The circle class is the rival to the player and it also moves with a mouse click however it's movement is randomized within
 * a certain range that I stated in the actionPerformed (for boost) and mouseClicked functions. 
 * The win/loss of the user is detectable by checking the x values of the user and the circle after it is redrawn and if it passes the 
 * finish line which has a x value of 900, it will be considered a win/loss depending on who passes the finish line first.
 */
public class Player extends JPanel{
    
    //variables
    int userMove = 0;
    Boolean check = false;

    int x = 0;
    int x2 = 0;
    int x3 = 0;
    int cX = 0;
    int cX2 = 0;
    int cX3 = 0;
    int counter = 5;

    //events and objects
    Boost boost = new Boost();
    Clicker click = new Clicker();
    Rect r = new Rect(10,20,80); //draws player's rectangle
    Circ c = new Circ(10, 20, 80);
    JButton fast;
    JLabel label;
 
    //creates JPanel
    public Player(){
        this.setPreferredSize(new Dimension(1000,300));
        this.setLayout(null);
        fast = new JButton();
        
        fast.setText("CLICK NOW");
        fast.setBounds(100,250,125,35);
        fast.addActionListener(boost);
        fast.setEnabled(false);

        label = new JLabel();
        label.setText("BOOST NOW");
        label.setBounds(10, 250, 175,35);
        label.setVisible(false);
        
        this.add(label);
        this.add(fast);
        this.addMouseListener(click);
    }

    //repaints rect and circ after every mouse click or boost 
    @Override
    protected void paintComponent(Graphics g){
        //draws the shapes
        super.paintComponent(g);
        r.draw(g);
        c.draw(g);
    }
   
    public class Rect{

        public Rect(int body, int wheel1, int wheel2){
            x = body;
            x2 = wheel1;
            x3 = wheel2;
        }

        public void draw(Graphics g){
            //finish line, too lazy to make a class for it
            Graphics2D finish = (Graphics2D) g;
            finish.setColor(Color.BLACK);
            finish.fillRect(900, 0, 100, 300);
            finish.drawLine(0, 80, 900, 80);
            finish.drawLine(0, 164, 900, 164);
            finish.setColor(Color.white);
            finish.fillRect(900, 0, 100, 50);
            finish.fillRect(900, 100, 100, 50);
            finish.fillRect(900, 200, 100, 50);

            Graphics2D rect = (Graphics2D) g;
            rect.setColor(Color.green);
            rect.fillRect(x, 10, 100, 50); //rectangle body
            rect.setColor(Color.BLACK);
            rect.drawOval(x2, 60, 20,20); //rectangle wheel 1
            rect.drawOval(x3, 60, 20,20); //rectangle wheel 2
        }

        
    }

    public class Circ{
        public Circ(int body, int wheel1, int wheel2){
            cX = body;
            cX2 = wheel1;
            cX3 = wheel2;
        }

        public void draw(Graphics g){
            //creates circle
            Graphics2D circ = (Graphics2D) g;

            circ.setColor(Color.red);
            circ.fillOval(cX, 100, 100, 50); //circle body
            circ.setColor(Color.BLACK);
            circ.drawOval(cX2, 144, 20,20); //circle wheel one 
            circ.drawOval(cX3, 144, 20,20); //circle wheel two

            
        }
    }
   
    private class Boost implements ActionListener{

        /*
         * The labels and buttons here are disabled after the user has clicked the button so that user can't infinitely boost.
         * the last 2 conditionals check for who won 
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            check = true; 
            int circ = 0 + (int)(Math.random() * (100)); //random value generated 0 to 99 inclusive to travel on x-axis for circle
            System.out.println(check);
            if(check == true && fast.isEnabled() == true){
                fast.setEnabled(false);
                check = false;
                fast.setEnabled(false);
                label.setVisible(false);
                c = new Circ(cX+=circ, cX2+=circ, cX3+=circ);
                r = new Rect(x += 120, x2 += 120, x3 += 120);
            }
            Player.this.repaint();
            if(x+100 >= 900){  
                GameFrame.frame.setVisible(false);
                Winner w = new Winner();
            }
            else if(cX+100 >= 900){
                GameFrame.frame.setVisible(false);
                Loser l = new Loser();
            }
        }
    }
    
    private class Clicker implements MouseListener{

        //This is where most of the code works
        /*
         * userMove and circ move the player and the circle respectively
         * first conditional checks to see if 5 clicks has occured before a boost can be given 
         * repaints the circle and rectangle based on usermove and circ
         * the last 2 conditionals check for who won  
         */
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            int circ = 0 + (int)(Math.random() * (130)); //random value generated 0 to 129 inclusive to travel on x-axis for circle 
            userMove+= 10; //moves the player
            counter--;//countdown for boost
            System.out.println(counter);
            if(counter == 0){
                fast.setEnabled(true);
                label.setVisible(true);
                counter = 5;
            }
            c = new Circ(cX+=circ, cX2+=circ, cX3+=circ);
            r = new Rect(x += userMove, x2 += userMove, x3 += userMove);
            
            Player.this.repaint();

            if(x+100 >= 900){  
                GameFrame.frame.setVisible(false);
                Winner w = new Winner();
            }
            else if(cX+100 >= 900){
                GameFrame.frame.setVisible(false);
                Loser l = new Loser();
            }
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {}

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {}

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {}

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {}
        
    }

}
