// Fig. 3.9: AccountTest.java
// Inputting and outputting floating-point numbers with Account objects.

import java.util.Scanner;

public class AccountTest
{
   public static void main(String[] args)
   {
	   Account account1 = new Account("Jane Green", 50.00);
	   // new stores Account object and calls the constructor Account to initialize the object which will be the object's name
	   Account account2 = new Account("John Blue", -7.53); 
	   // new stores Account object and calls the constructor Account to initialize the object which will be the object's name
	   
	   // display initial balance of each object
	   System.out.printf("%s balance: $%.2f%n",
			   account1.getName(), account1.getBalance()); 
	   System.out.printf("%s balance: $%.2f%n%n",
			   account2.getName(), account2.getBalance()); 

	   // create a Scanner to obtain input from the command window
	   Scanner input = new Scanner(System.in);

	   // from Fig 3.2
	   // display initial value of name (null)
	   // System.out.printf("Initial name is: %s%n%n", myAccount.getName());

	   // prompt for and read name
	   // System.out.println("Please enter the name:");
	   // String theName = input.nextLine(); // read a line of text
	   // myAccount.setName(theName); // put theName in myAccount
	   // System.out.println(); // outputs a blank line

	   // display the name stored in object myAccount
	   // System.out.printf("Name in object myAccount is:%n%s%n",
			   // myAccount.getName());
	   
	   // This section is for depositing amounts
	   System.out.print("Enter deposit amount for account1: "); // prompt
	   double depositAmount = input.nextDouble(); // obtain user input
	   System.out.printf("%nadding %.2f to account1 balance%n%n", 
			   depositAmount);
	   account1.deposit(depositAmount); // add to account1's balance

	   // display balances
	   System.out.printf("%s balance: $%.2f%n",
			   account1.getName(), account1.getBalance()); 
	   System.out.printf("%s balance: $%.2f%n%n",
			   account2.getName(), account2.getBalance()); 

	   System.out.print("Enter deposit amount for account2: "); // prompt
	   depositAmount = input.nextDouble(); // obtain user input
	   System.out.printf("%nadding %.2f to account2 balance%n%n", 
			   depositAmount);
	   account2.deposit(depositAmount); // add to account2 balance

	   // display balances
	   System.out.printf("%s balance: $%.2f%n", 
			   account1.getName(), account1.getBalance()); 
	   System.out.printf("%s balance: $%.2f%n%n",
			   account2.getName(), account2.getBalance());
	   
	   // this section is for withdrawing amounts

   } // end method main
   
} // end class AccountTest

/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
