package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by bobsol on 19.01.17.
 */
public class DataBaseService {

    public DataBaseService() {

    }

    public ArrayList<String> executeQueryDefaults(String sql) {
        ArrayList<String> resultList = new ArrayList<>();
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);

            System.out.println("Opened database successfully");

            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

           // System.out.println(getClass().getSimpleName() + " : " + sql);
           // System.out.print(rs.getFetchSize());
            while (rs.next()) {

                String result = rs.getString("TABLES");

                resultList.add(result);

            }


         //   System.out.print(resultList.toArray().toString());


            stmt.close();
            c.commit();
            c.close();
            rs.close();

            return resultList;

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

}

