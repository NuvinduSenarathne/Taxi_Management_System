package com.EasyTaxiCTRL.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.EasyTaxiCTRL.model.Employee;

public class EmployeeDao {
	
	//database details...
	private static String jdbcURL = "jdbc:mysql://localhost:3306/easytaxi?useSSL=false";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "root";

	//queries...
	private static final String INSERT_EMPS_SQL = "INSERT INTO employee" + "  (firstname, lastname, address, email, mobile, salary) VALUES " + " (?, ?, ?, ?, ?, ?);";
	private static final String SELECT_EMP_BY_ID = "SELECT empid, firstname, lastname, address, email, mobile, salary FROM employee WHERE empid =?";
	private static final String SELECT_ALL_EMPS = "SELECT * FROM employee";
	private static final String DELETE_EMP_SQL = "DELETE FROM employee WHERE empid = ?;";
	private static final String UPDATE_EMP_SQL = "UPDATE employee SET firstname=?, lastname=?, address=?, email=?, mobile=?, salary=? WHERE empid= ?;";

	public EmployeeDao() {
		
	}

	//queries...
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

	//insert vehicle to employee table...
	public void insertEmployee(Employee employee) throws SQLException {
		System.out.println(INSERT_EMPS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPS_SQL)) {
			preparedStatement.setString(1, employee.getFirstname());
			preparedStatement.setString(2, employee.getLastname());
			preparedStatement.setString(3, employee.getAddress());
			preparedStatement.setString(4, employee.getEmail());
			preparedStatement.setString(5, employee.getMobile());
			preparedStatement.setFloat(6, employee.getSalary());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	//select employee from employee table...
	public  Employee selectEmployee(int empid) {
		Employee employee = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMP_BY_ID);) {
			preparedStatement.setInt(1, empid);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String address = rs.getString("address");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				Float salary = rs.getFloat("salary");
				employee = new Employee(empid, firstname, lastname, address, email, mobile, salary);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return employee;
	}

	//select all employees from  employee table...
	public static List<Employee> selectAllEmployees() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Employee> employees = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int empid = rs.getInt("empid");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String address = rs.getString("address");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				Float salary = rs.getFloat("salary");
				employees.add(new Employee(empid, firstname, lastname, address, email, mobile, salary));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return employees;
	}

	//delete employee from employee table...
	public boolean deleteEmployee(int empid) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_EMP_SQL);) {
			statement.setInt(1, empid);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	//update employee from employee table...
	public boolean updateEmployee(Employee employee) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_EMP_SQL);) {
			
			statement.setString(1, employee.getFirstname());
			statement.setString(2, employee.getLastname());
			statement.setString(3, employee.getAddress());
			statement.setString(4, employee.getEmail());
			statement.setString(5, employee.getMobile());
			statement.setFloat(6, employee.getSalary());
			statement.setInt(7, employee.getEmpid());
			
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
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
