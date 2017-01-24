package models;

import daos.AccessObject;
import daos.DataModelFactory;
import daos.FactoryDAO;
import daos.MasterDAOImpl;
import services.DefaultValuesGateway;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bobsol on 19.01.17.
 */
public class MasterModel {

    private HashMap<String, AccessObject> dao;
    private HashMap<String, Model> models;

    public MasterModel() {
        this.dao = new HashMap<>();
        models = new HashMap<>();
        this.dao.put(Model.DEFAULT_VALUES, new FactoryDAO().getAccessObject(Model.DEFAULT_VALUES));
        this.models.put(Model.DEFAULT_VALUES, dao.get(Model.DEFAULT_VALUES).getModel());



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
