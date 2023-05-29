/* Create a class called Date that includes three instance variables—
 * a month (type int),
 * a day (type int) and
 * a year (type int).
 * Provide a constructor that initializes the three instance variables and
 * assumes that the values provided are correct.
 * Provide a set and a get method for each instance variable.
 * Provide a method displayDate that displays the month, day and year
 * separated by forward slashes (/).
 * Write a test app named DateTest that demonstrates class Date’s capabilities. */

public class Date
{

	// initializing variables
	public int month;
	public int day;
	public int year;
	
	// constructor
	public Date(int month, int day, int year)
	{
		this.month = month;
		this.day = day;
		this.year = year;
	}
	// end constructor
	
	//set method for month
	public void setMonth(int month)
	{
		this.month = month;
	} //end method setMonth
	
	//get method for month
	public int getMonth()
	{
		return month;
	} //end method getMonth
	
	//set method for day
	public void setDay(int day)
	{
		this.day = day;
	} //end method setDay
	
	//get method for day
	public int getDay()
	{
		return day;
	} //end method getDay
	
	//set method for year
	public void setYear(int year)
	{
		this.year = year;
	} //end method setYear
	
	//get method for year
	public int getYear()
	{
		return year;
	} //end method getYear
	
	public void displayDate()
	{
		System.out.printf("The date you have provided is: %d / %d / %d %n", month, day, year);
	} // end method displayDate

}// end class Date
