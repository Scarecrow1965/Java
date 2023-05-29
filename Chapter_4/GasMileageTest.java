// Exercise 4.17
/* Drivers are concerned with the mileage their automobiles get.
 * One driver has kept track of several trips by recording the miles driven
 * and gallons used for each tankful.
 * Develop a Java application that will input the miles driven and gallons used
 * (both as integers) for each trip.
 * The program should calculate and display the miles per gallon obtained for each
 * trip and print the combined miles per gallon obtained for all trips up to this point.
 * All averaging calculations should produce floating-point results.
 * Use class Scanner and sentinel-controlled iteration to obtain the data from the user. */

import java.util.Scanner;

public class GasMileageTest
{

	public static void main(String[] args)
	{
		// initiating trip calculator
		GasMileage user = new GasMileage (0,0,0,0,0,0,0);
		
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
				
		System.out.println("This is a trip calculator.");
		System.out.println("To exit this app, type 999 in trip number");
		
		System.out.print("Enter trip number: "); // prompt 
		int trip = input.nextInt(); // read trip number from user
		user.setTrip(trip); // add trip to user	

		while(trip != 999)
		{
			System.out.print("Enter miles done: "); // prompt 
		   	int milesdriven = input.nextInt(); // read miles driven from user
		   	user.setMilesDriven(milesdriven);
			    	
		   	System.out.print("Enter gallons used: "); // prompt 
		   	int gallonsused = input.nextInt(); // read gallons used from user
		   	user.setGallonsUsed(gallonsused);
		   	
		   	System.out.printf("Your average of miles driven is %d for %d trips%n", user.getTotalMiles() / user.getTripTotal(), user.getTripTotal());
		   	System.out.printf("Your average miles per gallon is %.2f%n", user.CalTripAverage());
		   	
		   	System.out.print("Enter trip number: "); // prompt 
			trip = input.nextInt(); // read trip number from user
			user.setTrip(trip); // add trip to user	
		    
		} //end while statement

	} // end method main

} // end class GasMileageTest
