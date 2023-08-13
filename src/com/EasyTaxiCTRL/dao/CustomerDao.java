package com.EasyTaxiCTRL.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.EasyTaxiCTRL.model.Customer;
import com.EasyTaxiCTRL.model.Employee;

public class CustomerDao {
	
	//database details...
	private static String jdbcURL = "jdbc:mysql://localhost:3306/easytaxi?useSSL=false";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "root";
	
	//queries
	private static final String INSERT_CUSTOMERS_SQL = "INSERT INTO customer" + "  (firstname, lastname, email, mobile, nic) VALUES " + " (?, ?, ?, ?, ?);";
	private static final String SELECT_ALL_CUSTOMERS = "SELECT * FROM customer";
	
	public CustomerDao() {
		
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
	
	//insert customer to customer table...
	public void insertCustomer(Customer customer) throws SQLException {
		System.out.println(INSERT_CUSTOMERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMERS_SQL)) {
			preparedStatement.setString(1, customer.getFirstname());
			preparedStatement.setString(2, customer.getLastname());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setString(4, customer.getMobile());
			preparedStatement.setString(5, customer.getNic());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	//select all customers from customer table...
	public static List<Customer> selectAllCustomers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Customer> customers = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int userid = rs.getInt("customerid");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				String nic = rs.getString("nic");
				customers.add(new Customer(userid, firstname, lastname, email, mobile, nic));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return customers;
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