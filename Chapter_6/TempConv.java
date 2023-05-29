// Exercise 6.22
/*  Implement the following integer methods:
1.	Method celsius returns the Celsius equivalent of a Fahrenheit temperature,
using the calculation celsius = 5.0 / 9.0 * (fahrenheit - 32);
2.	Method fahrenheit returns the Fahrenheit equivalent of a Celsius temperature,
using the calculation fahrenheit = 9.0 / 5.0 * celsius + 32;
3.	Use the methods from parts (a) and (b) to write an application that enables the
user either to enter a Fahrenheit temperature and display the Celsius equivalent
or to enter a Celsius temperature and display the Fahrenheit equivalent.
 */

import java.util.Scanner;

public class TempConv
{

	public static void main(String[] args)
	{
		// initializing variables
		int a; // used to decipher temp kind
		double celsius;
		double fahrenheit;

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("This application will convert temperatures to either Celcius or Fahrenheit.");
		System.out.println("Enter 1 to convert Fahrenheit to Celcius or,");
		System.out.println("Enter 2 to convert Celsius to Fahrenheit.");
		a = input.nextInt(); // read integer a

		switch (a)
		{
		case 1:
		{
			System.out.println("Enter the Fahrenheit Temp: ");
			fahrenheit = input.nextDouble(); // read Double fahrenheit
			System.out.printf("%.1f degrees Fahrenheit (°F) = %.1f degrees Celsius (°C).%n", fahrenheit, Celsius(fahrenheit) );
			return;
		}
		case 2:
		{
			System.out.println("Enter the Celsius Temp: ");
			celsius = input.nextDouble(); // read double celsius
			System.out.printf("%.1f degrees Celsius (°C) = %.1f degrees Fahrenheit (°F).%n", celsius, Fahrenheit(celsius) );
			return;
		}
		}

	} // end method main

	public static double Celsius(double fahrenheit)
	{
		double celsius = 5.0 / 9.0 * (fahrenheit - 32);
		return celsius;
	}

	public static double Fahrenheit(double celsius)
	{
		double fahrenheit = 9.0 / 5.0 * celsius + 32;
		return fahrenheit;
	}

} // end class TempConv
