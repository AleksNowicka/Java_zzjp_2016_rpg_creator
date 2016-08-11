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

    public String getFullRowQuery(String byColumnName, String byValue){
        return SELECT+ALL+FROM+tableName+WHERE+byColumnName+EQUALS+byValue;
    }

    public String getRowColumnsValuesQuery(List<String> searchedColumns, String byColumnName, String byValue){
        String query = SELECT;
        for(String searchedColumnName : searchedColumns){
            query += searchedColumnName+", ";
        }
        query = query.substring(0, query.length()-2);
        query += FROM+tableName+WHERE+byColumnName+EQUALS+byValue;
        return query;
    }

    public String getRowMaxColumnValueQuery(String searchedColumn){
        return SELECT+MAX_START+searchedColumn+MAX_MIN_END+FROM+tableName;
    }

    public String getRowMinColumnValueQuery(String searchedColumn, String byColumnName, String byValue){
        return SELECT+MIN_START+searchedColumn+MAX_MIN_END+WHERE+byColumnName+EQUALS+byValue;
    }

    public String getInsertRowQuery(List<String> rowValues){
        String query = INSERT+tableName+VALUES+"(";
        for(String value : rowValues){
            query += "'"+value+"', ";
        }
        query = query.substring(0, query.length()-2);
        query += ")";
        return query;
    }

    public String getUpdateRowQuery(Map<String, String> columsNamesWithUpdatedValues, String byColumnName, String byValue){
        String query = UPDATE+tableName+SET;
        for(String key : columsNamesWithUpdatedValues.keySet()){
            query += key+EQUALS+"'"+columsNamesWithUpdatedValues.get(key)+"' ";
        }
        query += WHERE+byColumnName+EQUALS+byValue;
        return query;
    }

    public String getDeleteRowQuery(String byColumnName, String byValue){
        return DELETE+FROM+tableName+WHERE+byColumnName+EQUALS+byValue;
    }

}
