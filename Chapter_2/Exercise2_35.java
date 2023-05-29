//Exercise 2.35
// Research several car-pooling websites. Create an application that calculates
// your daily driving cost, so that you can estimate how much money could be saved
// by car pooling, which also has other advantages such as reducing carbon emissions
// and reducing traffic congestion. The application should input the following
// information and display the user’s cost per day of driving to work:
// 1.	Total miles driven per day. (I will change this to km as we are Canadian)
// 2.	Cost per gallon of gasoline. (I will change this to litres as we are Canadian)
// 3.	Average miles per gallon. (I will change this to km/litres as we Canadian)
// 4.	Parking fees per day.
// 5.	Tolls per day.

import java.util.Scanner; // program uses class Scanner

public class Exercise2_35 {
	// main method begins execution of Java application
   public static void main (String [] args) {
	   // create Scanner to obtain input from command line
	   Scanner input = new Scanner (System.in);
       
	   // initializing variables
       int totalkm; 
       int gasolineCost; 
       int kmPerlt; 
       int parkingFees; 
       int tolls;
       int DrivingCost;
       
       // getting data
       System.out.println ("This Application Calculates Your Canadian Daily Driving Cost");
       System.out.print ("Enter your Total Kilometers(km) Driven Per Day: "); // prompt
       totalkm = input.nextInt(); // read totalkm from user
       System.out.print ("Enter the current Cost Per Litre(lt) Of Gasoline: "); // prompt
       gasolineCost = input.nextInt(); // read gasolineCost from user
       System.out.print ("Enter the vehicles' Average km/lt: "); // prompt
       kmPerlt = input.nextInt(); // read kmPerlt from user
       System.out.print ("Enter how much the Parking Fees are: "); // prompt
       parkingFees = input.nextInt(); // read parkingFees from user
       System.out.print ("Enter how much the Tolls cost per day: "); // prompt
       tolls = input.nextInt(); // read tolls from user
       
       // formula
       DrivingCost = ((totalkm / kmPerlt) * gasolineCost) + parkingFees + tolls;
       
       // output
       System.out.println("\n"); //extra line for spacing
       System.out.printf ("Your Daily Driving Cost Is: %d\n", DrivingCost);

   } // end method main
} // end class Exercise2_35