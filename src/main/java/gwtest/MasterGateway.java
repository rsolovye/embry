package gwtest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by bobsol on 29.01.17.
 */
public class MasterGateway {

    public synchronized static ArrayList<RowObject> findByGuid(UUID guid){
        ArrayList<RowObject> rowObjectList = RowObjects.getList();
        try {
            if (DB.con.isClosed()) DB.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (RowObject r: rowObjectList) {
            DB.setResult("SELECT * FROM "+ r.getName() + " WHERE GUID='"+ guid.toString() + "';");

            try {
                while (DB.rs.next()) {
                    for (String k : r.getKeySet()) {
                        String temp =  DB.rs.getString(k);
                        r.getMap().put(k, temp);
                    }
                }
            }catch (SQLException e) {     e.printStackTrace();}
        }
            DB.destroy();
            return rowObjectList;
        }

    public synchronized static ArrayList<RowObject> findAll(){

        ArrayList<RowObject> rowObjectList = RowObjects.getList();
        ArrayList<RowObject> allRows = new ArrayList<>();
        try {
            if (DB.con.isClosed()) DB.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (RowObject r: rowObjectList) {
            DB.setResult("SELECT * FROM "+ r.getName() + ";");

            try {
                while (DB.rs.next()) {
                    RowObject tempRow = new RowObject(r.getName(), r.getKeySet());

                    for (String k : tempRow.getKeySet()) {
                        String value =  DB.rs.getString(k);
                        tempRow.put(k, value);
                    }
                    System.out.println("MGW findAll, tempRow.get(guid) :" + tempRow.get("guid"));
                    allRows.add(tempRow);
                    System.out.println("RowObjectList.size MAsterGateway.findAll(): " + allRows.size());
                }
            }catch (SQLException e) {     e.printStackTrace();}
        }
        DB.destroy();
        return allRows;
    }

    public synchronized static void insert(ArrayList<RowObject> protocolPackage) {


        for (RowObject rowObject : protocolPackage) {
            String sql = mapToInsertQuery(rowObject);
            try {
                if (DB.con.isClosed()) DB.init();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("\nMasterGateWay is trying to execute SQL-Statement \n'" + sql + "'.");
            DB.execute(sql);
            DB.commit();
            DB.destroy();
        }
    }
public synchronized static void update(ArrayList<RowObject> ar) {
    for (RowObject rowObject : ar) {
        String sql = mapToUpdateQuery(rowObject);
        System.out.println(sql);

        try {
            if (DB.con.isClosed()) DB.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DB.execute(sql);
        DB.commit();
        DB.destroy();
    }
}


    public static void update(RowObject row){
        ArrayList<RowObject> r = new ArrayList<>();
        r.add(row);
        update(r);
    }

    public static void insert(RowObject row){
        ArrayList<RowObject> r = new ArrayList<>();
        r.add(row);
        insert(r);
    }

    private static String mapToInsertQuery(RowObject row){
        String sql = "INSERT OR REPLACE INTO " + row.getName() + " \n(";
        String values = ") \nVALUES(";
        for (String r: row.getMap().keySet())
        {
            sql = sql + r + ", ";
            values = values + "'" + row.get(r) + "', ";
        }
        sql = sql.substring(0, sql.length()-2) + values.substring(0, values.length()-2) + ");";
        return sql;
    }


    private static String mapToUpdateQuery(RowObject row){
        String sql = "UPDATE " + row.getName() + "\n SET ";

        for (String r: row.getMap().keySet())
        {//TODO
            if (r.compareTo("guid") != 0)
            {
                sql = sql + r + "='" + row.getMap().get(r) + "', ";
            }
        }
        sql = sql.substring(0, sql.length()-2) + " WHERE guid='" + row.getMap().get("guid") + "';";
        return sql;
    }

    private static String mapToUpdateQuery(HashMap<String, String> map4where, RowObject row){
        String sql = "UPDATE " + row.getName() + "\n SET ";

        for (String r: row.getMap().keySet())
        {

            if (r.compareTo("guid") != 0)
            {
                sql = sql + r + "='" + row.getMap().get(r) + "', ";
            }
        }
        sql = sql.substring(0, sql.length()-2) + " WHERE guid='" + row.getMap().get("guid") + "';";


        return sql;
    }
}
