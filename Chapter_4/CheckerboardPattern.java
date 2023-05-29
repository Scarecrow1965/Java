// Exercise 4.33
/* Write an application that uses only the output statements
1   System.out.print("* ");
2   System.out.print(" ");
3   System.out.println();
to display the checkerboard pattern that follows.
A System.out.println method call with no arguments causes the program to output
a single newline character. [Hint: Iteration statements are required.]

* * * * * * * *
 * * * * * * * *
* * * * * * * *
 * * * * * * * *
* * * * * * * *
 * * * * * * * *
* * * * * * * *
 * * * * * * * *0
*/

public class CheckerboardPattern
{

	public static void main(String[] args)
	{
		// initializing variables
		int line = 1;
		while(line < 9)
			{
				int n = 1;
				while(n < 9)
					{
						System.out.print("* ");
						++n;
					}
				System.out.println();
				++line;
				if(line % 2 == 0)
					{
						System.out.print(" ");
					}
			}
			
	}//end method main

} // end class CheckerBoardPattern
