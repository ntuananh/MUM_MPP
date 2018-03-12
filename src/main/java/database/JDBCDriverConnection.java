package main.java.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDriverConnection {
    
    private static Connection connection;
    
    private JDBCDriverConnection() {}
    
    public static Connection getInstance() {
        if(connection == null) {
            connection = getSQLiteConnection(); 
        }
        return connection;
    }
    
	public static Connection getSQLiteConnection() {
		String url = "jdbc:sqlite:src/main/resource/db/delivery.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public static void closeConnection(Connection con) {
	    try {
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
