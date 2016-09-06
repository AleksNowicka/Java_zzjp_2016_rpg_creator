package com.politechnikalodzka.rpgcreator;

import com.politechnikalodzka.rpgcreator.enums.Gender;
import com.politechnikalodzka.rpgcreator.enums.TypeOfPictrues;
import com.politechnikalodzka.rpgcreator.utils.Pictures;
import com.politechnikalodzka.rpgcreator.view.WelcomeScreenView;

import java.awt.*;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        final WelcomeScreenView welcomeScreenView = new WelcomeScreenView("RPG Creator");
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InitializeDataPictures();
                    welcomeScreenView.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void InitializeDataPictures() {
        Pictures instance = Pictures.getInstance();
        instance.addPictures(TypeOfPictrues.HAIR, instance.getPathMale() + "3HairMale.png", 0, Gender.MALE);
        instance.addPictures(TypeOfPictrues.ACCESSORIES, instance.getPathMale() + "1AccessoryMale.png", 1, Gender.MALE);
        instance.addPictures(TypeOfPictrues.HAIR, instance.getPathMale() + "1HairMale.png", 2, Gender.MALE);
        instance.addPictures(TypeOfPictrues.HAT, instance.getPathMale() + "1HatMale.png", 3, Gender.MALE);
        instance.addPictures(TypeOfPictrues.OUTFIT, instance.getPathMale() + "1OutfitMale.png", 4, Gender.MALE);
        instance.addPictures(TypeOfPictrues.HAIR, instance.getPathMale() + "4HairMale.png", 5, Gender.MALE);
        instance.addPictures(TypeOfPictrues.EYES, instance.getPathMale() + "BlueEyesMale.png", 6, Gender.MALE);
        instance.addPictures(TypeOfPictrues.EYES, instance.getPathMale() + "BrownEyesMale.png", 7, Gender.MALE);
        instance.addPictures(TypeOfPictrues.EYES, instance.getPathMale() + "GreenEyesMale.png", 8, Gender.MALE);
        instance.addPictures(TypeOfPictrues.HAIR, instance.getPathMale() + "2HairMale.png", 9, Gender.MALE);
        instance.addPictures(TypeOfPictrues.HAT, instance.getPathMale() + "2HatMale.png", 10, Gender.MALE);
        instance.addPictures(TypeOfPictrues.OUTFIT, instance.getPathMale() + "2OutfitMale.png", 11, Gender.MALE);
        instance.addPictures(TypeOfPictrues.BASE, instance.getPathMale() + "BaseMale.png", 12, Gender.MALE);
        instance.addPictures(TypeOfPictrues.HAT, instance.getPathMale() + "BlankHat.png", 13, Gender.MALE);
        instance.addPictures(TypeOfPictrues.HAIR, instance.getPathMale() + "BlankHair.png", 14, Gender.MALE);
        instance.addPictures(TypeOfPictrues.ACCESSORIES, instance.getPathMale() + "BlankAccessory.png", 15, Gender.MALE);

        instance.addPictures(TypeOfPictrues.HAIR, instance.getPathFemale() + "Hair4.png", 16, Gender.FEMALE);
        instance.addPictures(TypeOfPictrues.ACCESSORIES, instance.getPathFemale() + "BlankAccessory.png", 17, Gender.FEMALE);
        instance.addPictures(TypeOfPictrues.HAIR, instance.getPathFemale() + "Hair1.png", 18, Gender.FEMALE);
        instance.addPictures(TypeOfPictrues.HAT, instance.getPathFemale() + "BlankHat.png", 19, Gender.FEMALE);
        instance.addPictures(TypeOfPictrues.OUTFIT, instance.getPathFemale() + "Outfit1.png", 20, Gender.FEMALE);
        instance.addPictures(TypeOfPictrues.HAIR, instance.getPathFemale() + "Hair2.png", 21, Gender.FEMALE);
        instance.addPictures(TypeOfPictrues.EYES, instance.getPathFemale() + "FemaleBrownEyes.png", 22, Gender.FEMALE);
        instance.addPictures(TypeOfPictrues.EYES, instance.getPathFemale() + "FemaleGreenEyes.png", 23, Gender.FEMALE);
        instance.addPictures(TypeOfPictrues.EYES, instance.getPathFemale() + "FemalevioletEyes.png", 24, Gender.FEMALE);
        instance.addPictures(TypeOfPictrues.HAIR, instance.getPathFemale() + "Hair3.png", 25, Gender.FEMALE);
        instance.addPictures(TypeOfPictrues.HAIR, instance.getPathFemale() + "BlankHair.png", 26, Gender.FEMALE);
        instance.addPictures(TypeOfPictrues.BASE, instance.getPathFemale() + "FemaleBase.png", 27, Gender.FEMALE);
    }
}
