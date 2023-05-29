// Exercise 8.11
/* (Complex Numbers)
 *  Create a class called Complex for performing arithmetic with complex numbers.
 *  Complex numbers have the form: realPart + imaginaryPart * i
where i is the sqrt(-1) 
Write a program to test your class.
Use floating-point variables to represent the private data of the class.
Provide a constructor that enables an object of this class to be initialized when it’s declared.
Provide a no-argument constructor with default values in case no initializers are provided.
Provide public methods that perform the following operations:
1.	Add two Complex numbers: The real parts are added together and the imaginary parts are added together.
2.	Subtract two Complex numbers: The real part of the right operand is subtracted from the real part
of the left operand, and the imaginary part of the right operand is subtracted from the imaginary part of the left operand.
3.	Print Complex numbers in the form (realPart, imaginaryPart).
*/

// import static java.lang.Math.sqrt;

public class Complex
{
	private double realPart;
	private double imaginaryPart;

	// Complex no-argument constructor: 
	// initializes each instance variable to zero
	public Complex()
	{
		this(0, 0); // invoke constructor with two arguments
	}

	// constructor Complex
	public Complex (double realPart, double imaginaryPart)
	{
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}

	// method to add two complex numbers
	// realParts are added together
	// imaginaryParts are added together
	public static Complex AddCmplxNmbrs(Complex num1, Complex num2)
	{
		Complex temp1 = new Complex();

		temp1.realPart = num1.realPart + num2.realPart;
		temp1.imaginaryPart = num1.imaginaryPart + num2.imaginaryPart;

		return temp1;
	}

	// method to subtract two complex numbers
	// real part of the right operand is subtracted from the real part of the left operand
	// imaginary part of the right operand is subtracted from the imaginary part of the left operand
	public static Complex SubtrctCmplxNmbrs(Complex num1, Complex num2)
	{
		Complex temp2 = new Complex();

		temp2.realPart = num1.realPart - num2.realPart;
		temp2.imaginaryPart = num1.imaginaryPart - num2.imaginaryPart;

		return temp2;
	}

	// print complex numbers (realPart and imaginaryPart)
	public String toString()
	{
		return String.format("%.1f, %.1f", realPart, imaginaryPart);
	}

} // end class Complex
