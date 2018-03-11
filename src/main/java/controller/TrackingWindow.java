package main.java.controller;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TrackingWindow extends Stage{
	Stage primaryStage;
	GridPane grid = new GridPane();
	
	public TrackingWindow(Stage stage) {
		// TODO Auto-generated constructor stub
		this.primaryStage = stage;
		setTitle("Tracking Update");

		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Label fromLb = new Label("From Location :");
		Label fLocationLb = new Label("Maharishi University of Management");
		Label toLb = new Label("To Location :");
		Label tLocation = new Label("HoChiMinh Vietnam");
		Label currentLb = new Label("Current Location :");
		Label cLocation = new Label("Tokyo - Japan");
		
		grid.add(fromLb, 0, 0);
		grid.add(fLocationLb, 1, 0);
		grid.add(toLb, 0, 1);
		grid.add(tLocation, 1, 1);
		grid.add(currentLb, 0, 2);
		grid.add(cLocation, 1, 2);
		
		
		//View Window
		Scene scene = new Scene(grid, 500, 300);
		setScene(scene);
	}
}
