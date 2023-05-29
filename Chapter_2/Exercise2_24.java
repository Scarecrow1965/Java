// Exercise 2.24
// Write an application that reads five integers and determines and prints
// the largest and smallest integers in the group.
// Use only the programming techniques you learned in this chapter.

import java.util.Scanner; // program uses class Scanner

public class Exercise2_24 {
	  // main method begins execution of Java application
	public static void main(String[] args) {
		// create Scanner to obtain input from command line
	      Scanner input = new Scanner(System.in);

	      System.out.print("Enter first integer: "); // prompt #1
	      int number1 = input.nextInt(); // read first number from user 

	      System.out.print("Enter second integer: "); // prompt #2
	      int number2 = input.nextInt(); // read second number from user 
	      
	      System.out.print("Enter third integer: "); // prompt #3
	      int number3 = input.nextInt(); // read third number from user 
	      
	      System.out.print("Enter fourth integer: "); // prompt #4
	      int number4 = input.nextInt(); // read third number from user
	      
	      System.out.print("Enter fifth integer: "); // prompt #5
	      int number5 = input.nextInt(); // read third number from user 
	      
	      int max = number1; // to find the largest number 
	      if (number2 > number1) {
	            	max = number2;}
	      if (number3 > number2) {
	            	max = number3;}
	      if (number4 > number3) {
	    	  		max = number4;}
	      if (number5 > number4) {
	    	  		max = number5;}
	      
	      int min = number1; // to find the smallest number
	      if(number2 < number1) {
	    	  min = number2;}
	      if(number3 < number2) {
	    	  min = number3;}
	      if(number4 < number3) {
	    	  min = number4;}
	      if(number5 < number4) {
	    	  min = number5;}

	      System.out.printf("The smallest number is: %d%n", min);
	      System.out.printf("The largest number is: %d%n", max);
	} // end method main

} // end class Exercise 2_24
