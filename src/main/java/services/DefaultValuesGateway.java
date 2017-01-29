package services;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by micro on 24.01.2017.
 */
public class DefaultValuesGateway {

   // private final UUID guid;
   private HashMap<String, ArrayList<String>> defaultValuesMap;


    public HashMap<String, ArrayList<String>> getDefaultValuesMap() {
        return defaultValuesMap;
    }

    public void setDefaultValuesMap(HashMap<String, ArrayList<String>> defaultValuesMap) {
        this.defaultValuesMap = defaultValuesMap;
    }



    public synchronized static DefaultValuesGateway findListNames() throws DefaultValuesGatewayExecption {
        Connection c = null;
        Statement stmt = null;

        try {

            String sql = "SELECT * FROM default_value_tables;";
            ArrayList<String> resultList = new ArrayList<>();
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();

            //RecordSet rs = (RecordSet) stmt.executeQuery(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                resultList.add(rs.getString("TABLES"));

            }
            stmt.close();
            c.commit();

            stmt = c.createStatement();
            HashMap<String, ArrayList<String>> tempMap = new HashMap<>();

            for (String sqlString: resultList) {

                ArrayList<String> listValues = new ArrayList<>();
                ResultSet rs2 = stmt.executeQuery("SELECT name FROM " + sqlString + ";");
                while (rs2.next()){
                    listValues.add(rs2.getString("NAME"));
                }

                tempMap.put(sqlString, listValues);

            }

            stmt.close();
            c.commit();

            c.close();
            rs.close();

            return new DefaultValuesGateway(tempMap);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }










    public DefaultValuesGateway() {
        this.defaultValuesMap = new HashMap<>();
    }

    public DefaultValuesGateway(HashMap<String, ArrayList<String>> map) {

        this.defaultValuesMap = map;
    }


}
