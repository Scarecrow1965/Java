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

// Fig. 10.5: SalariedEmployee.java
// SalariedEmployee concrete class extends abstract class Employee.

public class SalariedEmployee2 extends Employee2 implements Payable2 // added implements Payable2 as Part 1
{
	private double weeklySalary;

	// constructor
	public SalariedEmployee2(String firstName, String lastName, 
			String socialSecurityNumber, double weeklySalary)
	{
		super(firstName, lastName, socialSecurityNumber);

		if (weeklySalary < 0.0)
		{
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");
		}

		this.weeklySalary = weeklySalary;
	}

	// set salary
	public void setWeeklySalary(double weeklySalary)
	{
		if (weeklySalary < 0.0)
		{
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");
		}

		this.weeklySalary = weeklySalary;
	}

	// return salary
	public double getWeeklySalary()
	{
		return weeklySalary;
	}

	// calculate earnings; override abstract method earnings in Employee
	@Override
	public double earnings()
	{
		return getWeeklySalary();
	}

	// return String representation of SalariedEmployee object
	@Override
	public String toString()
	{
		return String.format("salaried employee: %s%n%s: $%,.2f",
				super.toString(), "weekly salary", getWeeklySalary());
	}

} // end class SalariedEmployee2 
