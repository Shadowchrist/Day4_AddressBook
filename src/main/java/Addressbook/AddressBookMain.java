package Addressbook;

import java.io.*;
import java.util.Comparator;

import com.opencsv.bean.CsvBindByName;

public class AddressBookMain implements Serializable{

	private static final long serialVersionUID = 1L;
	@CsvBindByName(column="First Name",required=true)
	public String firstName;
	@CsvBindByName(column="Last Name",required=true)
	public String lastName;
	@CsvBindByName(column="Address",required=true)
	public String address;
	@CsvBindByName(column="City",required=true)
	public String city;
	@CsvBindByName(column="State",required=true)
	public String state;
	@CsvBindByName(column="Zipcode",required=true)
	public String zip;
	@CsvBindByName(column="Phone Number",required=true)
	public String phoneNumber;
	@CsvBindByName(column="Email ID",required=true)
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
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
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
