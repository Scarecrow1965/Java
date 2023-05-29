// Exercise 6.28
/* Write a method qualityPoints that inputs a student’s average and returns
 * 4 if it’s 90–100,
 * 3 if 80–89,
 * 2 if 70–79,
 * 1 if 60–69 and
 * 0 if lower than 60.
 * Incorporate the method into an application that reads a value from the user and displays the result.
 */

import java.util.Scanner;

public class QualityPoints
{

	public static void main(String[] args)
	{
		// initializing variables
		int grade;

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
		
		System.out.println("This application will provide Quality Points to the studen't average grade.");
		System.out.println("Enter student's average:");
		grade = input.nextInt(); // read student's grade
		
		System.out.printf("Student receives: %d Quality Points%n", qualityPoints(grade) );

	} // end method main

	//method qualityPoints
	public static int qualityPoints (int grade)
	{
		grade = grade / 10;
		switch(grade)
		{
			case 9:
			{
				return 4;
			}
			case 10:
			{
				return 4;
			}
			case 8:
			{
				return 3;
			}
			case 7:
			{
				return 2;
			}
			case 6:
			{
				return 1;
			}
			default:
			{
				return 0;
			}
		}
	}

} // End class QualityPoints
