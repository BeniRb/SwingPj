package main;

import object.Obj_golden_key;
import object.Obj_key;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {

    GamePanel gp;
    Font arial;
    BufferedImage silverKeyImage;
    BufferedImage goldenKeyImage;
    public UI(GamePanel gp) {
        this.gp = gp;
        arial = new Font("Arial", Font.PLAIN, 30);
        Obj_key key = new Obj_key();
        silverKeyImage = key.image;
        Obj_golden_key golden_key = new Obj_golden_key();
        goldenKeyImage = golden_key.image;
    }

    public void draw(Graphics2D g2) {
        // i need to draw the number of keys the player has
        // the total number of keys collected
        // golden keys the player has
        //font for messages
        g2.setFont(arial);
        g2.setColor(Color.white);
        //silver key draw
        g2.drawImage(silverKeyImage,gp.tileSize/2,gp.tileSize/2,gp.tileSize,gp.tileSize,null);
        g2.drawString("X "+ gp.player.hasKeys, 65,60);
        //gold key draw
        g2.drawImage(goldenKeyImage,26,80,gp.tileSize,gp.tileSize,null);
        g2.drawString("X "+ gp.player.hasGoldKey, 65,120);


        g2.drawString("collected silver keys x "+gp.player.keyCounter, 400,50);
        g2.drawString("collected gold keys x "+gp.player.goldKeyCounter, 400,90);
    }
}
