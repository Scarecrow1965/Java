// Exercise 6.24
/* An integer number is said to be a perfect number if its factors,
 * including 1 (but not the number itself), sum to the number.
 * For example, 6 is a perfect number, because 6 = 1 + 2 + 3.
 * Write a method isPerfect that determines whether parameter number is a perfect number.
 * Use this method in an application that displays all the perfect numbers between 1 and 1000.
 * Display the factors of each perfect number to confirm that the number is indeed perfect.
 * Challenge the computing power of your computer by testing numbers much larger than 1000.
 * Display the results.
 */

public class PerfectNumbers
{

	public static void main(String[] args)
	{
		// initializing variables
		int a;

		System.out.println("This application will see which numbers from 1 to 1000 are Perfect Numbers");

		for(a = 1; a <=1000; a++)
		{
			System.out.print("Integer " + a);
			isPerfect(a);
		}

	} // end method main

	public static void isPerfect(int a)
	{
		int i; // counter
		int sum = 0; // to find the perfect number

		for(i = 1; i < a; i++)
		{
			if(a % i == 0)
			{
				sum = sum + i;
			}
		}
		if(sum == a)
		{
			System.out.println(" is a perfect number");
			Factors(a);
		}
		else
		{
			System.out.println(" is not a perfect number");
		}
	}

	public static void Factors(int a)
	{
		// now to find out what the factors are
		int x; // temp variable
		String displayDigit = "";
		
		System.out.println("Version 1");
		System.out.print("The factors are: 1 ");
		
		for(int factor = 2; factor < a; factor++)
		{
			x = a % factor;
			if(x == 0)
			{
				// trying to print out + between multiple numbers
				System.out.print("+ ");
				displayDigit = factor + " ";
				System.out.print(displayDigit);
			}
		}
		System.out.println();
		
		System.out.println("Version 2");
		System.out.print("The factors are: ");
		
		for(int factor = 1; factor < a; factor++)
		{
			x = a % factor;
			if(x == 0)
			{
				// trying to print out + between multiple numbers
				displayDigit = factor + " ";
				System.out.print(displayDigit);
			}
		}
		System.out.println();
		
	}
	
} // end class PerfectNumbers
