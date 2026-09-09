import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;

//This class only creates a JFrame that tells the user they won if they beat the circle.
//Also gives player the ability to return to main menu
public class Winner {
    JFrame frame;
    JButton returnToMenu;
    public Winner(){

        frame = new JFrame("Winner");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800,500);
        frame.setLayout(new GridLayout(1,1));
        frame.setVisible(true);


        JLabel win = new JLabel();
        win.setText("YOU WON");
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




