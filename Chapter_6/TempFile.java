// This is a tempfile to practice and process that requires touchups without changing the actual java file.

public class TempFile 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int sum = 0;
		int x = 0;
		for(int num = 1; num < 1000; num++)
			{
			for(int factor = 1; factor < num; factor++)
				{
					x= num % factor;
					if(x == 0)
						sum = sum + factor;
				}
			if(sum == num)
				{
				System.out.println("\n\n"+num+":");
				System.out.println("\nThe factors are: ");

				for(int factor = 1; factor < num; factor++)
					{
					x= num % factor;
					if(x == 0)
						System.out.println(factor);
					}
				}
			sum = 0;
			}

	} //end method main

} // end class TempFile
