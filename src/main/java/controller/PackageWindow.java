package main.java.controller;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PackageWindow extends Stage{
	Stage primaryStage;
	GridPane grid = new GridPane();
	
	public PackageWindow(Stage stage) {
		// TODO Auto-generated constructor stub
		this.primaryStage = stage;
		setTitle("Package Properties");
		
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Label widthLb = new Label("Width");
		TextField widthTF = new TextField();
		Label unit1Lb = new Label("cm");
		Label heightLb = new Label("Height");
		TextField heightTF = new TextField();
		Label unit2Lb = new Label("cm");
		Label lengthLb = new Label("Length");
		TextField lengthTF = new TextField();
		Label unit3Lb = new Label("cm");
		Label weigthLb = new Label("Weight");
		TextField weigthTF = new TextField();
		Label uLb = new Label("kg");
		
		Button calFeeBtn = new Button("Done");
		
		grid.add(widthLb, 0, 0);
		grid.add(widthTF, 1, 0);
		grid.add(unit1Lb, 2, 0);
		grid.add(heightLb, 0, 1);
		grid.add(heightTF, 1, 1);
		grid.add(unit2Lb, 2, 1);
		grid.add(lengthLb, 0, 2);
		grid.add(lengthTF, 1, 2);
		grid.add(unit3Lb, 2, 2);
		grid.add(weigthLb, 0, 3);
		grid.add(weigthTF, 1, 3);
		grid.add(uLb, 2, 3);
		grid.add(calFeeBtn, 1, 4);
		
		//View Window
		Scene scene = new Scene(grid, 500, 300);
		setScene(scene);
	}
}
