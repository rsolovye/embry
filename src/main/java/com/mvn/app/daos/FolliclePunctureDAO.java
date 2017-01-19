package com.mvn.app.daos;

import com.mvn.app.FolliclePuncture;
import com.mvn.app.services.DataBaseService;

import java.util.ArrayList;

/**
 * Created by bobsol on 19.01.17.
 */
public class FolliclePunctureDAO {

    DataBaseService dbs = new DataBaseService();
    ArrayList<FolliclePuncture> folliclePunctureList;

    public FolliclePunctureDAO(){

    }

    public void addNewFollcePuncture(FolliclePuncture folliclePuncture){
        dbs.insertQuery("INSERT INTO follicle_punctures(LAB_PROTOCOL_ID, Embryologist, Nurse, EggCount)" +
                    "VALUES(\'" + folliclePuncture.getEmbryologist() + "\', \'" +
                    folliclePuncture.getNurse() + "\', \'" +
                    folliclePuncture.getEgg_count() + "\');");
    }


}
