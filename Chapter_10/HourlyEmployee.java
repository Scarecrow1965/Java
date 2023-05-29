// Exercise 10.13
/*(Payroll System Modification)
 Modify the payroll system of Figs. 10.4 – 10.9 to include private instance variable birthDate in class Employee.
 Use class Date of Fig.8.7 to represent an employee’s birthday.
 Add get methods to class Date. Assume that payroll is processed once per month.
 Create an array of Employee variables to store references to the various employee objects.
 In a loop, calculate the payroll for each Employee (polymorphically), and add a $100.00 bonus to the person’s
 payroll amount if the current month is the one in which the Employee’s birthday occurs.
*/

// Fig. 10.6: HourlyEmployee.java
// HourlyEmployee class extends Employee.

public class HourlyEmployee extends Employee
{
	private double wage; // wage per hour
	private double hours; // hours worked for week

	// constructor
	public HourlyEmployee(String firstName, String lastName,
			String socialSecurityNumber, double wage, double hours, Date birthDate) // from exercise 10.13 added birthDate
	{
		super(firstName, lastName, socialSecurityNumber, birthDate); // from exercise 10.13 added birthDate

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

	// return String representation of HourlyEmployee object
	@Override
	public String toString()
	{
		return String.format("hourly employee: %s%n%s: $%,.2f; %s: %,.2f",
				super.toString(), "hourly wage", getWage(), "hours worked", getHours());
	}
}
