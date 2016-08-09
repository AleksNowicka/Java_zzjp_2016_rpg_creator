package com.politechnikalodzka.rpgcreator.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by aleks on 19.05.16.
 */
public class DataBase {

    private Connection connection;
    private User user;

    public DataBase() throws ClassNotFoundException {
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

}
