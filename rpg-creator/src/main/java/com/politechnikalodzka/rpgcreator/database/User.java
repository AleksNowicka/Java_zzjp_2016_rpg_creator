package com.politechnikalodzka.rpgcreator.database;

import java.util.List;

/**
 * Created by aleks on 19.05.16.
 */
public class User {

    private int id;
    private List groupsId;

    public boolean authenticate(String nick, String password){
        return false;
    }

}
