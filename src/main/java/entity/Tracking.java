package main.java.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Tracking {
    private static Tracking trackingInstance;
    private List<Location> locations;

    public static Tracking getInstance() {
        if (trackingInstance == null) {
            trackingInstance = new Tracking();
        }
        return trackingInstance;
    }
    
    public void setLocation(Shipment s, String location) {
        // get last location
        
        // move to new location
    }
    
//    public void viewAllShipment() {
//        System.out.println("List all shipments:");
//        for(Entry<String, Location> entry: locManager.entrySet()) {
//                System.out.println(entry.getKey());
//                for(Shipment s: entry.getValue().getShipments()) {
//                    System.out.println("\t"+s.getId());
//                }
//        }
//    }
//    
//
//    public void moveShipment(Shipment s, String nextloc) {
//
//        Location currentLoc = s.getCurrentLoction();
//        currentLoc.removeShipment(s);
//
//        Location next = locManager.get(nextloc);
//        next.addShipment(s);
////        s.setCurrentLoction(next);
//    }
}
