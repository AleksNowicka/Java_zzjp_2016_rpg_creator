package com.politechnikalodzka.rpgcreator.picture.factory;

import com.politechnikalodzka.rpgcreator.picture.Picture;

/**
 *
 * @author lbary
 */
public class Hair extends Picture {
    private int ID;
    private String URL;
    private final int priority = 5;
    
    public Hair(int id, String url) {
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
