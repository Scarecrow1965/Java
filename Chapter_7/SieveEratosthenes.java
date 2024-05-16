// Exercise 7.27
/* (Sieve of Eratosthenes)
 * https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 * A prime number is any integer greater than 1 that’s evenly divisible only by itself and 1.
 * The Sieve of Eratosthenes is a method of finding prime numbers. It operates as follows:
1.	Create a primitive-type boolean array with all elements initialized to true. Array elements
with prime indices will remain true.
All other array elements will eventually be set to false.
2.	Starting with array index 2, determine whether a given element is true.
If so, loop through the remainder of the array and set to false every element whose index is a
multiple of the index for the element with value true.
Then continue the process with the next element with value true. For array index 2,
all elements beyond element 2 in the array that have indices which are multiples of 2
(indices 4, 6, 8, 10, etc.) will be set to false;
for array index 3, all elements beyond element 3 in the array that have indices which
are multiples of 3 (indices 6, 9, 12, 15, etc.) will be set to false; and so on.
When this process completes, the array elements that are still true indicate that the index is a prime number.
These indices can be displayed.
Write an application that uses an array of 1,000 elements to determine and display the prime numbers between 2 and 999.
 Ignore elements 0 and 1.
  */

public class SieveEratosthenes
{

	public static void main(String[] args)
	{
		// initializing variables
		int n = 1000; // 1000 prime numbers??
		boolean SieveEratosthenes[] = new boolean[1000]; // initializing default = false
		for(int i = 0; i < SieveEratosthenes.length; i++) //set all array to true
		{
			SieveEratosthenes[i] = true;
		}
		SieveEratosthenes[0] = true; // sets 0 as true
		SieveEratosthenes[1] = true; // sets 1 as true
		// all non prime numbers will be changed to false

		// IAW https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes pseudocode
		for (int i = 2; i < Math.sqrt(n); i++) // integer starts at 2 and not exceeding square root of n
		{
			if(SieveEratosthenes[i] == true)
			{
				for(int multiples = (i * i); multiples < n; multiples += i) // multiples are prime * prime
				{
					SieveEratosthenes[multiples] = false;
				}
			}
		}

		// to print all prime numbers
		System.out.println("Prime numbers from 2 to 999 are");
		for(int i = 0; i < SieveEratosthenes.length; i++)
		{
			if(SieveEratosthenes[i] == true)
			{
				System.out.printf("%d, ", i);
			}
		}
		System.out.println();

	} // end method main

} // end class SieveEratosthenes
