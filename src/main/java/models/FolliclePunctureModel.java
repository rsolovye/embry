package models;

import protocol.old.pojos.FolliclePuncture;
import daos.FolliclePunctureDAO;

/**
 * Created by bobsol on 19.01.17.
 */
public class FolliclePunctureModel implements Model {

    private FolliclePuncture.Builder folliclePunctureBuilder;
    private FolliclePuncture folliclePuncture;
    private FolliclePunctureDAO folliclePunctureDAO;

    public FolliclePunctureModel(){
        folliclePunctureBuilder = new FolliclePuncture.Builder();
        folliclePunctureDAO = new FolliclePunctureDAO();
    }


    public void setEmbriologist(String embryologistName){
        folliclePunctureBuilder.embryologist(embryologistName);
    }

    public void setNurse(String nursesName){
        folliclePunctureBuilder.nurse(nursesName);
    }



    public void buildFolliclePuncture(){
        folliclePuncture = folliclePunctureBuilder.build();
    }

    public void saveFolliclePuncture(){
        folliclePunctureDAO.addNewFollcePuncture(folliclePuncture);
    }
}