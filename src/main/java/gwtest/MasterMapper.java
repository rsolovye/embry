package gwtest;

import javafx.beans.property.SimpleStringProperty;
import protocol.maps.Protocol;
import sun.rmi.transport.proxy.RMIMasterSocketFactory;

import java.util.*;

/**
 * Created by bobsol on 29.01.17.
 */
public class MasterMapper {
    public synchronized static ArrayList<Protocol> findByGuid(UUID guid) {

        ArrayList<RowObject> protocolAsLists = MasterGateway.findByGuid(guid);
        ArrayList<Protocol> protocols = new ArrayList<>();

        for (RowObject roi : protocolAsLists) {

//            System.out.print("MasMapper " + roi.getKeySet().length);
            if (roi.getMap().size() > 0)
                protocols.add(ProtocolFactory.get(roi.className, roi.getMap()));
        }

        return protocols;
    }

    public synchronized static ArrayList<Protocol> findAll() {
        ArrayList<RowObject> protocolAsLists = MasterGateway.findAll();
        ArrayList<Protocol> protocols = new ArrayList<>();

        for (RowObject roi : protocolAsLists) {
            if (roi.getMap().size() > 0)
                protocols.add(ProtocolFactory.get(roi.className, roi.getMap()));
        }
        return protocols;
    }

    public synchronized static void mapForSaving(Protocol protocol) {
        RowObject row;
        String className;
        Set<String> keySet;
        String[] convertedKeys;
        className = Registry.convertProtocolType(protocol.getClass().getSimpleName());

        keySet = protocol.keySet();
        convertedKeys = new String[keySet.size()];
        int i = 0;
        for (String k : keySet) {
            convertedKeys[i++] = k;
        }
        row = new RowObject(className, convertedKeys);


        if (Registry.containsGuid(protocol)) {
            //TODO


            MasterGateway.update(row);
        } else {
            MasterGateway.insert(row);
        }

    }

    public static void saveToDB(HashMap<String, String> inputMap, String protocolName){
        RowObject ro = new RowObject(protocolName, inputMap);
//        if (MasterGateway.recordExists(ro.get("guid"), protocolName))
//            MasterGateway.update(ro);
//        else
        MasterGateway.insert(ro);


        print_saveToDB(inputMap, protocolName, ro);

    }

    public static void remapAndSave(HashMap<String, SimpleStringProperty> inputMap, String protocolName){
        HashMap<String, String> tempMap = new HashMap<>();
        for (String k: inputMap.keySet())
        {

            tempMap.put(k, (inputMap.get(k).getValue() == null) ? "" : inputMap.get(k).getValue());

        }
        saveToDB(tempMap, protocolName);


    }

    private static void print_saveToDB(HashMap<String, String> inputMap, String protocolName, RowObject ro){
        System.out.println("\n" + "MasterMapper.saveToDB | protocolName: " + protocolName);
        System.out.println("               KEY  "+ spacer("", 30) +  "  INPUT_MAP " + spacer("", 35) + "ROW_OBJECT\n" +
                "--------------------------------------------------------------------------------------------------------");

        for (String k: inputMap.keySet()) {

            System.out.println("---->       " + k + spacer(k, 20) +"<<<     '" + inputMap.get(k) +
                                "'" + spacer(ro.get(k), 40) +   "'" + ro.get(k) + "'.");
        }


    }

    public static String spacer(String s, int max){
        String space = " ";
        if (s==null) s = "";
        int keyCol = max - s.length();
        for (int i = 0; i < keyCol; i ++)
            space = space +  " ";
        return space;
    }
}
