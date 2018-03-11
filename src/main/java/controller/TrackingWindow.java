package main.java.controller;


import java.util.Map;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.java.database.DBUtils;

public class TrackingWindow extends Stage{
    Stage primaryStage;
    GridPane grid = new GridPane();
    
    TextField trackingTf;
    Label fLocationLb, tLocation, cLocation;
    
    public TrackingWindow(Stage stage) {
        // TODO Auto-generated constructor stub
        this.primaryStage = stage;
        setTitle("Tracking Shipment");

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        trackingTf = new TextField();
        trackingTf.setPromptText("Tracking Number");
        Button findBt = new Button("Find");
        
        
        Label fromLb = new Label("From Location :");
        fLocationLb = new Label();
        Label toLb = new Label("To Location :");
        tLocation = new Label();
        Label currentLb = new Label("Current Location :");
        cLocation = new Label();
        
        grid.add(trackingTf, 0, 0);
        grid.add(findBt, 1, 0);
        
        grid.add(fromLb, 0, 1);
        grid.add(fLocationLb, 1, 1);
        grid.add(toLb, 0, 2);
        grid.add(tLocation, 1, 2);
        grid.add(currentLb, 0, 3);
        grid.add(cLocation, 1, 3);
        
        findBt.setOnAction((evt)->findShipment());
        //View Window
        Scene scene = new Scene(grid, 500, 300);
        setScene(scene);
    }
    
    private void findShipment() {
        String trackingNumber = trackingTf.getText();
        Map<String, String> findShipment = DBUtils.findShipment(trackingNumber);
        fLocationLb.setText(findShipment.get("from_loc"));
        tLocation.setText(findShipment.get("to_loc"));
        cLocation.setText("N/A");
    }
}