package gwtest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by bobsol on 29.01.17.
 */
public class MasterGateway {

    public synchronized static ArrayList<RowObectImpl> findByGuid(UUID guid){
        ArrayList<String> tableNames = new ArrayList<>();
        RowObjectMapper.rowObjectsFromDB();

        try {
            if (DB.con.isClosed()) DB.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (RowObectImpl r: RowObjectMapper.rowArray) {
            DB.setResult("SELECT * FROM "+ r.getName() + " WHERE GUID='"+ guid.toString() + "';");

            try {
                while (DB.rs.next()) {
                    for (String k : r.getKeySet()) {
                        System.out.print(k);
                        String temp =  DB.rs.getString(k);
                        System.out.println("temp" + temp);
                            r.getMap().put(k, temp);
                    }
                }
             //DB.commit();
            }catch (SQLException e) {     e.printStackTrace();}
        }
            DB.destroy();
            return RowObjectMapper.rowArray;
        }



    public synchronized static void insert(ArrayList<RowObectImpl> protocolPackage){

        for (RowObectImpl rowObject: protocolPackage){
            String sql = mapToInsertQuery(rowObject);
            if (DB.con == null) DB.init();

                DB.execute(sql);
                DB.commit();
                DB.destroy();

        }

    }



    private static String mapToInsertQuery(RowObectImpl row){
        String sql = "INSERT INTO " + row.getName() + " \n(";
        String values = ") \nVALUES(";
        for (String r: row.getMap().keySet())
        {
            sql = sql + r + ", ";
            values = values + "'" + row.get(r) + "', ";
        }
        sql = sql.substring(0, sql.length()-2) + values.substring(0, values.length()-2) + ");";


        return sql;
    }
}
