package com.politechnikalodzka.rpgcreator.database;

import com.politechnikalodzka.rpgcreator.view.CharacterCreationView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aleks on 19.05.16.
 */
public class User extends BaseDataBaseEntity{

    private static User instance = null;

    private static int id;
    private static String nick;
    private static String emailAddress;
    private static String password;
    private static List<Group> userGroups;
    private static Map<Integer, List<Character>> usersGroupsWithTheirCharacters;

    protected User() throws ClassNotFoundException, SQLException {
        initDataBaseAndQueryBuilder("User");
    }

    public static User getInstance() throws ClassNotFoundException, SQLException {
        if(instance == null) {
            instance = new User();
        }
        return instance;
    }

    public boolean authenticateAndGetData(String nick, String password) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = dataBaseStatement.executeQuery(queryBuilder.getFullRowQueryFromOwnTable(columnsNames.get(1),
                nick));
        if(!resultSet.getString(columnsNames.get(3)).equals(password)){
            return false;
        }
        id = Integer.parseInt(resultSet.getString(columnsNames.get(0)));
        this.nick = nick;
        emailAddress = resultSet.getString(columnsNames.get(2));
        this.password = password;
        ResultSet groupCharactersResultSet;
        List<Character> groupCharacters;
        Group group = new Group();
        Character character = new Character();
        usersGroupsWithTheirCharacters = new HashMap<Integer, List<Character>>();
        userGroups = new ArrayList<Group>();
        resultSet = dataBaseStatement.executeQuery(queryBuilder.getFullRowQuery(group.getTableName(),
                group.getColumnsNames().get(group.getColumnsNames().size()-1), String.valueOf(id)));
        if(resultSet.getFetchSize() == 0){
            System.out.println("empty");
            return true;
        }
        while (resultSet.next()){
            System.out.println("Not empty");
            group = new Group();
            groupCharacters = new ArrayList<Character>();
            group.getData(resultSet.getInt(group.getColumnsNames().get(0)));
            groupCharactersResultSet = dataBaseStatement.executeQuery(queryBuilder.getFullRowQuery(
                    character.getTableName(), character.getColumnsNames().get(character.getColumnsNames().size()-1),
                    String.valueOf(group.getId())));
            while (groupCharactersResultSet.next()){
                character = new Character();
                character.getData(groupCharactersResultSet.getInt(character.getColumnsNames().get(0)));
                groupCharacters.add(character);
            }
            usersGroupsWithTheirCharacters.put(group.getId(), groupCharacters);
            userGroups.add(group);
            System.out.println("Group "+group.getName());
        }
        return true;
    }

    public void updateData() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = dataBaseStatement.executeQuery(queryBuilder.getFullRowQueryFromOwnTable(columnsNames.get(1),
                nick));
        id = Integer.parseInt(resultSet.getString(columnsNames.get(0)));
        this.nick = resultSet.getString(columnsNames.get(1));
        emailAddress = resultSet.getString(columnsNames.get(2));
        this.password = resultSet.getString(columnsNames.get(3));
    }

    public void retriveUsersGroupsWithTheirCharacters() throws SQLException, ClassNotFoundException {
        ResultSet groupsResultSet, groupCharactersResultSet;
        List<Character> groupCharacters;
        Group group = new Group();
        Character character = new Character();
        usersGroupsWithTheirCharacters = new HashMap<Integer, List<Character>>();
        userGroups = new ArrayList<Group>();
        groupsResultSet = dataBaseStatement.executeQuery(queryBuilder.getFullRowQuery(group.getTableName(),
                group.getColumnsNames().get(group.getColumnsNames().size()-1), String.valueOf(id)));
        if(groupsResultSet.getFetchSize() == 0){
            System.out.println("empty");
            return;
        }
        while (groupsResultSet.next()){
            System.out.println("Not empty");
            group = new Group();
            groupCharacters = new ArrayList<Character>();
            group.getData(groupsResultSet.getInt(group.getColumnsNames().get(0)));
            groupCharactersResultSet = dataBaseStatement.executeQuery(queryBuilder.getFullRowQuery(
                    character.getTableName(), character.getColumnsNames().get(character.getColumnsNames().size()-1),
                            String.valueOf(group.getId())));
            while (groupCharactersResultSet.next()){
                character = new Character();
                character.getData(groupCharactersResultSet.getInt(character.getColumnsNames().get(0)));
                groupCharacters.add(character);
            }
            usersGroupsWithTheirCharacters.put(group.getId(), groupCharacters);
            userGroups.add(group);
            System.out.println("Group "+group.getName());
        }
    }

    public void saveAsEditedUser() throws SQLException {
        Map<String, String> columsNamesWithUpdatedValues = new HashMap<String, String>();
        columsNamesWithUpdatedValues.put(columnsNames.get(1), nick);
        columsNamesWithUpdatedValues.put(columnsNames.get(2), emailAddress);
        columsNamesWithUpdatedValues.put(columnsNames.get(3), password);
        dataBaseStatement.executeUpdate(queryBuilder.getUpdateRowQueryFromOwnTable(columsNamesWithUpdatedValues,
                columnsNames.get(0), String.valueOf(id)));
    }

    public void saveAsNewUser(String password) throws SQLException {
        ResultSet resultSet = dataBaseStatement.executeQuery(queryBuilder.getRowMaxColumnValueQueryFromOwnTable(
                String.valueOf(id)));
        int newId = Integer.parseInt(resultSet.getString("max("+columnsNames.get(0)+")"));
        List<String> rowValues = new ArrayList<String>();
        rowValues.add(String.valueOf(newId)); rowValues.add(nick);
        rowValues.add(emailAddress); rowValues.add(password);
        dataBaseStatement.executeUpdate(queryBuilder.getInsertRowQueryFromOwnTable(rowValues));
    }

    public String getNick() { return nick; }
    public void setNick(String nick) { this.nick = nick; }
    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public static List<Group> getUserGroups() {
        return userGroups;
    }

    public static Map<Integer, List<Character>> getUsersGroupsWithTheirCharacters() {
        return usersGroupsWithTheirCharacters;
    }
}
