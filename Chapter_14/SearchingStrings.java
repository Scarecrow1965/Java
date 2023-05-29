// Exercise 14.11
/*(Searching Strings)
 * Write an application that inputs a line of text and a search character and uses String 
 * method indexOf to determine the number of occurrences of the character in the text.
 */

import java.util.Scanner;

public class SearchingStrings
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// initializing variables
		int i;
		int j = 0;

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("This application will search a sentence for a character "
				+ "and will count how many times that character is within the sentence.");
		System.out.println("Enter a sentence:");
		String sentence = input.nextLine();
		System.out.println("Which character would you like to search for?");
		String character = input.next();

		// to count how many times the character is in the sentence
		for(i = 0; i <= sentence.length(); i++)
			{
//				System.out.print(j); // used for testing purposes only
				if(sentence.indexOf(character, i) == -1)
				{
					break;
				}
				else
				{
					i = sentence.indexOf(character, i);
					j += 1;
				}
			}

		System.out.printf("Character %s was in the sentence %d times.%n", character, j );

	} // end method main

} // end class SearchingStrings
