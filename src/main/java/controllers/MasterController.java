package controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.MasterModel;
import models.VitrificationTable;
import protocol.maps.VitrifiedEmbryo;
import views.MasterView;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.ResourceBundle;

/**
 * Created by bobsol on 19.01.17.
 */
public class MasterController implements Initializable {
    private MasterView masterView;
    private MasterModel masterModel;


    @FXML  TableView<VitrifiedEmbryo> vitrificationTableView;
    @FXML  TableColumn<VitrifiedEmbryo, String>  strawNumberCol;
    @FXML  TableColumn<VitrifiedEmbryo, String>  embryoNumberCol;
    @FXML  TableColumn<VitrifiedEmbryo, String>  cryoDpfCol;
    @FXML  TableColumn<VitrifiedEmbryo, String>  cryoStageCol;
    @FXML  TableColumn<VitrifiedEmbryo, String>  cryoNotesCol;
    @FXML  TableColumn<VitrifiedEmbryo, String>  cryoEmbryologistCol;
    @FXML  TableColumn<VitrifiedEmbryo, String>  defrostDate;
    @FXML  TableColumn<VitrifiedEmbryo, String>  defrostEmbryoQuality;
    @FXML  TableColumn<VitrifiedEmbryo, String>  defrostEmbryologist;
    @FXML  TableColumn<VitrifiedEmbryo, String>  defrostSurvival;


    public MasterController() {
        //this.masterView = masterView;
        //this.masterModel = masterModel;


        //masterView.setDeaultValuesMap(masterModel.getDefaultControlValuesMap());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        strawNumberCol.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("strawNumber"));
        embryoNumberCol.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("embryoNumber"));
        cryoDpfCol.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("cryoDpf"));
        cryoStageCol.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("cryoStage"));
        cryoNotesCol.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("cryoNotes"));
        cryoEmbryologistCol.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("cryoEmbryologist"));

        defrostDate.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("defrostDate"));
        defrostEmbryoQuality.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("defrostEmbryoQuality "));
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
