// Exercise 15.4
/*(File Matching)
 * Self-Review Exercise15.2 asked you to write a series of single statements.
 * Actually, these statements form the core of an important type of file-processing program—namely,
 * a file-matching program.
 * In commercial data processing, it’s common to have several files in each application system.
 * In an accounts receivable system, for example, there’s generally a master file containing detailed
 *  information about each customer, such as the customer’s name, address, telephone number,
 *  outstanding balance, credit limit, discount terms, contract arrangements and possibly a condensed
 *  history of recent purchases and cash payments.
 *  As transactions occur (i.e., sales are made and payments arrive in the mail),
 *   information about them is entered into a file.
 * At the end of each business period (a month for some companies, a week for others, and a day in some
 *  cases), the file of transactions (called "trans.txt") is applied to the master file (called
 *   "oldmast.txt") to update each account’s purchase and payment record.
 * During an update, the master file is rewritten as the file "newmast.txt",
 *  which is then used at the end of the next business period to begin the updating process again.
 * 
 * File-matching programs must deal with certain problems that do not arise in single-file programs.
 * For example, a match does not always occur.
 * If a customer on the master file has not made any purchases or cash payments in the current business
 *  period, no record for this customer will appear on the transaction file.
 *  Similarly, a customer who did make some purchases or cash payments could have just moved to this
 *  community, and if so, the company may not have had a chance to create a master record for this customer.
 * 
 * Write a complete file-matching accounts receivable program. Use the account number on each file as the
 *  record key for matching purposes.
 *  Assume that each file is a sequential text file with records stored in increasing account-number order.
 *  
 * 1. Define class TransactionRecord.
 * Objects of this class contain an account number and amount for the transaction.
 * Provide methods to modify and retrieve these values.
 * 
 * 2. Modify class Account in Fig. 15.9 to include method combine, which takes a TransactionRecord object
 * and combines the balance of the Account object and the amount value of the TransactionRecord object.
 * 
 * 3. Write a program to create data for testing the program.
 *  Use the sample account data in Figs. 15.16 and 15.17.
 *  Run the program to create the files trans.txt and oldmast.txt to be used by your file-matching program.
 * Fig. 15.16
 * Master file
 * account
 * number	Name	Balance
 * 100	Alan Jones	348.17
 * 300	Mary Smith	27.19
 * 500	Sam Sharp	0.00
 * 700	Suzy Green	–14.22
 * Sample data for master file.
 * 
 * 4. Create class FileMatch to perform the file-matching functionality.
 * The class should contain methods that read oldmast.txt and trans.txt.
 * When a match occurs (i.e., records with the same account number appear in both the master file and the
 * transaction file), add the dollar amount in the transaction record to the current balance in the master
 * record, and write the "newmast.txt" record.
 * (Assume that purchases are indicated by positive amounts in the transaction file and payments by negative
 *  amounts.)
 * When there’s a master record for a particular account, but no corresponding transaction record, merely
 *  write the master record to "newmast.txt".
 * When there’s a transaction record, but no corresponding master record, print to a log file the message
 *  "Unmatched transaction record for account number___" (fill in the account number from the transaction record).
 *  The log file should be a text file named "log.txt".
 *Fig. 15.17
 *Transaction file
 *account
 *number	Transaction amount
 *   100	27.14
 *   300	62.11
 *   400	100.56
 *   900	82.17
 * Sample data for transaction file.
 */

// Fig. 15.11: CreateSequentialFile.java
// Writing objects to a file with JAXB and BufferedWriter.

