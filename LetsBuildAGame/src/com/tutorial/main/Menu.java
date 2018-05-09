package com.tutorial.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {
    private Game game;
    private Handler handler;
    private Random r = new Random();
    private HUD hud;


    public  Menu(Game game, Handler handler, HUD hud){
        this.game = game;
        this.hud = hud;
        this.handler = handler;
    }


    public void mousePressed(MouseEvent e){

        int mx = e.getX();
        int my = e.getY();

        if (game.gameState == Game.STATE.Menu){

            //if the mouse is inside the play button
            if (mouseOver(mx, my,210,150,200,64)){
                game.gameState = Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player,handler)); //create object and add it to game, get random height and width
                handler.clearEnemys();
                handler.addObject(new BasicEnemy(r.nextInt((int)Game.WIDTH - 50), r.nextInt((int)Game.HEIGHT - 50), ID.BasicEnemy, handler));


            }///end if

            //if the mouse is inside the quit button
            if (mouseOver(mx , my , 210, 250, 200, 64)){
                game.gameState = Game.STATE.Help;
            }//END IF



            //if the mouse is inside the quit button
            if (mouseOver(mx, my, 210, 350, 200, 64)){
                System.exit(1);
            }//end if

        }//END IF


        //back button for help
        if (game.gameState == Game.STATE.Help){
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = Game.STATE.Menu;
                return;

            }//end nested if
        }//END IF

        //TRY AGAIN button for help
        if (game.gameState == Game.STATE.End){
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = Game.STATE.Game;
                hud.setLevel(1);
                hud.setscore(0);
                handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player,handler)); //create object and add it to game, get random height and width
                handler.clearEnemys();
                handler.addObject(new BasicEnemy(r.nextInt((int)Game.WIDTH - 50), r.nextInt((int)Game.HEIGHT - 50), ID.BasicEnemy, handler));


            }//end nested if
        }//END IF







    }

    public void mouseReleased(MouseEvent e){

    }

    private boolean mouseOver(int mx, int my, int x, int y,  int width, int height){

        if (mx > x && mx < x + width){
            if (my > y && my < y + height){
                return true;
            }else  return false;
        }else  return false;
    }

    public void tick(){

    }

    public void render(Graphics g){

        //this is the menu screen
        if (game.gameState == Game.STATE.Menu){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Wave", 240, 70);

            g.setFont(fnt2);
            g.drawRect(210, 150, 200, 64);
            g.drawString("Play", 270, 190);

            g.drawRect(210,250,200,64);
            g.drawString("Help", 270, 290);

            g.drawRect(210,350,200,64);
            g.drawString("Quit", 270, 390);
        }else if (game.gameState == Game.STATE.Help){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);


            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Help", 240, 70);

            //help text
            g.setFont(fnt3);
            g.drawString("Use WASD keys to dodge enemies", 50, 200);

            //MAKE A BACK BUTTON
            g.setFont(fnt2);
            g.drawRect(210,350,200,64);
            g.drawString("Back", 270, 390);
        }else if (game.gameState == Game.STATE.End){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);


            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Game Over", 180, 70);

            //help text
            g.setFont(fnt3);
            g.drawString("You lost with a score of: " + hud.getScore(), 175, 200);

            //MAKE A BACK BUTTON
            g.setFont(fnt2);
            g.drawRect(210,350,200,64);
            g.drawString("Try Again", 245, 390);
        }//END ELES IF




    }




}//end class
