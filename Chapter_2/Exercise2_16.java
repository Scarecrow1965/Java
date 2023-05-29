// Exercise 2.16
// Write an application that asks the user to enter two integers,
// obtains them from the user and displays the larger number followed
// by the words "is larger".
// If the numbers are equal, print the message "These numbers are equal".
// Use the techniques shown in Fig.2.15.

import java.util.Scanner; // program uses class Scanner

public class Exercise2_16 {
   // main method begins execution of Java application
   public static void main(String[] args) {
      // create Scanner to obtain input from command line
      Scanner input = new Scanner(System.in);

      System.out.print("Enter first integer: "); // prompt #1
      int number1 = input.nextInt(); // read first number from user 

      System.out.print("Enter second integer: "); // prompt #2
      int number2 = input.nextInt(); // read second number from user 
      
      // used my knowledge of other languages and tested to see if it would work
      // if, else, and else if works!!!
      if (number1 == number2) {
         System.out.printf("These nubmers are equal");
	  }

      else if (number1 > number2) {
         System.out.printf("%d is larger than %d%n", number1, number2);
	  }

      else {
         System.out.printf("%d is larger than %d%n", number2, number1);
	  }

	}// end method main

}// end class Execrise2_16
