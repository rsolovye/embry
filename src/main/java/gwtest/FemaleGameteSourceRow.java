package gwtest;

import java.util.HashMap;

/**
 * Created by bobsol on 29.01.17.
 */
public class FemaleGameteSourceRow {

    private HashMap<String, String> femaleGameteSourceMap = new HashMap<>();
    ;
    private String[] keys = {"guid", "source", "material_type", "cryo_date", "expected_follicle_count"};

    public FemaleGameteSourceRow() {

    }

    public String get(String key) {
        return femaleGameteSourceMap.get(key);
    }

    public String[] getKeys() {
        return keys;
    }

    public String getString(String key) {
        return femaleGameteSourceMap.get(key);
    }

    public boolean set(String key, String val) {
        boolean isSet = false;

        for (String k : keys) {
            if (key.equalsIgnoreCase(k)) {
                femaleGameteSourceMap.put(k, val);
                isSet = true;
            }
        }
        return isSet;
    }
}
