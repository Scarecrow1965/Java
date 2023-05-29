// Exercise 5.23
/* These laws state that the expression !(condition1 && condition2)
 * is logically equivalent to the expression (!condition1 || !condition2).
 * Also, the expression !(condition1 || condition2)
 * is logically equivalent to the expression (!condition1 && !condition2).
 * Use De Morgan’s laws to write equivalent expressions for each of the following,
 * then write an application to show that both the original expression and
 * the new expression in each case produce the same value:
1.	!(x < 5) && !(y >= 7)
2.	!(a == b) || !(g != 5)
3.	!((x <= 8) && (y > 4))
4.	!((i > 4) || (j <= 6))
 */

public class DeMorganLaw
{

	public static void main(String[] args) 
	{
		// initializing variables
		int x = 8; // used for 1 and 3 
		int y = 5; // used for 1 and 3 
		int a = 2; // used for 2
		int b = 1; // used for 2
		int g = 2; // used for 2
		int i = 3; // used for 4
		int j = 7; // used for 4

		
		System.out.printf("so if x = %d and y = %d then %n", x, y);
		System.out.printf("#1 !(x < 5) && !(y >= 7) = %s%n", !(x < 5) && !(y >= 7) );
		System.out.printf("Using deMorgan's for #1 is !((x < 5) || (y >= 7)) = %s%n", !((x < 5) || (y >= 7)) );
		System.out.println();
		System.out.printf("so if a = %d, b = %d, g = %d then %n", a, b, g);
		System.out.printf("#2 !(a == b) || !(g != 5) = %s%n", !(a == b) || !(g != 5) );
		System.out.printf("Using deMorgan's for #2 is !((a == b) && (g != 5)) = %s%n", !((a == b) && (g != 5)) );
		System.out.println();
		System.out.printf("so if x = %d and y = %d then %n", x, --y);
		System.out.printf("#3 !((x <= 8) && (y > 4)) = %s%n", !((x <= 8) && (y > 4)) );
		System.out.printf("Using deMorgan's for #2 is (!(x <= 8) || !(y > 4)) = %s%n", (!(x <= 8) || !(y > 4)) );
		System.out.println();
		System.out.printf("so if i = %d and j = %d then %n", i, j);
		System.out.printf("#4 !((i > 4) || (j <= 6)) = %s%n", !((i > 4) || (j <= 6)) );
		System.out.printf("Using deMorgan's for #2 is !(i > 4) && !(j <= 6) = %s%n", !(i > 4) && !(j <= 6) );
		System.out.println();
		
	} // end method main

} // end class DeMorganLaw
