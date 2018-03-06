package main.java.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.java.entity.Customer;

public class DBUtils {
    static Connection conn = JDBCDriverConnection.getInstance();
    
	public static void createCustomer(Customer customer)
			throws SQLException {
		String sql = "INSERT INTO Customer(name) VALUES(?,?,?,?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, customer.getName());
		pstmt.executeUpdate();
	}
}
