package com.javapractice;

import java.util.Comparator;

public class AddressBookMain {

	public String firstName;
	public String lastName;
	public String address;
	public String city;
	public String state;
	public String zip;
	public String phoneNumber;
	public String email;

	public AddressBookMain(String firstName, String lastName, String address, String city, String state, String zip,
			String phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public void Display() {
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Address: " + address);
		System.out.println("City: " + city);
		System.out.println("State: " + state);
		System.out.println("Zipcode: " + zip);
		System.out.println("Phone Number: " + phoneNumber);
		System.out.println("Email ID: " + email);
		System.out.println("\n" + System.lineSeparator());
	}

	public static Comparator<AddressBookMain> nameComparator = new Comparator<AddressBookMain>() {
		public int compare(AddressBookMain contact1, AddressBookMain contact2) {
			String name1 = contact1.firstName + contact1.lastName;
			String name2 = contact2.firstName + contact2.lastName;
			return name1.compareTo(name2);
		}
	};
}
