// Exercise 4.38
// 1.	Write an application that reads a nonnegative integer and computes and prints its factorial.
// 2.	Write an application that estimates the value of the mathematical constant e by using the following formula.
// Allow the user to enter the number of terms to calculate.
// 3.	Write an application that computes the value of ex by using the following formula.
// Allow the user to enter the number of terms to calculate.

import java.util.Scanner;

public class Factorial
{

	public static void main(String[] args)
	{
		// initializing variables
		int a = 1; // used in factorials
		int b = 1; // used in constant e
		int c = 1; // used in e to the power of x as e
		int d = 1; // used in e to the power of x as x
		double constantE; // used in constant e
		int counter; // used as a temp int;
		double y = 0.0;
		double powerof; //used as a temp int
		int factorial = 1;
		double eX;
		
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("This is application number 1:");
		System.out.println("This is an application that will detemine the factorial of what you have entered.");
		System.out.println("Enter number:");
		a = input.nextInt(); // read number
		
		counter = a;
		if (counter == 0 || counter == 1)
			{
				System.out.println("Factorial is 1");
			}
		while (counter > 1)
			{ 
		    	factorial = factorial * counter; // or result *= z;
		    	counter--; // reduces by 1 after
		  	}
		System.out.printf("Factorial of %d is %d%n", a, factorial);
		System.out.println("\n");
		
		System.out.println("This is application number 2:");
		System.out.println("This is an application that will detemine the mathematical constant e what you have entered.");
		System.out.println("Enter number:");
		b = input.nextInt(); // read number
		
		counter = b;
		
		if (counter == 0 || counter == 1)
			{
				System.out.println("constant e is 1");
			}
		while (counter > 1)
			{ 
	    		y += 1.0 / counter;
	    		counter--; // reduces by 1 after
			}
		constantE = 1 + y;
		
		System.out.printf("constant e of %d is %f%n", b, constantE);
		System.out.println("\n");
		
		System.out.println("This is application number 3:");
		System.out.println("This is an application that will determine the value of e to the power of x from what you have entered.");
		System.out.println("Enter value of e:");
		c = input.nextInt(); // read number
		System.out.println("Enter value of power to the x:");
		d = input.nextInt(); // read number
		
		// formula taken from http://lia.disi.unibo.it/Courses/PMA4DS1718/materiale/lab/code/IM_jhtp7_ch04.pdf
		powerof = 1.0;
		counter = 1;
		factorial = 1;
		eX = 1.0;
		
		while ( counter < c )
		{
		 powerof *= d;
		 factorial *= counter;
		 eX += powerof / factorial;
		 counter++;
		 } // end while loop
		
		System.out.printf("You have entered value e (%d) to the power of x (%d) is equal to %f%n", c, d, eX);
		
	} // end method main
}// end class Factorial
