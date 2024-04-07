package main.ui;

import javax.swing.*;
import java.awt.*;

public class ChatGPTGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            // Create panels for character sprites and health bars
            JPanel characterPanel = new JPanel();
            JPanel healthPanel = new JPanel();
            JPanel buttonsPanel = new JPanel();
            buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
            buttonsPanel.add(Box.createVerticalStrut(10));
            buttonsPanel.add(Box.createHorizontalStrut(10));

            // Add JLabels for character sprites (replace with actual images)
            JLabel playerSprite = new JLabel("Character sprite here");//new ImageIcon("player.png"));
            JLabel enemySprite = new JLabel("Monster sprite here");//new ImageIcon("enemy.png"));

            // Create health bars (custom components or images)
            int playerHealth = 100; // Example health value
            int enemyHealth = 100;   // Example health value
            JProgressBar playerHealthBar = new JProgressBar(0, 100);
            JProgressBar enemyHealthBar = new JProgressBar(0, 100);
            playerHealthBar.setValue(playerHealth);
            enemyHealthBar.setValue(enemyHealth);

            // Create action buttons
            JButton attackButton = new JButton("Attack");
            JButton defendButton = new JButton("Defend");
            JButton healButton = new JButton("Heal");
            JButton boostButton = new JButton("Boost");

            // Add components to panels
            characterPanel.add(playerSprite);
            characterPanel.add(enemySprite);
            healthPanel.add(playerHealthBar);
            healthPanel.add(enemyHealthBar);
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