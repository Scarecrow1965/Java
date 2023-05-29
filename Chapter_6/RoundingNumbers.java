// Exercise 6.9
/* (Rounding Numbers)
Math.floor can be used to round values to the nearest integer - e.g.,
double y = Math.floor(x + 0.5);
will round the number x to the nearest integer and assign the result to y.
Write an application that reads double values and uses the preceding statement
to round each of the numbers to the nearest integer. For each number processed,
display both the original number and the rounded number.
  */

import java.util.Scanner;

public class RoundingNumbers {

	public static void main(String[] args) {
		// initializing variables
		double x;
		double y;
		
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
		
		System.out.println("This is an application that will round your numbers to the nearest integer.");
		System.out.println("Enter the your number: ");
		x = input.nextDouble(); // read amount of radius
		
		y = Math.floor(x + 0.5);
		
		System.out.printf("The number you have entered is %f and its nearest integer is %.0f%n", x, y);
	
	} //end method main

} // end 
