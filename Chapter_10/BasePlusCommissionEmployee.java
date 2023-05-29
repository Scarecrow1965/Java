// Exercise 10.13
/*(Payroll System Modification)
 Modify the payroll system of Figs. 10.4 – 10.9 to include private instance variable birthDate in class Employee.
 Use class Date of Fig.8.7 to represent an employee’s birthday.
 Add get methods to class Date. Assume that payroll is processed once per month.
 Create an array of Employee variables to store references to the various employee objects.
 In a loop, calculate the payroll for each Employee (polymorphically), and add a $100.00 bonus to the person’s
 payroll amount if the current month is the one in which the Employee’s birthday occurs.
*/

// Fig. 10.8: BasePlusCommissionEmployee.java
// BasePlusCommissionEmployee class extends CommissionEmployee.

public class BasePlusCommissionEmployee extends CommissionEmployee
{
	private double baseSalary; // base salary per week

	// constructor
	public BasePlusCommissionEmployee(String firstName, String lastName, 
			String socialSecurityNumber, double grossSales,
			double commissionRate, double baseSalary, Date birthDate) // from exercise 10.13 added birthDate
	{
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate, birthDate); // from exercise 10.13 added birthDate

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

	// return String representation of BasePlusCommissionEmployee object
	@Override
	public String toString()
	{
		return String.format("%s %s; %s: $%,.2f", "base-salaried",
				super.toString(), "base salary", getBaseSalary());
	}
} 
