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

public class IntegerSet
{
	// initializing variables
	private final int integer = 101; // used to build array of 0 - 100 integers
	private boolean [] set;

	// IntegerSet no-argument constructor: 
	public IntegerSet()
	{
		set = new boolean[integer]; // when boolean array is created, all values are defaulted to false.
	}

	// initializes each instance variable to zero
	public IntegerSet (int[] array)
	{
		set = new boolean[integer];
//		for (int i = 0; i < integer; i++) // this loop forces array variables to false
//		{
//			set[i] = false;
//		}
		for (int i = 0; i < integer; i++)
		{
			insertElement(array[i]);
		}
	}

	// 1 - The static method union creates a set that’s the set-theoretic union of two existing sets
	// (i.e., an element of the new set’s array is set to true if that element is true in either
	// or both of the existing sets—otherwise, the new set’s element is set to false).
	public IntegerSet union(IntegerSet setB)
	{
		IntegerSet union = new IntegerSet();
		for(int i = 0; i < integer; i++)
		{
			// using OR truth tables values to combine both sets together
			// A		B		Union
			// false	false	false
			// true		false	true
			// false	true	true
			// true		true	true
			union.set[i] = (set[i] || setB.set[i]);
		}
		return union;
	}

	// 2 - The static method intersection creates a set which is the set-theoretic intersection of two
	// existing sets (i.e., an element of the new set’s array is set to false if that element is
	// false in either or both of the existing sets—otherwise, the new set’s element is set to true).
	public IntegerSet intersection(IntegerSet setB)
	{
		IntegerSet intersection = new IntegerSet();
		for(int j = 0; j < integer; j++)
		{
			// using AND truth tables values to see which numbers are the same
			// A		B		Intersection
			// false	false	false
			// true		false	false
			// false	true	false
			// true		true	true
			intersection.set[j] = (set[j] && setB.set[j]); 
		}
		return intersection;
	}

	//3 - Method insertElement inserts a new integer k into a set (by setting a[k] to true).
	public void insertElement(int k)
	{
		// when inserting an integer into a boolean array, the array number will be the integer
		// int k = integer
		// aka boolean array set[k] = true; <- this will flag the "integer number" to true
		if(checkInt(k) == k)
		{
		set[k] = true;
		}
	}

	//4 - Method deleteElement deletes integer m (by setting a[m] to false).
	public void deleteElement(int m)
	{
		// when deleting an integer from a boolean array, the array number will be the integer
		// int m = integer
		// aka boolean array set[m] = false <- this will flag the "integer number" to false
		if(checkInt(m) == m)
		{
		set[m] = false;
		}
	}

	// 5 - Method toString returns a String containing a set as a list of numbers separated by spaces (" ").
	public String toString()
	{
		boolean empty = true;
		String output = "{ ";

		for(int i = 0; i < integer; i++)	// Include only those elements that are present in the set.
		{
			if(set[i])
			{
				output += " " + i + " ";
				empty = false; // there's an integer entered
			}
		}

		if(empty)	// Use --- to represent an empty set.
		{
			output += "---";
		}
		output += " }";
		return output;
	}

	//6 - Method isEqualTo determines whether two sets are equal.
	public boolean isEqual(IntegerSet setB)
	{
		for(int i = 0; i < integer; i++)
		{
			if(set[i] != setB.set[i]) // double negative statement: if true then they are not equal
			{
				return false; // sets are not equal
			}
		}
		return true; // sets are equal
	}

	// method to check integers being inserted into arrays
	public int checkInt(int temp)
	{
		if (temp < 0 || temp > 100)
		{
			throw new IllegalArgumentException("integers must be between 1 and 100");
		}
		else
		{
			return temp;
		}
	}

} // end class IntegerSet
