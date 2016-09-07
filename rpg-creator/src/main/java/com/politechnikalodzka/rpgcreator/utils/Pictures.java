package com.politechnikalodzka.rpgcreator.utils;

import com.politechnikalodzka.rpgcreator.enums.Gender;
import com.politechnikalodzka.rpgcreator.picture.factory.PictureFactory;
import com.politechnikalodzka.rpgcreator.interfaces.Picture;
import com.politechnikalodzka.rpgcreator.enums.TypeOfPictures;
import com.politechnikalodzka.rpgcreator.interfaces.Factory;
import com.politechnikalodzka.rpgcreator.database.Character;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lbary
 */
public class Pictures {

    private static Pictures instance = null;

    private List<Picture> pictureToDraw;
    private List<Picture> allPicture;
    private Factory pictureFactory = new PictureFactory();
    private Gender gender = Gender.MALE;

    //Paths for different systems (Windows, Linux)
//    private String pathMale = "resources\\Male\\";
//    private String pathFemale = "resources\\Female\\";
    private String pathMale = "resources/Male/";
    private String pathFemale = "resources/Female/";

    protected Pictures() {
        this.pictureToDraw = new ArrayList();
        for (int i = 0; i < 6; i++) {
            pictureToDraw.add(null);
        }
        this.allPicture = new ArrayList();
    }

    public static Pictures getInstance() {
        if (instance == null) {
            instance = new Pictures();
        }
        return instance;
    }

    public void addPictures(TypeOfPictures type, String url, int id, Gender gender) {
        boolean isNotContain = true;
        for (int i = 0; i < allPicture.size(); i++) {
            if (allPicture.get(i).getURL().equals(url)) {
                isNotContain = false;
            }
        }
        if (isNotContain) {
            allPicture.add(pictureFactory.addPicture(type, url, id, gender));
        }
    }

    public void choosePicture(int ID) {
        for (int i = 0; i < allPicture.size(); i++) {
            if (allPicture.get(i).getID() == ID) {
                this.addToDrawList(allPicture.get(i).getType(), allPicture.get(i));
            }
        }
    }

    private void addToDrawList(TypeOfPictures type, Picture picture) {
        switch (type) {
            case BASE:
                pictureToDraw.set(5, picture);
                break;
            case OUTFIT:
                pictureToDraw.set(4, picture);
                break;
            case HAIR:
                pictureToDraw.set(3, picture);
                break;
            case EYES:
                pictureToDraw.set(2, picture);
                break;
            case HAT:
                pictureToDraw.set(1, picture);
                break;
            case ACCESSORIES:
                pictureToDraw.set(0, picture);
                break;
        }
    }

    public void setCurrentCharacter(Character character) {
        this.choosePicture(character.getAccessoriesId());
        this.choosePicture(character.getEyesId());
        this.choosePicture(character.getHairId());
        this.choosePicture(character.getHatId());
        this.choosePicture(character.getOutfitId());
        if(character.getGender() == 'm'){
            this.setGender(Gender.MALE);
            this.choosePicture(this.getPictureByType(TypeOfPictures.BASE).get(0).getID());
        }
        else{
            this.setGender(Gender.FEMALE);
            this.choosePicture(this.getPictureByType(TypeOfPictures.BASE).get(0).getID());
        }
    }

    public List<Picture> getPictureByType(TypeOfPictures type) {
        List<Picture> pictureByType = new ArrayList();
        for (Picture p : allPicture) {
            if (p.getGender().equals(gender) && p.getType().equals(type)) {
                pictureByType.add(p);
            }
        }
        return pictureByType;
    }

    public void setPictureToDraw() {
        for (int i = 0; i < 6; i++) {
            pictureToDraw.set(i, null);
        }
    }

    public String getPathMale() {
        return pathMale;
    }
    public String getPathFemale() {
        return pathFemale;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public List<Picture> getPictureToDraw() {
        return pictureToDraw;
    }
    public List<Picture> getAllPicture() {
        return allPicture;
    }
    public void setAllPicture(List<Picture> pictures) {
        this.allPicture = pictures;
    }
}
