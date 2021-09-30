package com.test;

import java.sql.SQLException;

import org.junit.Test;

import com.address.AddressBookJDBC;


public class AddressBookJDBCTest {

	/**
	 * test case to check database connected or not
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void givenEmployeePayrollDatabase_ShouldConnectToDatabase() throws ClassNotFoundException, SQLException {
		AddressBookJDBC addressbook = new AddressBookJDBC();
		addressbook.checkDatabaseConnection();
	}
}