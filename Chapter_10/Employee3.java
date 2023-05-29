// Exercise 10.17 and Exercise 10.18
// exercise 10.17
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

// Exercise 10.18
/*(Recommended Project: Implementing the Payable Interface)
 Modify class Employee3 from Exercise 10.17 so that it implements the Payable2 interface of Fig. 10.11.
 Replace the Salaried-Employee objects in the application of Fig. 10.14 with the Employee objects from Exercise 10.17
 and demonstrate processing the Employee and Invoice objects polymorphically.
*/

// taken from Exercise 10.16
public class Employee3 implements Payable2, CompensationModel
{
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	private CompensationModel compensationmodel;

	// constructor
	public Employee3(String firstName, String lastName, 
			String socialSecurityNumber, CompensationModel compensation)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.compensationmodel = compensation;
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

	// for exercise 10.17
	public void setCompensation(CompensationModel compensation)
	{
		compensationmodel = compensation; 
	}

	public double earnings()
	{
		return compensationmodel.earnings();
	}

	// implementing getPaymentAmount here enables the entire Employee
	// class hierarchy to be used in an app that processes Payables
	public double getPaymentAmount()
	{
		return earnings();
	}

	// return String representation of Employee object
	@Override
	public String toString()
	{
		return String.format("%s %s%nsocial security number: %s%n%s%nPayment Due: $%.2f%n",
				getFirstName(), getLastName(), getSocialSecurityNumber(), compensationmodel.toString(), getPaymentAmount());
	}

} // end class Employee3
