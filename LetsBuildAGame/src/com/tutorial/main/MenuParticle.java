package com.tutorial.main;

import java.awt.*;
import java.util.Random;

public class MenuParticle  extends GameObject{

    private Handler handler;
    Random r = new Random();

    private Color col;


    public MenuParticle(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        //make enemy bounce on screen
        velX = (r.nextInt(7 - -7) + -7);
        velY= (r.nextInt(7 - -7) + -7);
        if (velX == 0 ) velX = 1; //fix bug
        if (velY == 0 ) velY = 1;//fix bug



        col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));



    }// end BasicEnemy

    public Rectangle getBounds(){
        return new Rectangle((int)x,(int) y, 16, 16);

    }//end getBounds


    public void tick() {
        //make the objects move across the screen
        x += velX;
        y += velY;

        //make enemy bounce on screen
        if(y <= 0 || y >= Game.HEIGHT-32) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH-16) velX *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, col ,16 ,16 ,0.05f , handler));



    }//end tick


    public void render(Graphics g) {

        g.setColor(col);
        g.fillRect((int)x, (int)y, 16, 16);


    }//end render
}//end class FastEnemy

