// Exercise 5.17
/* An online retailer sells five products whose retail prices are as follows:
 * Product 1, $2.98;
 * product 2, $4.50;
 * product 3, $9.98;
 * product 4, $4.49 and
 * product 5, $6.87.
 * Write an application that reads a series of pairs of numbers as follows:
1.	product number
2.	quantity sold
Your program should use a switch statement to determine the retail price for each product.
It should calculate and display the total retail value of all products sold.
Use a sentinel-controlled loop to determine when the program should stop looping and display the final results.
*/
import java.util.Scanner;

public class CalculatingSales
{

	public static void main(String[] args)
	{
		//initializing variables
		int prod = 0;
		int qty = 0;
		double price = 0.0;
		double totprice = 0.0;
		
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
		
		System.out.println("This application will display the total amount of product sold and total retail value.");
		System.out.println("to finish inputing, please type in 999 in product number");
		System.out.println("Enter the product number:");
		prod = input.nextInt(); // read product
		
		while(prod != 999)
			{
				switch(prod)
					{
						case 1:
							price = 2.98;
							break;
						case 2:
							price = 4.50;
							break;
						case 3:
							price = 9.98;
							break;
						case 4:
							price = 4.49;
							break;
						case 5:
							price = 6.87;
							break;
					}
				System.out.println("Enter the quantity sold:");
				qty = input.nextInt(); // read quantity
				totprice += (price * qty);
				
				System.out.println("Enter the product number:");
				prod = input.nextInt(); // read product
			}
		System.out.printf("The total amount of retail value is: $%.02f%n", totprice);
		
	}// end method main

} // end class CalculatingSales
