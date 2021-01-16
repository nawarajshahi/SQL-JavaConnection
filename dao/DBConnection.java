package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private final static String url = "jdbc:mysql://localhost:3306/lapco_technologies";
	private final static String userName = "root";
	private final static String password = "password";
	private static Connection connection;
	private static DBConnection instance;
	
	private DBConnection(Connection connection) {
		DBConnection.connection = connection;
	}
	
	public static Connection getConnection() {
		if(instance == null) {
			try {
				connection = DriverManager.getConnection(url, userName, password);
				instance = new DBConnection(connection);
				System.out.println("Successfully connected..");
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return DBConnection.connection;
	}

}
