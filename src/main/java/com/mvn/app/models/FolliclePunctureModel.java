package com.mvn.app.models;

import com.mvn.app.FolliclePuncture;
import com.mvn.app.daos.FolliclePunctureDAO;

/**
 * Created by bobsol on 19.01.17.
 */
public class FolliclePunctureModel {

    private FolliclePuncture.Builder folliclePunctureBuilder;
    private FolliclePuncture folliclePuncture;
    private FolliclePunctureDAO folliclePunctureDAO;

    public FolliclePunctureModel(){
        folliclePunctureBuilder = new FolliclePuncture.Builder();
        folliclePunctureDAO = new FolliclePunctureDAO();
    }

    public void setLabProtocolID(int labProtocolID){
        folliclePunctureBuilder.labProtocolID(labProtocolID);
    }
    public void setEmbriologist(String embryologistName){
        folliclePunctureBuilder.embryologist(embryologistName);
    }

    public void setNurse(String nursesName){
        folliclePunctureBuilder.nurse(nursesName);
    }


    public void setEggCount(int eggCount){
        folliclePunctureBuilder.eggCount(eggCount);
    }

    public void buildFolliclePuncture(){
        folliclePuncture = folliclePunctureBuilder.build();
    }

    public void saveFolliclePuncture(){
        folliclePunctureDAO.addNewFollcePuncture(folliclePuncture);
    }
}