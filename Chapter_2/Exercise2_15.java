// Exercise 2.15
// Write an application that asks the user to enter two integers,
// obtains them from the user and prints their sum, product,
// difference and quotient (division). Use the techniques shown in Fig.2.7

import java.util.Scanner; // program uses class Scanner

public class Exercise2_15 {
	// main method begins execution of Java application
	public static void main(String[] args) {
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
		
		System.out.println("This application will add, multiply, subtract and divide your first integer with the second.");
		System.out.println("Please sure your first number is higher then the next");
		System.out.print("Enter first integer: "); // prompt #1
        int number1 = input.nextInt(); // read first number from user
		
        System.out.print("Enter second integer: "); // prompt #2
        int number2 = input.nextInt(); // read second number from user

		int sum = number1 + number2; // add numbers, then store total in sum
		int product = number1 * number2; // multiply numbers, then store total in product
		int difference = number1 - number2; // subtract numbers, then store total in difference
		int quotient = number1 / number2; // divide numbers, then store total in quotient
		
		System.out.printf("You have entered %d and %d%n", number1, number2); 
		System.out.printf("%d + %d = %d%n", number1, number2, sum); // display sum
		System.out.printf("%d x %d = %d%n", number1, number2, product); // display product
		System.out.printf("%d - %d = %d%n", number1, number2, difference); // display difference
		System.out.printf("%d / %d = %d%n", number1, number2, quotient); // display quotient

	} // end method main
	
} // end class Exercise2_15
