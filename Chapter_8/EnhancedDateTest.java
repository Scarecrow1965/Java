// Exercise 8.8
/* (Enhancing Class Date)
 * Modify class Date of Fig.8.7 to perform error checking on the initializer values for variables month,
 * day and year (currently it validates only the month and day).
 * Provide a method nextDay to increment the day by one.
 * Write a program that tests method nextDay in a loop that prints the date during each iteration to
 * illustrate that the method works correctly. Test the following cases:
1.	incrementing into the next month and
2.	incrementing into the next year.
*/
import java.util.Scanner;

public class EnhancedDateTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// initializing variables
		EnhancedDate date = new EnhancedDate(1,1,1800); // (int month, int day, int year)
		
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("This application will provide you, the user, to input a date");
		System.out.println("and to be able to add a day and see what happens next.");
		System.out.println("This first step is to enter a date.");
		System.out.println("Please enter a month:");
		int month = input.nextInt();
		date.checkMonth(month);
		System.out.println("Please enter a day:");
		int day = input.nextInt();
		date.checkDay(day);
		System.out.println("Please enter a year:");
		int year = input.nextInt();
		date.checkYear(year);

		System.out.printf("Date is now set to: %s%n", date.toString());
		System.out.println();

		System.out.println("Now we start incrementing one day at a time.");
		System.out.println("A loop of 20 days is used top test this.");
		for( int i = 1; i <= 20; i++)
		{
			date.nextDay();
			System.out.printf("Date is: %s%n", date.toString());
		}

	} // end method main

} // end class EnhancedDateTest
