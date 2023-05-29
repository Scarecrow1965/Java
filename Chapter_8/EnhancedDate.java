// Exercise 8.8
/* (Enhancing Class Date)
 * Modify class Date of Fig.8.7 to perform error checking on the initializer values for variables month,
 * day and year (currently it validates only the month and day).
 * Provide a method nextDay to increment the day by one.
 * Write a program that tests method nextDay in a loop that prints the date during each iteration to
 * illustrate that the method works correctly. Test the following cases:
1.	incrementing into the next month and
2.	incrementing into the next year.

// Fig. 8.7: Date.java 
// Date class declaration.

public class Date
{
	private int month; // 1-12
	private int day; // 1-31 based on month
	private int year; // any year

	private static final int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	// constructor: confirm proper value for month and day given the year
	public Date(int month, int day, int year)
	{
		// check if month in range
		if (month <= 0 || month > 12)
		{
			throw new IllegalArgumentException("month (" + month + ") must be 1-12");
		}

		// check if day in range for month
		if (day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29)))
		{
			throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
		}

		// check for leap year if month is 2 and day is 29
		if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
		{
			throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
		}

		this.month = month;
		this.day = day;
		this.year = year;

		System.out.printf("Date object constructor for date %s%n", this);
	}

	// return a String of the form month/day/year
	public String toString()
	{
		return String.format("%d/%d/%d", month, day, year); 
	}
}
*/
public class EnhancedDate
{
	// initializing variables
	private static int month; // 1-12
	private static int day; // 1-31 based on month
	private static int year; // any year

	private static final int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	// constructor: confirm proper value for month and day given the year
	public EnhancedDate(int month, int day, int year)
	{

		this.month = checkMonth(month);
		this.day = checkDay(day);
		this.year = checkYear(year);

		System.out.printf("Date has a default of: %s (MM/DD/YYYY)%n", this);
	}

public static int checkDay(int ifDay)
	{
		// check if day in range for month
		if (ifDay <= 0 || (ifDay > daysPerMonth[month] && !(month == 2 && ifDay == 29)))
		{
			throw new IllegalArgumentException("day (" + ifDay + ") out-of-range for the specified month and year");
		}
		// check for leap year if month is 2 and day is 29
		if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
		{
			throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
		}
		return day = ifDay;
	}

	public static int checkMonth(int ifMonth)
	{
		// check if month in range
		if (ifMonth <= 0 || ifMonth > 12)
		{
			throw new IllegalArgumentException("month (" + ifMonth + ") must be between 1 and 12");
		}

		return month = ifMonth;
		// could use this:
		// month = ((ifMonth >= 1 && ifMonth <=12) ? month : 1);
	}

	public static int checkYear(int ifYear)
	{
		if (ifYear >= 1800 && ifYear < 9999)
		{
			 return year = ifYear;
		}
		else
		{
			throw new IllegalArgumentException("year (" + ifYear + ") must be between 1800 and 9999");
		}
	}

	public static void nextDay()
	{
		int nextday = day + 1;
		try
		{
			if(checkDay(nextday) == nextday)
			{
				day = nextday;
			}
			else
			{
				day = 1;
				nextMonth();
			}
		}
		catch (IllegalArgumentException e)
		{
			day = 1;
			nextMonth();
		}
	}

	public static void nextMonth()
	{
		int nextmonth = month + 1;
		if (nextmonth > 12)
		{
			month = 1;
			nextYear();
		}
		else
		{
			month = nextmonth;
		}
	}
	
	public static void nextYear()
	{
		checkYear(year + 1);
	}

	// return a String of the form month/day/year
	public String toString()
	{
		return String.format("%d/%d/%d", month, day, year); 
	}
}
