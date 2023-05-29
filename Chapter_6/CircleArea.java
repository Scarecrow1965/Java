// Exercise 6.20
/* (Circle Area) Write an application that prompts the user for the radius of
 * a circle and uses a method called circleArea to calculate the area of the circle.
 */

import java.util.Scanner;

public class CircleArea
{

	public static void main(String[] args)
	{
		// initializing variables
		int radius;

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("This is an application that determine if the area of a circle from the radius you enter.");
		System.out.println("Enter the radius of the circle: ");
		radius = input.nextInt(); // read amount of radius

		System.out.printf("with a %d as radius, the area of a circle is %f%n", radius, circleArea(radius) );

	} // end method main

	public static double circleArea (int radius)
	{
		double circlearea = Math.PI * Math.pow(radius, 2);
		return circlearea;
	}

} //end class CircleArea
