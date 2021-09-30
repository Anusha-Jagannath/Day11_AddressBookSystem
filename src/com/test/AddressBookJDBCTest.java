package com.test;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import com.address.AddressBookJDBC;

import junit.framework.Assert;

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

	/**
	 * test cases to test data retrieval from database
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Test
	public void givenEmployeePayrollDatabase_ShouldRetrieveData() throws ClassNotFoundException, SQLException {
		AddressBookJDBC addressbook = new AddressBookJDBC();
		addressbook.selectData();
	}

	/**
	 * test case to update the record
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Test
	public void givenEmployeePayrollDatabase_ShouldUpdateData() throws ClassNotFoundException, SQLException {
		AddressBookJDBC addressbook = new AddressBookJDBC();
		boolean result = addressbook.updateData();
		Assert.assertTrue(result);

	}
}
