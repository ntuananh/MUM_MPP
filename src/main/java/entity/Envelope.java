package main.java.entity;

public class Envelope extends Shipment {
    private int quantity;

    public Envelope(int quantity) {
        super();
        this.quantity = quantity;
    }
    
    Envelope(){
        
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Shipment infomation");
        // sb.append("\tId: " + this.getId() + ", sent from " +
        // this.getFromLocation().getName() + " to "
        // + this.getToLocation().getName());
        return sb.toString();
    }
}
