package com.politechnikalodzka.rpgcreator.picture.factory;

import com.politechnikalodzka.rpgcreator.enums.Gender;
import com.politechnikalodzka.rpgcreator.interfaces.Picture;

/**
 *
 * @author lbary
 */
public class Hat extends Picture {

    private int ID;
    private String URL;
    private final int priority = 5;
    private Gender gender;

    public Hat(int id, String url) {
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
    public int getPriority() {
        return priority;
    }

    @Override
    public Gender getGender() {
        return gender;
    }
}
