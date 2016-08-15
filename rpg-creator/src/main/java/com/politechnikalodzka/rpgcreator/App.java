package com.politechnikalodzka.rpgcreator;

import com.politechnikalodzka.rpgcreator.view.WelcomeScreenView;

import java.awt.*;

public class App {
    public static void main( String[] args ) throws ClassNotFoundException {
        final WelcomeScreenView welcomeScreenView = new WelcomeScreenView("RPG Creator");
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    welcomeScreenView.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
