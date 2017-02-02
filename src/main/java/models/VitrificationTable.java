package models;

import java.util.HashMap;

/**
 * Created by bob on 02.02.2017.
 */
public class VitrificationTable {
    private HashMap<String, String> embryoMap;
    public VitrificationTable(){
        embryoMap = new HashMap<>();
    }
    public VitrificationTable(HashMap<String, String> map){
    embryoMap = map;
    }
    public HashMap<String, String> getMap(){
        return this.embryoMap;
    }
    public String get(String key){
        return embryoMap.get(key);
    }

}
