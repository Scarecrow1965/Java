// Exercise 6.10
/*  (Rounding Numbers) To round numbers to specific decimal places, use a statement like
double y = Math.floor(x * 10 + 0.5) / 10;
which rounds x to the tenths position (i.e., the first position to the right of the decimal point), or
double y = Math.floor(x * 100 + 0.5) / 100;
which rounds x to the hundredths position (i.e., the second position to the right of the decimal point).
Write an application that defines four methods for rounding a number x in various ways:
1.	roundToInteger(number)
2.	roundToTenths(number)
3.	roundToHundredths(number)
4.	roundToThousandths(number)
For each value read, your program should display the original value, the number rounded to the nearest
integer, the number rounded to the nearest tenth, the number rounded to the nearest hundredth and the
number rounded to the nearest thousandth.
 */

import java.util.Scanner;

public class RoundingNumbers2
{

	public static void main(String[] args)
	{
		// initializing variables
		double numbers;

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
		
		System.out.println("This is an application that will round your numbers.");
		System.out.println("Enter the your number: ");
		numbers = input.nextDouble(); // read number
		
		System.out.printf("The number you have entered is: %f%n", numbers);
		System.out.printf("The nearest integer is: %.0f%n" , roundToInterger(numbers) );
		System.out.printf("The nearest 10th is: %.1f%n", roundToTenths(numbers) );
		System.out.printf("The nearest 100th is %.2f%n", roundToHundredths(numbers) );
		System.out.printf("The nearest 1000th is %.3f%n", roundToThousandths(numbers) );

	} // end method main

	public static double roundToInterger (double x)
	{
		double y = Math.floor(x * 10 + 0.5) / 10;
		return y;
	}

	public static double roundToTenths(double x)
	{
		double y = Math.floor(x * 100 + 0.5) / 100;
		return y;
	}

	public static double roundToHundredths(double x)
	{
		double y = Math.floor(x * 1000 + 0.5) / 1000;
		return y;
	}

	public static double roundToThousandths(double x)
	{
		double y = Math.floor(x * 10000 + 0.5) / 10000;
		return y;
	}
} // end class RoundingNumbers2
