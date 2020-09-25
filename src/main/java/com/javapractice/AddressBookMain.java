package com.javapractice;

public class AddressBookMain {

	public String firstName;
	public String lastName;
	public String address; 
	public String city;
	public String state;
	public String zip;
	public String phoneNumber;
	public String email;
	
	public AddressBookMain(String firstName, String lastName, String address, 
						   String city, String state, 
						   String zip, String phoneNumber, String email)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		this.city=city;
		this.state=state;
		this.zip=zip;
		this.phoneNumber=phoneNumber;
		this.email=email;
	}
	

	
	public void Display()
	{
		System.out.println("First Name: "+ this.firstName);
		System.out.println("Last Name: "+ this.lastName);
		System.out.println("Address: "+ this.address);
		System.out.println("City: "+ this.city);
		System.out.println("State: "+ this.state);
		System.out.println("Zipcode: "+ this.zip);
		System.out.println("Phone Number: "+ this.phoneNumber);
		System.out.println("Email ID: "+ this.email);
	}
	
}
