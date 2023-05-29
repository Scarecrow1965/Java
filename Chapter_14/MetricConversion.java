// Exercise 14.23
/*(Metric Conversions)
 * Write an application that will assist the user with metric conversions.
 * Your application should allow the user to specify the names of the units as strings
 * (i.e., centimeters, liters, grams, and so on, for the metric system and inches, quarts,
 * pounds, and so on, for the English system) and should respond to simple questions, such as
 * "How many inches are in 2 meters?"
 * "How many liters are in 10 quarts?"
 * 
 * Your application should recognize invalid conversions.
 * For example, the question
 * "How many feet are in 5 kilograms?"
 * is not meaningful because "feet" is a unit of length, whereas "kilograms" is a unit of mass.
 * 
 */

import java.util.Arrays;
import java.util.Scanner;

public class MetricConversion
{
	// initializing variables
	public static int selection;
	public static String [] conversionType;
	public static String units = "";
	public static String question = "";
	public static double result; // this will be used for all formulas
	public static double factor; // this will be used for all formulas
	protected static String temperatureSymbol;
	protected static double valuenow;
	
	// Temperature:
	// protected final String[] tempMetric = {"celsius"};
	// protected final String[] tempStandard = {"fahrentheit"};
	protected static final String[] temperatureConversion = {"celsius", "fahrentheit"};
	protected static final String[] temperatureSymbols = {"*C", "*F"};
	
		// speed:
		// mph to kph

	public static void main(String[] args)
	{
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("This application will carry out conversions of metric to US standard and vice versa.");
		// removed the following lines since it does not work with the exercise output.
		//System.out.println("Please enter your question in the following format:");
		//System.out.println("How many ______ are in XX _____?");
		//System.out.println("where ____ are conversion format and XX are numbers (even XX.XX is accepted.");
		//System.out.println("Please note that any conversion that are two words must have a _ between them.");
		// question = input.nextLine();
		// replaced line above for testing purposes
		//question = "How many inches are in 2 meters?";
		
		//String[] token = question.split("[\\s?]");
		// used for testing purposes only
		//System.out.println("Here are the parts of the string:");
		//for(int m = 0; m < token.length ; m++)
		//{
		//	System.out.printf("part %d of the string is: %s%n", m, token[m]);
		//}
		// token[0],[1] are irrelevant
		// token[2] is conversion #1 string
		// token[3],[4] are irrelevant
		// token[5] will be a number
		// token[6] is conversion #2 string

		// System.out.print("Please select if you want this application to:\n (1) convert standard to metric; or\n (2) convert metric to standard.");

		System.out.println("Here are your selections:");
		for(int i = 0 ; i <= LengthConversion.lengthConversion.length - 1; i++)
			System.out.print(LengthConversion.lengthConversion[i]+ ", ");
		System.out.println();
		for(int i = 0 ; i <= WeightConversion.weightConversion.length - 1; i++)
			System.out.print(WeightConversion.weightConversion[i]+ ", ");
		System.out.println();
		for(int i = 0 ; i <= VolumeConversion.volumeConversion.length - 1; i++)
			System.out.print(VolumeConversion.volumeConversion[i]+ ", ");
		System.out.println();
		for(int i = 0 ; i <= temperatureConversion.length - 1; i++)
			System.out.print(temperatureConversion[i]+ ", ");
		System.out.println();

		System.out.println("Convert from: ");
		String fromUnit = input.nextLine();
		if(FindFromUnit(LengthConversion.lengthConversion, fromUnit) == -1)
		{
			if(FindFromUnit(WeightConversion.weightConversion, fromUnit) == -1)
			{
				if(FindFromUnit(VolumeConversion.volumeConversion, fromUnit) == -1)
				{
					if(FindFromUnit(temperatureConversion, fromUnit) == -1)
					{
						System.out.println("Sorry, your selection is not listed.\nPlease try again.");
						fromUnit = input.nextLine();
					}
					else
					{
						conversionType = temperatureConversion;
						selection = 1;
					}
				}
				else
				{
					conversionType = VolumeConversion.volumeConversion;
					selection = 2;
				}
			}
			else
			{
				conversionType = WeightConversion.weightConversion;
				selection = 3;
			}
		}
		else
		{
			conversionType = LengthConversion.lengthConversion;
			selection = 4;
		}

		System.out.println("Convert to: ");
		String toUnit = input.nextLine();

		if(FindToUnit(conversionType, toUnit) == -1)
		{
			System.out.println("Sorry, your second selection is not listed within the same group as your first.\nPlease try again.");
			toUnit = input.nextLine();
		}

		System.out.print("value = ");
		double value = input.nextDouble();

		// have to make a method to find out which type of conversion is going to take place
		switch(selection)
		{
		case 4:
		{
			LengthConversion result = new LengthConversion(fromUnit, toUnit, value);
			System.out.printf("%s", result.toString());
			break;
		}
		case 3:
		{
			WeightConversion result = new WeightConversion(fromUnit, toUnit, value);
			System.out.printf("%s", result.toString());
			break;
		}
		case 2:
		{
			VolumeConversion result = new VolumeConversion(fromUnit, toUnit, value);
			System.out.printf("%s", result.toString());
			break;
		}
		case 1:
		{
			if(FindFromUnit(temperatureConversion, fromUnit) == 0)
			{
				//then method to celsius
				valuenow = CelsiusFahrenheit(value);
			}
			else
			{
				// then method fahrenheit
				valuenow = FahrenheitCelsius(value);
			}
			//then to method fahrenheit
			System.out.println("Version 1");
				System.out.printf("The question is: You want to convert %.02f %s to %s."
						+ "%nThe answer is: %.02f %s is equal to %.02f %s%n", value, fromUnit, toUnit, value, fromUnit,
						valuenow, toUnit );
				System.out.println("Version 2");
				System.out.printf("You want to convert %.02f %s(%s) to %s(%s)."
						+ "%nThe answer is: %.02f(%s) = %s%n", value, fromUnit,
						FindSymbolFromUnit(temperatureConversion, fromUnit), toUnit, FindSymbolToUnit(temperatureConversion, toUnit),
						value, FindSymbolFromUnit(temperatureConversion, fromUnit), valuenow, FindSymbolToUnit(temperatureConversion, toUnit) );
				System.out.println();
			break;
		}
		default:
		{
			System.out.println();
		}
		} // end switch

	} // end method main

