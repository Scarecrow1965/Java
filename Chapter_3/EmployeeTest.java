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

public class EmployeeTest {
	//access modifier public
	
	public static void main(String[] args) {

		// add employee list
		Employee employee1 = new Employee("John", "Doe", 1000.00);
		Employee employee2 = new Employee("Jane", "Smith", 2000.00);
		
		// print out employee current yearly totals
		System.out.printf("%s %s has a yearly salary of $%.2f.%n",
				employee1.getfirstName(), employee1.getlastName(), employee1.getmonthlySalary() * 12); 
		System.out.printf("%s %s has a yearly salary of $%.2f.%n",
				employee2.getfirstName(), employee2.getlastName(), employee2.getmonthlySalary() * 12); 

		// employee raise of 10%
		System.out.printf("%s %s receives a pay raise of 10 percent. Now they make $%.2f per month.%n",
				employee1.getfirstName(), employee1.getlastName(), employee1.Havearaise());
		System.out.printf("%s %s receives a pay raise of 10 percent. Now they make $%.2f per month.%n",
				employee2.getfirstName(), employee2.getlastName(), employee2.Havearaise());
		
		// print out employee current yealry totals
		System.out.println("Here is what they make now:");
		System.out.printf("%s %s has a yearly salary of $%.2f.%n",
				employee1.getfirstName(), employee1.getlastName(), employee1.getmonthlySalary() * 12); 
		System.out.printf("%s %s has a yearly salary of $%.2f.%n",
				employee2.getfirstName(), employee2.getlastName(), employee2.getmonthlySalary() * 12); 
				
	}// end method main

} // end class EmployeeTest