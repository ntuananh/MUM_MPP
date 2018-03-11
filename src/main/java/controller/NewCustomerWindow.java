package main.java.controller;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.java.database.DBUtils;
import main.java.entity.Customer;

public class NewCustomerWindow extends Stage {
    Stage stage;
    GridPane grid = new GridPane();

    TextField usernameTf;
    Button createBtn;

    public NewCustomerWindow(Stage stage) {
        super();
        this.stage = stage;
        
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label usernameLb = new Label("Username");
        usernameTf = new TextField();
        usernameTf.setPromptText("Enter a username");

        createBtn = new Button("Create");
        grid.add(usernameLb, 0, 0);
        grid.add(usernameTf, 1, 0);
        grid.add(createBtn, 2, 0);
        
        createBtn.setOnAction((evt)->newCustomer());
        
        Scene scene = new Scene(grid, 400, 100);
        setScene(scene);
        
    }
    
    private void newCustomer() {
        String name = usernameTf.getText();
        Customer c = new Customer(name);
        
        DBUtils.createCustomer(c);
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Create a new customer successfully!");

        alert.showAndWait();
        
        CustomerWindow customerWindow = new CustomerWindow(stage);
        customerWindow.show();
        
        this.close();
    }

}
