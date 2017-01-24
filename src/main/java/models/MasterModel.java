package models;

import daos.AccessObject;
import daos.DataModelFactory;
import daos.FactoryDAO;
import daos.MasterDAOImpl;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bobsol on 19.01.17.
 */
public class MasterModel {

    private HashMap<String, AccessObject> dao;

   // private LabProtocol.LabProtocolBuilder labProtocolBuilder;


    ArrayList<Model> models = new ArrayList<>();
    public MasterModel() {
        this.dao = new HashMap<>();
        this.dao.put("DEFAULT_VALUES", new FactoryDAO().getAccessObject(Model.DEFAULT_VALUES));




    }

    public Model getModel(String modelName){
        return this.dao.get(modelName).getModel();
    }
    public HashMap<String, String[]> getDefaultControlValuesMap(){
        DefaultValuesModel model = (DefaultValuesModel) getModel(Model.DEFAULT_VALUES);
        //IMUTABLE?
        return new HashMap<>(model.getValuesMap());
    }
}
