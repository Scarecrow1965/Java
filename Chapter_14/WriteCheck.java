// Exercise 14.21
/*(Writing the Word Equivalent of a Check Amount)
 * Continuing the discussion in Exercise 14.20 , we reiterate the importance of designing
 * check-writing systems to prevent alteration of check amounts.
 * One common security method requires that the amount be written in numbers and spelled
 * out in words as well.
 * Even if someone is able to alter the numerical amount of the check, it’s extremely
 * difficult to change the amount in words.
 * Write an application that inputs a numeric check amount that’s less than $1000 and
 * writes the word equivalent of the amount. For example, the amount 112.43 should be
 * written as
 * ONE hundred TWELVE and 43/100
 */

import java.util.Scanner;

public class WriteCheck
{
	// initializing variables
	static String checkamount = "";
	static String checkcents = "";
	static String checkdollars = "";
	static int dollarsOnes;
	static int dollarsTens;
	static int dollarsHundreds;
	final static String[] onesunits = {"One", "Two", "Three", "Four", "Five", "Six", "Seven",
			"Eight", "Nine"};
	// 0 = One, 1= Two, 2 = Three, 3 = Four, 4 = Five, 5 = Six, 6 = Seven
	// 7 = Eight, 8 = Nine
	final static String[] tensunits = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
			"Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", };
	// 0 = Ten, 1 = Eleven, 2 = Twelve, 3 = Thirteen, 4 = Fourteen, 5 = Fifteen
	// 6 = Sixteen, 7 = Seventeen, 8 = Eighteen, 9 = Nineteen
	
	final static String[] multipleoftens = {"", "Twenty",
			"Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	// 0 = blank, 1 = Twenty, 2 = Thirty, 3 = Forty, 4 = Fifty, 5 = Sixty, 6 = Seventy
	// 7 = Eighty, 8 = Ninety
	final static String[] hundredsunits = {"Hundred"};
	// 0 = Hundred, leaving room for expansion

	public static void main(String[] args)
	{
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("This application will help you write out a check for anything less than $1,000.00 but more than $1.");
		System.out.println("Please enter the amount for the check:");
		System.out.print("$");
		String checkamount = input.nextLine();
		// replace checkamount input with the following line 
		// String checkamount = "9.45";
		
		// need to figure out how to ensure String does not go less that 1.00 or more than 1000.00
		Double check = Double.valueOf(checkamount);
		int check1 = check.intValue();
//		System.out.printf("%.02f%n", check);
//		System.out.println(check1);
		if(check1 < 1 || check1 > 1000)
		{
			System.out.println("Sorry, this application must be more than one ($1) dollar and less than a ($1000) thousand.");
			System.out.println("Please try again.");
			checkamount = input.nextLine();
		}
		System.out.println();

//		// if I use checkamount1 as a String
		String[] token = checkamount.split("[\\s.]"); 

//		// Used the following lines for testing purposes only
//		System.out.println("Here are the parts of the string:");
//		for(int i = 0; i < token.length ; i++)
//		{
//			System.out.printf("part %d of the string is: %s%n", i, token[i]);
//		}
		// output is: token[0] is dollars and token[1] is cents
		checkcents = token[1];
		checkdollars = token[0];
		
		System.out.println();
		System.out.printf("The amount you have entered is: $%s%n", checkamount);
		
		// idea taken from https://www.daniweb.com/programming/software-development/threads/35087/run-the-number-to-the-word-equivalent
		int LengthInDollars = checkdollars.length();
		// System.out.println(checkdollars.length()); // verifying length
		switch(LengthInDollars)
		{
		case 3:
		{
			//get ones digit
			char onesDigit = checkdollars.charAt(LengthInDollars-1);
			// System.out.println(checkdollars.charAt(LengthInDollars-1) ); // verifying ones unit
			int dollarsOnes = ConverttoDigit(onesDigit); // convert char into ACSII digit
			// Under10(dollarsOnes, dollarsTens);
			//get tens digit
			char tensDigit = checkdollars.charAt(LengthInDollars-2);
			// System.out.println(checkdollars.charAt(LengthInDollars-2) ); // verifying tens unit
			int dollarsTens = ConverttoDigit(tensDigit); // convert char into ACSII digit
			// Tens(dollarsOnes, dollarsTens);
			//get hundreds digit
			char hundredsDigit = checkdollars.charAt(LengthInDollars-3);
			// System.out.println(checkdollars.charAt(LengthInDollars-3) ); // verifying hundreds unit
			int dollarsHundreds = ConverttoDigit(hundredsDigit); // convert char into ACSII digit
			// Hundreds(dollarsHundreds);
			System.out.printf("This amount you have entered is written as:%n -> %s and %s %s . %s%n",
				Hundreds(dollarsHundreds), Tens(dollarsOnes, dollarsTens), Under10(dollarsOnes, dollarsTens), checkcents);
			break;
		}
		case 2:
		{
			//get ones digit
			char onesDigit = checkdollars.charAt(LengthInDollars-1);
			// System.out.println(checkdollars.charAt(LengthInDollars-1) ); // verifying ones unit
			int dollarsOnes = ConverttoDigit(onesDigit); // convert char into ACSII digit
			// Under10(dollarsOnes, dollarsTens);
			//get tens digit
			char tensDigit = checkdollars.charAt(LengthInDollars-2);
			// System.out.println(checkdollars.charAt(LengthInDollars-2) ); // verifying tens unit
			int dollarsTens = ConverttoDigit(tensDigit); // convert char into ACSII digit
			// Tens(dollarsOnes, dollarsTens);
			System.out.printf("This amount you have entered is written as:%n -> %s %s . %s%n",
					Tens(dollarsOnes, dollarsTens), Under10(dollarsOnes, dollarsTens), checkcents);
			break;
		}
		case 1:
		{
			//get ones digit
			char onesDigit = checkdollars.charAt(LengthInDollars-1);
			// System.out.println(checkdollars.charAt(LengthInDollars-1) ); // verifying ones unit
			int dollarsOnes = ConverttoDigit(onesDigit); // convert char into ACSII digit
			// Under10(dollarsOnes, dollarsTens);
			System.out.printf("This amount you have entered is written as:%n -> %s . %s%n",
					Under10(dollarsOnes, 48), checkcents);
		}
		}

	} // end method main

	public static int ConverttoDigit(char digits)
	{
		int digit = digits;
		// System.out.println(digits); // verifying integer tens unit
		return digit;
		/* char 0 = ASCII int 48, char 1 = ASCII int 49
		 * char 2 = ASCII int 50, char 3 = ASCII int 51
		 * char 4 = ASCII int 52, char 5 = ASCII int 53
		 * char 6 = ASCII int 54, char 7 = ASCII int 55
		 * char 8 = ASCII int 56, char 9 = ASCII int 57 */
	}

	public static String Under10(int dollarsOnes, int dollarsTens)
	{
		/* char 0 = ASCII int 48, char 1 = ASCII int 49
		 * char 2 = ASCII int 50, char 3 = ASCII int 51
		 * char 4 = ASCII int 52, char 5 = ASCII int 53
		 * char 6 = ASCII int 54, char 7 = ASCII int 55
		 * char 8 = ASCII int 56, char 9 = ASCII int 57 */
		//onesunits[] =
		// 0 = One, 1= Two, 2 = Three, 3 = Four, 4 = Five, 5 = Six, 6 = Seven
		// 7 = Eight, 8 = Nine
		String ones = "";
		for(int i = 48; i <= 57; i++)
		{
			if(dollarsTens == 49)
			{
				Tens(dollarsOnes, dollarsTens);
			}
			if(dollarsTens == 48 && i == dollarsOnes)
			{
				ones = onesunits[i - 49];
			}
			if(dollarsTens >= 50 && i == dollarsOnes)
			{
				ones = onesunits[i -49];
			}
		}
		return ones;
	}

	public static String Tens(int dollarsOnes, int dollarsTens)
	{
		/* char 0 = ASCII int 48, char 1 = ASCII int 49
		 * char 2 = ASCII int 50, char 3 = ASCII int 51
		 * char 4 = ASCII int 52, char 5 = ASCII int 53
		 * char 6 = ASCII int 54, char 7 = ASCII int 55
		 * char 8 = ASCII int 56, char 9 = ASCII int 57 */
		// tensunits[] =
		// 0 = Ten, 1 = Eleven, 2 = Twelve, 3 = Thirteen, 4 = Fourteen, 5 = Fifteen
		// 6 = Sixteen, 7 = Seventeen, 8 = Eighteen, 9 = Nineteen
		// multiplesoftens[] = 
		// 0 = blank, 1 = Twenty, 2 = Thirty, 3 = Forty, 4 = Fifty, 5 = Sixty, 6 = Seventy
		// 7 = Eighty, 8 = Ninety
		String tens = "";

		for(int i = 48; i <= 57; i++)
		{
		if(dollarsTens == 48)
		{
			Under10(dollarsOnes, dollarsTens);
		}
		if(dollarsTens == 49) // this must work for 10 - 19
		{
			for(int j = 48; j <= 57; j++)
			{
				if(dollarsTens == 49 && dollarsOnes == 48 ) // looking for 10
				{
					tens = tensunits[0];
				}
				// now must look for numbers that are 11-19
				if(dollarsTens == 49 && dollarsOnes == j)
				{
					tens = tensunits[j - 48];
				}
			}
			}
		if(dollarsTens >= 50 && i == dollarsTens ) // this must work for 20 to 90
		{
			tens = multipleoftens[i - 49];
			Under10(dollarsOnes, dollarsTens);
		}
		}
		return tens;
	}

	public static String Hundreds(int dollarsHundreds)
	{
		/* char 1 = ASCII int 49, char 2 = ASCII int 50
		 * char 3 = ASCII int 51, char 4 = ASCII int 52
		 * char 5 = ASCII int 53, char 6 = ASCII int 54
		 * char 7 = ASCII int 55, char 8 = ASCII int 56
		 * char 9 = ASCII int 57 */
		//onesunits[] =
		// 0 = One, 1= Two, 2 = Three, 3 = Four, 4 = Five, 5 = Six, 6 = Seven
		// 7 = Eight, 8 = Nine
		String hundreds = "";
		for(int i = 49; i <= 57; i++)
		{
			if(i == dollarsHundreds )
			{
				hundreds = onesunits[i-49] + " " + hundredsunits[0];
			}
		}
		return hundreds;
	}

} // end class WriteCheck
