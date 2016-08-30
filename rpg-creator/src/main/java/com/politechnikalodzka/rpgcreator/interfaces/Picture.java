package com.politechnikalodzka.rpgcreator.interfaces;

import com.politechnikalodzka.rpgcreator.enums.Gender;

/**
 *
 * @author lbary
 */
public abstract class Picture {
    public abstract int getID();
    public abstract String getURL();    
    public abstract int getPriority();
    public abstract Gender getGender();
}
