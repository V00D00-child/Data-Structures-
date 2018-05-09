package com.tutorial.main;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Random r  = new Random(); //create a random instance
    Handler handler;


    public Player(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;



    }

    public  Rectangle getBounds(){
        return new Rectangle((int) x, (int)y, 32, 32);

    }//end getBounds

    public void tick() {

        //make the objects move across the screen
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH-37);
        y = Game.clamp(y, 0, Game.HEIGHT-60);

        handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.white ,32,32 ,0.05f , handler)); //trial for player

        collision();


    }

    public void collision(){

        for (int i = 0; i < handler.object.size(); i++){

            GameObject tempObject = handler.object.get(i);

            if (tempObject.getID() == ID.BasicEnemy || tempObject.getID() == ID.FastEnemy || tempObject.getID() == ID.SmartEnemy){ //tempObject is now basicENEMY
                if (getBounds().intersects(tempObject.getBounds())){
                    //collision code
                    HUD.HEAlTH -= 2;

                }//end nested loop
            }//end if statement
                //collision for boss enemy
                if (tempObject.getID() == ID.EnemyBoss) { //tempObject is now basicENEMY
                    if (getBounds().intersects(tempObject.getBounds())) {
                        //collision code
                        HUD.HEAlTH -= 200;

                    }//end nested loop
                }//end boss if


        }//end loop

    }//end collision


    public void render(Graphics g) {

        g.setColor(Color.white);
        g.fillRect((int)x, (int)y, 32, 32);

    }


}//end player class
