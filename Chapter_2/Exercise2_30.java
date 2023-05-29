// Exercise 2.30
// Write an application that inputs one number consisting of five digits from the user,
// separates the number into its individual digits and prints the digits separated
// from one another by three spaces each. For example, if the user types in the number
// 42339, the program should print 4 2 3 3 9
// Assume that the user enters the correct number of digits.
// What happens when you enter a number with more than five digits?
// What happens when you enter a number with fewer than five digits?
// [Hint: It’s possible to do this exercise with the techniques you learned in this chapter.
// You’ll need to use both division and remainder operations to “pick off ” each digit.]

import java.util.Scanner; // program uses class Scanner

public class Exercise2_30 {
	// main method begins execution of Java application
	public static void main(String[] args) {
		// create Scanner to obtain input from command line
	    Scanner input = new Scanner(System.in);

	    System.out.print("Enter your 5 digit integer: "); // prompt 
	    int number = input.nextInt(); // read number from user

	    // source is https://www.javatpoint.com/java-program-to-break-integer-into-digits
	    // could only figure out the % but could not figure out the rest.
	    // also does not solve the issues if someone entered more or less than 5 integers
	    int digit1 = number / 10000 % 10;  
	    int digit2 = number / 1000 % 10;  
	    int digit3 = number / 100 % 10;  
	    int digit4 = number / 10 % 10;  
	    int digit5 = number % 10;
	    System.out.printf("The number you have entered is %d%n", number);
	    System.out.printf("The digits are %d %d %d %d %d.%n", digit1, digit2, digit3, digit4, digit5);
	} // end method main

} // end class Exercise2_30
