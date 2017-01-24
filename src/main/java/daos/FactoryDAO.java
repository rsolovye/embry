package daos;

import models.DefaultValuesModel;
import models.Model;
import models.ModelFactory;

import java.util.HashMap;
import java.util.StringJoiner;


public class FactoryDAO extends DataModelFactory{
    private HashMap<String, AccessObject> accessObjectMap;

    public FactoryDAO(){
        this.accessObjectMap = new HashMap<>();


        accessObjectMap.put(Model.DEFAULT_VALUES, new DefaultValuesDAO());
        accessObjectMap.put(Model.DEFAULT_VALUES, new ProtocolHeaderDAO());
        accessObjectMap.put(Model.FOLLICLE_PUNCTURE, new FolliclePunctureDAO());
        accessObjectMap.put(Model.FERTILIZATION, new FertilizationDAO());
        accessObjectMap.put(Model.PGS_CRYO_ET, new PgsCryoEtDAO());
        accessObjectMap.put(Model.CULTIVATION_TABLE, new CultivationTableDAO());
        accessObjectMap.put(Model.SPERMIOGRAMM, new SpermiogrammDAO());

    }


    @Override
    public Model getModel(String model) {
        this.accessObjectMap.get(model).getModel();
        return new ModelFactory().getModel(model);
    }

    @Override
    public AccessObject getAccessObject(String accessObject) {
        return this.accessObjectMap.get(accessObject);
    }

    public HashMap<String, AccessObject> getAllaccessObjects(){
        return this.accessObjectMap;
    }
}

