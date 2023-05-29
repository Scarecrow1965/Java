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
1.	Add two Rational numbers: The result of the addition should be stored in reduced form.
 Implement this as a static method.
2.	Subtract two Rational numbers: The result of the subtraction should be stored in reduced form.
 Implement this as a static method.
3.	Multiply two Rational numbers: The result of the multiplication should be stored in reduced form.
 Implement this as a static method.
4.	Divide two Rational numbers: The result of the division should be stored in reduced form.
 Implement this as a static method.
5.	Return a String representation of a Rational number in the form a/b, where a is the numerator and b is the denominator.
6.	Return a String representation of a Rational number in floating-point format.
(Consider providing formatting capabilities that enable the user of the class to specify the number of digits of precision to the right of the decimal point.)
*/

/* Operations of Fractions
All mathematical operations are performed on fractions as well but have a different method.
Common operations are:
Addition:
For adding two fractions, numerator of first fraction is multiplied by the denominator of second
and numerator of second fraction is multiplied by the denominator of second fraction and both are added to
form the numerator of the resulting fraction.
Denominator of resulting fraction is determined by multiplying the denominators of both the fractions.
Finally the resulting fraction is reduced to its lowest form.
Example, 2/7 + 7/4 = (2 * 4) + (7 * 7) / (7 * 4) = 57/28

Subtraction:
Similar to addition, numerator of first fraction is multiplied by the denominator of second and numerator
of second fraction is multiplied by the denominator of second fraction and both are subtracted to form the
numerator of the resulting fraction.
Denominator of resulting fraction is determined by multiplying the denominators of both the fractions.
Example, 11/3 – 2/5 = (11 * 5) – (2 * 3) / (3 * 5) = 49/15

Multiplication:
This is straight-forward. Numerator of first fraction is multiplied by the numerator of second and denominator
of second fraction is multiplied by the denominator of second fraction.
Finally, the resulting fraction is reduced to its simplest form.
Example, 14/5 * 2/7 = (14 * 2) / (5 * 7) = 28/35 = 4/5(reduced to simplest form)

Division:
Numerator of first fraction is multiplied with denominator of second and denominator of first fraction is multiplied
with numerator of second and the resulting fraction is reduced to its simplest form.
Example, 12/7 ÷ 4/3 = 36/28 = 9/7(reduced to simplest form)
*/

public class Rational
{
	// initializing variables
	// Use integer variables to represent the private instance variables of the class—the numerator and the denominator.
	private int numerator;
	private int denominator;

	// no-argument constructor
	public Rational()
	{
		numerator = 1;
		denominator = 1;
	}

	// Provide a constructor that enables an object of this class to be initialized when it’s declared.
	public Rational(int num, int den)
	{
		if(den == 0)
		{
			throw new IllegalArgumentException("denominator cannot be 0");
		}
		this.numerator = num;
		this.denominator = den;
		ReduceFrac();
	}

	private final void ReduceFrac()
	{
		int gcd = 0;
		int smaller;

		// find the greatest common denominator of the two numbers
		smaller = Math.min(numerator, denominator);

		// incorporate the GCD here 
		for(int i = smaller; i >= 2; i--)
		{
			if(numerator % i == 0 && denominator % i == 0)
			{
			gcd = i;
			break;
			}
		}

		if(gcd != 0)
		{
			numerator /= gcd;
			denominator /=gcd;
		}
	}

	//1. Add two Rational numbers: The result of the addition should be stored in reduced form.
	// Implement this as a static method.
	/* Addition:
	For adding two fractions, numerator of first fraction is multiplied by the denominator of second
	and numerator of second fraction is multiplied by the denominator of second fraction and both are added to
	form the numerator of the resulting fraction.
	Denominator of resulting fraction is determined by multiplying the denominators of both the fractions.
	Finally the resulting fraction is reduced to its lowest form.
	Example, 2/7 + 7/4 = (2 * 4) + (7 * 7) / (7 * 4) = 57/28*/
	public Rational AddNumbers(Rational num2)
	{
		int sumnum = numerator * num2.denominator + num2.numerator * denominator;
		int sumden = denominator * num2.denominator;
		// ReduceFrac();
		return new Rational(sumnum, sumden);
	}

	//2. Subtract two Rational numbers: The result of the subtraction should be stored in reduced form.
	// Implement this as a static method.
	/*Subtraction:
	Similar to addition, numerator of first fraction is multiplied by the denominator of second and numerator
	of second fraction is multiplied by the denominator of second fraction and both are subtracted to form the
	numerator of the resulting fraction.
	Denominator of resulting fraction is determined by multiplying the denominators of both the fractions.
	Example, 11/3 – 2/5 = (11 * 5) – (2 * 3) / (3 * 5) = 49/15 */
	public Rational SubNumbers(Rational num2)
	{
		int subnum = numerator * num2.denominator - num2.numerator * denominator;
		int subden = denominator * num2.denominator;
		// ReduceFrac();
		return new Rational (subnum, subden);
	}

	//3. Multiply two Rational numbers: The result of the multiplication should be stored in reduced form.
	// Implement this as a static method.
	/*Multiplication:
	This is straight-forward. Numerator of first fraction is multiplied by the numerator of second and denominator
	of second fraction is multiplied by the denominator of second fraction.
	Finally, the resulting fraction is reduced to its simplest form.
	Example, 14/5 * 2/7 = (14 * 2) / (5 * 7) = 28/35 = 4/5(reduced to simplest form) */
	public Rational MultiNumbers(Rational num2)
	{
		int multinum = numerator * num2.numerator;
		int multiden = denominator * num2.denominator;
		// ReduceFrac();
		return new Rational (multinum, multiden);
	}

	//4. Divide two Rational numbers: The result of the division should be stored in reduced form.
	// Implement this as a static method.
	/* Division:
	Numerator of first fraction is multiplied with denominator of second and denominator of first fraction is multiplied
	with numerator of second and the resulting fraction is reduced to its simplest form.
	Example, 12/7 ÷ 4/3 = 36/28 = 9/7(reduced to simplest form)
	 */
	public Rational DivNumbers(Rational num2)
	{
		int divnum = numerator * num2.denominator;
		int divden = denominator * num2.numerator;
		// ReduceFrac();
		return new Rational (divnum, divden);
	}

	// 5. Return a String representation of a Rational number in the form a/b, where a is the numerator and b is the denominator.
	public String toString()
	{
		return String.format(numerator + " / " + denominator);
	}

	// 6. Return a String representation of a Rational number in floating-point format.
	// (Consider providing formatting capabilities that enable the user of the class to specify the number of digits of precision to the right of the decimal point.)
	public String FloattoString(int precision)
	{
		double result = numerator / denominator;
		return String.format("%." + precision + "f", result);
	}

} // end class Rational
