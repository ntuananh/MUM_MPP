package main.java.entity;

public abstract class Shipment{
    private String id;
    private Location fromLocation;
    private Location toLocation;
    private Location currentLocation;
    private double fee;
    private Service service;

    Shipment() {
    }

    public String getId() {
        return id;
    }

    public Location getFromLocation() {
        return fromLocation;
    }

    public Location getToLocation() {
        return toLocation;
    }

    public void setShippingInformation(Location fromLocation, Location toLocation, Service s) {
//        this.id = id;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.service = service;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFromLocation(Location fromLocation) {
        this.fromLocation = fromLocation;
    }

    public void setToLocation(Location toLocation) {
        this.toLocation = toLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
     
    
    
    

}
