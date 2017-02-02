package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.MasterModel;
import models.VitrificationTable;
import views.MasterView;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * Created by bobsol on 19.01.17.
 */
public class MasterController implements Initializable {
    private MasterView masterView;
    private MasterModel masterModel;
    @FXML
    TableView<VitrificationTable> vitrificationTableView;
    TableColumn<VitrificationTable, String>  strawCol;
    TableColumn<VitrificationTable, String>  embCol;
    TableColumn<VitrificationTable, String>  dpfCol;
    TableColumn<VitrificationTable, String>  devStage;
    TableColumn<VitrificationTable, String>  vitNotes;
    TableColumn<VitrificationTable, String>  vitSignature;
    TableColumn<VitrificationTable, String>  defrostDate;
    TableColumn<VitrificationTable, String>  defrostEmb;
    TableColumn<VitrificationTable, String>  defrostignature;
    TableColumn<VitrificationTable, String>  defrostSurvival;
    public MasterController(MasterView masterView, MasterModel masterModel) {
        this.masterView = masterView;
        this.masterModel = masterModel;


        //masterView.setDeaultValuesMap(masterModel.getDefaultControlValuesMap());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        strawCol.setCellValueFactory(new PropertyValueFactory<VitrificationTable, String>("strawCol"));
        strawCol.setCellValueFactory(new PropertyValueFactory<VitrificationTable, String>("embCol"));

        strawCol.setCellValueFactory(new PropertyValueFactory<VitrificationTable, String>("dpfCol"));

        strawCol.setCellValueFactory(new PropertyValueFactory<VitrificationTable, String>("devStage"));

        strawCol.setCellValueFactory(new PropertyValueFactory<VitrificationTable, String>("vitNotes"));

        strawCol.setCellValueFactory(new PropertyValueFactory<VitrificationTable, String>("vitSignature"));
        strawCol.setCellValueFactory(new PropertyValueFactory<VitrificationTable, String>("defrostDate"));
        strawCol.setCellValueFactory(new PropertyValueFactory<VitrificationTable, String>("defrostEmb "));
        strawCol.setCellValueFactory(new PropertyValueFactory<VitrificationTable, String>("defrostSignature"));
        strawCol.setCellValueFactory(new PropertyValueFactory<VitrificationTable, String>("defrostSurvival"));

    }

    public void getDefaultControlValuesMap(){

        for (String d:  masterModel.getDefaultControlValuesMap().keySet() )
        {

                System.out.print(d + " - " + masterModel.getDefaultControlValuesMap().get(d));

        }
    }

}
