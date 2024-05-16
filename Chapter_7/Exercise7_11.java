// Exercise 7.11
/* Write statements that perform the following one-dimensional-array operations:
1.	Set the 10 elements of integer array counts to zero.
2.	Add one to each of the 15 elements of integer array bonus.
3.	Display the five values of integer array bestScores in column format.
 */
public class Exercise7_11
{

	public static void main(String[] args)
	{
		// initializing variables
		System.out.println("Step 1:");// step 1:
		int [] exercise = new int[10];
		// all array counts are zero by default
		for(int count = 0; count < exercise.length; count++)
		{
			System.out.printf(" %d ,", exercise[count]);
		}
		System.out.println();

		System.out.println("Step 2:");
		int[] bonus = new int[15];
		System.out.println("before adding one (1):");
		for(int count = 0; count < bonus.length; count++)
		{
			
			System.out.printf(" %d ,", bonus[count]);
		}
		System.out.println();
		System.out.println("after adding one (1):");
		for(int count = 0; count < bonus.length; count++)
		{
			bonus[count] += 1;
			
			System.out.printf(" %d ,", bonus[count]);
		}
		System.out.println();

		System.out.println("Step 3:");
		int[] bestScores = new int[5];
		System.out.println("BestScores column format:");
		for(int count = 0; count < bestScores.length; count++)
		{
			System.out.printf("Best score #%d= ", count + 1);
			System.out.printf(" %d %n", bestScores[count]);
		}
		System.out.println();

	} // end method main

} // end class Exercise7_11
