//  Exercise 8.4
/*(Rectangle Class)
 * Create a class Rectangle with attributes length and width, each of which defaults to 1.
 * Provide methods that calculate the rectangle’s perimeter and area.
 * It has set and get methods for both length and width.
 * The set methods should verify that length and width are each floating-point numbers larger
 * than 0.0 and less than 20.0.
 * Write a program to test class Rectangle. */

import java.util.Scanner;

public class RectangleTest
{

	public static void main(String[] args)
	{
		// initializing variables
		Rectangle Test = new Rectangle (0.0, 0.0, 0.0, 0.0);
		
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
		
		System.out.println("This application will determine the perimeter and area of a rectangle");
		System.out.println("with the length and width you provide");
		System.out.println("Please ensure the dimensions are not smaller than 0 and bigger than 20.0");
		System.out.println("Please enter the length:");
		double length = input.nextDouble();
		Test.SetLength(length);
		System.out.println("Please enter the width:");
		double width = input.nextDouble();
		Test.SetWidth(width);
		
		System.out.printf("The length you have provided is %f%n", (float) Test.GetLength() );
		System.out.printf("The width you have provided is %f%n", (float) Test.GetWidth() );
		System.out.printf("The Perimeter of your rectangle is: %%n", (float) Test.Perimeter(Test.GetLength(), Test.GetWidth()) );
		System.out.printf("The Area of your rectangle is: %f%n", (float) Test.Area(Test.GetLength(), Test.GetWidth()) );

	} // end method main

} // end class RectangleTest
