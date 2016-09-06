package com.politechnikalodzka.rpgcreator.picture.factory;

import com.politechnikalodzka.rpgcreator.enums.Gender;
import com.politechnikalodzka.rpgcreator.interfaces.Picture;
import com.politechnikalodzka.rpgcreator.enums.TypeOfPictrues;
import com.politechnikalodzka.rpgcreator.interfaces.Factory;
import com.politechnikalodzka.rpgcreator.picture.factory.*;

/**
 *
 * @author lbary
 */
public class PictureFactory implements Factory {

    public Picture addPicture(TypeOfPictrues type, String url, int id, Gender gender) {
        switch (type) {
            case OUTFIT:
                return new Outfit(id, url, gender);
            case HAIR:
                return new Hair(id, url, gender);
            case HAT:
                return new Hat(id, url, gender);
            case EYES:
                return new Eyes(id, url, gender);
            case ACCESSORIES:
                return new Accessories(id, url, gender);
            case BASE:
                return new Base(id, url, gender);
            default:
                return null;
        }
    }
}
