package main.java.entity;
import main.java.entity.Package;
public class DimensionCalc implements IFeeCalculator {

    @Override
    public double calcFee(Shipment shipment) {
        Package pack = (Package) shipment;
        return (pack.getDimension1()*pack.getDimension2()*pack.getDimension3()+pack.getWeight());
    }
}
