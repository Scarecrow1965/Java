import java.util.Scanner;

// Exercise 8.15
/* (Date Class)
Create class Date with the following capabilities:
1. Output the date in multiple formats, such as
MM/DD/YYYY
June 14, 1992
DDD YYYY
2. Use overloaded constructors to create Date objects initialized with dates of the formats in part (a).
In the first case the constructor should receive three integer values.
In the second case it should receive a String and two integer values.
In the third case it should receive two integer values, the first of which represents the day number in the year.
*/
import java.util.Scanner;

public class Date
{
	private static int month; // 1-12
	private static int day; // 1-31 based on month
	private static int year; // any year

	private static final int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	// constructor: confirm proper value for month and day given the year
	public Date(int month, int day, int year)
	{
		this.month = checkMonth(month);
		this.day = checkDay(day);
		this.year = checkYear(year);
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


	// Get Date methods
	// get month value
	public int getMonth()
	{
		return month;
	}

	// get day value
	public int getDay()
	{
		return day;
	}

	// get year value
	public int getYear()
	{
		return year;
	}


	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// initializing variables
		Date date = new Date(1,1,1800); // (int month, int day, int year)
		
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("This application will provide you, the user, to input a date");
		System.out.println("and then display the date in three different formats:");
		System.out.println("MM/DD/YYYY\r\n"
				+ "MONTH DD, YYYY\r\n"
				+ "DDD YYYY");
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

		System.out.println("Here is the date in the three formats mentioned previously:");
		System.out.printf("%s%n", date.toString() );
	} // end method main

	// to change int month to a String month
	public static String Month(int month)
	{
		String monthString = "";
		switch(month)
		{
		case 1:
		{
			monthString = "January";
			break;
		}
		case 2:
		{
			monthString = "February";
			break;
		}
		case 3:
		{
			monthString = "March";
			break;
		}
		case 4:
		{
			monthString = "April";
			break;
		}
		case 5:
		{
			monthString = "May";
			break;
		}
		case 6:
		{
			monthString = "June";
			break;
		}
		case 7:
		{
			monthString = "July";
			break;
		}
		case 8:
		{
			monthString = "August";
			break;
		}
		case 9:
		{
			monthString = "September";
			break;
		}
		case 10:
		{
			monthString = "October";
			break;
		}
		case 11:
		{
			monthString = "November";
			break;
		}
		case 12:
		{
			monthString = "December";
			break;
		}
		}
		return monthString;
	}

	// method to calculate day number in the year
	public static int DayNumber(int day, int month)
	{
		if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
		{
			++day;
		}
		while (--month > 0)
		{
			day += daysPerMonth[month];
			// day = day + daysPerMonth[month - 1];
		}
		return day;
	}

	// to printout date formats
	public String toString()
	{
		return String.format("%d / %d / %d%n%s %d, %d%n%d %d", getMonth(), getDay(), getYear(), Month(month), getDay(), getYear(), DayNumber(day, month), getYear() );
	}

} // end class Date
