// Exercise 8.16
/* (Rational Numbers)
 Create a class called Rational for performing arithmetic with fractions.
 Write a program to test your class.
 Use integer variables to represent the private instance variables of the class—the numerator and the denominator.
 Provide a constructor that enables an object of this class to be initialized when it’s declared.
 The constructor should store the fraction in reduced form.
 The fraction 2/4 is equivalent to 1/2 and would be stored in the object as 1 in the numerator and 2 in the denominator.
 Provide a no-argument constructor with default values in case no initializers are provided.
 Provide public methods that perform each of the following operations:
1. Add two Rational numbers: The result of the addition should be stored in reduced form.
 Implement this as a static method.
2. Subtract two Rational numbers: The result of the subtraction should be stored in reduced form.
 Implement this as a static method.
3. Multiply two Rational numbers: The result of the multiplication should be stored in reduced form.
 Implement this as a static method.
4. Divide two Rational numbers: The result of the division should be stored in reduced form.
 Implement this as a static method.
5. Return a String representation of a Rational number in the form a/b, where a is the numerator and b is the denominator.
6. Return a String representation of a Rational number in floating-point format.
(Consider providing formatting capabilities that enable the user of the class to specify the number of digits of precision to the right of the decimal point.)

*/

import java.util.Scanner;

public class RationalTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// initializing variables
		// fractions look like: numerator / denominator
		int numerator; // numerator of fraction
		int denominator; // denominator of fraction
		int precision; // used to get precision of the results
		int temp = 0; // used as temporary menu input
		
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("This application will allow the user to input to sets of fractions,");
		System.out.println("then have the option to: Add, Subtract, Multiply and Divide them. ");

		System.out.println("For your first fraction");
		System.out.println("Please enter the numerator");
		numerator = input.nextInt();
		System.out.println("Please enter the denominator");
		denominator = input.nextInt();
		Rational num1 = new Rational(numerator, denominator);
		System.out.printf("Your fraction is %s%n", num1.toString() );

		System.out.println("For your second fraction");
		System.out.println("Please enter the numerator");
		numerator = input.nextInt();
		System.out.println("Please enter the denominator");
		temp = input.nextInt();
		denominator = temp;
		Rational num2 = new Rational(numerator, denominator);

		//(Consider providing formatting capabilities that enable the user of the class to specify the number of digits of precision to the right of the decimal point.)


		while(temp != 99)
		{
			System.out.printf("Your fraction is %s%n", num1.toString() );
			System.out.printf("Your fraction is %s%n", num2.toString() );
			System.out.println("Please enter the precision for your results");
			precision = input.nextInt();
			Rational result = new Rational();
			System.out.println("Here are your options:");
			System.out.println("(1) to Add your fractions");
			System.out.println("(2) to Subtract your fractions");
			System.out.println("(3) to Multiply your fractions");
			System.out.println("(4) to Divide your fractions");
			System.out.println("(99) to exit.");
			temp = input.nextInt();
			switch(temp)
			{
			case 1:
			{
				result = num1.AddNumbers(num2);
				System.out.printf("The addition of both fractions is: %s or %s%n", result.toString(), result.FloattoString(precision) );
//				System.out.printf("The addition of %s and %s is: %s or %s%n", num1.toString(), num2.toString(),
//						result.toString(), result.FloattoString(precision) );
				break;
			}
			case 2:
			{
				result = num1.SubNumbers(num2);
				System.out.printf("The substraction of %s and %s is: %s or %s%n", num1.toString(), num2.toString(),
						result.toString(), result.FloattoString(precision) );
				break;
			}
			case 3:
			{
				result = num1.MultiNumbers(num2);
				System.out.printf("The multiplication of %s and %s is: %s or %s%n", num1.toString(), num2.toString(),
						result.toString(), result.FloattoString(precision) );
				break;
			}
			case 4:
			{
				result = num1.DivNumbers(num2);
				System.out.printf("The division of %s and %s is: %s or %s%n", num1.toString(), num2.toString(),
						result.toString(), result.FloattoString(precision) );
				break;
			}
			case 99:
			{
				break;
			}
			default:
			{
				System.out.println("You have entered a wrong number. Please try again");
				temp = input.nextInt();
			}
			} // end switch
		} // end while

	} //end method main

} // end class RationalTest
