package com.politechnikalodzka.rpgcreator.picture;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lbary
 */
public class ManagePictures {
    private List<Picture> pictrueToDraw;
    private List<Picture> allPicture;

    public ManagePictures() {
        this.pictrueToDraw = new ArrayList();
        for(int i = 0; i < 7; i++)
        {
            pictrueToDraw.add(null);
        }
        this.allPicture = new ArrayList();
    }

    public List<Picture> getPictrueToDraw() {
        return pictrueToDraw;
    }

    public List<Picture> getAllPicture() {
        return allPicture;
    }
    
    public void addPictures(TypeOfPictrues type, String url, int id)
    {
        boolean isNotContain = true;
        for(int i = 0; i < allPicture.size(); i++)
        {            
            if(allPicture.get(i).getURL().equals(url)) {
                isNotContain = false;
            }
        }
        
        if(isNotContain) {
            allPicture.add(PictureFactory.addPicture(type, url, id));
        }
    }
    
    public void choosePicture(int ID) {
        Picture tempP = null;
        int priority = 8;
        for(int i = 0; i < allPicture.size(); i++)
        {
            if(allPicture.get(i).getID() == ID)
            {
                tempP = allPicture.get(i);
                priority = tempP.getPriority();
            }
        }
        
        switch (priority) {
                case 1:
                    pictrueToDraw.set(0, tempP);
                    break;
                case 2:
                    pictrueToDraw.set(1, tempP);
                    break;
                case 3:
                    pictrueToDraw.set(2, tempP);
                    break;
                case 4:
                    pictrueToDraw.set(3, tempP);
                    break;
                case 5:
                    pictrueToDraw.set(4, tempP);
                    break;
                case 6:                    
                    pictrueToDraw.set(5, tempP);
                    break;
                case 7:
                    pictrueToDraw.set(6, tempP);
                    break;
        }        
    }
}
