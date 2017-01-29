package gwtest;

import protocol.Protocol;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by bobsol on 29.01.17.
 */
public class MasterMapper {
    public synchronized static ArrayList<Protocol> findByGuid(UUID guid){

        ArrayList<RowObectImpl> protocolAsLists = MasterGateway.findByGuid(guid);
        ArrayList<Protocol> protocols = new ArrayList<>();
        for (RowObectImpl roi : protocolAsLists){
                 protocols.add(ProtocolFactory.get(roi.className, roi.getMap()));
                }
                return protocols;
    }
}
