// Exercise 5.13
// Write an application that calculates the factorials of 1 through 20.
// Use type long. Display the results in tabular format.

public class Factorials {

	public static void main(String[] args) {
		// initializing variables
		int counter = 1;
		long factorial = 1;
		
		System.out.println("This is an application that will display the factorial from 1 to 20.");

		while (counter <=20)
			{ 
		    	factorial = factorial * counter; // or result *= z;
		    	System.out.printf("factorial of %d\t is\t %d%n", counter, factorial);
		    	counter++; // reduces by 1 after
		  	}
		System.out.println("\n");

	} // end method main

} // end class Factorials
