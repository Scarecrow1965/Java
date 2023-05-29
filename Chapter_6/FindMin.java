// Exercise 6.23
/* (Find the Minimum) Write a method minimum3 that returns the smallest of
 * three floating-point numbers.
 * Use the Math.min method to implement minimum3.
 * Incorporate the method into an application that reads three values from the user,
 * determines the smallest value and displays the result.
 */

import java.util.Scanner;

public class FindMin
{

	public static void main(String[] args)
	{
		// initializing variables
		int a;
		int b;
		int c;

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("This application wil find the smallest integer from the three you will provide.");
		System.out.println("Enter the first integer:");
		a = input.nextInt(); // read integer a
		System.out.println("Enter the second integer.");
		b = input.nextInt(); // read integer b
		System.out.println("Enter the third integer.");
		c = input.nextInt(); // read integer c

		System.out.printf("The smallest integer you have typed in is %d%n", minimum3(a, b, c) );
	} // end method main

	public static int minimum3 (int a, int b, int c)
	{
		int minimum1 = Math.min(a, b);
		int minimum2 = Math.min(minimum1, c);
		int minimum = minimum2;
		return minimum;
	}

} // end class FindMin
