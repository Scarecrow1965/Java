// Exercise 4.20
/* Develop a Java application that determines the gross pay for each of three employees.
 * The company pays straight time for the first 40 hours worked by each employee and
 * time and a half for all hours worked in excess of 40.
 * You’re given a list of the employees, their number of hours worked last week and their
 * hourly rates.
 * Your program should input this information for each employee, then determine and display
 * the employee’s gross pay.
 * Use class Scanner to input the data.
 */

public class SalaryCalculator
{
	// initializing variables
	String employee;
	int hours;
	double hourlyRate;
	double pay;
	double overtime = hours - 40;
	
	// constructor
	public SalaryCalculator(String employee, double hourlyRate)
	{
		this.employee = employee;
		this.hourlyRate = hourlyRate;
	} // end constructor
	
	// method setEmployee
	public void setEmployee(String employee)
	{
		this.employee = employee;
	}//end method setEmployee
	
	// method getEmployee
	public String getEmployee()
	{
		return employee;
	}// end method getEmployee
	
	// method setHourlyRate
	public void setHourlyRate(double hourlyRate)
	{
		this.hourlyRate = hourlyRate;
	} // end method setHourlyRate
	
	// method getHourlyRate
	public double getHourlyRate()
	{
		return hourlyRate;
	}// end method GetHourlyRate
	
	// method setHours
	public void setHours(int hours)
	{
		this.hours = hours;
	} // end method setHours
	
	// method getHours
	public int getHours()
	{
		return hours;
	} // end method getHours
	
	// method CalculatePay
	public double CalculatePay()
	{
		if(hours <= 40)
			{
				pay = hours * hourlyRate;
			}
		else
			{
			overtime = hours - 40;
			double overtimePay = 1.5 * (overtime * hourlyRate);
			pay = (40 * hourlyRate) + overtimePay;
			}
		return pay;
	} // end method CalculatePay
	
}// end class SalaryCalculator
