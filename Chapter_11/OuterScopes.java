// Exercise 11.21
/*(Catching Exceptions Using Outer Scopes)
 * Write a program showing that a method with its own try block does not have to catch
 * every possible error generated within the try.
 * Some exceptions can slip through to, and be handled in, other scopes.
 */

public class OuterScopes
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
			System.out.println("someMethod throws Exception");
			throw new Exception();
		}
		catch (Exception exception) // exception thrown from someMethod2
		{
			System.out.println("Exception is handled in someMethod");
		}
	} // end method someMethod

	// someMethod2 initially throws the exception 
	public static void someMethod2() throws Exception
	{
		System.out.println("Exception thrown in someMethod2");
		throw new Exception();
	} // end method someMethod2

} // end class OuterScopes
