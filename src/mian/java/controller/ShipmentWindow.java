package mian.java.controller;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ShipmentWindow extends Stage {
    Stage primaryStage;
    GridPane grid = new GridPane();

    public ShipmentWindow(Stage stage) {
        this.primaryStage = stage;
        setTitle("Create new shipment");

        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        
        Scene scene = new Scene(grid,300, 250);
//        positionSceneInStage(this, scene);
        scene.setFill(Color.BEIGE);
        setScene(scene);
    }

}
