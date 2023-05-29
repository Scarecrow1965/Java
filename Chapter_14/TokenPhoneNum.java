// Exercise 14.8
/*(Tokenizing Telephone Numbers)
 * Write an application that inputs a telephone number as a string in the form (555) 555-5555.
 * The application should use String method split to extract the area code as a token, the
 * first three digits of the phone number as a token and the last four digits of the phone
 * number as a token.
 * The seven digits of the phone number should be concatenated into one string.
 * Both the area code and the phone number should be printed.
 * Remember that you’ll have to change delimiter characters during the tokenization process.
 */

import java.util.Scanner;

public class TokenPhoneNum
{
		// validate phone 
		public static boolean validatePhone(String phone)
		{
			// North American area code standard
			return phone.matches("\\([2-9]\\d{2}\\)\\s[1-9]\\d{2}-\\d{4}");
		}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// initializing variables
		String phoneNumber = "";

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter your number:");
		System.out.println("(Ex: (555) 555-5555)");
		phoneNumber = input.nextLine();
		// replace the line above for testing purposes only
		// phoneNumber = "(555) 556-5557";
		
		// to ensure phone number is correct standard
		if(!validatePhone(phoneNumber) )
		{
			System.out.print("This is not a valid phone number. Please try again.");
			phoneNumber = input.nextLine();
		}
//		else // for testing purposes only
//		{
//			System.out.println(validatePhone(phoneNumber));
//			System.out.println("This number is valid!");
//		}

		// now to use the split method
		// String tokens = phoneNumber.split("[\\s]+");
		// uses whitespace to create a separation
		// String[] tokens = phoneNumber.split("");
		// separates everything including all characters
		// String[] tokens = phoneNumber.replaceAll("\\s","").split("");
		// removes all whitespaces and joins everything together
		// String[] tokens = phoneNumber.split("^\\(\\d{3}\\)\\s\\d{3}-\\d{4}");
		// does not work
		// String[] tokens = phoneNumber.split("[()\\s\\-]");
		// this creates 5 tokens with the first and third as empty space/blank
		// String[] tokens = phoneNumber.split("[()\\s\\-]+");
		// this get 90% of my info but has an extra token at token[0] which is blank/empty or has a space in it
		// String[] tokens = phoneNumber.split("\\) ");
		// this creates only two tokens; one is the area code with the first parentheses,
		// the other is the full dashed phone number

		String phoneNumber1 = phoneNumber.replaceAll("[^0-9]", " ");
		String phoneNumber2 = phoneNumber1.trim();
		String[] tokens = phoneNumber2.split("[\\s]+");
		// or
		// String[] tokens = phoneNumber.split("\\b[^0-9]+");
		
		// Used the following lines for testing purposes only
//		System.out.println("Here are the parts of the string:");
//		for(int i = 0; i < tokens.length ; i++)
//		{
//			System.out.printf("part %d of the string is: %s%n", i, tokens[i]);
//		}
		
		// from Ali
		// String[] tokens = phoneNumber.split("\\) ");
		// String areaCode = tokens[0].substring(1);
		// tokens = tokens[1].split("-");
		// String number = tokens[0] + tokens[1];
		// System.out.printf("Area Code: %s\nPhone Number: %s\n", areaCode, number);

		// now for the output
//		System.out.println("The area code is:");
//		System.out.println(tokens[0].substring(1));
//		System.out.println("Your phone number is:");
//		System.out.println(tokens[1]);

		// if I use the 90% solution, then use the following lines
		// System.out.println("The area code is:");
		// // since token[0] contains blank/empty/has a space on it then must use token[1]
		// System.out.println(tokens[1]);
		// The next four lines are for confirmation only
		// // System.out.println("The first three digits of the phone number is:");
		// // System.out.println(tokens[2]);
		// // System.out.println("The last four digits of the phone number is:");
		// // System.out.println(tokens[3]);
		// System.out.println("Your phone number is:");
		// System.out.println(tokens[2] + "-" + tokens[3]);

		System.out.println("The area code is:");
		System.out.println(tokens[0]);
		// The next four lines are for confirmation only
		// System.out.println("The first three digits of the phone number is:");
		// System.out.println(tokens[1]);
		// System.out.println("The last four digits of the phone number is:");
		// System.out.println(tokens[2]);
		System.out.println("Your phone number is:");
		System.out.println(tokens[1] + "-" + tokens[2]);

	} // end main method

} // end class TokenPhoneNum
