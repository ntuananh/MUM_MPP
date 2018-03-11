package main.java.entity;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<Shipment> shipments;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
        shipments = new ArrayList<Shipment>();
    }

    public Customer(String name) {
        this.name = name;
        shipments = new ArrayList<Shipment>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Shipment> getShipments() {
        return shipments;
    }
}
