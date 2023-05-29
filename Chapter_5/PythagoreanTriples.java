// Exercise 5.21
/* Write an application that displays a table of the Pythagorean triples for
 *  side1,
 *  side2 and the
 *  hypotenuse, all no larger than 500.
 *  Use a triple-nested for loop that tries all possibilities. */

public class PythagoreanTriples
{

	public static void main(String[] args)
	{
		// initializing variables
		int a = 0;
		int b = 0;
		int c = 0;
		int n = 0;
		int m = 0;
		int k = 0;
		int side1 = 0;
		int side2 = 0;
		int hypotenuse = 0;
		
		// taken from https://en.wikipedia.org/wiki/Pythagorean_triple ...
		// keep with standard Pythagorean calculations a*a + b*b = c*c
		// or go with Euclid's formula of a= m*m - n*n, b = 2 * m * n, c = m*m + n*n
		// or go with a = k * (m*m - n*n), b = k * (2 * m * n), c = k * (m*m + n*n)
		
		// from the exercise requirements...
		// where side1 = a, side2 = b, hypotenuse = c
		// all numbers < 500 so side 1 and side 2 < 500 and hypotenuse cannot be < 500
		// triple nested loop...
		
		System.out.println("Pythagorean Triples are:");
		System.out.println("side1\t side2\t hypotenuse");

//		//Option 1: this works but missing triples and Ali Moussa hint
//		while(c <=500)
//		{
//			for(n = 1; n < 500 ; ++n)
//				{
//       				a = (n * n) - (m * m);
//      				b = 2 * (n * m);
//       				c = n * n + m * m;
//       				if(a*a + b*b == c*c)
//       					{
//       						if(c > 500)
//       							{
//       								break;
//       							}
//      						System.out.printf("%d\t %d\t %d\n", a, b, c);
//       					}
//				m++;
//				}
//		}
		
		// Option 1: this used to work but now does not, and was missing triples
//		System.out.println("Option #1");
//		while(hypotenuse < 500)
//		{
//			for(n = 1; n < m ; n++)
//			{
//       			side1 = m * m - n * n;
//      			side2 = 2 * m * n;
//       			hypotenuse = m * m + n * n;
//       			if(side1*side1 + side2*side2 == hypotenuse*hypotenuse)
//       			{
//       				if(hypotenuse > 500)
//       				{
//       					break;
//       				}
//      				System.out.printf("%d\t %d\t %d\n", side1, side2, hypotenuse);
//       			}
//				m++;
//			}
//		}
		
		// Option 2: this works but is missing some of the true triples
//		System.out.println("Option #2");
//		while(c < 500) // loop #1 and < 500 criteria
//		{ 
//	        for(n = 1; n < m; ++n) // loop #2
//	        {
//	            for(k = 1; ; k++) // loop #3
//	            {
//	            	a = k * (m * m - n * n);
//	            	b = k * (2 * n * m);
//	            	c = k * (m * m + n * n);
//	 
//	            	if (c > 500)
//	            		{
//	            			break;
//	            		}
//	            	System.out.printf("%d\t %d\t %d\n", a, b, c);
//	            }	            
//	        }
//	        m++;
//	    }
		
		// New Option
				System.out.println("New Option)");
				for(a = 1; a <= 500; a++) // loop #1
				{
					for(b = 1; b <= 500; b++) // loop #2
					{
						for(c = 1; c <= 500; c++) // loop #3
						{
							if((a * a) + (b * b) == (c * c))
							{
								System.out.printf("%d\t %d\t %d\n", a, b, c);
							}
						} // end for c
					} // end for b
				} // end for a
		
//		// Option 3
//		System.out.println("Option #3");
//		for(m = 1; m <= 500; m++) // loop #1 and < 500 criteria
//		{ 
//	        for(n = 1; n < m; ++n) // loop #2
//	        {
//	            for(k = 1; ; k++) // loop #3
//	            {
//	            	a = k * (m * m - n * n);
//	            	b = k * (2 * n * m);
//	            	c = k * (m * m + n * n);
//	 
//	            	if (c > 500)
//	            		{
//	            			break;
//	            		}
//	            	System.out.printf("%d\t %d\t %d\n", a, b, c);
//	            }	            
//	        }
//	    }
		
	} // end method main

} // end class PythagoreanTriples
