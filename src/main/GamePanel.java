package main;

import entity.Player;
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

    //when i instantiate a class i always pass (this) because im passing the gamepanel from iinside gp class

    //instantiate tilemanager
    TileManage tileM = new TileManage(this);

    //fps
    int FPS = 60;

    //instantiating keyhandler = movement
    keyHandler keyH = new keyHandler();
    Thread gameThread;

    //instantiating player class
    Player player = new Player(this,keyH);

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
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
        player.update();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        //draw tiles
        tileM.draw(g2);
        //draw the player
        player.draw(g2);

        g2.dispose();
    }

}
