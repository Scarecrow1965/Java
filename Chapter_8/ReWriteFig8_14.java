// Exercise 8.9
/* Rewrite the code in Fig.8.14 to use a separate import declaration
 *  for each static member of class Math that’s used in the example.

// Fig. 8.14: StaticImportTest.java
// Static import of Math class methods.
import static java.lang.Math.*;

public class StaticImportTest
{
	public static void main(String[] args)
	{
		System.out.printf("sqrt(900.0) = %.1f%n", sqrt(900.0));
		System.out.printf("ceil(-9.8) = %.1f%n", ceil(-9.8));
		System.out.printf("E = %f%n", E);
		System.out.printf("PI = %f%n", PI);
	}
}
*/

import static java.lang.Math.sqrt;
import static java.lang.Math.ceil;
import static java.lang.Math.E;
import static java.lang.Math.PI;

public class ReWriteFig8_14
{
	public static void main(String[] args)
	{
		System.out.printf("sqrt(900.0) = %.1f%n", sqrt(900.0));
		System.out.printf("ceil(-9.8) = %.1f%n", ceil(-9.8));
		System.out.printf("E = %f%n", E);
		System.out.printf("PI = %f%n", PI);
	} // end method main

} // end class ReWriteFig8_14

