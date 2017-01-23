package models;

import daos.AccessObject;
import daos.DefaultValuesDAO;
import sun.nio.ch.DefaultAsynchronousChannelProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bobsol on 23.01.17.
 */
public class DefaultValuesModel extends HashMap implements Model{
    HashMap<String, String[]> listValueMap;
    DefaultValuesDAO defaultValuesDAO;
    ArrayList<String> idList;
    public DefaultValuesModel(){
        this.listValueMap = new HashMap<>();
        this.defaultValuesDAO = new DefaultValuesDAO();
        idList.add("doctor");
        idList.add("nurse");
        idList.add("diagnosis");
        idList.add("embryologist");
        idList.add("catheters");
        idList.add("sperm");
    }


    public void mapDefaultValues(){
        String sql;
        for (String listID: idList) {
            sql = "SELECT * FROM " + listID;

            ResultSet rs = defaultValuesDAO.query(sql);
            ArrayList<String> values = new ArrayList<>();
            try {
                while (rs.next()) {
                    values.add(rs.getString(""));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            listValueMap.put(listID, (String[]) values.toArray());
        }

    }

    public HashMap<String, String[]> getValuesMap(){
        return this.listValueMap;
    }

    public String[] getValue(String listID){
        return this.listValueMap.get(listID);
    }
}
