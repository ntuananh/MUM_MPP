package main.java.entity;

import java.util.HashMap;

public class FeeCalculatorFactory {
    private FeeCalculatorFactory() {
    }

    static HashMap<Class<? extends Shipment>, IFeeCalculator> calc = new HashMap<>();

    static {
        calc.put(Envelope.class, new QuantityCalc());
        calc.put(Package.class, new DimensionCalc());
    }

    public static IFeeCalculator getFeeCalculator(Shipment s) {
        Class<? extends Shipment> cl = s.getClass();
        if (!calc.containsKey(cl)) {
            throw new IllegalArgumentException("No Fee Calculator found for this Shipment");
        }
        return calc.get(cl);
    }
}
