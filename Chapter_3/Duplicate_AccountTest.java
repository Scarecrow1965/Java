// Exercise 3.15
// In this exercise, you’ll define a new displayAccount method that contains one copy of that output statement.

//Fig. 3.9: AccountTest.java
//Inputting and outputting floating-point numbers with Account objects.

import java.util.Scanner;

public class Duplicate_AccountTest
{
	public static void main(String[] args)
	{
		Duplicate_Account account1 = new Duplicate_Account("Jane Green", 50.00);
		// new stores Account object and calls the constructor Account to initialize the object which will be the object's name
		Duplicate_Account account2 = new Duplicate_Account("John Blue", -7.53);
		// new stores Account object and calls the constructor Account to initialize the object which will be the object's name
	   
		// display initial balance of each object
//	   	System.out.printf("%s balance: $%.2f%n", account1.getName(), account1.getBalance()); 
//	   	System.out.printf("%s balance: $%.2f%n%n", account2.getName(), account2.getBalance()); 
		displayAccount(account1);
		displayAccount(account2);

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

	   // This section is for depositing amounts
	   System.out.print("Enter deposit amount for account1: "); // prompt
	   double depositAmount = input.nextDouble(); // obtain user input
	   System.out.printf("%nadding %.2f to account1 balance%n%n", 
			   depositAmount);
	   account1.deposit(depositAmount); // add to account1's balance

	   // display balances
//	   System.out.printf("%s balance: $%.2f%n", account1.getName(), account1.getBalance()); 
//	   System.out.printf("%s balance: $%.2f%n%n", account2.getName(), account2.getBalance()); 
	   displayAccount(account1);
	   displayAccount(account2);
		   
	   System.out.print("Enter deposit amount for account2: "); // prompt
	   depositAmount = input.nextDouble(); // obtain user input
	   System.out.printf("%nadding %.2f to account2 balance%n%n", 
			   depositAmount);
	   account2.deposit(depositAmount); // add to account2 balance

	   // display balances
//	   System.out.printf("%s balance: $%.2f%n", account1.getName(), account1.getBalance()); 
//	   System.out.printf("%s balance: $%.2f%n%n", account2.getName(), account2.getBalance());
	   displayAccount(account1);
	   displayAccount(account2);
	   
	} // end method main

	// displays accountToDisplay name and balance
	public static void displayAccount(Duplicate_Account accountToDisplay)
	{
      // place the statement that displays
      // accountToDisplay's name and balance here
		System.out.printf("%s balance: $%.2f%n", accountToDisplay.getName(), accountToDisplay.getBalance()); 
	} // end method displayAccount

} // end class AccountTest
