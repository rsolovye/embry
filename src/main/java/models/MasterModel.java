package models;

import daos.AccessObject;
import gwtest.*;
import protocol.maps.Protocol;
import protocol.old.pojos.ProtocolHeader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by bobsol on 19.01.17.
 */
public class MasterModel {

    private HashMap<String, AccessObject> dao;
    private HashMap<String, Model> models;

//    public ProtocolHeader getHeader(UUID guid){
//        ProtocolHeaderRow rds = ProtocolHeaderGateway.findByGUID(guid);
//        ProtocolHeader ph = new ProtocolHeader.ProtocolHeaderBuilder(rds).build();
//        return ph;
//    }
//
//
    public void saveProtocol(String protocolType, HashMap<String, String> map){
        Protocol protocol = ProtocolFactory.get(protocolType, map);

        MasterMapper.mapForSaving(protocol);

    }
//
//    private ProtocolHeader buildProtocolHeader(HashMap<String, String> map){
//        ProtocolHeaderRow rds = new ProtocolHeaderRow();
//
//
//        for (String k: rds.getKeys())
//        {
//            System.out.print(k);
//            rds.set(k, map.get(k));
//        }
//        return new ProtocolHeader.ProtocolHeaderBuilder(rds).build();


 //   }
    SQLRegistry sqlRegistry;
    public MasterModel() {
        SQLRegistry.initialize();
        SQLRegistry.load_control_defaults();

        //this.dao = new HashMap<>();
        //sqlRegistry = SQLRegistry.getSqlRegistry();
        //SQLRegistry.getSQL("control_list_values").;
        //SQLRegistry.getSQL(DefaultValues.getDefaultList(SQL.).getDefaultList(q);
        //models = new HashMap<>();
        //this.dao.put(Model.DEFAULT_VALUES, new FactoryDAO().getAccessObject(Model.DEFAULT_VALUES));
        //this.models.put(Model.DEFAULT_VALUES, dao.get(Model.DEFAULT_VALUES).getModel());



    }

    public Model getModel(String modelName){
        return this.dao.get(modelName).getModel();
    }

    public HashMap<String, ArrayList<String>> getDefaultControlValuesMap(){
        DefaultValuesModel model = (DefaultValuesModel)  models.get(Model.DEFAULT_VALUES);

        //IMUTABLE?
        return    model.getValuesMap();
    }
}
