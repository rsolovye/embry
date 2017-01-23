package com.mvn.app.controllers;

import com.mvn.app.models.MasterModel;
import com.mvn.app.views.MasterView;

import java.util.ArrayList;

/**
 * Created by bobsol on 19.01.17.
 */
public class MasterController {
    private MasterView masterView;
    private MasterModel masterModel;
    ArrayList<Controller> controllers = new ArrayList<>();

    public MasterController(MasterView masterView, MasterModel masterModel) {
        this.masterView = masterView;
        this.masterModel = masterModel;

    }


}
