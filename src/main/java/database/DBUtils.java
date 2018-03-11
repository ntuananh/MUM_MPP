package main.java.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.java.entity.Customer;
import main.java.entity.Location;
import main.java.entity.Package;
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
        // String sql = "INSERT INTO Shipment(type, service, from, to, customer) VALUES
        // (?,?, ?, ? , ?)";
        //
        // if(s.getClass() == Package.class)
        // PreparedStatement pstmt = conn.prepareStatement(sql);
        // pstmt.setInt(1, s.get().getId());
        // pstmt.setDouble(2, capacity);
        // pstmt.executeUpdate();
	 }
}
