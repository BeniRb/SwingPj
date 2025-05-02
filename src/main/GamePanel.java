package main;

import entity.Player;
import object.Sobject;
import tile.TileManage;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    // screen settings
    final int originalTileSize = 16; //16x16
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; // 48 tiles
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    //world settings
    public final int maxWorldCol = 63;
    public final int maxWorldRow = 60;
//    public final int worldWidth = tileSize * maxWorldCol;
//    public final int worldHeight = tileSize * maxWorldRow;

    //when i instantiate a class i always pass (this) because im passing the gamepanel from iinside gp class
    //instantiate tilemanager
    TileManage tileM = new TileManage(this);

    //fps
    int FPS = 60;

    //instantiating keyhandler = movement
    keyHandler keyH = new keyHandler(this);

    // instantiating ui
    public UI ui = new UI(this);
    Thread gameThread;
    //instantiating collision class
     public checkCollision cChecker = new checkCollision(this);

     //instantiate sound class
    Sound sound = new Sound();
    Sound SE = new Sound();

    //instantiate Asetter
    public ObjSetter aSetter = new ObjSetter(this);

     //instantiate object
    public Sobject [] obj = new Sobject[20];

    //game state
    public int gameState;
    public final int playstate = 1;
    public final int pausestate = 2;


    //instantiating player class
    //public so i can access it in other classes
    public Player player = new Player(this,keyH);


    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    //initilize game
    public void setupGame() {
        //places objects
        aSetter.setObj();
        //starts theme music
        playMusic(3);
        //gamestate
        gameState = playstate;
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    // the thread calls this run method basiclly a thread
    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {
            update();
            repaint();
            // let the thread sleep
            try {

                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000;

                if(remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void update() {
        if(gameState == playstate) {
            player.update();
        }
        if(gameState == pausestate) {
            //nothing for now
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        //draw tiles
        tileM.draw(g2);
        //draw objects
        for (int i = 0; i < obj.length; i++) {
            if(obj[i] != null) {
               obj[i].draw(g2, this);
            }
        }
        //draw the player
        player.draw(g2);

        //draw the ui
        ui.draw(g2);

        g2.dispose();
    }

    public void playMusic(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }
    public void stopMusic() {
        sound.stop();
    }
    public void playSoundE (int i) {
        SE.setFile(i);
        SE.play();
    }

}
