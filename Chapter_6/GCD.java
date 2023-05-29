//Exercise 6.27
/* (Greatest Common Divisor)
 * The greatest common divisor (GCD) of two integers is the largest integer that evenly
 * divides each of the two numbers.
 * Write a method gcd that returns the greatest common divisor of two integers.
 * [Hint: You might want to use Euclid’s algorithm.
 * You can find information about it at https:en.wikipedia.org/wiki/Euclidean_algorithm.]
 * Incorporate the method into an application that reads two values from the user and displays the result.
 */

import java.util.Scanner;

public class GCD
{

	public static void main(String[] args)
	{
		// initializing variables
		int num1;
		int num2;
		int gcd;
		
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("This application wil find the GCD (Greatest Common Divisor) from two integer you will provide.");
		System.out.println("Enter the first integer:");
		num1 = input.nextInt(); // read integer num1
		System.out.println("Enter the second integer:");
		num2 = input.nextInt(); // read integer num2

		System.out.printf("Your GCD is: %d%n", GCD(num1, num2) );

	} // end method main

	public static int GCD(int num1, int num2)
	{
		//https://beginnersbook.com/2018/09/java-program-to-find-gcd-of-two-numbers/
//		int gcd = 0;
//		for(int i = 1; i <= num1 && i <= num2; i++)
//		{
//			if(num1 % i == 0 && num2 % i == 0)
//				gcd = i;
//		}
//		return gcd;

		int gcd = 0;
		if(num1 < num2)
		{
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		while(num2 > 0)
		{
			int temp = num1 % num2;
			num1 = num2;
			num2 = temp;
		}
		gcd = num1;
		return gcd;
	}
	
} // end class GCD
