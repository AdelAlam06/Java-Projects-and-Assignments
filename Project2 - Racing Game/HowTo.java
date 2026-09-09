import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;


public class HowTo {
    private JFrame frame;
    private JButton returnToMenu;
    private JLabel guide;

    public HowTo(){
        frame = new JFrame("How to Play");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800,500);
        frame.setLayout(new GridLayout(1,1));
        frame.setVisible(true);

        guide = new JLabel();
        guide.setText("<html>\r\n" + 
                        "            This is a race with a Circle and Rectangle.\r\n" + 
                        "            Player is the rectangle and their goal is to beat the Circle. Player moves by clicking left mouse button.\r\n" +
                        "            Circle has randomized distance each cycle.\\r\\n" +
                        "            The circle has \r\n" + 
                        "            Rectangle will have a boost the gives a burst of energy that might allow it to pass the\r\n" + 
                        "            circle before Circle gets the chance. The boost will only work after clicking the button.\r\n" + 
                        "            Please note that you  need to click outside the button to be able to move the rectangle regularly. Only click the button when \r\n" + 
                        "            you see that boost is enabled. Good luck\r\n" + 
                        "            <html>");
        guide.setBounds(50, 15, 500, 150);

        //returns to the main menu
        returnToMenu = new JButton();
        returnToMenu.setText("Return to Menu");
        returnToMenu.setBounds(100, 160, 200, 35);


        frame.add(returnToMenu);
        frame.add(guide);
        returnMain m = new returnMain();
        returnToMenu.addActionListener(m);
    }

    private class returnMain implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
            Main m = new Main();
        }

    }

}
