//Exercise 10.16
/* (Accounts Payable System Modification)
 In this exercise, we modify the accounts payable application of Figs. 10.11 – 10.14 to include
 the complete functionality of the payroll application of Figs. 10.4 – 10.9.
 The application should still process two Invoice objects, but now should process one object of each
 of the four Employee subclasses.
 If the object currently being processed is a BasePlusCommissionEmployee, the application should
 increase the BasePlusCommissionEmployee’s base salary by 10%.
 Finally, the application should output the payment amount for each object.
 Complete the following steps to create the new application:
1. Modify classes HourlyEmployee (Fig. 10.6 ) and CommissionEmployee (Fig. 10.7 )
 to place them in the Payable hierarchy as subclasses of the version of Employee (Fig. 10.13 )
 that implements Payable.
 [Hint: Change the name of method earnings to getPaymentAmount in each subclass so that the class
 satisfies its inherited contract with interface Payable.]
2. Modify class BasePlusCommissionEmployee (Fig. 10.8 ) such that it extends the version of class
CommissionEmployee created in part (a) <- or Part 1 of this exercise.
3. Modify PayableInterfaceTest (Fig. 10.14 ) to polymorphically process two Invoices,
 one SalariedEmployee, one HourlyEmployee, one CommissionEmployee and one BasePlusCommissionEmployee.
 First output a String representation of each Payable object.
 Next, if an object is a BasePlusCommissionEmployee, increase its base salary by 10%.
 Finally, output the payment amount for each Payable object.
*/

// Fig. 10.12: Invoice.java
// Invoice class that implements Payable.

public class Invoice2 implements Payable2
{
	private final String partNumber; 
	private final String partDescription;
	private final int quantity;
	private final double pricePerItem;

	// constructor
	public Invoice2(String partNumber, String partDescription, int quantity,
			double pricePerItem)
	{
		if (quantity < 0) // validate quantity
		{
			throw new IllegalArgumentException("Quantity must be >= 0");
		}

		if (pricePerItem < 0.0) // validate pricePerItem
		{
			throw new IllegalArgumentException("Price per item must be >= 0");
		}

		this.quantity = quantity;
		this.partNumber = partNumber;
		this.partDescription = partDescription;
		this.pricePerItem = pricePerItem;
	}

	// get part number
	public String getPartNumber()
	{
		return partNumber;
	}

	// get description
	public String getPartDescription()
	{
		return partDescription;
	}

	// get quantity
	public int getQuantity()
	{
		return quantity;
	}

	// get price per item
	public double getPricePerItem()
	{
		return pricePerItem;
	}

	// return String representation of Invoice object
	@Override
	public String toString()
	{
		return String.format("%s: %n%s: %s (%s) %n%s: %d %n%s: $%,.2f", 
				"invoice", "part number", getPartNumber(), getPartDescription(), 
				"quantity", getQuantity(), "price per item", getPricePerItem());
	}

	// method required to carry out contract with interface Payable
	@Override
	public double getPaymentAmount()
	{
		return getQuantity() * getPricePerItem(); // calculate total cost
	}

} // end class Invoice2
