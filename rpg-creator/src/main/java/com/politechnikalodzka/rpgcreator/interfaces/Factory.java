package com.politechnikalodzka.rpgcreator.interfaces;

import com.politechnikalodzka.rpgcreator.enums.Gender;
import com.politechnikalodzka.rpgcreator.enums.TypeOfPictrues;

/**
 *
 * @author lbary
 */
public interface Factory {

    public Picture addPicture(TypeOfPictrues type, String url, int id, Gender gender);
}
