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

public class CreditLimitCalculator
{
		// initializing variables
		int accountNumber;
		int begBalance;
		int itemCharged;
		int totalCredits;
		int creditLimit;
		int newBalance;

	// constructor
	public CreditLimitCalculator(int accountNumber, int begBalance, int itemCharged, int totalCredits, int creditLimit, int newBalance)
	{
		this.accountNumber = accountNumber;
		this.begBalance = begBalance;
		this.itemCharged = itemCharged;
		this.totalCredits = totalCredits;
		this.creditLimit = creditLimit;
		this.newBalance = newBalance;
	} // end constructor
	
	// method setAccountNumber
	public void setAccountNumber(int accountNumber)
	{
		this.accountNumber = accountNumber;
	} // end method setAccountNumber
	
	// method getAccountNumber
	public int getAccountNumber()
	{
		return accountNumber;
	} // end method getAccountNumber
	
	// method setBegBalance
	public void setBegBalance(int begBalance)
	{
		this.begBalance = begBalance;
	} // end method setBegBalance
	
	// method getBegBalance
	public int getBegBalance()
	{
		return begBalance;
	} // end method getBegBalance
	
	// method setItemCharged
	public void setItemCharged(int itemCharged)
	{
		this.itemCharged = itemCharged;
	} // end method setItemCharged
	
	// method getItemCharged
	public int getItemChgarged()
	{
		return itemCharged;
	} // end method getItemCharged
	
	// method setTotalCredits
	public void setTotalCredits(int totalCredits)
	{
		this.totalCredits = totalCredits;
	} // end method setTotalCredits
	
	// method getTotalCredits
	public int getTotalCredits()
	{
		return totalCredits;
	} // end method getTotalCredits
	
	// method setCreditLimit
	public void setCreditLimit( int creditLimit)
	{
		this.creditLimit = creditLimit;
	} // end method getCreditLimit
	
	// method getCreditLimit
	public int getCreditLimit()
	{
		return creditLimit; 
	} // end method getCreditLimit
	
	// method getNewBalance
	public int getNewBalance()
	{
		newBalance = begBalance + itemCharged - totalCredits;
		return newBalance;
	}// end method getNewBalance
	
} // end class CreditLimitCalculator
