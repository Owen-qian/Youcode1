package main.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//sdfaf
public class gameguii {
    private Player player;
    private List<Monster> monsters;
    private int currentMonsterIndex;
    private boolean gameOver;
    ImageIcon playerIcon = new ImageIcon("./data/black outfit.jpeg");
    ImageIcon monsterIcon = new ImageIcon("./data/homework monster.jpeg");
    ImageIcon attimageIcon = new ImageIcon("./data/attack icon.jpg");
    Image attImage = attimageIcon.getImage();
    Image newAttImage = attImage.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH);
    ImageIcon attImageIcon = new ImageIcon(newAttImage);

    ImageIcon healimageIcon = new ImageIcon("./data/healing icon.png");
    Image healImage = healimageIcon.getImage();
    Image newHealImage = healImage.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH);
    ImageIcon healImageIcon = new ImageIcon(newHealImage);

    ImageIcon boostimageIcon = new ImageIcon("./data/booster icon.png");
    Image boostImage = boostimageIcon.getImage();
    Image newboostImage = boostImage.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH);
    ImageIcon boostImageIcon = new ImageIcon(newboostImage);


    ImageIcon deficon = new ImageIcon("./data/shield picture.jpg");
    Image defImage = deficon.getImage();
    Image newdefImage = defImage.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH);
    ImageIcon defIcon = new ImageIcon(newdefImage);


    public gameguii() {
        // Initialize player
        player = new Player(100, 20, 10, 1.5, "Player"); // HP, damage, defence, multiplier, name of player

        // Initialize monsters
        monsters = new ArrayList<>();
        monsters.add(new Monster(80, 15, 5, 1.2, "Homework")); // HP, damage, defence, multiplier
        monsters.add(new Monster(100, 20, 8, 1.3, "The final exam"));
        monsters.add(new Monster(120, 25, 10, 1.4, "The life"));

        currentMonsterIndex = 0;
        gameOver = false;
    }

    public void start() {
        // Create the main frame
        JFrame frame = new JFrame("Keep Fighting");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(null); // Use null layout for absolute positioning

        // Create a panel for the player
        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        playerPanel.setBounds(10, 400, 300, 150); // Set position and size
        frame.add(playerPanel);

        // Create a label for the player's name
        JLabel playerNameLabel = new JLabel(player.getName());
        playerPanel.add(playerNameLabel);

        // Create a label for the player's image
        JLabel playerImageLabel = new JLabel(scaleImage(playerIcon.getImage(), 100, 100));
        playerPanel.add(playerImageLabel);

        // Create a label for the player's HP
        JLabel playerHPLabel = new JLabel("HP: " + player.getHP());
        playerPanel.add(playerHPLabel);

        // Create a panel for the monster
        JPanel monsterPanel = new JPanel();
        monsterPanel.setLayout(new FlowLayout());
        monsterPanel.setBounds(490, 10, 300, 150); // Set position and size
        frame.add(monsterPanel);

        // Create a label for the monster's name
        JLabel monsterNameLabel = new JLabel(monsters.get(currentMonsterIndex).getName());
        monsterPanel.add(monsterNameLabel);

        // Create a label for the monster's image
        JLabel monsterImageLabel = new JLabel(scaleImage(monsterIcon.getImage(), 200, 200));
        monsterPanel.add(monsterImageLabel);

        // Create a label for the monster's HP
        JLabel monsterHPLabel = new JLabel("HP: " + monsters.get(currentMonsterIndex).getHP());
        monsterPanel.add(monsterHPLabel);

        // Create the text area for displaying messages
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 10, 300, 380); // Set position and size
        frame.add(scrollPane);

        // Create buttons for player actions
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));
        buttonPanel.setBounds(320, 420, 300, 130); // Set position and size
        frame.add(buttonPanel);

        // Create buttons with images
        JButton attackButton = new JButton(attImageIcon);
        attackButton.setBackground(new Color(173, 216, 230));
        attackButton.setPreferredSize(new Dimension(70, 70));
        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerAction(1, textArea, monsterHPLabel);
            }
        });
        buttonPanel.add(attackButton);

        JButton defenceButton = new JButton(defIcon);
        defenceButton.setBackground(new Color(173, 216, 230));
        defenceButton.setPreferredSize(new Dimension(70, 70));
        defenceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerAction(2, textArea, monsterHPLabel);
            }
        });
        buttonPanel.add(defenceButton);

        JButton boostButton = new JButton(boostImageIcon);
        boostButton.setBackground(new Color(173, 216, 230));
        boostButton.setPreferredSize(new Dimension(70, 70));
        boostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerAction(3, textArea, monsterHPLabel);
            }
        });
        buttonPanel.add(boostButton);

        JButton healButton = new JButton(healImageIcon);
        healButton.setBackground(new Color(173, 216, 230));
        healButton.setPreferredSize(new Dimension(70, 70));
        healButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerAction(4, textArea, monsterHPLabel);
            }
        });
        buttonPanel.add(healButton);

        // Display the frame
        frame.setVisible(true);

        // Start the game
        textArea.append("Welcome to the Monster Battle!\n");
        textArea.append("You are facing " + monsters.get(currentMonsterIndex).getName() + ".\n");
    }

    private void playerAction(int action, JTextArea textArea, JLabel monsterHPLabel) {
        Monster currentMonster = monsters.get(currentMonsterIndex);
        switch (action) {
            case 1:
                textArea.append(player.getName() + " : " + player.useAttack(currentMonster) + "\n");
                break;
            case 2:
                textArea.append(player.getName() + " : " + player.useDefence() + "\n");
                break;
            case 3:
                textArea.append(player.getName() + " : " + player.useBooster() + "\n");
                break;
            case 4:
                textArea.append(player.getName() + " : " + player.useHealing() + "\n");
                break;
            default:
                textArea.append("Invalid action. Please choose again.\n");
        }

        monsterHPLabel.setText("HP: " + currentMonster.getHP()); // Update monster's HP display

        if (currentMonster.check()) {
            textArea.append("Good job, you defeated " + currentMonster.getName() + "\n");
            currentMonsterIndex++;
            if (currentMonsterIndex >= monsters.size()) {
                textArea.append("Never forget to work hard and keep going\n");
                gameOver = true;
                return;
            }
            player.setHP(100); // Reset player's HP
            textArea.append("Get ready for " + monsters.get(currentMonsterIndex).getName() + "\n");
        }
        monsterAction(textArea);
    }

    private void monsterAction(JTextArea textArea) {
        if (!gameOver) {
            Monster currentMonster = monsters.get(currentMonsterIndex);
            textArea.append(currentMonster.getName() + " : " + currentMonster.randomAction(player) + "\n");

            textArea.append("Your HP: " + player.getHP() + "\n");
            if (player.check()) {
                textArea.append("Game over! You were defeated by the monster.\n");
                gameOver = true;
            }
        }
    }

    private ImageIcon scaleImage(Image image, int width, int height) {
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    public static void main(String[] args) {
        gameguii game = new gameguii();
        game.start();
    }
}
