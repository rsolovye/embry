package daos;

import models.DefaultValuesModel;
import models.Model;
import models.ModelFactory;
import services.DataBaseService;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by bobsol on 23.01.17.
 */
public class DefaultValuesDAO implements AccessObject {

    DataBaseService dataBaseService;
    DefaultValuesModel model;

    public DefaultValuesDAO() {
        model = (DefaultValuesModel) getModel();
        query("SELECT * FROM default_list_values");
    }

    public void fillModel(ResultSet rs){
       try {
           while (rs.next()){

             String listID =  rs.getString("listID");
             Object listValues =  rs.getArray("listValues");

             model.mapDefaultValues(listID, (String[]) listValues);
           }

       } catch (SQLException e) {
           e.printStackTrace();
       }
   }


    @Override
    public void query(String sql) {
        dataBaseService = new DataBaseService();

        fillModel(dataBaseService.executeQuery(sql));
    }

    @Override
    public Model getModel() {
        return new ModelFactory().getModel(Model.DEFAULT_VALUES);
    }


}
