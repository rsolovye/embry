package controllers;

import gwtest.MasterMapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.MasterModel;
import protocol.maps.Protocol;
import protocol.maps.VitrificationMap;
import protocol.maps.VitrifiedEmbryo;
import views.MasterView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.UUID;

/**
 * Created by bobsol on 19.01.17.
 */
public class VitrificationController implements Initializable {
    private MasterView masterView;
    private MasterModel masterModel;

    @FXML TextField fName;
    @FXML TextField fDOB;
    @FXML TextField fCode;
    @FXML TextField mCode;
    @FXML TextField mName;
    @FXML TextField mDOB;
    @FXML TextField vitDate;
    @FXML TextField vitVRT;
    @FXML TextField dewar;
    @FXML TextField canister;
    @FXML ComboBox<String> sectionColor;
    @FXML ListView<String> doctors;
    @FXML TextField vitMedia;
    @FXML TextField sectionCount;
    @FXML TextField strawCount;
    @FXML TextField embryoCount;
    @FXML CheckBox isOms;
    @FXML CheckBox isPostponed;
    @FXML CheckBox fromAnotherClinic;
    @FXML  TableView<VitrifiedEmbryo> vitrificationTableView;
    @FXML  TableColumn<VitrifiedEmbryo, String>  strawNumberCol;
    @FXML  TableColumn<VitrifiedEmbryo, String>  embryoNumberCol;
    @FXML  TableColumn<VitrifiedEmbryo, String>  cryoDpfCol;
    @FXML  TableColumn<VitrifiedEmbryo, String>  cryoStageCol;
    @FXML  TableColumn<VitrifiedEmbryo, String>  cryoNotesCol;
    @FXML  TableColumn<VitrifiedEmbryo, String>  cryoEmbryologistCol;
    @FXML  TableColumn<VitrifiedEmbryo, String>  defrostDate;
    @FXML  TableColumn<VitrifiedEmbryo, String>  defrostEmbryo;
    @FXML  TableColumn<VitrifiedEmbryo, String>  defrostMedia;
    @FXML  TableColumn<VitrifiedEmbryo, String>  defrostEmbryologist;
    @FXML  TableColumn<VitrifiedEmbryo, String>  defrostSurvival;


    public VitrificationController() {
        //this.masterView = masterView;
        //this.masterModel = masterModel;


        //masterView.setDeaultValuesMap(masterModel.getDefaultControlValuesMap());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        ArrayList<Protocol> listP = MasterMapper.findByGuid(UUID.fromString("61c7628a-2551-4ce5-b134-efd00289d72a"));

        for (Protocol protocol : listP) {
            if (protocol.getClass().getSimpleName().equalsIgnoreCase("VitrificationMap")) {
                VitrificationMap map = (VitrificationMap) protocol;
                map.print();

                vitDate.setText(map.get("vitDate"));
                vitVRT.setText(map.get("vitVRT"));

                fName.setText(map.get("fName"));
                fDOB.setText(map.get("fDOB"));
                fCode.setText(map.get("fCode"));
                mName.setText(map.get("mName"));
                mDOB.setText(map.get("mDOB"));

                mCode.setText(map.get("mCode"));
                dewar.setText(map.get("dewar"));
                canister.setText(map.get("canister"));
                //'Doc
                //'sectionColor.setText(map.get("color"));;
                vitMedia.setText(map.get("vitMedia"));
                sectionCount.setText(map.get("sectionCount"));
                strawCount.setText(map.get("strawCount"));
                embryoCount.setText(map.get("embryoCount"));
                isOms.setSelected(map.get("isOms").compareTo("1")==0);
                isPostponed.setSelected(map.get("isPostponed").compareTo("1")==0);
                fromAnotherClinic.setSelected(map.get("fromAnotherClinic").compareTo("1")==0);
            }
        }


        strawNumberCol.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("strawNumber"));
        embryoNumberCol.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("embryoNumber"));
        cryoDpfCol.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("cryoDpf"));
        cryoStageCol.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("cryoStage"));
        cryoNotesCol.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("cryoNotes"));
        cryoEmbryologistCol.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("cryoEmbryologist"));


        defrostDate.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("defrostDate"));
        defrostEmbryo.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("defrostEmbryo"));
        defrostMedia.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("defrostMedia"));
        defrostEmbryologist.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("defrostEmbryologist"));
        defrostSurvival.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("defrostSurvival"));

        vitrificationTableView.setItems(new VitrifiedEmbryoService().getVitrifiedEmbryosList());
    }



    public void getDefaultControlValuesMap(){

        for (String d:  masterModel.getDefaultControlValuesMap().keySet() )
        {

                System.out.print(d + " - " + masterModel.getDefaultControlValuesMap().get(d));

        }

    }

}
