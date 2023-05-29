// Exercise 3.11
// Modify class Account (Fig.3.8) to provide a method called withdraw that
// withdraws money from an Account. Ensure that the withdrawal amount does
// not exceed the Account’s balance. If it does, the balance should be left
// unchanged and the method should print a message indicating "Withdrawal
// amount exceeded account balance." Modify class AccountTest (Fig.3.9)
// to test method withdraw.
// 

//Fig. 3.9: AccountTest.java
//Inputting and outputting floating-point numbers with Account objects.

import java.util.Scanner;

public class Modified_AccountTest
{
	public static void main(String[] args)
	{
	   Modified_Account account1 = new Modified_Account("Jane Green", 50.00);
	   // new stores Account object and calls the constructor Account to initialize the object which will be the object's name
	   Modified_Account account2 = new Modified_Account("John Blue", -7.53); 
	   // new stores Account object and calls the constructor Account to initialize the object which will be the object's name
	   
	   // display initial balance of each object
	   System.out.printf("%s balance: $%.2f%n",
			   account1.getName(), account1.getBalance()); 
	   System.out.printf("%s balance: $%.2f%n%n",
			   account2.getName(), account2.getBalance()); 

	   // create a Scanner to obtain input from the command window
	   Scanner input = new Scanner(System.in);

	   // from Fig 3.2
	   // display initial value of name (null)
	   // System.out.printf("Initial name is: %s%n%n", myAccount.getName());

	   // prompt for and read name
	   // System.out.println("Please enter the name:");
	   // String theName = input.nextLine(); // read a line of text
	   // myAccount.setName(theName); // put theName in myAccount
	   // System.out.println(); // outputs a blank line

	   // display the name stored in object myAccount
	   // System.out.printf("Name in object myAccount is:%n%s%n",
			   // myAccount.getName());
   
	   //
	   //This section is for depositing amounts to accounts
	   //
	   System.out.print("Enter deposit amount for account1: "); // prompt
	   double depositAmount = input.nextDouble(); // obtain user input
	   System.out.printf("%nadding %.2f to account1 balance%n%n", 
			   depositAmount);
	   account1.deposit(depositAmount); // add to account1's balance

	   // display balances
	   System.out.printf("%s balance: $%.2f%n",
			   account1.getName(), account1.getBalance()); 
	   System.out.printf("%s balance: $%.2f%n%n",
			   account2.getName(), account2.getBalance()); 

	   System.out.print("Enter deposit amount for account2: "); // prompt
	   depositAmount = input.nextDouble(); // obtain user input
	   System.out.printf("%nadding %.2f to account2 balance%n%n", 
			   depositAmount);
	   account2.deposit(depositAmount); // add to account2 balance
   	   
	   // display balances
	   System.out.printf("%s balance: $%.2f%n", 
			   account1.getName(), account1.getBalance()); 
	   System.out.printf("%s balance: $%.2f%n%n",
			   account2.getName(), account2.getBalance()); 

	   //
	   // This section is for withdrawing amounts to accounts
	   //
	   System.out.print("Enter withdraw amount for account1: "); // prompt
	   double withdrawAmount = input.nextDouble(); // obtain user input
	   System.out.printf("%nremoving %.2f to account1 balance%n%n", 
			   withdrawAmount);
	   account1.withdraw(withdrawAmount); // add to account1's balance

	   // display balances
	   System.out.printf("%s balance: $%.2f%n",
			   account1.getName(), account1.getBalance()); 
	   System.out.printf("%s balance: $%.2f%n%n",
			   account2.getName(), account2.getBalance()); 

	   System.out.print("Enter withdraw amount for account2: "); // prompt
	   withdrawAmount = input.nextDouble(); // obtain user input
	   System.out.printf("%nremoving %.2f to account2 balance%n%n", 
			   withdrawAmount);
	   account2.withdraw(withdrawAmount); // add to account2 balance
   	   
	   // display balances
	   System.out.printf("%s balance: $%.2f%n", 
			   account1.getName(), account1.getBalance()); 
	   System.out.printf("%s balance: $%.2f%n%n",
			   account2.getName(), account2.getBalance()); 

	} // end method main

} // end class Modified_AccountTest