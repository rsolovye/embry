package controllers;


import etv.EditCell;
import gwtest.MasterMapper;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.scene.layout.AnchorPane;

import models.MasterModel;
import protocol.maps.VitrifiedEmbryo;
import services.ValueSetter;
import views.MasterView;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.function.Function;

/**
 * Created by bobsol on 19.01.17.
 */
public class VitrificationControllerETV implements Initializable {
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
    private ValueSetter valueSetter = null;

@FXML Button saveCryoButton;
    public VitrificationControllerETV() {
        //this.masterView = masterView;
        //this.masterModel = masterModel;

    }

    public VitrificationControllerETV(String guid) {
        //this.masterView = masterView;
        //this.masterModel = masterModel;
        this.guid = guid;

    }

    public void setGuid(String guid){ this.guid=guid;}

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        valueSetter = new ValueSetter();
        if (guid.length() == 0)
            guid = "61c7628a-2551-4ce5-b134-efd00289d72a";

        valueSetter.setValues(vitrificationInfoPane, "VitrificationMap", guid);
        valueSetter.setValues(vitrificationTableView, "VitrificationMap", guid);


        saveCryoButton.setOnAction((e) -> saveInput());


        //ETV

        vitrificationTableView.setItems(new VitrifiedEmbryoService().getVitrifiedEmbryosList());

        vitrificationTableView.getSelectionModel().setCellSelectionEnabled(true);
        vitrificationTableView.setEditable(true);

        vitrificationTableView.setOnKeyPressed(event -> {
            TablePosition<VitrifiedEmbryo, ?> pos = vitrificationTableView.getFocusModel().getFocusedCell() ;
            if (pos != null && (event.getCode().isLetterKey() || event.getCode().isDigitKey() || event.getCode().isArrowKey()
                    || event.getCode().getName().compareToIgnoreCase("TAB") == 0
                    || event.getCode().getName().compareToIgnoreCase("ENTER") == 0 ) ) {
                vitrificationTableView.edit(pos.getRow(), pos.getTableColumn());
            }
        });
        vitrificationTableView.setOnKeyReleased(event -> {
            TablePosition<VitrifiedEmbryo, ?> pos = vitrificationTableView.getFocusModel().getFocusedCell() ;
            if (pos != null && (event.getCode().isLetterKey() || event.getCode().isDigitKey() || event.getCode().isArrowKey()
                    || event.getCode().getName().compareToIgnoreCase("TAB") == 0
                    || event.getCode().getName().compareToIgnoreCase("ENTER") == 0 ) ) {

                vitrificationTableView.edit(pos.getRow(), pos.getTableColumn());
            }
        });




    }


    /**
     * Insert a new default row to the table, select a cell of it and scroll to it.
     */
    public void addRow() {

        // get current position
        TablePosition pos = vitrificationTableView.getFocusModel().getFocusedCell();

        // clear current selection
        vitrificationTableView.getSelectionModel().clearSelection();

        // create new record and add it to the model
        VitrifiedEmbryo vEmb  = new VitrifiedEmbryo.VitrifiedEmbryoBuilder(guid, "", "").build();

        vitrificationTableView.getItems().add( vEmb);

        // get last row
        int row = vitrificationTableView.getItems().size() - 1;
        vitrificationTableView.getSelectionModel().select( row, pos.getTableColumn());

        // scroll to new row
        vitrificationTableView.scrollTo( vEmb);

    }

    private <T> TableColumn<T, String> createColumn(String title, Function<T, StringProperty> property) {
        TableColumn<T, String> col = new TableColumn<>(title);
        col.setCellValueFactory(cellData -> property.apply(cellData.getValue()));

        col.setCellFactory(column -> EditCell.createStringEditCell());
        return col ;
    }

    /**
     * Remove all selected rows.
     */
    public void removeSelectedRows() {

        vitrificationTableView.getItems().removeAll(vitrificationTableView.getSelectionModel().getSelectedItems());

        // table selects by index, so we have to clear the selection or else items with that index would be selected
        vitrificationTableView.getSelectionModel().clearSelection();


    }

    @FXML
 private void saveInput() {
        System.out.println("saveInput()");
       //for testing only
        if (guid.length() == 0)
            setGuid("61c7628a-2551-4ce5-b134-efd00289d72b");

        HashMap<String, String> inputMap = new HashMap<>();

        inputMap.put("guid", guid);

        valueSetter.mapInput(vitrificationInfoPane,
                        "VitrificationMap",
                                        inputMap);

        MasterMapper.saveToDB(inputMap, "VITRIFICATION");

        ObservableList<HashMap<String, String>> vitrificationTable = FXCollections.observableArrayList();
            System.out.println(vitrificationTableView.getItems().size());
        for (VitrifiedEmbryo n: vitrificationTableView.getItems())
        {
           MasterMapper.remapAndSave(n.getMap(), "VITRIFIEDEMBRYO");
           System.out.println("vitrificationTableView.getItems() :" + n.get("strawNumber") + " " + n.get("embryoNumber"));

        }


}


}














