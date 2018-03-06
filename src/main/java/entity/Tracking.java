package main.java.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Tracking {
    private static Tracking trackingInstance;
    private static Map<String, Location> locManager;

    private Tracking() {
        locManager = new HashMap<String, Location>();
        locManager.put("Loc1", new Location(1, "Loc1"));
        locManager.put("Loc2", new Location(2, "Loc2"));
        locManager.put("Loc3", new Location(3, "Loc3"));
        locManager.put("Loc4", new Location(4, "Loc4"));
    }

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
    
    public void viewAllShipment() {
        System.out.println("List all shipments:");
        for(Entry<String, Location> entry: locManager.entrySet()) {
                System.out.println(entry.getKey());
                for(Shipment s: entry.getValue().getShipments()) {
                    System.out.println("\t"+s.getId());
                }
        }
    }
    

    public void moveShipment(Shipment s, String nextloc) {

        Location currentLoc = s.getCurrentLoction();
        currentLoc.removeShipment(s);

        Location next = locManager.get(nextloc);
        next.addShipment(s);
//        s.setCurrentLoction(next);
    }
}
