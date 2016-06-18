package com.politechnikalodzka.rpgcreator.dbmodule;

import com.sun.corba.se.spi.presentation.rmi.PresentationManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by aleks on 19.05.16.
 */

//Singleton - in order to provide only one instance of this class in whole application

public class DataBase {

    private static DataBase instance = null;
    private Connection connection;
    private User user;

    protected DataBase() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:rpg_creator_database.db");
            System.out.println("Connected to database");
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        finally{
            try{
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e){
                System.err.println(e);
            }
        }
    }

    public static DataBase getInstance() throws ClassNotFoundException {
        if(instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

}
