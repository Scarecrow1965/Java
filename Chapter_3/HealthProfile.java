//Exercise 3.17
/* In this exercise, you’ll design a “starter” HealthProfile class for a person.
 * The class attributes should include the person’s
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
 *  Write a Java app that prompts for the person’s information,
 *  instantiates an object of class HealthProfile for that person and prints the information
 *  from that object—including the person’s first name, last name, gender, date of birth, height
 *  and weight—then calculates and prints the person’s age in years, BMI, maximum heart rate
 *  and target-heart-rate range. It should also display the BMI values chart from Exercise 2.33 */


public class HealthProfile
{
	// initializing variables
	private String firstName;
	private String lastName;
	private int gender;
	private int day;
	private int month;
	private int year;
	private int height;
	private int weight;
	private int age;
	private float bmiStandard;
	private int heartRate;
	
	// constructor
	public HealthProfile(String firstName, String lastName, int gender, int day, int month, int year,
			int height, int weight, int age, float bmiStandard)
	{
		// default initiation
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.day = day;
		this.month = month;
		this.year = year;
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.bmiStandard = bmiStandard;
		this.gender = gender;
	} //end constructor

	//method setFirstName
		public void setFirstName(String firstName)
		{
			this.firstName = firstName;
		} // end method setFirstName
		
		//method getFirstName
		public String getFirstName()
		{
			return firstName;
		} //end method getFirstName
		
		//method setLastName
		public void setLastName(String lastName)
		{
			this.lastName = lastName;
		} // end method setLastName
		
		//method getLastName
		public String getLastName()
		{
			return lastName;
		} // end method getLastName
		
		//method setDay
		public void setDay(int day)
		{
			this.day = day;
		} // end method setDay
		
		//method getDay
		public int getDay()
		{
			return day;
		} // end method getDay
		
		//method setMonth
		public void setMonth(int month)
		{
			this.month = month;
		} // end method setMonth
		
		//method getMonth
		public int getMonth()
		{
			return month;
		} // end method getMonth
		
		//method setYear
		public void setYear(int year)
		{
			this.year = year;
		} // end method setYear
		
		//method getYear
		public int getYear()
		{
			// if(year < )
			return year;
		} //end method getYear
		
		//method setGender
		public void setGender(int gender)
		{
			this.gender = gender;
		} // end method setGender
		
		//method getGender
		public int getGender()
		{
//			System.out.print("Agender - \nA person who is agender does not identify with any particular gender,\r\n"
//					+ "or they may have no gender at all\r\n"
//					+ " = 1\n");
//			System.out.print("Androgyne - \nA person who identifies as androgyne has a gender that is either \r\n"
//					+ "both masculine and feminine or between masculine and feminine.\r\n"
//					+ "= 2\n");
//			System.out.print("Bigender -\nA person who identifies as bigender has two genders. \r\n"
//					+ "People who are bigender often display cultural masculine and feminine roles.\r\n"
//					+ "= 3\n");
//			System.out.print("Butch -\n Women, especially lesbians, tend to use this term to describe the way they express masculinity,\r\n"
//					+ " or what society defines as masculinity.\r\n"
//					+ "= 4\n");
//			System.out.print("Cisgender -\n A cisgender person identifies with the sex that they were assigned at birth.\r\n"
//					+ "Male = 5\r\n"
//					+"Female = 6\n");
//			System.out.print("Gender expansive -\n as an “umbrella term used for individuals who broaden their own culture’s commonly\r\n"
//					+ " held definitions of gender, including expectations for its expression, identities, roles,\r\n"
//					+ " and/or other perceived gender norms.”\r\n"
//					+ " = 7\n");
//			System.out.print("Genderfluid -\n A person who identifies as genderfluid has a gender identity and presentation that shifts between,\r\n"
//					+ " or shifts outside of, society’s expectations of gender.\r\n"
//					+ "= 8\n");
//			System.out.print("Gender outlaw -\n A person who identifies as a gender outlaw refuses to allow society’s definition of “male”\r\n"
//					+ " or “female” to define them.\r\n"
//					+ "= 9\n");
//			System.out.print("Genderqueer -\n  A person who identifies as genderqueer has a gender identity or expression that is not the same as\r\n"
//					+ " society’s expectations for their assigned sex or assumed gender.\r\n"
//					+ "= 10\n");
//			System.out.print("Masculine of center -\n A person who uses this term is usually a lesbian or a trans person who leans more toward\r\n"
//					+ " masculine performances and experiences of gender.\r\n"
//					+ "= 11\n");
//			System.out.print("Nonbinary -\n A person who identifies as nonbinary does not experience gender within the gender binary.\r\n"
//					+ "= 12\n");
//			System.out.print("Omnigender -\n A person who identifies as omnigender experiences and possesses all genders.\r\n"
//					+ "= 13\n");
//			System.out.print("Polygender and pangender -\n People who identify as polygender or pangender experience and display parts of multiple genders.\r\n"
//					+ "= 14\n");
//			System.out.print("Transgender/Trans -\n Trans is a more inclusive term that covers those who identify as nonbinary and those who are genderless,\r\n"
//					+ "= 15\n");
//			System.out.print("Two Spirit -\n Two Spirit is an umbrella term that encompasses different sexualities and genders in\r\n"
//					+ " Indigenous Native American communities.\r\n"
//					+ "= 16\n");
			return gender;
		} // end method getGender
		
		//method setHeight 
		public void setHeight(int height)
		{
			this.height = height;
		} // end method setHeight
		
		//method getHeight
		public int getHeight()
		{
			return height;
		} // end method getHeight
		
		// method setWeight
		public void setWeight(int weight)
		{
			this.weight = weight;
		} // end method setWeight
		
		//method getWeight
		public int getWeight()
		{
			return weight;
		} // end method geWeight
		
		//method getAge
		public int getAge()
		{
			int today = 2022; // opted to use this year as part of the age calculation
			age = today - year;
			return age;
					
			//day,month,year - today = age
		}
		
		//method getDate
				public String getDate()
				{
					return String.format("%d / %d / %d", day, month, year);
				} // end method getDate
				
		//method MaxHeartRate
		public int MaxHeartRate()
		{
			heartRate = 220 - getAge();
			return heartRate;
			// max heart rate = 220 - age
		} //end method MaxHeartRate
		
		//method TargetheartRate
		public String TargetHeartRate()
		{
			return String.format("Target Heart rate is %d - %d", (int)(heartRate * .5), (int)(heartRate * .85));
			// 50% of MaxHeartRate is min
			// 85% of MaxHeartRate is max
		} //end method TargetHeartRate
		
		//method calculate BMI
		public String BMI()
		{
			bmiStandard = ((weight * 703) / (height * height));
			return String.format("Member's BMI is: %.1f%n%n", bmiStandard);
		} // end method BMI
    	
    	
    	
		
} // end class HealthProfile
