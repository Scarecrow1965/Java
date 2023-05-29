// Exercise 4.37
// Write an application that reads three nonzero integers and
// determines and prints whether they could represent the sides of a right triangle.

import java.util.Scanner;

public class SidesofRightTriangle
{

	public static void main(String[] args)
	{
		// initializing variables
		int a;
		int b;
		int c;
		
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		// Option 1
		System.out.println("This is an application that will detemine if the dimensions you have entered is a right triangle.");
		System.out.println("Enter side a:");
		a = input.nextInt(); // read side a
		System.out.println("Enter side b:");
		b = input.nextInt(); // read side b
		System.out.println("Enter side c: (must be the longest side)");
		c = input.nextInt(); // read side c

		// formula = a*a + b*b = c*c
		if(a*a + b*b == c*c)
		{
			System.out.println("This is a right triangle.");
		}
		else
		{
			System.out.println("This is not a right triangle.");
		}
		System.out.println("Thank you.");
	
//		// Option2 taken from https://www.youtube.com/watch?v=e1B7QdaCnik
//		if(a>b && a>c)
//		{
//			int hypo=a;
//			if(hypo*hypo == b*b+c*c)
//			{
//				System.out.println("This is a right Triangle.");
//			}
//		}
//		if(b>a && b>c)
//		{
//			int hypo=b;
//			if(hypo*hypo == a*a+c*c)
//			{
//				System.out.println("This is a right Triangle.");
//			}
//			
//		}
//		if(c>a && c>b)
//		{
//			int hypo=c;
//			if(hypo*hypo == a*a+b*b)
//			{
//				System.out.println("This is a right Triangle.");
//			}
//			
//		}
	} // end method main

} // end class SidesofRightTriangle
