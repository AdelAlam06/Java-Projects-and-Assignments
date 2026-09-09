import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Project2Runner {
    
    /*
     * Name: Adel Alam
     * Student ID: 501293305
     * 
     ******** Project Description ********
     * 
     * Describe in plain English the overall program/program in a paragraph or 2.
     * 
     * *****************************************************************************************************************
     *  This is a race with a Circle and Rectangle. Player is the rectangle and their goal is to beat the Circle. 
     *  Player moves by clicking left mouse button. Circle has randomized distance each cycle. Rectangle will
     *  have a boost the gives a burst of energy that might allow it to pass the Circle before Circle gets the chance. The boost
     *  will only work after clicking the button. Please note that the player needs to click outside the button to be 
     * able to move the rectangle regularly. They can only click the button when boost is enabled. Otherwise it wont work.
     ******************************************************************************************************************
     * 
     ******** Swing Requirement ********
     * 
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least 3 unique components. Be clear to identify in what
     * files and the lines number (just the starting line is fine) that the
     * components are defined on.
     * 
     * *****************************************************************************************************************
     * Multiple JFrames used to create menus. Only GameFrame class utilizes JPanel classes. 
     * Most swing components can be found in the first constructors. I used a label and button for moving from different menus
     * and also for boost function in the game. Created return to menu and play again buttons as well.
     * Example: Main class, lines 21, 26, 31 
     * *****************************************************************************************************************
     * 
     ******** 2D Graphics Requirement ********
     *
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least 1 JPanel used for drawing something. Be clear to
     * identify in what files and the line numbers that this panel is defined on.
     * 
     * *****************************************************************************************************************
     * The entirety of my player class satisfies this requirement. The JPanel is used to create the shapes.
     * The player object is a rectangle with 2 wheels and the automated opponent is a circle with 2 wheels.
     * They both start at the same x coordinate. I also created a finish line to identify who won.
     * 
     * For rectangle + finish line: line 81 of Player.java
     * For circle: line 111 of Player.java
     * *****************************************************************************************************************
     ******** Event Listener Requirement ********
     *
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least one ActionListener, and there is additionally at least
     * one MouseListener or ActionListener. Be clear to identify in what file
     * and the line numbers that these listeners are defined in.
     * 
     * *****************************************************************************************************************
     * Every class that has jframes also has a button. Those buttons all have some form of action event whether it's to return to menu,
     * or play again, or go to a different menu, or to boost to gain an advantage. All of these buttons utilized ActionListeners.
     * The player class heavily relies on MouseListener event to play the game.
     * 
     * Examples:
     * ActionListener: Line 27, 49, 50, 62  of Main.java  <- in order of importance. First is button, middle two assign action event to button,
     * and last one is the purpose of the action event
     * 
     * MouseListener: Line 166 of Player.java 
     * *****************************************************************************************************************
     */

        public static void main(String[] args) {
        Main m = new Main();
    }

}