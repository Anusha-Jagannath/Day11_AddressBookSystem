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

	/**
	 * test case to update the record fails
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Test
	public void givenEmployeePayrollDatabase_ShouldUpdateDataFails() throws ClassNotFoundException, SQLException {
		AddressBookJDBC addressbook = new AddressBookJDBC();
		boolean result = addressbook.updateDataFail();
		Assert.assertTrue(result);

	}

	/**
	 * test cases to test data retrieval from database
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Test
	public void givenEmployeePayrollDatabase_ShouldRetrieveDataBasedOnDate()
			throws ClassNotFoundException, SQLException {
		AddressBookJDBC addressbook = new AddressBookJDBC();
		boolean result = addressbook.selectOnDate();
		Assert.assertTrue(result);
	}

	/**
	 * test cases to test count by city from database
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Test
	public void givenEmployeePayrollDatabase_ShouldRetrieveDataBasedOnCity()
			throws ClassNotFoundException, SQLException {
		AddressBookJDBC addressbook = new AddressBookJDBC();
		boolean result = addressbook.countCity();
		Assert.assertTrue(result);
	}

	/**
	 * test cases to test count by city from database fails
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Test
	public void givenEmployeePayrollDatabase_ShouldRetrieveDataBasedOnCityFail()
			throws ClassNotFoundException, SQLException {
		AddressBookJDBC addressbook = new AddressBookJDBC();
		boolean result = addressbook.countCityFails();
		Assert.assertFalse(result);
	}

	/**
	 * test cases to test count by state from database
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Test
	public void givenEmployeePayrollDatabase_ShouldRetrieveDataBasedOnState()
			throws ClassNotFoundException, SQLException {
		AddressBookJDBC addressbook = new AddressBookJDBC();
		boolean result = addressbook.countState();
		Assert.assertTrue(result);
	}

	/**
	 * test cases to add record to database
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@Test
	public void givenEmployeePayrollDatabase_ShouldAddRecord() throws ClassNotFoundException, SQLException {
		AddressBookJDBC addressbook = new AddressBookJDBC();
		boolean result = addressbook.addrecord();
		Assert.assertTrue(result);
	}
}
