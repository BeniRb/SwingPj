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
//indicating players screen
 public final int screenX;
 public final int screenY;
 public int hasKeys = 0;
 public int keyCounter = 0;
 public int hasGoldKey = 0;
 public int goldKeyCounter = 0;

 public Player(GamePanel gp, keyHandler keyH) {
     this.gp = gp;
     this.keyH = keyH;

     //because i want the center
     screenX = gp.screenWidth/2 - (gp.tileSize/2);
     screenY = gp.screenHeight/2 - (gp.tileSize/2);

//initializes default values
     setDefaultValues();
     // initializes players sprites
     getPlayerImage();

     //instantiating rectangle for collision
     //i pass the parameters that i want to collide with different tiles
     //if i wont like the way the player collides with the tiles i change the numbers
     solidArea = new Rectangle();
     solidArea.x = 8;
     solidAreaDefX = solidArea.x;
     solidAreaDefY = solidArea.y;
     solidArea.y = 16;
     solidArea.width = 32;
     solidArea.height = 32;
 }
// player starting pos and speed
 public void setDefaultValues() {
     worldX = gp.tileSize * 30;
     worldY = gp.tileSize * 31;
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
     //this if statement checks if and or the moving keys are pressed, if yes it starts the sprite cycle,basiclly changing the picture
     //if no key is pressed then the picture/ sprite remains static
     //also here we check for collision
     if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
         if(keyH.upPressed) {
             direction = "up";
         }
         else if(keyH.downPressed) {
             direction = "down";
         }
         else if(keyH.leftPressed) {
             direction = "left";
         }
         else  if(keyH.rightPressed) {
             direction = "right";
         }
// here i write all the collision code//checking tile collision
         isCollided = false;
         // im passing this player class because its a sub-class to entity
         gp.cChecker .checkTiles(this);
         //check obj collision
         int ObjIndex = gp.cChecker.checkObj(this,true);
         pickUpObj(ObjIndex);

         //if collision is false player can move
         if(!isCollided) {
             switch (direction){
                 case "up":
                     worldY-=speed;
                     break;
                 case "down":
                     worldY+=speed;
                     break;
                 case "left":
                     worldX-=speed;
                     break;
                 case "right":
                     worldX+=speed;
                     break;
             }
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

 public void pickUpObj(int i) {
     // you can put any number as long as it does touch the object
     if(i != 999){
       String objName= gp.obj[i].name;

       switch (objName) {
           case "Key":
               hasKeys++;
               keyCounter++;
               gp.obj[i] = null;
               gp.playSoundE(4);
               gp.ui.showMsg("Silver key acquired!");
               break;
           case "Wine":
               speed +=2;
               gp.playSoundE(1);
               gp.obj[i] = null;
                break;
           case "Water":
               speed-=2;
               gp.obj[i] = null;
               break;
           case "Door":
               if(hasKeys > 0) {
                   gp.playSoundE(0);
                   gp.obj[i] = null;
                   hasKeys--;
                   gp.ui.showMsg("Door is open!");
               }
               else{
                   gp.ui.showMsg("You need a silver key");
               }
               break;
           case "Golden key":
               gp.playSoundE(4);
               hasGoldKey++;
               goldKeyCounter++;
               gp.obj[i] = null;
               gp.ui.showMsg("Gold key acquired!");
               break;
           case "Golden door":
               if(hasGoldKey > 1 && keyCounter >= 3) {
                   gp.playSoundE(0);
                   gp.obj[i] = null;
                   hasGoldKey--;
                   gp.ui.showMsg("Golden door is open!");
                   gp.stopMusic();
               }
               else{
                   gp.ui.showMsg("You need to collect 3 silver keys and 2 gold keys");
//                   gp.ui.showMsg("you have " + goldKeyCounter + " gold keys");
//                   gp.ui.showMsg("you have " + keyCounter + " silver keys");
               }
               break;
           case "End chest":
               gp.ui.finishGame = true;
               gp.stopMusic();
               gp.playSoundE(2);
               break;
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
     g2.drawImage(image, screenX, screenY,gp.tileSize,gp.tileSize, null);
 }
}
