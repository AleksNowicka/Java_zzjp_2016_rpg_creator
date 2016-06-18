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
    private String nick;
    private String emailAddress;
    private String password;
    private DataBase dataBase;

    User() throws ClassNotFoundException {
        this.dataBase = DataBase.getInstance();
    }

    public boolean authenticateAndGetData(String nick, String password) throws SQLException {
        Statement statement = dataBase.getConnection().createStatement();
        statement.setQueryTimeout(30);
        ResultSet rs = statement.executeQuery("select * from User " +
                "where nick = "+nick);
        if(rs.getString("password") != password){
            return false;
        }
        id = Integer.parseInt(rs.getString("id"));
        this.nick = nick;
        emailAddress = rs.getString("emailAddress");
        this.password = password;
        return true;
    }

    public void saveAsEditedUser() throws SQLException {
        Statement statement = dataBase.getConnection().createStatement();
        statement.setQueryTimeout(30);
        statement.executeUpdate("update User set nick = '"+this.nick+"', emailAddress = '"+this.emailAddress+
                "', password = '"+this.password+"' where id = "+Integer.toString(this.id));
    }

    public void saveAsNewUser(String password) throws SQLException {
        Statement statement = dataBase.getConnection().createStatement();
        statement.setQueryTimeout(30);
        ResultSet rs = statement.executeQuery("select max(id) from User");
        int newId = Integer.parseInt(rs.getString("max(id)"));
        statement.executeUpdate("insert into User values ("+Integer.toString(newId)+", '"+this.nick+
                "', '"+this.emailAddress+"', '"+password+"')");
    }

    public String getNick() { return nick; }
    public void setNick(String nick) { this.nick = nick; }
    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }

}
