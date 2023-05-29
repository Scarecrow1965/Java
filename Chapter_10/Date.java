// Exercise 10.13
/*(Payroll System Modification)
 Modify the payroll system of Figs. 10.4 – 10.9 to include private instance variable birthDate in class Employee.
 Use class Date of Fig.8.7 to represent an employee’s birthday.
 Add get methods to class Date. Assume that payroll is processed once per month.
 Create an array of Employee variables to store references to the various employee objects.
 In a loop, calculate the payroll for each Employee (polymorphically), and add a $100.00 bonus to the person’s
 payroll amount if the current month is the one in which the Employee’s birthday occurs.
*/

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

	// for exercise 10.13, I added the following methods: getDay, getMonth, getYear
	public int getDay()
	{
		return day;
	}

	public int getMonth()
	{
		return month;
	}

	public int getYear()
	{
		return year;
	}

	// return a String of the form month/day/year
	public String toString()
	{
		return String.format("%d/%d/%d", month, day, year); 
	}
}
