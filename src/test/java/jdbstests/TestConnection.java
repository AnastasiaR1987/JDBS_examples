package jdbstests;

import java.sql.*;

public class TestConnection {

    public static void main(String[] args) throws SQLException {
        //we need this info for connect with database.
        String dbUrl = "jdbc:oracle:thin:@3.231.58.251:1521:XE";
        String dbUsername = "hr";
        String dbPassword = "hr";

        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        ///statement we nee for run query
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM departments");

       //once you set up connection by default pointing in 0.
        resultSet.next();
       // System.out.println(resultSet.getString("region_name"));
        System.out.println(resultSet.getString(2));




        //close connection
        resultSet.close();
        statement.close();
        connection.close();
    }
}
