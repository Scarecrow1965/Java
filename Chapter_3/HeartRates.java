// Exercise 3.16
/*Create a class called HeartRates.
 * The class attributes should include the person’s
 * - first name,
 * - last name and
 * - date of birth (consisting of separate attributes for the
 * -- month,
 * -- day and
 * -- year of birth).
 * Your class should have a constructor that receives this data as parameters.
 * For each attribute provide set and get methods.
 * The class also should include a method that calculates and returns the person’s age (in years),
 * a method that calculates and returns the person’s maximum heart rate and
 * a method that calculates and returns the person’s target heart rate.
 * Write a Java app that prompts for the person’s information, instantiates an object of class
 * HeartRates and prints the information from that object—including the person’s first name,
 * last name and date of birth—then calculates and prints the person’s age in (years), maximum heart rate
 * and target-heart-rate range.
 */

public class HeartRates {

	// initializing variables
	private String firstName;
	private String lastName;
	public int day;
	public int month;
	public int year;
	private int age;
	public int heartRate;

	// initializing constructor
	public HeartRates (String firstName, String lastName, int day, int month, int year)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.day = day;
		this.month = month;
		this.year = year;
	} // end constructor
	
	//method setFirstName
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	} // end method setFirstName
	
	//method getFirstName
	public String getFirstName()
	{
		return firstName;
	} //end method getFirstName
	
	//method setLastName
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	} // end method setLastName
	
	//method getLastName
	public String getLastName()
	{
		return lastName;
	} // end method getLastName
	
	//method setDay
	public void setDay(int day)
	{
		this.day = day;
	} // end method setDay
	
	//method getDay
	public int getDay()
	{
		return day;
	} // end method getDay
	
	//method setMonth
	public void setMonth(int month)
	{
		this.month = month;
	} // end method setMonth
	
	//method getMonth
	public int getMonth()
	{
		return month;
	} // end method getMonth
	
	//method setYear
	public void setYear(int year)
	{
		this.year = year;
	} // end method setYear
	
	//method getYear
	public int getYear()
	{
		// if(year < )
		return year;
	} //end method getYear
	
	//method DetAge
	public int getAge()
	{
		int today = 2022; // opted to use this year as part of the age calculation
		age = today - year;
		return age;
				
		//day,month,year - today = age
	}
	//method MaxHeartRate
	public int MaxHeartRate()
	{
		heartRate = 220 - getAge();
		return heartRate;
		// max heart rate = 220 - age
	} //end method MaxHeartRate
	
	//method TargetheartRate
	public String TargetHeartRate()
	{
		return String.format("Target Heart rate is %d - %d", (int)(heartRate * .5), (int)(heartRate * .85));
		// 50% of MaxHeartRate is min
		// 85% of MaxHeartRate is max
	} //end method TargetHeartRate

} // end class Heart Rates
