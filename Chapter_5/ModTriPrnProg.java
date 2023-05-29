// Exercise 5.22
/* Modify Exercise 5.15 to combine your code from the four separate triangles of
 * asterisks such that all four patterns print side by side.
 * [Hint: Make clever use of nested for loops.]
 * 
 * Exercise 5.15
 * Write an application that displays the following patterns separately,
 * one below the other.
 * Use for loops to generate the patterns.
 * All asterisks (*) should be printed by a single statement of the form System.out.print('*');
 * which causes the asterisks to print side by side.
 * A statement of the form System.out.println(); can be used to move to the next line.
 * A statement of the form System.out.print(' '); can be used to display a space for
 * the last two patterns.
 * There should be no other output statements in the program.
 * [Hint: The last two patterns require that each line begin with an appropriate number of blank spaces.]
(a) 		(b) 		(c)		 			(d)
* 			********** 	**********			 *
**	 		*********	 *********			**
*** 		********	  ********		   ***
**** 		******* 	   *******		  ****
***** 		******	 		******		 *****
****** 		***** 			 *****		******
******* 	**** 			  ****	   *******
******** 	*** 			   ***	  ********
********* 	**					**	 *********
********** 	* 					 *	********** */


public class ModTriPrnProg
{

	public static void main(String[] args)
	{
		// initializing variables
		int a; // used for triangle a
		int b; // used for triangle b
		int c; // used for triangle c
		int d; // used for triangle d
		int i; // used for lines
		int j; // used for spaces
		int k1; // used for asterisks

//		// for combination of all triangles
//				System.out.println("All Triangles");
//				a = 0;
//				while(a == 0)
//				{
//					// inner loop
//					for(i = 1; i <= 10; i++)
//						{
//							// for triangle a
//							for (k1 = 1; k1 <= i; k1++)  
//								{  
//									System.out.print("*");  
//								}
//							for (j = 1; j <=11-i ; j++)  
//								{  
//									System.out.print(" ");  
//								}
//							// for triangle b
//							for (j = 1; j <=11-i ; j++)
//								{
//									System.out.print("*");
//								}
//							for (k1 = 0; k1 <= i; k1++)  
//								{
//									System.out.print(" ");
//								}
//							// for Triangle c
//							for (k1 = 1; k1 <= i; k1++)  
//								{  
//									System.out.print(" ");  
//								}
//							for (j = 1; j <=11-i ; j++)  
//								{  
//									System.out.print("*");  
//								}  
//							// for triangle d
//							for (j = 1; j <=11-i ; j++)
//								{
//									System.out.print(" ");
//								}
//							for (k1 = 0; k1 < i; k1++)
//								{
//									System.out.print("*");
//								}
//						System.out.println();
//						}
//					a++;	
//				}//end while combination of all triangles
		
		// for triangle (a)
		System.out.println("Triangle a");
		a = 0;
		while(a == 0)
		{
			// inner loop
			for(i = 1; i <= 10; i++)
				{
					// for triangle a
					for (k1 = 1; k1 <= i; k1++)  
						{  
							System.out.print("*");  
						}
					for (j = 1; j <=10-i ; j++)  
						{  
							System.out.print(" ");  
						}
				System.out.println();
				}
			a++;	
		}//end while a
				
		//for triangle b
		System.out.println("Triangle b");
		b = 0;
		while(b == 0)
		{
			//inner loop
			for (i = 0; i <= 10; i++)
				{
					//outer loop
					for (j = 1; j <=10-i ; j++)
						{
							System.out.print("*");
						}
					for (k1 = 0; k1 <= i; k1++)
						{
							System.out.print(" ");
						}
				System.out.println();
				}
			b++;
		} //end while b
				
		// for triangle c
		System.out.println("Triangle c");
		c = 0;
		while(c == 0)
		{
			// inner loop
			for(i = 1; i <= 10; i++)
			{
				// outer loop
				for (k1 = 1; k1 <= i; k1++)
				{
					System.out.print(" ");
				}
				for (j = 1; j <=10-i ; j++)
				{
					System.out.print("*");
				}
			System.out.println();
			}
				c++;
		} // end while c
			
		// for triangle d
		System.out.println("Triangle d");
		d = 0;
		while(d == 0)
		{
			//inner loop
			for (i = 0; i <= 10; i++)
				{
					//outer loop
					for (j = 1; j <=10-i ; j++)
						{
							System.out.print(" ");
						}
					for (k1 = 0; k1 <= i; k1++)
						{
							System.out.print("*");
						}
				System.out.println();
				}
			d++;
		} // end while d
		
	} // end method main

} // end class ModTriPrnProg
