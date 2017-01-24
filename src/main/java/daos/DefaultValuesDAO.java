package daos;

import models.DefaultValuesModel;
import models.Model;
import models.ModelFactory;
import services.DataBaseService;
import services.DefaultValuesGateway;
import services.DefaultValuesGatewayExecption;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by bobsol on 23.01.17.
 */
public class DefaultValuesDAO implements AccessObject {

    DefaultValuesModel model;


    public DefaultValuesDAO() {
        model = (DefaultValuesModel) getModel();
        try {
            model.setDefaultValuesMap(DefaultValuesGateway.findListNames().getDefaultValuesMap());
        } catch (DefaultValuesGatewayExecption defaultValuesGatewayExecption) {
            defaultValuesGatewayExecption.printStackTrace();
        }
    }




    @Override
    public void query(String sql) {

    }

    @Override
    public Model getModel() {
        return new ModelFactory().getModel(Model.DEFAULT_VALUES);
    }


}
