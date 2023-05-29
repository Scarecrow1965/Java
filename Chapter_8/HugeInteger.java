// exercise 8.16
/* (HugeInteger Class)
Create a class HugeInteger which uses a 40-element array of digits to store integers as large as 40 digits each.
Provide methods parse, toString, add and subtract.
Method parse should receive a String, extract each digit using method charAt
 and place the integer equivalent of each digit into the integer array.
For comparing HugeInteger objects, provide the following methods:
isEqualTo, isNotEqualTo, isGreaterThan, isLessThan, isGreaterThanOrEqualTo and isLessThanOrEqualTo.
Each of these is a predicate method that returns true if the relationship holds between the two HugeInteger objects and returns false if the relationship does not hold.
Provide a predicate method isZero.
If you feel ambitious, also provide methods multiply, divide and remainder.
[Note: Primitive boolean values can be output as the word “true” or the word “false” with format specifier %b.]
*/

import java.util.Arrays;
import java.util.Scanner;

public class HugeInteger
{
	//initializing variables
	final int maxDigit = 40;
	private int[] hugeArray;
	boolean valuesrtn;
	int size; // this will help determine when the HugeInteger starts/ends 

	public HugeInteger()
	{
		hugeArray = new int[maxDigit];
		//Create a class HugeInteger which uses a 40-element array of digits to store integers as large as 40 digits each.
	}
	
	private HugeInteger(String inputstring)
	{
		this(); // initializes hugeArray. First time using this();
		this.parse(inputstring);
//		this.addZeros(hugeArray);
	}

	// method parse using charAt method
	// Method parse should receive a String, extract each digit using method charAt
	// and place the integer equivalent of each digit into the integer array.

	/*according to https://www.javatpoint.com/java-string-charat
	The Java String class charAt() method returns a char value at the given index number.
	The index number starts from 0 and goes to n-1, where n is the length of the string.
	It returns StringIndexOutOfBoundsException, if the given index number is greater than or equal to this string length or a negative number.
	    public char charAt(int index)    */

	public void parse(String inputstring) 
	{
		// these commented lines below do not include any zero above the greatest number and induced errors with other methods 
//		if(inputstring.length() > maxDigit)
//		{
//			throw new IllegalArgumentException("Maximum length of Huge Integer is 40!!");
//		}
//		else
//		{
//			hugeArray = new int[inputstring.length()];
//			for(int i = 0; i < inputstring.length(); i++) 
//			{
//				hugeArray[i] = inputstring.charAt(i) - '0';
//			}
//		}

		// these next commented lines add a zero to the end of the number and add all zeros to the start of the number 
//		if( (inputstring.length() <= maxDigit) && (inputstring.length() > 0))
//		{	
//			for(int counter = 1; counter <= inputstring.length(); counter++)
//			{
//				// charDigit starts at the highest index of the string and decreases
//				int charDigit = inputstring.length();
//				
//				// check that each character is a numeral
//				if( Character.isDigit( inputstring.charAt( charDigit ) ) )
//				{
//					/*
//					 * iterate from the rightmost end of both the array and the string,
//					 * as though reading the number numerically
//					 */
//					this.setLocation(counter, Character.getNumericValue(inputstring.charAt(charDigit)));
//				}
//
//				else
//				{
//					// Alert the user if the string contained non-numeric characters
//					System.out.println("parse failed: value must consist of numeric characters only.");
//				}
//			}
//		}
//		
//		else
//		{
//			// Alert the user if the string was too large or too small
//			System.out.printf("parse failed: value must contain %d or fewer characters", maxDigit);
//		}

		int numLength = inputstring.length();
		int digitIndex = numLength - 1;
		for (int i = (hugeArray.length) - 1; i >= (hugeArray.length - numLength); i--)
		{
			char charDigit = inputstring.charAt(digitIndex);
			int digit = Character.digit(charDigit, 10);
			hugeArray[i] = digit;
			digitIndex--;
		}
		
//		for(int i = inputstring.length() - 1; i <= maxDigit ; i--)
//		{
//			int charDigit = inputstring.charAt(i);
//			this.hugeArray[i] = charDigit - '0';
//		}
	}

//	private int[] addZeros(int[] arr)
//	{
//		int[] temp = new int[maxDigit];
//		for( int i = 0; i < maxDigit; i++)
//		{
//			if( i < arr.length )
//			{
//				temp[i] = arr[i];
//			}
//			else
//			{
//				temp[i] = 0;
//			}
//		}
//		return temp;
//	}
	
	//need to set location of Number from hugeArray
	private void setLocation(int index, int value)
	{
		//need to refer to hugeArray to set location
		//hugeArray[i] = location/index and also provides the integer
		if( (index < maxDigit) && (index >= 0) )
		{
			if( (value < 10) && (value >= 0) )
			{
				this.hugeArray[index] = value;
			}
			else
			{
				throw new IllegalArgumentException("integer must be between 0 and 9!!");
			}
		}
		else
		{
			throw new IllegalArgumentException("index out of bound!!");
		}
	}

