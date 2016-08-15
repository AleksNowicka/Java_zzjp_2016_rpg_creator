package com.politechnikalodzka.rpgcreator.database;

import com.politechnikalodzka.rpgcreator.utils.QueryBuilder;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aleks on 11.08.16.
 */
public class BaseDataBaseEntity {

    protected String tableName;
    protected List<String> columnsNames;

    protected DataBase dataBase;
    protected QueryBuilder queryBuilder;
    protected Statement dataBaseStatement;

    protected void initDataBaseAndQueryBuilder(String tableName) throws ClassNotFoundException, SQLException {
        this.tableName = tableName;
        dataBase = DataBase.getInstance();
        dataBaseStatement = dataBase.getConnection().createStatement();
        dataBaseStatement.setQueryTimeout(30);
        queryBuilder = new QueryBuilder(tableName);
        retriveColumnsNames();
    }

    protected void retriveColumnsNames() throws SQLException {
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

    protected boolean doesColumnExist(String columnName){
        for(String column : columnsNames){
            if(columnName.equals(column)){
                return true;
            }
        }
        return false;
    }

    public String getTableName() { return tableName; }
    public List<String> getColumnsNames() { return columnsNames; }
}
