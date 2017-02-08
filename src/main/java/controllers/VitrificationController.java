package controllers;


import gwtest.DefaultValues;
import gwtest.MasterMapper;
import gwtest.RowObject;
import gwtest.RowObjects;
import javafx.beans.property.SimpleStringProperty;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import models.MasterModel;
import protocol.maps.Protocol;
import protocol.maps.VitrifiedEmbryo;
import services.ValueSetter;
import views.MasterView;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.UUID;

/**
 * Created by bobsol on 19.01.17.
 */
public class VitrificationController implements Initializable {
    private MasterView masterView;
    private MasterModel masterModel;

    @FXML
    TextField fName;
    @FXML
    TextField fDOB;
    @FXML
    TextField fCode;
    @FXML
    TextField mCode;
    @FXML
    TextField mName;
    @FXML
    TextField mDOB;
    @FXML
    TextField vitDate;
    @FXML
    TextField vitVRT;
    // @FXML TextField dewar;
    @FXML
    TextField canister;
    @FXML
    ComboBox<String> sectionColor;
    @FXML
    ComboBox<String> doctor;
    @FXML
    TextField vitMedia;
    @FXML
    TextField sectionCount;
    @FXML
    TextField strawCount;
    @FXML
    TextField embryoCount;
    @FXML
    CheckBox isOms;
    @FXML
    CheckBox isPostponed;
    @FXML
    CheckBox fromAnotherClinic;
    @FXML
    TableView<VitrifiedEmbryo> vitrificationTableView;
    @FXML
    TableColumn<VitrifiedEmbryo, String> strawNumber;
    @FXML
    TableColumn<VitrifiedEmbryo, String> embryoNumber;
    @FXML
    TableColumn<VitrifiedEmbryo, String> cryoDpf;
    @FXML
    TableColumn<VitrifiedEmbryo, String> cryoStage;
    @FXML
    TableColumn<VitrifiedEmbryo, String> cryoNotes;
    @FXML
    TableColumn<VitrifiedEmbryo, String> cryoEmbryologist;
    @FXML
    TableColumn<VitrifiedEmbryo, String> defrostDate;
    @FXML
    TableColumn<VitrifiedEmbryo, String> defrostEmbryo;
    @FXML
    TableColumn<VitrifiedEmbryo, String> defrostMedia;
    @FXML
    TableColumn<VitrifiedEmbryo, String> defrostEmbryologist;
    @FXML
    TableColumn<VitrifiedEmbryo, String> defrostSurvival;
    @FXML
    AnchorPane vitrificationInfoPane;
    @FXML
    AnchorPane tableViewPane;
    private String guid = "";
@FXML Button saveCryoButton;
    public VitrificationController() {
        //this.masterView = masterView;
        //this.masterModel = masterModel;

    }

    public VitrificationController(String guid) {
        //this.masterView = masterView;
        //this.masterModel = masterModel;
        this.guid = guid;

    }

    public void setGuid(String guid){ this.guid=guid;}

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        if (guid.length() == 0)
            guid = "61c7628a-2551-4ce5-b134-efd00289d72a";

        ValueSetter.setValues(vitrificationInfoPane, "VitrificationMap", guid);
        ValueSetter.setValues(vitrificationTableView, "VitrificationMap", guid);

        Callback<TableColumn<VitrifiedEmbryo, String>, TableCell<VitrifiedEmbryo, String>> cellFactory
                = (TableColumn<VitrifiedEmbryo, String> param) -> new EditingCell();
        saveCryoButton.setOnAction((e) -> saveInput());
        vitrificationTableView.setItems(new VitrifiedEmbryoService().getVitrifiedEmbryosList());
    }
    @FXML
 private void saveInput() {
       //for testing only
        if (guid.length() == 0)
            setGuid("61c7628a-2551-4ce5-b134-efd00289d72b");

        HashMap<String, String> inputMap = new HashMap<>();

        inputMap.put("guid", guid);

        ValueSetter.mapInput(vitrificationInfoPane,
                        "VitrificationMap",
                                        inputMap);

        MasterMapper.saveToDB(inputMap, "VITRIFICATION");

        ObservableList<HashMap<String, String>> vitrificationTable = FXCollections.observableArrayList();

        for (VitrifiedEmbryo n: vitrificationTableView.getItems())
        {

           System.out.println("vitrificationTableView.getItems() :" + n.get("cryoStage"));

        }


}

    class EditingCell extends TableCell<VitrifiedEmbryo, String> {

        private TextField textField;

        private EditingCell() {
        }

        @Override
        public void startEdit() {
            if (!isEmpty()) {
                super.startEdit();
                createTextField();
                setText(null);
                setGraphic(textField);
                textField.selectAll();
            }
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();

            setText((String) getItem());
            setGraphic(null);
        }

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(item);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
//                        setGraphic(null);
                    }
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(getString());
                    setGraphic(null);
                }
            }
        }

        private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
            textField.setOnAction((e) -> commitEdit(textField.getText()));
            textField.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                if (!newValue) {
                    System.out.println("Commiting " + textField.getText());
                    commitEdit(textField.getText());
                }
            });
        }

        private String getString() {
            return getItem() == null ? "" : getItem();
        }
    }

}
//        doctor.setItems(DefaultValues.getObservableList("DOCTORS"));
    //      sectionColor.setItems(DefaultValues.getObservableList("SECTION_COLOR"));

