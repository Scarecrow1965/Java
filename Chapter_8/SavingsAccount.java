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

public class SavingsAccount
{
	// initializing variables
	static double annualInterestRate = 0; // to be used for all account users
	private double savingsBalance; // to be used indicating the amount the user currently has on deposit
	private String member;

	public SavingsAccount(String member, double savingsBalance)
	{
		this.member = member;
		this.savingsBalance = savingsBalance;
	}

	public void SetMember(String member)
	{
		this.member = member;
	}
	
	public String GetMember()
	{
		return member;
	}
	
	public void SetSavingsBalance(double savingsBalance)
	{
		this.savingsBalance = savingsBalance;
	}
	
	public double GetSavingsBalance()
	{
		return savingsBalance;
	}
	
	public static void SetAnnualInterestRate(double newannualInterestRate)
	{
		annualInterestRate = newannualInterestRate;
	}
	
	public double GetAnnualInterestRate()
	{
		return annualInterestRate;
	}
	
	// method calculateMonthlyInterest
	public void calculateMonthlyInterest()
	{
		//formula savings_Balance =savingsBalance * annualInterestRate / 12;
		savingsBalance += savingsBalance * (annualInterestRate / 12);
	}

	// static method modifyInterestRate
	public static void modifyInterestRate(double newvalue)
	{
		// formula annualInterestRate = newvalue;
		annualInterestRate = newvalue;
	}

	public String toString()
	{
		return String.format("$%.02f", savingsBalance);
	}
	
} // end class Savings Account
