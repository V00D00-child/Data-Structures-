package com.tutorial.main;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    private static final long serialVersionUID = -240840600533728354L;

    //Create a constutor********************************************************************************************

    public Window(int width, int height, String title, Game game){

        //create your window
        JFrame frame = new JFrame(title);  ///the frame of the window

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); // make it so you cant resize the window
        frame.setLocationRelativeTo(null); // makes the window start in the middle of the screen
        frame.add(game);
        frame.setVisible(true);
        game.start();  // call method from game call to start the game


    }//end constutor




}//end class windows
