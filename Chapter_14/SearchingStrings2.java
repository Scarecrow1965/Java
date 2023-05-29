// Exercise 14.12
/* (Searching Strings)
 * Write an application based on the application in Exercise 14.11 that inputs a line of text
 * and uses String method indexOf to determine the total number of occurrences of each letter
 * of the alphabet in the text.
 * Uppercase and lowercase letters should be counted together.
 * Store the totals for each letter in an array, and print the values in tabular format after
 * the totals have been determined.
 */

import java.util.Scanner;

public class SearchingStrings2
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// initializing variables
		int maxcharacters = 26;
		String[] charArray = {"a","b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
				"o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"}; 
		int[] frequ = new int[maxcharacters];

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("This application will allow you to enter a sentence.");
		System.out.println("Then it will count all the characters within that sentence and display");
		System.out.println("then the result of the character counts.");
		
		System.out.println("Please enter your sentence:");
		String sentence = input.nextLine();
		String sentence1 = sentence.toLowerCase();

		// this is taken from previous exercise and it works
		// to count how many times the character is in the sentence
		//String character = "a"; // this is an example of a character search
		//int j = 0;
		//for(int i = 0; i <= sentence.length(); i++)
			//{
				//System.out.print(j); // used for testing purposes only
				//if(sentence.indexOf(character, i) == -1)
				//{
					//break;
				//}
				//else
				//{
					//i = sentence.indexOf(character, i);
					//j += 1;
				//}
			//}
		// at the end j would tell you how many times the character was seen.

		
		// to count how many times the character is in the sentence
		for(int j = 0 ; j < charArray.length; j++) // this loop is for the character
			{
			for(int i = 0; i <= sentence1.length(); i++) // this loop is for the sentence
			{
//				System.out.printf("j= %d%n", j); // used for testing purposes only
//				System.out.printf("i= %d%n", i); // used for testing purposes only
//				System.out.printf("charArray[j]= %s%n", charArray[j] ); // used for testing purposes only
//				System.out.printf("sentence.indexOf(%s, %d)= %d%n", charArray[j], i, sentence.indexOf(charArray[j], i) ); // used for testing purposes only
//				System.out.printf("frequ[j]= %d%n", frequ[j] ); // used for testing purposes only
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
			System.out.printf("%s was displayed %d times.%n", charArray[k], frequ[k]);
		}

	} // end method main

} // end class SearchingStrings2
