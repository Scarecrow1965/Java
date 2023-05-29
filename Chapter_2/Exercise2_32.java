// Exercise 2.32
// Write a program that inputs five numbers and determines and prints
// the number of negative numbers input, the number of positive numbers
// input and the number of zeros input.

import java.util.Scanner; // program uses class Scanner

public class Exercise2_32 {

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
	      int number4 = input.nextInt(); // read fourth number from user
	      
	      System.out.print("Enter fifth integer: "); // prompt #5
	      int number5 = input.nextInt(); // read fifth number from user
	      
	      if(number1>0) {System.out.printf("This number: %d is a positive input.%n", number1);}
	      if(number2>0) {System.out.printf("This number: %d is a positive input.%n", number2);}
	      if(number3>0) {System.out.printf("This number: %d is a positive input.%n", number3);}
	      if(number4>0) {System.out.printf("This number: %d is a positive input.%n", number4);}
	      if(number5>0) {System.out.printf("This number: %d is a positive input.%n", number5);}
	      if(number1<0) {System.out.printf("This number: %d is a negative input.%n", number1);}
	      if(number2<0) {System.out.printf("This number: %d is a negative input.%n", number2);}
	      if(number3<0) {System.out.printf("This number: %d is a negative input.%n", number3);}
	      if(number4<0) {System.out.printf("This number: %d is a negative input.%n", number4);}
	      if(number5<0) {System.out.printf("This number: %d is a negative input.%n", number5);}
	      if(number1==0) {System.out.printf("This number: %d is a zero input.%n", number1);}
	      if(number2==0) {System.out.printf("This number: %d is a zero input.%n", number2);}
	      if(number3==0) {System.out.printf("This number: %d is a zero input.%n", number3);}
	      if(number4==0) {System.out.printf("This number: %d is a zero input.%n", number4);}
	      if(number5==0) {System.out.printf("This number: %d is a zero input.%n", number5);}
	      
	} // end method main

} // end class Exercise2_32
