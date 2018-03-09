package main.java.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import main.java.database.DBUtils;
import main.java.entity.Customer;
import main.java.entity.Location;

public class ShipmentWindow extends Stage {
	Stage primaryStage;
	GridPane grid = new GridPane();

	public ShipmentWindow(Stage stage) {

		this.primaryStage = stage;
		setTitle("Create new shipment");

		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		// Shipment type
		ToggleGroup typeTg = new ToggleGroup();
		Label typeLb = new Label("Type");
		RadioButton envelopeRb = new RadioButton("Envelope");
		envelopeRb.setToggleGroup(typeTg);
		RadioButton packageRb = new RadioButton("Package");
		packageRb.setToggleGroup(typeTg);

		Button propertyBtn = new Button("Set Property");

		grid.add(typeLb, 0, 0);
		grid.add(envelopeRb, 1, 0);
		grid.add(packageRb, 2, 0);
		grid.add(propertyBtn, 3, 0);

		// Service Type
		ToggleGroup serviceTg = new ToggleGroup();
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
		ComboBox<Location> fromLocCb = new ComboBox<>(locations);
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
		grid.add(fromLb, 0, 2);
		grid.add(fromLocCb, 1, 2);

		// To location
		Label toLb = new Label("To");
		// ObservableList<Location> locations =
		// FXCollections.observableArrayList(DBUtils.getAllLocation());
		ComboBox<Location> toLocCb = new ComboBox<>(locations);
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
		grid.add(toLb, 0, 3);
		grid.add(toLocCb, 1, 3);

		// Customer
		Label customerLb = new Label("Customer");
		ObservableList<Customer> customers = FXCollections.observableArrayList(DBUtils.getAllCustomer());
		ComboBox<Customer> customerCb = new ComboBox<>(customers);
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
		Label feeLb = new Label();
		calFeeBtn.setOnAction(e -> {
			feeLb.setText("Calculating...");
		});
		grid.add(calFeeBtn, 0, 7);
		grid.add(feeLb, 1, 7);

		Button shipBtn = new Button("OK! Ship it");
		shipBtn.setOnAction(e -> {
			hide();
		});
		grid.add(shipBtn, 0, 8);

		Scene scene = new Scene(grid, 500, 300);
		setScene(scene);
	}

}
