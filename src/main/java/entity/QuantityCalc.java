package main.java.entity;

public class QuantityCalc implements IFeeCalculator {

    @Override
    public double calcFee(Shipment shipment, Discount d) {
        Envelope e = (Envelope) shipment;
        double price = e.getQuantity() * shipment.getService().getBaseRate();
        double discountAmount = d.calcDiscount(price);
        return price-discountAmount;
    }
}
