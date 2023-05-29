//Exercise 4.19
/*A large company pays its salespeople on a commission basis.
 * The salespeople receive $200 per week plus 9% of their gross sales for that week.
 * For example, a salesperson who sells $5,000 worth of merchandise in a week receives
 * $200 plus 9% of $5,000, or a total of $650.
 * You’ve been supplied with a list of the items sold by each salesperson.
 * The values of these items are shown in Fig.4.33.
 * Develop a Java application that inputs one salesperson’s items sold for last week
 * and calculates and displays that salesperson’s earnings.
 * There’s no limit to the number of items that can be sold.
 * Fig. 4.33
Item	Value
1	239.99
2	129.75
3	99.95
4	350.89
 */

import java.util.Scanner;

public class SalesComCalcTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		// initiating Sales Commission calculator
		SalesComCalc member1 = new SalesComCalc (" ",0,0);
				
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
						
		System.out.println("This is a Sales Commission Calculator for each member.");
		System.out.println("To exit this app, type 999 in Merchandise Sold#");
				
		System.out.print("Enter member's name: "); // prompt 
		String salesperson = input.next(); // read salesperson 
		member1.setSalesPerson(salesperson); // add salesperson to list	

		System.out.println("Enter first Merchandise Sold#:");
		System.out.println("Options are:");
		System.out.println("1: Duvet ($239.99)");
		System.out.println("2: Duvet Cover ($129.75)");
		System.out.println("3: Pillow ($99.95)");
		System.out.println("4: Bed Sheet Combo ($350.89)");
		int item = input.nextInt(); // read item
		member1.setItem(item); // adds item/sets gross sales to person
				
		while(item != 999)
		{
			System.out.println("Enter next Merchandise Sold#:"); // prompt 
			System.out.println("Options are:");
			System.out.println("1: Duvet ($239.99)");
			System.out.println("2: Duvet Cover ($129.75)");
			System.out.println("3: Pillow ($99.95)");
			System.out.println("4: Bed Sheet Combo ($350.89)");
			item = input.nextInt(); // read item
			member1.setItem(item); // adds item/sets gross sales to person				    
		} //end while statement

		System.out.println("Member: " + member1.getSalesPerson() + " has made $" + String.format("%.2f", member1.getGrossSales())
				+ " in sales and earned $" + String.format("%.2f", member1.getWeeklyComm()) + " in commission this week.\n");

	} // end method main

} // end class SalesComCalcTest
