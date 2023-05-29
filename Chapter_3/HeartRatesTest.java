// Exercise 3.16
/*Create a class called HeartRates.
 * The class attributes should include the person’s
 * - first name,
 * - last name and
 * - date of birth (consisting of separate attributes for the
 * -- month,
 * -- day and
 * -- year of birth).
 * Your class should have a constructor that receives this data as parameters.
 * For each attribute provide set and get methods.
 * The class also should include a method that calculates and returns the person’s age (in years),
 * a method that calculates and returns the person’s maximum heart rate and
 * a method that calculates and returns the person’s target heart rate.
 * Write a Java app that prompts for the person’s information, instantiates an object of class
 * HeartRates and prints the information from that object—including the person’s first name,
 * last name and date of birth—then calculates and prints the person’s age in (years), maximum heart rate
 * and target-heart-rate range.
 */

import java.util.Scanner;

public class HeartRatesTest
{

	public static void main(String[] args) {

		HeartRates person1 = new HeartRates(" "," ",0,0,0);
		
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the member's first name: \n"); // prompt
		String firstName = input.next(); // obtain user input
		person1.setFirstName(firstName); // add month to date
		
		System.out.print("Enter the member's last name: \n"); // prompt
		String lastName = input.next(); // obtain user input
		person1.setLastName(lastName); // add day to date
		
		System.out.print("Enter the member's birth month: \n"); // prompt
		int month = input.nextInt(); // obtain user input
		person1.setMonth(month); // add month to date
		
		System.out.print("Enter the member's birth day: \n"); // prompt
		int day = input.nextInt(); // obtain user input
		person1.setDay(day); // add day to date
		
		System.out.print("Enter the member's birth year: \n"); // prompt
		int year = input.nextInt(); // obtain user input
		person1.setYear(year); // add year to date
		
		System.out.printf("Member %s %s is %d years young. %n", person1.getFirstName(), person1.getLastName(), person1.getAge());
		System.out.println("Source: http://bit.ly/TargetHeartRates");
		System.out.printf("Their maximum heart rate is %d.%n", person1.MaxHeartRate());
		System.out.printf("%s.%n", person1.TargetHeartRate());

	} // end method main

} // end class HeartRatesTest
