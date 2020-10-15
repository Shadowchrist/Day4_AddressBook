package Addressbook;
import java.io.*;
import java.util.*;
import com.opencsv.*;
import com.opencsv.bean.*;

public class FileOperations {

	public static void createBook(String bookName)
	{
		String path = "C:\\Users\\DELL\\Desktop\\Practice\\Eclipse\\JAVA\\Addressbook\\Dictionary\\"+ bookName +".csv";
		File file=new File(path);
		boolean result;
		try {
			result=file.createNewFile();
			if(result)
			{
				System.out.println("New Address Book created at: "+file.getAbsolutePath());
				FileWriter outputfile=new FileWriter(file);
				CSVWriter writer=new CSVWriter(outputfile,'|', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
				List<String[]> allLines=new ArrayList<String[]>();
				allLines.add(new String[] {"First Name","Last Name","Address","City","State","Zipcode","Phone Number","Email ID"});
				writer.writeAll(allLines);
				writer.close();
			}
			else
				System.out.println("Address Book already present at: "+file.getAbsolutePath());
		}
		catch (IOException e)
		{
			e.getMessage();
		}	
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static AddressBookSingle mapFileToBook(AddressBookSingle book)
	{
		try
		{
			ColumnPositionMappingStrategy<AddressBookMain> strategy=new ColumnPositionMappingStrategy<AddressBookMain>();
			String[] mapping=new String[] {"First Name","Last Name","Address","City","State","Zipcode","Phone Number","Email ID"};
			strategy.setType(AddressBookMain.class);
			strategy.setColumnMapping(mapping);
			CsvToBean csvToBean=new CsvToBean();
			CSVReader csvReader=new CSVReader(new FileReader("C:\\Users\\DELL\\Desktop\\Practice\\Eclipse\\JAVA\\Addressbook\\"+ book.name +".csv"));
			@SuppressWarnings("deprecation")
			List list=csvToBean.parse(strategy, csvReader);
			for(Object object: list)
			{
				AddressBookMain contact=(AddressBookMain) object;
				String index=(contact.firstName+contact.lastName).toUpperCase();
				book.addressbook.put(index, contact);
			}
		}catch(Exception e)
		{
			e.getMessage();
		}
		return book;
	}
	
	public static void initializeDictionary()
	{
		File directory=new File("C:\\Users\\DELL\\Desktop\\Practice\\Eclipse\\JAVA\\Addressbook\\Dictionary");
		File fileList[]=directory.listFiles();
		for (File file: fileList)
		{
			AddressBookSingle book = new AddressBookSingle(file.getName().toUpperCase(),new HashMap<String,AddressBookMain>());
			AddressBookSingle existingBook=mapFileToBook(book);
			AddressBookDictionary.dictionary.put(existingBook.name.toUpperCase(), existingBook);
		}
	}
	
	public static void displayAllBooks()
	{
		File directory=new File("C:\\Users\\DELL\\Desktop\\Practice\\Eclipse\\JAVA\\Addressbook\\Dictionary");
		File fileList[]=directory.listFiles();
		for (File file: fileList)
		{
			System.out.println(file.getName());
			System.out.println(file.getAbsolutePath());
		}
	}
	
	public static void addDetailsInBook(AddressBookSingle book, AddressBookMain contact, String index)
	{
		String path = "C:\\Users\\DELL\\Desktop\\Practice\\Eclipse\\JAVA\\Addressbook\\Dictionary\\"+ book.name +".csv";
		try 
		{
			FileWriter file=new FileWriter(path,true);
			CSVWriter writer=new CSVWriter(file,'|', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
			List<String[]> allLines=new ArrayList<String[]>();
			allLines.add(new String[] {book.addressbook.get(index).firstName,book.addressbook.get(index).lastName,book.addressbook.get(index).address,book.addressbook.get(index).city,book.addressbook.get(index).state,book.addressbook.get(index).zip,book.addressbook.get(index).phoneNumber,book.addressbook.get(index).email});
			writer.writeAll(allLines);
			writer.close();
		} 	
		catch (IOException e) 
		{
			e.getMessage();
		}
	}

	public static boolean checkIfBookExists(String bookName) {
		String path = "C:\\Users\\DELL\\Desktop\\Practice\\Eclipse\\JAVA\\Addressbook\\Dictionary\\"+ bookName +".csv";
		File temp=new File(path);
		if(temp.exists() && temp.isFile())
			return true;
		else
			return false;
	}
	
	public static boolean deleteBook(String bookName) {
		String path = "C:\\Users\\DELL\\Desktop\\Practice\\Eclipse\\JAVA\\Addressbook\\Dictionary\\"+ bookName +".csv";
		File temp=new File(path);
		return temp.delete();				
	}
	
	public static void getContactDetails(String bookName)
	{
		String path = "C:\\Users\\DELL\\Desktop\\Practice\\Eclipse\\JAVA\\Addressbook\\Dictionary\\"+ bookName +".csv";
		File file = new File(path);
		try {
			FileReader reader=new FileReader(file);
			CSVParser parser=new CSVParserBuilder().withSeparator('|').withIgnoreQuotations(true).withEscapeChar(CSVWriter.DEFAULT_ESCAPE_CHARACTER).withEscapeChar(CSVWriter.DEFAULT_ESCAPE_CHARACTER).withQuoteChar(CSVWriter.NO_QUOTE_CHARACTER).build();
			CSVReader csvReader= new CSVReaderBuilder(reader).withCSVParser(parser).build();
			String[] header=csvReader.readNext();
			String[] nextEntry=csvReader.readNext();
			while(nextEntry!=null)
			{
				for(int i=0;i<header.length;i++)
				{
					System.out.print(header[i]+": "+nextEntry[i]+"\n");
				}
				System.out.println();
				nextEntry=csvReader.readNext();
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
}	

