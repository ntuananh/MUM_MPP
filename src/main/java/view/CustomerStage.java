package main.java.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class CustomerStage extends RootStage{
	GridPane grid = new GridPane();
	
	public CustomerStage() throws Exception {
		// TODO Auto-generated constructor stub
		Parent root = FXMLLoader.load(getClass().getResource("fxml_customer.fxml"));
		
		this.setTitle("Delivery System");
		Scene scene = new Scene(root, 500, 300);
		positionSceneInStage(this, scene);
		this.setScene(scene);
	}
	
}
