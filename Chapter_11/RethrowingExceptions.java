// Exercise 11.20
/*(Rethrowing Exceptions)
 * Write a program that illustrates rethrowing an exception.
 * Define methods someMethod and someMethod2.
 * Method someMethod2 should initially throw an exception.
 * Method someMethod should call someMethod2, catch the exception and rethrow it.
 * Call someMethod from method main, and catch the rethrown exception.
 * Print the stack trace of this exception.
 */

public class RethrowingExceptions
{

	public static void main(String[] args)
	{
		try
		{
			someMethod(); 
		}
		catch (Exception exception) // exceptions thrown from someMethod
		{
			// exception.getCause(); // has no effect
			// exception.getMessage(); // has no effect
			exception.printStackTrace();
		}
	} // end method main

	public static void someMethod() throws Exception
	{
		
		try
		{
			someMethod2(); 
		}
		catch (Exception exception) // exception thrown from someMethod2
		{
			throw exception;
		}
	} // end method someMethod

	// someMethod2 initially throws the exception 
	public static void someMethod2() throws Exception
	{
		System.out.println("Exception thrown in someMethod2");
		throw new Exception();
	

	} // end method someMethod2

} // end class RethrowingExceptions
