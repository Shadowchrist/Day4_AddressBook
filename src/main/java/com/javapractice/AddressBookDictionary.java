package com.javapractice;

import java.io.IOException;
import java.util.*;

public class AddressBookDictionary {
	public static HashMap<String, AddressBookSingle> dictionary = new HashMap<>();

	public static void main(String args[])throws IOException {
		while (true) {
			System.out.println("1. Create and Add AddressBook");
			System.out.println("2. Select AddressBook");
			System.out.println("3. Delete AddressBook");
			System.out.println("4. Search people according to city, state or zipcode: ");
			System.out.println("5. Display number of people living in a city, state or zipcode: ");
			System.out.println("6. Exit");
			System.out.println("Enter your choice : \n");
			@SuppressWarnings("resource")
			Scanner ob1 = new Scanner(System.in);
			char choice = ob1.next().charAt(0);

			switch (choice) {
			case '1':
				DictionaryOperations.createAddressBook();
				break;
			case '2':
				DictionaryOperations.selectAddressBook();
				break;
			case '3':
				DictionaryOperations.removeAddressBook();
				break;
			case '4':
				int flag1 = 0;
				while (flag1 == 0) {
					System.out.println("Display people according to \n" + "1. City \n" + "2. State \n" + "3. Zipcode \n"
							+ "4. Return \n" + "Enter your choice: \n");
					char searchparameter = ob1.next().charAt(0);
					if (searchparameter == '1') {
						@SuppressWarnings("resource")
						Scanner sc = new Scanner(System.in);
						System.out.println("Enter city name: ");
						String searchCity = sc.nextLine();
						DictionaryOperations
								.diplayCriteriaDetails(DictionaryOperations.searchByCriteria('1', searchCity));
					} else if (searchparameter == '2') {
						@SuppressWarnings("resource")
						Scanner sc = new Scanner(System.in);
						System.out.println("Enter state name: ");
						String searchState = sc.nextLine();
						DictionaryOperations
								.diplayCriteriaDetails(DictionaryOperations.searchByCriteria('2', searchState));
					} else if (searchparameter == '3') {
						@SuppressWarnings("resource")
						Scanner sc = new Scanner(System.in);
						System.out.println("Enter zip code: ");
						String searchZip = sc.nextLine();
						DictionaryOperations
								.diplayCriteriaDetails(DictionaryOperations.searchByCriteria('3', searchZip));
					} else {
						System.out.println("Wrong Choice!");
						flag1 = 1;
					}
				}
				break;
			case '5':
				int flag2 = 0;
				while (flag2 == 0) {
					System.out.println("Display no of people according to: \n" + "1. City \n" + "2. State \n"
							+ "3. Zipcode \n" + "4. Return \n" + "Enter your choice: \n");
					char countparameter = ob1.next().charAt(0);
					if (countparameter == '1') {
						@SuppressWarnings("resource")
						Scanner sc = new Scanner(System.in);
						System.out.println("Enter city name: ");
						String searchCity = sc.nextLine();
						System.out.println(DictionaryOperations.searchByCriteria('1', searchCity).size()
								+ " people living in " + searchCity);
					} else if (countparameter == '2') {
						@SuppressWarnings("resource")
						Scanner sc = new Scanner(System.in);
						System.out.println("Enter state name: ");
						String searchState = sc.nextLine();
						System.out.println(DictionaryOperations.searchByCriteria('2', searchState).size()
								+ " people living in " + searchState);
					} else if (countparameter == '3') {
						@SuppressWarnings("resource")
						Scanner sc = new Scanner(System.in);
						System.out.println("Enter zipcode: ");
						String searchZip = sc.nextLine();
						System.out.println(DictionaryOperations.searchByCriteria('3', searchZip).size()
								+ " people living in " + searchZip);
					} else {
						System.out.println("Wrong Choice!");
						flag2 = 1;
					}
				}
				break;
			case '6':
				System.out.println("Exiting...");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}
	}
}
