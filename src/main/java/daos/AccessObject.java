package daos;

import models.Model;

/**
 * Created by bobsol on 23.01.17.
 */
public abstract class AccessObject {


    public abstract void query();
    public abstract void query(String sql);
    public abstract Model getModel();
}
