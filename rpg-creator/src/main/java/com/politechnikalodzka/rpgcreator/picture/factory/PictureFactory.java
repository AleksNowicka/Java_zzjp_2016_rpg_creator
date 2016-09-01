package com.politechnikalodzka.rpgcreator.picture.factory;

import com.politechnikalodzka.rpgcreator.interfaces.Picture;
import com.politechnikalodzka.rpgcreator.enums.TypeOfPictrues;
import com.politechnikalodzka.rpgcreator.interfaces.Factory;
import com.politechnikalodzka.rpgcreator.picture.factory.*;

/**
 *
 * @author lbary
 */
public class PictureFactory implements Factory {

    @Override
    public Picture addPicture(TypeOfPictrues type, String url, int id) {
        switch (type) {
            case OUTFIT:
                return new Outfit(id, url);
            case HAIR:
                return new Hair(id, url);
            case HAT:
                return new Hat(id, url);
            case EYES:
                return new Eyes(id, url);
            case ACCESSORIES:
                return new Accessories(id, url);
            default:
                return null;
        }
    }
}
