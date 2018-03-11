package main.java.entity;

public abstract class Shipment {
    private String id;
    private Location fromLocation;
    private Location toLocation;
    private Location currentLocation;
    private double fee;
    private Service service;
    private Customer customer;
    protected IFeeCalculator feeCalculator;
    protected int type;
    protected String trackingNumber;
    Discount discount;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    Shipment() {
    }

    String getId() {
        return id;
    }

    public Location getFromLocation() {
        return fromLocation;
    }

    public Location getToLocation() {
        return toLocation;
    }

    public void setShippingInformation(Location fromLocation, Location toLocation, Service service) {
        // this.id = id;
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

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setToLocation(Location toLocation) {
        this.toLocation = toLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public IFeeCalculator getFeeCalculator() {
        return feeCalculator;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

}
