import javax.swing.*;
import java.awt.event.*;

public class Main {
    private JFrame frame;
    private JButton button;
    private JLabel label;
    private JLabel title;
    private GameButton bl;
    private SendToHow guide;
    private End end;
    private JButton howTo;
    private JButton exit;
    public Main(){
        frame = new JFrame("Main");
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        
        //title 
        title = new JLabel();
        title.setText("Rectangle vs Circle");
        title.setBounds(138,43,200,30);

        //Enter the game
        button = new JButton();
        button.setText("Enter Game");
        button.setBounds(5,120,125,35);

        //How to Guide
        howTo = new JButton();
        howTo.setText("How To Play");
        howTo.setBounds(140,120,150,35);


        //Exit
        exit = new JButton();
        exit.setText("Exit");
        exit.setBounds(300, 120, 75, 35);

        frame.add(button);
        frame.add(title);
        frame.add(howTo);
        frame.add(exit);

    
        
        bl = new GameButton();
        button.addActionListener(bl);

        guide = new SendToHow();
        howTo.addActionListener(guide);

        end = new End();
        exit.addActionListener(end);
    }

    private class GameButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
           GameFrame f = new GameFrame();
          // f.animate();
        }
    }

    private class SendToHow implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
            HowTo h = new HowTo();
        }
    }
   
    private class End implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
        
    }
    
}
