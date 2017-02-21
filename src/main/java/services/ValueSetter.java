package services;

import controllers.VitrifiedEmbryoService;
import etv.EditCell;
import gwtest.DefaultValues;
import gwtest.MasterMapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import protocol.maps.Protocol;
import protocol.maps.VitrifiedEmbryo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class ValueSetter {

public ValueSetter(){

}
    public  void setValues(Pane pane, String protocolType, String guid) {
      //  System.out.println("GUID=" + guid);

       // String guid = "61c7628a-2551-4ce5-b134-efd00289d72a"
        ArrayList<Protocol> listP = MasterMapper.findByGuid(UUID.fromString(guid));

        for (Protocol protocol : listP) {

            if (protocol.getClass().getSimpleName().equalsIgnoreCase(protocolType)) {

                for (javafx.scene.Node n : pane.getChildren()) {
                    String value = (protocol.get(n.getId()) == null) ? "" :  protocol.get(n.getId());
                    //System.out.println(pane.getId() + " - " + n.getId() + " - " + n.getClass().getSimpleName());

                    String type = n.getClass().getSimpleName();
                    if (n instanceof Pane) {
                        setValues((Pane) n, protocolType, guid);
                    }
                    if (type.compareTo("TextField") == 0)
                        ((TextField) n).setText(value);

                    if (type.compareTo("CheckBox") == 0) {
                    //    System.out.println(n.getId() + " " + value);

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

    public  void  mapInput(Pane pane, String rowObjectType, HashMap<String, String> inputMap) {

        for (javafx.scene.Node n : pane.getChildren()) {
            String className = n.getClass().getSimpleName();

            if (n instanceof Pane)
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



    public  void setValues(TableView<VitrifiedEmbryo> pane, String protocolType, String guid) {

        //String id = "61c7628a-2551-4ce5-b134-efd00289d72a"
        ObservableList<VitrifiedEmbryo> vEmbList = new VitrifiedEmbryoService().getVitrifiedEmbryosList();

        UUID requestedGuid = UUID.fromString(guid);

        Callback<TableColumn<VitrifiedEmbryo, String>, TableCell<VitrifiedEmbryo, String>> comboBoxCellFactory
                = (TableColumn<VitrifiedEmbryo, String> param) -> new ComboBoxEditingCell();


        Callback<TableColumn<VitrifiedEmbryo, String>, TableCell<VitrifiedEmbryo, String>> cellFactory
                = (TableColumn<VitrifiedEmbryo, String> param) -> new EditingCell();

        for (VitrifiedEmbryo vEmb : vEmbList) {
            boolean guidsAreEqual = (UUID.fromString(vEmb.getGuid()).compareTo(requestedGuid) == 0);
            if (guidsAreEqual)
            {

                for (TableColumn<VitrifiedEmbryo, ?> n : pane.getColumns()) {
                    try {
                       // System.out.println(n.getId() + " - " + n.toString());


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
                         ((TableColumn<VitrifiedEmbryo, String>) n).setCellFactory(col -> EditCell.createStringEditCell());
//                         ((TableColumn<VitrifiedEmbryo, String>) n).setOnEditCommit(
//                                (TableColumn.CellEditEvent<VitrifiedEmbryo, String> t) -> (t.getTableView().getItems()
//                                        .get(t.getTablePosition().getRow()))
//                                        .set(n.getId(), new SimpleStringProperty(t.getNewValue())));
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
               // System.out.println("Committed: " + comboBox.getSelectionModel().getSelectedItem());
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

    class EditingCell_focus extends TableCell<VitrifiedEmbryo, String> {

        private TextField textField;

        public EditingCell_focus() {
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
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
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
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()* 2);
            textField.focusedProperty().addListener(new ChangeListener<Boolean>(){
                @Override
                public void changed(ObservableValue<? extends Boolean> arg0,
                                    Boolean arg1, Boolean arg2) {
                    if (!arg2) {
                        commitEdit(textField.getText());
                    }
                }
            });
        }

        private String getString() {
            return getItem() == null ? "" : getItem().toString();
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





