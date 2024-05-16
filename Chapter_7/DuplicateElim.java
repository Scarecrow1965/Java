// Exercise 7.12
/* (Duplicate Elimination)
 * Use a one-dimensional array to solve the following problem:
 * Write an application that inputs five numbers, each between 10 and 100, inclusive.
 * As each number is read, display it only if it’s not a duplicate of a number already read.
 * Provide for the “worst case,” in which all five numbers are different.
 * Use the smallest possible array to solve this problem.
 * Display the complete set of unique values input after the user enters each new value.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DuplicateElim
{

	public static void main(String[] args)
	{
		// initializing variables
		ArrayList<Integer> duplicate = new ArrayList<Integer>(); // array of 5 for non-duplicate number
		int nonDuplicate[] = new int[5];
		int counter = 0;
		int integer;
		int duplicated = 0; // acts as a flag to determine whether this number already exists

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		// Option 1
		System.out.println("This is an application that will remove any duplicate numbers from the five you will enter.");
		System.out.println("I am currently using an Array.");

		for(counter = 0; counter < 5; counter++ )
		{
			System.out.println("Enter number: ");
			integer = input.nextInt();

			// validate the input
			
			if (integer >= 10 && integer <= 100)
			{
				duplicated = 0;
				for (int i = 0; i < counter; i++) // compare number to nonduplicated numbers in array
				{
					if (integer == nonDuplicate[i])// if new number is a duplicate, set the flag
						duplicated = 1;
				}
					if (duplicated != 1) // add only if the number is not there already
					{
						nonDuplicate[counter] = integer;
						//counter++;
					}
					else
						System.out.printf("%d has already been entered\n", integer);
			}
			else
				System.out.println("number must be between 10 and 100");

			// print the list of unique numbers
			System.out.println("Here are the numbers that are not duplicated: ");
			for (int j = 0; j <= counter; j++)
			{
				System.out.printf("%d ", nonDuplicate[j]);
			}
			System.out.println();
		}

		
		//Option 1a: Instructor answer
//		while( counter < nonDuplicate.length )
//		{
//			System.out.print( "Enter number: " );
//			integer = input.nextInt();
//		// validate the input
//			if ( 10 <= integer && integer <= 100 )
//			{
//				// flags whether this number already exists
//				int containsNumber = 0;
//
//				// compare input number to unique numbers in array
//				for ( int i = 0; i < counter; i++ )
//					// if new number is duplicate, set the flag
//					if ( integer == nonDuplicate[ i ] )
//						containsNumber = 1;
//
//				// add only if the number is not there already
//				if ( containsNumber != 1 )
//				{
//					nonDuplicate[ counter ] = integer;
//					counter++;
//				} // end if
//				else
//					System.out.printf( "%d has already been entered\n", integer );
//
//			} // end if
//			else
//				System.out.println( "number must be between 10 and 100" );
//
//			System.out.println("Here are the numbers that are not duplicated:");
//			for ( int i = 0; i < counter; i++ ) // print the list
//				System.out.printf( "%d ", nonDuplicate[i] );
//				System.out.println();
//		} // end while

		// Option 1b
//		System.out.println("This is an application that will remove any duplicate numbers from the five you will enter.");
//		System.out.println("I am currently using an Array.");
//		
//		while(counter < nonDuplicate.length) 
//		{
//			System.out.println("Enter your number: ");
//			integer = input.nextInt(); // read integer number
//			// Need to nest following statements in if/else statement here to check between 10 && 100
//			for(int i = 4; i >= 0; i--)
//			{
//				if(integer == nonDuplicate[i]) // to check if integer is the same for all numbers entered into array
//					duplicated = 1;
//			}
//			if(duplicated != 1) // add the number
//			{
//				System.out.printf("%d is not a duplicate number. %n", integer);
//				nonDuplicate[counter] = integer; // enter into array if integer is not the same
//				counter++;
//			}
//			else
//				System.out.println("You've already entered that number");
//			
//			System.out.println("Here are the non-duplicated numbers you entered so far:");
//			for(int j = 4; j >= 0 ; j--) // to print out array if integer is not the same
//			{
//				System.out.printf("%d , ", nonDuplicate[j]);
//			}
//			System.out.println(); // print line for spacing
//			duplicated = 0;
//			
//		}

		// Option 2
//		System.out.println("This is an application that will remove any duplicate numbers from the five you will enter.");
//		System.out.println("I am currently using an ArrayList.");
//		System.out.println("Enter your first number: ");
//		integer = input.nextInt(); // read integer number
//		duplicate.add(integer);
//
//		for(counter = 3; counter >= 0; counter--) // to set up for only 4 more integer input
//		{
//			System.out.println("Enter your next number: ");
//			integer = input.nextInt(); // read integer number
//
//			for(int i = 4; i > counter; i--)
//			{
//				if(duplicate.contains(integer)) // to check if integer is the same for all numbers entered into array
//				{
//					duplicated = 1;
//				}
//				else
//				{
//					duplicate.add(integer); // enter into array if integer is not the same
//					System.out.printf("%d is not a duplicate number. %n", integer);
//					System.out.println("Here are the non-duplicated numbers you entered so far:");
//					for(Integer number : duplicate) // to print out array if integer is not the same
//					{
//						System.out.printf("%d , ", number);
//					}
//					System.out.println(); // print line for spacing
//					duplicated = 0;
//				}
//			}
//		}

	} // end method main

} // end class DuplicateElim
