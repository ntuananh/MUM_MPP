package main.java.controller;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.java.database.DBUtils;
import main.java.entity.Customer;

public class CustomerWindow extends Stage {
    Stage stage;
    GridPane grid = new GridPane();

    Button newBt;
    ListView<Customer> customerLv;

    public CustomerWindow(Stage stage) {
        super();
        this.stage = stage;

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        newBt = new Button("New Customer");
        newBt.setOnAction((evt) -> {
            NewCustomerWindow newCustomerWindow = new NewCustomerWindow(stage);
            newCustomerWindow.show();
            this.close();
        });

        grid.add(newBt, 0, 0);

        initCustomerList();

        grid.add(customerLv, 0, 1);

        Scene scene = new Scene(grid, 500, 300);
        setScene(scene);
    }

    private void initCustomerList() {
        List<Customer> customers = DBUtils.getAllCustomer();
        ObservableList<Customer> customerList = FXCollections.<Customer>observableArrayList(customers);
        customerLv = new ListView<>(customerList);

        customerLv.setCellFactory(param -> new ListCell<Customer>() {
            @Override
            protected void updateItem(Customer item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getName());
                }
            }
        });

        customerLv.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    if (mouseEvent.getClickCount() == 2) {
                        Customer c = customerLv.getSelectionModel().getSelectedItem();
                        ReportWindow reportWindow = new ReportWindow(stage, c);
                        reportWindow.show();
                    }
                }
            }
        });
    }

}
