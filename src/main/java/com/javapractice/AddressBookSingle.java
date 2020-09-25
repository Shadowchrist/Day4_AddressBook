package com.javapractice;
import java.util.*;

public class AddressBookSingle {
	
	static HashMap<String,AddressBookMain> addressbook= new HashMap<>();
	
	private static void addDetails()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first name:");
		String firstName=sc.nextLine();
		System.out.println("Enter last name:");
		String lastName=sc.nextLine();
		String index=firstName+" "+lastName;
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
		addressbook.put(index,new AddressBookMain(firstName,lastName,address,city,
						   state,zip,phoneNumber,email));
		System.out.println("New contact added.");
		addressbook.get(index).Display();
	}
	
	private static void editDetails()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter existing first name:");
		String firstName=sc.nextLine();
		System.out.println("Enter existing last name:");
		String lastName=sc.nextLine();
		String index=firstName+" "+lastName;
		if(!addressbook.isEmpty()&&addressbook.containsKey(index))
		{
			System.out.println("Enter new first name:");
			String newfirstName=sc.nextLine();
			System.out.println("Enter new last name:");
			String newlastName=sc.nextLine();
			String newindex=newfirstName+" "+newlastName;
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
			addressbook.put(newindex,new AddressBookMain(newfirstName,newlastName,newaddress,newcity,
							   newstate,newzip,newphoneNumber,newemail));
			addressbook.remove(index);
			System.out.println(" Updated Contact details: ");
			addressbook.get(newindex).Display();
		}	
		else
			System.out.println("Contact does not exist!!!");
	}
	
	private static void removeDetails()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first name:");
		String firstName=sc.nextLine();
		System.out.println("Enter last name:");
		String lastName=sc.nextLine();
		String index=firstName+" "+lastName;
		if(!addressbook.isEmpty()&&addressbook.containsKey(index))
		{
			addressbook.remove(index);
			System.out.println("Contact removed.");
		}
		else
			System.out.println("Contact does not exist!!!");
	}
	
	private static void displayDetails()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first name:");
		String firstName=sc.nextLine();
		System.out.println("Enter last name:");
		String lastName=sc.nextLine();
		String index=firstName+" "+lastName;
		if(!addressbook.isEmpty()&&addressbook.containsKey(index))
		{
			addressbook.get(index).Display();
		}
		else
			System.out.println("Contact does not exist!!!"); 
	}
	
	public static void main(String args[])
	{
		while(true)
		{
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter 1 to add a contact detail.");
			System.out.println("Enter 2 to edit a contact detail.");
			System.out.println("Enter 3 to remove a contact detail.");
			System.out.println("Enter 4 to display a contact detail.");
			System.out.println("Enter 5 to exit.");
			System.out.println("Enter your choice:");
			
			int ch=sc.nextInt();
			
			switch(ch)
			{
				case 1:
					addDetails();
					break;
				case 2:
					editDetails();
					break;
				case 3:					
					removeDetails();
					break;
				case 4:
					displayDetails();
					break;
				default:
					System.out.println("Exiting...");
					System.exit(0);
			}
		}
	}
}	
