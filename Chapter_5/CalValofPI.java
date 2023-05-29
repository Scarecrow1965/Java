// Exercise 5.20
// Print a table that shows the value of π approximated by computing the first 200,000 terms of this series.

public class CalValofPI
{

	public static void main(String[] args)
	{
		// initializing variables
		double val = 4;
		double PI = 4;
		double odd = 3;
		
		System.out.println("This application will display 200,000 terms of the infinite series.");
		// formula is PI = 4 - 4/3 + 4/5 - 4/7 + 4/9 - 4/11 + ....

		for(int i = 0; i < 200000; i++)
		{
			if(i % 2 == 0)
				{
					PI += -(val / odd);	
				}
			else
				{
					PI += (val / odd);
				}
			System.out.printf("The value of PI for term %d\t is\t %.05f%n", i, PI);
			odd += 2;
		}
		
	} // end method main

} // end class CalValofPI
