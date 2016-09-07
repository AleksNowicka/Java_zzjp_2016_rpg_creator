package com.politechnikalodzka.rpgcreator;

import com.politechnikalodzka.rpgcreator.utils.QueryBuilder;
import org.junit.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by aleks on 07.09.16.
 */
public class QueryBuilderTest {

    public QueryBuilderTest(){
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetAllQuery(){
        QueryBuilder queryBuilder = new QueryBuilder("TestTable");
        String queryResult = queryBuilder.getAllQuery();
        String expectedResult = " select  *  from TestTable";
        assertThat(queryResult.equals(expectedResult));
    }

    @Test
    public void testGetFullRowQueryFromOwnTable(){
        QueryBuilder queryBuilder = new QueryBuilder("TestTable");
        String queryResult = queryBuilder.getFullRowQueryFromOwnTable("id", "1");
        String expectedResult = " select  *  from TestTable where id = '1'";
        assertThat(queryResult.equals(expectedResult));
    }

    @Test
    public void testGetFullRowQuery(){
        QueryBuilder queryBuilder = new QueryBuilder("TestTable");
        String queryResult = queryBuilder.getFullRowQuery("OtherTable", "id", "1");
        String expectedResult = " select  *  from OtherTable where id = '1'";
        assertThat(queryResult.equals(expectedResult));
    }

    @Test
    public void testGetRowMaxColumnValueQueryFromOwnTable(){
        QueryBuilder queryBuilder = new QueryBuilder("TestTable");
        String queryResult = queryBuilder.getRowMaxColumnValueQueryFromOwnTable("id");
        String expectedResult = " select max(id) from TestTable";
        assertThat(queryResult.equals(expectedResult));
    }

    @Test
    public void testGetInsertRowQueryFromOwnTable(){
        QueryBuilder queryBuilder = new QueryBuilder("TestTable");
        List<String> rowValues = new ArrayList<String>();
        rowValues.add("13"); rowValues.add("someName");
        String queryResult = queryBuilder.getInsertRowQueryFromOwnTable(rowValues);
        String expectedResult = " insert into TestTable values ('13', 'someName')";
        assertThat(queryResult.equals(expectedResult));
    }

    @Test
    public void testGetUpdateRowQueryFromOwnTable(){
        QueryBuilder queryBuilder = new QueryBuilder("TestTable");
        Map<String, String> columnsNamesWithUpdatedValues = new HashMap<String, String>();
        columnsNamesWithUpdatedValues.put("testId", "13");
        columnsNamesWithUpdatedValues.put("testName", "Moon");
        String queryResult = queryBuilder.getUpdateRowQueryFromOwnTable(columnsNamesWithUpdatedValues, "testId", "1");
        String expectedResult = " update TestTable set testId = '13', testName = 'Moon' where testId = '1'";
        assertThat(queryResult.equals(expectedResult));
    }

    @Test
    public void testGetDeleteRowQuery(){
        QueryBuilder queryBuilder = new QueryBuilder("TestTable");
        String queryResult = queryBuilder.getDeleteRowQuery("TempTable", "id", "1");
        String expectedResult = " delete  from TempTable where id = '1'";
        assertThat(queryResult.equals(expectedResult));
    }

}
