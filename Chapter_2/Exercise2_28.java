// Exercise 2.28
// Write an application that inputs from the user the radius of a circle
// as an integer and prints the circle’s diameter, circumference and area
// using the floating-point value 3.14159 for π. Use the techniques shown in Fig.2.7.
// [Note: You may also use the predefined constant Math.PI for the value of π.
// This constant is more precise than the value 3.14159. 
// Class Math is defined in package java.lang.
// Classes in that package are imported automatically, so you do not need to import
// class Math to use it.] Use the following formulas (r is the radius):
// diameter = 2 r
// circumference = 2 π r
// area = π r2
// Do not store the results of each calculation in a variable.
// Rather, specify each calculation as the value that will be output in a System.out.printf statement.
// The values produced by the circumference and area calculations are floating-point numbers.
// Such values can be output with the format specifier %f in a System.out.printf statement.

import java.util.Scanner; // program uses class Scanner

public class Exercise2_28 {
	// main method begins execution of Java application
	public static void main(String[] args) {
		// create a Scanner to obtain input from the command window
	    Scanner input = new Scanner(System.in);
	    
	    System.out.print("Enter the radius of your circle: "); // prompt 
	    int radius = input.nextInt(); // read value from user

	    // used https://docs.oracle.com/javase/tutorial/java/data/numberformat.html to get more info for the results
	    System.out.printf("The diameter of your circle is %d%n", (2 * radius));
	    System.out.printf("The circumferrence of your circle is %.4f%n", (2 * Math.PI * radius));
	    System.out.printf("The area of your circle is %.4f%n", (Math.PI * (radius * radius)));

	} // end method main

} // end class Exercise 2_28
