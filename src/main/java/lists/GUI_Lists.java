package lists;

import experiment.SQLiteTasksBackUP;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import sun.plugin2.jvm.CircularByteBuffer;

import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by micro on 03.02.2017.
 */
public class GUI_Lists {



    private static final Logger logger = Logger.getLogger("GUI_LISTS:");
    private static final String[] lists = {"DOCTORS", "NURSES", "EMBRYOLOGISTS"};

    private ObservableList<String> DOCTORS;

    public GUI_Lists(){
        logger.info("GUI_LISTS getting set up.");
        try {
           DOCTORS = fetchNames("DOCTORS", getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    public  ObservableList<String> getDoctors() {
   return DOCTORS;
    }



 private Connection getConnection() {

     logger.info("Getting a database connection");

     try {
         Class.forName("org.sqlite.JDBC");
     } catch (ClassNotFoundException e) {
         e.printStackTrace();
     }
     Connection temp = null;
     try {
         temp = DriverManager.getConnection("jdbc:sqlite:embry-test.db");
     } catch (SQLException e) {
         e.printStackTrace();
     }
     return temp;
 }


    class Fetch implements Runnable {
        String tableName;
        ObservableList<String> l;


        Fetch(ObservableList<String> l, String t){ this.l = l; this.tableName=t;}


        @Override
        public void run() {
            try {
               l = fetchNames(tableName, getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

        private ObservableList<String> fetchNames(String tableName, Connection con) throws SQLException {
        private ObservableList<String> fetchNames(String tableName, Connection con) throws SQLException {
            logger.info("Fetching names from database");
            ObservableList<String> names = FXCollections.observableArrayList();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from " + tableName);
            while (rs.next()) {
                names.add(rs.getString("control_value"));
            }

            logger.info("Found " + names.size() + " names in " + tableName);

            return names;
        }
}
