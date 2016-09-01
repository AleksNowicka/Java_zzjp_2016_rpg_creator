package com.politechnikalodzka.rpgcreator.picture.factory;

import com.politechnikalodzka.rpgcreator.enums.Gender;
import com.politechnikalodzka.rpgcreator.enums.TypeOfPictrues;
import com.politechnikalodzka.rpgcreator.interfaces.Picture;

/**
 *
 * @author lbary
 */
public class Eyes implements Picture {
    private int ID;
    private String URL;
    private TypeOfPictrues type = TypeOfPictrues.EYES;
    private Gender gender;

    public Eyes(int id, String url) {
        this.ID = id;
        this.URL = url;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getURL() {
        return URL;
    }
    
    @Override
    public TypeOfPictrues getType() {
        return type;
    }

    @Override
    public Gender getGender() {
        return gender;
    }
}