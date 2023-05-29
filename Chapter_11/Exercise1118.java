import java.io.IOException;

// Exercise 11.18
/*(Order of catch Blocks)
 Write a program demonstrating that the order of catch blocks is important.
 If you try to catch a superclass exception type before a subclass type,
 the compiler should generate errors.
*/

public class Exercise1118
{

	public static void main(String[] args)
	{
		try
		{
			System.out.println("Throwing IOException under the bus.");
			throw new IOException();
		}
		catch(ExceptionC error)
		{
			// print error message;
			System.out.println("ExceptionC.");
			System.err.println("Using System.err.println: ExceptionC.");
			//the err print statement will print first
		}
		catch(ExceptionB error)
		{
			// print error message
			System.out.println("ExceptionB.");
			System.err.println("Using System.err.println: ExceptionB.");
			//the err print statement will print first
		}
		catch(ExceptionA error)
		{
			// print error message
			System.out.println("ExceptionA.");
			System.err.println("Using System.err.println: ExceptionA.");
			//the err print statement will print first
		}
		catch(Exception NullPointerException)
		{
			// print error message;
			System.err.println("java.lang.NullPointerException");
		}
		catch(Exception IOException)
		{
			// print error message;
			System.err.println("java.io.IOException");
		}
	} // end method main

} // end class Exercise1118
