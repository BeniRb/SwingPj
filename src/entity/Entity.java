package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    // the whole map
    public int worldX,worldY;

    public int speed;

    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
    public String direction;

    public int spriteCounter=0;
    public int spriteNum=1;
// for player collision
    public Rectangle solidArea;
    public int solidAreaDefX,solidAreaDefY;
    public boolean isCollided = false;
}
