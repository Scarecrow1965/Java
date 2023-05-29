// Exercise 3.11
// Modify class Account (Fig.3.8) to provide a method called withdraw that
// withdraws money from an Account. Ensure that the withdrawal amount does
// not exceed the Account’s balance. If it does, the balance should be left
// unchanged and the method should print a message indicating "Withdrawal
// amount exceeded account balance." Modify class AccountTest (Fig.3.9)
// to test method withdraw.
// 

public class Modified_Account
//access modifier public
{
	// initializing parameters 
	private String name; // instance variable where name is a string
	//access modifier private
	private double balance; // instance variable where variable balance is of double
	//  access modifier private

	// constructor initializes name with parameter name
	// constructor name is class name
	// constructors CANNOT return values
	// Account constructor that receives two parameters
	public Modified_Account(String name, double balance)
	// access modifier public
	{
		this.name = name; // assign name to instance variable name

		// validate that the balance is greater than 0.0; if it's not,
		// instance variable balance keeps its default initial value of 0.0
		if (balance > 0.0)
		{ // if the balance is valid
			this.balance = balance; // assign it to instance variable balance
		}
	} // end constructor Account

	// method that deposits (adds) only a valid amount to the balance
	public void deposit(double depositAmount)
	// access modifier public
	{
		if (depositAmount > 0.0)// if the depositAmount is valid
		{ 
			balance = balance + depositAmount; // add it to the balance
		}
	} // end method deposit

	// exercise 3.11
	// method that withdraws (removes) only a valid amount from the balance
	public void withdraw(double withdrawAmount)
	// access modifier public
	{
		//Ali Moussa recommends
		if (withdrawAmount > balance)
		{
			System.out.println("Withdrawal amount amount exceeded account balance.");
		}

		// my Version
		if (withdrawAmount <= balance)// if the depositAmount is valid
		{ 
			balance = balance - withdrawAmount; // removes it to the balance
		}
		System.out.println("Withdraw amount exceeded account balance."); 
	} // end method withdraw
	
	// method to return the account balance
	public double getBalance()
	// access modifier public
	{
		return balance;
	} // end method getBalance

	// method to set the name in the object
	public void setName(String name)
	// method setName created/instantiated, also method header, parameter list is String name
	// access modifier public
	{
		this.name = name; // store the name
	} // end method setName 

	// method that returns the name
	public String getName()
	// method getName is created/instantiated, also method header, parameter list is (blank)
	// access modifier public
	{
		return name; // return value of name to caller
	} // end method getName
	
} // end class Account