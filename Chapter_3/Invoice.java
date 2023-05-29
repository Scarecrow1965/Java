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

public class Invoice
	//access modifier public
{
	private String partNumber;
	private String description;
	private int quantity;
	private double pricePerItem;
	public double invoiceAmount;
	
	// constructor Invoice
	public Invoice(String partNumber, String description, int quantity, double pricePerItem)
	{
		this.partNumber = partNumber;
		this.description = description;
		this.quantity = quantity;
		this.pricePerItem = pricePerItem;
		
		if(quantity < 0)
		{
			quantity = 0;
		}
		if(pricePerItem < 0.0)
		{
			pricePerItem = 0.0;
		}
	} // end constructor
		
	// method to enter partNumber of item
	public void setPartNumber(String partNumber)
	{
		this.partNumber = partNumber;
	} // end method setPartNumber
		
	// method to enter description of item
	public void setDescription(String description)
	{
		this.description = description;
	} // end method setDescription
		
	// method to enter quantity of item
	public void setQuantity(int quantity)
	{
		if(quantity < 0)
		{
			quantity = 0;
		}
		else
		{
			this.quantity = quantity;
		}
	} // end method setQuantity
		
	// method that enters price of item
	public void setPrice(double pricePerItem)
	{
		if(pricePerItem < 0.0)
		{
			pricePerItem = 0.0;
		}
		else
		{
			this.pricePerItem = pricePerItem;
		}
	} // end method setPrice
		
	// method to return partNumber
	public String getPartNumber()
	{
		return partNumber;
	} // end method getPartNumber
		
	// method to return description of item
	public String getDescription()
	{
		return description;
	} // end method getDescitption
		
	// method to return quantity of item
	public int getQuantity()
	{
		return quantity;
	} // end method getQuantity
		
	// method to return price of item
	public double getPrice()
	{
		return pricePerItem;
	}// end method getPrice 
				
	public double getInvoiceAmount()
	{
		invoiceAmount = quantity * pricePerItem;
		return invoiceAmount;
	} // end method GetInvoiceAmount
		
} // end class Invoice
