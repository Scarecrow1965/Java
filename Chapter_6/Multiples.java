import java.util.Scanner;

// Exercise 6.16
/* (Multiples) Write a method isMultiple that determines, for a pair of integers,
 * whether the second integer is a multiple of the first.
 * The method should take two integer arguments and return true if the second is a
 * multiple of the first and false otherwise.
 * [Hint: Use the remainder operator.]
 * Incorporate this method into an application that inputs a series of pairs of
 * integers (one pair at a time) and determines whether the second value in each
 * pair is a multiple of the first.
 */

import java.util.Scanner;

public class Multiples
{

	public static void main(String[] args)
	{
		// initializing variables
		int a;
		int b;

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("This is an application that determine if the second integer is a multiple of the first integer.");
		System.out.println("Enter the first integer: ");
		a = input.nextInt(); // read first integer
		System.out.println("Enter the second integer: ");
		b = input.nextInt(); // read second integer
		
		System.out.printf("You have entered integer %d and integer %d.%n", a, b);
		System.out.printf("Integer %d %s of %d.%n", b, isMultiple(a, b), a);

	} // end method main

	public static String isMultiple (int a, int b)
	{
		double multiple = b % a;
		if(multiple == 0)
		{
			return "is a multiple";
		}
		else
		{
			return "is not a multiple";
		}
	}

} // end class Multiples
