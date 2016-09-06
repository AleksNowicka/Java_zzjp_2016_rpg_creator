package com.politechnikalodzka.rpgcreator.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group extends BaseDataBaseEntity{

    private final String tableName = "Groups";

    private int id;
    private String name;
    private  String description;
    private int maxGroupMembers;
    private String groupIcon;
    private int groupOwnerId;


    public Group() throws ClassNotFoundException, SQLException {
        initDataBaseAndQueryBuilder(tableName);
    }

    public Group(int id) throws ClassNotFoundException, SQLException {
        initDataBaseAndQueryBuilder(tableName);
        try{
            getData(id);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void getData(int id) throws SQLException {
        String columnName = "id";
        if(!doesColumnExist(columnName)){
            return;
        }
        ResultSet rs = dataBaseStatement.executeQuery(queryBuilder.getFullRowQueryFromOwnTable(columnName,
                String.valueOf(id)));
        if(rs.next()) {
            this.id = id;
            name = rs.getString(columnsNames.get(1));
            description = rs.getString(columnsNames.get(2));
            maxGroupMembers = Integer.parseInt(rs.getString(columnsNames.get(3)));
            groupIcon = rs.getString(columnsNames.get(4));
            groupOwnerId = Integer.parseInt(rs.getString(columnsNames.get(5)));
        }
    }

    public void saveAsEditedGroup() throws SQLException{
        Map<String, String> columsNamesWithUpdatedValues = new HashMap<String, String>();
        columsNamesWithUpdatedValues.put(columnsNames.get(1), name);
        columsNamesWithUpdatedValues.put(columnsNames.get(2), description);
        columsNamesWithUpdatedValues.put(columnsNames.get(3), String.valueOf(maxGroupMembers));
        columsNamesWithUpdatedValues.put(columnsNames.get(4), groupIcon);
        columsNamesWithUpdatedValues.put(columnsNames.get(5), String.valueOf(groupOwnerId));
        dataBaseStatement.executeUpdate(queryBuilder.getUpdateRowQueryFromOwnTable(columsNamesWithUpdatedValues,
                columnsNames.get(0), String.valueOf(id)));
    }

    public void saveAsNewGroup() throws  SQLException{
        ResultSet resultSet = dataBaseStatement.executeQuery(queryBuilder.getRowMaxColumnValueQueryFromOwnTable(
                columnsNames.get(0)));
        int newId = Integer.parseInt(resultSet.getString("max("+columnsNames.get(0)+")"));
        List<String> rowValues = new ArrayList<String>();
        rowValues.add(String.valueOf(newId)); rowValues.add(name);
        rowValues.add(description); rowValues.add(String.valueOf(maxGroupMembers));
        rowValues.add(groupIcon); rowValues.add(String.valueOf(groupOwnerId));
        dataBaseStatement.executeUpdate(queryBuilder.getInsertRowQueryFromOwnTable(rowValues));
    }

    public int getId() { return id; }
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public int getMaxGroupMembers() {return maxGroupMembers;}
    public void setMaxGroupMembers(int maxGroupMembers) { this.maxGroupMembers = maxGroupMembers; }
    public String getGroupIcon() {return groupIcon;}
    public void setGroupIcon(String groupIcon) {this.groupIcon = groupIcon;}
    public void setGroupOwnerId(int groupOwnerId) {this.groupOwnerId = groupOwnerId;}
}
