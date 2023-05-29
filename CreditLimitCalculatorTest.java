// Exercise 4.18
/* Develop a Java application that determines whether any of several department-store customers
 * has exceeded the credit limit on a charge account. For each customer, the following facts are available:
 * 1.	account number
 * 2.	balance at the beginning of the month
 * 3.	total of all items charged by the customer this month
 * 4.	total of all credits applied to the customer’s account this month
 * 5.	allowed credit limit.
 * The program should input all these facts as integers, calculate the new
 * balance (= beginning balance + charges – credits),
 * display the new balance and determine whether the new balance exceeds the customer’s credit limit.
 * For those customers whose credit limit is exceeded, the program should display the message "Credit limit exceeded".
 */

import java.util.Scanner;

public class CreditLimitCalculatorTest
{

	public static void main(String[] args)
	{
		// initiating customer
		CreditLimitCalculator customer = new CreditLimitCalculator(0, 0, 0, 0, 0, 0); 

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("This app calculates if the customer has overdrawn their credit card limit");
		System.out.print("Enter member's Account Number: \n"); // prompt 
	   	int accountNumber = input.nextInt(); // read miles driven from user
	   	customer.setAccountNumber(accountNumber); // sets member's account number
		 
	   	System.out.print("Enter member's Credit Limit: \n"); // prompt 
	   	int creditLimit = input.nextInt(); // read gallons used from user
	   	customer.setCreditLimit(creditLimit);
	   	
	   	System.out.print("Enter member's Beginning Balance: \n"); // prompt 
	   	int begBalance = input.nextInt(); // read gallons used from user
	   	customer.setBegBalance(begBalance); // sets member's beginning balance
	   	
	   	System.out.print("Enter member's Total Credits: \n"); // prompt 
	   	int totalCredits = input.nextInt(); // read gallons used from user
	   	customer.setTotalCredits(totalCredits);
	   	
	   	System.out.print("Enter item charged by the customer: \n"); // prompt 
	   	int itemCharged = input.nextInt(); // read gallons used from user
	   	customer.setItemCharged(itemCharged);
	   	
		if (customer.getNewBalance() > customer.getCreditLimit())
		{
			System.out.printf("The member's new balance is: %d%n", customer.getNewBalance());
			System.out.println("Credit Limit has been exceeded!");
		}
	   	System.out.printf("The member's new balance is: %d%n", customer.getNewBalance());
		
	} // end method main

} // end class CreditLimitCalculatorTest
