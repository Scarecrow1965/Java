// Exercise 5.28
/* Describe in general how you’d remove any continue statement from a loop
 *  in a program and replace it with some structured equivalent.
 *  Use the technique you develop here to remove the continue statement from
 *  the program in Fig.5.14 .
// Fig. 5.14: ContinueTest.java
// continue statement terminating an iteration of a for statement.
public class ContinueTest
{
   public static void main(String[] args)
   {
      for (int count = 1; count <= 10; count++)// loop 10 times
      { 
         if (count == 5)
         {
            continue; // skip remaining code in loop body if count is 5
         } 

         System.out.printf("%d ", count);
      } 

      System.out.printf("%nUsed continue to skip printing 5%n");
   } // end method main
} // end class ContinueTest */


public class Exercise5_28
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		 for (int count = 1; count <= 10; count++)// loop 10 times
	      { 
			 // in order to skip 5 this loop must be redone
			 if(count != 5)
			 {
		         System.out.printf("%d ", count); // relocated this statement
			 }
//	         if (count == 5)
//	         {
//	            continue; // skip remaining code in loop body if count is 5
//	         } 
	      } 

	      System.out.printf("%nUsed continue to skip printing 5%n");
	      
	} // end method main

} // end class Exercise5_28
