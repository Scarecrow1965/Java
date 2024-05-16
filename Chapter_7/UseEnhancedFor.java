// Exercise 7.16
/* (Using the Enhanced for Statement)
 * Write an application that uses an enhanced for statement to sum the double values
 * passed by the command-line arguments.
 * [Hint:Use the static method parseDouble of class Double to convert a String to a double value.]
 */

public class UseEnhancedFor
{

	public static void main(String[] args)
	{
		// Initializing variables
		double total = 0;
		double number;
		

		
		// to get the array size from the CLI
		int arrayLength = Integer.parseInt(args[0]);
		double [] argCLI = new double[arrayLength];
				
		// If statement to provide error if entered improperly
		if(args.length != arrayLength + 1)
		{
			System.out.printf("Error: please re-enter the entire command,%n"
				+ " including an array size (integer),%n"
				+ " an initial double value and additional double values depending on the size of the array.%n");
//		System.out.println("This application will provide the sum of double values using the CLI.");
//		System.out.println("the first criteria in the CLI will be the integer array length");
//		System.out.println("The next will be the double numbers");
		}

		for (int counter = 0; counter < argCLI.length; counter++)
		{
			number = Double.parseDouble(args[counter]);
			total += number;
		}
		System.out.printf("You have entered: %d for the size of the array.%n", arrayLength);
		for (int counter = 1; counter <= argCLI.length; counter++)
		{
			System.out.printf("You have entered: %s%n", args[counter]);
		}
		System.out.printf("The sum of what you have entered is: %f%n", total);

	} // end method main

} // end class UseEnhancedFor
