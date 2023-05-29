// Exercise 14.18
/* (Text Analysis)
 * String manipulation enables interesting approaches to analyzing the writings of great authors.
 * Much attention has been focused on whether William Shakespeare ever lived.
 * Some scholars believe there’s substantial evidence indicating that Christopher Marlowe actually
 * penned the masterpieces attributed to Shakespeare.
 * Researchers have used computers to find similarities in the writings of these two authors.
 * This exercise examines three methods for analyzing texts with a computer.
 * 
 * 1. Write an application that reads a line of text from the keyboard and prints a table indicating
 * the number of occurrences of each letter of the alphabet in the text. For example, the phrase
 * To be, or not to be: that is the question: contains one “a,” two “b’s,” no “c’s,” and so on.
 * 
 * 2. Write an application that reads a line of text and prints a table indicating the number of
 * one-letter words, two-letter words, three-letter words, and so on, appearing in the text.
 * For example, Fig. 14.25 shows the counts for the phrase -> Whether 'tis nobler in the mind to suffer
 * Fig. 14.25
 * Word length	Occurrences
 * 1	0
 * 2	2
 * 3	1
 * 4	2 (including 'tis)
 * 5	0
 * 6	2
 * 7	1
 * Word-length counts for the string "Whether 'tis nobler in the mind to suffer"
 * 
 * 3. Write an application that reads a line of text and prints a table indicating the number of
 * occurrences of each different word in the text.
 * The application should include the words in the table in the same order in which they appear in the text.
 * For example, the lines:
 * To be, or not to be: that is the question:
 * Whether 'tis nobler in the mind to suffer
 * contain the word “to” three times, the word “be” two times, the word “or” once, etc.
*/

import java.util.Scanner;

public class TextAnalysis
{
	// Part 1
	// initializing variables
	final static int maxcharacters = 26;
	final static String[] charArray = {"a","b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
			"o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"}; 
	final static int[] frequ = new int[maxcharacters];
	// Part 2
	// initializing new variables
	final static int[] textlength = new int[20];
	// Part 3
	// initializing variables
	final static int[] freq = new int[20];

	public static void CharacterCount(String sentence)
	{
		String sentence1 = sentence.toLowerCase();

		// to count how many times the character is in the sentence
		for(int j = 0 ; j < charArray.length; j++) // this loop is for the character
		{
			for(int i = 0; i <= sentence1.length(); i++) // this loop is for the sentence
			{
				if(sentence1.indexOf(charArray[j], i) == -1)
				{
					break;
				}
				else
				{
					i = sentence1.indexOf(charArray[j], i);
					frequ[j] += 1; // increment the frequency for that character
				}
			}
		}
		System.out.printf("The sentence you have entered is:%n%s%nThe following character(s) were used:%n", sentence);
		for (int k= 0; k < maxcharacters; k++)
		{
			System.out.printf("%s was displayed %02d times.%n", charArray[k], frequ[k]);
		}
	}
	
	public static void WordLengthCount(String sentence2)
	{
		String[] token = sentence2.split("[\\s]");

//		// used for testing purposes only
//		System.out.println("Here are the parts of the string:");
//		for(int m = 0; m < token.length ; m++)
//		{
//			System.out.printf("part %d of the string is: %s%n", m, token[m]);
//		}

		for(int i = 0; i < token.length; i++)
		{
			textlength[token[i].length()]++;
		}
		
		System.out.printf("The sentence you have entered is:%n%s%n", sentence2);
		System.out.println("Number of");
		System.out.println("Letters \tCount");
		for(int j= 1; j < token.length; j++)
		{
			System.out.printf("%02d\t\t%d%n", j, textlength[j]);
		}
	}

	public static void WordTypeCount(String sentence4)
	{
		String sentence5 = sentence4.toLowerCase();

		String[] token2 = sentence5.split("[\\s,:.]+");

//		// used for testing purposes only
//		System.out.println("Here are the parts of the string:");
//		for(int i = 0; i < token2.length ; i++)
//		{
//			System.out.printf("part %02d of the string is: %s%n", i, token2[i]);
//		}

		for(int j = 0; j < token2.length; j++) // to count the string tokens
		{
			for(int k = 1; k < token2.length; k++) // to count the other tokens to compareTo
			{
				// get the first string and then compare it to the others
				if(token2[j].compareTo(token2[k]) == 0 )
				{
					freq[j]++;
				}
			}
		}
		// if no return then take next string and start all over again
		// must count when there is more than one int[] freq created.

		System.out.printf("The sentence you have entered is:%n%s%n", sentence4);
		for(int m = 0; m < token2.length; m++)
		{
			System.out.printf("Word: %s\tused %02d times.%n", token2[m], freq[m]);
		}
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//***************************Part 1**************************

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("Part 1");
		System.out.println("This application will allow you to enter a sentence.");
		System.out.println("Then it will count all the characters within that sentence and display");
		System.out.println("then the result of the character counts.");
		System.out.println("Please enter your sentence:");
		String sentence = input.nextLine();
		// used line below to replace input line for testing purposes
		//String sentence = "To be, or not to be: that is the question";

		CharacterCount(sentence);

		System.out.println();
		// ***********************end*Part 1*************************

		//***************************Part 2**************************
		System.out.println("Part 2");
		System.out.println("This part will display how many characters per word you have entered.");
		String sentence2 = input.nextLine();
		// used line below to replace input line for testing purposes
		// String sentence2 = "Whether 'tis nobler in the mind to suffer";

		WordLengthCount(sentence2);

		System.out.println();
		// ***********************end*Part 2*************************

		//***************************Part 3**************************
		System.out.println("Part 3");
		System.out.println("This part will display how many words were duplicated from what you have entered.");
		System.out.println("Enter your sentence:");
		String sentence4 = input.nextLine();
		// used line below to replace input line for testing purposes
		// String sentence4 = "To be, or not to be: that is the question. Whether 'tis nobler in the mind to suffer.";

		WordTypeCount(sentence4);
		
		// ***********************end*Part 3*************************

	} // end method main


} // end class TextAnalysis
