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

import java.util.Scanner;

public class WeightConversion
{
	// Initializing variables
	public static double value; // this will be used for all formulas
	protected static String weightSymbol;
	public static String toUnit = "";
	public static String fromUnit = "";

	//Weight table
	protected static final String[] weightConversion = {"milligram","gram","kilogram","ounce","pound","stone"};
	protected static final String[] weightSymbols = {"mg","g","kg","oz","lb","st"};
	private static final double[] weightMG = {1.0, 0.001, 0.000001, 0.00003527, 0.000002205, 0.0000001575};
	private static final double[] weightG = {1000.0, 1.0, 0.001, 0.03527, 0.002205, 0.0001575};
	private static final double[] weightKG = {1000000.0, 1000.0, 1.0, 35.27, 2.205, 0.1575};
	private static final double[] weightOunce = {28350.0, 28.35, 0.02835, 1.0, 0.0625, 0.004464};
	private static final double[] weightPound = {453600.0, 453.6, 0.4536, 16.0, 1.0, 0.07143};
	private static final double[] weightStone = {6350000.0, 6350.0, 6.35, 224.0, 14.0, 1.0};
	private static final double[][] weightTable = {weightMG, weightG, weightKG, weightOunce, weightPound, weightStone};

	public WeightConversion(String from, String to, double val)
	{
		this.fromUnit = from.toLowerCase(); // need to do a method to find out what the String belongs to what array
		this.toUnit = to.toLowerCase(); // need to do a method to confirm the other String is correct
		this.value = val;
	}

	public static int FindFromUnit(String[] weightConversion, String fromUnit)
	{
		for(int i = 0; i <= weightConversion.length -1; i++)
		{
			if(fromUnit.contains(weightConversion[i]))
			{
				return i;
			}
		}
		return -1;
	}
	
	public static int FindToUnit(String[] weightConversion, String toUnit)
	{
		for(int i = 0; i <= weightConversion.length -1; i++)
		{
			if(toUnit.contains(weightConversion[i]) )
			{
				return i;
			}
		}
		return -1;
	}

	public static String FindSymbolFromUnit(String[] weightConversion, String fromUnit)
	{
		if(FindFromUnit(weightConversion, fromUnit) != -1)
		{
			weightSymbol = weightSymbols[FindFromUnit(weightConversion, fromUnit)];
		}
			return weightSymbol;
	}
	public static String FindSymbolToUnit(String[] weightConversion, String toUnit)
	{
		if(FindToUnit(weightConversion, toUnit) != -1)
		{
			weightSymbol = weightSymbols[FindToUnit(weightConversion, toUnit)];
		}
		return weightSymbol;
	}
	
	public static String convert(double conversionRate, double value)
	{
		double total = conversionRate * value;
		return String.format("%.02f", total);
		// return "" + (conversionRate * value);
	}

