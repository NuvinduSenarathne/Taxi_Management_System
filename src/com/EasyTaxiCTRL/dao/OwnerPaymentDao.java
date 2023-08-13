package com.EasyTaxiCTRL.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.EasyTaxiCTRL.model.OwnerPayment;

public class OwnerPaymentDao {
	private static String jdbcURL = "jdbc:mysql://localhost:3306/easytaxi?useSSL=false";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "root";

	private static final String INSERT_OWN_PAY_SQL = "INSERT INTO ownerpayment" + "  (vehiclename, ownerid, chargePerKM, noOfKM, date) VALUES "
			+ " (?, ?, ?, ?, ?);";
	private static final String SELECT_ALL_OWN_PAYS = "select * from ownerpayment";
	
	public OwnerPaymentDao() {
		
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
	
	public void insertOwnerPayment(OwnerPayment ownerpayment) throws SQLException {
		System.out.println(INSERT_OWN_PAY_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_OWN_PAY_SQL)) {
			preparedStatement.setString(1, ownerpayment.getVehiclename());
			preparedStatement.setInt(2, ownerpayment.getOwnerid());
			preparedStatement.setFloat(3, ownerpayment.getChargePerKM());
			preparedStatement.setInt(4, ownerpayment.getNoOfKM());
			preparedStatement.setString(5, ownerpayment.getDate());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public static List<OwnerPayment> selectAllOwnerPayments() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<OwnerPayment> ownerpayments = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_OWN_PAYS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String vehiclename = rs.getString("vehiclename");
				int ownerid = rs.getInt("ownerid");
				String date = rs.getString("date");
				Float chargePerKM = rs.getFloat("chargePerKM");
				Integer noOfKM = rs.getInt("noOfKM");
				Float payment = rs.getFloat("payment");
				ownerpayments.add(new OwnerPayment(vehiclename, ownerid, date, chargePerKM, noOfKM, payment));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return ownerpayments;
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