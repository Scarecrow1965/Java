// Exercise 5.11
// Write an application that finds the smallest of several integers.
// Assume that the first value read specifies the number of values to input from the user.

import java.util.Scanner;

public class FindSmallestValue
{

	public static void main(String[] args)
	{
		// initializing variables
		int totvars;
		int vars;
		int smallest;
		
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
		
		System.out.println("This is an application that will detemine the smallest integer you have entered.");
		System.out.println("Enter the amount of variables you want to enter:");
		totvars = input.nextInt(); // read amount of variables
		System.out.println("Enter your first variable:");
		vars = input.nextInt(); // read first variable
		smallest = vars;
		
		for(int i=1; i <totvars; i++)
		{
			System.out.println("Enter your next variable:");
			vars = input.nextInt(); // reads next variable
			if(vars < smallest)
			{
				smallest = vars;
			}
			else
			{
				continue;
			}
		}
		System.out.printf("The smallest variable you have entered is %d:%n", smallest);
		
	} //end method main

}// end class FindSmallestValue
