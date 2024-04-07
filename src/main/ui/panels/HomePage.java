package main.ui.panels;

import main.ui.AppGUI;

import javax.swing.*;

public class HomePage extends JPanel {

    private JButton startbtn;
    private AppGUI app;

    public HomePage(AppGUI app) {
        this.app = app;
        startbtn = new JButton("Get Started");
        //setLayout(null);
        add(startbtn);
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
