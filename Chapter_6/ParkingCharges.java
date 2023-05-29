// Exercise 6.8
/* A parking garage charges a $2.00 minimum fee to park for up to three hours.
 * The garage charges an additional $0.50 per hour for each hour or part thereof
 * in excess of three hours.
 * The maximum charge for any given 24-hour period is $10.00.
 * Assume that no car parks for longer than 24 hours at a time.
 * Write an application that calculates and displays the parking charges for each
 * customer who parked in the garage yesterday.
 * You should enter the hours parked for each customer.
 * The program should display the charge for the current customer and should calculate
 * and display the running total of yesterday’s receipts.
 * It should use the method calculateCharges to determine the charge for each customer.
 */

import java.util.Scanner;

public class ParkingCharges {

	public static void main(String[] args) {

		// initializing variables
		double tothours = 0.0;
		double totreceipts = 0.0;
		double fee;
		String vehicle;
		
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
		
		System.out.println("This is an application that will detemine how much the parking fee will be.");
		System.out.println("Enter -1 to hours spent in parking lot to quit.");
		
		System.out.println("Enter the first vehicle licence number: ");
		vehicle = input.next(); // read vehicle number
		
		System.out.println("Enter the hours spent in parking lot: ");
		tothours = input.nextDouble(); // read hours spent
		
		while(tothours != -1)
		{
			fee = calculateCharges(tothours);
			totreceipts += fee;
			System.out.printf("Vehicle: %s owes: %.2f%n", vehicle, fee);
			System.out.printf("Total receipts for yesterday is: %.2f%n", totreceipts);
			
			System.out.println("Enter the next vehicle licence number: ");
			vehicle = input.next(); // read vehicle number
			
			System.out.println("Enter the hours spent in parking lot: ");
			tothours = input.nextDouble(); // read hours spent
		}
	
	} // end method main

	// method calculateCharges
	public static double calculateCharges(double tothours)
	{
		// notes:
		// maximum charge is 10.00 for > 24 hours
		// minimum charge is 2.00 for < 3 hours
		// charge .50 for hour > 3 hours
		double fee;
		if(tothours <= 3)
		{
			fee = 2.00;
			return fee;
		}
		else
		{
			fee = 2.00;
			double hours = tothours - 3;
			fee += hours * .5;
			if (fee > 10.00)
			{
				fee = 10.00;
				return fee;
			}
			else
			{
				return fee;
			}
		}	
	}// end method calculateCharges
	
} // end class ParkingCharges
