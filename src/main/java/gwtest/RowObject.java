package gwtest;

import protocol.maps.Protocol;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by bobsol on 29.01.17.
 */
public class RowObject {
    public String className;
    public String[] keySet;
    private HashMap<String, String> mappedValues = new HashMap<>();

    public RowObject(String className, String[] keySet)
    {
        this.className = className;
        this.keySet = keySet;
        for (String k : keySet)
            put(k, "");
    }

    public RowObject(String className, HashMap<String, String> inputMap)
    {
        this.className = className;
        this.keySet = new String[inputMap.keySet().size()];
        inputMap.keySet().toArray(keySet);

        for (String k : keySet)
            put(k, (inputMap.get(k) == null) ? "" : inputMap.get(k));
    }

    public RowObject(String className,  Set<String> keySet)
    {
        this.keySet = new String[keySet.size()];
        keySet.toArray(this.keySet);
        this.className = className;

        for (String k : keySet)
            put(k, "");
    }

    public void put(String k, String v){
                boolean canBeMapped = false;
        for (String ks : keySet)
        {
            if (ks.equalsIgnoreCase(k) && v.length() > 0) {
                canBeMapped = true;
            }
        }

        if (canBeMapped) {
            System.out.println("RowObject mapping(" + k + "," + v + ")");
            mappedValues.put(k, v);
        }
    }

    public String[] getKeySet(){
        return keySet;
    }
    public String getName(){
        return className;
    }
    public String get(String k){
        return mappedValues.get(k);
    }
    public HashMap<String, String> getMap(){
        return mappedValues;
    }
}
