package com.tutorial.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;


public class Game extends Canvas implements Runnable{


    private static final long serialVersionUID = 1550691097823471818L;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9; //height can be set to watever you want
    //create a thread
    private Thread thread; //game will be a single threaded game
    private boolean running = false;
    private Random r; //create a random instance
    private Handler handler; //will run through every object in the game and render it
    private HUD hud;
    private Spawn spawner;
    private Menu menu;

    public enum STATE {
        Menu,
        Help,
        End,
        Game
    };

    public static STATE gameState = STATE.Menu;



    public Game(){

        handler = new Handler();
        hud = new HUD();
        menu = new Menu(this, handler,hud);
        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(menu);

        new Window(WIDTH, HEIGHT, "Let's Build a Game!", this);

        spawner = new Spawn(handler, hud);

        r = new Random();

        if (gameState == STATE.Game){
            handler.addObject(new Player((int)WIDTH/2-32, (int)HEIGHT/2-32, ID.Player,handler)); //create object and add it to game, get random height and width
            handler.addObject(new BasicEnemy(r.nextInt((int)Game.WIDTH - 50), r.nextInt((int)Game.HEIGHT - 50), ID.BasicEnemy, handler));
        }else{

            //this creates the meun screen particles
            for (int i = 0; i < 20; i++){
                handler.addObject(new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuParticle, handler));

            }//end for loop
        }//end else

        // handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy,handler));
        //handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy,handler));

    }//end Game()
    //********************************************************************************************

    public synchronized void start(){

        // start the game
        thread = new Thread(this);
        thread.start();
        running = true;
    }//end synchronized()
    //********************************************************************************************

    public synchronized void stop(){

       try{
           thread.join();
           running = false;
       }catch(Exception e){
           e.printStackTrace();
       }//end catch

    }//end synchronized()
    // ********************************************************************************************

    public void run(){
        //set up the game loop the heart of the game
        this.requestFocus(); //so you dont have to click on the screen to move player
        long lastTime = System.nanoTime();
        double amountOFTicks = 60.0;
        double ns = 1000000000 / amountOFTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        float frames = 0;

        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;

            }//end nested while
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;

            }//end if

        }//end while
        stop();

    }//end run()
    //********************************************************************************************
    private void tick(){
        handler.tick();

        if (gameState == STATE.Game){
            hud.tick();
            spawner.tick();

            //IF THE PLAYER HEATH REACHES 0 GO TO END STATE
            if (HUD.HEAlTH <= 0){
                HUD.HEAlTH = 100;
                gameState = STATE.End;
                handler.clearEnemys();
                //this creates the meun screen particles
                for (int i = 0; i < 20; i++){
                    handler.addObject(new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuParticle, handler));

                }//end for loop


            }//end if
        }else if (gameState == STATE.Menu || gameState == STATE.End){

            menu.tick();

        }

    }//end tick
    //********************************************************************************************
    private void render(){

        BufferStrategy bs = this.getBufferStrategy(); // starts out as null
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }//end if


        //set graphics
        Graphics g = bs.getDrawGraphics();

        // place background to hid fps flash
        g.setColor(Color.black);
        g.fillRect(0, 0, (int)WIDTH, (int)HEIGHT);

        handler.render(g);

        if (gameState == STATE.Game){
            hud.render(g);
        }else if (gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End){

            menu.render(g);

        }

        g.dispose();
        bs.show();

    }//end render
    //********************************************************************************************

    public static float clamp(float var, float min, float max){
        if (var >= max)
            return var = max;
        else if(var <= min)
            return var = min;
        else
            return var;

    }//end clamp

    public static void main(String args []){

        new Game();//run the game



    }//main method




}//end game
