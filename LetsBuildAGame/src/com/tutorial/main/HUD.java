package com.tutorial.main;

import java.awt.*;

public class HUD {

    public static float HEAlTH = 100;
    private float greenValue = 255;

    private int score = 0;
    private int level = 1;

    public void tick(){
        HEAlTH = Game.clamp(HEAlTH,0,100);
        greenValue =  Game.clamp(greenValue, 0, 255);

        greenValue = HEAlTH*2;
        score ++;


    }

    public void render(Graphics g){

        g.setColor(Color.gray);
        g.fillRect(15, 15, 200,32);
        g.setColor(new Color(75, (int)greenValue, 0));
        g.fillRect(15, 15, (int)HEAlTH*2,32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200,32);

        g.drawString("Score: " + score, 15, 64);
        g.drawString("Level: " + level, 15, 80);


    }

    public void setscore(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }

}//end hud class
