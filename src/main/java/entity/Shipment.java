package main.java.entity;

public abstract class Shipment {
    private int id;
    private String fromLocation;
    private String toLocation;
    private Location currentLoction;

    public Location getCurrentLoction() {
        return currentLoction;
    }

    public int getId() {
        return id;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setCurrentLoction(String currentLoction) {
//        this.currentLoction = currentLoction;
    }

    public void setInformation(int id, String fromLocation, String toLocation) {
        this.id = id;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
    }

}
