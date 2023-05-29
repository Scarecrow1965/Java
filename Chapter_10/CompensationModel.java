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

// public class CompensationModel
public interface CompensationModel // changed to interface for this exercise
{

	// abstract method must be overridden by concrete subclasses
	public abstract double earnings();

	// implementing getPaymentAmount here enables the entire Employee
	// class hierarchy to be used in an app that processes Payables
	public abstract double getPaymentAmount();

} //end interface CompensationModel
