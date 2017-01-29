package gwtest;

import java.util.HashMap;

/**
 * Created by bobsol on 29.01.17.
 */
public class RowObectImpl {
    public String className;
    public String[] keySet;
    public HashMap<String, String> mapedValues;

    public RowObectImpl(String className, String[] keySet)
    {
        this.className = className;
        this.keySet = keySet;
        mapedValues = new HashMap<>();
    }

    public void put(String k, String v){
        boolean canBeMapped = false;
        for (String ks : keySet)
        {
            if (ks.compareTo("k") == 0) {
                canBeMapped = true;
            }
        }

        if (canBeMapped) {
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
