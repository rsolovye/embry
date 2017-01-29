package models;

import daos.AccessObject;
import daos.DataModelFactory;
import daos.FactoryDAO;
import daos.MasterDAOImpl;
import gwtest.*;
import protocol.ProtocolHeader;
import services.DefaultValuesGateway;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by bobsol on 19.01.17.
 */
public class MasterModel {

    private HashMap<String, AccessObject> dao;
    private HashMap<String, Model> models;

    public ProtocolHeader getHeader(UUID guid){
        ProtocolHeaderRow rds = ProtocolHeaderGateway.findByGUID(guid);
        ProtocolHeader ph = new ProtocolHeader.ProtocolHeaderBuilder(rds).build();
        return ph;
    }


    public void saveProtocolHeader(HashMap<String, String> map){
        ProtocolHeader ph = buildProtocolHeader(map);

        if (Registry.containsGuid(ph.getGuid()))
        {
            ProtocolHeaderMapper.updateByGuid(ph);
        }
        else {
            ProtocolHeaderMapper.insert(ph);
        }

    }

    private ProtocolHeader buildProtocolHeader(HashMap<String, String> map){
        ProtocolHeaderRow rds = new ProtocolHeaderRow();


        for (String k: rds.getKeys())
        {
            System.out.print(k);
            rds.set(k, map.get(k));
        }
        return new ProtocolHeader.ProtocolHeaderBuilder(rds).build();


    }
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
