package main.java.entity;

public class Envelope extends Shipment {
    private int quantity;
    

    public Envelope(int quantity) {
        super();
        this.quantity = quantity;
    }


    public int getQuantity() {
        return quantity;
    }
    
}
