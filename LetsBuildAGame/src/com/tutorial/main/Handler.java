package com.tutorial.main;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

//create a list of all object in game
    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick(){
        for( int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);

            tempObject.tick();


        }//end for

    }

    public void render(Graphics g){

        for( int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }//end for loop

    }

    public void clearEnemys(){
        for( int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            if (tempObject.getID() == ID.Player)
            {
                object.clear();
                if (Game.gameState != Game.STATE.End)
                addObject(new Player((int)tempObject.getX(), (int)tempObject.getY(),ID.Player, this));
            }//end if
        }//end for loop
    }

//handel adding and removing items for your list
    public void addObject(GameObject object){
        this.object.add(object);
    }

    public void removeObject(GameObject object){
        this.object.remove(object);
    }




}//end class handler
