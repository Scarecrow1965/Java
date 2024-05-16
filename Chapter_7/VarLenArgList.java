// Exercise 7.14
/* (Variable-Length Argument List)
 * Write an application that calculates the product of a series of integers
 * that are passed to method product using a variable-length argument list.
 * Test your method with several calls, each with a different number of arguments.
 */

public class VarLenArgList
{

	//variable-length argument list.
	//method product listed here
	public static int product (int... numbers)
	{
		int total = 0;

		// calculate total using the enhanced for statement
		for (int d : numbers)
		{
			total += d;
		}

		return total;
	} // end method product

	public static void main(String[] args)
	{
		// Initializing variables
		int a = 10;
		int b = 20;
		int c = 100;
		int d = 200;
		int e = 50;
		int f = 30;

		System.out.println("This application will provide the product of integers using a variable-length argument list.");
		System.out.println("Attempt #1:");
		System.out.printf("Product of %d and %d is %d%n", a, b, product(a, b)); 
		System.out.println("Attempt #2:");
		System.out.printf("Product of %d, %d and %d is %d%n", c, d, e, product(c, d, e));
		System.out.println("Attempt #3:");
		System.out.printf("Product of %d, %d, %d and %d is %d%n", b, d, e, f, product(b, d, e, f));
		System.out.println("Attempt #4:");
		System.out.printf("Product of %d, %d and %d is %d%n", a, b, e, product(a, b, e));
		
	} // end method main

	

} // end class VarLenArgList
