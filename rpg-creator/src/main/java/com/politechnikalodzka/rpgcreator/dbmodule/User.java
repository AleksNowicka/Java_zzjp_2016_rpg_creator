package com.politechnikalodzka.rpgcreator.dbmodule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