	public static String convertWeight(String[] weightConversion, String fromUnit, String toUnit, double value)
	{		
		return "" + convert(weightTable[FindFromUnit(weightConversion, fromUnit)][FindToUnit(weightConversion, toUnit)],
				value) + FindSymbolToUnit(weightConversion, toUnit);
	}

//	public static void main(String[] args)
//	{
//		// create a Scanner to obtain input from the command window
//		Scanner input = new Scanner(System.in);
//		
//		System.out.println("This application will carry out mostly-used weight conversions of metric to US standard and vice versa.");
//		System.out.println("Your word options are:");
//		for(int i = 0 ; i <= weightConversion.length - 1; i++)
//		System.out.print(weightConversion[i]+ ", ");
//		System.out.println();
//
//		System.out.println("Convert from: ");
//		String fromUnit = input.nextLine();
//		if(FindFromUnit(weightConversion, fromUnit) == -1)
//		{
//			System.out.println("You have entered a wrong term.\nPlease try again.");
//			fromUnit = input.nextLine();
//		}
//
//		System.out.println("Convert to: ");
//		String toUnit = input.nextLine();
//		if(FindFromUnit(weightConversion, toUnit) == -1)
//		{
//			System.out.println("You have entered a wrong term.\nPlease try again.");
//			toUnit = input.nextLine();
//		}
//		System.out.println("Value = ");
//		double value = input.nextDouble();
//		if(value < 0 || value >= 100000)
//		{
//			System.out.println("The value you have entered cannot be less that 0 (zero) or more than 100,000."
//					+ "\nPlease try again.");
//			value = input.nextDouble();
//		}
//		
//		System.out.println("Version 1");
//		System.out.printf("The question is: You want to convert %.02f %s to %s."
//				+ "%nThe answer is: %.02f %s is equal to %s%n", value, fromUnit, toUnit, value, fromUnit,
//				convertWeight(weightConversion, fromUnit, toUnit, value) );
//		System.out.println("Version 2");
//		System.out.printf("You want to convert %.02f %s(%s) to %s(%s)."
//				+ "%nThe answer is: %.02f %s = %s%n", value, fromUnit,
//				FindSymbolFromUnit(weightConversion, fromUnit), toUnit, FindSymbolToUnit(weightConversion, toUnit),
//				value, FindSymbolFromUnit(weightConversion, fromUnit), convertWeight(weightConversion, fromUnit, toUnit, value) );
//	} // end method main

	public String toString()
	{
		return String.format("You want to convert %.02f %s(%s) to %s(%s)."
				+ "%nThe answer is: %.02f %s = %s%n", value, fromUnit,
				FindSymbolFromUnit(weightConversion, fromUnit), toUnit, FindSymbolToUnit(weightConversion, toUnit),
				value, FindSymbolFromUnit(weightConversion, fromUnit), convertWeight(weightConversion, fromUnit, toUnit, value) );
	}

//	//a method to convert liters to gallons.
//	public double litertogallon(double lt)
//	{
//		double gal;
//		gal =(lt * 3.7854118);
//		return gal;
//	}
//	//a method to convert gallons to liters.
//	public double gallontoliter(double gal)
//	{
//		double lt;
//		lt =(gal * 0.264172051);
//		return lt;
//	}
//
//	//a method to convert U.S. pounds to metric kilograms.
//	public double poundtokilogram(double lbs)
//	{
//		double kg;
//		kg = (lbs * 2.20462262);
//		return kg;
//	}
//	//a method to convert metric kilograms to U.S. pounds.
//	public double kilogramtopound(double kg)
//	{
//		double lbs;
//		lbs =(kg * 0.45359237);
//		return lbs;
//	}
	
	// original info
//	//Weight table
//	private final String[] strWeightMenu = {"Milligram","Gram","Kilogram","Ounce","Pound","Stone"};
//	private final String[] strWeightSymbol = {"mg","g","kg","oz","lb","st"};
//	private final double[] weightMG = {1.0, 0.001, 0.000001, 0.00003527, 0.000002205, 0.0000001575};
//	private final double[] weightG = {1000.0, 1.0, 0.001, 0.03527, 0.002205, 0.0001575};
//	private final double[] weightKG = {1000000.0, 1000.0, 1.0, 35.27, 2.205, 0.1575};
//	private final double[] weightOunce = {28350.0, 28.35, 0.02835, 1.0, 0.0625, 0.004464};
//	private final double[] weightPound = {453600.0, 453.6, 0.4536, 16.0, 1.0, 0.07143};
//	private final double[] weightStone = {6350000.0, 6350.0, 6.35, 224.0, 14.0, 1.0};
//	private final double[][] weightTable = {weightMG, weightG, weightKG, weightOunce, weightPound, weightStone};
//
//	private String convert(double conversionRate, double unit)
//	{
//		return "Answer: " + (conversionRate * unit);
//	}
//
//	public String convertWeight(int sourceIndex, int desIndex, double unit)
//	{		
//		return "" + convert(weightTable[sourceIndex][desIndex], unit) + strWeightSymbol[desIndex];
//	}

} // end class WeightConversion
