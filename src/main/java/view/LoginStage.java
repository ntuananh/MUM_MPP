package main.java.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginStage extends Application{
	
	public static void main(String[] args) {
		Application.launch(LoginStage.class, args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
				Parent root = FXMLLoader.load(getClass().getResource("fxml_login.fxml"));
				
				stage.setTitle("Delivery System");
		        stage.setScene(new Scene(root, 500, 300));
		        //you can communicate with the components using id's
		        Text target = (Text)root.lookup("#submittarget");
		        target.setFill(Color.FIREBRICK);
		        target.setText("Default text");
		       
		        stage.show();
	}
}
