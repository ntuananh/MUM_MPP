import java.sql.SQLException;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import lesson6.lecture.javafx.secondwindow.SecondWindow;
import main.java.database.DBUtils;
import main.java.entity.Customer;
import mian.java.controller.ShipmentWindow;

public class Main extends Application {

    @FXML
    ListView<Customer> customerLV;
    
    @FXML
    ToggleGroup typeTg;
    
    @FXML
    ToggleGroup serviceTg;
    
    GridPane grid1 = null;
    
    Stage shipmentWindow;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("main/resource/view/shipment.fxml"));
        Parent root = loader.load();
        
        createShipmentWindow(stage);
        shipmentWindow.show();

//        customerLV = (ListView<Customer>) root.lookup("#customerLV");

//        List<Customer> allCustomer = DBUtils.getAllCustomer();
//        ObservableList<Customer> items = FXCollections.observableArrayList(allCustomer);
//        customerLV.setItems(items);
//
//        customerLV.setCellFactory(new Callback<ListView<Customer>, ListCell<Customer>>() {
//
//            @Override
//            public ListCell<Customer> call(ListView<Customer> arg0) {
//                ListCell<Customer> cell = new ListCell<Customer>() {
//
//                    @Override
//                    protected void updateItem(Customer t, boolean bln) {
//                        super.updateItem(t, bln);
//                        if (t != null) {
//                            setText(t.getName());
//                        }
//                    }
//
//                };
//                return cell;
//
//            }
//        });

        stage.setTitle("Delivery Inc.");
        stage.setScene(new Scene(root, 600, 300));
        stage.show();
    }

    private void createShipmentWindow(Stage stage) {
        shipmentWindow = new ShipmentWindow(stage);
//        messageBar.setText("");
    }

}
