package com.address;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		List<Contact> list = new ArrayList<>();
		String firstName;
		String lastName;
		String address;
		String city;
		String state;
		int zip;
		int phoneNo;
		String email;

		Scanner sc = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);

		Boolean ch = true;
		int option;

		while (ch) {
			System.out.println("1.Add\n2.Display\n3.Exit");
			option = scanner.nextInt();

			switch (option) {
			case 1:
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
				phoneNo = scanner.nextInt();

				System.out.println("Enter email");
				email = sc.nextLine();

				Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNo, email);
				list.add(contact);

				break;

			case 2:
				for (Contact values : list) {
					System.out.println(values);

				}
				break;

			case 3:
				ch = false;
				break;
			default:
				ch = false;

			}
		}
	}

}
