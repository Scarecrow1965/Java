// Exercise 5.12
// Write an application that calculates the product of the odd integers from 1 to 15.

public class ProductOddInt {

	public static void main(String[] args) {
		// initializing variables
		int sum = 0;
		int count;
		
		for(count = 1; count <= 15; count += 2)
			{
				sum += count;
				System.out.printf("count is %d, sum is %d%n", count, sum);
			}

	} // end method main

} // end class ProductOddInt
