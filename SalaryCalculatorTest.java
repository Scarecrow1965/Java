// Exercise 4.20
/* Develop a Java application that determines the gross pay for each of three employees.
 * The company pays straight time for the first 40 hours worked by each employee and
 * time and a half for all hours worked in excess of 40.
 * You’re given a list of the employees, their number of hours worked last week and their
 * hourly rates.
 * Your program should input this information for each employee, then determine and display
 * the employee’s gross pay.
 * Use class Scanner to input the data.
 */

import java.util.Scanner;

public class SalaryCalculatorTest
{

	public static void main(String[] args)
	{
		// initiating SalarayCalculator
		SalaryCalculator member = new SalaryCalculator(" ",0);
				
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("This is a Salary Caluclator for your company.");
		System.out.println("Enter the employee's name:");
		String employee = input.next(); // prompt input
		member.setEmployee(employee); // add employee to list
		
		System.out.println("Enter the employee's hourly rate:");
		double hourlyRate = input.nextDouble(); // prompt input 
		member.setHourlyRate(hourlyRate); // add hourly rates to list

		System.out.println("Enter the employee's hours:");
		int hours = input.nextInt(); // prompt input 
		member.setHours(hours); // add hours to list
		
		System.out.printf("Employee %s, has worked %d hours and%n", member.getEmployee(), member.getHours());
		System.out.print("earned $" + String.format("%.2f", member.CalculatePay()) + " this week.\n");
		
	} // end method main

} // end class SalarayCalculatorTest
