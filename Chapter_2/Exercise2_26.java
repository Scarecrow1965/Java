// Exercise 2.26
//Write an application that reads two integers, determines whether the
// first is a multiple of the second and prints the result.
// [Hint: Use the remainder operator.]

import java.util.Scanner; // program uses class Scanner

public class Exercise2_26 {
	 // main method begins execution of Java application
	public static void main(String[] args) {
		 // create a Scanner to obtain input from the command window
	      Scanner input = new Scanner(System.in);
	      
	      System.out.println("This application will check if your first integer is a multiple of the second one");
	      System.out.print("Enter first integer: "); // prompt #1
	      int number1 = input.nextInt(); // read first number from user

	      System.out.print("Enter second integer: "); // prompt #2
	      int number2 = input.nextInt(); // read second number from user

	      if(number1 % number2 == 0) {
	    	  System.out.printf("%d is a multiple of %d%n", number1, number2);
	      }
	      else
	    	  System.out.printf("%d is not a multiple of %d%n", number1, number2);
	} // end method main

} // end class Exercise 2_26
