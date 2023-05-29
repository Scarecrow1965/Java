/* Create a class called Date that includes three instance variables—
 * a month (type int),
 * a day (type int) and
 * a year (type int).
 * Provide a constructor that initializes the three instance variables and
 * assumes that the values provided are correct.
 * Provide a set and a get method for each instance variable.
 * Provide a method displayDate that displays the month, day and year
 * separated by forward slashes (/).
 * Write a test app named DateTest that demonstrates class Date’s capabilities. */

import java.util.Scanner;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated met

		Date date1 = new Date(0,0,0);
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter Month: \n"); // prompt
		int month = input.nextInt(); // obtain user input
		date1.setMonth(month); // add quantity to date
		
		System.out.print("Enter Day: \n"); // prompt
		int day = input.nextInt(); // obtain user input
		date1.setDay(day); // add quantity to item3
		
		System.out.print("Enter Year: \n"); // prompt
		int year = input.nextInt(); // obtain user input
		date1.setYear(year); // add quantity to item3
		
		// test to display date
		date1.displayDate();
				
	} // end method main

} // end class DateTest
