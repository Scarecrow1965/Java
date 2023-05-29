// Exercise 6.21
/* (Separating Digits) Write methods that accomplish each of the following tasks:
1.	Calculate the integer part of the quotient when integer a is divided by integer b.
2.	Calculate the integer remainder when integer a is divided by integer b.
3.	Use the methods developed in parts (a) and (b) to write a method displayDigits that
receives an integer between 1 and 99999 and displays it as a sequence of digits,
separating each pair of digits by two spaces.
For example, the integer 4562 should appear as
4 5 6 2
Incorporate the methods into an application that inputs an integer
and calls displayDigits by passing the method the integer entered.
Display the results.
*/

import java.util.Scanner;

public class SepDigits
{

	public static void main(String[] args) 
	{
		// initializing variables
		int a = 0;
		int b = 0;
		int number = 0;

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("Part 1:");
		System.out.println("Calculate the integer part of the quotient when integer a is divided by integer b.");
		System.out.println("Enter the integer a: ");
		a = input.nextInt(); // read integer a
		System.out.println("Enter the integer b: ");
		b = input.nextInt(); // read integer b

		if(b <= 0)
		{
			System.out.println("Cannot divide by zero or less than zero!!");
		}
		else
		{
			System.out.printf("The quotient of %d / %d is: %d%n", a, b, Quotient(a, b) );
			
		}

		System.out.println("Part 2:");
		System.out.println("Calculate the integer remainder when integer a is divided by integer b.");
		System.out.printf("the remainder of %d / %d is: %d%n", a, b, Remainder(a,b) );
		
		System.out.println("Part 3:");
		System.out.println("Use the methods developed in parts (a) and (b) to write a method displayDigits,");
		System.out.println("displays it as a sequence of digits, separating each pair of digits by two spaces.");
		System.out.println("Number must be between 1 and 99_999.");
		System.out.println("Enter a number: ");
		number = input.nextInt(); // read integer c
		System.out.printf("The number you have entered is %d%n", number);
		displayDigits(number);

	} // end method main
	
	// part 1
	public static int Quotient(int a, int b)
	{
		return a / b;
	}

	// part 2
	public static int Remainder(int a, int b)
	{
		return a % b;
	}

	// part 3
	public static void displayDigits(int number)
	{
		int base = 1;
		int digit;
		String displayDigit = "";

		// to start from highest digit and work way down 
		for(int i = 1; i < number; i *= 10)
		{
			base = i;
		}
			while(base >= 1)
			{
				digit = Quotient(number, base); // finds the number
				
				displayDigit += digit + "  ";
				
				number = Remainder(number, base); // finds what is left
				base = Quotient(base, 10);
			}
		System.out.print(displayDigit);
	}

} // end class SepDigits
