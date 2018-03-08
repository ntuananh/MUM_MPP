package main.java.model;

import java.sql.Connection;

import main.java.database.JDBCDriverConnection;

public class BaseModel {
    static Connection conn = JDBCDriverConnection.getInstance();
}
