// Exercise 8.7.
/*(Enhancing Class Time2)
 * Modify class Time2 of Fig.8.5 to include a tick method that increments the time stored in a Time2 object by one second.
 * Provide method incrementMinute to increment the minute by one and method incrementHour to increment the hour by one.
 * Write a program that tests the tick method, the incrementMinute method and the incrementHour method to ensure that
 * they work correctly. Be sure to test the following cases:
1.	incrementing into the next minute,
2.	incrementing into the next hour and
3.	incrementing into the next day (i.e., 11:59:59 PM to 12:00:00 AM).

// Fig. 8.5: Time2.java
// Time2 class declaration with overloaded constructors.

public class Time2
{
	private int hour; // 0 - 23
	private int minute; // 0 - 59
	private int second; // 0 - 59

	// Time2 no-argument constructor: 
	// initializes each instance variable to zero  
	public Time2()
	{
		this(0, 0, 0); // invoke constructor with three arguments
	}

	// Time2 constructor: hour supplied, minute and second defaulted to 0
	public Time2(int hour)
	{
		this(hour, 0, 0); // invoke constructor with three arguments 
	}

	// Time2 constructor: hour and minute supplied, second defaulted to 0
	public Time2(int hour, int minute)
	{
		this(hour, minute, 0); // invoke constructor with three arguments 
	}

	// Time2 constructor: hour, minute and second supplied
	public Time2(int hour, int minute, int second)
	{
		if (hour < 0 || hour >= 24)
		{
			throw new IllegalArgumentException("hour must be 0-23");
		}

		if (minute < 0 || minute >= 60)
		{
			throw new IllegalArgumentException("minute must be 0-59");
		}

		if (second < 0 || second >= 60)
		{
			throw new IllegalArgumentException("second must be 0-59");
		}

		this.hour = hour;
		this.minute = minute; 
		this.second = second; 
	}

	// Time2 constructor: another Time2 object supplied
	public Time2(Time2 time)
	{
		// invoke constructor with three arguments
		this(time.hour, time.minute, time.second);
	}

	// Set Methods
	// set a new time value using universal time;  
	// validate the data
	public void setTime(int hour, int minute, int second)
	{
		if (hour < 0 || hour >= 24)
		{
			throw new IllegalArgumentException("hour must be 0-23");
		}

		if (minute < 0 || minute >= 60)
		{
			throw new IllegalArgumentException("minute must be 0-59");
		}

		if (second < 0 || second >= 60)
		{
			throw new IllegalArgumentException("second must be 0-59");
		}

		this.hour = hour;
		this.minute = minute; 
		this.second = second; 
	}

	// validate and set hour 
	public void setHour(int hour)
	{
		if (hour < 0 || hour >= 24)
		{
			throw new IllegalArgumentException("hour must be 0-23");
		}

		this.hour = hour;
	}

	// validate and set minute 
	public void setMinute(int minute)
	{
		if (minute < 0 || minute >= 60)
		{
			throw new IllegalArgumentException("minute must be 0-59");
		}

		this.minute = minute; 
	}

	// validate and set second 
	public void setSecond(int second)
	{
		if (second < 0 || second >= 60)
		{
			throw new IllegalArgumentException("second must be 0-59");
		}

		this.second = second;
	}

	// Get Methods
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

	// convert to String in universal-time format (HH:MM:SS)
	public String toUniversalString()
	{
		return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
	}

	// convert to String in standard-time format (H:MM:SS AM or PM)
	public String toString()
	{
		return String.format("%d:%02d:%02d %s", ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
				getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
	}
}
 */
public class EnhancedTime2
{
	private int hour; // 0 - 23
	private int minute; // 0 - 59
	private int second; // 0 - 59

	// Time2 no-argument constructor: 
	// initializes each instance variable to zero  
	public EnhancedTime2()
	{
		this(0, 0, 0); // invoke constructor with three arguments
	}

	// Time2 constructor: hour supplied, minute and second defaulted to 0
	public EnhancedTime2(int hour)
	{
		this(hour, 0, 0); // invoke constructor with three arguments 
	}

	// Time2 constructor: hour and minute supplied, second defaulted to 0
	public EnhancedTime2(int hour, int minute)
	{
		this(hour, minute, 0); // invoke constructor with three arguments 
	}

	// Time2 constructor: hour, minute and second supplied
	public EnhancedTime2(int hour, int minute, int second)
	{
		this.hour = hour;
		this.minute = minute; 
		this.second = second; 
	}

	// Time2 constructor: another Time2 object supplied
	public EnhancedTime2(EnhancedTime2 time)
	{
		// invoke constructor with three arguments
		this(time.hour, time.minute, time.second);
	}

	// Set Methods
	// set a new time value using universal time;  
	// validate the data
	public void setTime(int hour, int minute, int second)
	{
		this.hour = hour;
		this.minute = minute; 
		this.second = second; 
	}

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

	// Get Methods
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

	/*Modify class Time2 of Fig.8.5 to include a tick method that increments the time stored in a Time2 object by one second.
	 * Provide method incrementMinute to increment the minute by one and method incrementHour to increment the hour by one.
	 * Write a program that tests the tick method, the incrementMinute method and the incrementHour method to ensure that
	 * they work correctly. Be sure to test the following cases:
	1.	incrementing into the next minute,
	2.	incrementing into the next hour and
	3.	incrementing into the next day (i.e., 11:59:59 PM to 12:00:00 AM). */

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
		}
	}
	
	// convert to String in universal-time format (HH:MM:SS)
	public String toUniversalString()
	{
		return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
	}

	// convert to String in standard-time format (HH:MM:SS AM or PM)
	public String toString()
	{
		return String.format("%02d:%02d:%02d %s", ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
				getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
	}

} // end class EnhancedTime2
