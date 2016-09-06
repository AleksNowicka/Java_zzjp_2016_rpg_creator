package com.politechnikalodzka.rpgcreator.utils;

import com.politechnikalodzka.rpgcreator.enums.Gender;
import com.politechnikalodzka.rpgcreator.picture.factory.PictureFactory;
import com.politechnikalodzka.rpgcreator.interfaces.Picture;
import com.politechnikalodzka.rpgcreator.enums.TypeOfPictrues;
import com.politechnikalodzka.rpgcreator.interfaces.Factory;
import com.politechnikalodzka.rpgcreator.database.Character;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lbary
 */
public class Pictures {

    private List<Picture> pictrueToDraw;
    private List<Picture> allPicture;
    private Factory pictrueFactory = new PictureFactory();
    private Gender gender = Gender.MALE; //Default
    //TODO - always change depending on used system (Windows, Linux)
    private String pathMale = "resources\\Male\\";
    private String pathFemale = "resources\\Female\\";

    public Pictures() {
        this.pictrueToDraw = new ArrayList();
        for (int i = 0; i < 6; i++) {
            pictrueToDraw.add(null);
        }
        this.allPicture = new ArrayList();

        this.addPictures(TypeOfPictrues.HAIR, pathMale + "3HairMale.png", 0, Gender.MALE);
        this.addPictures(TypeOfPictrues.ACCESSORIES, pathMale + "1AccessoryMale.png", 1, Gender.MALE);
        this.addPictures(TypeOfPictrues.HAIR, pathMale + "1HairMale.png", 2, Gender.MALE);
        this.addPictures(TypeOfPictrues.HAT, pathMale + "1HatMale.png", 3, Gender.MALE);
        this.addPictures(TypeOfPictrues.OUTFIT, pathMale + "1OutfitMale.png", 4, Gender.MALE);
        this.addPictures(TypeOfPictrues.HAIR, pathMale + "4HairMale.png", 5, Gender.MALE);
        this.addPictures(TypeOfPictrues.EYES, pathMale + "BlueEyesMale.png", 6, Gender.MALE);
        this.addPictures(TypeOfPictrues.EYES, pathMale + "BrownEyesMale.png", 7, Gender.MALE);
        this.addPictures(TypeOfPictrues.EYES, pathMale + "GreenEyesMale.png", 8, Gender.MALE);
        this.addPictures(TypeOfPictrues.HAIR, pathMale + "2HairMale.png", 9, Gender.MALE);
        this.addPictures(TypeOfPictrues.HAT, pathMale + "2HatMale.png", 10, Gender.MALE);
        this.addPictures(TypeOfPictrues.OUTFIT, pathMale + "2OutfitMale.png", 11, Gender.MALE);
        this.addPictures(TypeOfPictrues.BASE, pathMale + "BaseMale.png", 12, Gender.MALE);
        this.addPictures(TypeOfPictrues.HAT, pathMale + "BlankHat.png", 13, Gender.MALE);
        this.addPictures(TypeOfPictrues.HAIR, pathMale + "BlankHair.png", 14, Gender.MALE);
        this.addPictures(TypeOfPictrues.ACCESSORIES, pathMale + "BlankAccessory.png", 15, Gender.MALE);
        
        
        this.addPictures(TypeOfPictrues.HAIR, pathFemale + "Hair4.png", 16, Gender.FEMALE);
        this.addPictures(TypeOfPictrues.ACCESSORIES, pathFemale + "BlankAccessory.png", 17, Gender.FEMALE);
        this.addPictures(TypeOfPictrues.HAIR, pathFemale + "Hair1.png", 18, Gender.FEMALE);
        this.addPictures(TypeOfPictrues.HAT, pathFemale + "BlankHat.png", 19, Gender.FEMALE);
        this.addPictures(TypeOfPictrues.OUTFIT, pathFemale + "Outfit1.png", 20, Gender.FEMALE);
        this.addPictures(TypeOfPictrues.HAIR, pathFemale + "Hair2.png", 21, Gender.FEMALE);
        this.addPictures(TypeOfPictrues.EYES, pathFemale + "FemaleBrownEyes.png", 22, Gender.FEMALE);
        this.addPictures(TypeOfPictrues.EYES, pathFemale + "FemaleGreenEyes.png", 23, Gender.FEMALE);
        this.addPictures(TypeOfPictrues.EYES, pathFemale + "FemalevioletEyes.png", 24, Gender.FEMALE);
        this.addPictures(TypeOfPictrues.HAIR, pathFemale + "Hair3.png", 25, Gender.FEMALE);
        this.addPictures(TypeOfPictrues.HAIR, pathFemale + "BlankHair.png", 26, Gender.FEMALE);
        this.addPictures(TypeOfPictrues.BASE, pathFemale + "FemaleBase.png", 27, Gender.FEMALE);
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Picture> getPictrueToDraw() {
        return pictrueToDraw;
    }

    public List<Picture> getAllPicture() {
        return allPicture;
    }

    public List<Picture> getPictureByType(TypeOfPictrues type) {
        List<Picture> pictrueByType = new ArrayList();

        for (Picture p : allPicture) {
            if (p.getGender().equals(gender) && p.getType().equals(type)) {
                pictrueByType.add(p);
            }
        }
        return pictrueByType;
    }

    public void addPictures(TypeOfPictrues type, String url, int id, Gender gender) {
        boolean isNotContain = true;
        for (int i = 0; i < allPicture.size(); i++) {
            if (allPicture.get(i).getURL().equals(url)) {
                isNotContain = false;
            }
        }

        if (isNotContain) {
            allPicture.add(pictrueFactory.addPicture(type, url, id, gender));
            this.choosePicture(id);
        }
    }

    public void choosePicture(int ID) {
        for (int i = 0; i < allPicture.size(); i++) {
            if (allPicture.get(i).getID() == ID) {
                this.addToDrawList(allPicture.get(i).getType(), allPicture.get(i));
            }
        }
    }

    private void addToDrawList(TypeOfPictrues type, Picture picture) {
        switch (type) {
            case BASE:
                pictrueToDraw.set(5, picture);
                break;
            case OUTFIT:
                pictrueToDraw.set(4, picture);
                break;
            case HAIR:
                pictrueToDraw.set(3, picture);
                break;
            case EYES:
                pictrueToDraw.set(2, picture);
                break;
            case HAT:
                pictrueToDraw.set(1, picture);
                break;
            case ACCESSORIES:
                pictrueToDraw.set(0, picture);
                break;
        }
    }

    public void setCurrentCharacter(Character character) { // Ta metoda pobiera dane na temat obrazk�w dla aktualnie wybranego Character'a
        this.choosePicture(character.getAccessoriesId());
        this.choosePicture(character.getEyesId());
        this.choosePicture(character.getGroupId());
        this.choosePicture(character.getHairId());
        this.choosePicture(character.getHatId());
        this.choosePicture(character.getOutfitId());
        this.setGender(Gender.valueOf(String.valueOf(character.getGender())));
        //this.setGender(character.getGender()) // ta linijka b�dzie prawid�owa po dokonaniu zmian w Character
    }
    
    public void setAllPicture(List<Picture> pictures) {
        this.allPicture = pictures;
    }
}
