package main.java.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class DeliveryController {
	CustomerStage customerStage;
	
	@FXML protected void handleSubmitButtonAction(ActionEvent event) throws Exception {
		if(customerStage == null) {
			customerStage = new CustomerStage();
			customerStage.show();
		}
    }
	
	@FXML protected void handleShipmentButtonAction(ActionEvent event) throws Exception{
		ShipmentStage shipmentStage;
		shipmentStage = new ShipmentStage();
		shipmentStage.show();
	}
	
	@FXML protected void handleTrackingButtonAction(ActionEvent event) throws Exception{
		
	}
	
}
