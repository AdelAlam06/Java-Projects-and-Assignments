
import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(500,500);
        f.setLayout(new GridLayout(1, 1));
        f.add(new Face());
      
        f.setVisible(true);
    }
}
