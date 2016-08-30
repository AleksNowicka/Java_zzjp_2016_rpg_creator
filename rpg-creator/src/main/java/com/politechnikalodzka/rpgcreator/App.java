package com.politechnikalodzka.rpgcreator;

import com.politechnikalodzka.rpgcreator.picture.ManagePictures;
import com.politechnikalodzka.rpgcreator.view.WindowSwitcher;

public class App {

    public static void main(String[] args) throws ClassNotFoundException {
        //DataBase database = new DataBase();
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    WelcomeScreen window = new WelcomeScreen();
//                    window.frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
        ManagePictures mP = new ManagePictures();
        WindowSwitcher windowSwitcher = new WindowSwitcher("RPG Creator", mP);
        windowSwitcher.launchGui();
    }
}
