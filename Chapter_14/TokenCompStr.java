// Exercise 14.13
/* (Tokenizing and Comparing Strings)
 *  Write an application that reads a line of text,
 *  tokenizes the line using space characters as delimiters and
 *  outputs only those words beginning with the letter "b".
 */

import java.util.Scanner;

public class TokenCompStr
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// initializing variables
		

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("This application will allow you to enter a sentence.");
		System.out.println("Then it will display all words that starts with a 'b'");
		System.out.println("Please enter your sentence:");
		String sentence = input.nextLine();

		// now to use the split method
		// sentence.split("[\\s]+") -> uses whitespace to create a separation
		// sentence.split("") -> separates everything including all characters
		// String[] tokens = sentence.replaceAll("\\s","").split(""); // removes all whitespaces and joins everything together
		String[] token = sentence.split("[\\s]");

//		// used for testing purposes only
//		System.out.println("Here are the parts of the string:");
//		for(int i = 0; i < token.length ; i++)
//		{
//			System.out.printf("part %d of the string is: %s%n", i, token[i]);
//		}

		for(int i = 0; i < token.length; i++)
		{
			if(token[i].substring(0,1).equals("b") ) // was if( token[i].indexOf('b', 0) != -1)
			{
				// System.out.print(token[i].indexOf('b')); // used for testing purposes only
				System.out.print(token[i]);
			}
		}


	} // end method main

} // end class TokenCompStr