	// need to set Number from location in hugeArray
	public void setNumber(int digit, int value)
	{
		//need to refer to location to set Number
		this.setLocation( (maxDigit - digit), value );
	}

	//need to get location of Number from hugeArray
	public int getLocation(int index)
	{
		
		//need to refer to hugeArray to set location
		if( (index < maxDigit) && (index >= 0) )
		{
			return this.hugeArray[index];
		}
		else
		{
			throw new IllegalArgumentException("index out of bound!!");
		}
	}
	
	// need to get number from hugeArray
	public int getNumber(int digit)
	{
		
		//need to refer to location in order to get Number
		return this.getLocation(maxDigit - digit);
	}

	// method add
	public void add(HugeInteger other)
	{
		int sum = 0;
		int carry = 0;
		
		for(int i = 1; i <= maxDigit; i++)
		{
			sum = this.getNumber(i) + other.getNumber(i) + carry;

			if(sum > 10)
			{
				this.setNumber(i, (sum - 10) );
				carry = 1;
			}
			else
			{
				this.setNumber(i, sum);
				carry = 0;
			}
		}
	}

	// method subtract
	public void subtract(HugeInteger other)
	{
		int borrow = 0;
		int difference = 0;
		
		if(this.isGreaterThanOrEqualTo(other) )
		{
			for(int i = 1; i <= maxDigit; i++)
			{
				difference = this.getNumber(i) - other.getNumber(i) - borrow;
				if(difference >= 0)
				{
					this.setNumber(i, difference);
					borrow = 0;
				}
				else
				{
					this.setNumber(i, (difference + 10) ); // must ensure that the digit (difference + 10) is above 0
					borrow = 1;
				}
			}
		}
		else
		{
			throw new IllegalArgumentException("subtraction failed: result would be negative");
		}
	}

	// method isZero
	public boolean isZero()	//[Note: Primitive boolean values can be output as the word “true” or the word “false” with format specifier %b.]
	{
		for(int i = 0; i < maxDigit; i++) // have to go through the entire number to see if there is a number there 
		{
			if(getLocation(i) != 0 )
			{
				return false;
			}
		}
		return true;
	}

	// method isEqualTo
	public boolean isEqualTo(HugeInteger other) //[Note: Primitive boolean values can be output as the word “true” or the word “false” with format specifier %b.]
	{
		for(int i = 0; i < maxDigit; i++)
		{
			if(getLocation(i) != other.getLocation(i))
			{
				return false;
			}
		}
		return true;
	}

	// method isNotEqualTo
	public boolean isNotEqualTo(HugeInteger other) //[Note: Primitive boolean values can be output as the word “true” or the word “false” with format specifier %b.]
	{
//		for(int i = 0; i < maxDigit; i++)
//		{
//			if(getLocation(i) == other.getLocation(i))
//			{
//				return false;
//			}
//		}
//		return true;
		// or maybe use return !isEqualTo(HugeInteger other)??
		return !isEqualTo(other);
	}

	// method isGreaterThan
	public boolean isGreaterThan(HugeInteger other) //[Note: Primitive boolean values can be output as the word “true” or the word “false” with format specifier %b.]
	{
		int i = 0;
		while( (getLocation(i) == other.getLocation(i) ) && (i < maxDigit)) // getting rid of all extra zeros
		{
			i++;
		}
		if(i == maxDigit)
		{
			return false;
		}
		else
		{
			return ( getLocation(i) > other.getLocation(i) ); // use math greater than to make it work. 
		}
	}

	// method isLessThan
	public boolean isLessThan(HugeInteger other) //[Note: Primitive boolean values can be output as the word “true” or the word “false” with format specifier %b.]
	{
		int i = 0;
		while( (getLocation(i) == other.getLocation(i) ) && (i < maxDigit)) // getting rid of all extra zeros
		{
			i++;
		}
		if(i == maxDigit)
		{
			return false;
		}
		else
		{
			return ( getLocation(i) < other.getLocation(i) ); // use math less than to make it work. 
		}
	}

