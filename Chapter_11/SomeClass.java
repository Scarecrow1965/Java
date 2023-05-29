// Exercise 11.19
/*(Constructor Failure)
 Write a program that shows a constructor passing information about constructor
 failure to an exception handler.
 Define class SomeClass, which throws an Exception in the constructor.
 Your program should try to create an object of type SomeClass and catch the
 exception that’s thrown from the constructor.
 */

public class SomeClass
{

	// constructor with throws an Exception
	public static void SomeClass() throws Exception
	{
		try
		{
			System.out.println("Testing the constructor exception");
			throw new Exception();
		}
		catch (Exception exception)
		{
			System.err.println("Exception thrown, caught and rethrown");
			throw exception;
		}
		finally
		{
			System.err.println("Exception finally executed");
		}
	}
	
	public static void main(String[] args)
	{

		try
		{
			SomeClass(); 
		}
		catch (Exception exception) // exception thrown by SomeClass
		{
			System.err.println("java.lang.Exception");
		}
	} // end method main

} // end class SomeClass
