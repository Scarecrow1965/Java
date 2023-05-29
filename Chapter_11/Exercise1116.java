// Exercise 11.16
/* (Catching Exceptions with Superclasses)
 * Use inheritance to create an exception superclass (called ExceptionA)
 * and exception subclasses ExceptionB and ExceptionC,
 * where ExceptionB inherits from ExceptionA and ExceptionC inherits from ExceptionB.
 * 
 *  Write a program to demonstrate that the catch block for type ExceptionA catches
 *  exceptions of types ExceptionB and ExceptionC.
 */

// probably using chap 11.3 as prime

public class Exercise1116
{
	public static void main(String[] args)
	{
		System.out.println("Throwing ExceptionC under the bus.");
		try
		{
			throw new ExceptionC();
		}
		catch(ExceptionC error)
		{
			// print error message;
			System.out.println("First Exception subclass (ExceptionC) caught");
			System.err.println("Using System.err.println: First Exception subclass (ExceptionC) caught.");
			//the err print statement will print first
		}
		catch(ExceptionB error) // Eclipse already states this catch is not used
		{
			// print error message
			System.out.println("Second Exception subclass (ExceptionB) caught.");
			System.err.println("Using System.err.println: Second Exception subclass (ExceptionB) caught.");
			//the err print statement will print first
		}
		catch(ExceptionA error) // Eclipse already states this catch is not used
		{
			// print error message
			System.out.println("Superclass Exception (ExceptionA) caught.");
			System.err.println("Using System.err.println: Superclass Exception (ExceptionA) caught.");
			//the err print statement will print first
		}

		System.out.println("Throwing ExceptionB under the bus.");
		try
		{
			throw new ExceptionB();
		}
		catch(ExceptionC error)
		{
			// print error message;
			System.out.println("First Exception subclass (ExceptionC) caught.");
			System.err.println("Using System.err.println: First Exception subclass (ExceptionC) caught.");
			//the err print statement will print first
		}
		catch(ExceptionB error)
		{
			// print error message
			System.out.println("Second Exception subclass (ExceptionB) caught.");
			System.err.println("Using System.err.println: Second Exception subclass (ExceptionB) caught.");
			//the err print statement will print first
		}
		catch(ExceptionA error) // Eclipse already states this catch is not used
		{
			// print error message
			System.out.println("Superclass Exception (ExceptionA) caught.");
			System.err.println("Using System.err.println: Superclass Exception (ExceptionA) caught.");
			//the err print statement will print first
		}

		System.out.println("Throwing ExceptionA under the bus.");
		try
		{
			throw new ExceptionA();
		}
		catch(ExceptionC error)
		{
			// print error message;
			System.out.println("First Exception subclass (ExceptionC) caught.");
			System.err.println("Using System.err.println: First Exception subclass (ExceptionC) caught.");
			//the err print statement will print first
		}
		catch(ExceptionB error)
		{
			// print error message
			System.out.println("Second Exception subclass (ExceptionB) caught.");
			System.err.println("Using System.err.println: Second Exception subclass (ExceptionB) caught.");
			//the err print statement will print first
		}
		catch(ExceptionA error)
		{
			// print error message
			System.out.println("Superclass Exception (ExceptionA) caught.");
			System.err.println("Using System.err.println: Superclass Exception (ExceptionA) caught.");
			//the err print statement will print first
		}
		System.out.println("All Done!");

	} // end method main

} //end class Exercise1116