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
 * As transactions occur (i.e., sales are made and payments arrive in the mail),
 *  information about them is entered into a file.
 * At the end of each business period (a month for some companies, a week for others, and a day in some
 *  cases), the file of transactions (called "trans.txt") is applied to the master file (called
 *  "oldmast.txt") to update each account’s purchase and payment record.
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

// Exercise 15.5
/*(File Matching with Multiple Transactions)
 * It’s possible (and actually common) to have several transaction records with the same record key.
 * This situation occurs, for example, when a customer makes several purchases and cash payments
 * during a business period.
 * Rewrite your accounts receivable file-matching program from Exercise 15.4 to provide for the possibility
 * of handling several transaction records with the same record key.
 * Modify the test data of CreateData.java to include the additional transaction records in Fig. 15.18 .
 * Fig. 15.18
 * Account number	Dollar amount
 * 300	83.89
 * 700	80.78
 * 700	1.53
 * Additional transaction records. */

import java.util.Scanner;
import java.util.TreeMap;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.io.File;
//import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
//import java.io.FileNotFoundException;
import java.lang.SecurityException;
//import java.util.Formatter;
import java.util.NoSuchElementException;
import java.net.URI;

public class FileMatch
{
	// initializing variables

	// used for exercise 15.4 
	// private static Path inputOldMaster2 = Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\oldmast2.txt");
	// private static Path inputTransaction2 = Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\trans2.txt");
	//	private static Scanner inputTrans;

	// used for exercise 15.5
	public static Path inputOldMaster = Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\15-4_5 new files created\\oldmast.txt");
	public static Path inputTransaction = Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\15-4_5 new files created\\trans.txt");
	public static Path inputNewTrans = Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\newTrans.txt"); 
	//for reference only
	//public static Scanner inputOld ; // input oldmast (old master) file
	// public static Scanner inputTrans; // input trans (transaction) file
	// public static Formatter outputNewMast2; // output newmast2 (New Master) file
	// public static Formatter outputLogFile2; // output log (error Log) file
	// for Option #2
	// private static TransactionRecord trecord = new TransactionRecord();
	// private static Account account = new Account();

	// this method confirms if all files are in working order.
	protected static boolean FileVerification(Path inputOld, Path inputTrans, Path outputNew, Path outputLog)
	{
		// the following files need to be verified that they exist since they are the standard
//		// Scanner inputOldMaster = new Scanner(Paths.get("oldmast.txt"));
//		// Scanner inputTransaction = new Scanner(Paths.get("trans.txt"));
//		// Scanner outputNewMaster = new Scanner(Paths.get("newmast.txt"));
//		// Scanner outputLog = new Scanner(Paths.get("log.txt"));
		// Path inputOldMaster = Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\15-4_4 new files created\\oldmast.txt");
		// Path inputTransaction = Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\15-4_4 new files created\\trans.txt");
		// Path outputNewMaster = Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\15-4_4 new files created\\newmast.txt");
		// Path outputLog = Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\15-4_4 new files created\\log.txt");

		// need method to verify files
		//first is the oldmast file
		if (!fileVerify(inputOld)) // does the oldmast.txt exist?
		{
			System.out.println("The oldmaster file does not exist!!");
			return false;
		}
		else
		{
			// next we need to confirm if oldmast and newmast files have any bad lines
			if (!validateLines(inputOld)) // is it a valid format?
			{
				System.out.println("The oldmaster file is corrupted!!\nPlease repair it now!!");
				return false;
			}
		}
		// next is the trans file
		if (!fileVerify(inputTrans)) // does the trans.txt exist?
		{
			System.out.println("The transaction file does not exist!!");
			return false;
		}
		// last is the newmast file
		if (!fileVerify(outputNew)) // does the outmaster.txt exist?
		{
			System.out.println("The newmaster file does not exist!!");
			return false;
		}
		else
		{
			// next we need to confirm if oldmast and newmast files have any bad lines
			if (!validateLines(outputNew)) // is it a valid format?
			{
				System.out.println("The newmaster file is corrupted!!\nPlease repair it now!!");
				return false;
			}
		}
		if (!fileVerify(outputLog)) // does the log.txt exist?
		{
			System.out.println("The log file does not exist!!");
			return false;
		}
		return true;
	} // end FileMatching method

