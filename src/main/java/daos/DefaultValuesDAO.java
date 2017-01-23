package daos;

import services.DataBaseService;

import java.sql.ResultSet;

/**
 * Created by bobsol on 23.01.17.
 */
public class DefaultValuesDAO implements AccessObject {
    DataBaseService dataBaseService;
    @Override
    public ResultSet query(String sql) {
        dataBaseService = new DataBaseService();

        return         dataBaseService.executeQuery(sql);
    }




}
