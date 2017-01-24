package daos;

import models.Model;

/**
 * Created by micro on 24.01.2017.
 */
public abstract class DataModelFactory {


    public abstract Model getModel(String model);
    public abstract AccessObject getAccessObject(String accessObject);

}
