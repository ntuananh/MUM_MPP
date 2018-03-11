package main.java.controller;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.java.database.DBUtils;
import main.java.entity.Location;

public class LocationWindow  extends Stage {
    Stage stage;
    GridPane grid = new GridPane();

    ListView<Location> locationLv;
    
    public LocationWindow(Stage stage) {
        super();
        this.stage = stage;

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        initLocationList();

        grid.add(locationLv, 0, 1);

        Scene scene = new Scene(grid, 500, 300);
        setScene(scene);
    }
    
    private void initLocationList() {
        List<Location> location = DBUtils.getAllLocation();
        ObservableList<Location> locationList = FXCollections.<Location>observableArrayList(location);
        locationLv = new ListView<>(locationList);

        locationLv.setCellFactory(param -> new ListCell<Location>() {
            @Override
            protected void updateItem(Location item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getName());
                }
            }
        });

        locationLv.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    if (mouseEvent.getClickCount() == 2) {
                        Location c = locationLv.getSelectionModel().getSelectedItem();
                        System.out.println(c.getName());
                        ShipmentAtLocationWindow shipWindow = new ShipmentAtLocationWindow(stage, c);
                        shipWindow.show();
                    }
                }
            }
        });
    }
}
