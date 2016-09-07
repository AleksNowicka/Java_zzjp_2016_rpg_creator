package com.politechnikalodzka.rpgcreator.interfaces;

import com.politechnikalodzka.rpgcreator.enums.Gender;
import com.politechnikalodzka.rpgcreator.enums.TypeOfPictures;

/**
 *
 * @author lbary
 */
public interface Factory {

    public Picture addPicture(TypeOfPictures type, String url, int id, Gender gender);
}
