package main;

import object.Obj_golden_key;
import object.Obj_key;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {
    Graphics2D g2;
    GamePanel gp;
    Font arial;
    BufferedImage silverKeyImage;
    BufferedImage goldenKeyImage;

    public boolean displayMsg= false;
    public String msg = "";
    int msgCounter = 0;
    public boolean finishGame = false;
    public int commandNumber =0;


    public UI(GamePanel gp) {
        this.gp = gp;
        arial = new Font("Arial", Font.PLAIN, 30);
        Obj_key key = new Obj_key();
        silverKeyImage = key.image;
        Obj_golden_key golden_key = new Obj_golden_key();
        goldenKeyImage = golden_key.image;
    }
    //method showing msgson map
    public void showMsg(String text) {
        msg = text;
        displayMsg = true;

    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        // i need to draw the number of keys the player has
        // the total number of keys collected
        // golden keys the player has
        //font for messages
        //check if game is finished

        if(finishGame) {
            g2.setFont(arial);
            g2.setColor(Color.white);
            String text ="Congratulations! You won!";
            int textLen;
             textLen = text.length();
            int x = gp.getWidth()/2 - textLen/2;
            int y = gp.getHeight()/2;
            g2.drawString(text, x, y);
            gp.gameThread = null;
        }
        //titlestate
        if(gp.gameState == gp.titlestate) {
            drawTitleScreen();
        }
        //gamestate
        if (gp.gameState == gp.playstate) {
            g2.setFont(arial);
            g2.setColor(Color.white);
            //silver key draw
            g2.drawImage(silverKeyImage, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
            g2.drawString("X " + gp.player.hasKeys, 65, 60);
            //gold key draw
            g2.drawImage(goldenKeyImage, 26, 80, gp.tileSize, gp.tileSize, null);
            g2.drawString("X " + gp.player.hasGoldKey, 65, 120);


            g2.drawString("total silver keys x " + gp.player.keyCounter, 400, 50);
            g2.drawString("total gold keys x " + gp.player.goldKeyCounter, 400, 90);
            //msg
            if (displayMsg) {
                g2.drawString(msg, gp.tileSize / 2, gp.tileSize * 5);
                msgCounter++;
//handle the timing of the msg 120 fps== 2 sec
                if (msgCounter == 120) {
                    msgCounter = 0;
                    displayMsg = false;
                }
            }
        }
        //pausestate
        if(gp.gameState == gp.pausestate){
            drawPauseScreen();
//                g2.drawString("PAUSED",gp.screenHeight/2,gp.screenWidth/2);
            }
    }
    public void drawTitleScreen() {
        g2.setColor(new Color(34, 139, 34));
        g2.fillRect(0,0,gp.screenWidth, gp.screenHeight);
        int xPos;
        int yPos;
        //title name
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,50f));
        String text = "Path To The Prize";
        xPos = getXforText(text);
        yPos = gp.tileSize * 2;
        //text shadow
        g2.setColor(Color.black);
        g2.drawString(text, xPos+3, yPos+3);
        //text color
        g2.setColor(Color.white);
        g2.drawString(text, xPos, yPos);

        //game explanation
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 20f));
        g2.setColor(Color.white);
        text = " Welcome to my game!\n"
                + "You need to go through the maze and collect keys\n"
                +"you'll notice you have items that give you certain buffs\n"
                +"some doors need different keys to open\n"
                +"the total amount of keys is displayed on the right\n"
                +"Good luck!";
        yPos =gp.tileSize * 4;
        int lineHeight = g2.getFontMetrics().getHeight();
        for (String line : text.split("\n")) {
            xPos = getXforText(line);
            g2.drawString(line, xPos, yPos);
            yPos += lineHeight; // move down for next line
        }
        // start game button
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40f));
        g2.setColor(Color.white);
        text = "START GAME";
        xPos = getXforText(text);
        yPos = gp.tileSize * 8;
        g2.drawString(text, xPos, yPos);

        //get width and height for mouse
        FontMetrics fm = g2.getFontMetrics();
        int buttonWidth= fm.stringWidth(text);
        int buttonHeight = fm.getHeight();
    }
    public void drawPauseScreen() {
        g2.setFont(arial);
        g2.setColor(Color.white);
        String text = "PAUSED";
        int xPos = getXforText(text);
        int yPos = gp.getHeight()/2;
        g2.drawString(text,xPos,yPos);
    }
    public int getXforText(String text) {
        int length =(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.getWidth()/2 - length/2;
        return x;
    }
}
