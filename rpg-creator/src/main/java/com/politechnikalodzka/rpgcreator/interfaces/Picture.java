package com.politechnikalodzka.rpgcreator.interfaces;

import com.politechnikalodzka.rpgcreator.enums.Gender;
import com.politechnikalodzka.rpgcreator.enums.TypeOfPictures;

/**
 *
 * @author lbary
 */
public interface Picture {

    public int getID();

    public String getURL();

    public TypeOfPictures getType();

    public Gender getGender();
}
