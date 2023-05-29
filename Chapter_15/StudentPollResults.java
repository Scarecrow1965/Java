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
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.Scanner;

public class StudentPollResults
{
	// initializing variables
	// first part is for the input
	public static Path StudentPollresults = Paths.get("c:\\Users\\steph\\OneDrive\\Documents\\Coding for Veterans\\Java\\Chapter15\\numbers.txt");
	public static int[] pollresults = new int[10];

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// first we extract the information from a file
		methodnextInt();

		methodOutput();

	} // end method main

	public static void methodOutput()
	{
		// next we output the information to a file
		try
		{
			try (Formatter output = new Formatter("output.txt"))
			{
				System.out.println("This is the output of the info");
				System.out.printf("%s%10s%n", "Rating", "Frequency"); // for testing purposes only
				for (int i = 0; i < pollresults.length; i++)
				{
					output.format("%6d%10d%n", pollresults[i], pollresults[i + 1]);
					System.out.printf("%6d%10d%n", pollresults[i], pollresults[i + 1]); // for testing purposes only
					i++;
				}
				output.close();
			}
		}
		catch (SecurityException | FileNotFoundException | FormatterClosedException e)
		{
			e.printStackTrace();
			System.exit(1); // terminate the program
		}
	} // end method moethodOutput

	public static void methodnextInt()
	{
		try
		{
			URI path = StudentPollresults.toUri();
			Scanner input = new Scanner(Paths.get(path) );

			while(input.hasNext())
			{
				try
				{
					for(int i = 0; i < pollresults.length; i++)
					{
						pollresults[i] = input.nextInt();
					}
				}
				catch (ArrayIndexOutOfBoundsException e)
				{
					System.out.println(e);
				}
			}
			System.out.println("This is the retrieval of info from file");
			// to verify that we have the info
			System.out.printf("%s%10s%n", "Rating", "Frequency");
			for(int i = 0; i < pollresults.length; i++)
			{
				System.out.printf("%6d%10d%n", pollresults[i] , pollresults[i + 1]);
				i++;
			}
		}
		catch (IOException ioexception)
		{
			System.err.println("Cannot find file. Program terminates.");
		}
		catch (SecurityException | FormatterClosedException e)
		{
			e.printStackTrace();
		}

	} // end method methodnextInt
	
} // end class StudentPollResults
