// Exercise 5.3
/* Write a Java statement or a set of Java statements to accomplish each of the following tasks:
1.	Sum the odd integers between 1 and 99, using a for statement. Assume that the integer variables sum and count have been declared.
2.	Calculate the value of 2.5 raised to the power of 3, using the pow method.
3.	Print the integers from 1 to 20, using a while loop and the counter variable i. Assume that the variable i has been declared, but not initialized. Print only five integers per line. [Hint: Use the calculation i % 5. When the value of this expression is 0, print a newline character; otherwise, print a tab character. Assume that this code is an application. Use the System.out.println() method to output the newline character, and use the System.out.print('\t') method to output the tab character.]
4.	Repeat part (c), using a for statement.
*/

public class Exercise5_3 {

	public static void main(String[] args) {
		// initializing variables
		
		
		System.out.println("Part 1:");
		{
			int sum = 0;
			int count;
			for(count = 1; count <= 100; count += 2)
				{
					sum += count;
					System.out.printf("count is %d, sum is %d%n", count, sum);
				}
		} // end part 1
		
		System.out.println("Part 2:");
		{
			Math.pow(2.5, 3);
			System.out.print(Math.pow(2.5, 3));
			System.out.println();
		} // end part 2
		
		System.out.println("Part 3:");
		{
			int i = 1;
			while(i <= 20)
			{
				System.out.print(i);
				if(i % 5 == 0)
				{
					System.out.println();
				}
				else 
				{
					System.out.print('\t');
				}
				i++;
			}
		} // end part 3
		
		System.out.println("Part 4:");
		{
		for(int i = 1; i <=20; i++)
			{
				System.out.print(i);
				if(i % 5 == 0)
				{
					System.out.println();
				}
				else 
				{
					System.out.print('\t');
				}
			}
		}// end part 4
		
	}// end method main

} // end class Exercise5_3
