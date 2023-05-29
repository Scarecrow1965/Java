// Exercise 8.6
/* (Savings Account Class)
 * Create class SavingsAccount.
 * Use a static variable annualInterestRate to store the annual interest rate for all account holders.
 * Each object of the class contains a private instance variable savingsBalance indicating the amount
 * the saver currently has on deposit.
 * Provide method calculateMonthlyInterest to calculate the monthly interest by multiplying the savingsBalance
 * by annualInterestRate divided by 12—this interest should be added to savings-Balance.
 * Provide a static method modifyInterestRate that sets the annualInterestRate to a new value.
 * Write a program to test class SavingsAccount.
 * Instantiate two savingsAccount objects, saver1 and saver2, with balances of $2000.00 and $3000.00, respectively.
 * Set annualInterestRate to 4%, then calculate the monthly interest for each of 12 months and print the new
 * balances for both savers.
 * Next, set the annualInterestRate to 5%, calculate the next month’s interest and print the new balances for both savers.
 */

import java.util.Scanner;

public class SavingsAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// initializing variables

		SavingsAccount saver1 = new SavingsAccount ("saver 1", 2000.00);
		SavingsAccount saver2 = new SavingsAccount ("saver 2", 3000.00);
		
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("This application will calculate and display the balance of each user.");
		
		SavingsAccount.SetAnnualInterestRate(.04);
		System.out.println("The current Annual Interest Rate is: 4.00%");
		
		System.out.printf("For:\t\t %s \t%s:%n", saver1.GetMember(), saver2.GetMember());
		for (int i = 1; i <= 12; i++)
		{
			System.out.printf("Month %2d is:\t %s \t%s%n", i, saver1.toString(), saver2.toString() );
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
		}
		System.out.println();
		
		SavingsAccount.modifyInterestRate(.05);
		System.out.println("The Annual Interest Rate has changed to: 5.00%");
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		
		System.out.printf("For\t%s \t%s:%n", saver1.GetMember(), saver2.GetMember());
		System.out.printf("Month: %s \t%s%n", saver1.toString(), saver2.toString() );

	}

}
