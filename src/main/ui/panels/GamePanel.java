package main.ui.panels;

import main.model.Monster;
import main.model.Player;
import main.ui.AppGUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel {

    private Player player;
    private List<Monster> monsters;
    private int currentMonsterIndex;
    private boolean gameOver;

    private AppGUI app;
    private Image cartoon;
    private Image monster;
    private JLabel attackBtn;
    private JLabel healBtn;
    private JLabel defenseBtn;
    private JLabel boosterBtn;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel monsterHpPanel;
    private JProgressBar monsterHp;
    private JPanel personHpPanel;
    private JProgressBar personHp;

    private int width;
    private int height;


    public GamePanel(AppGUI app) {

        player = new Player(100, 20, 10, 1.5,"Player"); // HP, damage, defence, multiplier, name of player

        // Initialize monsters
        monsters = new ArrayList<>();
        monsters.add(new Monster(80, 15, 5, 1.2,"Homework")); // HP, damage, defence, multiplier
        monsters.add(new Monster(100, 20, 8, 1.3, "The final exam"));
        monsters.add(new Monster(120, 25, 10, 1.4,"The life"));

        currentMonsterIndex = 0;
        gameOver = false;

        this.app = app;
        width = app.getWIDTH();
        height = app.getHEIGHT();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        add(leftPanel);
        add(rightPanel);
        initLeftPanel();
        initRightPanel();
    }

    // EFFECTS: adds the character, their decision buttons, monster hp, character hp to left half of game panel
    public void initLeftPanel() {
        monsterHp = new JProgressBar();

        //
    }

    // EFFECTS: monster to the right half of the game panel
    public void initRightPanel() {
        //
    }



}
