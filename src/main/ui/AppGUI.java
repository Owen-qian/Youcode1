package main.ui;

import main.ui.panels.GamePanel;
import main.ui.panels.HomePage;
import main.ui.panels.MenuPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppGUI extends JFrame implements ActionListener {

    private HomePage homePage;
    private MenuPanel menu;
    private GamePanel gamepanel;

    private static final int WIDTH = 800;
    private static final int HEIGHT = 500;

    public AppGUI() {
        setSize(WIDTH, HEIGHT);
        setResizable(false);

        homePage = new HomePage();
        add(homePage);
        homePage.setVisible(true);
    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
