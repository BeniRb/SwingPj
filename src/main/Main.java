package main;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setTitle("The Drunken Amish");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();
        window.setVisible(true);
        gamePanel.setupGame();
        // initializing game thread = basicly allowing everything to start
        gamePanel.startGameThread();
    }
}