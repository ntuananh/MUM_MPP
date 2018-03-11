package main.java.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.Utils.Const;
import main.java.entity.Customer;
import main.java.entity.Envelope;
import main.java.entity.Location;
import main.java.entity.Package;
import main.java.entity.Service;
import main.java.entity.Shipment;

public class DBUtils {
    static Connection conn = JDBCDriverConnection.getInstance();

    public static List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        String sql = "Select * From Customer";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                customers.add(new Customer(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return customers;
    }

    public static List<Location> getAllLocation() {
        List<Location> locations = new ArrayList<>();
        String sql = "Select * From Location";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                locations.add(new Location(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return locations;
    }

    public static void saveShipement(Shipment s) {
        String sql = "INSERT INTO Shipment(type, service_id, from_loc, to_loc, customer_id, tracking_number) VALUES (?,?, ?, ? , ?, ?)";

        try {
            String trackingNumber = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, s.getType());
            pstmt.setInt(2, s.getService().getId());
            pstmt.setInt(3, s.getFromLocation().getId());
            pstmt.setInt(4, s.getToLocation().getId());
            pstmt.setInt(5, s.getCustomer().getId());
            pstmt.setString(6, trackingNumber);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Map<String, String> findShipment(String trackingNumber) {
        String sql = "SELECT type, l1.name from_loc, l2.name to_loc from Shipment s join Location l1 on s.from_loc = l1.id "
                + "join Location l2 on s.to_loc = l2.id " + "where tracking_number = '" + trackingNumber + "'";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            Map<String, String> map = new HashMap<>();
            while (rs.next()) {
                map.put("from_loc", rs.getString(2));
                map.put("to_loc", rs.getString(3));
            }
            return map;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static void createCustomer(Customer c) {
        String sql = "INSERT INTO Customer(name) VALUES (?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, c.getName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static List<String[]> findShipments(Customer customer) {
        String sql = "SELECT type, sv.id service_id, sv.name service_name, l1.name from_loc, l2.name to_loc, tracking_number from Shipment s "
                + "join Location l1 on s.from_loc = l1.id " + "join Location l2 on s.to_loc = l2.id "
                + "join Service sv on s.service_id = sv.id " + "where customer_id = '" + customer.getId() + "'";

        try {
            List<String[]> list = new ArrayList<>();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            Map<String, String> map = new HashMap<>();
            while (rs.next()) {
                String serviceName=  "";
            
                if(rs.getInt(1) == 1) {
                    serviceName = "Envelop";
                } else if(rs.getInt(1) == 2) {
                    serviceName = "Package";
                }
                list.add(new String[] {serviceName, rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
            }
            return list;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<String[]> findShipments(Location location) {
        String sql = "SELECT type, sv.id service_id, sv.name service_name, l1.name from_loc, l2.name to_loc, tracking_number from Shipment s "
                + "join Location l1 on s.from_loc = l1.id " + "join Location l2 on s.to_loc = l2.id "
                + "join Service sv on s.service_id = sv.id " + "where s.current_loc = '" + location.getId() + "'";

        try {
            List<String[]> list = new ArrayList<>();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            Map<String, String> map = new HashMap<>();
            while (rs.next()) {
                String serviceName=  "";
            
                if(rs.getInt(1) == 1) {
                    serviceName = "Envelop";
                } else if(rs.getInt(1) == 2) {
                    serviceName = "Package";
                }
                list.add(new String[] {serviceName, rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
            }
            return list;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
