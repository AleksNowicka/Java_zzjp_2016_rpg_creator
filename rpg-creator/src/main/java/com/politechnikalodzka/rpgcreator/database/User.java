package com.politechnikalodzka.rpgcreator.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aleks on 19.05.16.
 */
public class User extends BaseDataBaseEntity{

    private int id;
    private String nick;
    private String emailAddress;
    private String password;
    private Map<Group, List<Character>> usersGroupsWithTheirCharacters;

    User() throws ClassNotFoundException, SQLException {
        initDataBaseAndQueryBuilder("User");
    }

    public boolean authenticateAndGetData(String nick, String password) throws SQLException {
        ResultSet resultSet = dataBaseStatement.executeQuery(queryBuilder.getFullRowQuery(columnsNames.get(1),
                nick));
        if(resultSet.getString(columnsNames.get(3)) != password){
            return false;
        }
        id = Integer.parseInt(resultSet.getString(columnsNames.get(0)));
        this.nick = nick;
        emailAddress = resultSet.getString(columnsNames.get(2));
        this.password = password;
        return true;
    }

    public void getUsersGroupsWithTheirCharacters(){
        
    }

    public void saveAsEditedUser() throws SQLException {
        Map<String, String> columsNamesWithUpdatedValues = new HashMap<String, String>();
        columsNamesWithUpdatedValues.put(columnsNames.get(1), nick);
        columsNamesWithUpdatedValues.put(columnsNames.get(2), emailAddress);
        columsNamesWithUpdatedValues.put(columnsNames.get(3), password);
        dataBaseStatement.executeUpdate(queryBuilder.getUpdateRowQuery(columsNamesWithUpdatedValues,
                columnsNames.get(0), String.valueOf(id)));
    }

    public void saveAsNewUser(String password) throws SQLException {
        ResultSet resultSet = dataBaseStatement.executeQuery(queryBuilder.getRowMaxColumnValueQuery(
                String.valueOf(id)));
        int newId = Integer.parseInt(resultSet.getString("max("+columnsNames.get(0)+")"));
        List<String> rowValues = new ArrayList<String>();
        rowValues.add(String.valueOf(newId)); rowValues.add(nick);
        rowValues.add(emailAddress); rowValues.add(password);
        dataBaseStatement.executeUpdate(queryBuilder.getInsertRowQuery(rowValues));
    }

    public String getNick() { return nick; }
    public void setNick(String nick) { this.nick = nick; }
    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }

}
