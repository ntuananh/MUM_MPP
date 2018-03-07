package main.java.database;

import main.java.entity.Customer;
import main.java.entity.Shipment;
import main.java.entity.Package;

public class Main {

    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "Anh");

        Shipment shipment1 = new Package(1, 2, 3, 4);
        customer1.shipments.add(shipment1);
        
        System.out.println(shipment1.feeCalc());
    }

}
