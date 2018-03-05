package main.java.entity;

public abstract class Shipment {
    private int id;
    private String fromLocation;
    private String toLocation;
    
//    public  IFeeCalculator feeCal;
//
//    public Shipment(int id, String fromLocation, String toLocation, IFeeCalculator feeCal) {
//        this.id = id;
//        this.fromLocation = fromLocation;
//        this.toLocation = toLocation;
//        this.feeCal = feeCal;
//    }
    protected abstract double getBaseFee();
    public abstract double feeCalc();
    
    

}
