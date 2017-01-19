package com.mvn.app.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by bobsol on 19.01.17.
 */
public class DataBaseService {

    public DataBaseService() {

    }

    public void insertQuery(String sql) {
        {
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:test.db");
                c.setAutoCommit(false);

                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                stmt.executeUpdate(sql);

                stmt.close();
                c.commit();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }

    }
}