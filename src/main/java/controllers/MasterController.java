package controllers;

import models.MasterModel;
import views.MasterView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bobsol on 19.01.17.
 */
public class MasterController {
    private MasterView masterView;
    private MasterModel masterModel;


    public MasterController(MasterView masterView, MasterModel masterModel) {
        this.masterView = masterView;
        this.masterModel = masterModel;

        //masterView.setDeaultValuesMap(masterModel.getDefaultControlValuesMap());
    }

    public void getDefaultControlValuesMap(){

        for (String d:  masterModel.getDefaultControlValuesMap().keySet() )
        {

                System.out.print(d + " - " + masterModel.getDefaultControlValuesMap().get(d));

        }
    }

}
