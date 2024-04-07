package main.ui.panels;

import main.ui.AppGUI;

import javax.swing.*;
import java.awt.*;

public class HomePage extends JPanel {

    private JButton startbtn;
    private AppGUI app;

    private int width;
    private int height;

    public HomePage(AppGUI app) {
        this.app = app;
        this.width = app.getWIDTH();
        this.height = app.getHEIGHT();
        startbtn = new JButton("Get Started");
        startbtn.setBackground(new Color(149, 208, 90));
        setLayout(null);
        add(startbtn);
        startbtn.setLocation(WIDTH / 2,HEIGHT / 2);
        //startbtn.setVisible(true);
        //startbtn.setLocation(200, 200);
        startbtn.setVisible(true);
        btnaction();
    }

    public void btnaction() {
        startbtn.addActionListener(app);
    }

    public JButton getStartbtn() {
        return startbtn;
    }
}
