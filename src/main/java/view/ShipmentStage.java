package main.java.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ShipmentStage extends RootStage{

	public ShipmentStage() throws Exception {
		// TODO Auto-generated constructor stub
		Parent root = FXMLLoader.load(getClass().getResource("fxml_shipment.fxml"));
		
		this.setTitle("Delivery System");
		Scene scene = new Scene(root, 500, 300);
		positionSceneInStage(this, scene);
		this.setScene(scene);
	}

}
