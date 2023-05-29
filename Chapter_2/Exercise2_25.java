// Exercise 2.25
// Write an application that reads an integer and determines
// and prints whether it’s odd or even.
// [Hint: Use the remainder operator. An even number is a
// multiple of 2. Any multiple of 2 leaves a remainder of 0 when divided by 2.]

import java.util.Scanner; // program uses class Scanner

//main method begins execution of Java application
public class Exercise2_25 {

	public static void main(String[] args) {
		// create a Scanner to obtain input from the command window
	      Scanner input = new Scanner(System.in);
	      
	      System.out.println("This application will determine your number to be odd or even");
	      System.out.print("Enter your integer: \n"); // prompt 
	      int number = input.nextInt(); // read number from user
	      
	      if(number % 2 == 0) {
	    	  System.out.println("This number is even");}
	      else 
	    	  System.out.println("This number is odd");
	      
	} // end method main

} // end class Exercise 2_25