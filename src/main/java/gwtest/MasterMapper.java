package gwtest;

import protocol.maps.Protocol;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by bobsol on 29.01.17.
 */
public class MasterMapper {
    public synchronized static ArrayList<Protocol> findByGuid(UUID guid){

        ArrayList<RowObject> protocolAsLists = MasterGateway.findByGuid(guid);
        ArrayList<Protocol> protocols = new ArrayList<>();

        for (RowObject roi : protocolAsLists){

            System.out.print("MasMapper " + roi.getKeySet().length);
                if (roi.getMap().size() > 0)
                 protocols.add(ProtocolFactory.get(roi.className, roi.getMap()));
                }
                return protocols;
    }

    public synchronized static ArrayList<Protocol> findAll(){
        ArrayList<RowObject> protocolAsLists = MasterGateway.findAll();
        ArrayList<Protocol> protocols = new ArrayList<>();

        for (RowObject roi : protocolAsLists){

            //System.out.print("MasMapper " + roi.getKeySet().length);
            if (roi.getMap().size() > 0)
                protocols.add(ProtocolFactory.get(roi.className, roi.getMap()));
        }
        return protocols;
    }

    public synchronized static void mapForSaving(Protocol protocol){
        if (Registry.containsGuid(protocol))
        {
            //TODO
            String className =  Registry.convertProtocolType(protocol.getClass().getSimpleName());
            String[] keySet = protocol.keySet();
            RowObject row = new RowObject(className, keySet)
        }

            MasterGateway.update(protocol);
        }
        else {
            MasterMapper.insert(protocol);
        }

    }
}
