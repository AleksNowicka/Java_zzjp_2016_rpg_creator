package com.politechnikalodzka.rpgcreator.picture.factory;

import com.politechnikalodzka.rpgcreator.enums.Gender;
import com.politechnikalodzka.rpgcreator.enums.TypeOfPictrues;
import com.politechnikalodzka.rpgcreator.interfaces.Picture;

/**
 *
 * @author lbary
 */
public class Hat implements Picture {

    private int ID;
    private String URL;
    private TypeOfPictrues type = TypeOfPictrues.HAT;
    private Gender gender;

    public Hat(int id, String url, Gender gender) {
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

    public TypeOfPictrues getType() {
        return type;
    }

    public Gender getGender() {
        return gender;
    }
}
