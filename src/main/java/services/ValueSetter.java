package services;

import controllers.VitrifiedEmbryoService;
import gwtest.DefaultValues;
import gwtest.MasterMapper;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import protocol.maps.Protocol;
import protocol.maps.VitrifiedEmbryo;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by micro on 06.02.2017.
 */
public class ValueSetter {


    public static void setValues(Pane pane, String protocolType, String guid) {

        //String id = "61c7628a-2551-4ce5-b134-efd00289d72a"
        ArrayList<Protocol> listP = MasterMapper.findByGuid(UUID.fromString(guid));

        for (Protocol protocol : listP) {
            if (protocol.getClass().getSimpleName().equalsIgnoreCase(protocolType)) {
                //VitrificationMap map = (VitrificationMap) protocol;


                for (javafx.scene.Node n : pane.getChildren()) {
                    System.out.println(pane.getId() + " - " + n.getId() + " - " + n.getClass().getSimpleName());

                    String type = n.getClass().getSimpleName();
                    if (isPane(type)) {
                        setValues((Pane) n, protocolType, guid);
                    }
                    if (type.compareTo("TextField") == 0)
                        ((TextField) n).setText(protocol.get(n.getId()));

                    if (type.compareTo("CheckBox") == 0) {
                        System.out.println(n.getId() + " " + protocol.get(n.getId()));

                        ((CheckBox) n).setSelected(protocol.get(n.getId()).compareTo("1") == 0);
                    }

                    if (type.compareTo("ComboBox") == 0) {
                        ((ComboBox) n).setItems(DefaultValues.getObsservableListForThisControl(n.getId()));
                        ((ComboBox) n).getSelectionModel().select(protocol.get(n.getId()));
                    }
                    if (type.compareTo("ListView") == 0) {
                        ((ListView) n).setItems(DefaultValues.getObsservableListForThisControl(n.getId())); //.getObservableList("SECTION_COLOR"));
                        ((ListView) n).getSelectionModel().select(protocol.get(n.getId()));
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
                }
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
        ;
        UUID requestedGuid = UUID.fromString(guid);


        for (VitrifiedEmbryo vEmb : vEmbList) {
            boolean guidsAreEqual = (UUID.fromString(vEmb.getGuid()).compareTo(requestedGuid) == 0);
            if (guidsAreEqual)//VitrificationMap map = (VitrificationMap) protocol;
            {

                for (TableColumn<VitrifiedEmbryo, ?> n : pane.getColumns()) {
                    try {
                        System.out.println(n.getId() + " - " + n.toString());
                        ((TableColumn<VitrifiedEmbryo, String>) n).setCellValueFactory(cellData -> cellData.getValue().get(n.getId()));
                        ((TableColumn<VitrifiedEmbryo, String>) n).setCellFactory(TextFieldTableCell.forTableColumn());

                        ((TableColumn<VitrifiedEmbryo, String>) n).setOnEditCommit(
                        (TableColumn.CellEditEvent<VitrifiedEmbryo, String> t) -> ( t.getTableView().getItems()
                                .get(t.getTablePosition().getRow()))
                                .set(n.getId(), new SimpleStringProperty(t.getNewValue())));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
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





