package models;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bobsol on 23.01.17.
 */
public class DefaultValuesModel implements Model{
    HashMap<String, String[]> listValueMap;

    ArrayList<String> idList;
    public DefaultValuesModel(){
        this.listValueMap = new HashMap<>();
    }


    public void mapDefaultValues(String listID, String[] valueArray){
        listValueMap.put(listID, valueArray);
    }

    public HashMap<String, String[]> getValuesMap(){
        return this.listValueMap;
    }

    public String[] getValue(String listID){
        return this.listValueMap.get(listID);
    }
}
