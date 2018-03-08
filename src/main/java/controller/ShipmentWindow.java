package main.java.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ShipmentWindow extends Stage {
    Stage primaryStage;
    GridPane grid = new GridPane();

    @FXML ToggleGroup typeTg;
    @FXML ToggleGroup serviceTg;
    
    public ShipmentWindow(Stage stage) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("main/resource/view/shipment.fxml"));
        
        this.primaryStage = stage;
        setTitle("Create new shipment");

        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        
        RadioButton selectedRadioButton = (RadioButton) typeTg.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();
        
        Scene scene = new Scene(grid,300, 250);
//        positionSceneInStage(this, scene);
        scene.setFill(Color.BEIGE);
        setScene(scene);
    }

}
