//Exercise 8.12
/*(Date and Time Class)
 * Create class DateAndTime that combines the modified Time2 class of Exercise 8.7 and the modified Date class of Exercise 8.8.
 * Modify method incrementHour to call method nextDay if the time is incremented into the next day.
 * Modify methods toString and toUniversalString to output the date in addition to the time.
 * Write a program to test the new class DateAndTime.
 * Specifically, test incrementing the time to the next day.
 */

import java.util.Scanner;

public class DateAndTimeTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// initializing variables
		DateAndTime datetime = new DateAndTime(1, 1, 1800, 0, 0, 1); // (month, day, year, hour, minute, second)
		
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
		
		System.out.println("This application will allow you to change the date and time you provide.");

		System.out.println("Please enter the month:");
		int month = input.nextInt();
		datetime.checkMonth(month);
		System.out.println("Please enter the day:");
		int day = input.nextInt();
		datetime.checkDay(day);
		System.out.println("Please enter the year:");
		int year = input.nextInt();
		datetime.checkYear(year);
		System.out.println("Please enter the hour:");
		int hour = input.nextInt();
		datetime.checkHour(hour);
		System.out.println("Please enter the minutes:");
		int minute = input.nextInt();
		datetime.checkMinute(minute);
		System.out.println("Please enter the seconds:");
		int second = input.nextInt();
		datetime.checkSecond(second);
		
		System.out.println("Here is what you have entered:");
		displayDateTime("Date", "Universal Time:", "Standard Time:", datetime);
		System.out.println();

		System.out.println("Please use the following options:");
		System.out.println("Add 1 day, choose 1:");
		System.out.println("Add 1 month, choose 2:");
		System.out.println("Add 1 year, choose 3:");
		System.out.println("Add 1 second, choose 4:");
		System.out.println("Add 1 minute, choose 5:");
		System.out.println("Add 1 hour, choose 6:");
		System.out.println("Enter 99 to exit");
		int option = input.nextInt();
		while(option != 99)
		{
			switch (option)
			{
			case 1:
			{
				datetime.nextDay();
				displayDateTime("Date", "Universal Time:", "Standard Time:", datetime);
				break;
			}
			case 2:
			{
				datetime.nextMonth();
				displayDateTime("Date", "Universal Time:", "Standard Time:", datetime);
				break;
			}
			case 3:
			{
				datetime.nextYear();
				displayDateTime("Date", "Universal Time:", "Standard Time:", datetime);
				break;
			}case 4:
			{
				datetime.tick();
				displayDateTime("Date", "Universal Time:", "Standard Time:", datetime);
				break;
			}
			case 5:
			{
				datetime.incrementMinute();
				displayDateTime("Date", "Universal Time:", "Standard Time:", datetime);
				break;
			}
			case 6:
			{
				datetime.incrementHour();
				displayDateTime("Date", "Universal Time:", "Standard Time:", datetime);
				break;
			}
			case 99:
			{
				System.out.println("Good bye.");
				break;
			}
			default:
			{
				System.out.println("You have selected a wrong number. Please try again.");
				break;
			}
			}
			System.out.println("Please use the following options:");
			System.out.println("Add 1 day, choose 1:");
			System.out.println("Add 1 month, choose 2:");
			System.out.println("Add 1 year, choose 3:");
			System.out.println("Add 1 second, choose 4:");
			System.out.println("Add 1 minute, choose 5:");
			System.out.println("Add 1 hour, choose 6:");
			System.out.println("Enter 99 to exit");
			option = input.nextInt();
		}
	} // end method main

	private static void displayDateTime(String header, String header1, String header2, DateAndTime datetime)
	{
		System.out.printf("   %s%n   %s%n   %s%n   %s%n   %s%n   %s%n", header, datetime.DatetoString(), header1, datetime.TimetoUniversalString(), header2, datetime.toString() );
	}

}
