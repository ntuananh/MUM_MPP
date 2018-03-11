package main.java.controller;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DashboardWindow extends Stage {
    Stage primaryStage;
    GridPane grid = new GridPane();

    public DashboardWindow(Stage primaryStage) {
        super();
        this.primaryStage = primaryStage;

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Button trackingBtn = new Button("Tracking");
        Button createShipmentBtn = new Button("Create Shipment");
        Button manageShipment = new Button("Mangage Shipment");

        grid.add(trackingBtn, 0, 0);
        grid.add(createShipmentBtn, 0, 1);
        grid.add(manageShipment, 0, 2);

        Scene scene = new Scene(grid, 500, 300);
        setScene(scene);

    }

}