	public static int FindFromUnit(String[] array, String fromUnit)
	{
		for(int i = 0; i <= array.length -1; i++)
		{
			if(fromUnit.contains(array[i]))
			{
				return i;
			}
		}
		return -1;
	}

	public static int FindToUnit(String [] conversionType, String toUnit)
	{
		for(int i = 0; i <= conversionType.length -1; i++)
		{
			if(toUnit.contains(conversionType[i]))
			{
				return i;
			}
		}
		return -1;
	}

	// used solely for the temperature model
	public static String FindSymbolFromUnit(String[] temperatureConversion, String fromUnit)
	{
		if(FindFromUnit(temperatureConversion, fromUnit) != -1)
		{
			temperatureSymbol = temperatureSymbols[FindFromUnit(temperatureConversion, fromUnit)];
		}
			return temperatureSymbol;
	}
	public static String FindSymbolToUnit(String[] temperatureConversion, String toUnit)
	{
		if(FindToUnit(temperatureConversion, toUnit) != -1)
		{
			temperatureSymbol = temperatureSymbols[FindToUnit(temperatureConversion, toUnit)];
		}
		return temperatureSymbol;
	}
	
	// taken from https://stackoverflow.com/questions/52187264/java-multiple-arrays
	//System.out.printf("Convert from is located in %s", fromUnit, LengthConversion.lengthConversion, WeightConversion.weightConversion, VolumeConversion.volumeConversion, temperatureConversion);
	// this only identifies if it finds the string not identify which array it belongs to.
//	public static String FindFromUnit(String fromUnit, String[]... arrays)
//	{
//		System.out.println("");
//		for(String[] array : arrays)
//		{
//			if(Arrays.asList(array).contains(fromUnit))
//				{
//				return array[0];
//				}
//		}
//		return "";
//	}

//	//a method to convert kilometers per hour to miles per hour.
//	public double kphtomph(double kph)
//	{
//		double mph;
//		mph = (kph*1.609344);
//		return mph;
//	}
//	//a method to convert miles per hour to kilometers per hour.
//	public double mphtokph(double mph)
//	{
//		double kmph;
//		kmph = (mph*0.621371192);
//		return kmph;
//	}
	
	// Temperature Conversions 
	public static double CelsiusFahrenheit (double celsius)
	{
		return (celsius * (9 / 5) ) + 32;
	}
	public static double FahrenheitCelsius (double fahrenheit)
	{
		return ((fahrenheit - 32) * (5 / 9) );
	}

//	//a method to convert the standard measure of power (horsepower) to the metric measure of power (kilowatts).
//	public double horsepowertokilowatts(double hp)
//	{
//		double kw;
//		kw = (hp * 0.745699872);
//		return kw;
//	}
//	//a method to convert the metric measure of power(kilowatts) to the standard measure of power(horsepower).
//	public double kilowattstohorsepower(double kw)
//	{
//		double hp;
//		hp = (kw * 1.34102209);
//		return hp;
//	}

} // end class MetricConversion
