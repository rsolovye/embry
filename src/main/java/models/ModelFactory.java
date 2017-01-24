package models;

import daos.AccessObject;
import daos.DataModelFactory;
import protocol.*;

import java.util.HashMap;

/**
 * Created by micro on 24.01.2017.
 */
public class ModelFactory extends DataModelFactory {
    private HashMap<String, Model> models =  new HashMap<>();

    public  ModelFactory(){
        models.put(Model.DEFAULT_VALUES, new DefaultValuesModel());
        models.put(Model.PROTOCOL_HEADER, new ProtocolHeaderModel());
        models.put(Model.FOLLICLE_PUNCTURE, new FolliclePunctureModel());
        models.put(Model.FERTILIZATION, new FertilizationModel());
        models.put(Model.PGS_CRYO_ET, new PgsCryoEtModel());
        models.put(Model.CULTIVATION_TABLE, new CultivationTableModel());
        models.put(Model.SPERMIOGRAMM, new SpermiogrammModel());
    }
    @Override
    public Model getModel(String model) {

        return models.get(model);
    }

    @Override
    public AccessObject getAccessObject(String accessObject) {
        return null;
    }
}
