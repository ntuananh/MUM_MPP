import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.java.controller.EnvelopeWindow;
import main.java.controller.PackageWindow;
import main.java.controller.ShipmentWindow;
import main.java.controller.TrackingWindow;
import main.java.entity.Customer;

public class Main extends Application {

	GridPane grid1 = null;

	Stage shipmentWindow;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		shipmentWindow = new EnvelopeWindow(stage);
		shipmentWindow.show();
		
		

		// stage.setTitle("Delivery Inc.");
		// stage.setScene(new Scene(root, 600, 300));
		// stage.show();
	}
}
