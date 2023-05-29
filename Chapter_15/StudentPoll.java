// Exercise 15.8
/*(Student Poll)
 * Figure 7.8 contains an array of survey responses that’s hard coded into the program.
 * Suppose we wish to process survey results that are stored in a file.
 * This exercise requires two separate programs.
 * First, create an application that prompts the user for survey responses and outputs
 * each response to a file.
 * Use a Formatter to create a file called numbers.txt.
 * Each integer should be written using method format.
 * Then modify the program in Fig. 7.8 to read the survey responses from numbers.txt.
 * The responses should be read from the file by using a Scanner.
 * Use method nextInt to input one integer at a time from the file.
 * The program should continue to read responses until it reaches the end of the file.
 * The results should be output to the text file "output.txt".
 */

/*
// Fig. 7.8: StudentPoll.java
// Poll analysis program.

public class StudentPoll
{
	public static void main(String[] args)
	{
		// student response array (more typically, input at runtime)
		int[] responses = {1, 2, 5, 4, 3, 5, 2, 1, 3, 3, 1, 4, 3, 3, 3, 2, 3, 3, 2, 14};
		int[] frequency = new int[6]; // array of frequency counters

		// for each answer, select responses element and use that value
		// as frequency index to determine element to increment
		for (int answer = 0; answer < responses.length; answer++)
		{
			try
			{
				++frequency[responses[answer]];
			}
			catch (ArrayIndexOutOfBoundsException e)
			{
				System.out.println(e); // invokes toString method
				System.out.printf("   responses[%d] = %d%n%n", answer, responses[answer]);
			}
		}

		System.out.printf("%s%10s%n", "Rating", "Frequency");

		// output each array element's value
		for (int rating = 1; rating < frequency.length; rating++)
		{
			System.out.printf("%6d%10d%n", rating, frequency[rating]);
		}
	}
}
*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.SecurityException;
//import java.net.URI;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
//import java.util.Scanner;

public class StudentPoll
{
	// initializing variables

	// student response array (more typically, input at runtime)
	public static final int[] responses = {1, 2, 5, 4, 3, 5, 2, 1, 3, 3, 1, 4, 3, 3, 3, 2, 3, 3, 2, 14};
	public static int[] frequency = new int[6]; // array of frequency counters
	public static int rating;

	public static void main(String[] args)
	{
		Format(responses, frequency);
	}// end method main
	
	public static void Format(int[] responses, int[] frequency)
	{
		// first is the input of information
		// for each answer, select responses element and use that value
		// as frequency index to determine element to increment
		for (int answer = 0; answer < responses.length; answer++)
		{
			try
			{
				++frequency[responses[answer]];
			}
			catch (ArrayIndexOutOfBoundsException e)
			{
				System.out.println(e); // invokes toString method
				System.out.printf("   responses[%d] = %d%n%n", answer, responses[answer]);
			}
		}
		// now we enter all the information into a file
		try
		{
			Formatter output = new Formatter("numbers.txt");
			for (rating = 1; rating < frequency.length; rating++)
			{
				output.format("%6d%10d%n", rating, frequency[rating]);
				System.out.printf("%6d%10d%n", rating, frequency[rating]);
			}
			output.close();
		}
		catch (SecurityException | FileNotFoundException | FormatterClosedException e)
		{
			e.printStackTrace();
			System.exit(1); // terminate the program
		}

		// output of the results indicated here and should be the same as the numbers.txt file
		System.out.printf("%s%10s%n", "Rating", "Frequency");
		// output each array element's value
		for (rating = 1; rating < frequency.length; rating++)
		{
			System.out.printf("%6d%10d%n", rating, frequency[rating]);
		}
	} // end method methodFormat

} // end class StudentPoll
