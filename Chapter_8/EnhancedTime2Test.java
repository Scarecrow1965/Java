//Exercise 8.7
/* (Enhancing Class Time2)
 * Modify class Time2 of Fig.8.5 to include a tick method that increments the time stored in a Time2 object by one second.
 * Provide method incrementMinute to increment the minute by one and method incrementHour to increment the hour by one.
 * Write a program that tests the tick method, the incrementMinute method and the incrementHour method to ensure that
 * they work correctly. Be sure to test the following cases:
1.	incrementing into the next minute,
2.	incrementing into the next hour and
3.	incrementing into the next day (i.e., 11:59:59 PM to 12:00:00 AM).

// Fig. 8.6: Time2Test.java
// Overloaded constructors used to initialize Time2 objects.

public class Time2Test
{
	public static void main(String[] args)
	{
		Time2 t1 = new Time2(); // 00:00:00
		Time2 t2 = new Time2(2); // 02:00:00
		Time2 t3 = new Time2(21, 34); // 21:34:00
		Time2 t4 = new Time2(12, 25, 42); // 12:25:42
		Time2 t5 = new Time2(t4); // 12:25:42

		System.out.println("Constructed with:");
		displayTime("t1: all default arguments", t1);
		displayTime("t2: hour specified; default minute and second", t2);
		displayTime("t3: hour and minute specified; default second", t3);
		displayTime("t4: hour, minute and second specified", t4);
		displayTime("t5: Time2 object t4 specified", t5);

		// attempt to initialize t6 with invalid values
		try
		{
			Time2 t6 = new Time2(27, 74, 99); // invalid values
		}
		catch (IllegalArgumentException e)
		{
			System.out.printf("%nException while initializing t6: %s%n", e.getMessage());
		}
	}

	// displays a Time2 object in 24-hour and 12-hour formats
	private static void displayTime(String header, Time2 t)
	{
		System.out.printf("%s%n   %s%n   %s%n", header, t.toUniversalString(), t.toString());
	}
} */

import java.util.Scanner;

public class EnhancedTime2Test
{

	public static void main(String[] args)
	{
		// initializing variables
		EnhancedTime2 timed = new EnhancedTime2(0,0,0);
		
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
		
		System.out.println("This application will allow you to change the time you provide.");
		
		System.out.println("Please enter the hour:");
		int hour = input.nextInt();
		timed.setHour(hour);
		System.out.println("Please enter the minutes:");
		int minute = input.nextInt();
		timed.setMinute(minute);
		System.out.println("Please enter the seconds:");
		int second = input.nextInt();
		timed.setSecond(second);
		
		System.out.println("Here is what you have entered:");
		displayTime("Universal Time:", "Standard Time:", timed);
		System.out.println();

		System.out.println("Please use the following options:");
		System.out.println("Add 1 second, choose 1:");
		System.out.println("Add 1 minute, choose 2:");
		System.out.println("Add 1 hour, choose 3:");
		System.out.println("Enter 99 to exit");
		int option = input.nextInt();
		while(option != 99)
		{
			switch (option)
			{
			case 1:
			{
				timed.tick();
				displayTime("Universal Time:", "Standard Time:", timed);
				break;
			}
			case 2:
			{
				timed.incrementMinute();
				displayTime("Universal Time:", "Standard Time:", timed);
				break;
			}
			case 3:
			{
				timed.incrementHour();
				displayTime("Universal Time:", "Standard Time:", timed);
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
			System.out.println("Add 1 second, choose 1:");
			System.out.println("Add 1 minute, choose 2:");
			System.out.println("Add 1 hour, choose 3:");
			System.out.println("Enter 99 to exit");
			option = input.nextInt();
		}
	} // end method main

	private static void displayTime(String header, String header2, EnhancedTime2 timed)
	{
		System.out.printf("   %s%n   %s%n   %s%n   %s%n", header, timed.toUniversalString(), header2, timed.toString());
	}
//		EnhancedTime2 t1 = new EnhancedTime2(); // 00:00:00
//		EnhancedTime2 t2 = new EnhancedTime2(2); // 02:00:00
//		EnhancedTime2 t3 = new EnhancedTime2(21, 34); // 21:34:00
//		EnhancedTime2 t4 = new EnhancedTime2(12, 25, 42); // 12:25:42
//		EnhancedTime2 t5 = new EnhancedTime2(t4); // 12:25:42
//
//		System.out.println("Constructed with:");
//		displayTime("t1: all default arguments", t1);
//		displayTime("t2: hour specified; default minute and second", t2);
//		displayTime("t3: hour and minute specified; default second", t3);
//		displayTime("t4: hour, minute and second specified", t4);
//		displayTime("t5: Time2 object t4 specified", t5);
//
//		// attempt to initialize t6 with invalid values
//		try
//		{
//			EnhancedTime2 t6 = new EnhancedTime2(27, 74, 99); // invalid values
//		}
//		catch (IllegalArgumentException e)
//		{
//			System.out.printf("%nException while initializing t6: %s%n", e.getMessage());
//		}
//	} // end method main
//
//	// displays a Time2 object in 24-hour and 12-hour formats
//	private static void displayTime(String header, EnhancedTime2 t)
//	{
//		System.out.printf("%s%n   %s%n   %s%n", header, t.toUniversalString(), t.toString());
//	}

} // end class EnhancedTime2
