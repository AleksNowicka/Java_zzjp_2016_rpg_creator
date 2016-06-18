package com.politechnikalodzka.rpgcreator.dbmodule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by aleks on 19.05.16.
 */
public class Character {

    private int id;
    private String name;
    private char gender;
    private int hairId;
    private int hatId;
    private int outfitId;
    private int eyesId;
    private int accessoriesId;
    private int groupId;
    private DataBase dataBase;

    Character() throws ClassNotFoundException {
        dataBase = DataBase.getInstance();
    }

    Character(int id) throws ClassNotFoundException{
        dataBase = DataBase.getInstance();
        try {
            getData(id);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void getData(int id) throws SQLException {
        Statement statement = dataBase.getConnection().createStatement();
        statement.setQueryTimeout(30);
        ResultSet rs = statement.executeQuery("select * from Characters where id = "+ Integer.toString(id));
        if(rs.getFetchSize() == 0){
            return;
        }
        this.id = id;
        name = rs.getString("name");
        gender = rs.getString("gender").charAt(0);
        hairId = Integer.parseInt(rs.getString("hair"));
        hatId = Integer.parseInt(rs.getString("hat"));
        outfitId = Integer.parseInt(rs.getString("outfit"));
        eyesId = Integer.parseInt(rs.getString("eyes"));
        accessoriesId = Integer.parseInt(rs.getString("accessories"));
        groupId = Integer.parseInt(rs.getString("belongsToGroup"));
    }

    public void saveAsEditedCharacter() throws SQLException{
        Statement statement = dataBase.getConnection().createStatement();
        statement.setQueryTimeout(30);
        statement.executeUpdate("update Characters set name = '"+name+"' gender = '"+gender+
                "' hair = "+Integer.toString(hairId)+" hat = "+Integer.toString(hatId)+
                " outfit = "+Integer.toString(outfitId)+" eyes = "+Integer.toString(eyesId)+
                " accessories = "+Integer.toString(accessoriesId)+" belongsToGroup = "+
                Integer.toString(groupId)+" where id = "+Integer.toString(id));
    }

    public void saveAsNewCharacter() throws  SQLException{
        Statement statement = dataBase.getConnection().createStatement();
        statement.setQueryTimeout(30);
        ResultSet rs = statement.executeQuery("select max(id) from Characters");
        int newId = Integer.parseInt(rs.getString("max(id)"));
        statement.executeUpdate("insert into Characters values ("+Integer.toString(newId)+", '"+name+
                "', '"+gender+"', "+Integer.toString(hairId)+", "+Integer.toString(hatId)+
                ", "+Integer.toString(outfitId)+", "+Integer.toString(eyesId)+", "+
                Integer.toString(accessoriesId)+", "+Integer.toString(groupId)+")");
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public char getGender() { return gender; }
    public void setGender(boolean isMan) {
        if(isMan){
            gender = 'm';
        }
        else{
            gender = 'f';
        }
    }
    public int getHairId() { return hairId; }
    public void setHairId(int hairId) { this.hairId = hairId; }
    public int getHatId() { return hatId; }
    public void setHatId(int hatId) { this.hatId = hatId; }
    public int getOutfitId() { return outfitId; }
    public void setOutfitId(int outfitId) { this.outfitId = outfitId; }
    public int getEyesId() { return eyesId; }
    public void setEyesId(int eyesId) { this.eyesId = eyesId; }
    public int getAccessoriesId() { return accessoriesId; }
    public void setAccessoriesId(int accessoriesId) { this.accessoriesId = accessoriesId; }
    public int getGroupId() { return groupId; }
    public void setGroupId(int groupId) { this.groupId = groupId; }

}
