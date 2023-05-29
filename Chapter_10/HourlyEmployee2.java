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

// Fig. 10.6: HourlyEmployee.java
// HourlyEmployee class extends Employee.

public class HourlyEmployee2 extends Employee2 implements Payable2
{
	private double wage; // wage per hour
	private double hours; // hours worked for week

	// constructor
	public HourlyEmployee2(String firstName, String lastName,
			String socialSecurityNumber, double wage, double hours)
	{
		super(firstName, lastName, socialSecurityNumber);

		if (wage < 0.0)
		{ // validate wage
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");
		}

		if ((hours < 0.0) || (hours > 168.0)) // validate hours
		{
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
		}

		this.wage = wage;
		this.hours = hours;
	}

	// set wage
	public void setWage(double wage)
	{
		if (wage < 0.0) // validate wage
		{
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");
		}

		this.wage = wage;
	}

	// return wage
	public double getWage()
	{
		return wage;
	}

	// set hours worked
	public void setHours(double hours)
	{
		if ((hours < 0.0) || (hours > 168.0)) // validate hours
		{
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
		}

		this.hours = hours;
	}

	// return hours worked
	public double getHours()
	{
		return hours;
	}

	// calculate earnings; override abstract method earnings in Employee
	@Override
	public double earnings()
	{
		if (getHours() <= 40) // no overtime
		{
			return getWage() * getHours();
		}
		else
		{
			return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
		}
	}

	// calculate earnings; override abstract method earnings in Employee
	@Override
	public double getPaymentAmount() // replaced earnings with getPaymentAmount as per Part 1 
	{
		return earnings();
	}

	// return String representation of HourlyEmployee object
	@Override
	public String toString()
	{
		return String.format("hourly employee: %s%n%s: $%,.2f; %s: %,.2f",
				super.toString(), "hourly wage", getWage(), "hours worked", getHours());
	}

} // end class HourlyEmployee2
