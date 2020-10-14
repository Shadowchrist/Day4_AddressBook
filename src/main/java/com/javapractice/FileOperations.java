package com.javapractice;
import java.io.*;
import java.util.HashMap;


public class FileOperations {

	public static void createBook(String bookName)
	{
		String path = "C:\\Users\\DELL\\Desktop\\Practice\\Git Repositories\\Day4_AddressBook\\Dictionary\\"+ bookName +".txt";
		File file=new File(path);
		boolean result;
		try {
			result=file.createNewFile();
			if(result)
				System.out.println("New Address Book created at: "+file.getAbsolutePath());
			else
				System.out.println("Address Book already present at: "+file.getAbsolutePath());
		}
		catch (IOException e)
		{
			e.getMessage();
		}	
	}
	
	public static void displayAllBooks()
	{
		File directory=new File("C:\\Users\\DELL\\Desktop\\Practice\\Git Repositories\\Day4_AddressBook\\Dictionary");
		File fileList[]=directory.listFiles();
		for (File file: fileList)
		{
			System.out.println(file.getName());
			System.out.println(file.getAbsolutePath());
		}
	}
	
	public static void addDetailsInBook(AddressBookSingle book, AddressBookMain contact, String index)
	{
		String path = "C:\\Users\\DELL\\Desktop\\Practice\\Git Repositories\\Day4_AddressBook\\Dictionary\\"+ book.name +".txt";
		try 
		{
			FileWriter file=new FileWriter(path,true);
			BufferedWriter out=new BufferedWriter(file);
			String toBeWritten ="Name: " + index + "\nAddress: " + book.addressbook.get(index).address + 
					"\nCity: " + book.addressbook.get(index).city + "\nState: " + book.addressbook.get(index).state + 
					"\nZip Code: " + book.addressbook.get(index).zip + "\nPhone Number: " + book.addressbook.get(index).phoneNumber + 
					"\nEmail ID: " + book.addressbook.get(index).email + "\n";
			out.write(toBeWritten); 
            out.write("====================");
            out.close();
		} 	
		catch (IOException e) 
		{
			e.getMessage();
		}
	}
	
	@SuppressWarnings("resource")
	public static String returnContactDetails(AddressBookSingle book, String index)
	{
		String path1 = "C:\\Users\\DELL\\Desktop\\Practice\\Git Repositories\\Day4_AddressBook\\Dictionary\\"+ book.name +".txt";
		try 
		{			
			File file1 = new File(path1);
			BufferedReader in=new BufferedReader(new FileReader(file1));
			String line= in.readLine();
			while(line!=null)
				{	
					if(line.contains("Name: "+index))
					{
						break;
					}
					line=in.readLine();
				}
			while(line!="====================")
			{
				System.out.println(line);
				line=in.readLine();
			}
		} 
		catch (IOException e) 
		{
			e.getMessage();
		}
		return "No such contact exists!!!";
	}

	public static boolean checkIfBookExists(String bookName) {
		String path = "C:\\Users\\DELL\\Desktop\\Practice\\Git Repositories\\Day4_AddressBook\\Dictionary\\"+ bookName +".txt";
		File temp=new File(path);
		if(temp.exists() && temp.isFile())
			return true;
		else
			return false;
	}
	
	public static boolean deleteBook(String bookName) {
		String path = "C:\\Users\\DELL\\Desktop\\Practice\\Git Repositories\\Day4_AddressBook\\Dictionary\\"+ bookName +".txt";
		File temp=new File(path);
		return temp.delete();				
	}
	
	public static void getContactDetails(String bookName)
	{
		String path = "C:\\Users\\DELL\\Desktop\\Practice\\Git Repositories\\Day4_AddressBook\\Dictionary\\"+ bookName +".txt";
		File file = new File(path);
		try {
			BufferedReader in=new BufferedReader(new FileReader(file));
			String line= in.readLine();
			while(line!=null)
				{	
					System.out.println(line);
					line=in.readLine();
				}
			in.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
	}
	
	public static void initializeDictionary()
	{
		File directory=new File("C:\\Users\\DELL\\Desktop\\Practice\\Git Repositories\\Day4_AddressBook\\Dictionary");
		File fileList[]=directory.listFiles();
		for (File file: fileList)
		{
			HashMap<String, AddressBookMain> book = new HashMap<>();
			AddressBookDictionary.dictionary.put(file.getName().toUpperCase(), new AddressBookSingle(file.getName().toUpperCase(), book));
		}
	}
}	

