package daos;

import models.Model;

import java.sql.ResultSet;

/**
 * Created by bobsol on 23.01.17.
 */
public interface AccessObject {
    public void query(String sql);
    public Model getModel();
}
