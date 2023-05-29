// Exercise 6.6
/* Declare method sphereVolume to calculate and return the volume of the sphere.
 * Use the following statement to calculate the volume:
double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3)
Write a Java application that prompts the user for the double radius of a sphere,
calls sphereVolume to calculate the volume and displays the result.
  */

import java.util.Scanner;

public class SphereVolume
{

	public static void main(String[] args)
	{

		// initializing variables
		double radius;

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
		
		System.out.println("This is an application that will detemine the volume of a sphere from the radius you enter.");
		System.out.println("Enter the radius of the sphere:");
		radius = input.nextDouble(); // read amount of radius
		
		System.out.printf("The volume of your sphere is: %f%n", sphereVolume(radius));

	} // end method main
	
	//method sphereVolume
	public static double sphereVolume(double radius)
	{
		// formula for sphere: double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3)
		double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
		return volume;
	} // end method sphereVolume

} // end class SphereVolume
