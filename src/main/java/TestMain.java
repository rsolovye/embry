import controllers.MasterController;
import models.MasterModel;
import views.MasterView;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by bobsol on 24.01.17.
 */
public class TestMain {
public static void main(String args[]){

    //    Connection c = null;
//    Statement stmt = null;
//    ResultSet rs = null;
//    try {
//        Class.forName("org.sqlite.JDBC");
//        c = DriverManager.getConnection("jdbc:sqlite:test.db");
//        c.setAutoCommit(false);
//
//        System.out.println("Opened database successfully");
//
//        stmt = c.createStatement();
//        stmt.execute("CREATE TABLE TESTTEST(TEST TEXT)");
//
//        //rs = stmt.getResultSet();
//
//        stmt.close();
//        c.commit();
//        c.close();
//
//    } catch (Exception e) {
//        System.err.println(e.getClass().getName() + ": " + e.getMessage());
//        System.exit(0);
//    }
       // JFrame frame = new JFrame();
    MasterView v = new MasterView();
    MasterModel m = new MasterModel();
    MasterController controller=new MasterController(v, m);
    controller.getDefaultControlValuesMap();

   // frame.add(v.getUI());
   // frame.pack();
   // frame.setVisible(true);

}
}
