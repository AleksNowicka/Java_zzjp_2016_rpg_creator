package com.politechnikalodzka.rpgcreator.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Character extends BaseDataBaseEntity{

    private int id;
    private String name;
    private char gender;
    private int hairId;
    private int hatId;
    private int outfitId;
    private int eyesId;
    private int accessoriesId;
    private int groupId;

    Character() throws ClassNotFoundException, SQLException {
        initDataBaseAndQueryBuilder("Characters");
    }

    Character(int id) throws ClassNotFoundException, SQLException {
        initDataBaseAndQueryBuilder("Characters");
        try {
            getData(id);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void getData(int id) throws SQLException {
        String columnName = "id";
        if(!doesColumnExist(columnName)){
            return;
        }
        ResultSet resultSet = dataBaseStatement.executeQuery(queryBuilder.getFullRowQuery(columnName, Integer.toString(id)));
        if(resultSet.getFetchSize() == 0){
            return;
        }
        this.id = id;
        name = resultSet.getString(columnsNames.get(1));
        gender = resultSet.getString(columnsNames.get(2)).charAt(0);
        hairId = Integer.parseInt(resultSet.getString(columnsNames.get(3)));
        hatId = Integer.parseInt(resultSet.getString(columnsNames.get(4)));
        outfitId = Integer.parseInt(resultSet.getString(columnsNames.get(5)));
        eyesId = Integer.parseInt(resultSet.getString(columnsNames.get(6)));
        accessoriesId = Integer.parseInt(resultSet.getString(columnsNames.get(7)));
        groupId = Integer.parseInt(resultSet.getString(columnsNames.get(8)));
    }

    public void saveAsEditedCharacter() throws SQLException{
        Map<String, String> columsNamesWithUpdatedValues = new HashMap<String, String>();
        columsNamesWithUpdatedValues.put(columnsNames.get(1), name);
        columsNamesWithUpdatedValues.put(columnsNames.get(2), String.valueOf(gender));
        columsNamesWithUpdatedValues.put(columnsNames.get(3), String.valueOf(hairId));
        columsNamesWithUpdatedValues.put(columnsNames.get(4), String.valueOf(hatId));
        columsNamesWithUpdatedValues.put(columnsNames.get(5), String.valueOf(outfitId));
        columsNamesWithUpdatedValues.put(columnsNames.get(6), String.valueOf(eyesId));
        columsNamesWithUpdatedValues.put(columnsNames.get(7), String.valueOf(accessoriesId));
        columsNamesWithUpdatedValues.put(columnsNames.get(8), String.valueOf(groupId));
        dataBaseStatement.executeUpdate(queryBuilder.getUpdateRowQuery(columsNamesWithUpdatedValues,
                columnsNames.get(0), String.valueOf(id)));
    }

    public void saveAsNewCharacter() throws  SQLException{
        ResultSet resultSet = dataBaseStatement.executeQuery(queryBuilder.getRowMaxColumnValueQuery(
                columnsNames.get(0)));
        int newId = Integer.parseInt(resultSet.getString("max("+columnsNames.get(0)+")"));
        List<String> rowValues = new ArrayList<String>();
        rowValues.add(String.valueOf(newId)); rowValues.add(name);
        rowValues.add(String.valueOf(gender)); rowValues.add(String.valueOf(hairId));
        rowValues.add(String.valueOf(hatId)); rowValues.add(String.valueOf(outfitId));
        rowValues.add(String.valueOf(eyesId)); rowValues.add(String.valueOf(accessoriesId));
        rowValues.add(String.valueOf(groupId));
        dataBaseStatement.executeUpdate(queryBuilder.getInsertRowQuery(rowValues));
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
