package gwtest;

import com.sun.rowset.internal.Row;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bobsol on 29.01.17.
 */
public class RowObjectMapper {




public static ArrayList<RowObectImpl> rowArray = new ArrayList<>();

public static void rowObjectsFromDB(){
            DB.init();
            DB.setResult("SELECT * FROM pojo_keysets;");

            try {
                while (DB.rs.next())
                {

                        String className = DB.rs.getString("class_name");
                        String[] keys = DB.rs.getString("keyset").split(",");
                        rowArray.add(new RowObectImpl(className, keys));
                }
                DB.con.commit();
                DB.destroy();

            } catch (SQLException e) {
                e.printStackTrace();

            }

        }



        }