// import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateFiles
{
	/*Part 3. Write a program to create data for testing the program.
	 *  Use the sample account data in Figs. 15.16 and 15.17.
	 *  Run the program to create the files trans.txt and oldmast.txt to be used by your file-matching program.
	 * Fig. 15.16
	 * Master file
	 * account
	 * number	Name	Balance
	 * 100	Alan Jones	348.17
	 * 300	Mary Smith	27.19
	 * 500	Sam Sharp	0.00
	 * 700	Suzy Green	–14.22
	 * Sample data for master file.
	 * 
	 * *Fig. 15.17
	 *Transaction file
	 *account
	 *number	Transaction amount
	 *   100	27.14
	 *   300	62.11
	 *   400	100.56
	 *   900	82.17
	 * Sample data for transaction file.
	 */ 
	
	// initializing variables. This data is used for force insert into file
	private static String[] oldMasterFile = {"100 Alan Jones 348.17", "300 Mary Smith 27.19", "500 Sam Sharp 0.00", "700 Suzy Green -14.22"};
	private static String[] transFile = {"100 27.14", "300 62.11", "400 100.56", "900 82.17"};
	
	public static void CreateOldMasterFile() // this method need human intervention
	{
		Scanner input = new Scanner(System.in);
		System.out.printf("%s%n%s%n? ", "Enter account number, first name, last name, and balance.", "Enter end-of-file indicator to end input.");
		
		// create new record/account
		Account record = new Account(input.nextInt(), input.next(), input.next(), input.nextDouble());
		try (Formatter oldMaster2 = new Formatter("oldmast2.txt"))
		{
			while (input.hasNext()) // loop until end-of-file indicator
			{
				try
				{
					// add to oldmaster file
					oldMaster2.format("%d %s %s %.2f%n", record.getAccountNumber(), record.getFirstName(), record.getLastName(), record.getBalance() );
				}
				catch (NoSuchElementException elementException)
				{
					System.err.println("Invalid Account input. Please try again.");
					input.nextLine(); // discard input so user can try again
				}
			}
		}
		catch (SecurityException | FileNotFoundException | FormatterClosedException e)
		{
			e.printStackTrace();
			System.exit(1); // terminate the program
		}
		input.close();
	} // end method CreateOldMasterFile

	public static void CreateOldMasterFile2() // this method bypasses the human input of the data required
	{
		try (Formatter output = new Formatter("oldmast2.txt") )
		{
			for(int i = 0; i < oldMasterFile.length; i++)
			{
				output.format("%s%n", oldMasterFile[i] );
			}
		}
//		catch (NoSuchElementException elementException)
//		{
//			System.err.println("Invalid Account input. Please try again.");
//		}
		catch (SecurityException | FileNotFoundException | FormatterClosedException e)
		{
			e.printStackTrace();
		}
	} // end method CreateOldMasterFile2

	// create trans file
	public void CreateTransFile() // this method need human intervention
	{
		Scanner input = new Scanner(System.in);
		// get the info first
		Account record = new Account(); // will be removed if Account accountNumber does not work
		TransactionRecord transaction = new TransactionRecord(input.nextInt(),input.nextDouble() );
		try (Formatter outputTrans2 = new Formatter("trans2.txt") )
		{
			while (input.hasNext())
			{
				try
				{
					// then output the info to file
					// the below line will be used if Account accountNumber does not work
					// output.format("%d %.2f%n", transaction.getAccountNumber(), transaction.getTransaction() );
					outputTrans2.format("%d %.2f%n", record.getAccountNumber(), transaction.getTransaction() );
					// Scanner(Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\15-4_4 new files created\\log.txt"));
				}
				catch (NoSuchElementException elementException)
				{
					System.err.println("Invalid transfer into file. Please try again.");
					input.nextLine(); // discard input so user can try again
				}
			}
		}
		catch (SecurityException | FileNotFoundException | FormatterClosedException e)
		{
			e.printStackTrace();
		}
		input.close();
	} // end method CreateTransFile
	
	public static void CreateTransFile2() // this method bypasses the human input of the data required
	{
		try (Formatter output = new Formatter("trans2.txt") )
		{
			for(int i = 0; i < transFile.length; i++)
			{
				output.format("%s%n", transFile[i] );
			}
		}
		catch (NoSuchElementException elementException)
		{
			System.err.println("Invalid Account input. Please try again.");
		}
		catch (SecurityException | FileNotFoundException | FormatterClosedException e)
		{
			e.printStackTrace();
		}
	} // end method CreateTransFile2
	
	public static void main(String[] args)
	{
	
		// these two commands will force the creation/create the two files
		CreateOldMasterFile2();

		CreateTransFile2();

		// the below line are used as a template only
//		// Fig. 15.11: CreateSequentialFile.java
//		// Writing objects to a file with JAXB and BufferedWriter.
//		// open clients.xml, write objects to it then close file
//		try(BufferedWriter output = Files.newBufferedWriter(Paths.get("clients.xml")))
//		{
//
//			Scanner input = new Scanner(System.in);
//
//			// stores the Accounts before XML serialization
//			// Accounts accounts = new Accounts(); 
//			List<Account> accounts = new ArrayList<>(); // stores Accounts
//
//			System.out.printf("%s%n%s%n? ", "Enter account number, first name, last name and balance.", "Enter end-of-file indicator to end input.");
//
//			while (input.hasNext()) // loop until end-of-file indicator
//			{
//				try
//				{
//					// create new record
//					Account record = new Account(input.nextInt(), input.next(), input.next(), input.nextDouble());
//
//					// add to AccountList
//					accounts.getAccounts().add(record);
//				}
//				catch (NoSuchElementException elementException)
//				{
//					System.err.println("Invalid input. Please try again.");
//					input.nextLine(); // discard input so user can try again
//				}
//
//				System.out.print("? ");
//			}
//			input.close();
//
//			// write AccountList's XML to output
//			JAXB.marshal(accounts, output); 
//		}
//		catch (IOException ioException)
//		{
//			System.err.println("Error opening file. Terminating.");
//		}
	} // end method main

} // end class CreateFiles
