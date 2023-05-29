// Exercise 5.27
/*What does the following program segment do?
 1   for (i = 1; i <= 5; i++) {
 2      for (j = 1; j <= 3; j++) {
 3         for (k = 1; k <= 4; k++) {
 4            System.out.print('*');
 5         }
 6
 7          System.out.println();
 8      }
 9
10      System.out.println();
11   }
 */
public class Exercise5_27
{

	public static void main(String[] args)
	{
		// initializing variables
		int i;
		int j;
		int k;
		
		// copying exercise 5.27
		for (i = 1; i <= 5; i++) // this loop creates 5 set of 3 rows of ***
			{
			for (j = 1; j <= 3; j++) // this loop creates 3 rows of ***
				{
				for (k = 1; k <= 4; k++) // this loop creates 3 * (***)
					{
						System.out.print('*');
					}
				System.out.println(); // and spaces each out by a space
				}
			System.out.println();
			}

	} // end method main

} // end class Exercise5_27
