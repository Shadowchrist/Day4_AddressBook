package com.javapractice;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookSingle {

	public String name;
	public HashMap<String, AddressBookMain> addressbook;

	public AddressBookSingle(String bookName, HashMap<String, AddressBookMain> book) {
		this.name = bookName;
		this.addressbook = book;
	}

	public static void addDetails(AddressBookSingle book) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first name:");
		String firstName = sc.nextLine();
		System.out.println("Enter last name:");
		String lastName = sc.nextLine();
		String index = firstName + " " + lastName;
		index = index.toUpperCase();
		if (!book.addressbook.containsKey(index)) {
			System.out.println("Enter address:");
			String address = sc.nextLine();
			System.out.println("Enter city:");
			String city = sc.nextLine();
			System.out.println("Enter state:");
			String state = sc.nextLine();
			System.out.println("Enter zipcode:");
			String zip = sc.nextLine();
			System.out.println("Enter Phone Number:");
			String phoneNumber = sc.nextLine();
			System.out.println("Enter email ID:");
			String email = sc.nextLine();
			book.addressbook.put(index,
					new AddressBookMain(firstName, lastName, address, city, state, zip, phoneNumber, email));
			System.out.println("New contact added.");
			book.addressbook.get(index).Display();
		} else
			System.out.println("Contact already exists!!!");
	}

	public static void editDetails(AddressBookSingle book) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter existing first name:");
		String firstName = sc.nextLine();
		System.out.println("Enter existing last name:");
		String lastName = sc.nextLine();
		String index = firstName + " " + lastName;
		index = index.toUpperCase();
		if (!book.addressbook.isEmpty() && book.addressbook.containsKey(index)) {
			int flag = 0;
			while (flag == 0) {
				System.out.println("What do you want to edit? \n" + "1. Address \n" + "2. City \n" + "3. State \n"
						+ "4. Zipcode \n" + "5. Phone Number \n" + "6. Email ID \n" + "7. Password \n"
						+ "8. Editing finished.");
				System.out.println("Enter your choice: \n");
				int ch = sc.nextInt();
				switch (ch) {
				case 1:
					System.out.println("Enter a new address: \n");
					String newaddress = new Scanner(System.in).nextLine();
					book.addressbook.get(index).address = newaddress;
					break;
				case 2:
					System.out.println("Enter a new city: \n");
					String newcity = new Scanner(System.in).nextLine();
					book.addressbook.get(index).city = newcity;
					break;
				case 3:
					System.out.println("Enter a new state: \n");
					String newstate = new Scanner(System.in).nextLine();
					book.addressbook.get(index).state = newstate;
					break;
				case 4:
					System.out.println("Enter a new zip code: \n");
					String newzip = new Scanner(System.in).nextLine();
					book.addressbook.get(index).zip = newzip;
					break;
				case 5:
					System.out.println("Enter a new phone number: \n");
					String newnumber = new Scanner(System.in).nextLine();
					book.addressbook.get(index).phoneNumber = newnumber;
					break;
				case 6:
					System.out.println("Enter a new email ID: \n");
					String newemail = new Scanner(System.in).nextLine();
					book.addressbook.get(index).email = newemail;
					break;
				case 7:
					System.out.println("Changes saved.");
					flag = 1;
					break;
				default:
					System.out.println("Invalid choice!!!");
				}
			}
			System.out.println(" Updated Contact details: ");
			book.addressbook.get(index).Display();
		} else
			System.out.println("Contact does not exist!!!");
	}

	public static void removeDetails(AddressBookSingle book) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first name:");
		String firstName = sc.nextLine();
		System.out.println("Enter last name:");
		String lastName = sc.nextLine();
		String index = firstName + " " + lastName;
		index = index.toUpperCase();
		if (!book.addressbook.isEmpty() && book.addressbook.containsKey(index)) {
			book.addressbook.remove(index);
			System.out.println("Contact removed.");
		} else
			System.out.println("Contact does not exist!!!");
	}

	public static void displayDetails(AddressBookSingle book) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first name:");
		String firstName = sc.nextLine();
		System.out.println("Enter last name:");
		String lastName = sc.nextLine();
		String index = firstName + " " + lastName;
		index = index.toUpperCase();
		if (!book.addressbook.isEmpty() && book.addressbook.containsKey(index)) {
			book.addressbook.get(index).Display();
		} else
			System.out.println("Contact does not exist!!!");
	}

	public static void displayAllContacts(AddressBookSingle book) {
		System.out.println("How do you want to sort? \n" + "1. By name \n" + "2. By zip \n" + "3. By city \n"
				+ "4. By state \n" + "Enter your Choice: ");
		@SuppressWarnings("resource")
		int choice = (new Scanner(System.in)).nextInt();
		ArrayList<AddressBookMain> contacts = new ArrayList<>();
		switch (choice) {
		case 1:
			contacts = (ArrayList<AddressBookMain>) book.addressbook.values().stream().collect(Collectors.toList());
			DictionaryOperations.diplayCriteriaDetails(contacts);
		case 2:
			book.addressbook.values().stream()
					.sorted((contact1, contact2) -> contact1.zip.compareToIgnoreCase(contact2.zip))
					.forEach((p1) -> p1.Display());
			break;
		case 3:
			book.addressbook.values().stream()
					.sorted((contact1, contact2) -> contact1.city.compareToIgnoreCase(contact2.city))
					.forEach((p1) -> p1.Display());
			break;
		case 4:
			book.addressbook.values().stream()
					.sorted((contact1, contact2) -> contact1.state.compareToIgnoreCase(contact2.state))
					.forEach((p1) -> p1.Display());
			break;
		default:
			System.out.println("Wrong Choice!");
		}
	}

	public static void bookOperations(AddressBookSingle book) {
		while (true) {
			System.out.println("Active Book: " + book.name);

			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter 1 to add a contact detail.");
			System.out.println("Enter 2 to edit a contact detail.");
			System.out.println("Enter 3 to remove a contact detail.");
			System.out.println("Enter 4 to display a contact detail.");
			System.out.println("Enter 5 to display all the contact details in the current active book.");
			System.out.println("Enter 6 to return.");
			System.out.println("Enter your choice:");

			int ch = sc.nextInt();

			switch (ch) {
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
			case 5:
				displayAllContacts(book);
				break;
			default:
				return;
			}
		}
	}
}
