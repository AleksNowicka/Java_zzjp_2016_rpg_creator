package com.politechnikalodzka.rpgcreator.picture;

import com.politechnikalodzka.rpgcreator.picture.factory.*;

/**
 *
 * @author lbary
 */
public class PictureFactory {
    
    public static Picture addPicture(TypeOfPictrues type, String url, int id)
    {
        switch(type) {
            case BODY:
                return new Body(id, url);
            case HEAD:
                return new Head(id, url);
            case OUTFIT:
                return new Outfit(id, url);
            case HAIR:
                return new Hair(id, url);
            case HAT:
                return new Hat(id, url);
            case ACCESSORIES:
                return new Accessories(id, url);
            case EYES:
                return new Eyes(id, url);
            default:
                return null;
        }
    }    
}