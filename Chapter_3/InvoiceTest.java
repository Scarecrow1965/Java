/* Exercise 3.12	(Invoice Class) Create a class called Invoice that
a hardware store might use to represent an invoice for an item sold at the store.
An Invoice should include four pieces of information as instance variables — 
-a part number (type String),
-a part description (type String),
-a quantity of the item being purchased (type int) and
-a price per item (double).
Your class should have a constructor that initializes the four instance variables.
-Provide a set and a get method for each instance variable.
-In addition, provide a method named getInvoiceAmount that calculates the
invoice amount (i.e., multiplies the quantity by the price per item),
then returns the amount as a double value.
-If the quantity is not positive, it should be set to 0.
-If the price per item is not positive, it should be set to 0.0.
-Write a test app named InvoiceTest that demonstrates class Invoice’s capabilities.*/

import java.util.Scanner;

public class InvoiceTest {

	public static void main(String[] args)
	{
		// create invoices
		Invoice item1 = new Invoice("PN01234", "thingamajiggy", 3, 12.00);
		Invoice item2 = new Invoice("PN56789", "whatchamacallit", 5, 20.00);
		Invoice item3 = new Invoice("", "", 0, 00.00);
		
		// print out invoices
		System.out.printf("Item %s %s has quantity %d and costs $%.2f per item %n", item1.getPartNumber(), item1.getDescription(), item1.getQuantity(), item1.getPrice()); 
		System.out.printf("Item %s %s has quantity %d and costs $%.2f per item %n", item2.getPartNumber(), item2.getDescription(), item2.getQuantity(), item2.getPrice());
		
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		// create invoice number 3
		System.out.print("Enter the part number for the item3: "); // prompt
		String partNumber = input.next(); // obtain user input
		item3.setPartNumber(partNumber); // add partNumber to item3
		
		System.out.print("Enter the description for the item3: "); // prompt
		String description = input.next(); // obtain user input
		item3.setDescription(description); // add description to item3
		
		System.out.print("Enter quantity for the item3: "); // prompt
		int quantity = input.nextInt(); // obtain user input
		item3.setQuantity(quantity); // add quantity to item3
		   
		System.out.print("Enter price for item3: "); // prompt
		double pricePerItem = input.nextDouble(); // obtain user input
		item3.setPrice(pricePerItem); // add to price to item3
		
		//display of all items in inventory
		System.out.printf("Item %s %s has quantity %d and costs $%.2f per item %n", item1.getPartNumber(), item1.getDescription(), item1.getQuantity(), item1.getPrice()); 
		System.out.printf("Item %s is costing you $%.2f%n", item1.getPartNumber(), item1.getInvoiceAmount());
		System.out.printf("Item %s %s has quantity %d and costs $%.2f per item %n", item2.getPartNumber(), item2.getDescription(), item2.getQuantity(), item2.getPrice());
		System.out.printf("Item %s is costing you $%.2f%n", item1.getPartNumber(), item2.getInvoiceAmount());
		System.out.printf("Item %s %s has quantity %d and costs $%.2f per item %n", item3.getPartNumber(), item3.getDescription(), item3.getQuantity(), item3.getPrice());
		System.out.printf("Item %s is costing you $%.2f%n", item1.getPartNumber(), item3.getInvoiceAmount());
	} // end method main

} // end class Invoice Test 
