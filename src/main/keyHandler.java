package main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class keyHandler implements KeyListener {
    public boolean upPressed,downPressed,leftPressed,rightPressed;
    GamePanel gp;
    UI ui = new UI(gp);
    @Override
    public void keyTyped(KeyEvent e) {

    }
    public keyHandler(GamePanel gp) {
        this.gp =gp;
        gp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMouseClick(e);
            }
        });
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if(code == KeyEvent.VK_A) {
            leftPressed = true;
        }
        if(code == KeyEvent.VK_S) {
            downPressed = true;
        }
        if(code == KeyEvent.VK_D) {
            rightPressed = true;
        }
        if(code == KeyEvent.VK_ESCAPE) {
            if(gp.gameState== gp.playstate){
                gp.gameState = gp.pausestate;
            } else if (gp.gameState== gp.pausestate) {
                gp.gameState = gp.playstate;
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if(code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if(code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if(code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
    //mouse handler
    private void handleMouseClick(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        if(StartGameButton(mouseX,mouseY)) {
            startGame();
        }
    }
    private boolean StartGameButton(int mouseX, int mouseY) {
        String text = "START GAME";
        int buttonX =gp.getWidth()/2;
        int buttonY =gp.tileSize*8;
        int buttonWidth = gp.getFontMetrics(gp.getFont().deriveFont(Font.PLAIN, 40f)).stringWidth(text);
        int buttonHeight = gp.getFontMetrics(gp.getFont().deriveFont(Font.PLAIN, 40f)).getHeight();
        //check if clicked
        return mouseX >= buttonX && mouseX <= buttonX + buttonWidth &&
                mouseY >= buttonY - buttonHeight && mouseY <= buttonY;
    }
    private void startGame() {
        gp.gameState = gp.playstate;
    }
}
