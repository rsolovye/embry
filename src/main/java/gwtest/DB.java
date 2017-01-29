package gwtest;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by bobsol on 29.01.17.
 */
public class DB {

        static Connection con = null;
        static ResultSet rs = null;


    public static void init(){

            try {

                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:" + SQLRegistry.getDB_NAME());
                con.setAutoCommit(false);



            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }

        }
public static void setResult(String sql) {
    try {
        rs = con.createStatement().executeQuery(sql);
    } catch (SQLException e) {
        e.printStackTrace();
    }

}

    public static void execute(String sql) {
        try {
            con.createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void commit() {
        try {
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void destroy() {
        // Clean up.
        try {
            if (con != null) con.close();
        }
        catch (SQLException ignored) { }
    }




}
