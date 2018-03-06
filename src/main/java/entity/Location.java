package main.java.entity;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private int id;
    private String name;
    private List<Shipment> shipments;

    public Location(int id, String name) {
        this.id = id;
        this.name = name;
        shipments = new ArrayList<>();
    }
    
    public void addShipment(Shipment s) {
        shipments.add(s);
    }
    
    public void removeShipment(Shipment s) {
        shipments.remove(s);
    }

    public List<Shipment> getShipments() {
        return shipments;
    }
}
