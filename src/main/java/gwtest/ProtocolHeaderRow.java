package gwtest;

import java.util.HashMap;
import java.util.UUID;

public class ProtocolHeaderRow  {

    private HashMap<String, String>   protocolHeaderMap = new HashMap<>();;
    private String[] keys =   {"guid", "pfDate", "pfTime", "pfVRT", "ivfAttempt", "pfDoctor", "isOms", "pfHeaderNotes", "pfDiagnosis", "fName", "fDOB", "fCode", "mName", "mDOB", "mCode"};
    public ProtocolHeaderRow(){

    }

    public ProtocolHeaderRow(UUID guid) {
        set("guid", guid.toString());
    }


    public String[] getKeys(){
        return keys;
    }

    public String getString(String key){
        return protocolHeaderMap.get(key);
    }
    public Boolean getBoolean(String key){
        return (protocolHeaderMap.get(key).compareTo("1") == 0);
    }

    public boolean set(String key, String val){
        boolean isSet = false;

        for (String k: keys){
            if (key.equalsIgnoreCase(k)) {
            protocolHeaderMap.put(k, val);
            isSet = true;
            }
        }
        return isSet;
    }





}
