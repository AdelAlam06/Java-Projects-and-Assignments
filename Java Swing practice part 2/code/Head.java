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
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Head extends JPanel implements MouseMotionListener{
    boolean check = false;
   
    public Head() 
    {
        this.setPreferredSize(new Dimension(500,500));
        addMouseMotionListener(this);
    }

    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D circle = (Graphics2D) g;
        circle.setColor(Color.BLACK);
        circle.drawOval(150, 150, 200, 200);
        Graphics2D eyes = (Graphics2D) g;
        
        eyes.setColor(Color.BLACK);
        
        if(check){
            eyes.drawRect(200, 200, 25, 25); //eye 1 open
            eyes.drawRect(280, 200, 25, 25); //eye 2 open
           
        }
        else{ 
            eyes.drawLine(180, 200, 205, 200); //eye 1 closed
            eyes.drawLine(280, 200, 305, 200); //eye 2 closed
           
        }
        

        Graphics2D mouth = (Graphics2D) g;
        mouth.setColor(Color.BLACK);
        mouth.drawRect(200, 280, 100, 25);
    }

    @Override
    public void mouseDragged(MouseEvent e){}
    @Override
    public void mouseMoved(MouseEvent e){
        int dx = 0;
        int dy = 0;
        dx = 250 - e.getX();
        dy = 250 - e.getY();

        double radius = Math.sqrt(dx*dx + dy*dy);

        if(radius < 100 ){
            check = true;
            repaint();
        }
        else{
            check = false;
            repaint();
        }
    }

}

