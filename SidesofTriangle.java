// Exercise 4.36
// Write an application that reads three nonzero values entered by the user 
// and determines and prints whether they could represent the sides of a triangle.

import java.util.Scanner;

public class SidesofTriangle
{

	public static void main(String[] args)
	{
		// initializing variables
		int a;
		int b;
		int c;
		
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("This is an application that will detemine if the dimensions you have entered is a triangle.");
		System.out.println("Enter side a:");
		a = input.nextInt(); // read side a
		System.out.println("Enter side b:");
		b = input.nextInt(); // read side b
		System.out.println("Enter side c:");
		c = input.nextInt(); // read side c
		
		// formula 1 = a + b > c
		// formula 2 = a + c > b
		// formula 3 = b + c > a
		
		if(a + b > c)
		{
			if(a + c > b)
			{
				if(b + c > a)
				{
					System.out.println("This is a triangle.");
				}
				else
				{
					System.out.println("This is not a triangle.");
				}
			}
			else
			{
				System.out.println("This is not a triangle.");
			}
		}
		else
			{
				System.out.println("This is not a triangle.");
			}
		System.out.println("Thank you for participating.");

	} // end method main

} // end class SidesofTriangle
