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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
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
            if (pos != null && (event.getCode().isLetterKey() || event.getCode().isDigitKey())) {
                vitrificationTableView.edit(pos.getRow(), pos.getTableColumn());
            }
        });



    //    vitrificationTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
   /*     vitrificationTableView.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if( event.getCode() == KeyCode.ENTER) {
//                  event.consume(); // don't consume the event or else the values won't be updated;
                    return;
                }

                // switch to edit mode on keypress, but only if we aren't already in edit mode
                if( vitrificationTableView.getEditingCell() == null) {
                    if( event.getCode().isLetterKey() || event.getCode().isDigitKey()) {

                        TablePosition focusedCellPosition = vitrificationTableView.getFocusModel().getFocusedCell();
                        vitrificationTableView.edit(focusedCellPosition.getRow(), focusedCellPosition.getTableColumn());

                    }
                }

            }
        });*/



        // single cell selection mode
       //vitrificationTableView.getSelectionModel().setCellSelectionEnabled(true);
  //      FlowPane buttonBar = new FlowPane();

//        // add new row button
//        Button addButton = new Button( "Add");
//        addButton.setOnAction(e -> {
//            addRow();
//        });
//        addButton.setFocusTraversable(false);// don't let it get the focus or else the table would lose it when we click the button and we's have to request the focus on the table in the event handler
//
//        // remove selected rows button
//        Button removeButton = new Button( "Remove");
//        removeButton.setOnAction(e -> {
//            removeSelectedRows();
//        });
//        removeButton.setFocusTraversable(false);// don't let it get the focus or else the table would lose it when we click the button and we's have to request the focus on the table in the event handlervitrifica
//        buttonBar.getChildren().addAll( addButton, removeButton);
//


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














