package main.ui;

import javax.swing.*;
import java.awt.*;

public class BattleScreenGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            // Create panels for character sprites and health bars
            JPanel characterPanel = new JPanel(new BorderLayout());
            characterPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JPanel statsNums = new JPanel(new BorderLayout());
            statsNums.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JPanel statsSymbols = new JPanel(new BorderLayout());
            statsSymbols.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JPanel healthPanel = new JPanel(new BorderLayout());
            healthPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            JPanel buttonsPanel = new JPanel();
            buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
            buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // Add JLabels for character sprites (also resize images)
            ImageIcon playerIcon = new ImageIcon("./data/black outfit.jpeg");
            Image playerImage = playerIcon.getImage(); // transform it 
            Image newimg = playerImage.getScaledInstance(200, 300,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            playerIcon = new ImageIcon(newimg);  // transform it back
            ImageIcon monsterIcon = new ImageIcon("./data/homework monster.jpeg");
            Image monsterImage = monsterIcon.getImage(); // transform it 
            Image tempimg = monsterImage.getScaledInstance(300, 500,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            monsterIcon = new ImageIcon(tempimg);  // transform it back
            JLabel playerSprite = new JLabel(playerIcon);
            JLabel monsterSprite = new JLabel(monsterIcon);

            // create stats symbols
            JPanel statSymbolpair = new JPanel();
            ImageIcon shieldIcon = new ImageIcon("./data/homework monster.jpeg");

            // Create health bars
            int playerHealth = 100; // Example health value
            int monsterHealth = 100;   // Example health value
            JProgressBar playerHealthBar = new JProgressBar(0, 100);
            playerHealthBar.setStringPainted(true);
            playerHealthBar.setForeground(Color.green);
            playerHealthBar.setValue(playerHealth); // must set to player's actual health
            playerHealthBar.setString(playerHealth + "%");
            JProgressBar monsterHealthBar = new JProgressBar(0, 100);
            monsterHealthBar.setStringPainted(true);
            monsterHealthBar.setForeground(Color.green);
            monsterHealthBar.setValue(monsterHealth); // must set monster's actual health
            monsterHealthBar.setString(monsterHealth + "%");

            // Create action buttons
            JButton attackButton = new JButton("Attack");
            JButton defendButton = new JButton("Defend");
            JButton healButton = new JButton("Heal");
            JButton boostButton = new JButton("Boost");

            // Add components to panels
            characterPanel.add(playerSprite, BorderLayout.WEST);
            characterPanel.add(monsterSprite, BorderLayout.EAST);

            healthPanel.add(playerHealthBar, BorderLayout.WEST);
            healthPanel.add(monsterHealthBar, BorderLayout.EAST);
            buttonsPanel.add(attackButton);
            buttonsPanel.add(defendButton);
            buttonsPanel.add(healButton);
            buttonsPanel.add(boostButton);

            // Set layout for the main frame
            frame.setLayout(new BorderLayout());
            frame.add(characterPanel, BorderLayout.CENTER);
            frame.add(healthPanel, BorderLayout.NORTH);
            frame.add(buttonsPanel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }
}