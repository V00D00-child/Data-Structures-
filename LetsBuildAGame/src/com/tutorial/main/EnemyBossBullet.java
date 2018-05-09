package com.tutorial.main;

import java.awt.*;
import java.util.Random;

public class EnemyBossBullet extends  GameObject{

    private Handler handler;
    Random r  = new Random();


    public EnemyBossBullet(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        //make enemy bounce on screen
        velX = (r.nextInt(5 - -5) + -5); // give you a random from -5 - 5
        velY = 5;


    }// end BasicEnemy

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);

    }//end getBounds


    public void tick() {
        //make the objects move across the screen
        x += velX;
        y += velY;

        //make enemy bounce on screen
        //if(y <= 0 || y >= Game.HEIGHT-32) velY *= -1;
        //if(x <= 0 || x >= Game.WIDTH-16) velX *= -1;

        if (y >= Game.HEIGHT) handler.removeObject(this);

        handler.addObject(new Trail(x, y, ID.Trail, Color.red ,16 ,16 ,0.02f , handler));



    }//end tick


    public void render(Graphics g) {

        g.setColor(Color.red);
        g.fillRect((int)x, (int)y, 16, 16);


    }//end render
}//end class BasicEnemy
