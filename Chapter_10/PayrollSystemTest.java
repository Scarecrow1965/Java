// Exercise 10.13
/*(Payroll System Modification)
 Modify the payroll system of Figs. 10.4 – 10.9 to include private instance variable birthDate in class Employee.
 Use class Date of Fig.8.7 to represent an employee’s birthday.
 Add get methods to class Date. Assume that payroll is processed once per month.
 Create an array of Employee variables to store references to the various employee objects.
 In a loop, calculate the payroll for each Employee (polymorphically), and add a $100.00 bonus to the person’s
 payroll amount if the current month is the one in which the Employee’s birthday occurs.
*/

// Fig. 10.9: PayrollSystemTest.java
// Employee hierarchy test program.

import java.util.Scanner;

public class PayrollSystemTest
{
//	Date currentDate = new Date(31,03,2022);
	
	public static void main(String[] args) {
		// create subclass objects
		Date birthDate1 = new Date(6, 15, 1944); // from exercise 10.13 added birthDate
		SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00, birthDate1);
		Date birthDate2 = new Date(12, 29, 1960); // from exercise 10.13 added birthDate
		HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40, birthDate2);
		Date birthDate3 = new Date(9, 8, 1954); // from exercise 10.13 added birthDate
		CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06, birthDate3);
		Date birthDate4 = new Date(3, 2, 1965); // from exercise 10.13 added birthDate
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300, birthDate4);
		Date birthDate5 = new Date(4, 6, 1965); // from exercise 10.13 added birthDate and extended it to exercise 10.15
		PieceWorker pieceworker = new PieceWorker("Rick", "Bridges", "555-55-5555", 2.25, 400, birthDate5); //from exercise 10.15 added this line

//		Date birthDate = new Date(01, 01, 1980); // test to see if this works

		// from exercise 10.13
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("Employees processed individually:");

		System.out.printf("%n%s%n%s: $%,.2f%n%n", salariedEmployee, "earned", salariedEmployee.earnings());
		System.out.printf("%s%n%s: $%,.2f%n%n", hourlyEmployee, "earned", hourlyEmployee.earnings());
		System.out.printf("%s%n%s: $%,.2f%n%n", commissionEmployee, "earned", commissionEmployee.earnings());
		System.out.printf("%s%n%s: $%,.2f%n%n", basePlusCommissionEmployee, "earned", basePlusCommissionEmployee.earnings());
		System.out.printf("%s%n%s: $%,.2f%n%n", pieceworker, "earned", pieceworker.earnings()); //from exercise 10.15 added this line

		// create four-element Employee array
		Employee[] employees = new Employee[5]; //from exercise 10.15 added +1 to employees

		// initialize array with Employees
		// this is the example of having 4 different types of employee being paid
		employees[0] = salariedEmployee;
		employees[1] = hourlyEmployee;
		employees[2] = commissionEmployee;
		employees[3] = basePlusCommissionEmployee;
		employees[4] = pieceworker; //from exercise 10.15 added this line

		// from exercise 10.13
		/*In a loop, calculate the payroll for each Employee (polymorphically), and add a $100.00 bonus to the person’s
			payroll amount if the current month is the one in which the Employee’s birthday occurs.*/
		System.out.println("Enter the current month (1-12)");
		int month = input.nextInt();

		System.out.printf("Employees processed polymorphically:%n%n");

		// generically process each element in array employees
		for (Employee currentEmployee : employees)
		{
			System.out.println(currentEmployee); // invokes toString

			// determine whether element is a BasePlusCommissionEmployee
			if (currentEmployee instanceof BasePlusCommissionEmployee)
			{
				// downcast Employee reference to 
				// BasePlusCommissionEmployee reference
				BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;

				employee.setBaseSalary(1.10 * employee.getBaseSalary());

				System.out.printf("new base salary with 10%% increase is: $%,.2f%n", employee.getBaseSalary());
			}

			// from exercise 10.13
			if(currentEmployee.getBirthDate().getMonth() == month)
			{
				System.out.printf("%s gets $100.00 bonus for their birthday and has earned $%,.2f!!%n%n", currentEmployee.getFirstName(), currentEmployee.earnings() + 100.00);
			}
			else
			{
				System.out.printf("earned $%,.2f%n%n", currentEmployee.earnings());
			}
			
		}

		// get type name of each object in employees array
		for (int j = 0; j < employees.length; j++)
		{
			System.out.printf("Employee %d is a %s%n", j, employees[j].getClass().getName());
		}
	}
}
