package com.politechnikalodzka.rpgcreator.picture;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lbary
 */
public class ManagePictures {
    private final List<Picture> pictrueToDraw;
    private final List<Picture> allPicture;

    public ManagePictures() {
        this.pictrueToDraw = new ArrayList();
        this.allPicture = new ArrayList();
    }

    public List<Picture> getPictrueToDraw() {
        return pictrueToDraw;
    }

    public List<Picture> getAllPicture() {
        return allPicture;
    }
    
    public void addPictures(int id, String url, TypeOfPictrues type)
    {
        if(!allPicture.contains(new Picture(id, url, type))) {
            allPicture.add(new Picture(id, url, type));
        }
    }
    
    private void setPriorityPicture(Picture picture)
    {        
        TypeOfPictrues tempType;
        tempType = picture.getTYPE();
        
        switch(tempType)
        {
            case HEAD:
                pictrueToDraw.set(0, picture);
                break;
            case CLOTHES:
                pictrueToDraw.set(1, picture);
                break;            
            case SHOES:
                pictrueToDraw.set(2, picture);
                break;
            case HAIR:
                pictrueToDraw.set(3, picture);
                break;
            case HAT:
                pictrueToDraw.set(4, picture);
                break;                
        }
    }
    
    public void choosePicture(int ID)
    {
        for (Picture picture : allPicture) {
            if(picture.getID() == ID)
            {
                setPriorityPicture(picture);            
            }
        }
    }
}
