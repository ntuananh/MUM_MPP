package main.java.controller;

import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import main.java.database.DBUtils;
import main.java.entity.Customer;
import main.java.entity.Location;

public class ShipmentAtLocationWindow extends Stage {
    Stage stage;
    GridPane grid = new GridPane();
    Location location;

    private final TableView<String[]> table = new TableView<>();

    public ShipmentAtLocationWindow(Stage stage, Location c) {
        super();
        this.stage = stage;
        this.location = c;

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        List<String[]> findShipments = DBUtils.findShipments(this.location);
        ObservableList<String[]> data = FXCollections.observableArrayList(findShipments);

        TableColumn<String[], String> typeCol = new TableColumn<String[], String>("Type");
        TableColumn<String[], String> serviceCol = new TableColumn<String[], String>("Service");
        TableColumn<String[], String> fromCol = new TableColumn<String[], String>("From");
        TableColumn<String[], String> toCol = new TableColumn<String[], String>("To");
        TableColumn<String[], String> curCol = new TableColumn<String[], String>("Current");
        TableColumn<String[], String> trackingCol = new TableColumn<String[], String>("Tracking");

        typeCol.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<String[], String> arg0) {
                        return new SimpleStringProperty(arg0.getValue()[0]);
                    }
                });

        serviceCol.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<String[], String> arg0) {
                        return new SimpleStringProperty(arg0.getValue()[1]);
                    }
                });

        fromCol.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<String[], String> arg0) {
                        return new SimpleStringProperty(arg0.getValue()[2]);
                    }
                });
        toCol.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<String[], String> arg0) {
                        return new SimpleStringProperty(arg0.getValue()[3]);
                    }
                });
        curCol.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<String[], String> arg0) {
                        return new SimpleStringProperty(arg0.getValue()[5]);
                    }
                });
        trackingCol.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<String[], String> arg0) {
                        return new SimpleStringProperty(arg0.getValue()[4]);
                    }
                });

        table.getColumns().addAll(typeCol, serviceCol, fromCol, toCol, curCol, trackingCol);
        table.setItems(data);

        table.getSelectionModel().setCellSelectionEnabled(true);
        MenuItem item = new MenuItem("Copy");
        item.setOnAction(evt -> {
            ObservableList<TablePosition> posList = table.getSelectionModel().getSelectedCells();
            int old_r = -1;
            StringBuilder clipboardString = new StringBuilder();
            for (TablePosition p : posList) {
                int r = p.getRow();
                int co = p.getColumn();
                Object cell = table.getColumns().get(co).getCellData(r);
                if (cell == null)
                    cell = "";
                if (old_r == r)
                    clipboardString.append('\t');
                else if (old_r != -1)
                    clipboardString.append('\n');
                clipboardString.append(cell);
                old_r = r;
            }
            final ClipboardContent content = new ClipboardContent();
            content.putString(clipboardString.toString());
            Clipboard.getSystemClipboard().setContent(content);
        });

        ContextMenu menu = new ContextMenu();
        menu.getItems().add(item);
        table.setContextMenu(menu);

        grid.add(table, 0, 0);

        Scene scene = new Scene(grid, 700, 300);
        setScene(scene);
    }

}
