// Exercise Chapter 2.10 to 2.14 Complete

public class Exercise_Chap2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		{
			System.out.println("Exercise 2.10 Answer:");
			int x = 2;
			int y = 3;
			System.out.printf("x = %d%n", x);
			System.out.printf("Value of %d + %d is %d%n", x, x, (x + x));
			System.out.printf("x = %n");
			System.out.printf("%d = %d%n", (x + y), (y + x));
		}
		{
			System.out.println("Exercise 2.12 Answer:");
			int a = 3;
			int x = 4;
			// Given that y = ax3 + 7, which of the following are correct Java statements
			// for this equation?
			// Answer should be y = 199 
			System.out.println("Given that y = ax3 + 7, and a=3 and x=4,\n which of the following are correct\n Java statements for this equation?");
			System.out.println("Result should be 199");
			
			System.out.println("int y = a * x * x * x + 7; ");
			int y = a * x * x * x + 7;
			System.out.printf("int y = %d%n", y);
			
			System.out.println("int y = a * x * x * (x + 7); ");
			int y1 = a * x * x * (x + 7);
			System.out.printf("int y = %d%n", y1);
			
			System.out.println("int y = (a * x) * x * (x + 7); ");
			int y2 = (a * x) * x * (x + 7);
			System.out.printf("int y = %d%n", y2);
			
			System.out.println("int y = (a * x) * x * x + 7; ");
			int y3 = (a * x) * x * x + 7;
			System.out.printf("int y = %d%n", y3);
			
			System.out.println("int y = a * (x * x * x) + 7; ");
			int y4 = a * (x * x * x) + 7;
			System.out.printf("int y = %d%n", y4);
			
			System.out.println("int y = a * x * (x * x + 7); ");
			int y5 = a * x * (x * x + 7);
			System.out.printf("int y = %d%n", y5);
		}
		{
			System.out.println("Exercise 2.13 Answer:");
			// State the order of evaluation of the operators in each of the following
			// Java statements, and show the value of x after each statement is performed:
			System.out.println("int x = 7 + 3 * 6 / 2 - 1; ");
			int x = 7 + 3 * 6 / 2 - 1;
			System.out.printf("int x = %d%n", x);
			
			System.out.println("int x1 = 2 % 2 + 2 * 2 - 2 / 2; ");
			int x1 = 2 % 2 + 2 * 2 - 2 / 2;
			System.out.printf("int x = %d%n", x1);
			
			System.out.println("int x2 = (3 * 9 * (3 + (9 * 3 / (3)))); ");
			int x2 = (3 * 9 * (3 + (9 * 3 / (3))));
			System.out.printf("int x = %d%n", x2);
		}
		{
			System.out.println("Exercise 2.14 Answer:");
			// Write an application that displays the numbers 1 to 4 on the same line,
			// with each pair of adjacent numbers separated by one space. Use the following techniques:
			System.out.println("1. Use one System.out.println statement.");
			System.out.println("1 2 3 4");
			
			System.out.println("2. Use four System.out.print statements.");
			System.out.print("1 ");
			System.out.print("2 ");
			System.out.print("3 ");
			System.out.print("4\n");
			
			System.out.println("3. Use one System.out.printf statement.");
			System.out.printf("1 2 3 4%n");
		}
	}// end method main
}// end class Exercise_Chap2