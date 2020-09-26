package com.javapractice;
import java.util.*;

public class AddressBookSingle {
		
	public String name;
	public HashMap<String, AddressBookMain> addressbook;
	public AddressBookSingle(String bookName, HashMap<String, AddressBookMain> book) 
	{
		this.name=bookName;
		this.addressbook=book;
	}
	public static void addDetails(AddressBookSingle book)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first name:");
		String firstName=sc.nextLine();
		System.out.println("Enter last name:");
		String lastName=sc.nextLine();
		String index=firstName+" "+lastName;
		index=index.toUpperCase();
		System.out.println("Enter address:");
		String address=sc.nextLine();
		System.out.println("Enter city:");
		String city=sc.nextLine();
		System.out.println("Enter state:");
		String state=sc.nextLine();
		System.out.println("Enter zipcode:");
		String zip=sc.nextLine();
		System.out.println("Enter Phone Number:");
		String phoneNumber=sc.nextLine();
		System.out.println("Enter email ID:");
		String email=sc.nextLine();
		book.addressbook.put(index,new AddressBookMain(firstName,lastName,address,city,
						   state,zip,phoneNumber,email));
		System.out.println("New contact added.");
		book.addressbook.get(index).Display();
	}
	
	public static void editDetails(AddressBookSingle book)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter existing first name:");
		String firstName=sc.nextLine();
		System.out.println("Enter existing last name:");
		String lastName=sc.nextLine();
		String index=firstName+" "+lastName;
		index=index.toUpperCase();
		if(!book.addressbook.isEmpty()&&book.addressbook.containsKey(index))
		{
			System.out.println("Enter new first name:");
			String newfirstName=sc.nextLine();
			System.out.println("Enter new last name:");
			String newlastName=sc.nextLine();
			String newindex=newfirstName+" "+newlastName;
			newindex=newindex.toUpperCase();
			System.out.println("Enter new address:");
			String newaddress=sc.nextLine();
			System.out.println("Enter new city:");
			String newcity=sc.nextLine();
			System.out.println("Enter new state:");
			String newstate=sc.nextLine();
			System.out.println("Enter new zipcode:");
			String newzip=sc.nextLine();
			System.out.println("Enter new Phone Number:");
			String newphoneNumber=sc.nextLine();
			System.out.println("Enter new email ID:");
			String newemail=sc.nextLine();
			book.addressbook.put(newindex,new AddressBookMain(newfirstName,newlastName,newaddress,newcity,
							   newstate,newzip,newphoneNumber,newemail));
			book.addressbook.remove(index);
			System.out.println(" Updated Contact details: ");
			book.addressbook.get(newindex).Display();
		}	
		else
			System.out.println("Contact does not exist!!!");
	}
	
	public static void removeDetails(AddressBookSingle book)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first name:");
		String firstName=sc.nextLine();
		System.out.println("Enter last name:");
		String lastName=sc.nextLine();
		String index=firstName+" "+lastName;
		index=index.toUpperCase();
		if(!book.addressbook.isEmpty()&&book.addressbook.containsKey(index))
		{
			book.addressbook.remove(index);
			System.out.println("Contact removed.");
		}
		else
			System.out.println("Contact does not exist!!!");
	}
	
	public static void displayDetails(AddressBookSingle book)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first name:");
		String firstName=sc.nextLine();
		System.out.println("Enter last name:");
		String lastName=sc.nextLine();
		String index=firstName+" "+lastName;
		index=index.toUpperCase();
		if(!book.addressbook.isEmpty()&&book.addressbook.containsKey(index))
		{
			book.addressbook.get(index).Display();
		}
		else
			System.out.println("Contact does not exist!!!"); 
	}
	
	public static void bookOperations(AddressBookSingle book)
	{
		while(true)
		{
			System.out.println("Active Book: "+book.name);
			
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter 1 to add a contact detail.");
			System.out.println("Enter 2 to edit a contact detail.");
			System.out.println("Enter 3 to remove a contact detail.");
			System.out.println("Enter 4 to display a contact detail.");
			System.out.println("Enter 5 to return.");
			System.out.println("Enter your choice:");
			
			int ch=sc.nextInt();
			
			switch(ch)
			{
				case 1:
					addDetails(book);
					break;
				case 2:
					editDetails(book);
					break;
				case 3:					
					removeDetails(book);
					break;
				case 4:
					displayDetails(book);
					break;
				default:
					return;
			}
		}
	}
}	
