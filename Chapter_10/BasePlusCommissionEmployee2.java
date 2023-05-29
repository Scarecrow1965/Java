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

// Fig. 10.8: BasePlusCommissionEmployee.java
// BasePlusCommissionEmployee class extends CommissionEmployee.

public class BasePlusCommissionEmployee2 extends CommissionEmployee2 implements Payable2 // added implements Payable2 as per Part 2 
{
	private double baseSalary; // base salary per week

	// constructor
	public BasePlusCommissionEmployee2(String firstName, String lastName, 
			String socialSecurityNumber, double grossSales,
			double commissionRate, double baseSalary)
	{
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);

		if (baseSalary < 0.0) // validate baseSalary
		{
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}

		this.baseSalary = baseSalary;
	}

	// set base salary
	public void setBaseSalary(double baseSalary)
	{
		if (baseSalary < 0.0) // validate baseSalary
		{
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}

		this.baseSalary = baseSalary;
	}

	// return base salary
	public double getBaseSalary()
	{
		return baseSalary;
	}

	// calculate earnings; override method earnings in CommissionEmployee
	@Override
	public double earnings() 
	{
		return getBaseSalary() + super.earnings();
	}

	// calculate earnings; override method earnings in CommissionEmployee
	@Override
	public double getPaymentAmount() // changed earnings to getPaymentAmount as per Part 1
	{
		return earnings();
	}

	// return String representation of BasePlusCommissionEmployee object
	@Override
	public String toString()
	{
		return String.format("%s %s; %s: $%,.2f", "base-salaried",
				super.toString(), "base salary", getBaseSalary());
	}

} // end class BasePlusCommissionEmployee2
