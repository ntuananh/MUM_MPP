package main.java.database;
import java.sql.Connection;
import java.sql.SQLException;

import main.java.entity.Customer;

public class Main {

    public static void main(String[] args) {
        Customer customer1 = new Customer(1, "Anh");
//
//        Shipment shipment1 = new Package(1, 2, 3, 4);
//        shipment1.setCurrentLoction("LocA");
//        customer1.shipments.add(shipment1);
//        
//        IFeeCalculator calc1 = FeeCalculatorFactory.getFeeCalculator(shipment1);
//        
//        Shipment shipment2 = new Envelope(2);
//        IFeeCalculator calc2 = FeeCalculatorFactory.getFeeCalculator(shipment2);
//        customer1.shipments.add(shipment2);
//        
//        System.out.println(calc1.calcFee(shipment1));
//        System.out.println(calc2.calcFee(shipment2));
//        
//        Tracking tracking = Tracking.getInstance();
//        tracking.viewAllShipment();
        Connection conn = JDBCDriverConnection.getInstance();
        
        try {
            DBUtils.createCustomer(customer1);
            System.out.println("Create customer successfully");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
