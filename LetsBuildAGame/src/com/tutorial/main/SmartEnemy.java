package com.tutorial.main;

import java.awt.*;

public class SmartEnemy extends  GameObject{

    private Handler handler;

    private GameObject player;


    public SmartEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        //make a for loop to set enemy player object to the real player object
        for (int i =0; i < handler.object.size(); i++){
            if (handler.object.get(i).getID() == ID.Player) player = handler.object.get(i);

        }//end for loop




    }// end BasicEnemy

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);

    }//end getBounds


    public void tick() {
        //make the objects move across the screen
        x += velX;
        y += velY;


        //this is for the smartenemy movement to follow the player
        float diffX = x - player.getX() - 16;
        float diffY = y - player.getY() - 16;
        float distance = (float) Math.sqrt((x - player.getX()) *(x - player.getX())  + (y - player.getY()) *(y - player.getY()) );

        velX = (float) ((-1/ distance) * diffX);
        velY = (float) ((-1 / distance) * diffY);

        //make enemy bounce on screen
        //if(y <= 0 || y >= Game.HEIGHT-32) velY *= -1;
        //if(x <= 0 || x >= Game.WIDTH-16) velX *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, Color.green ,16 ,16 ,0.02f , handler));



    }//end tick


    public void render(Graphics g) {

        g.setColor(Color.green);
        g.fillRect((int)x, (int)y, 16, 16);


    }//end render
}//end class BasicEnemy

