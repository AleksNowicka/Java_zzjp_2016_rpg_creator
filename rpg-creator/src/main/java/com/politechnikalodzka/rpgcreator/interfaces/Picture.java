package com.politechnikalodzka.rpgcreator.interfaces;

import com.politechnikalodzka.rpgcreator.enums.Gender;
import com.politechnikalodzka.rpgcreator.enums.TypeOfPictrues;

/**
 *
 * @author lbary
 */
public interface Picture {
    public int getID();
    public String getURL();    
    public TypeOfPictrues getType();
    public Gender getGender();
}
