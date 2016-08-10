package com.politechnikalodzka.rpgcreator.database;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aleks on 19.05.16.
 */
public class Group {
    private final int maxNumberOfCharactersInGroup = 10;

    private int id;
    private String name;
    private  String description;
    private int maxGroupMembers;
    private String pathToGroupIcon;
    private int groupOwnerId;
    private List<Integer> charactersIds;
    private DataBase dataBase;

    public Group() throws ClassNotFoundException{
        dataBase = DataBase.getInstance();
    }

    public Group(int id) throws ClassNotFoundException{
        dataBase = DataBase.getInstance();
        try{
            getData(id);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void getData(int id) throws SQLException {
        Statement statement = dataBase.getConnection().createStatement();
        statement.setQueryTimeout(30);
        ResultSet rs = statement.executeQuery("select * from Groups where id = "+ Integer.toString(id));
        if(rs.getFetchSize() == 0){
            return;
        }
        this.id = id;
        name = rs.getString("name");
        description = rs.getString("description");
        maxGroupMembers = Integer.parseInt(rs.getString("maxGroupMembers"));
        pathToGroupIcon = rs.getString("groupIcon");
        groupOwnerId = Integer.parseInt(rs.getString("owner"));
        rs = statement.executeQuery("select id from Characters where belongsToGroup = "+ Integer.toString(this.id));
        while (rs.next()){
            charactersIds.add(Integer.parseInt(rs.getString("id")));
        }
    }

    public void addCharacterToGroup(int characterId){
        charactersIds.add(characterId);
    }

    public void reomoveCharacterFromGroup(int characterId){
        charactersIds.remove(Integer.valueOf(characterId));
    }

    public void saveAsEditedGroup() throws SQLException{
        Statement statement = dataBase.getConnection().createStatement();
        statement.setQueryTimeout(30);
        statement.executeUpdate("update Groups set name = '"+name+"' description = '"+description+
                "' maxGroupMembers = "+Integer.toString(maxGroupMembers)+" groupIcon = "+pathToGroupIcon+
                " owner = "+Integer.toString(groupOwnerId)+" where id = "+id);
        updateAllGroupMembers();
    }

    public void saveAsNewGroup() throws  SQLException{
        Statement statement = dataBase.getConnection().createStatement();
        statement.setQueryTimeout(30);
        ResultSet rs = statement.executeQuery("select max(id) from Groups");
        int newId = Integer.parseInt(rs.getString("max(id)"));
        statement.executeUpdate("insert into Groups values ("+Integer.toString(newId)+", '"+name+
                "', '"+description+"', "+Integer.toString(maxGroupMembers)+", "+pathToGroupIcon+
                ", "+Integer.toString(groupOwnerId)+")");
        updateAllGroupMembers();
    }

    private void updateAllGroupMembers() throws SQLException {
        Statement statement = dataBase.getConnection().createStatement();
        statement.setQueryTimeout(30);
        for(Integer characterId : charactersIds){
            statement.executeUpdate("update Characters set belongsToGroup = "+id+" where id = "+
                    Integer.toString(characterId));
        }
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public int getMaxGroupMembers() {return maxGroupMembers;}
    public void setMaxGroupMembers(int maxGroupMembers) {
        if (maxGroupMembers <= maxNumberOfCharactersInGroup) {
            this.maxGroupMembers = maxGroupMembers;
        } else {
            this.maxGroupMembers = maxNumberOfCharactersInGroup;
        }
    }
    public String getPathToGroupIcon() {return pathToGroupIcon;}
    public void setPathToGroupIcon(String pathToGroupIcon) {this.pathToGroupIcon = pathToGroupIcon;}
    public void setGroupOwnerId(int groupOwnerId) {this.groupOwnerId = groupOwnerId;}
    public List<Integer> getCharactersIds() { return charactersIds;}
}
