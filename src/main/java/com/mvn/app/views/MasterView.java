package com.mvn.app.views;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bobsol on 19.01.17.
 */
public class MasterView{
    public HashMap<String, View> viewPanels;
    private HashMap<String, ArrayList<String>> defaultValues;

    public JPanel masterViewPanel;

    public MasterView() {
        masterViewPanel = new JPanel();
        viewPanels = new HashMap<>();
        initializeViews();
        defaultValues = new HashMap<>();

    }

    private void  initializeViews(){
        viewPanels.put("ProtocolHeader", new ProtocolHeaderView(this));

    }
    public ArrayList<String> getDefraultValues(String listName){
        return (ArrayList<String>) defaultValues.get(listName);
    }

    public void mapDefaultValues(String listName, ArrayList<String> value){
        defaultValues.put(listName, value);
    }
    public void fillComponentsWithValues(){

    }
    public JPanel getUI(){
        return this.masterViewPanel;
    }


}
