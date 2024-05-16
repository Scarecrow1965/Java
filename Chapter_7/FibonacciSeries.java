// Exercise 7.29
/*) The Fibonacci series
0, 1, 1, 2, 3, 5, 8, 13, 21, …
begins with the terms 0 and 1 and has the property that each succeeding term is the sum of the two preceding terms.
1.	Write a method fibonacci(n) that calculates the nth Fibonacci number.
 Incorporate this method into an application that enables the user to enter the value of n.
2.	Determine the largest Fibonacci number that can be displayed on your system.
3.	Modify the application you wrote in part (a) to use double instead of int to calculate and return Fibonacci numbers,
and use this modified application to repeat part (b).

https://en.wikipedia.org/wiki/Fibonacci_number
 */

import java.util.Scanner;

public class FibonacciSeries
{

	public static void main(String[] args)
	{
		// initializing variables
		int n;
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
		
		System.out.println("This application will provide you with the Fibonacci Series to what number you provide.");
		System.out.println("Please enter your number:");
		n = input.nextInt();
		
		Fibonacci1(n);
		Fibonacci3(n);

	} //end method main

	public static void Fibonacci1(int n)
	{
		int f1 = 0;
		int f2 = 1;
		int fibonacci;
		System.out.println("Part 1: The result of the Fibonacci Series is:");
		for(int i = 2; i < n; i++)
		{
			fibonacci = f1 + f2;
			System.out.printf("%d, ", fibonacci);
			f1 = f2;
			f2 = fibonacci;
		}
		System.out.println();
	} // end method Fibonacci1

	public static void Fibonacci3(int n)
	{
		double f1 = 0;
		double f2 = 1;
		double fibonacci;
		System.out.println("Part 3: The result of the Fibonacci Series is:");
		for(int i = 2; i < n; i++)
		{
			fibonacci = f1 + f2;
			System.out.printf("%.1f, ", fibonacci);
			f1 = f2;
			f2 = fibonacci;
		}
		System.out.println();
	} // end method Fibonacci3

} // end class FibonacciSeries
