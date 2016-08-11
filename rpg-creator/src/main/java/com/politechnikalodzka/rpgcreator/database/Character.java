package com.politechnikalodzka.rpgcreator.database;

import com.politechnikalodzka.rpgcreator.utils.QueryBuilder;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aleks on 19.05.16.
 */
public class Character {

    private final String tableName = "Characters";
    private List<String> columnsNames;

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
    private QueryBuilder queryBuilder;
    private Statement dataBaseStatement;

    Character() throws ClassNotFoundException, SQLException {
        dataBase = DataBase.getInstance();
        dataBaseStatement = dataBase.getConnection().createStatement();
        queryBuilder = new QueryBuilder(tableName);
        getColumnsNames();
    }

    Character(int id) throws ClassNotFoundException{
        dataBase = DataBase.getInstance();
        try {
            getData(id);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private void getColumnsNames() throws SQLException {
        columnsNames = new ArrayList<String>();
        ResultSet resultSet = dataBaseStatement.executeQuery(queryBuilder.getAllQuery());
        if(resultSet.getFetchSize() == 0){
            return;
        }
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        for(int i=1; i<=resultSetMetaData.getColumnCount(); i++){
            columnsNames.add(resultSetMetaData.getColumnName(i));
        }
    }

    private boolean doesColumnExist(String columnName){
        for(String column : columnsNames){
            if(columnName.equals(column)){
                return true;
            }
        }
        return false;
    }

    public void getData(int id) throws SQLException {
        dataBaseStatement.setQueryTimeout(30);
        String columnName = "id";
        if(!doesColumnExist(columnName)){
            return;
        }
        ResultSet resultSet = dataBaseStatement.executeQuery(queryBuilder.getFullRowQuery(columnName, Integer.toString(id)));
        if(resultSet.getFetchSize() == 0){
            return;
        }
        this.id = id;
        name = resultSet.getString(columnsNames.get(0));
        gender = resultSet.getString(columnsNames.get(1)).charAt(0);
        hairId = Integer.parseInt(resultSet.getString(columnsNames.get(2)));
        hatId = Integer.parseInt(resultSet.getString(columnsNames.get(3)));
        outfitId = Integer.parseInt(resultSet.getString(columnsNames.get(4)));
        eyesId = Integer.parseInt(resultSet.getString(columnsNames.get(5)));
        accessoriesId = Integer.parseInt(resultSet.getString(columnsNames.get(6)));
        groupId = Integer.parseInt(resultSet.getString(columnsNames.get(7)));
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
