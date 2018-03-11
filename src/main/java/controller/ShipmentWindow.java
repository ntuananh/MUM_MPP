package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import main.java.Utils.Const;
import main.java.database.DBUtils;
import main.java.entity.Customer;
import main.java.entity.Envelope;
import main.java.entity.Express;
import main.java.entity.IFeeCalculator;
import main.java.entity.Location;
import main.java.entity.Package;
import main.java.entity.Regular;
import main.java.entity.Service;
import main.java.entity.Shipment;

public class ShipmentWindow extends Stage {
    Stage primaryStage;
    GridPane grid = new GridPane();
    ToggleGroup typeTg;
    ToggleGroup serviceTg;

    ComboBox<Location> fromLocCb;
    ComboBox<Location> toLocCb;
    ComboBox<Customer> customerCb;

    TextField quantityTf, dim1Tf, dim2Tf, dim3Tf, weightTf;

    Label feeLb;

    Shipment shipment;

    public ShipmentWindow(Stage stage) {

        this.primaryStage = stage;
        setTitle("Create new shipment");

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Shipment type == R0
        VBox typeVB = new VBox(3);

        HBox evelopeHb = new HBox(5);

        HBox packageHb = new HBox(3);
        HBox packageHb2 = new HBox(3);
        typeTg = new ToggleGroup();
        Label typeLb = new Label("Type");
        RadioButton envelopeRb = new RadioButton("Envelope");
        envelopeRb.setToggleGroup(typeTg);
        RadioButton packageRb = new RadioButton("Package");
        packageRb.setToggleGroup(typeTg);

        quantityTf = new TextField();
        quantityTf.setPromptText("Quantity");

        dim1Tf = new TextField();
        dim1Tf.setPromptText("Dimension 1");
        // dim1Tf.setPrefWidth(100);

        dim2Tf = new TextField();
        dim2Tf.setPromptText("Dimension 2");
        // dim1Tf.setPrefWidth(100);

        dim3Tf = new TextField();
        dim3Tf.setPromptText("Dimension 3");
        // dim1Tf.setPrefWidth(100);

        weightTf = new TextField();
        weightTf.setPromptText("Weight");
        // dim1Tf.setPrefWidth(100);

        Label mockLb = new Label();
        mockLb.setPrefWidth(66);

        evelopeHb.getChildren().addAll(envelopeRb, quantityTf);
        packageHb.getChildren().addAll(packageRb, dim1Tf, dim2Tf);
        packageHb2.getChildren().addAll(mockLb, dim3Tf, weightTf);
        typeVB.getChildren().addAll(evelopeHb, packageHb, packageHb2);

        grid.add(typeVB, 0, 0);
        GridPane.setColumnSpan(typeVB, 4);

        // Service Type
        serviceTg = new ToggleGroup();
        Label service = new Label("Service");
        RadioButton regularRb = new RadioButton("Regular");
        regularRb.setToggleGroup(serviceTg);
        RadioButton expressRb = new RadioButton("Express");
        expressRb.setToggleGroup(serviceTg);

        grid.add(service, 0, 1);
        grid.add(regularRb, 1, 1);
        grid.add(expressRb, 2, 1);

        // From location
        Label fromLb = new Label("From");
        ObservableList<Location> locations = FXCollections.observableArrayList(DBUtils.getAllLocation());
        fromLocCb = new ComboBox<>(locations);
        fromLocCb.setCellFactory(new Callback<ListView<Location>, ListCell<Location>>() {

            @Override
            public ListCell<Location> call(ListView<Location> arg0) {
                final ListCell<Location> cell = new ListCell<Location>() {
                    @Override
                    public void updateItem(Location item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.getName());
                        }
                    }
                };
                return cell;
            }
        });

        fromLocCb.setConverter(new StringConverter<Location>() {

            @Override
            public String toString(Location arg0) {
                return arg0.getName();
            }

            @Override
            public Location fromString(String arg0) {
                return null;
            }
        });

        // fromLocCb.valueProperty().addListener((option, oldVal, newVal) -> {
        // fromLocCb.setValue(newVal);
        // });

        grid.add(fromLb, 0, 2);
        grid.add(fromLocCb, 1, 2);

        // To location
        Label toLb = new Label("To");
        // ObservableList<Location> locations =
        // FXCollections.observableArrayList(DBUtils.getAllLocation());
        toLocCb = new ComboBox<>(locations);
        toLocCb.setCellFactory(new Callback<ListView<Location>, ListCell<Location>>() {

            @Override
            public ListCell<Location> call(ListView<Location> arg0) {
                final ListCell<Location> cell = new ListCell<Location>() {
                    @Override
                    public void updateItem(Location item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.getName());
                        }
                    }
                };
                return cell;
            }
        });

        toLocCb.setConverter(new StringConverter<Location>() {

            @Override
            public String toString(Location arg0) {
                return arg0.getName();
            }

            @Override
            public Location fromString(String arg0) {
                return null;
            }
        });
        grid.add(toLb, 0, 3);
        grid.add(toLocCb, 1, 3);

        // Customer
        Label customerLb = new Label("Customer");
        ObservableList<Customer> customers = FXCollections.observableArrayList(DBUtils.getAllCustomer());
        customerCb = new ComboBox<>(customers);
        customerCb.setCellFactory(new Callback<ListView<Customer>, ListCell<Customer>>() {

            @Override
            public ListCell<Customer> call(ListView<Customer> arg0) {
                final ListCell<Customer> cell = new ListCell<Customer>() {
                    @Override
                    public void updateItem(Customer item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.getName());
                        }
                    }
                };
                return cell;
            }
        });

        customerCb.setConverter(new StringConverter<Customer>() {

            @Override
            public String toString(Customer arg0) {
                return arg0.getName();
            }

            @Override
            public Customer fromString(String arg0) {
                return null;
            }
        });
        grid.add(customerLb, 0, 5);
        grid.add(customerCb, 1, 5);

        // Discount
        Label discountLb = new Label("Discount");
        ToggleGroup discountTg = new ToggleGroup();
        RadioButton cashRb = new RadioButton("Cash");
        cashRb.setToggleGroup(discountTg);
        RadioButton percentRb = new RadioButton("Percent");
        percentRb.setToggleGroup(discountTg);
        TextField discountValTf = new TextField();
        discountValTf.setPromptText("Discount value");
        grid.add(discountLb, 0, 6);
        grid.add(cashRb, 1, 6);
        grid.add(percentRb, 2, 6);
        grid.add(discountValTf, 3, 6);

        // Fee Button
        Button calFeeBtn = new Button("Calculate fee");
        feeLb = new Label();
        calFeeBtn.setOnAction(e -> {
            feeLb.setText("Calculating...");
        });
        calFeeBtn.setOnAction((event) -> calcFee());

        grid.add(calFeeBtn, 0, 7);
        grid.add(feeLb, 1, 7);

        // Ship Button
        Button shipBtn = new Button("OK! Ship it");
        shipBtn.setOnAction(e -> {
            DBUtils.saveShipement(shipment);
            hide();
        });
        grid.add(shipBtn, 0, 8);

        Scene scene = new Scene(grid, 600, 350);
        setScene(scene);
    }

    private void calcFee() {
        RadioButton type = (RadioButton) typeTg.getSelectedToggle();
        System.out.println(type.getText());
        shipment = null;
        if (type.getText().equalsIgnoreCase("envelope")) {
            int quantity = Integer.parseInt(quantityTf.getText());
            shipment = new Envelope(quantity);
            shipment.setType(Const.SHIPMENT_ENVELOPE);
        } else if (type.getText().equalsIgnoreCase("package")) {
            int dim1 = Integer.parseInt(dim1Tf.getText());
            int dim2 = Integer.parseInt(dim2Tf.getText());
            int dim3 = Integer.parseInt(dim3Tf.getText());
            int weight = Integer.parseInt(weightTf.getText());

            shipment = new Package(dim1, dim2, dim3, weight);
            shipment.setType(Const.SHIPMENT_PACKAGE);
        }

        Location fromLoc = fromLocCb.getValue();
        Location toLoc = toLocCb.getValue();
        RadioButton serviceRb = (RadioButton) serviceTg.getSelectedToggle();

        Service service = null;
        if (serviceRb.getText().equalsIgnoreCase("regular")) {
            service = new Regular();
        } else {
            service = new Express();
        }

        Customer customer = customerCb.getValue();

        shipment.setShippingInformation(fromLoc, toLoc, service);
        shipment.setCurrentLocation(fromLoc);
        shipment.setCustomer(customer);
        customer.getShipments().add(shipment);
        IFeeCalculator feecal = shipment.getFeeCalculator();
        double fee = feecal.calcFee(shipment);
        feeLb.setText("$" + String.valueOf(fee));

    }

}
