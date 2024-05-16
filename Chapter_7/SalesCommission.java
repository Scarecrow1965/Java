// Exercise 7.10
/* Use a one-dimensional array to solve the following problem:
 * A company pays its salespeople on a commission basis.
 * The salespeople receive $200 per week plus 9% of their gross sales for that week.
 * For example, a salesperson who grosses $5,000 in sales in a week receives $200 plus
 * 9% of $5,000, or a total of $650.
 * Write an application (using an array of counters) that determines how many of the
 * salespeople earned salaries in each of the following ranges (assume that each
 * salesperson’s salary is truncated to an integer amount):
1.	$200–299
2.	$300–399
3.	$400–499
4.	$500–599
5.	$600–699
6.	$700–799
7.	$800–899
8.	$900–999
9.	$1,000 and over
Summarize the results in tabular format.
*/

import java.util.Scanner;

public class SalesCommission
{
	public static void main(String[] args)
	{
		// initializing variables
		int employee;
		int salary;
		int count;
		int sales;
		int scale;
		int[] counting = new int[9]; // setting up new counting array since we know what the output is expected;
		
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
		
		System.out.println("This application will display the ranges of the salesperson's commission for the week.");
		System.out.println("How many salesperson(s) are we entering?");
		employee = input.nextInt(); // read salesperson amount

		final int ARRAY_LENGTH = employee + 1; // declaring array length
		int [] store = new int[ARRAY_LENGTH]; // creating array
		store[0] = employee; //keeps the array length/number of employees

		// entering data into store/employee array and set up a counting array
		for(count= 1; count <= store[0]; count++)
		{
			System.out.println("Enter sales for each salesperson:");
			sales = input.nextInt(); // reads sales
			
			salary = (int) getWeeklyComm(sales); // calculating proper salary 
			store[count] = salary; // entering data into store/employee array
			
			scale = salary / 100; // setting up for counting array
			CountingArray(scale, counting); // adding to counting array
		}
		
		// for testing purposes only
		System.out.println("Here's is what has been calculated:");
		for(count = 1; count < store[0] + 1; count ++)
		{
		System.out.printf("%03d, at c[%d]%n", store[count], count);
		} // this works
		
		// for testing purposes only
		System.out.println("Here's what has been tabulated:");
		for(count = 0; count < counting.length; count++)
		{
			System.out.printf(" %d %n", counting[count]);
		} // this works

		//time to output data into tabular look
		System.out.println("Here is the distribution of this weeks sales");
		//setting up display bar
		for(count = 0; count < 9; count++)
		{
			if(count == 8)
			{
				System.out.printf("$%4d and over: ", 1000);
				System.out.printf(" %d ", counting[count]);
			}
			else
			{
				// output bar label
				/* 1. $200–299, 2. $300–399, 3. $400–499, 4. $500–599, 5. $600–699
				6. $700–799, 7. $800–899, 8. $900–999, 9. $1,000 and over */
				System.out.printf("$%03d - $%03d: \t" , (count + 2) * 100, (count + 2) * 100 + 99);
				System.out.printf(" %d ", counting[count]);
			}
			System.out.println();
		}

	} // end method main

	// to calculate the amount of commission each saleperson would make
	public static double getWeeklyComm(int sales)
	{
		double commission = 200 + (.09 * sales);
		return commission;
	} // end method WeeklyComm

	// to add all the amounts earned into a counting array 
	public static void CountingArray(int scale, int[] counting)
	{
		switch(scale) // entering all scales into array
			{
				case 2:
				{
					counting[0] += 1;
					break;
				}
				case 3:
				{
					counting[1] += 1;
					break;
				}
				case 4:
				{
					counting[2] += 1;
					break;
				}
				case 5:
				{
					counting[3] += 1;
					break;
				}
				case 6:
				{
					counting[4] += 1;
					break;
				}
				case 7:
				{
					counting[5] += 1;
					break;
				}
				case 8:
				{
					counting[6] += 1;
					break;
				}
				case 9:
				{
					counting[7] += 1;
					break;
				}
				case 10:
				{
					
				} 
				default: // this will "tally" up $1000 and above
				{
					counting[8] += 1;
					break;
				}
			} // end switch
	} // end CountingArray

} // end class SalesCommission
