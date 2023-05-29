// Exercise 8.5
/* 8.5	(Modifying the Internal Data Representation of a Class)
 * It would be perfectly reasonable for the Time2 class of Fig.8.5 to represent the time internally
 * as the number of seconds since midnight rather than the three integer values hour, minute and second.
 * Clients could use the same public methods and get the same results.
 * Modify the Time2 class of Fig.8.5 to implement the time as the number of seconds since midnight
 * and show that no change is visible to the clients of the class.
 * 
 * // Fig. 8.5: Time2.java
// Time2 class declaration with overloaded constructors.

public class Time2 {
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
	public int getHour() {return hour;}

	// get minute value
	public int getMinute() {return minute;}

	// get second value
	public int getSecond() {return second;}

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
public class ModIntDataRep
{
		private int hour; // 0 - 23
		private int minute; // 0 - 59
		private int second; // 0 - 59
		private int totalseconds;

		// Time2 no-argument constructor: 
		// initializes each instance variable to zero  
		public ModIntDataRep()
		{
			this(0, 0, 0); // invoke constructor with three arguments
			totalseconds = 0;
		}

		// Time2 constructor: hour supplied, minute and second defaulted to 0
		public ModIntDataRep(int hour)
		{
			this(hour, 0, 0); // invoke constructor with three arguments 
		}

		// Time2 constructor: hour and minute supplied, second defaulted to 0
		public ModIntDataRep(int hour, int minute)
		{
			this(hour, minute, 0); // invoke constructor with three arguments 
		}

		// Time2 constructor: hour, minute and second supplied
		public ModIntDataRep(int hour, int minute, int second)
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
		public ModIntDataRep(ModIntDataRep time)
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
			this.totalseconds = totalseconds;
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
			this.totalseconds = (getHour() * 3600) + (getMinute() * 60 ) + getSecond() ;
		}

		public void setTotalSeconds()
		{
			this.totalseconds = totalseconds;
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

		public int getTotalSeconds()
		{
			return ((getHour() * 3600) + (getMinute() * 60 ) + getSecond()) ;
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
		
		// convert to String in total seconds format (SSSSSSSSSSSS)
		public String toTotalSecondsString()
		{
			return String.format("%12d", getTotalSeconds());
		}
	}
