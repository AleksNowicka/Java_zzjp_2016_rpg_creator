package com.politechnikalodzka.rpgcreator.picture.factory;

import com.politechnikalodzka.rpgcreator.enums.Gender;
import com.politechnikalodzka.rpgcreator.enums.TypeOfPictures;
import com.politechnikalodzka.rpgcreator.interfaces.Picture;

/**
 *
 * @author lbary
 */
public class Hair implements Picture {

    private int ID;
    private String URL;
    private TypeOfPictures type = TypeOfPictures.HAIR;
    private Gender gender;

    public Hair(int id, String url, Gender gender) {
        this.ID = id;
        this.URL = url;
        this.gender = gender;
    }

    public int getID() {
        return ID;
    }

    public String getURL() {
        return URL;
    }

    public TypeOfPictures getType() {
        return type;
    }

    public Gender getGender() {
        return gender;
    }
}
