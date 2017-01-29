//package gwtest;
//
//import protocol.ProtocolHeader;
//
//import java.sql.*;
//import java.util.HashMap;
//import java.util.UUID;
//
///**
// * Created by bobsol on 28.01.17.
// */
//public class RowObjectGateway {
//
//
//
//
//
//    public static synchronized HashMap<UUID, ProtocolHeaderRow>  findAll(UUID guid){
//
//        Connection c = null;
//        Statement stmt = null;
//
//        try {
//
//            String sql = SQLRegistry.getSQL("PROTOCOL_HEADER_FIND_BY_GUID", guid.toString());
//
//            Class.forName("org.sqlite.JDBC");
//            c = DriverManager.getConnection("jdbc:sqlite:" + SQLRegistry.getDB_NAME());
//            c.setAutoCommit(false);
//
//            stmt = c.createStatement();
//
//            ResultSet resultSet = stmt.executeQuery(sql);
//            ProtocolHeaderRow row = new ProtocolHeaderRow();
//            HashMap<UUID, ProtocolHeaderRow> mapedHeaders = new HashMap<>();
//            while (resultSet.next())
//            {
//                for (String k: row.getKeys()){
//                    row.set(k, resultSet.getString(k));
//                }
//            mapedHeaders.put(UUID.fromString(row.getString("guid")), row);
//            }
//
//
//            resultSet.close();
//            stmt.close();
//            c.commit();
//            c.close();
//            return mapedHeaders;
//
//        } catch (Exception e) {
//            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
//        }
//
//        return null;
//    }
//
//    public synchronized static void insert(RowDataSet row){
//
//        Connection c = null;
//        Statement stmt = null;
//
//        try {
//            String sql = mapToInsertQuery(row);
//
//            Class.forName("org.sqlite.JDBC");
//            c = DriverManager.getConnection("jdbc:sqlite:" + SQLRegistry.getDB_NAME());
//            c.setAutoCommit(false);
//
//            stmt = c.createStatement();
//
//            stmt.execute(sql);
//
//            stmt.close();
//            c.commit();
//            c.close();
//        } catch (SQLException e){
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public synchronized static void updateByGuid(RowDataSet row){
//
//
//        Connection c = null;
//        Statement stmt = null;
//
//        try {
//            String sql = mapToUpdateQuery(row);
//
//            Class.forName("org.sqlite.JDBC");
//            c = DriverManager.getConnection("jdbc:sqlite:" + SQLRegistry.getDB_NAME());
//            c.setAutoCommit(false);
//
//            stmt = c.createStatement();
//
//            stmt.execute(sql);
//
//            stmt.close();
//            c.commit();
//            c.close();
//        } catch (SQLException e){
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    private static String mapToInsertQuery(RowDataSet row){
//        String sql = "INSERT INTO " + row.getRowType() +" \n(";
//        String values = ") \nVALUES(";
//        for (String r: row.getKeys())
//        {
//            sql = sql + r + ", ";
//            values = values + "'" + row.getString(r) + "', ";
//        }
//        sql = sql.substring(0, sql.length()-2) + values.substring(0, values.length()-2) + ");";
//
//
//        return sql;
//    }
//
//    private static String mapToUpdateQuery(RowDataSet row){
//        String sql = "UPDATE " + row.getRowType() +  "\n SET ";
//
//        String values = ") \nVALUES(";
//        for (String r: row.getKeys())
//        {
//            if (r.compareTo("guid") != 0)
//            {
//                sql = sql + r + "='" + row.getString(r) + "', ";
//            }
//        }
//        sql = sql.substring(0, sql.length()-2) + " WHERE guid='" + row.getString("guid") + "';";
//
//
//        return sql;
//    }
//    }
//
