//Exercise 8.12
/*(Date and Time Class)
 * Create class DateAndTime that combines the modified Time2 class of Exercise 8.7 and the modified Date class of Exercise 8.8.
 * Modify method incrementHour to call method nextDay if the time is incremented into the next day.
 * Modify methods toString and toUniversalString to output the date in addition to the time.
 * Write a program to test the new class DateAndTime.
 * Specifically, test incrementing the time to the next day.
 */

public class DateAndTime
{
	// initializing variables
	private static int month; // 1-12
	private static int day; // 1-31 based on month
	private static int year; // any year
	private static int hour; // 0 - 23
	private static int minute; // 0 - 59
	private static int second; // 0 - 59
	private static final int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	// DateAndTime constructor:
	public DateAndTime(int ifmonth, int ifday, int ifyear, int ifhour, int ifminute, int ifsecond)
	{
		setDate(ifmonth, ifday, ifyear);
		if(ifmonth == month)
		{
			this.month = month;
		}
		if(ifday == day)
		{
			this.day = day;
		}
		if(ifyear == year)
		{
			this.year = year;
		}
		setTime(ifhour, ifminute, ifsecond);
		if(ifhour == hour)
		{
			this.hour = hour;
		}
		if(ifminute == minute)
		{
			this.minute = minute;
		}
		if(ifsecond == second)
		{
			this.second = second;
		}
	} // end constructor
	

	// validate the data
	public static void setDate(int month, int day, int year)
	{
		month = checkMonth(month);
		day = checkDay(day);
		year = checkYear(year);
	}

	// set a new time value using universal time;  
	// validate the data
	public static void setTime(int hour, int minute, int second)
	{
		hour = checkHour(hour);
		minute = checkMinute(minute); 
		second = checkSecond(second); 
	}

	public static int checkDay(int ifDay)
	{
		// check if day in range for month
		if(ifDay <= 0 || (ifDay > daysPerMonth[month] && !(month == 2 && ifDay == 29)))
		{
			throw new IllegalArgumentException("day (" + ifDay + ") out-of-range for the specified month and year");
		}
		// check for leap year if month is 2 and day is 29
		if(month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
		{
			throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
		}
		return day = ifDay;
	}

	public static int checkMonth(int ifMonth)
	{
		// check if month in range
		if(ifMonth <= 0 || ifMonth > 12)
		{
			throw new IllegalArgumentException("month (" + ifMonth + ") must be between 1 and 12");
		}

		return month = ifMonth;
		// could use this:
		// month = ((ifMonth >= 1 && ifMonth <=12) ? month : 1);
	}

	public static int checkYear(int ifYear)
	{
		if(ifYear >= 1800 && ifYear < 9999)
		{
			return year = ifYear;
		}
		else
		{
			throw new IllegalArgumentException("year (" + ifYear + ") must be between 1800 and 9999");
		}
	}

	// validate and set hour 
	public static int checkHour(int ifHour)
	{
		// check if month in range
		if(ifHour < 0 || ifHour >= 24)
		{
			throw new IllegalArgumentException("hour (" + ifHour + ") must be between 1 and 24");
		}
		return hour = ifHour;
		// hour = ((hour >= 0 && hour <= 24) ? hour : 0);
	}

	// validate and set minute 
	public static int checkMinute(int ifMinute)
	{
		// check if month in range
		if(ifMinute < 0 || ifMinute >= 60)
		{
			throw new IllegalArgumentException("minute (" + ifMinute + ") must be between 1 and 60");
		}

		return minute = ifMinute;
		// minute = ((minute >= 0 && minute <= 60) ? minute : 0);
	}

	// validate and set second 
	public static int checkSecond(int ifSecond)
	{
		// check if month in range
		if(ifSecond < 0 || ifSecond >= 60)
		{
			throw new IllegalArgumentException("second (" + ifSecond + ") must be between 1 and 60");
		}

		return second = ifSecond;
		// second = ((second >= 0 && second <= 60) ? second : 0);
	}

	// set Time methods
	// validate and set hour 
	public void setHour(int hour)
	{
		hour = ((hour >= 0 && hour <= 24) ? hour : 0);
		this.hour = hour;
	}

	// validate and set minute 
	public void setMinute(int minute)
	{
		minute = ((minute >= 0 && minute <= 60) ? minute : 0);
		this.minute = minute; 
	}

	// validate and set second 
	public void setSecond(int second)
	{
		second = ((second >= 0 && second <= 60) ? second : 0);
		this.second = second; 
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

	// get hour value
	public int getHour()
	{
		return hour;
	}

	// get minute value
	public int getMinute()
	{
		return minute;
	}

	// get second value
	public int getSecond()
	{
		return second;
	}

	// Increment / Add methods
	// increment day by one
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

	// increment month by one
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

	// increment year by one
	public static void nextYear()
	{
		checkYear(year + 1);
	}

	// increment time by one second
	public void tick()
	{
		setSecond(second + 1);
		if(second == 60)
		{
			second = 0;
			incrementMinute();
		}
	}

	// increment next minute
	public void incrementMinute()
	{
		setMinute(minute + 1);
		if(minute == 60)
		{
			minute = 0;
			incrementHour();
		}
	}

	// increment next hour
	public void incrementHour()
	{
		setHour(hour + 1);
		if(hour == 24)
		{
			hour = 00;
			nextDay();
		}
	}

	// Printing solutions
	// return a String of the form month/day/year
	public String DatetoString()
	{
		return String.format("%d/%d/%d", month, day, year);
	}
	// convert to String in universal-time format (HH:MM:SS)
	public String TimetoUniversalString()
	{
		return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
	}
	// convert to String in standard-time format (HH:MM:SS AM or PM)
	public String toString()
	{	
		return String.format("%02d:%02d:%02d %s", ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
			getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
	}
} // End class DateAndTime