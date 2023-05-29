//Exercise 10.16
/* (Accounts Payable System Modification)
 In this exercise, we modify the accounts payable application of Figs. 10.11 – 10.14 to include
 the complete functionality of the payroll application of Figs. 10.4 – 10.9.
 The application should still process two Invoice objects, but now should process one object of each
 of the four Employee subclasses.
 If the object currently being processed is a BasePlusCommissionEmployee, the application should
 increase the BasePlusCommissionEmployee’s base salary by 10%.
 Finally, the application should output the payment amount for each object.
 Complete the following steps to create the new application:
1. Modify classes HourlyEmployee (Fig. 10.6 ) and CommissionEmployee (Fig. 10.7 )
 to place them in the Payable hierarchy as subclasses of the version of Employee (Fig. 10.13 )
 that implements Payable.
 [Hint: Change the name of method earnings to getPaymentAmount in each subclass so that the class
 satisfies its inherited contract with interface Payable.]
2. Modify class BasePlusCommissionEmployee (Fig. 10.8 ) such that it extends the version of class
CommissionEmployee created in part (a) <- or Part 1 of this exercise.
3. Modify PayableInterfaceTest (Fig. 10.14 ) to polymorphically process two Invoices,
 one SalariedEmployee, one HourlyEmployee, one CommissionEmployee and one BasePlusCommissionEmployee.
 First output a String representation of each Payable object.
 Next, if an object is a BasePlusCommissionEmployee, increase its base salary by 10%.
 Finally, output the payment amount for each Payable object.
*/

// Fig. 10.13: Employee.java
// Employee abstract superclass that implements Payable.

public abstract class Employee2 implements Payable2
{
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;

	// constructor
	public Employee2(String firstName, String lastName, 
			String socialSecurityNumber)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	}

	// return first name
	public String getFirstName()
	{
		return firstName;
	}

	// return last name
	public String getLastName()
	{
		return lastName;
	}

	// return social security number
	public String getSocialSecurityNumber()
	{
		return socialSecurityNumber;
	}

	// return String representation of Employee object
	@Override
	public String toString()
	{
		return String.format("%s %s%nsocial security number: %s",
				getFirstName(), getLastName(), getSocialSecurityNumber());
	}

	// abstract method must be overridden by concrete subclasses
	public abstract double earnings(); // no implementation here

	// implementing getPaymentAmount here enables the entire Employee
	// class hierarchy to be used in an app that processes Payables
	public double getPaymentAmount()
	{
		return earnings();
	}

} // end class Employee2
