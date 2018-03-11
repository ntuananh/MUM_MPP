package main.java.controller;

import java.util.List;
import java.util.Map;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import main.java.database.DBUtils;
import main.java.entity.Customer;

public class ReportWindow extends Stage {
    Stage stage;
    GridPane grid = new GridPane();
    Customer customer;

    private final TableView<String[]> table = new TableView<>();

    public ReportWindow(Stage stage, Customer c) {
        super();
        this.stage = stage;
        this.customer = c;

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        List<String[]> findShipments = DBUtils.findShipments(this.customer);
        ObservableList<String[]> data = FXCollections.observableArrayList(findShipments);

        TableColumn<String[], String> typeCol = new TableColumn<String[], String>("Type");
        TableColumn<String[], String> serviceCol = new TableColumn<String[], String>("Service");
        TableColumn<String[], String> fromCol = new TableColumn<String[], String>("From");
        TableColumn<String[], String> toCol = new TableColumn<String[], String>("To");
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
        trackingCol.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(CellDataFeatures<String[], String> arg0) {
                        return new SimpleStringProperty(arg0.getValue()[4]);
                    }
                });

        table.getColumns().addAll(typeCol, serviceCol, fromCol, toCol, trackingCol);
        table.setItems(data);

        grid.add(table, 0, 0);

        Scene scene = new Scene(grid, 700, 300);
        setScene(scene);

    }

}
