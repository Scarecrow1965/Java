/* Create a class called Employee that includes three instance variables
 * —a first name (type String),
 * a last name (type String)
 * and a monthly salary (double).
 * Provide a constructor that initializes the three instance variables.
 * Provide a set and a get method for each instance variable.
 * If the monthly salary is not positive, do not set its value.
 * Write a test app named EmployeeTest that demonstrates class Employee’s capabilities.
 * Create two Employee objects and display each object’s yearly salary.
 * Then give each Employee a 10% raise and display each Employee’s yearly salary again.
 */

public class Employee
{
	//access modifier public
	
	// initiating variables
	private String firstName;
	private String lastName;
	private double monthlySalary;
	private double raise;
	
	// constructor Employee
	public Employee(String firstName, String lastName, double monthlySalary)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		if(monthlySalary < 0) 
		{
			monthlySalary = 0;
		}
		this.monthlySalary = monthlySalary;
	} // end constructor Employee
	
	// set method for firstName
	public void setfirstName(String firstName)
	{
		this.firstName = firstName;
	} //end method setfirstName
	
	// get method for firstName
	public String getfirstName()
	{
		return firstName;
	} // end method getfirstName
	
	// set method for lastName
	public void setlastName(String lastName)
	{
		this.lastName = lastName;
	} //end method setlastName
	
	// get method for lastName
	public String getlastName()
	{
		return lastName;
	} // end method getlastName
	
	// set method for salary
	public void setmonthlySalary(double monthlySalary)
	{
		if(monthlySalary < 0) 
		{
			monthlySalary = 0;
		}
		this.monthlySalary = monthlySalary;
	} //end method setmonthlySalary
	
	// get method for salary
	public double getmonthlySalary()
	{
		return monthlySalary;
	} // end method getmonthlySalary

	// method for raise of 10%
	public double Havearaise()
	{
		raise = monthlySalary + (monthlySalary * 0.10);
		monthlySalary = raise;
		return monthlySalary;
	} // end method Havearaise 

} // end class Employee