	// method isGreaterThanOrEqualTo
	public boolean isGreaterThanOrEqualTo(HugeInteger other) //[Note: Primitive boolean values can be output as the word “true” or the word “false” with format specifier %b.]
	{
		// if we use the same methodology of the method name...
		if(isGreaterThan(other) || isEqualTo(other) )
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	// method isLessThanOrEqualTo
	public boolean isLessThanOrEqualTo(HugeInteger other) //[Note: Primitive boolean values can be output as the word “true” or the word “false” with format specifier %b.]
	{
		// if we use the same methodology of the method name...
		if(isLessThan(other) || isEqualTo(other) )
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public String toString()
	{
		String output = new String();

		if( this.isZero() )
		{
			return output = "0";
		}
//		return output;

		int counter = 0;
		
		while( (this.getLocation(counter) == 0) && (counter < maxDigit) ) 
		{
			counter++;
		}
		
		// when a value that is not zero is reached, ordinary printing can begin
		for( ; counter < maxDigit; counter++)
		{
			output += this.getLocation(counter);
		}
		return output;
		

		// These following lines print out the entire 40 digit String (including zeros)
//		for (int i = 0; i < maxDigit; i++)
//		{
//			output += this.getLocation(i);
//		}
//		
//		return output;

//		// These following lines prints out the String backwards
//		boolean firstNonZero = false;
//		for (int i = maxDigit ; i >= 0; i--)
//		{
//			if ( firstNonZero == false && i - 1 >= 0 && getLocation(i - 1) != 0 )
//			{
//				firstNonZero = true;
//				continue;
//			}
//			if (firstNonZero)
//			{
//				output += String.format( "%d", getLocation(i) );
//			}
//		}

		// the following lines will remove any zeros from the answer (including the ones in the middle!!))
//		String goodoutput = new String();
//		for(int j = maxDigit -1 ; j >= 0; j--)
//		{
//			if(output.charAt(j) != '0')
//				{
//				goodoutput = output.charAt(j) + goodoutput;
//				}
//			else
//				{
//				j--;
//				}
//		}
//		
//		return goodoutput;
//
	}

	public static void main(String[] args)
	{
		// initializing variables
		String hugeInt1;
		String hugeInt2;
		String hugeInt3 = "0";

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("Enter your first Huge Integer:");
		hugeInt1 = input.next();
		HugeInteger hugeArray1 = new HugeInteger(hugeInt1);

		System.out.println("Enter your second Huge Integer:");
		hugeInt2 = input.next();
		HugeInteger hugeArray2 = new HugeInteger(hugeInt2);

		HugeInteger hugeArray3 = new HugeInteger(hugeInt3);

		System.out.println("Your first Huge Integer is: " + hugeArray1.toString() );
		System.out.println("Your second Huge Integer is: " + hugeArray2.toString() );
		System.out.println("Our third (test) Huge Integer is: " + hugeArray3.toString() );

		// to test isZero, isEqualTo, isNotEqualTo, isGreaterThan, isLessThan, isGreaterThanOrEqualTo and isLessThanOrEqualTo.
		//[Note: Primitive boolean values can be output as the word “true” or the word “false” with format specifier %b.]
		System.out.println("Your first Huge Integer is zero? Answer is: " + hugeArray1.isZero() );
		System.out.println("Your second Huge Integer is zero? Answer is: " + hugeArray2.isZero() );
		System.out.println("Our third (test) Huge Integer is zero? Answer is: " + hugeArray3.isZero() );
		
		System.out.println("Is the first Huge Integer Equal To the Second Huge Interger? Answer is: " + hugeArray1.isEqualTo(hugeArray2) );
		System.out.println("Is the first Huge Integer Not Equal To the Second Huge Interger? Answer is: " + hugeArray1.isNotEqualTo(hugeArray2) );
		System.out.println("Is the first Huge Integer Greater Than the Second Huge Interger? Answer is: " + hugeArray1.isGreaterThan(hugeArray2) );
		System.out.println("Is the first Huge Integer Less Than the Second Huge Interger? Answer is: " + hugeArray1.isLessThan(hugeArray2) );
		System.out.println("Is the first Huge Integer Greater Than OR Equal To the Second Huge Interger? Answer is: " + hugeArray1.isGreaterThanOrEqualTo(hugeArray2) );
		System.out.println("Is the first Huge Integer Less Than OR Equal To the Second Huge Interger? Answer is: " + hugeArray1.isLessThanOrEqualTo(hugeArray2) );

		System.out.println("Adding the first Huge Integer to the Second Huge Interger?");
		System.out.printf("\t %40s%n", hugeArray1.toString() ); // example = 16,516,534,453,526
		System.out.printf(" + \t %40s%n", hugeArray2.toString() ); // example = 45,645,416,315
		
		HugeInteger hugeArray4 = new HugeInteger(hugeInt1);
		hugeArray4.add(hugeArray2);
		System.out.printf(" = \t %40s%n", hugeArray4.toString() ); // result = 16,562,179,869,841

		System.out.println("Subtracting the first Huge Integer to the Second Huge Integer?");
		System.out.printf("\t %40s%n", hugeArray1.toString() ); // example = 16,516,534,453,526
		System.out.printf(" - \t %40s%n", hugeArray2.toString() ); // example = 45,645,416,315
		HugeInteger hugeArray5 = new HugeInteger(hugeInt1);
		hugeArray5.subtract(hugeArray2);
		System.out.printf(" = \t %40s%n", hugeArray5.toString() );
		// instructor result is wrong. It should be 16,470,889,037,211 not 16,672,909,057,211

	} //end method main

} // end class HugeInteger
