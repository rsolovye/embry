package controllers;

import gwtest.DefaultValues;
import gwtest.MasterMapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swt.FXCanvas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
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
    @FXML ComboBox<String> doctors;
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
    @FXML  TableColumn<VitrifiedEmbryo, Typ>  defrostEmbryologist;
    @FXML  TableColumn<VitrifiedEmbryo, String>  defrostSurvival;


    public VitrificationController() {
        //this.masterView = masterView;
        //this.masterModel = masterModel;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        ArrayList<Protocol> listP = MasterMapper.findByGuid(UUID.fromString("61c7628a-2551-4ce5-b134-efd00289d72a"));
        doctors.setItems(DefaultValues.getObservableList("DOCTORS"));
        sectionColor.setItems(DefaultValues.getObservableList("SECTION_COLOR"));
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
                doctors.getSelectionModel().select(map.get("doctor"));
                sectionColor.getSelectionModel().select(map.get("sectionColor"));
                System.out.println(map.get("doctor"));
            }
        }


        strawNumberCol.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("strawNumber"));
        embryoNumberCol.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("embryoNumber"));
        cryoDpfCol.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("cryoDpf"));
        cryoStageCol.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("cryoStage"));
        cryoNotesCol.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("cryoNotes"));
        cryoEmbryologistCol.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("cryoEmbryologist"));

        defrostDate.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("defrostDate"));

        defrostDate.setCellFactory(TextFieldTableCell.forTableColumn());



        Callback<TableColumn<VitrifiedEmbryo, String>, TableCell<VitrifiedEmbryo, String>> cellFactory
                = (TableColumn<VitrifiedEmbryo, String> param) -> new EditingCell();

        Callback<TableColumn<VitrifiedEmbryo, String>, TableCell<VitrifiedEmbryo, Typ>> comboBoxCellFactory
                = (TableColumn<VitrifiedEmbryo, String> param) -> new ComboBoxEditingCell();
        defrostEmbryologist.setCellValueFactory(cellData -> cellData.getValue().(new PropertyValueFactory<VitrifiedEmbryo, Typ>("defrostEmbryologist"));

        defrostDate.setCellFactory(cellFactory);
        defrostEmbryologist.setOnEditCommit(
                (TableColumn.CellEditEvent<VitrifiedEmbryo, Typ> t) -> {
                    ((VitrifiedEmbryo) t.getTableView().getItems()
                            .get(t.getTablePosition().getRow()))
                            .setDefrostEmbryologist(t.getNewValue().getTyp());
                    });





        defrostEmbryologist.setCellFactory(comboBoxCellFactory);
        defrostDate.setOnEditCommit(
                (TableColumn.CellEditEvent<VitrifiedEmbryo, String> t) -> {
                    ((VitrifiedEmbryo) t.getTableView().getItems()
                            .get(t.getTablePosition().getRow()))
                            .setDefrostDate((t.getNewValue()));

                } );
        defrostEmbryo.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("defrostEmbryo"));
        defrostMedia.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("defrostMedia"));
          defrostSurvival.setCellValueFactory(new PropertyValueFactory<VitrifiedEmbryo, String>("defrostSurvival"));

        vitrificationTableView.setItems(new VitrifiedEmbryoService().getVitrifiedEmbryosList());
    }



    public void getDefaultControlValuesMap(){

        for (String d:  masterModel.getDefaultControlValuesMap().keySet() )
        {

                System.out.print(d + " - " + masterModel.getDefaultControlValuesMap().get(d));

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

    class ComboBoxEditingCell extends TableCell<VitrifiedEmbryo, String> {

        private ComboBox<Typ> comboBox;

        private ComboBoxEditingCell() {
        }

        @Override
        public void startEdit() {
            if (!isEmpty()) {
                super.startEdit();
                createComboBox();
                setText(null);
                setGraphic(comboBox);
            }
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();

            setText(getTyp().getTyp());
            setGraphic(null);
        }

        @Override
        public void updateItem(Typ item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (comboBox != null) {
                        comboBox.setValue(getTyp());
                    }
                    setText(getTyp().getTyp());
                    setGraphic(comboBox);
                } else {
                    setText(getTyp().getTyp());
                    setGraphic(null);
                }
            }
        }

        private void createComboBox() {
           ObservableList<Typ> embTyp = FXCollections.observableArrayList();
            for (String str: DefaultValues.getObservableList("EMBRYOLOGIST")){
               embTyp.add(new Typ(str));
            }

            comboBox = new ComboBox<Typ>(embTyp);
            comboBoxConverter(comboBox);
            comboBox.valueProperty().set(getTyp());
            comboBox.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
            comboBox.setOnAction((e) -> {
                System.out.println("Committed: " + comboBox.getSelectionModel().getSelectedItem());
                commitEdit(comboBox.getSelectionModel().getSelectedItem());
            });
//            comboBox.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
//                if (!newValue) {
//                    commitEdit(comboBox.getSelectionModel().getSelectedItem());
//                }
//            });
        }

        private void comboBoxConverter(ComboBox<Typ> comboBox) {
            // Define rendering of the list of values in ComboBox drop down.
            comboBox.setCellFactory((c) -> {
                return new ListCell<Typ>() {
                    @Override
                    protected void updateItem(Typ item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item.getTyp());
                        }
                    }
                };
            });
        }

        private Typ getTyp() {
            return getItem() == null ? new Typ("") : getItem();
        }
    }

    public static class Typ {

        private final SimpleStringProperty typ;

        public Typ(String typ) {
            this.typ = new SimpleStringProperty(typ);
        }

        public String getTyp() {
            return this.typ.get();
        }

        public StringProperty typProperty() {
            return this.typ;
        }

        public void setTyp(String typ) {
            this.typ.set(typ);
        }

        @Override
        public String toString() {
            return typ.get();
        }

    }
}
