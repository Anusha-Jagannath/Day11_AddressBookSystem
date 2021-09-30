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

}
