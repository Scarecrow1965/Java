// Exercise 14.10
/* (Displaying Strings in Uppercase and Lowercase)
 * Write an application that inputs a line of text and outputs the text
 * twice—once in all uppercase letters and once in all lowercase letters.
 */

import java.util.Scanner;

public class DisplayStrings
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// initializing variables
		

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a line of text:");
		String sentence = input.nextLine();
		
		String sentence1 = sentence.toUpperCase(); 
		String sentence2 = sentence.toLowerCase();
		
		System.out.println("You have entered:");
		System.out.println(sentence);
		System.out.println("This sentence all in UPPER CASE:");
		System.out.println(sentence1);
		System.out.println("This sentence all in lower case:");
		System.out.println(sentence2);

	} // end method main

} // end class DisplayStrings
