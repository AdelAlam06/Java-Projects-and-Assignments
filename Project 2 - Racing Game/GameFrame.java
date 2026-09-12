
import javax.swing.*;
import java.awt.*;


import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.*;

public class GameFrame {
    public static JFrame frame;
    boolean check = false;
    
    int userMove = 0;
    int start = 0;

    int circX ;
    int circX2;
    int circX3;
    int circ2X;
    int circ2X2;
    int circ2X3;
    int rectX;
    int rectX2;
    int rectX3;
    int timer = 5;
    //this just creates the player class
    public GameFrame(){

        frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setSize(1000,300);
        
        frame.setLayout(new GridLayout(1,1));

        Player p = new Player();
        frame.add(p);
        frame.pack();
        frame.setVisible(true);

    }
    
    
}
