package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Cars;

public class CarsDao {
	private final String GET_CARS_QUERY = "SELECT * FROM cars";
	private final String GET_CAR_BY_ID_QUERY = "SELECT * FROM Cars WHERE id = ?";
	private final String CREATE_NEW_CAR_QUERY = "INSERT INTO Cars(make, model, year, price) VALUES (?, ?, ?, ?)";
	private final String DELETE_CAR_BY_ID_QUERY = "DELETE FROM Cars WHERE id = ?";
			
	private Connection connection;
	
	public CarsDao() {
		connection = DBConnection.getConnection();
	}
	
	public void createNewCar(String model, String make, int year, double price) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_CAR_QUERY);
		ps.setString(1, model);
		ps.setString(2, make);
		ps.setInt(3, year);
		ps.setDouble(4, price);
		ps.executeUpdate();
	}
	
	public Cars getCarById(int id) throws SQLException{
		PreparedStatement ps = connection.prepareStatement(GET_CAR_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Cars car = null;
		while(rs.next()) {
			car = new Cars(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5));
		}
		return car;
	}
	
	public List<Cars> getCars() throws SQLException{
		ResultSet rs = connection.prepareStatement(GET_CARS_QUERY).executeQuery();
		List<Cars> cars = new ArrayList<Cars>();
		
		while(rs.next()) {
			cars.add(new Cars(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5)));
		}
		return cars;
	}
	
	public void deleteCarsById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_CAR_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
		System.out.println("successfully deleted...");
	}	
}
