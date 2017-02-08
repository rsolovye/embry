package services;

import com.sun.rowset.internal.Row;
import controllers.VitrifiedEmbryoService;
import gwtest.DefaultValues;
import gwtest.MasterMapper;
import gwtest.RowObject;
import gwtest.RowObjects;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import protocol.maps.Protocol;
import protocol.maps.VitrifiedEmbryo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class ValueSetter {


    public static void setValues(Pane pane, String protocolType, String guid) {
System.out.println("GUID=" + guid);

       // String guid = "61c7628a-2551-4ce5-b134-efd00289d72a"
        ArrayList<Protocol> listP = MasterMapper.findByGuid(UUID.fromString(guid));

        for (Protocol protocol : listP) {

            if (protocol.getClass().getSimpleName().equalsIgnoreCase(protocolType)) {

                for (javafx.scene.Node n : pane.getChildren()) {
                    String value = (protocol.get(n.getId()) == null) ? "" :  protocol.get(n.getId());
                    System.out.println(pane.getId() + " - " + n.getId() + " - " + n.getClass().getSimpleName());

                    String type = n.getClass().getSimpleName();
                    if (isPane(type)) {
                        setValues((Pane) n, protocolType, guid);
                    }
                    if (type.compareTo("TextField") == 0)
                        ((TextField) n).setText(value);

                    if (type.compareTo("CheckBox") == 0) {
                        System.out.println(n.getId() + " " + value);

                        ((CheckBox) n).setSelected(value.compareTo("1") == 0);
                    }

                    if (type.compareTo("ComboBox") == 0) {
                        ((ComboBox) n).setItems(DefaultValues.getObsservableListForThisControl(n.getId()));
                        ((ComboBox) n).getSelectionModel().select(value);
                    }
                    if (type.compareTo("ListView") == 0) {
                        ((ListView) n).setItems(DefaultValues.getObsservableListForThisControl(n.getId()));
                        ((ListView) n).getSelectionModel().select(value);
                    }
                }
            }
        }
    }

    public static void  mapInput(Pane pane, String rowObjectType, HashMap<String, String> inputMap) {

        for (javafx.scene.Node n : pane.getChildren()) {
            String className = n.getClass().getSimpleName();

            if (isPane(className))
                mapInput((Pane) n, rowObjectType, inputMap);

            if (className.compareTo("TextField") == 0)
                inputMap.put(n.getId(), ((TextField) n).getText());

            if (className.compareTo("CheckBox") == 0)
                inputMap.put(n.getId(), ((CheckBox) n).isSelected() ? "1" : "0");


            if (className.compareTo("ComboBox") == 0){
               String selection = ((ComboBox<String>) n)
                       .getSelectionModel().getSelectedItem();
               inputMap.put(n.getId(), (selection == null) ? "" : selection);
            }
            if (className.compareTo("ListView") == 0) {
                String selection = ((ListView<String>) n)
                                        .getSelectionModel()
                                        .getSelectedItem();
                inputMap.put(n.getId(), (selection == null) ? "" : selection);
            }
        }
}

    private static boolean isPane(String className) {
        String[] paneTypeNames = {"AnchorPane", "VBox", "HBox", "BorderPane", "GridPane", "FlowPane", "ScrollPane", "TabPane"};
        boolean res = false;
        for (String pT : paneTypeNames) {
            if (pT.compareToIgnoreCase(className) == 0) {
                res = true;
            }
        }
        return res;
    }

    public static void setValues(TableView<VitrifiedEmbryo> pane, String protocolType, String guid) {

        //String id = "61c7628a-2551-4ce5-b134-efd00289d72a"
        ObservableList<VitrifiedEmbryo> vEmbList = new VitrifiedEmbryoService().getVitrifiedEmbryosList();

        UUID requestedGuid = UUID.fromString(guid);

        Callback<TableColumn<VitrifiedEmbryo, String>, TableCell<VitrifiedEmbryo, String>> comboBoxCellFactory
                = (TableColumn<VitrifiedEmbryo, String> param) -> new ComboBoxEditingCell();
        for (VitrifiedEmbryo vEmb : vEmbList) {
            boolean guidsAreEqual = (UUID.fromString(vEmb.getGuid()).compareTo(requestedGuid) == 0);
            if (guidsAreEqual)//VitrificationMap map = (VitrificationMap) protocol;
            {

                for (TableColumn<VitrifiedEmbryo, ?> n : pane.getColumns()) {
                    try {
                        System.out.println(n.getId() + " - " + n.toString());


                     if (n.getId().equalsIgnoreCase("cryoEmbryologist") || n.getId().equalsIgnoreCase("defrostEmbryologist"))
                    {
                        ((TableColumn<VitrifiedEmbryo, String>) n).setCellValueFactory(cellData -> cellData.getValue().get(n.getId()));
                        ((TableColumn<VitrifiedEmbryo, String>) n).setCellFactory(comboBoxCellFactory);
                        ((TableColumn<VitrifiedEmbryo, String>) n).setOnEditCommit(
                                (TableColumn.CellEditEvent<VitrifiedEmbryo, String> t) -> (t.getTableView().getItems()
                                        .get(t.getTablePosition().getRow()))
                                        .set(n.getId(), new SimpleStringProperty(t.getNewValue())));
                    }
                        else
                     {
                         ((TableColumn<VitrifiedEmbryo, String>) n).setCellValueFactory(cellData -> cellData.getValue().get(n.getId()));
                         ((TableColumn<VitrifiedEmbryo, String>) n).setCellFactory(TextFieldTableCell.forTableColumn());
                         ((TableColumn<VitrifiedEmbryo, String>) n).setOnEditCommit(
                                (TableColumn.CellEditEvent<VitrifiedEmbryo, String> t) -> (t.getTableView().getItems()
                                        .get(t.getTablePosition().getRow()))
                                        .set(n.getId(), new SimpleStringProperty(t.getNewValue())));
                    }   } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class ComboBoxEditingCell extends TableCell<VitrifiedEmbryo, String> {

        private ComboBox<String> comboBox;


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

            setText(getString());
            setGraphic(null);
        }

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (comboBox != null) {
                        comboBox.setValue(getString());
                    }
                    setText(item);
                    setGraphic(comboBox);
                } else {
                    setText(getString());
                    setGraphic(null);
                }
            }
        }

        private void createComboBox() {
            ObservableList<String> embCombo = FXCollections.observableArrayList();


            for (String str: DefaultValues.getObservableList("EMBRYOLOGISTS")){
                embCombo.add(str);
            }

            comboBox = new ComboBox<>(embCombo);
            comboBoxConverter(comboBox);
            comboBox.valueProperty().set(getString());
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

        private void comboBoxConverter(ComboBox<String> comboBox) {
            // Define rendering of the list of values in ComboBox drop down.
            comboBox.setCellFactory((c) -> {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item);
                        }
                    }
                };
            });
        }

        private String getString() {
            return getItem() == null ? new String("") : getItem();
        }
    }


}
//                    if (type.compareTo("TableColumn") == 0)
//                    {
//                        //for (Object tc: ((TableView) n).getColumns()) {
//
//                            ((TableColumn) n).setOnEditCommit( (TableColumn.CellEditEvent<VitrifiedEmbryo, String> t) -> (t.getTableView().getItems()
//                                    .get(t.getTablePosition().getRow())
//                                    .set((TableColumn) tc).getId(), new SimpleStringProperty(t.getNewValue())));
//                            );
//                            defrostDate.setOnEditCommit(
//                                    (TableColumn.CellEditEvent<VitrifiedEmbryo, String> t) -> (t.getTableView().getItems()
//                                            .get(t.getTablePosition().getRow())
//                                            .set(defrostDate.getId(), new SimpleStringProperty(t.getNewValue())));
//                        //}
//                    }





