package com.address;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;

import java.util.Scanner;
import java.util.Set;

/**
 * AddressBook is a class to add, delete, update contact Ability to create a
 * Contacts in Address Book with first and last names, address, city, state,
 * zip, phone number and email... Ability to ensure there is no Duplicate Entry
 * of the same Person in a particular Address Book. Ability to search Person in
 * a City or State across the multiple AddressBook Ability to view person by
 * city or state and get the count
 */
public class AddressBook {
	static String firstName;
	static String lastName;
	static String address;
	static String city;
	static String state;
	static int zip;
	static String phoneNo;
	static String email;
	static Map<String, Contact> map = new HashMap<>();
	static List<Contact> list = new ArrayList<>(); // list stores multiple contacts
	static String path = "/Users/anushajs/eclipse-workspace/Yml-training/Day11_AddressBook/src/data/address.txt";

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");

		Scanner sc = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);

		Boolean ch = true;
		int option;
		while (ch) {
			System.out.println(
					"1.Add contact\n2.Edit contact\n3.Delete contact\n4.Display contact\n5.Search contact by place\n6.View person by city\n7.View person by state\n8.Sort by name\n9.Sort by city\n10.Sort by zip\n11.write to file\n12.Read from file\n13.Exit");
			option = scanner.nextInt();

			switch (option) {
			case 1:
				System.out.println("1.create new address book\n2.Existing address book");
				int option2 = scanner.nextInt();
				if (option2 == 1) {
					System.out.println("Enter address book name");
					String addressBookName = sc.nextLine();
					addContact(addressBookName);
				}

				if (option2 == 2) {
					System.out.println("Enter the existing book adress");
					String existAddress = sc.nextLine();
					if (map.containsKey(existAddress) == false) {
						System.out.println("Address book name not found");
					} else {
						System.out.println("Address book found");
						addContact(existAddress);
					}
				}
				break;

			case 2:
				System.out.println("Enter the name of the contact you want to edit");
				String editName = sc.nextLine();
				if (list.size() != 0) {
					Contact person = getPerson(list, editName);
					if (person == null)
						System.out.println("Contacts not found");
					else
						editContact(person);
					System.out.println("Edited successfully");
					break;

				} else
					System.out.println("Address book is empty");
				break;

			case 3:
				System.out.println("Enter the contact first name to be deleted");
				String fname = sc.nextLine();
				Contact person2 = getPerson(list, fname);
				if (person2 == null)
					System.out.println("Contacts not found");
				else
					list.remove(person2);
				System.out.println("deleted successfully");
				break;
			case 4:
				for (Contact values : list) {
					System.out.println(values);
				}
				break;
			case 5:
				System.out.println("Enter city or state");
				String place = sc.nextLine();
				searchContact(list, place);
				break;
			case 6:
				System.out.println("Enter the City: ");
				String city = sc.next();
				System.out.println("Person's whose City is: " + city);
				for (Entry<String, Contact> entry : ((Map<String, Contact>) list).entrySet()) {
					searchContact(list, city);
				}
				break;

			case 7:
				System.out.println("Enter the state: ");
				String state = sc.next();
				System.out.println("Person's whose City is: " + state);
				for (Entry<String, Contact> entry : ((Map<String, Contact>) list).entrySet()) {
					searchContact(list, state);
				}
				break;

			case 8:
				sort();
				break;
			case 9:
				sort();
				break;
			case 10:
				sort();
				break;
			case 11:
				writeToFile(list);
				break;
			case 12:
				readFile();
				break;
			case 13:
				ch = false;
				break;
			default:
				ch = false;
			}
		}
	}

	private static void addContact(String addressBookName) {
		Scanner sc = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter first name");
		firstName = sc.nextLine();

		System.out.println("Enter second name");
		lastName = sc.nextLine();

		System.out.println("Enter address");
		address = sc.nextLine();

		System.out.println("Enter city");
		city = sc.nextLine();

		System.out.println("Enter state");
		state = sc.nextLine();

		System.out.println("Enter zip");
		zip = scanner.nextInt();

		System.out.println("Enter phone no");
		phoneNo = sc.nextLine();

		System.out.println("Enter email");
		email = sc.nextLine();

		Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNo, email);
		if (!duplicateCheck(list, firstName, lastName)) {
			list.add(contact);
			map.put(addressBookName, contact);
		}
		System.out.println(map);

	}

	/**
	 * method to edit contact
	 * 
	 * @param person
	 */

	private static void editContact(Contact person) {
		Scanner sc = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		int option;
		Boolean ch = true;
		while (ch) {
			System.out.println("1.Edit first name\n2.Edit last name\n"
					+ "3.Edit Address\n4.City\n5.State\n6.Zip\n7.Phone no\n8.email\n9Exit");
			option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter first name to edit");
				String fname = scanner.nextLine();
				person.firstName = fname;
				break;
			case 2:
				System.out.println("Enter last name to edit");
				String lname = scanner.nextLine();
				person.lastName = lname;
				break;
			case 3:
				System.out.println("Enter address to edit");
				String address = scanner.nextLine();
				person.address = address;
				break;
			case 4:
				System.out.println("Enter city to edit");
				String city = scanner.nextLine();
				person.city = city;
				break;

			case 5:
				System.out.println("Enter state to update");
				String state = scanner.nextLine();
				person.state = state;
				break;

			case 6:
				System.out.println("Enter zip code");
				int zip = sc.nextInt();
				person.zip = zip;

			case 7:
				System.out.println("Enter phone no to edit");
				String phone = scanner.nextLine();
				person.phoneNo = phone;
				break;

			case 8:
				System.out.println("Enter email to edit");
				String email = scanner.nextLine();
				person.email = email;
				break;

			case 9:
				ch = false;
				break;
			default:
				ch = false;

			}
		}
	}

	/**
	 * method to fetch contact
	 * 
	 * @param list and name to be edited
	 */

	private static Contact getPerson(List<Contact> list, String editName) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).firstName.equals(editName))
				return list.get(i);
		}
		return null;
	}

	/**
	 * Method to check for duplicate contacts
	 * 
	 * @param list
	 * @param name
	 * @param lastName
	 * @return
	 */
	private static Boolean duplicateCheck(List<Contact> list, String name, String lastName) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).firstName.equals(name) && list.get(i).lastName.equals(lastName)) {
				System.out.println("Contact already exists in this Address Book.");
				return true;
			}
		}
		return false;
	}

	/**
	 * search contact is used search the required contact
	 * 
	 * @param place to be searched
	 */
	private static void searchContact(List<Contact> list, String place) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).city.equals(place) || list.get(i).state.equals(place)) {
				System.out.println("First name: " + list.get(i).firstName + "\nLast name: " + list.get(i).lastName
						+ "\nPhone no: " + list.get(i).phoneNo + "\nZip:  " + list.get(i).zip + "\nEmail id: "
						+ list.get(i).email + "\nAddress: " + list.get(i).address);
			}
		}

	}

	/**
	 * method to sort person names,state and zip
	 */
	public static void sort() {
//		Contact contacts;
//		Map<String, Contact> sortedContact = contacts.entrySet().stream().sorted(Map.Entry.comparingByKey())
//				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
//						LinkedHashMap::new));
//
//		for (Map.Entry<String, Contact> entry : sortedContact.entrySet()) {
//
//			System.out.println(entry.getValue());
//		}

	}

	/**
	 * method to write list of contacts to a file
	 * 
	 * @param addressList
	 */
	public static void writeToFile(List<Contact> addressList) {
		final StringBuffer contactBuffer = new StringBuffer();
		addressList.forEach(new Consumer<Contact>() {
			public void accept1(Contact contacts) {
				String contactDataString = contacts.toString().concat("\n");
				contactBuffer.append(contactDataString);
			}

			@Override
			public void accept(Contact t) {

			}
		});

		try {
			Files.write(Paths.get(path), contactBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * method to read from the file
	 */
	public static void readFile() {
		try {
			Files.lines(new File(path).toPath()).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
