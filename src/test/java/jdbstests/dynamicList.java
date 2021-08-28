package jdbstests;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dynamicList {

    String dbUrl = "jdbc:oracle:thin:@3.231.58.251:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void test2() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT first_name,last_name,salary,job_id\n" +
                "from employees\n" +
                "where rownum <6");

        //in order to get column names we nee resultsetmetadata
        ResultSetMetaData rsmd = resultSet.getMetaData();

        List<Map<String, Object>> queryData = new ArrayList<>();

        int colCount = rsmd.getColumnCount();

        while (resultSet.next()) {
            Map<String, Object> row = new HashMap<>();
            for (int i = 1; i <= colCount; i++) {
                row.put(rsmd.getColumnName(i), resultSet.getObject(i));
            }
            queryData.add(row);
        }

        for (Map<String, Object> each : queryData) {
            System.out.println(each.toString());

        }


        resultSet.close();
        statement.close();
        connection.close();

    }
}