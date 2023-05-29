// Exercise 5.26
/* Describe in general how you’d remove any break statement from a loop in a program
 *  and replace it with some structured equivalent.
 *  [Hint: The break statement exits a loop from the body of the loop.
 *  The other way to exit is by failing the loop-continuation test.
 *  Consider using in the loop-continuation test a second test that indicates
 *  “early exit because of a ‘break’ condition.”]
 *  Use the technique you develop here to remove the break statement from the application
 *  in Fig.5.13 .
 *
// Fig. 5.13: BreakTest.java
// break statement exiting a for statement.
public class BreakTest
{
   public static void main(String[] args)
   {
      int count; // control variable also used after loop terminates
      
      for (count = 1; count <= 10; count++) // loop 10 times
      { 
         if (count == 5)
         	{
        	 	break; // terminates loop if count is 5
         	}
         System.out.printf("%d ", count);
      } 

      System.out.printf("%nBroke out of loop at count = %d%n", count);
      
   } // end method main
} // end class BreakTest 
 */

public class Exercise5_26
{

	public static void main(String[] args)
	{
		int count; // control variable also used after loop terminates
	      
	      for (count = 1; count <= 10; count++) // loop 10 times
	      { 
	         if (count == 5)
	         	{
	        	 	count = 10; // replaces break statement and causes early exit
	        	 	// yet still provides the same result as the break
	        	// 	break; // terminates loop if count is 5
	         	}
	         System.out.printf("%d ", count);
	      } 

	      System.out.printf("%nBroke out of loop at count = %d%n", count);
		
	} // end method main

} // end class Exercise5_26
