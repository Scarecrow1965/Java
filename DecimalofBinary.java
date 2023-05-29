// exercise 4.32
// Write an application that inputs an integer containing only 0s
// and 1s (i.e., a binary integer) and prints its decimal equivalent.

import java.util.Scanner;

public class DecimalofBinary
{

	public static void main(String[] args)
	{
		// initializing variables
		long digital = 0;
		int decimal = 0;
		int base = 1;
		long remainder;

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
		
		System.out.println("This application will convert any digital number of 1s and 0s into a decimal number.");
		System.out.println("Enter your digital number:");
		digital = input.nextLong();
		
	    while (digital > 0)
	    {
	        remainder = digital % 10;
	        digital = digital / 10;
	        decimal += remainder * base;
	        base = base * 2;
	    }
				
		System.out.printf("The number you have provided is %d and it's decimal is: %d", digital, decimal);
	} // end method main

} // end class DecimalofBinary
