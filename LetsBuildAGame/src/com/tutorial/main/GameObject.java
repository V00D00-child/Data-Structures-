package com.tutorial.main;

import java.awt.Graphics;
import java.awt.Rectangle;



public abstract class GameObject {

    protected float x, y;
    protected ID id;
    protected float velX, velY; //variabel that control speed


    // ********************************************************************************************

    public GameObject(float x, float y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;

    }//end constructor
//********************************************************************************************

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();

//*****Create get and set methods***************************************************************************************

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setID(ID id) {
        this.id = id;
    }

    public ID getID() {

        return id;

    }
    public void setVelX(float velX) {

        this.velX = velX;
    }

    public void setVelY(int velY) {

        this.velY = velY;
    }
    public float getVelX(){
        return velX;
    }
    public float getVelY(){
        return velY;
    }




}//end gameObject class
