package models;

import daos.AccessObject;
import daos.FactoryDAO;
import daos.MasterDAOImpl;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bobsol on 19.01.17.
 */
public class MasterModel {
    private MasterDAOImpl masterDAO;
    public FactoryDAO factoryDAO;
   // private LabProtocol.LabProtocolBuilder labProtocolBuilder;
    HashMap<String, String[]> defaultControlValuesMap;
    DefaultValuesModel defaultValuesModel = new DefaultValuesModel();


    ArrayList<Model> models = new ArrayList<>();
    public MasterModel() {

        models.add(defaultValuesModel);
        defaultValuesModel.mapDefaultValues();

        defaultControlValuesMap = defaultValuesModel.getValuesMap();

    }

    public HashMap<String, String[]> getDefaultControlValuesMap() {

        return  defaultControlValuesMap;
    }
}
