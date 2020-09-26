package com.javapractice;

import java.util.*;

public class AddressBookDictionary
{
	static HashMap<String,AddressBookSingle> dictionary= new HashMap<>();
	
	public static void main(String args[])
	{
		while(true)
		{
			System.out.println("1. Create and Add AddressBook");
			System.out.println("2. Select AddressBook");
			System.out.println("3. Delete AddressBook");
			System.out.println("4. Exit");
			System.out.println("Enter your choice : ");
			Scanner ob1=new Scanner(System.in);
			char choice = ob1.next().charAt(0);

			switch (choice) 
			{
				case '1':
					System.out.println("Enter name of Address Book to be created: ");
					Scanner ob2=new Scanner(System.in);
					String bookName = ob2.nextLine();
					bookName=bookName.toUpperCase();
					HashMap<String,AddressBookMain> book=new HashMap<>();
					dictionary.put(bookName,new AddressBookSingle(bookName,book));
					System.out.println("Address Book Created");
					break;
				case '2':
					System.out.println("Enter name of Address Book to be selected: ");
					Scanner ob3=new Scanner(System.in);
					String current = ob3.nextLine();
					current=current.toUpperCase();
					AddressBookSingle activeBook = dictionary.get(current);
					AddressBookSingle.bookOperations(activeBook);
					break;
				case '3':
					System.out.println("Enter name of Address Book to be removed: ");
					Scanner ob4=new Scanner(System.in);
					String rem=ob4.nextLine();
					rem=rem.toUpperCase();
					dictionary.remove(rem);
					System.out.println("Address Book Deleted");
					break;
				case '4':
					System.out.println("Exiting...");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Choice");
				}
		}
	}
}	
		
		