import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;

public class Loser {
    //This class only creates a JFrame that tells the user they lost if they got beat by the circle.
    //Also gives player the ability to return to main menu
    JFrame frame;
    JButton returnToMenu;
    public Loser(){

        frame = new JFrame("Loser");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800,500);
        frame.setLayout(new GridLayout(1,1));
        frame.setVisible(true);


        JLabel win = new JLabel();
        win.setText("YOU LOST");
        win.setBounds(500, 150, 50, 50);
        
    
        //returns to the main menu
        returnToMenu = new JButton();
        returnToMenu.setText("Play Again");
        returnToMenu.setBounds(100, 160, 200, 35);


        frame.add(returnToMenu);
        frame.add(win);
        frame.pack();
        frame.setVisible(true);
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