//        for (Protocol protocol : listP) {
//            if (protocol.getClass().getSimpleName().equalsIgnoreCase("VitrificationMap")) {
//                VitrificationMap map = (VitrificationMap) protocol;
//
//                for (javafx.scene.Node n: vitrificationInfoPane.getChildren()){
//                    System.out.println(n.getId() + " - " + n.getClass().getSimpleName());
//                    String type =  n.getClass().getSimpleName();
//                    if (type.compareTo("TextField")  == 0)
//                        ((TextField) n).setText(map.get(n.getId()));
//                    if (type.compareTo("CheckBox")  == 0)
//                        ((CheckBox) n).setSelected(map.get(n.getId()).compareTo("1") == 0);
//                    if (type.compareTo("ComboBox")  == 0)
//                        ((ComboBox) n).getSelectionModel().select(map.get(n.getId()));
//                    if (type.compareTo("ListView")  == 0)
//                        ((ListView) n).getSelectionModel().select(map.get(n.getId()));
//                }
//
//                vitDate.setText(map.get("vitDate"));
//                vitVRT.setText(map.get("vitVRT"));
//
//                fName.setText(map.get("fName"));
//                fDOB.setText(map.get("fDOB"));
//                fCode.setText(map.get("fCode"));
//                mName.setText(map.get("mName"));
//                mDOB.setText(map.get("mDOB"));
//
//                mCode.setText(map.get("mCode"));
//                dewar.setText(map.get("dewar"));
//                canister.setText(map.get("canister"));
//
//                vitMedia.setText(map.get("vitMedia"));
//                sectionCount.setText(map.get("sectionCount"));
//                strawCount.setText(map.get("strawCount"));
//                embryoCount.setText(map.get("embryoCount"));
//
//                isOms.setSelected(map.get("isOms").compareTo("1")==0);
//                isPostponed.setSelected(map.get("isPostponed").compareTo("1")==0);
//                fromAnotherClinic.setSelected(map.get("fromAnotherClinic").compareTo("1")==0);
//
//                doctors.getSelectionModel().select(map.get("doctor"));
//                sectionColor.getSelectionModel().select(map.get("sectionColor"));

//            }
//        }
    //  defrostDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDefrostDate()));
    // defrostDate.setCellFactory(TextFieldTableCell.forTableColumn());

//        defrostEmbryo.setCellFactory(TextFieldTableCell.forTableColumn());
//        defrostEmbryo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDefrostEmbryo()));
//
//        defrostEmbryo.setOnEditCommit( (TableColumn.CellEditEvent<VitrifiedEmbryo, String> t) -> ( t.getTableView().getItems()
//                .get(t.getTablePosition().getRow()))
//                .setDefrostEmbryo((t.getNewValue())));
//
//        defrostEmbryologist.setCellValueFactory(cellData -> cellData.getValue().getDefrostEmbryologistProperty());
//        defrostEmbryologist.setOnEditCommit(
//                (TableColumn.CellEditEvent<VitrifiedEmbryo, String> t) -> ( t.getTableView().getItems()
//                        .get(t.getTablePosition().getRow()))
//                        .setDefrostEmbryologist(t.getNewValue()));
//        defrostEmbryologist.setCellFactory(comboBoxCellFactory);

//        defrostDate.setOnEditCommit(
//                (TableColumn.CellEditEvent<VitrifiedEmbryo, String> t) -> ( t.getTableView().getItems()
//                        .get(t.getTablePosition().getRow()))
////                        .setDefrostDate((t.getNewValue())));
//
//        defrostDate.setOnEditCommit(
//                (TableColumn.CellEditEvent<VitrifiedEmbryo, String> t) -> ( t.getTableView().getItems()
//                        .get(t.getTablePosition().getRow()))
//                        .set(defrostDate.getId(), new SimpleStringProperty(t.getNewValue())));
//
//        defrostMedia.setCellFactory(cellFactory);
//        defrostMedia.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDefrostMedia()));
//        defrostMedia.setOnEditCommit( (TableColumn.CellEditEvent<VitrifiedEmbryo, String> t) -> ( t.getTableView().getItems()
//                .get(t.getTablePosition().getRow()))
//                .setDefrostMedia((t.getNewValue())));
//
//        defrostSurvival.setCellFactory(cellFactory);
//        defrostSurvival.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDefrostSurvival()));
//        defrostSurvival.setOnEditCommit( (TableColumn.CellEditEvent<VitrifiedEmbryo, String> t) -> ( t.getTableView().getItems()
//                .get(t.getTablePosition().getRow()))
//                .setDefrostSurvival((t.getNewValue())));

//        cryoEmbryologistCol.setCellValueFactory(
//                cellData -> new SimpleStringProperty(cellData.getValue().getCryoEmbryologist()));
//        cryoEmbryologistCol.setCellFactory(ComboBoxTableCell.forTableColumn(DefaultValues.getObservableList("EMBRYOLOGISTS")));
//        cryoEmbryologistCol.setOnEditCommit(
//                t -> ( t.getTableView().getItems().get(t.getTablePosition().getRow())).setCryoEmbryologist(t.getNewValue())
//        );














