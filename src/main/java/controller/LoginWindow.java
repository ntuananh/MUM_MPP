package main.java.controller;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginWindow extends Stage {
    Stage primaryStage;
    GridPane grid = new GridPane();

    Stage dashboardWindow;

    public LoginWindow(Stage stage) {
		// TODO Auto-generated constructor stub
		
		this.primaryStage = stage;
		setTitle("Sign In");
		
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Label emailLb = new Label("Email");
		TextField emailTf = new TextField();
		Button loginBtn = new Button("Sign In");
		
		loginBtn.setOnAction((evt)->{
		    dashboardWindow = new DashboardWindow(stage);
		    dashboardWindow.show();
		    this.close();
		});
		
		grid.add(emailLb, 0, 0);
		grid.add(emailTf, 1, 0);
		grid.add(loginBtn, 1, 1);
		
		//View Window
		Scene scene = new Scene(grid, 500, 300);
		setScene(scene);
	}
}
