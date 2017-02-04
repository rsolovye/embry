package gwtest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bobsol on 28.01.17.
 */
public class DefaultValues {
    private static HashMap<String, ArrayList<String>> mapValueLists = null;
    private static DefaultValues defaultValues = new DefaultValues();
        private DefaultValues(){


    }

    public static void initialize(){
        if (mapValueLists == null) {
            mapValueLists = new HashMap<>();
        }
        Connection c = null;
        Statement stmt = null;
        String sql = SQLRegistry.getSQL("control_list_names");


        try {

            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:embry-test.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql + ";");

            HashMap<String, String> default_value_query = new HashMap<>();


            while (rs.next()) {
                String key = rs.getString("table_name");
                String query = rs.getString("query_string");
                default_value_query.put(key, query);
            }
            rs.close();
            stmt.close();

            for (String q: default_value_query.keySet()) {
                stmt = c.createStatement();
                String sql2 = default_value_query.get(q);
                System.out.println("'" + q + "' - '" + sql2 + "'");

                ResultSet rs2 = stmt.executeQuery(default_value_query.get(q) + ";");

                ArrayList<String> list = new ArrayList<>();
                System.out.print("\nCONTROL_VALUE LISTED :\n");
                while (rs2.next()){
                    String value = rs2.getString("CONTROL_VALUE");
                    list.add(value);
                    System.out.print(" " + value);
                }
                mapValueLists.put(q, list);
                rs2.close();
                stmt.close();
            }

            c.commit();
            c.close();



        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }
    public static ObservableList<String> getObservableList(String listName){
        if (getValueListMap() == null) {
            initialize();
        }

        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.setAll(mapValueLists.get(listName));
        System.out.println("ObservableList<String> for list : " + listName + " has size=" + observableList.size());
        return observableList;
    }

    public static ArrayList<String> getDefaultList(String listName){
        if (getValueListMap() == null) {
                initialize();
        }

        return mapValueLists.get(listName);
    }
public static HashMap<String, ArrayList<String>> getValueListMap(){
        if (mapValueLists == null) {
            initialize();
        }
        return mapValueLists;
    }
    public static void printMap(){
            if (mapValueLists == null) { initialize();}
            for (String k: mapValueLists.keySet()){
                for (String l: getDefaultList(k)){
                    System.out.println(k + " : " + l);
                }
            }
    }
}
