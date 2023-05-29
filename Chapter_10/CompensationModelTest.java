// Exercise 10.17 and Exercise 10.18
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

/*(Recommended Project: Implementing the Payable Interface)
 Modify class Employee3 from Exercise 10.17 so that it implements the Payable2 interface of Fig. 10.11.
 Replace the Salaried-Employee objects in the application of Fig. 10.14 with the Employee objects from Exercise 10.17
 and demonstrate processing the Employee and Invoice objects polymorphically.
*/

public class CompensationModelTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// initializing variables
		
		// info from PayrollSystemTest
//		SalariedEmployee2 salariedEmployee = new SalariedEmployee2("John", "Smith", "111-11-1111", 800.00);
//		HourlyEmployee2 hourlyEmployee = new HourlyEmployee2("Karen", "Price", "222-22-2222", 16.75, 40);
//		CommissionEmployee2 commissionEmployee = new CommissionEmployee2("Sue", "Jones", "333-33-3333", 10000, .06);
//		BasePlusCommissionEmployee2 basePlusCommissionEmployee = new BasePlusCommissionEmployee2("Bob", "Lewis", "444-44-4444", 5000, .04, 300);

		// created employee CompensationModels
		SalariedCompensationModel salariedcompensationmodel = new SalariedCompensationModel(800.00);
		HourlyCompensationModel hourlycompensationmodel = new HourlyCompensationModel(16.75, 40);
		CommissionCompensationModel commissioncompensationmodel = new CommissionCompensationModel(10000, .06);
		BasePlusCommissionCompensationModel basepluscommissioncompensationmodel = new BasePlusCommissionCompensationModel(5000, .04, 300);

		// for exercise 10.17 version 1
		// created employee objects
		// Employee3 employee1 = new Employee3("John", "Smith", "111-11-1111", salariedcompensationmodel);
		// Employee3 employee2 = new Employee3("Karen", "Price", "222-22-2222", hourlycompensationmodel);
		// Employee3 employee3 = new Employee3("Sue", "Jones", "333-33-3333", commissioncompensationmodel);
		// Employee3 employee4 = new Employee3("Bob", "Lewis", "444-44-4444", basepluscommissioncompensationmodel);
		
		// added for exercise 10.18 version 1
		// Invoice2 invoice1 = new Invoice2("01234", "seat", 2, 375.00);
		// Invoice2 invoice2 = new Invoice2("56789", "tire", 4, 79.95);

		// from exercise 10.17
		// This shows only their particulars and what they have earned
		// System.out.println("Version 1");
		// System.out.printf("%s%n", employee1.toString()); // works fine
		// System.out.printf("%s%n", employee2.toString()); // works fine
		// System.out.printf("%s%n", employee3.toString()); // works fine
		// System.out.printf("%s%n", employee4.toString()); // works fine
		// System.out.println("Version 2");
		// is the same as lines above
		// System.out.printf("%s%s%n%s%s%n%s%s%n%s%s%n", "Salaried Employee:", employee1, "Hourly paid Employee: ", employee2, "Commissioned Employee: ", employee3, "Base plus Commissioned Employee: ", employee4);
		
		//for exercise 10.18 version 1
		//		System.out.printf("%s%n%s: $%,.2f%n%n%s%n%s: $%,.2f%n%n", invoice1, "Payment due: ", invoice1.getPaymentAmount(), invoice2, "Payment due: ", invoice2.getPaymentAmount());
		


		
		//for exercise 10.18
		Payable2[] payableObjects = new Payable2[] { new Invoice2("01234", "seat", 2, 375.00),
				new Invoice2("56789", "tire", 4, 79.95),
				new Employee3("John", "Smith", "111-11-1111", salariedcompensationmodel),
				new Employee3("Karen", "Price", "222-22-2222", hourlycompensationmodel),
				new Employee3("Sue", "Jones", "333-33-3333", commissioncompensationmodel),
				new Employee3("Bob", "Lewis", "444-44-4444", basepluscommissioncompensationmodel)
		};
		System.out.println("Invoices and Employees processed polymorphically:");

		// generically process each element in array payableObjects
		for (Payable2 currentPayable : payableObjects)
		{
			// output currentPayable and its appropriate payment amount
			System.out.printf("%n%s", currentPayable.toString()); // could invoke implicitly

			if(currentPayable instanceof Invoice2) // since all employees have their payment due statements
			{
				System.out.printf("%npayment due: $%,.2f%n", currentPayable.getPaymentAmount());
			}

			// determine whether element is a BasePlusCommissionEmployee
			if (currentPayable instanceof BasePlusCommissionCompensationModel)
			{
				// downcast Employee reference to 
				// BasePlusCommissionEmployee reference
				BasePlusCommissionEmployee2 employee = (BasePlusCommissionEmployee2) currentPayable;
				employee.setBaseSalary(1.10 * employee.getBaseSalary());
				System.out.printf("new base salary with 10%% increase is: $%,.2f%n", employee.getBaseSalary());
			}
		}

	} // end method main

} // end class CompensationModelTest
