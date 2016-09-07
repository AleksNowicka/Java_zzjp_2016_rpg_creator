package com.politechnikalodzka.rpgcreator.utils;

import java.util.List;
import java.util.Map;

/**
 * Created by aleks on 10.08.16.
 */
public class QueryBuilder {

    private String tableName;

    private final String SELECT = " select ";
    private final String INSERT = " insert into ";
    private final String UPDATE = " update ";
    private final String DELETE = " delete ";
    private final String FROM = " from ";
    private final String VALUES = " values ";
    private final String SET = " set ";
    private final String WHERE = " where ";
    private final String ALL = " * ";
    private final String MAX_START = "max(";
    private final String MIN_START = "min(";
    private final String MAX_MIN_END = ")";
    private final String EQUALS = " = ";

    public QueryBuilder(String tableName){
        this.tableName = tableName;
    }

    public String getAllQuery(){
        return SELECT+ALL+FROM+tableName;
    }

    public String getFullRowQueryFromOwnTable(String byColumnName, String byValue){
        return SELECT+ALL+FROM+tableName+WHERE+byColumnName+EQUALS+"'"+byValue+"'";
    }

    public String getFullRowQuery(String searchedTableName, String byColumnName, String byValue){
        return SELECT+ALL+FROM+searchedTableName+WHERE+byColumnName+EQUALS+"'"+byValue+"'";
    }

    public String getRowMaxColumnValueQueryFromOwnTable(String searchedColumn){
        return SELECT+MAX_START+searchedColumn+MAX_MIN_END+FROM+tableName;
    }

    public String getInsertRowQueryFromOwnTable(List<String> rowValues){
        String query = INSERT+tableName+VALUES+"(";
        for(String value : rowValues){
            query += "'"+value+"', ";
        }
        query = query.substring(0, query.length()-2);
        query += ")";
        return query;
    }

    public String getUpdateRowQueryFromOwnTable(Map<String, String> columnsNamesWithUpdatedValues, String byColumnName, String byValue){
        String query = UPDATE+tableName+SET;
        for(String key : columnsNamesWithUpdatedValues.keySet()){
            query += key+EQUALS+"'"+columnsNamesWithUpdatedValues.get(key)+"', ";
        }
        query = query.substring(0, query.length()-2);
        query += WHERE+byColumnName+EQUALS+"'"+byValue+"'";
        System.out.println(query);
        return query;
    }

    public String getDeleteRowQuery(String searchedTableName, String byColumnName, String byValue){
        return DELETE+FROM+searchedTableName+WHERE+byColumnName+EQUALS+"'"+byValue+"'";
    }

}
