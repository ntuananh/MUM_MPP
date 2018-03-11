package main.java.controller;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginWindow extends Stage{
	Stage primaryStage;
	GridPane grid = new GridPane();
	
	public LoginWindow(Stage stage) {
		// TODO Auto-generated constructor stub
		
		this.primaryStage = stage;
		setTitle("Sign In");
		
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Label quantityLb = new Label("Email");
		TextField quantityTF = new TextField();
		Button calFeeBtn = new Button("Sign In");
		
		grid.add(quantityLb, 0, 0);
		grid.add(quantityTF, 1, 0);
		grid.add(calFeeBtn, 1, 1);
		
		//View Window
		Scene scene = new Scene(grid, 500, 300);
		setScene(scene);
	}
}
