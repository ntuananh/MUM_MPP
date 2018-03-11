package main.java.entity;

public class Service {
    private  int id;
    private String name;
    private double baseRate;
    
    public Service(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseRate() {
        return this.baseRate;
    }

    public void setBaseRate(double baseRate) {
        this.baseRate = baseRate;
    }
    
    
}
