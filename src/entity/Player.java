package entity;
import main.GamePanel;
import main.keyHandler;

import javax.imageio.ImageIO;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {
 GamePanel gp;
 keyHandler keyH;

 public Player(GamePanel gp, keyHandler keyH) {
     this.gp = gp;
     this.keyH = keyH;
//initializes default values
     setDefaultValues();
     // initializes players sprites
     getPlayerImage();
 }
// player starting pos and speed
 public void setDefaultValues() {
     x = 100;
     y = 100;
     speed = 3;
     direction = "down";
 }

 //loading players sprites
    public void getPlayerImage() {
     try {
         up1= ImageIO.read(getClass().getResourceAsStream("/player/up_1.png"));
         up2= ImageIO.read(getClass().getResourceAsStream("/player/up_2.png"));
         down1= ImageIO.read(getClass().getResourceAsStream("/player/down_1.png"));
         down2= ImageIO.read(getClass().getResourceAsStream("/player/down_2.png"));
         left1= ImageIO.read(getClass().getResourceAsStream("/player/left_1.png"));
         left2= ImageIO.read(getClass().getResourceAsStream("/player/left_2.png"));
         right1= ImageIO.read(getClass().getResourceAsStream("/player/right_1.png"));
         right2= ImageIO.read(getClass().getResourceAsStream("/player/right_2.png"));
     } catch (Exception e) {
         e.printStackTrace();
     }
    }
    //updating the images / cycling through them and updating it in game panel
 public void update() {
     //this if statement checks if and of themoving keys are pressed, if yes it starts the sprite cycle,basiclly changing the picture
     //if no key is pressed then the picture/ sprite remains static
     if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
         if(keyH.upPressed) {
             direction = "up";
             y-=speed;
         }
         else if(keyH.downPressed) {
             direction = "down";
             y+=speed;
         }
         else if(keyH.leftPressed) {
             direction = "left";
             x-=speed;
         }
         else  if(keyH.rightPressed) {
             direction = "right";
             x+=speed;
         }
         //sprite cycler / if you want to add more sprites you do that here
         //first you add images in getplayerimage
         // then add up3 in the draw method
         //and lastly update here
         // 15 is the speed it changes // faster = lower number, slower= higher number
         spriteCounter++;
         if(spriteCounter > 15) {
             if(spriteNum ==1){
                 spriteNum = 2;
             }
             else if(spriteNum ==2){
                 spriteNum = 1;
             }
             spriteCounter = 0;
         }
     }
 }
 public void draw(Graphics2D g2) {

     BufferedImage image = null;

     switch(direction) {
         case "up":
             if(spriteNum==1){
                 image = up1;
             }
             if(spriteNum==2){
                 image = up2;
             }
             break;
         case "down":
             if(spriteNum==1){
                 image = down1;
             }
             if(spriteNum==2){
                 image = down2;
             }
             break;
         case "left":
             if(spriteNum==1){
                 image = left1;
             }
             if(spriteNum==2){
                 image = left2;
             }
             break;
         case "right":
             if(spriteNum==1){
                 image = right1;
             }
             if(spriteNum==2){
                 image = right2;
             }
             break;
     }
     //image observer??
     g2.drawImage(image, x, y,gp.tileSize,gp.tileSize, null);
 }
}
