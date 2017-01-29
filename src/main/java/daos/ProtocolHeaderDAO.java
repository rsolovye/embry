package daos;

import models.Model;
import protocol.ProtocolHeader;

import java.sql.*;
import java.util.UUID;

/**
 * Created by micro on 24.01.2017.
 */
public class ProtocolHeaderDAO extends AccessObject {


    private static String sql = "SELECT * FROM protocol_headers WHERE guid=";

    public static ProtocolHeader find(UUID id) {
        Connection c = null;
        Statement stmt = null;

        try {


            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);

            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery(sql + id + ";");

            while (rs.next()) {
               // ProtocolHeader ph = new ProtocolHeader.ProtocolHeaderBuilder()
                       // .buildFromRecordSet(rs)
                //        .build();
                //return ph;

            }

            stmt.close();
            c.commit();


            c.close();
            rs.close();


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;

    }



    @Override
    public void query() {

    }

    @Override
    public void query(String sql) {

    }

    @Override
    public Model getModel() {
        return null;
    }
}
