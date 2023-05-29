//Exercise 4.34
/* Write an application that keeps displaying in the command window the multiples
 * of the integer 2—namely, 2, 4, 8, 16, 32, 64, and so on.
 * Your loop should not terminate (i.e., it should create an infinite loop).
 * What happens when you run this program? */

public class Multiplesof2
{

	public static void main(String[] args)
	{
		// initializing variables
		int n = 1;
		
		while(n > 0)
		{
			System.out.printf("%d%n", n);
			n *= 2;
		}
		
	}// end method main

} // end class Multiples of 2

// answer to question is that program ends when it reaches max integer size.
