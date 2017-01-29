package gwtest;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import services.DefaultValuesGateway;
import services.RecordSet;

import javax.xml.transform.Result;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by bobsol on 28.01.17.
 */
public class SQLRegistry {

    private static String DB_NAME = "embry-test.db";
    private static HashMap<String, String> sqlMap;
    private static SQLRegistry sqlRegistry;
    private DefaultValues defaultValues;
    private SQLRegistry() {

    }


    public static void initialize(){


        Connection c = null;
        Statement stmt = null;

        try {

            String sql = "SELECT * FROM legal_queries;";

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:embry-test.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            sqlMap = new HashMap<>();
            while (rs.next()) {
                String queryName = rs.getString("query_name");
                String queryString = rs.getString("query_string");
                sqlMap.put(queryName, queryString);
            }
            stmt.close();
            c.commit();
            c.close();
            rs.close();


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

            System.out.println(LocalDateTime.now());
            System.out.println("Mapped sql statements:");
            for (String queryNames : sqlMap.keySet()) {
                System.out.println("'" + queryNames + "' - '" + sqlMap.get(queryNames) + "'.");
            }
    }


    private static String getQuery(String objectName) throws IllegalQueryException{

        if (sqlMap == null) {
             initialize();
        }

        return sqlMap.get(objectName) + ";";
    }
public static String getSQL(String objName){
    try {
       return getQuery(objName);
    } catch (IllegalQueryException e) {
        e.printStackTrace();
        e.printIllegalQuery();
    }
    return null;
    }

    public static String getSQL(String objName, String arg1){
        try {
            return getQuery(objName, arg1);
        } catch (IllegalQueryException e) {
            e.printStackTrace();
            e.printIllegalQuery();
        }
        return null;
    }

    private static String getQuery(String objectName, String arg1) throws IllegalQueryException{

        if (sqlMap == null) {
            initialize();
        }
        return sqlMap.get(objectName) + "='" + arg1 + "'" + ";";
    }

    public static String getDB_NAME(){
        String name = new String(DB_NAME);
        return name;
    }
    public static void load_control_defaults(){
        if (sqlMap == null)
        {
            initialize();
        }
        DefaultValues.initialize();

    }
    public static HashMap<String, ArrayList<String>> getDefaultValues(){
       return  DefaultValues.getValueListMap();
    }

    public static ArrayList<String> getDefaultList(String listName){
        return DefaultValues.getDefaultList(listName);
    }
    public static class IllegalQueryException extends Exception {
        private String name;
        public IllegalQueryException(String message) {
            name = message;
        }
        public String getIllegalQueryName(){
            return name;
        }
        public void printIllegalQuery(){
            System.out.println("\n" + name + " - is not in the registry");}
    }
}
