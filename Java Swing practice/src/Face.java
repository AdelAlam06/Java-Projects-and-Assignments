import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Face extends JPanel{
    
    public Face() 
    {

    }

    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        

        //ears
        Graphics2D ears = (Graphics2D) g;
        ears.setColor(Color.BLACK);
        ears.fillArc(110,100,70,70,90,360);
        ears.fillArc(315,100,70,70,90,360);

        //face
        Graphics2D face = (Graphics2D) g;
        face.setColor(new Color(116,57,45));
        face.fillArc(150, 100, 200, 125, 0, 180); //head base
        face.fillRect(150, 160, 200, 100);
        face.fillArc(150, 185, 200, 150, 180, 180);

        //mouth
        face.setColor(new Color(21,15,15));
        face.fillArc(175, 185, 150, 120, 180, 180);

        //eyes
        Graphics2D eyes = (Graphics2D) g;
        eyes.setColor(Color.BLACK);
        eyes.fillOval(205, 165, 40, 40); 
        eyes.fillOval(265, 165, 40, 40); 
        eyes.fillRect(260, 150, 50, 10);
        eyes.fillRect(200, 150, 50, 10);
        
        eyes.setColor(new Color(255,255,255));
        eyes.fillOval(210, 170, 20, 20);
        eyes.fillOval(280, 180, 20, 20);
        //hat
        Graphics2D line = (Graphics2D) g;
        line.setColor(Color.BLACK);
        line.drawLine(200, 100, 300, 100);
        line.drawLine(200, 100, 250, 0);
        line.drawLine(250, 0, 300, 100);


        //nose
        Graphics2D nose = (Graphics2D) g;
        nose.setColor(new Color(212,131,69));
        nose.fillArc(165, 200, 170, 100, 0, 180);
        nose.setColor(Color.BLACK);
        nose.fillOval(230, 195, 50, 30);
        nose.fillOval(190, 220, 7, 7);
        nose.fillOval(185, 230, 7, 7);
        nose.fillOval(195, 230, 7, 7);

        nose.fillOval(305, 220, 7, 7);
        nose.fillOval(300, 230, 7, 7);
        nose.fillOval(310, 230, 7, 7);
    }

}