	// this method is used to confirm that the file exists
	public static boolean fileVerify(Path filename)
	{
		try
		{
			// first need to verify if file exists
			if (Files.exists(filename)) // if path exists, output info about it
			{
				// display file (or directory) information
				System.out.printf("%n%s exists%n", filename.getFileName());
				System.out.printf("%s a directory%n", Files.isDirectory(filename) ? "Is" : "Is not");
				System.out.printf("%s an absolute path%n", filename.isAbsolute() ? "Is" : "Is not");
				System.out.printf("Last modified: %s%n", Files.getLastModifiedTime(filename));
				System.out.printf("Size: %s%n", Files.size(filename));
				System.out.printf("Path: %s%n", filename);
				System.out.printf("Absolute path: %s%n", filename.toAbsolutePath());
				return true;
			}
			else // not file or directory, output error message
			{
				return false;
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return false;
	} // end fileVerify method

	// This will apply only to oldmast and newmast files
	public static boolean validateLines(Path filename) 
	{
		URI path = filename.toUri();
		// to print out the content of the file (this works)
		try (Scanner input = new Scanner(Paths.get(path)) )
		{
			System.out.printf("%-10s%-12s%-12s%10s%n", "Account", "First Name", "Last Name", "Balance");
			while (input.hasNext() ) // while there is more to read
			{
				// display record contents
				System.out.printf("%-10d%-12s%-12s%10.2f%n", input.nextInt(), input.next(), input.next(), input.nextDouble());
				// "-10d" means 10 digits left align and "10.2" means 10 digits and .02 digits right aligned
			}
			return true;
		}
		catch (IOException ioException)
		{
			System.err.println("Error opening file.");
			return false;
		}
		catch (NoSuchElementException | IllegalStateException e)
		{
			e.printStackTrace();
		}
		return false;
	} // end method validateLines

	// this method will only apply if entering data to create an old master file 
	public static void CreateOldMasterFile()
	{
		Scanner input = new Scanner(System.in);
		System.out.printf("%s%n%s%n? ", "Enter account number, first name, last name, and balance.", "Enter end-of-file indicator to end input.");
		// create new record/account
		Account record = new Account(input.nextInt(), input.next(), input.next(), input.nextDouble());
		try
		{
			Formatter outputOld2 = new Formatter("oldmast2.txt");
			while (input.hasNext()) // loop until end-of-file indicator
			{
				try
				{
					// add to oldmaster file
					outputOld2.format("%d %s %s %.2f%n", record.getAccountNumber(), record.getFirstName(), record.getLastName(), record.getBalance() );
				}
				catch (NoSuchElementException elementException)
				{
					System.err.println("Invalid Account input. Please try again.");
					input.nextLine(); // discard input so user can try again
				}
			}
			outputOld2.close();
		}
		catch (SecurityException | FileNotFoundException | FormatterClosedException e)
		{
			e.printStackTrace();
			System.exit(1); // terminate the program
		}
		input.close();
		
	} // end method CreateOldMasterFile

	// this method will only apply if entering data to create a transaction file
	public void CreateTransFile()
	{
		Scanner input = new Scanner(System.in);
		// get the info first
		Account record = new Account(); // will be removed if Account accountNumber does not work
		TransactionRecord transaction = new TransactionRecord(input.nextInt(),input.nextDouble() );
		try
		{
			Formatter outputTrans2 = new Formatter("trans2.txt");
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
			outputTrans2.close();
		}
		catch (SecurityException | FileNotFoundException | FormatterClosedException e)
		{
			e.printStackTrace();
		}
		input.close();
	} // end method CreateTransFile

	public void CreateNewMasterFile()
	{
		// for exercise 15.4 - this works. Ensure you use the log file from 15-4_4 new files created directory
//		try
//		{
//			URI path1 = inputOldMaster2.toUri();
//			URI path2 = inputTransaction2.toUri();
//			Scanner inputOld = new Scanner(Paths.get(path1) );
//			Scanner inputTrans = new Scanner(Paths.get(path2) );
//			Formatter outputNewMast2 = new Formatter("newmast2.txt");
//			// Scanner(Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\15-4_4 new files created\\newmast.txt"));
//			Formatter outputLogFile2 = new Formatter("log2.txt");
//			// Scanner(Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\15-4_4 new files created\\log.txt"));
//			// System.out.printf("Old Master File entry: %s%n", inputOldMaster2); // used for testing purposes only
//			// System.out.printf("Transaction entry : %s%n", inputTransaction2); // used for testing purposes only
//
//			while (inputOld.hasNext() ) // loop until end-of-file indicator
//			{
//				Account account = new Account(inputOld.nextInt(), inputOld.next(), inputOld.next(), inputOld.nextDouble());
//				TransactionRecord trecord = new TransactionRecord(inputTrans.nextInt(), inputTrans.nextDouble());
//				if(account.getAccountNumber() != trecord.getAccountNumber()) // account number in the transaction record is not the master
//				{
//					// then create an error log
//					System.out.println("Entry made into the Error Log File.");
//					System.out.printf("Account Number: %d entered%n", trecord.getAccountNumber() );
//					// output new record to file; assumes valid input
//					outputLogFile2.format("%s %d%n", "Unmatched transaction record for account number", trecord.getAccountNumber() );
//					outputNewMast2.format("%d %s %s %.2f%n", account.getAccountNumber(), account.getFirstName(), account.getLastName(), account.getBalance());
//				}
//				if(trecord.getAccountNumber() == account.getAccountNumber() )
//				{
//				System.out.println("Entry placed into the new Master File.");
//				// output new record to file; assumes valid input
//				outputNewMast2.format("%d %s %s %.2f%n", account.getAccountNumber(), account.getFirstName(), account.getLastName(), account.getBalance() + trecord.getTransaction() );
//				}
//				inputOld.nextLine();
//			} // end while for exercise 15.4
//			// for 15.4 . Keep lines below together
//			inputOld.close();
//			inputTrans.close();
//			outputNewMast2.close();
//			outputLogFile2.close();
//		} // end try
//		catch (NoSuchElementException elementException)
//		{
//			System.err.println("Invalid input. Please try again.");
//		}
//		catch (IOException | IllegalStateException e)
//		{
//			e.printStackTrace();
//		}
//		catch (SecurityException e)
//		{
//			e.printStackTrace();
//		}

		// for exercise 15.5 only
		// Part 1 - reconfiguration of Trans file
		try
		{
			// setting up the paths to scanner and formatter
			URI path2 = inputTransaction.toUri();
			Scanner inputTrans = new Scanner(Paths.get(path2) );
//			System.out.printf("Transaction entry : %s%n", inputTransaction); // used for testing purposes only

			List<TransactionRecord> trecord = new ArrayList<>(); // Stores Transaction Records information
			while (inputTrans.hasNext() ) // reading the Transaction file and loop until end-of-file indicator
			{
					// create new record
					TransactionRecord record = new TransactionRecord(inputTrans.nextInt(), inputTrans.nextDouble() );
//					System.out.printf("%d %.02f%n",record.getAccountNumber(), record.getTransaction() ) ; // used for testing purposes only
					//add record to the trecord ArrayList
					trecord.add(record);
			} // end while

			// now that all transactions are saved into an array (including the ones that are not linked to the old master file, let's combine them
			TreeMap<Integer, Double> trecord3 = new TreeMap<Integer, Double>(); // Stores totalTransaction Records information but in order
			int currentaccount = 0;
			for (int z = 0; z < trecord.size(); z++) // for looking into the transaction ArrayList
			{
				double totalTransactions = 0.0;
				currentaccount = trecord.get(z).getAccountNumber();
				for(int y = 0; y < trecord.size(); y++)
				{
					//System.out.printf("Transaction record looking at:%n%d %.02f%n", trecord.get(y).getAccountNumber(), trecord.get(y).getTransaction()); // used for testing purposes only
					if(trecord.get(y).getAccountNumber() == currentaccount && trecord.get(y).getTransaction() != 0)
					{
						totalTransactions += trecord.get(y).getTransaction();
					}
					trecord3.put(currentaccount, totalTransactions);
				}
			}
//			System.out.println("TreeMap results of trecord3"); // for confirmation purposes only
//			System.out.println(trecord3); // for confirmation purposes only

			ArrayList<Integer> transactionAccountList = new ArrayList<Integer>(trecord3.keySet()); // to get the information (account number) off the TreeMap and put it into an array
			ArrayList<Double> transactionTransactionvalue = new ArrayList<Double>(trecord3.values());// to get the information (total Transactions) off the TreeMap and put it into an array
//			System.out.println(transactionAccountList); // used for testing purposes only
//			System.out.println(transactionTransactionvalue); // used for testing purposes only
			List<TransactionRecord> trecord2 = new ArrayList<>();
			for(int i = 0; i < transactionAccountList.size(); i++) // to turn the TreeMap back into a TransactionRecord (using trecord2 as an individual constant)
			{
				TransactionRecord record = new TransactionRecord(transactionAccountList.get(i), transactionTransactionvalue.get(i) );
				// add to Transaction RecordList
				trecord2.add(record);
			}
//			System.out.println("trecord2 holds:"); // for confirmation purposes only
//			for(int i = 0; i < trecord2.size(); i++) // this displays the true contents of the transaction file ArrayList
//			{
//				System.out.printf("%d %.02f%n",trecord2.get(i).getAccountNumber(), trecord2.get(i).getTransaction() ) ;
//			}
//			System.out.println();

			// now that we have all the transactions in place, let's create a newTrans file
			// Part 2 - creation of newTrans file
			try
			{
				Formatter output = new Formatter("newTrans.txt");
				for(int i = 0 ; i < trecord2.size(); i++) // loop until end-of-file indicator
				{
					// output new record to file; assumes valid input
					output.format("%d %.2f%n", trecord2.get(i).getAccountNumber(), trecord2.get(i).getTransaction());
				}
				output.close();
			}
			catch (NoSuchElementException elementException)
			{
				System.err.println("Invalid input. Please try again.");
			}
			catch (SecurityException | FileNotFoundException | FormatterClosedException e)
			{
				e.printStackTrace();
				System.exit(1); // terminate the program
			}
			inputTrans.close();
		}// end try inputTrans reconfiguration
		catch (IOException | IllegalStateException e)
		{
			e.printStackTrace();
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
		}

		// Part 3 - reading both oldMast and new newTrans files and outputing newMast2 and Log2
		try
		{
			// setting up the paths to scanner and formatter
			URI path1 = inputOldMaster.toUri();
			URI path3 = inputNewTrans.toUri();
			Scanner inputOld = new Scanner(Paths.get(path1) );
			Scanner inputTrans = new Scanner(Paths.get(path3) );
			// System.out.printf("Old Master File entry: %s%n", inputOldMaster); // used for testing purposes only
			// System.out.printf("New Transaction File entry: %s%n", inputNewTrans); // used for testing purposes only
			Formatter outputNewMast2 = new Formatter("newmast2.txt");
			Formatter outputLogFile2 = new Formatter("log2.txt");

			List<Account> accounts = new ArrayList<>();
			List<TransactionRecord> newTrans = new ArrayList<>();
			
			while (inputOld.hasNext() )
			{
				Account account = new Account(inputOld.nextInt(), inputOld.next(), inputOld.next(), inputOld.nextDouble());
				accounts.add(account);
			}
			
			while (inputTrans.hasNext() ) // loop until end-of-file indicator
			{
				TransactionRecord Trans = new TransactionRecord(inputTrans.nextInt(), inputTrans.nextDouble());
				newTrans.add(Trans);
			}
			
			for(int i = 0; i < newTrans.size(); i++)
			{
				try
				{
				System.out.printf("Transaction accounts # %d%n", newTrans.get(i).getAccountNumber());
				System.out.printf("currentaccount # %d%n", accounts.get(i).getAccountNumber());

				while(newTrans.get(i).getAccountNumber() == accounts.get(i).getAccountNumber() )
				{
					System.out.println("Entry placed into the new Master File.");
					// output new record to file; assumes valid input
//					System.out.printf("%d %s %s %.2f%n", accounts.get(i).getAccountNumber(), accounts.get(i).getFirstName(),
//	\						accounts.get(i).getLastName(), accounts.get(i).getBalance() + newTrans.get(i).getTransaction() ); // for confirmation purposes only
					outputNewMast2.format("%d %s %s %.2f%n", accounts.get(i).getAccountNumber(), accounts.get(i).getFirstName(), accounts.get(i).getLastName(),
							accounts.get(i).getBalance() + newTrans.get(i).getTransaction() );
					i++;
				}

				if(newTrans.get(i).getAccountNumber() < accounts.get(i).getAccountNumber() ) // account number in the transaction record is not the master
				{
					// then create an error log
					System.out.println("Entry made into the Error Log File.");
//					// System.out.printf("Account Number: %d entered%n", newTrans.get(i).getAccountNumber() ); // for confirmation purposes only
					// output new record to file; assumes valid input
//					System.out.printf("%s %d%n", "Unmatched transaction record for account number", newTrans.get(i).getAccountNumber() ); // for confirmation purposes only
					outputLogFile2.format("%s %d%n", "Unmatched transaction record for account number", newTrans.get(i).getAccountNumber() );
//					System.out.printf("%d %s %s %.2f%n", accounts.get(i).getAccountNumber(), accounts.get(i).getFirstName(), accounts.get(i).getLastName(),
//							accounts.get(i).getBalance()); // for confirmation purposes only
					outputNewMast2.format("%d %s %s %.2f%n", accounts.get(i).getAccountNumber(), accounts.get(i).getFirstName(), accounts.get(i).getLastName(),
							accounts.get(i).getBalance());
				}
//					if(newTrans.get(i).getAccountNumber() > accounts.get(i).getAccountNumber() ) 
//					{
//						System.out.println("Entry made into the Error Log File.");
//						System.out.printf("Account Number: %d entered%n", newTrans.get(i).getAccountNumber() );
//						// output new record to file; assumes valid input
//						outputLogFile2.format("%s %d%n", "Unmatched transaction record for account number", newTrans.get(i).getAccountNumber() );
//					}
				}
				catch (IndexOutOfBoundsException e)
				{
					System.out.println("Entry made into the Error Log File.");
					System.out.printf("Account Number: %d entered%n", newTrans.get(i).getAccountNumber() );
					// output new record to file; assumes valid input
					outputLogFile2.format("%s %d%n", "Unmatched transaction record for account number", newTrans.get(i).getAccountNumber() );
				}
			}

			inputOld.close();
			inputTrans.close();
			outputNewMast2.close();
			outputLogFile2.close();
		} // end try with newTrans file

		catch (NoSuchElementException e)
		{
			e.printStackTrace();
		}
		catch (SecurityException | FileNotFoundException | FormatterClosedException e)
		{
			e.printStackTrace();
			System.exit(1); // terminate the program
		}
		catch (IOException | IllegalStateException e)
		{
			e.printStackTrace();
		}

	} // end method CreateNewMasterFile

//	public static void main(String[] args)
//	{
//		// information taken from exercise 15.2's answers
//		// Scanner oldmastInput = new Scanner(Paths.get("oldmast.txt"));.
//		// Scanner inTransaction = new Scanner(Paths.get("trans.txt"));.
//		// Formatter outNewMaster = new Formatter("newmast.txt");.
//		// transaction.setAccount(inTransaction.nextInt());
//		// transaction.setAmount(inTransaction.nextDouble());
//
//		// create a Scanner to obtain input from the command window
//		// Scanner input = new Scanner(System.in);
//		// create Path object based on user input
//		// Path path = Paths.get(input.nextLine());
//
//		// Scanner inputOldMaster = new Scanner(Paths.get("oldmast.txt"));
//		// replaced line above for current location of file
//		Path inputOldMaster = Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\15-4_4 new files created\\oldmast.txt");
//		// Scanner inputTransaction = new Scanner(Paths.get("trans.txt"));
//		// replaced line above for current location of file
//		Path inputTransaction = Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\15-4_4 new files created\\trans.txt");
//
//		// need to verify if newmast file is correct
//		Path outputNewMaster = Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\15-4_4 new files created\\newmast.txt");
//		// replaced line above for current location of file
//		
//		// Scanner inputTransaction = new Scanner(Paths.get("trans.txt"));
//		// replaced line above for current location of file
//		Path logFile = Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\15-4_4 new files created\\log.txt");
//
//
//		// this line below is used to confirm and test all files for data integrity
//		FileVerification(inputOldMaster, inputTransaction, outputNewMaster, logFile);
////		openFiles();
////		closeFiles();
//
//	} // end method main

	// useful ideas
	// Pattern regexp = Pattern.compile("^\\d\\t\\w\\w\\t\\d+"); // to coincide with 100 Alan Jones 348.17
	// line.matches("[0-9]\\d{10}\\s\\w\\s\\w\\s[1-9]\\d{10}.\\d{2}"); // to coincide with 100 Alan Jones 348.17
	// create a conditional operator for any accounts that haven't changed.
	// condition ? if true then expression 1 : if false then expression 2
	// return String.format("%03d %s %s %s.2f%n", (record2.getAccountNumber() == record1.getAccountNumber())  ? record1.getAccountNumber(), record1.getFirstName(), record1.getLastName(), record1.getBalance() + record2.getTransaction() : record1.getAccountNumber(), record1.getFirstName(), record1.getLastName(), record1.getBalance() );

	// if I wanted to convert the accounts into an ArrayList, I would use the following after I initialize the scanners:
	//	List<Account> accounts = new ArrayList<>(); // stores Accounts information
	////System.out.println("accounts List:"); // used for testing purposes only
	//while (inputOld.hasNext() ) // reading the Old master file and loop until end-of-file indicator
	//{
	//	try
	//	{
	//		// create new record
	//		Account account = new Account(inputOld.nextInt(), inputOld.next(), inputOld.next(), inputOld.nextDouble());
	////		System.out.printf("%d %s %s %.02f%n", account.getAccountNumber(), account.getFirstName(), account.getLastName(), account.getBalance() ); // used for testing purposes only
	//		// add account to the accounts ArrayList
	//		accounts.add(account);
	//	}
	//	catch (NoSuchElementException elementException)
	//	{
	//		inputOld.nextLine();
	//	}
	//} // end while
	//System.out.println();
	//// now all file content of Old master is inside accounts ArrayList
	//// The following commented lines are kept here for referencing
	//System.out.println(accounts); // This displays only memory location of accounts ArrayList contents
	//for(int i = 0; i< accounts.size(); i++) // is the same as the stream statement; only displays memory allocations
	//{
	//	System.out.println(accounts.get(i));
	//}
	//accounts.stream().forEach(System.out::println); // is the same as the for loop
	//System.out.println();
	//System.out.println("accounts ArrayList");
	//for(int i = 0; i < accounts.size(); i++) // this displays the true contents of the Old Master file ArrayList // for confirmation purposes only
	//{
	//System.out.printf("%d %s %s %.02f%n", accounts.get(i).getAccountNumber(), accounts.get(i).getFirstName(), accounts.get(i).getLastName(), accounts.get(i).getBalance() ) ;
	//}
	//System.out.println();

	// here's another idea
//	// create oldmast and newmast files
//	public void CreateNewMasterFile(Path filename) // This will apply only to oldmast and newmast files
//	{
//		try
//		{
//			Scanner inputOld = new Scanner(Paths.get("oldmast.txt"));
//			Formatter outNew = new Formatter("newmast.txt");
//			// Scanner(Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\15-4_4 new files created\\oldmast.txt"));
//			// Formatter(Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\15-4_4 new files created\\newmast.txt"));
//			// header for the display record contents
//			// System.out.printf("%-10s%-12s%-12s%10s%n", "Account Number", "First Name", "Last Name", "Balance");
//			while (inputOld.hasNext() ) // while there is more to read
//			{
//				account = new Account(inputOld.nextInt(), inputOld.next(), inputOld.next(), inputOld.nextDouble());
//				// display record contents
//				// System.out.printf("%-10d%-12s%-12s%10.2f%n", input.nextInt(), input.next(), input.next(), input.nextDouble());
//				// "-10d" means 10 digits left align and "10.2" means 10 digits and .02 digits right aligned
//				outNew.format("%d %s %s %.2f%n", account.getAccountNumber(), account.getFirstName(), account.getLastName(), account.getBalance() );
//			}
//		}
//		catch (IOException | NoSuchElementException | IllegalStateException e)
//		{
//			e.printStackTrace();
//		}
//	} // end method validateLines2

} // end class FileMatch
