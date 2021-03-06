package com.address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import org.junit.Test;

import com.mysql.cj.jdbc.Driver;

public class AddressBookJDBC {

	private static final String url = "jdbc:mysql://localhost:3306/address_book";
	private static final String userName = "root";
	private static final String password = "user@456";

	public Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
		Connection connection = null;
		connection = DriverManager.getConnection(url, userName, password);
		System.out.println("connected to database" + connection);
		return connection;

	}

	/**
	 * method to establish connection with employee payroll database
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void checkDatabaseConnection() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		listDrivers();

	}

	/**
	 * method to list the drivers
	 */
	private void listDrivers() {
		Enumeration<java.sql.Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = (Driver) driverList.nextElement();
			System.out.println(" " + driverClass.getClass().getName());
		}
	}

	/**
	 * method to select data from the database
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void selectData() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from contact");
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
					+ " " + resultSet.getString(4) + " " + resultSet.getString(5) + " " + resultSet.getInt(6) + " "
					+ resultSet.getString(7) + " " + resultSet.getString(8));
		}

	}

	/**
	 * method to update the record
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean updateData() throws ClassNotFoundException, SQLException {
		boolean success = false;
		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		int result = statement.executeUpdate("update contact set lname='K' where fname='Geeta'");
		if (result > 0) {
			System.out.println("updated successfully");
			success = true;
		}
		return success;
	}

	/**
	 * method to update the record
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean updateDataFail() throws ClassNotFoundException, SQLException {
		boolean success = false;
		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		int result = statement.executeUpdate("update contact set lname='K' where name='Geeta'");
		if (result > 0) {
			System.out.println("updated successfully");
			success = true;
		}
		return success;
	}

	/**
	 * method to select the data on date
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean selectOnDate() {
		Connection connection;
		boolean result = false;
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(
					"select * from contacts where start BETWEEN CAST('2019-09-08' AS DATE) AND DATE(NOW());");
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
						+ " " + resultSet.getString(4) + " " + resultSet.getString(5) + " " + resultSet.getInt(6) + " "
						+ resultSet.getString(7) + " " + resultSet.getString(8));
				result = true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			return result;
		}
		return result;

	}

	/**
	 * method to count record by city
	 * 
	 * @return
	 */
	public boolean countCity() {
		Connection connection;
		boolean success = false;
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select count(*) from contact group by city");
			System.out.println(resultSet.getInt(1));
			success = true;
		} catch (ClassNotFoundException | SQLException e) {
			return success;
		}
		return success;

	}

	/**
	 * method to count records by state
	 * 
	 * @return
	 */
	public boolean countState() {
		Connection connection;
		boolean success = false;
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select count(*) from contact group by state");
			success = true;
			System.out.println(resultSet.getInt(1));
		} catch (ClassNotFoundException | SQLException e) {
			return success;
		}
		return success;
	}

	/**
	 * method to count record by city fails
	 * 
	 * @return
	 */
	public boolean countCityFails() {

		Connection connection;
		boolean success = false;
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select count(*) contact group by city");
			System.out.println(resultSet.getInt(1));
			success = true;
		} catch (ClassNotFoundException | SQLException e) {
			return success;
		}
		return success;
	}

	/**
	 * method to add record
	 * 
	 * @return
	 */
	public boolean addrecord() {
		Connection connection;
		boolean success = false;
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(
					"insert into contacts values('Hita','K','Jharkand','Jk',678965,'8907689769','hita@gmail.com')");
			if (result > 0)
				success = true;
		} catch (ClassNotFoundException | SQLException e) {
			return success;
		}
		return success;
	}

}
