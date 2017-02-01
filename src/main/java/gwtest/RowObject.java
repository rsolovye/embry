package gwtest;

import protocol.maps.Protocol;

import java.util.HashMap;

/**
 * Created by bobsol on 29.01.17.
 */
public class RowObject {
    public String className;
    public String[] keySet;
    public HashMap<String, String> mapedValues;

    public RowObject(String className, String[] keySet)
    {
        this.className = className;
        this.keySet = keySet;
        mapedValues = new HashMap<>();
        for (String k : keySet)
            put(k, "");
    }


    public void put(String k, String v){
                boolean canBeMapped = false;
        for (String ks : keySet)
        {
            if (ks.equalsIgnoreCase(k) && v.length()>0) {
                canBeMapped = true;
            }
        }

        if (canBeMapped) {
        //    System.out.println("RowObject mapping(" +k + "," + v + ")");
            mapedValues.put(k, v);
        }
    }

    public String[] getKeySet(){
        return keySet;
    }
    public String getName(){
        return className;
    }
    public String get(String k){
        return mapedValues.get(k);
    }
    public HashMap<String, String> getMap(){
        return mapedValues;
    }
}
