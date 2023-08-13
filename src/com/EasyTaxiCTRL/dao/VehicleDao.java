package com.EasyTaxiCTRL.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.EasyTaxiCTRL.model.Vehicle;



public class VehicleDao {
	
	//database details...
	private static String jdbcURL = "jdbc:mysql://localhost:3306/easytaxi?useSSL=false";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "root";

	//queries...
	private static final String INSERT_VEHICLE_SQL = "INSERT INTO vehicle" + "  (vehiclename, regno, manufactureyear, district, vehicletype, vehiclecondition, passengers, imgURL) VALUES " + " (?, ?, ?, ?, ?, ?,?,?);";
	private static final String SELECT_ALL_VEHICLES = "SELECT * FROM vehicle";
	private static final String DELETE_VEHICLE_SQL = "DELETE FROM vehicle WHERE vehicleid = ?;";

	public VehicleDao() {
		
	}

	//get connection...
	protected static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	//insert vehicle to vehicle table...
	public void insertVehicle(Vehicle vehicle) throws SQLException {
		System.out.println(INSERT_VEHICLE_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VEHICLE_SQL)) {
			preparedStatement.setString(1, vehicle.getVehiclename());
			preparedStatement.setString(2, vehicle.getRegno());
			preparedStatement.setInt(3, vehicle.getManufactureyear());
			preparedStatement.setString(4, vehicle.getDistrict());
			preparedStatement.setString(5, vehicle.getVehicletype());
			preparedStatement.setString(6, vehicle.getVehiclecondition());
			preparedStatement.setInt(7, vehicle.getPassengers());
			preparedStatement.setString(8, vehicle.getImgURL());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	//select all vehicles from  vehicle table...
	public static List<Vehicle> selectAllVehicles() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Vehicle> vehicles = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_VEHICLES);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int vehicleid = rs.getInt("vehicleid");
				String vehiclename = rs.getString("vehiclename");
				String regno = rs.getString("regno");
				int manufactureyear = rs.getInt("manufactureyear");
				String district = rs.getString("district");
				String vehicletype = rs.getString("vehicletype");
				String vehiclecondition = rs.getString("vehiclecondition");
				int passengers = rs.getInt("passengers");
				String imgURL = rs.getString("imgURL");
				vehicles.add(new Vehicle(vehicleid, vehiclename, regno, manufactureyear, district, vehicletype, vehiclecondition, passengers, imgURL));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return vehicles;
	}

	//delete vehicle from vehicle table...
	public boolean deleteVehicle(int vehicleid) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_VEHICLE_SQL);) {
			statement.setInt(1, vehicleid);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	private static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
