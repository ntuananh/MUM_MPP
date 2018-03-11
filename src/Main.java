import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.java.controller.DashboardWindow;
import main.java.controller.LoginWindow;

public class Main extends Application {

	GridPane grid1 = null;

	Stage loginWindow;

	Stage shipmentWindow;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

	    loginWindow = new LoginWindow(stage);
	    loginWindow.show();

		// stage.setTitle("Delivery Inc.");
		// stage.setScene(new Scene(root, 600, 300));
		// stage.show();
	}
}
