package daos;

import models.Model;
import protocol.old.pojos.FolliclePuncture;
import services.DataBaseService;

import java.util.ArrayList;

/**
 * Created by bobsol on 19.01.17.
 */
public class FolliclePunctureDAO extends AccessObject {

    DataBaseService dbs = new DataBaseService();
    ArrayList<FolliclePuncture> folliclePunctureList;

    public FolliclePunctureDAO(){

    }

    public void addNewFollcePuncture(FolliclePuncture folliclePuncture){
     //   dbs.insertQuery("INSERT INTO follicle_punctures(LAB_PROTOCOL_ID, Embryologist, Nurse, EggCount)" +
      //              "VALUES(\'" + folliclePuncture.getEmbryologist() + "\', \'" +
      //              folliclePuncture.getNurse() + "\', \'" +
      //              folliclePuncture.getEgg_count() + "\');");
    }


    @Override
    public void query() {

    }

    @Override
    public void query(String sql) {

    }

    @Override
    public Model getModel() {
        return null;
    }


}
