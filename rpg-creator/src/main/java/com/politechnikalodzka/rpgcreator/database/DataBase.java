package com.politechnikalodzka.rpgcreator.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by aleks on 19.05.16.
 */

public class DataBase {

    private static DataBase instance = null;
    private Connection connection;

    protected DataBase() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:rpg_creator_database.db");
            System.out.println("Connected to database");
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public static DataBase getInstance() throws ClassNotFoundException {
        if(instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    public Connection getConnection() { return connection; }

}
