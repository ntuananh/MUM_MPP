package main.java.database;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.entity.Customer;
import main.java.entity.Envelope;
import main.java.entity.Express;
import main.java.entity.FeeCalculatorFactory;
import main.java.entity.IFeeCalculator;
import main.java.entity.Location;
import main.java.entity.Package;
import main.java.entity.Regular;
import main.java.entity.Shipment;
import main.java.entity.Tracking;

public class Main {


    final static int SERVICE_REGULAR = 1;
    final static int SERVICE_EXPRESS = 2;

    public static List<Customer> allCustomer;
    public static List<Location> allLocation;

    public static void main(String[] args) throws SQLException {

//        allCustomer = DBUtils.getAllCustomer();
//        allLocation = DBUtils.getAllLocation();
//
//        Customer customer1 = allCustomer.get(0);
//        Customer customer2 = allCustomer.get(1);
//
//        Shipment shipment1 = new Package(1, 2, 3, 4);
//        shipment1.setInformation("SP1", allLocation.get(0), allLocation.get(3));
//        shipment1.setService(new Regular());
//        customer1.getShipments().add(shipment1);
//        IFeeCalculator calc1 = FeeCalculatorFactory.getFeeCalculator(shipment1);
//        System.out.println(calc1.calcFee(shipment1));
//        System.out.println(shipment1.toString());
//
//        Shipment shipment2 = new Envelope(2);
//        shipment2.setInformation("SE1", locations.get("locB"), locations.get("locC"));
//        shipment2.setService(new Express());
//        customer2.getShipments().add(shipment2);
//
//        IFeeCalculator calc2 = FeeCalculatorFactory.getFeeCalculator(shipment2);
//        System.out.println(calc2.calcFee(shipment2));
//        System.out.println(shipment2.toString());
//
//        // Tracking tracking = Tracking.getInstance();
//        // tracking.viewAllShipment();
//
//        // try {
//        //// DBUtils.createCustomer(customer1);
//        // System.out.println("Create customer successfully");
//        // } catch (SQLException e) {
//        // // TODO Auto-generated catch block
//        // e.printStackTrace();
//        // }
    }

    public static void prepareData() {
        // customers.put("cus1", new Customer(1, "Customer1"));
        // customers.put("cus2", new Customer(2, "Customer2"));
        // customers.put("cus3", new Customer(3, "Customer3"));
        //
        // locations.put("loc1", new Location(1, "Location1"));
        // locations.put("loc2", new Location(2, "Location2"));
        // locations.put("loc3", new Location(3, "Location3"));

    }

    public static void createShipment(int type) {
//        Shipment s;
//        if(type == SHIPMENT_PACKAGE){
//            s = new Package(1, 2, 3, 4);
//        } else if (type==SHIPMENT_ENVELOPE) {
//            s = new Envelope(3);
//        }
//        
////        s.setShippingInformation(allLocation.get(0), allLocation.get(4), SERVICE_REGULAR);
    }
    
    

}
