package com.politechnikalodzka.rpgcreator.picture;

import com.politechnikalodzka.rpgcreator.interfaces.Picture;
import com.politechnikalodzka.rpgcreator.enums.TypeOfPictrues;
import com.politechnikalodzka.rpgcreator.picture.factory.*;

/**
 *
 * @author lbary
 */
public class PictureFactory {
    
    public static Picture addPicture(TypeOfPictrues type, String url, int id)
    {
        switch(type) {
           
            case HEAD:
                return new Head(id, url);
            case OUTFIT:
                return new Outfit(id, url);
            case HAIR:
                return new Hair(id, url);
            case HAT:
                return new Hat(id, url);
            case EYES:
                return new Eyes(id, url);
            default:
                return null;
        }
    }    
}