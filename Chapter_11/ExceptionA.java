// Exercise 11.16
/* (Catching Exceptions with Superclasses)
 * Use inheritance to create an exception superclass (called ExceptionA)
 * and exception subclasses ExceptionB and ExceptionC,
 * where ExceptionB inherits from ExceptionA and ExceptionC inherits from ExceptionB.
 * 
 *  Write a program to demonstrate that the catch block for type ExceptionA catches
 *  exceptions of types ExceptionB and ExceptionC.
 */

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

public class ExceptionA extends Exception // added extends Exception for exercise 11.17
{

} // end class ExceptionA
