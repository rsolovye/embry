package gwtest;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by micro on 30.01.2017.
 */
public class RowObjects extends ArrayList<RowObject> {
    private static ArrayList<RowObject> list = null;
    public static ArrayList<RowObject> getList(){
        if (list == null) {
            initialize();
        }
        return list;
    }

    public static RowObject getRowObject(String objectName){
        if (list == null) {
            initialize();
        }
        for (RowObject o : list)
        {
            if (o.getName().compareTo(objectName)==0) return o;
        }
        return null;
    }

    private static void initialize(){
        DB.init();
        DB.setResult("SELECT * FROM pojo_keysets;");

        try {
            list = new ArrayList<>();

            while (DB.rs.next())
            {
                String className = DB.rs.getString("class_name");
                String[] keys = DB.rs.getString("keyset").split(",");
                //System.out.println(className +" + " + keys.length);
                list.add(new RowObject(className, keys));
            }
            DB.con.commit();
            DB.destroy();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
