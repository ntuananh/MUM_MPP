import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.java.controller.DashboardWindow;
import main.java.controller.ShipmentWindow;
import main.java.controller.TrackingWindow;
import main.java.entity.Shipment;

public class Main extends Application {

	GridPane grid1 = null;

	Stage loginWindow;

	Stage shipmentWindow;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

	    loginWindow = new DashboardWindow(stage);
	    loginWindow.show();
	}
}
