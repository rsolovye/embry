package gwtest;

import protocol.maps.Protocol;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by micro on 01.02.2017.
 */
public class DataBaseCopy {
        private static HashMap<String, ArrayList<Protocol>> mappedDataBase =   new HashMap<>();

        private DataBaseCopy() {};
        private static void mapDB(){

            if (mappedDataBase.size() == 0) {
                for (RowObject p : MasterGateway.findAll()) {
                    HashMap<String, String> rowMap = p.getMap();
                    String className = p.getName();
                    String rowGuid = rowMap.get("guid");

                    System.out.println("mapDB()  " + className + " " + rowGuid + " " + rowMap.size());

                    ArrayList<Protocol> protocols = new ArrayList<>();

                    mappedDataBase.putIfAbsent(rowGuid, protocols);

                    mappedDataBase.get(rowGuid).add(ProtocolFactory.get(className, rowMap));
                }

            }
        }

        public static HashMap<String, ArrayList<Protocol>> getProtocolMap(){
                mapDB();
             return mappedDataBase;
        }

        public static ArrayList<Protocol> findProtocol(String guid){
            mapDB();
            return mappedDataBase.get(guid);
        }
}
