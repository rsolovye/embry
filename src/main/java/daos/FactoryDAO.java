package daos;

import models.DefaultValuesModel;
import models.Model;

import java.util.HashMap;


public class FactoryDAO {
    private HashMap<Model, AccessObject> accessObjectMap;

    public FactoryDAO(){
        this.accessObjectMap = new HashMap<Model, AccessObject>();

        Model defaultModel = new DefaultValuesModel();
         accessObjectMap.put(defaultModel,  new DefaultValuesDAO());
    }

    private  void mapDAO(Object model) {
        if (model instanceof DefaultValuesModel) {

        }
        {
        }
    }
    public AccessObject getAccessObject(Model model) {

        return accessObjectMap.get(model);
    }
        public HashMap<Model, AccessObject> getAccessObjectMap() {
            return accessObjectMap;
        }
    }

