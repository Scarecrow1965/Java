// Exercise 11.17
/*(Catching Exceptions Using Class Exception)
 Write a program that demonstrates how various exceptions are caught with
catch (Exception exception)
This time, define classes ExceptionA (which inherits from class Exception)
and ExceptionB (which inherits from class ExceptionA).
In your program, create try blocks that throw exceptions of types ExceptionA, ExceptionB,
NullPointerException and IOException.
All exceptions should be caught with catch blocks specifying type Exception.
*/

// trying this out.
// needed to be imported as NullPointerException is outside of ExceptionA, B and C
import java.lang.NullPointerException;
// needed to be imported as IOException is outside of and RuntimeExceptions from ExceptionA, B and C
import java.io.IOException;

public class Exercise1117
{

	public static void main(String[] args)
	{

//		System.out.println("Throwing ExceptionC under the bus.");
//		try
//		{
//			throw new ExceptionC();
//		}
//		catch(ExceptionC error)
//		{
//			// print error message;
//			System.out.println("ExceptionC");
//			System.err.println("Using System.err.println: ExceptionC.");
//			// the err print statement will print first
//		}
//		catch(ExceptionB error) // Eclipse already states this catch is not used
//		{
//			// print error message
//			System.out.println("ExceptionB.");
//			System.err.println("Using System.err.println: ExceptionB.");
//			// the err print statement will print first
//		}
//		catch(ExceptionA error) // Eclipse already states this catch is not used
//		{
//			// print error message
//			System.out.println("ExceptionA.");
//			System.err.println("Using System.err.println:ExceptionA.");
//			// the err print statement will print first
//		}

		System.out.println("Throwing ExceptionB under the bus.");
		try
		{
			throw new ExceptionB();
		}
		catch(ExceptionC error)
		{
			// print error message;
			System.out.println("ExceptionC.");
			System.err.println("Using System.err.println: ExceptionC.");
			// the err print statement will print first
		}
		catch(ExceptionB error)
		{
			// print error message
			System.out.println("ExceptionB.");
			// System.err.println("Using System.err.println: ExceptionB.");
			// the err print statement will print first
		}
		catch(ExceptionA error) // Eclipse already states this catch is not used
		{
			// print error message
			System.out.println("ExceptionA.");
			// System.err.println("Using System.err.println: ExceptionA.");
			// the err print statement will print first
		}

		System.out.println("Throwing ExceptionA under the bus.");
		try
		{
			throw new ExceptionA();
		}
		catch(ExceptionC error)
		{
			// print error message;
			System.out.println("ExceptionC.");
			System.err.println("Using System.err.println: ExceptionC.");
			// the err print statement will print first
		}
		catch(ExceptionB error)
		{
			// print error message
			System.out.println("ExceptionB.");
			// System.err.println("Using System.err.println: ExceptionB.");
			// the err print statement will print first
		}
		catch(ExceptionA error)
		{
			// print error message
			System.out.println("ExceptionA.");
			// System.err.println("Using System.err.println: ExceptionA.");
			// the err print statement will print first
		}

		try
		{
			System.out.println("Throwing NullPointerException under the bus.");
			throw new NullPointerException();
		}
		// since NullPointerException is outside of the scope of ExceptionA, B and C zone the following lines had to be commented
//		catch(ExceptionC error)
//		{
//			// print error message;
//			System.out.println("ExceptionC.");
//			System.err.println("Using System.err.println: ExceptionC.");
//			// the err print statement will print first
//		}
//		catch(ExceptionB error)
//		{
//			// print error message
//			System.out.println("ExceptionB.");
//			System.err.println("Using System.err.println: ExceptionB.");
//			//the err print statement will print first
//		}
//		catch(ExceptionA error)
//		{
//			// print error message
//			System.out.println("ExceptionA.");
//			System.err.println("Using System.err.println: ExceptionA.");
//			//the err print statement will print first
//		}
		catch(Exception NullPointerException)
		{
			// print error message;
			System.err.println("java.lang.NullPointerException");
		}

		try
		{
			System.out.println("Throwing IOException under the bus.");
			throw new IOException();
		}
//		catch(ExceptionC error)
//		{
//			// print error message;
//			System.out.println("ExceptionC.");
//			System.err.println("Using System.err.println: ExceptionC.");
//			//the err print statement will print first
//		}
//		catch(ExceptionB error)
//		{
//			// print error message
//			System.out.println("ExceptionB.");
//			System.err.println("Using System.err.println: ExceptionB.");
//			//the err print statement will print first
//		}
//		catch(ExceptionA error)
//		{
//			// print error message
//			System.out.println("ExceptionA.");
//			System.err.println("Using System.err.println: ExceptionA.");
//			//the err print statement will print first
//		}
//		catch(Exception NullPointerException)
//		{
//			// print error message;
//			System.err.println("java.lang.NullPointerException");
//		}
		catch(Exception IOException)
		{
			// print error message;
			System.err.println("java.io.IOException");
		}

		System.out.println("All Done!");

	} // end method main

} // end class Exercise117
