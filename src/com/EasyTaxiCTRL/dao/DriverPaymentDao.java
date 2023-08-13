package com.EasyTaxiCTRL.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.EasyTaxiCTRL.model.DriverPayment;

public class DriverPaymentDao {
	private static String jdbcURL = "jdbc:mysql://localhost:3306/easytaxi?useSSL=false";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "root";

	private static final String INSERT_DRV_PAY_SQL = "INSERT INTO driverpayment" + "  (vehiclename, driverid, date, payment) VALUES "
			+ " (?, ?, ?, ?);";
	private static final String SELECT_DRIVERPAYMENT_BY_ID = "SELECT empid, firstname, lastname, address, email, mobile, salary FROM employee WHERE empid =?";
	private static final String SELECT_ALL_DRV_PAYS = "select * from driverpayment";
	
	public DriverPaymentDao() {
		
	}
	
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
	
	public void insertDriverPayment(DriverPayment driverpayment) throws SQLException {
		System.out.println(INSERT_DRV_PAY_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DRV_PAY_SQL)) {
			preparedStatement.setString(1, driverpayment.getVehiclename());
			preparedStatement.setInt(2, driverpayment.getDriverid());
			preparedStatement.setString(3, driverpayment.getDate());
			preparedStatement.setFloat(4, driverpayment.getPayment());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public  DriverPayment selectDriverPayment(int userid) {
		DriverPayment driverpayment = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DRIVERPAYMENT_BY_ID);) {
			preparedStatement.setInt(1, userid);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String vehiclename = rs.getString("vehiclename");
				String date = rs.getString("date");
				Float payment = rs.getFloat("payment");
				driverpayment = new DriverPayment( vehiclename, userid, date, payment);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return driverpayment;
	}
	
	public static List<DriverPayment> selectAllDriverPayments() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<DriverPayment> driverpayments = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DRV_PAYS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String vehiclename = rs.getString("vehiclename");
				int driverid = rs.getInt("driverid");
				String date = rs.getString("date");
				Float payment = rs.getFloat("payment");
				driverpayments.add(new DriverPayment(vehiclename, driverid, date, payment));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return driverpayments;
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