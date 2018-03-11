package main.java.entity;

import main.java.entity.Package;

public class DimensionCalc implements IFeeCalculator {

    @Override
    public double calcFee(Shipment shipment, Discount d) {
        Package pack = (Package) shipment;
        double price = (pack.getDimension1() * pack.getDimension2() * pack.getDimension3() + pack.getWeight())
                * shipment.getService().getBaseRate();
        double discountAmount = d.calcDiscount(price);
        return price - discountAmount;
    }
}
