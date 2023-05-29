//Exercise 3.17
/* In this exercise, you’ll design a “starter” HealthProfile class for a user.
 * The class attributes should include the user’s
 * -first name,
 * -last name,
 * -gender,
 * -date of birth (consisting of separate attributes for the month, day and year of birth),
 * -height (in inches) and
 * -weight (in pounds).
 *  Your class should have a constructor that receives this data.
 *  For each attribute, provide set and get methods.
 *  The class also should include methods that calculate and return the user’s
 *  -age in years,
 *  -maximum heart rate and
 *  -target-heart-rate range (see Exercise 3.16), and
 *  -body mass index (BMI; see Exercise 2.33).
 *  Write a Java app that prompts for the user’s information,
 *  instantiates an object of class HealthProfile for that user and prints the information
 *  from that object—including the user’s first name, last name, gender, date of birth, height
 *  and weight—then calculates and prints the user’s age in years, BMI, maximum heart rate
 *  and target-heart-rate range. It should also display the BMI values chart from Exercise 2.33 */

import java.util.Scanner;

public class HealthProfileTest
{

	public static void main(String[] args)
	{
		
		HealthProfile user1 = new HealthProfile(" ", " ", 0, 0, 0, 0, 0, 0, 0, 0);
		
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the member's first name: \n"); // prompt
		String firstName = input.next(); // obtain user input
		user1.setFirstName(firstName); // add firstName to profile
	
		System.out.print("Enter the member's last name: \n"); // prompt
		String lastName = input.next(); // obtain user input
		user1.setLastName(lastName); // add lastName to profile
		
		System.out.print("Enter the member's birth day: \n"); // prompt
		int day = input.nextInt(); // obtain user input
		user1.setDay(day); // add day to profile
		
		System.out.print("Enter the member's birth month: \n"); // prompt
		int month = input.nextInt(); // obtain user input
		user1.setMonth(month); // add month to profile

		System.out.print("Enter the member's birth year: \n"); // prompt
		int year = input.nextInt(); // obtain user input
		user1.setYear(year); // add year to profile
		
		System.out.print("Enter the member's height (ft): \n"); // prompt
		int heightft = input.nextInt(); // obtain user input
		System.out.print("Enter the member's height (in): \n"); // prompt
		int heightin = input.nextInt(); // obtain user input
		int height = (heightft * 12) + heightin;
		user1.setHeight(height); // add height to profile

		System.out.print("Enter the member's weight (lbs): \n"); // prompt
		int weight = input.nextInt(); // obtain user input
		user1.setWeight(weight); // add weight to profile

		System.out.println("In Accordance with https://www.medicalnewstoday.com/articles/types-of-gender-identity#types-of-gender-identity");
		System.out.print("Enter member's gender: \n");
		System.out.print("Agender - \nA person who is agender does not identify with any particular gender,\r\n"
				+ "or they may have no gender at all\r\n"
				+ " = 1\n");
		System.out.print("Androgyne - \nA person who identifies as androgyne has a gender that is either \r\n"
				+ "both masculine and feminine or between masculine and feminine.\r\n"
				+ "= 2\n");
		System.out.print("Bigender -\nA person who identifies as bigender has two genders. \r\n"
				+ "People who are bigender often display cultural masculine and feminine roles.\r\n"
				+ "= 3\n");
		System.out.print("Butch -\n Women, especially lesbians, tend to use this term to describe the way they express masculinity,\r\n"
				+ " or what society defines as masculinity.\r\n"
				+ "= 4\n");
		System.out.print("Cisgender -\n A cisgender person identifies with the sex that they were assigned at birth.\r\n"
				+ "Male = 5\r\n"
				+"Female = 6\n");
		System.out.print("Gender expansive -\n as an “umbrella term used for individuals who broaden their own culture’s commonly\r\n"
				+ " held definitions of gender, including expectations for its expression, identities, roles,\r\n"
				+ " and/or other perceived gender norms.”\r\n"
				+ " = 7\n");
		System.out.print("Genderfluid -\n A person who identifies as genderfluid has a gender identity and presentation that shifts between,\r\n"
				+ " or shifts outside of, society’s expectations of gender.\r\n"
				+ "= 8\n");
		System.out.print("Gender outlaw -\n A person who identifies as a gender outlaw refuses to allow society’s definition of “male”\r\n"
				+ " or “female” to define them.\r\n"
				+ "= 9\n");
		System.out.print("Genderqueer -\n  A person who identifies as genderqueer has a gender identity or expression that is not the same as\r\n"
				+ " society’s expectations for their assigned sex or assumed gender.\r\n"
				+ "= 10\n");
		System.out.print("Masculine of center -\n A person who uses this term is usually a lesbian or a trans person who leans more toward\r\n"
				+ " masculine performances and experiences of gender.\r\n"
				+ "= 11\n");
		System.out.print("Nonbinary -\n A person who identifies as nonbinary does not experience gender within the gender binary.\r\n"
				+ "= 12\n");
		System.out.print("Omnigender -\n A person who identifies as omnigender experiences and possesses all genders.\r\n"
				+ "= 13\n");
		System.out.print("Polygender and pangender -\n People who identify as polygender or pangender experience and display parts of multiple genders.\r\n"
				+ "= 14\n");
		System.out.print("Transgender/Trans -\n Trans is a more inclusive term that covers those who identify as nonbinary and those who are genderless,\r\n"
				+ "= 15\n");
		System.out.print("Two Spirit -\n Two Spirit is an umbrella term that encompasses different sexualities and genders in\r\n"
				+ " Indigenous Native American communities.\r\n"
				+ "= 16\n");
		int gender = input.nextInt(); // obtain user input
		user1.setGender(gender); // add gender to profile
		
		System.out.println("Health Profile");
		System.out.printf("Member: %s %s,%nborn: %s (DD/MM/YYYY)( %d years young).%n", user1.getFirstName(), user1.getLastName(), user1.getDate(), user1.getAge());
		System.out.printf("Gender: %d,%nHeight: %d (inches),%nWeight: %d (lbs),%n%n", user1.getGender(), user1.getHeight(), user1.getWeight());
		System.out.println("Source: http://bit.ly/TargetHeartRates");
		System.out.printf("Their maximum heart rate is %d.%n", user1.MaxHeartRate());
		System.out.printf("%s.%n%n", user1.TargetHeartRate());

	    System.out.println("Source: https://www.nhlbi.nih.gov/health/educational/lose_wt/BMI/bmicalc.htm");
	    System.out.printf("%s", user1.BMI());
	    System.out.println("BMI Categories:"); 
	    System.out.println("Underweight\t =\t <18.5");
	    System.out.println("Normal weight\t =\t 18.5–24.9"); 
	    System.out.println("Overweight\t =\t 25–29.9"); 
	    System.out.println("Obesity\t\t =\t BMI of 30 or greater\n\n");

	} //end method main

} // end class HealthProfileTest
