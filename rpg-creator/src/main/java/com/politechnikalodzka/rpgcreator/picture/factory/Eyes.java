package com.politechnikalodzka.rpgcreator.picture.factory;

import com.politechnikalodzka.rpgcreator.picture.Picture;

/**
 *
 * @author lbary
 */
public class Eyes extends Picture {
    private int ID;
    private String URL;
    private final int priority = 3;
    
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
    public int getPriority() {
        return priority;
    }
}
