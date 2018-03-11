package main.java.entity;

public class PercentDiscount implements Discount {

    private double amount;

    public PercentDiscount(double amount) {
        this.amount = amount;
    }

    @Override
    public double calcDiscount(double initialPrice) {
        return initialPrice * amount / 100;
    }

}
