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

// Using Fig. 15.8: CreditInquiry.java
// This program reads a file sequentially and displays the
// contents based on the type of account the user requests 
// (credit balance, debit balance or zero balance).

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

import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BankInquiry
{
	// initializing variables
	private final static MenuOption[] choices = MenuOption.values();
	// main path's to the files

	// for exercise 15.4
//	private static final Path inputOldMaster = Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\15-4_4 new files created\\oldmast.txt");
//	private static final Path inputTransaction = Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\15-4_4 new files created\\trans.txt");
//	private static final Path outputNewMaster = Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\15-4_4 new files created\\newmast.txt");
//	private static final Path logFile = Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\15-4_4 new files created\\log.txt");
	// for exercise 15.5:
	private static final Path inputOldMaster = Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\15-4_5 new files created\\oldmast.txt");
	private static final Path inputTransaction = Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\15-4_5 new files created\\trans.txt");
	private static final Path outputNewMaster = Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\15-4_5 new files created\\newmast.txt");
	private static final Path logFile = Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\15-4_5 new files created\\log.txt");
	
	// link to the Filematch.class file
	private static FileMatch filematch = new FileMatch();
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		// get user's request (e.g., zero, credit or debit balance)
		MenuOption actionType = getRequest(input);

		while (actionType != MenuOption.END_SESSION)
		{
			switch (actionType)
			{
			case START_OF_DAY_CHECK:
			{
				System.out.println("Good morning! Let's verify files first!");
				if(StartOfDayCheck())
					{
					System.out.println();
					System.out.println("All Files are ready to be used.");
					System.out.println();
					}
				else
				{
					System.out.println();
					System.out.println("There are problems with the files.");
					System.out.println();
				}
				break;
			}
			case ZERO_BALANCE:
			{
				System.out.printf("%nAccounts with zero balances:%n");
				readRecords(actionType);
				break;
			}
			case CREDIT_BALANCE:
			{
				System.out.printf("%nAccounts with credit balances:%n");
				readRecords(actionType);
				break;
			}
			case DEBIT_BALANCE:
			{
				System.out.printf("%nAccounts with debit balances:%n");
				readRecords(actionType);
				break;
			}
			case CREATE_ACCOUNT:
			{
				System.out.printf("%nCreating an account:%n");
				CreateAccount();
				break;
			}
			case CREATE_TRANSACTION:
			{
				System.out.printf("%nCreating a transaction:%n");
				CreateTransaction();
				break;
			}
			case END_OF_DAY_BACKUP:
			{
				System.out.println("Good day! Time to end the day right! Let's backup.");
				EndOfDayBackup();
				break;
			}
			default:
				break;
			} // end switch

			actionType = getRequest(input); // get user's request 
		} // end while
	} // end method main

	// obtain request from user
	private static MenuOption getRequest(Scanner input)
	{
		int request = 8;
		// display request options
		System.out.printf("%nEnter request%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n",
				" 1 - Start of the Day file check",
				" 2 - List accounts with zero balances",
				" 3 - List accounts with credit balances",
				" 4 - List accounts with debit balances",
				" 5 - Create Account",
				" 6 - Create Transaction",
				" 7 - End of Day Backup",
				" 8 - Terminate program");
		try
		{
			do // input user request
			{
				System.out.printf("%n? ");
				request = input.nextInt();
			}
			while ((request < 1) || (request > 8));
		} 
		catch (NoSuchElementException noSuchElementException)
		{
			System.err.println("Invalid input. Terminating.");
		}

		return choices[request - 1]; // return enum value for option
	}

	// read records from file and display only records of appropriate type
	private static void readRecords(MenuOption actionType)
	{
		// open file and process contents
		try (Scanner input = new Scanner(inputOldMaster))
		{
			while (input.hasNext()) // more data to read
			{
				int accountNumber = input.nextInt();
				String firstName = input.next();
				String lastName = input.next();
				double balance = input.nextDouble();

				// if proper account type, display record
				if (shouldDisplay(actionType, balance))
				{
					System.out.printf("%-10d%-12s%-12s%10.2f%n", accountNumber,
							firstName, lastName, balance);
				}
				else
				{
					input.nextLine(); // discard the rest of the current record
				}
			}
		}
		catch (NoSuchElementException | IllegalStateException | IOException e)
		{
			System.err.println("Error processing file. Terminating.");
			System.exit(1);
		}
	}

	// use record type to determine if record should be displayed
	private static boolean shouldDisplay(MenuOption option, double balance)
	{
		if ((option == MenuOption.CREDIT_BALANCE) && (balance < 0))
		{
			return true;
		}
		else if ((option == MenuOption.DEBIT_BALANCE) && (balance > 0))
		{
			return true;
		}
		else if ((option == MenuOption.ZERO_BALANCE) && (balance == 0))
		{
			return true;
		}
		return false;
	}

	private static void CreateAccount()
	{
		filematch.CreateOldMasterFile();
		filematch.validateLines(inputOldMaster);
	}

	private static void CreateTransaction()
	{
		filematch.CreateTransFile();
	}

	private static boolean StartOfDayCheck()
	{
		if(filematch.FileVerification(inputOldMaster, inputTransaction, outputNewMaster, logFile))
		{
			return true;
		}
		return false;
	}

	private static void EndOfDayBackup()
	{
		filematch.CreateNewMasterFile();
	}

} // end class AccountIquiry
