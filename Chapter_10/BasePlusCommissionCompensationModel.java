// Exercise 10.17
/* (Recommended Project: Combining Composition and Inheritance )
Exercise 9.16 asked you to remodel Chapter 9’s CommissionEmployee–BasePlusCommissionEmployee inheritance
hierarchy as a class Employee in which each Employee has a different CompensationModel object.
In this exercise, reimplement Exercise 9.16 ’s CompensationModel class as an interface that provides
a public abstract method earnings that receives no parameters and returns a double.
Then create the following classes that implement interface CompensationModel:
1. SalariedCompensationModel—For Employees who are paid a fixed weekly salary,
 this class should contain a weeklySalary instance variable,
 and should implement method earnings to return the weeklySalary.
2. HourlyCompensationModel—For Employees who are paid by the hour and receive overtime pay
 for all hours worked in excess of 40 hours per week,
 this class should contain wage and hours instance variables,
 and should implement method earnings based on the number of hours worked
 (see class HourlyEmployee’s earnings method in Fig. 10.6 ).
3. CommissionCompensationModel—For Employees who are paid by commission,
 this class should contain grossSales and commissionRate instance variables,
 and should implement method earnings to return grossSales * commissionRate.
4. BasePlusCommissionCompensationModel—For Employees who are paid a base salary and commission,
 this class should contain instance variables grossSales,
 commission-Rate and baseSalary and should implement earnings to return baseSalary + gross-Sales * commissionRate.
In your test application, create Employee objects with each of the CompensationModels described above,
then display each Employee’s earnings.
Next, change each Employee’s CompensationModel dynamically and redisplay each Employee’s earnings.
*/

// taken from Exercise 10.16

public class BasePlusCommissionCompensationModel extends CommissionCompensationModel
{
	private double baseSalary; // base salary per week

	// constructor
	public BasePlusCommissionCompensationModel(double grossSales, double commissionRate, double baseSalary)
	{
		super(grossSales, commissionRate);

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

	public double payIncrease()
	{
		return baseSalary += getBaseSalary() * 0.1; // equal to 10% of base Salary
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
		return String.format("%s$%,.2f; %s%.2f; %s$%,.2f%n%s$%,.2f",
				"Gross sales: ", getGrossSales(),
				"Commission Rate: ", getCommissionRate(),
				"Base Salary: ", getBaseSalary(),
				"new base salary with 10% increase is:", payIncrease());
	}

} // end class BasePlusCommissionCompensationModel
