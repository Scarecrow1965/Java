// Exercise 8.13 & 8.14
/* (Set of Integers)
 Create class IntegerSet.
 Each IntegerSet object can hold integers in the range 0–100.
 The set is represented by an array of booleans.
 Array element a[i] is true if integer i is in the set.
 Array element a[j] is false if integer j is not in the set.
 The no-argument constructor initializes the array to the “empty set” (i.e., all false values).
 
 Provide the following methods:
1 - The static method union creates a set that’s the set-theoretic union of two existing sets
 (i.e., an element of the new set’s array is set to true if that element is true in either
 or both of the existing sets—otherwise, the new set’s element is set to false).
2 - The static method intersection creates a set which is the set-theoretic intersection of two
 existing sets (i.e., an element of the new set’s array is set to false if that element is
 false in either or both of the existing sets—otherwise, the new set’s element is set to true).
3 - Method insertElement inserts a new integer k into a set (by setting a[k] to true).
4 - Method deleteElement deletes integer m (by setting a[m] to false).
5 - Method toString returns a String containing a set as a list of numbers separated by spaces.
Include only those elements that are present in the set.
Use --- to represent an empty set.
6 - Method isEqualTo determines whether two sets are equal.

 Write a program to test class IntegerSet.
 Instantiate several IntegerSet objects.
 Test that all your methods work properly.
 */

import java.util.Scanner;

public class IntegerSetTest
{

	public static void main(String[] args)
	{
		//initializing variables
		int option = 0;
		// Option #2
		IntegerSet setA = new IntegerSet();
		IntegerSet setB = new IntegerSet();

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("This application will allow you to enter two sets of integers");
		System.out.println("and will display integers that are the same in both sets and also display");
		System.out.println("integers that are not the same in both sets.");
		System.out.println("It will also allow you to add or remove integers from either sets.");
		System.out.println("Integers from 0 to 100 ONLY will be allowed.");
		System.out.println("Using numbers above or below this criteria will cause the program to terminate.");
		// Option #1
//		System.out.println("Enter (add) an integer into set A");
//		IntegerSet setA = InputSet();
//		System.out.println("Enter (add) an integer into set B");
//		IntegerSet setB = InputSet();

		while(option != 99)
		{
			// main menu
			System.out.println("Here are your options:");
			System.out.println("(1) to enter (add) an integer into set A");
			System.out.println("(2) to enter (add) an integer into Set B");
			System.out.println("(3) to see what you have entered into set A");
			System.out.println("(4) to see what you have entered into set B");
			System.out.println("(5) to see the result of joining both sets together");
			System.out.println("(6) to see what numbers are the same between both sets");
			System.out.println("(7) to remove (delete) an integer from Set A");
			System.out.println("(8) to remove (delete) an integer from Set B");
			System.out.println("(9) to see if both sets are equal");
			System.out.println("(99) to exit (terminate) this program");
			option = input.nextInt();

			switch (option)
			{
			case 1:
			{
				System.out.println("Enter (add) an integer into set A");
				setA = InputSet();
				break;
			}
			case 2:
			{
				System.out.println("Enter (add) an integer into set B");
				setB = InputSet();
				break;
			}
			case 3:
			{
				System.out.println(setA.toString() );
				// System.out.printf("Here is what you entered in set A: %n %s %n", setA.toString() );
				break;
			}
			case 4:
			{
				System.out.println(setB.toString() );
				// System.out.printf("Here is what you entered in set B: %n %s %n", setB.toString() );
				break;
			}
			case 5:
			{
				IntegerSet union = setA.union(setB);
				System.out.printf("Here are the numbers together:%n %s%n", union.toString() );
				break;
			}
			case 6:
			{
				IntegerSet intersection = setA.intersection(setB);
				System.out.printf("Here are the numbers that are the same :%n %s%n", intersection.toString() );
				break;
			}
			case 7:
			{
				System.out.println("Enter number to be removed: ");
				int temp = input.nextInt();
				setA.deleteElement(temp);
				break;
			}
			case 8:
			{
				System.out.println("Enter number to be removed: ");
				int temp = input.nextInt();
				setB.deleteElement(temp);
				break;
			}
			case 9:
			{
				System.out.printf("Are the two sets equal?: %b%n", setA.isEqual(setB));
				break;
			}
			case 99:
			{
				break;
			}
			default:
			{
				System.out.println("You have entered a wrong number. Please try again.");
				option = input.nextInt();
				break;
			}
			} // end switch
		} // end while

		// These commented lines (ArrayX) causes error : Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 145 out of bounds for length 145
		//test array
//		int[] arrayX = {1, 2, 15, 25, 35, 40, 55, 65, 75, 86, 87, 99, 100};
//		IntegerSet setX = new IntegerSet(arrayX);
//		System.out.printf("setX includes: %s", setX.toString() );

	} // end method main;

	public static IntegerSet InputSet()
	{
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
		
		IntegerSet temp = new IntegerSet();
		
		System.out.println("type -1 to exit.");
		System.out.println("Enter number: ");
		int number = input.nextInt();

		while (number != -1)
		{
			temp.insertElement(number);
			System.out.println("type -1 to exit.");
			System.out.println("Enter number: ");
			number = input.nextInt();
		}
		
		return temp;
	}

} // end class IntegerSetTest
