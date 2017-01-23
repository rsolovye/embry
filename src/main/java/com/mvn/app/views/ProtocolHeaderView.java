package com.mvn.app.views;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by micro on 23.01.2017.
 */
public class ProtocolHeaderView implements View{

    private ArrayList<JComponent> inputComponents;
    private JPanel viewPanel;
    private ArrayList<String> diagnosisCodes;
    private MasterView masterView;

    private JList doctorsList;
    public ProtocolHeaderView(MasterView masterView) {
       this.viewPanel = new JPanel();
       this.masterView = masterView;
    }


    public void setDiagnosisCodes(ArrayList<String> diagnosisCodes){
            this.diagnosisCodes = diagnosisCodes;
    }

    @Override
    public HashMap<String, String> getInputMap() {
      HashMap<String, String> mappedInput = new HashMap<>();
      for (JComponent component: inputComponents) {
              mappedInput.put(component.getName(), getComponentValue(component));
      }

      return mappedInput;
    }

    private String getComponentValue(JComponent component){
        String componentValue = new String();
        if (component instanceof JTextField)
        {
         componentValue = ((JTextField) component).getText();
        }
        else if (component instanceof JComboBox)
        {
            componentValue = (String) ((JComboBox) component).getModel().getSelectedItem();
        }

        else if (component instanceof JList)
        {
            componentValue = (String) ((JList) component).getSelectedValue();
        }

        return componentValue;
    }

    @Override
    public void setData(HashMap<String, String> dataMap) {

    }

    @Override
    public void buildUI() {

        doctorsList = new JList();
        doctorsList.setListData(masterView.getDefraultValues("doctors").toArray());
        viewPanel.add(doctorsList);
    }

    @Override
    public JPanel getUI() {
        return viewPanel;
    }
}
