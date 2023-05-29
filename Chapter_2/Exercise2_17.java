// Exercise 2.17
// Write an application that inputs three integers from the user
// and displays the sum, average, product, smallest and largest of the numbers.
// Use the techniques shown in Fig.2.15 .
// [Note: The calculation of the average in this exercise should result in an integer
// representation of the average. So, if the sum of the values is 7, the average should be 2, not 2.3333….]

import java.util.Scanner; // program uses class Scanner

public class Exercise2_17 {
	  // main method begins execution of Java application
   public static void main(String[] args) {
      // create Scanner to obtain input from command line
      Scanner input = new Scanner(System.in);

      System.out.println("This application will add, multiply, average out and display which one if smallest and largest of your three integers.");
      System.out.print("Enter first integer: "); // prompt #1
      int number1 = input.nextInt(); // read first number from user 

      System.out.print("Enter second integer: "); // prompt #2
      int number2 = input.nextInt(); // read second number from user 
      
      System.out.print("Enter third integer: "); // prompt #3
      int number3 = input.nextInt(); // read third number from user 
      
      int max = number1; // to find the largest number 
      if (number2 > number1) {
            	max = number2;}
      if (number3 > number2) {
            	max = number3;}
      
      int min = number1; // to find the smallest number
      if(number2 < number1) {
    	  min = number2;}
      if(number3 < number2) {
    	  min = number3;}
      
      int sum = number1 + number2 + number3; // to find the sum
      int product = number1 * number2 * number3; // to find the product
      int average = (number1 + number2 + number3)/3; // to find the average
      // time to display them all
      System.out.printf("The sum is: %d%n", sum);
      System.out.printf("The product is: %d%n", product);
      System.out.printf("The average is: %d%n", average);
      System.out.printf("The smallest number is: %d%n", min);
      System.out.printf("The largest number is: %d%n", max);
   } // end method main
   
} // end class Exercise2_17
