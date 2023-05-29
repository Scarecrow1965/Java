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

public class ComplexTest
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// initializing variables
		Complex a = new Complex(9.5, 7.7);
		Complex b = new Complex(1.2, 3.1);
		
		Complex temp1 = Complex.AddCmplxNmbrs(a, b);
		Complex temp2 = Complex.SubtrctCmplxNmbrs(a, b);
		System.out.println("The following equation is submitted: (9.5 + 7.7i) + (1.2 + 3.1i)");
		System.out.printf("The sum of complex numbers is: %s%n", temp1.toString());
		System.out.println("The following equation is submitted: (9.5 - 7.7i) - (1.2 - 3.1i)");
		System.out.printf("The subtraction of complex numbers is: %s%n", temp2.toString());
	}

}
