package com.politechnikalodzka.rpgcreator.database;

import com.politechnikalodzka.rpgcreator.utils.QueryBuilder;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group {

    private String tableName;
    private List<String> columnsNames;

    private int id;
    private String name;
    private  String description;
    private int maxGroupMembers;
    private String groupIcon;
    private int groupOwnerId;

    private DataBase dataBase;
    private QueryBuilder queryBuilder;
    private Statement dataBaseStatement;

    public Group() throws ClassNotFoundException, SQLException {
        initDataBaseAndQueryBuilder("Groups");
    }

    public Group(int id) throws ClassNotFoundException, SQLException {
        initDataBaseAndQueryBuilder("Groups");
        try{
            getData(id);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private void initDataBaseAndQueryBuilder(String tableName) throws ClassNotFoundException, SQLException {
        this.tableName = tableName;
        dataBase = DataBase.getInstance();
        dataBaseStatement = dataBase.getConnection().createStatement();
        dataBaseStatement.setQueryTimeout(30);
        queryBuilder = new QueryBuilder(tableName);
        getColumnsNames();
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

    public void getData(int id) throws SQLException {
        ResultSet rs = dataBaseStatement.executeQuery(queryBuilder.getFullRowQuery(columnsNames.get(0),
                String.valueOf(id)));
        if(rs.getFetchSize() == 0){
            return;
        }
        this.id = id;
        name = rs.getString(columnsNames.get(1));
        description = rs.getString(columnsNames.get(2));
        maxGroupMembers = Integer.parseInt(rs.getString(columnsNames.get(3)));
        groupIcon = rs.getString(columnsNames.get(4));
        groupOwnerId = Integer.parseInt(rs.getString(columnsNames.get(5)));
    }

    public void saveAsEditedGroup() throws SQLException{
        Map<String, String> columsNamesWithUpdatedValues = new HashMap<String, String>();
        columsNamesWithUpdatedValues.put(columnsNames.get(1), name);
        columsNamesWithUpdatedValues.put(columnsNames.get(2), description);
        columsNamesWithUpdatedValues.put(columnsNames.get(3), String.valueOf(maxGroupMembers));
        columsNamesWithUpdatedValues.put(columnsNames.get(4), groupIcon);
        columsNamesWithUpdatedValues.put(columnsNames.get(5), String.valueOf(groupOwnerId));
        dataBaseStatement.executeUpdate(queryBuilder.getUpdateRowQuery(columsNamesWithUpdatedValues,
                columnsNames.get(0), String.valueOf(id)));
    }

    public void saveAsNewGroup() throws  SQLException{
        ResultSet resultSet = dataBaseStatement.executeQuery(queryBuilder.getRowMaxColumnValueQuery(
                columnsNames.get(0)));
        int newId = Integer.parseInt(resultSet.getString("max("+columnsNames.get(0)+")"));
        List<String> rowValues = new ArrayList<String>();
        rowValues.add(String.valueOf(newId)); rowValues.add(name);
        rowValues.add(description); rowValues.add(String.valueOf(maxGroupMembers));
        rowValues.add(groupIcon); rowValues.add(String.valueOf(groupOwnerId));
        dataBaseStatement.executeUpdate(queryBuilder.getInsertRowQuery(rowValues));
    }

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
