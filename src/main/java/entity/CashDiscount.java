package main.java.entity;

public class CashDiscount implements Discount {
    
    private double amount; 
    public CashDiscount(double amount) {
        this.amount = amount;
    }
    @Override
    public double calcDiscount(double price) {
        return amount;
    }
}
