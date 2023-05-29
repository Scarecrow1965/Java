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

public class HourlyCompensationModel implements CompensationModel
{
	private double wage; // wage per hour
	private double hours; // hours worked for week

	// constructor
	public HourlyCompensationModel(double wage, double hours)
	{
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
		else // overtime
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
		return String.format("%s: $%,.2f; %s: %,.2f",
				"hourly wage", getWage(), "hours worked", getHours());
	}

} //end class 
