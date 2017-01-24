package models;


import services.*;

import java.sql.JDBCType;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by bobsol on 23.01.17.
 */
public class DefaultValuesModel implements Model, Visitable {
    HashMap<String, ArrayList<String>> listValueMap = new HashMap<>();


    public DefaultValuesModel() {
        try {
            listValueMap = DefaultValuesGateway.findListNames().getDefaultValuesMap();

        } catch (DefaultValuesGatewayExecption defaultValuesGatewayExecption) {
            defaultValuesGatewayExecption.printStackTrace();
        }

    }

//
//    public void mapDefaultValues(String listID, String[] valueArray){
//        System.out.print(getClass().getName() + " : listID :\"" + listID + "\"");
//        listValueMap.put(listID, valueArray);
//    }

    public HashMap<String, ArrayList<String>> getValuesMap() {

        return this.listValueMap;
    }

    public ArrayList<String> getValue(String listID) {
        return this.listValueMap.get(listID);
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visit(this);
    }

    public void setDefaultValuesMap(HashMap<String,ArrayList<String>> defaultValuesMap) {
        this.listValueMap = defaultValuesMap;
    }
}
