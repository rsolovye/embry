package views;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bobsol on 19.01.17.
 */
public class MasterView{
    public HashMap<String, View> viewPanels;
     HashMap<String, String[]> defaultValues;

    public JPanel masterViewPanel;

    public MasterView() {
        masterViewPanel = new JPanel();
        viewPanels = new HashMap<>();
        initializeViews();


    }

    public void setDeaultValuesMap(HashMap<String, String[]> defaultValuesMap){
        defaultValues = defaultValuesMap;
    }

    private void  initializeViews(){
        viewPanels.put("ProtocolHeader", new ProtocolHeaderView(defaultValues));

    }


    public void mapDefaultValues(String listName, String[] value){

        defaultValues.put(listName, value);
    }

    public void fillComponentsWithValues(){

    }
    public JPanel getUI(){
        return this.masterViewPanel;
    }


}
