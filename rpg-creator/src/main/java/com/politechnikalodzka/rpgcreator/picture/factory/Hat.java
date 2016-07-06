package com.politechnikalodzka.rpgcreator.picture.factory;

import com.politechnikalodzka.rpgcreator.picture.Picture;

/**
 *
 * @author lbary
 */
public class Hat extends Picture {
    private int ID;
    private String URL;
    private final int priority = 6;
    
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
}
