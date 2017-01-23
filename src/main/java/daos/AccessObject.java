package daos;

import java.sql.ResultSet;

/**
 * Created by bobsol on 23.01.17.
 */
public interface AccessObject {
    public ResultSet query(String sql);
}
