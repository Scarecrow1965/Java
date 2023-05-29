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


public class SalesComCalc
{
	//initializing variables
	int item;
	String salesperson;
	double gross_sales;
	double commission;
	
	// constructor
	public SalesComCalc(String salesperson, float commission, double gross_sales)
	{
		this.salesperson = salesperson;
		this.commission = commission;
	}//end constructor
	
	public void setSalesPerson(String salesperson)
	{
		this.salesperson = salesperson;
	} // end method setSalesPerson
	
	public String getSalesPerson()
	{
		return salesperson;
	} // end method getSalesPerson
	
	// method setItem = setGrossSales
	public void setItem(int item)
	{
		if(item == 1)
		{
			gross_sales += 239.99;
		}
		if(item == 2)
		{
			gross_sales += 129.75;
		}
		if(item == 3)
		{
			gross_sales += 99.95;
		}
		if(item == 4)
		{
			gross_sales += 350.99;
		}
	}// end method setItem
	
	public double getGrossSales()
	{
		return gross_sales;
	}// end method getGrossSalesTotal
	
	public double getWeeklyComm()
	{
	commission = 200 + (.09 * gross_sales);
	return commission;
	} // end method WeeklyComm
	
} // end class SalesComCalc
