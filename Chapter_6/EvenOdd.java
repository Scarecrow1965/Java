// Exercise 6.17
/* (Even or Odd) Write a method isEven that uses the remainder operator (%) to determine
 * whether an integer is even.
 * The method should take an integer argument and return true if the integer is even
 * and false otherwise.
 * Incorporate this method into an application that inputs a sequence of integers
 * (one at a time) and determines whether each is even or odd.
 */

import java.util.Scanner;

public class EvenOdd
{

	public static void main(String[] args)
	{
		// initializing variables
		int a;

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("This is an application that determine if the integer you have entered is Even or Odd.");
		System.out.println("Enter -1 to quit.");
		System.out.println("Enter the your number: ");
		a = input.nextInt(); // read amount of radius

		while(a != -1)
		{
			System.out.printf("Integer %d %s.%n", a, isEven(a) );
			
			System.out.println("Enter the your number: ");
			a = input.nextInt(); // read amount of radius
		}

	} // end method main

	public static String isEven(int a)
	{
		if(a % 2 == 0)
		{
			return "is an Even number";
		}
		else
			{
			return "is an Odd number"; 
			}
	}

} // end class EvenOdd
