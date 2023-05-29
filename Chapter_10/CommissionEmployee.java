// Exercise 10.13
/*(Payroll System Modification)
 Modify the payroll system of Figs. 10.4 – 10.9 to include private instance variable birthDate in class Employee.
 Use class Date of Fig.8.7 to represent an employee’s birthday.
 Add get methods to class Date. Assume that payroll is processed once per month.
 Create an array of Employee variables to store references to the various employee objects.
 In a loop, calculate the payroll for each Employee (polymorphically), and add a $100.00 bonus to the person’s
 payroll amount if the current month is the one in which the Employee’s birthday occurs.
*/

// Fig. 10.7: CommissionEmployee.java
// CommissionEmployee class extends Employee.

public class CommissionEmployee extends Employee
{
	private double grossSales; // gross weekly sales
	private double commissionRate; // commission percentage

	// constructor
	public CommissionEmployee(String firstName, String lastName, 
			String socialSecurityNumber,double grossSales, 
			double commissionRate, Date birthDate) // from exercise 10.13 added birthDate
	{
		super(firstName, lastName, socialSecurityNumber, birthDate); // from exercise 10.13 added birthDate

		if (commissionRate <= 0.0 || commissionRate >= 1.0) // validate 
		{
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}

		if (grossSales < 0.0) // validate
		{
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}

		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}

	// set gross sales amount
	public void setGrossSales(double grossSales)
	{
		if (grossSales < 0.0) // validate
		{
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}

		this.grossSales = grossSales;
	}

	// return gross sales amount
	public double getGrossSales()
	{
		return grossSales;
	}

	// set commission rate
	public void setCommissionRate(double commissionRate)
	{
		if (commissionRate <= 0.0 || commissionRate >= 1.0) // validate
		{
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}

		this.commissionRate = commissionRate;
	}

	// return commission rate
	public double getCommissionRate()
	{
		return commissionRate;
	}

	// calculate earnings; override abstract method earnings in Employee
	@Override
	public double earnings()
	{
		return getCommissionRate() * getGrossSales();
	}

	// return String representation of CommissionEmployee object
	@Override
	public String toString()
	{
		return String.format("%s: %s%n%s: $%,.2f; %s: %.2f", "commission employee",
				super.toString(), "gross sales", getGrossSales(), "commission rate", getCommissionRate());
	}
}
