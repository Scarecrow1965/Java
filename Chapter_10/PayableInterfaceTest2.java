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

// Fig. 10.14: PayableInterfaceTest.java
// Payable interface test program processing Invoices and 
// Employees polymorphically.

public class PayableInterfaceTest2
{
	public static void main(String[] args)
	{
		// create four-element Payable array

		Payable2[] payableObjects = new Payable2[] { new Invoice2("01234", "seat", 2, 375.00),
				new Invoice2("56789", "tire", 4, 79.95),
				new SalariedEmployee2("John", "Smith", "111-11-1111", 800.00),
				// new SalariedEmployee2("Lisa", "Barnes", "888-88-8888", 1200.00), //removed for Part 3 results
				new HourlyEmployee2("Karen", "Price", "222-22-2222", 16.75, 40), // added for Part 3 results
				new CommissionEmployee2("Sue", "Jones", "333-33-3333", 10000, .06), // added for Part 3 results
				new BasePlusCommissionEmployee2("Bob", "Lewis", "444-44-4444", 5000, .04, 300) // added for Part 3 results
		};

		//taken from PayrollSystemTest2
//		SalariedEmployee2 salariedEmployee = new SalariedEmployee2("John", "Smith", "111-11-1111", 800.00);
//		HourlyEmployee2 hourlyEmployee = new HourlyEmployee2("Karen", "Price", "222-22-2222", 16.75, 40);
//		CommissionEmployee2 commissionEmployee = new CommissionEmployee2("Sue", "Jones", "333-33-3333", 10000, .06);
//		BasePlusCommissionEmployee2 basePlusCommissionEmployee = new BasePlusCommissionEmployee2("Bob", "Lewis", "444-44-4444", 5000, .04, 300);
//		Invoice2 invoice = new Invoice2("01234", "seat", 2, 375.00); // relocated information from array
//		Invoice2 invoice1 = new Invoice2("56789", "tire", 4, 79.95); // relocated information from array 
//		SalariedEmployee2 salariedEmployee = new SalariedEmployee2("John", "Smith", "111-11-1111", 800.00);
//		HourlyEmployee2 hourlyEmployee = new HourlyEmployee2("Karen", "Price", "222-22-2222", 16.75, 40);
//		CommissionEmployee2 commissionEmployee = new CommissionEmployee2("Sue", "Jones", "333-33-3333", 10000, .06);
//		BasePlusCommissionEmployee2 basePlusCommissionEmployee = new BasePlusCommissionEmployee2("Bob", "Lewis", "444-44-4444", 5000, .04, 300);

		
		System.out.println("Invoices and Employees processed polymorphically:");

//		// generically process each element in array payableObjects
//		for (Payable2 currentPayable : payableObjects)
//		{
//			// output currentPayable and its appropriate payment amount
//			System.out.printf("%n%s %npayment due: $%,.2f%n",
//					currentPayable.toString(), // could invoke implicitly
//					currentPayable.getPaymentAmount()); 
//		}

		// generically process each element in array payableObjects
		for (Payable2 currentPayable : payableObjects)
		{
			// output currentPayable and its appropriate payment amount
			System.out.printf("%n%s%n", currentPayable.toString()); // could invoke implicitly
			
			// determine whether element is a BasePlusCommissionEmployee
			if (currentPayable instanceof BasePlusCommissionEmployee2)
			{
				// downcast Employee reference to 
				// BasePlusCommissionEmployee reference
				BasePlusCommissionEmployee2 employee = (BasePlusCommissionEmployee2) currentPayable;

				employee.setBaseSalary(1.10 * employee.getBaseSalary());
				System.out.printf("new base salary with 10%% increase is: $%,.2f%n", employee.getBaseSalary());
			}
			System.out.printf("payment due: $%,.2f%n", currentPayable.getPaymentAmount());

		}
	}

	//taken from PayrollSystemTest2
//	// create four-element Employee array
//	Employee2[] employees = new Employee2[4]; 
//
//	// initialize array with Employees
//	employees[0] = salariedEmployee;
//	employees[1] = hourlyEmployee;
//	employees[2] = commissionEmployee;
//	employees[3] = basePlusCommissionEmployee;
//
//	System.out.printf("Employees processed polymorphically:%n%n");
//
//	// generically process each element in array employees
//	for (Employee2 currentEmployee : employees)
//	{
//		System.out.println(currentEmployee); // invokes toString
//
//		// determine whether element is a BasePlusCommissionEmployee
//		if (currentEmployee instanceof BasePlusCommissionEmployee2)
//		{
//			// downcast Employee reference to 
//			// BasePlusCommissionEmployee reference
//			BasePlusCommissionEmployee2 employee = (BasePlusCommissionEmployee2) currentEmployee;
//
//			employee.setBaseSalary(1.10 * employee.getBaseSalary());
//
//			System.out.printf("new base salary with 10%% increase is: $%,.2f%n", employee.getBaseSalary());
//		}
//
//		System.out.printf("earned $%,.2f%n%n", currentEmployee.earnings());
//	}
//
//	// get type name of each object in employees array
//	for (int j = 0; j < employees.length; j++)
//	{
//		System.out.printf("Employee %d is a %s%n", j, employees[j].getClass().getName());
//	}
} // end class PayableInterfaceTest2

