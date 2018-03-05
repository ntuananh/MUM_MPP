package main.java.entity;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    public List<Shipment> shipments;
    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
        shipments = new ArrayList<Shipment>();
    }

}
