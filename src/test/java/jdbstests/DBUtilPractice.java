package jdbstests;

import org.junit.jupiter.api.Test;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class DBUtilPractice {

    @Test
    public void test1(){
        //create connection
        DBUtils.createConnection();

        String query ="select first_name,last_name,salary, job_id\n" +
                "from employees\n" +
                "where ROWNUM <6";

        List<Map<String, Object>> queryResultMap = DBUtils.getQueryResultMap(query);//alt+ent
        for (Map<String, Object> row : queryResultMap) {
            System.out.println(row.toString());
        }
        // close connection
        DBUtils.destroy();

        }
        //if we have just one row what we dont have to dealing with List .

    @Test
    public void test2(){
        //create connection
        DBUtils.createConnection();

        String query ="select first_name,last_name,salary, job_id\n" +
                "from employees\n" +
                "where ROWNUM <2";

        Map<String, Object> row = DBUtils.getRowMap(query);
        System.out.println(row.toString());

        // close connection
        DBUtils.destroy();

        }




    }


