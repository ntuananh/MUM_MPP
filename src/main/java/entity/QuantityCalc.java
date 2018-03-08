package main.java.entity;

public class QuantityCalc implements IFeeCalculator {

    @Override
    public double calcFee(Shipment shipment) {
        Envelope e = (Envelope) shipment;
        return e.getQuantity()*e.getService().getBaseRate();
    }
}
