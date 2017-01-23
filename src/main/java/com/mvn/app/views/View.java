package com.mvn.app.views;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by micro on 23.01.2017.
 */
public interface View {
    Map<String, String> inputMap = new HashMap<String, String>();

    HashMap<String, String> getInputMap();
    void setData(HashMap<String, String> dataMap);
    void buildUI();
    JPanel getUI();

}
