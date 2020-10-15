package Addressbook;

import java.io.IOException;
import java.util.*;

public class DictionaryOperations<search> {

	public static boolean checkAddressBook(String bookName) {
		if (AddressBookDictionary.dictionary.containsKey(bookName))
			return true;
		else
			return false;
	}

	public static void displayAddressBooks() {
		ArrayList<String> existingbooks = new ArrayList<>();
		for (String books : AddressBookDictionary.dictionary.keySet())
			existingbooks.add(books);
		Collections.sort(existingbooks);
		int i = 1;
		for (String books : existingbooks)
			System.out.println(i++ + ": " + books);
	}

	public static ArrayList<AddressBookMain> searchByCriteria(char choice, String parameter) {
		ArrayList<AddressBookMain> local = new ArrayList<>();
		for (AddressBookSingle itr : AddressBookDictionary.dictionary.values()) {
			if (choice == '1') {
				for (AddressBookMain criteria : itr.addressbook.values()) {
					if (criteria.city.equalsIgnoreCase(parameter))
						local.add(criteria);
				}
			} else if (choice == '2') {
				for (AddressBookMain criteria : itr.addressbook.values()) {
					if (criteria.state.equalsIgnoreCase(parameter))
						local.add(criteria);
				}
			} else {
				for (AddressBookMain criteria : itr.addressbook.values()) {
					if (criteria.state.equalsIgnoreCase(parameter))
						local.add(criteria);
				}
			}
		}
		return local;
	}

	public static void diplayCriteriaDetails(ArrayList<AddressBookMain> search) {
		Collections.sort(search, AddressBookMain.nameComparator);
		for (AddressBookMain itr : search) {
			itr.Display();
			System.out.println("\n");
		}
	}

	public static void createAddressBook() throws IOException {
		System.out.println("Enter name of Address Book to be created: ");
		@SuppressWarnings("resource")
		String bookName = new Scanner(System.in).nextLine();
		bookName = bookName.toUpperCase();
		if (!FileOperations.checkIfBookExists(bookName)) {
			HashMap<String, AddressBookMain> book = new HashMap<>();
			AddressBookDictionary.dictionary.put(bookName, new AddressBookSingle(bookName, book));
			FileOperations.createBook(bookName);
			System.out.println("Address Book Created");
			
		} else
			System.out.println("Address Book with that name already present!!!");
	}

	public static void selectAddressBook() throws IOException {
		System.out.println("Address Books present: \n");
		FileOperations.displayAllBooks();
		System.out.println("Enter name of Address Book to be selected: ");
		@SuppressWarnings("resource")
		
		Scanner ob = new Scanner(System.in);
		String current = ob.nextLine();
		current = current.toUpperCase();
		if (FileOperations.checkIfBookExists(current)) 
		{
			AddressBookSingle book = new AddressBookSingle(current,new HashMap<String,AddressBookMain>());
			AddressBookSingle activeBook = FileOperations.mapFileToBook(book);
			AddressBookDictionary.dictionary.put(current.toUpperCase(), activeBook);
			AddressBookSingle.bookOperations(activeBook);
		} else {
			System.out.println("No such directory exists! Do you want to create one? (Yes/No) \n");
			String choice = ob.nextLine();
			choice = choice.toUpperCase();
			switch (choice) {
			case "YES":
				createAddressBook();
				break;
			case "NO":
				System.out.println("Returning...");
				break;
			default:
				System.out.println("Wrong Choice!!!");
			}
		}
	}

	public static void removeAddressBook() {
		System.out.println("Enter name of Address Book to be removed: ");
		@SuppressWarnings("resource")
		Scanner ob = new Scanner(System.in);
		String rem = ob.nextLine();
		rem = rem.toUpperCase();
		if (AddressBookDictionary.dictionary.containsKey(rem) || FileOperations.checkIfBookExists(rem) ) {
			FileOperations.deleteBook(rem);
			AddressBookDictionary.dictionary.remove(rem);
			System.out.println("Address Book Deleted");
		} else
			System.out.println("No such directory exists!");
	}
}