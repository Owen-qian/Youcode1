package main.ui;

import main.model.Game;
import main.ui.panels.GamePanel;
import main.ui.panels.HomePage;
import main.ui.panels.MenuPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppGUI extends JFrame implements ActionListener {

    private Game game;
    private HomePage homePage;
    private MenuPanel menu;
    private GamePanel gamepanel;
    private JLabel leavesImg;

    private static final int WIDTH = 800;
    private static final int HEIGHT = 500;

    public AppGUI() {
        game = new Game();
        setSize(WIDTH, HEIGHT);
        setResizable(false);

        initView();
        setVisible(true);
    }

    public void initView() {
        homePage = new HomePage(this);
        getContentPane().add(homePage, BorderLayout.CENTER);
        homePage.setVisible(true);
    }

    public void initMainMenu() {

    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homePage.getStartbtn()) {
            homePage.setVisible(false);
            initMainMenu();
        }
    }
}
