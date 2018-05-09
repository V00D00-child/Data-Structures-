package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

    private Handler handler;
    private boolean[] keyDown = new boolean[4];


    public KeyInput(Handler handler){

        this.handler = handler;

        keyDown[0] = false; //w key
        keyDown[1] = false; //s key
        keyDown[2] = false; //d key
        keyDown[3] = false; //a key




    }//end KeyInput method

    public void keyPressed(KeyEvent e){

        int key = e.getKeyCode();

        // loop through all the objects in the game to detect key events fpr player 1
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getID() == ID.Player){

                //key events for player 1 movement
                if(key == KeyEvent.VK_W) { tempObject.setVelY(-5); keyDown[0] = true; }
                if(key == KeyEvent.VK_S) { tempObject.setVelY(5); keyDown[1] = true; }
                if(key == KeyEvent.VK_D) { tempObject.setVelX(5); keyDown[2] = true; }
                if(key == KeyEvent.VK_A) { tempObject.setVelX(-5); keyDown[3] = true; }

            }//end if

        }//end for loop

        if (key  == KeyEvent.VK_ESCAPE )System.exit(1);

    }//end keyPressed method

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        // loop through all the objects in the game to detect key events fpr player 1
        for(float i = 0; i <handler.object.size(); i++){

            GameObject tempObject = handler.object.get((int)i);

            if(tempObject.getID() == ID.Player){
                //key events for player 1 movement
                if(key == KeyEvent.VK_W) keyDown[0] = false; //tempObject.setVelY(0);
                if(key == KeyEvent.VK_S) keyDown[1] = false; //tempObject.setVelY(0);
                if(key == KeyEvent.VK_D) keyDown[2] = false; //tempObject.setVelX(0);
                if(key == KeyEvent.VK_A) keyDown[3] = false; //tempObject.setVelX(0);

                //vertical movement
                if (!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
                //horizontal movement
                if (!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);


            }//end if

        }//end for loop

        if (key  == KeyEvent.VK_ESCAPE )System.exit(1);


    }//end keyReleased()



}//end keyInput class
