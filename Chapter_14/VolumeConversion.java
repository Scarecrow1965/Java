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

public class VolumeConversion
{
	//initializing variables
	public static double value; // this will be used for all formulas
	protected static String volumeSymbol;
	public static String toUnit = "";
	public static String fromUnit = "";

	// Volume table
	protected static final String[] volumeConversion = {"millilitre","centilitre","litre","fluid_ounce","pint","gallon"};
	protected static final String[] volumeSymbols = {"ml","cl","l","F_oz","p","g"};
	private static final double[] volumeML = {1.0, 0.1, 0.001, 0.03381, 0.002113, 0.0003642};
	private static final double[] volumeCL = {10.0, 1.0, 0.01, 0.3381, 0.02113, 0.002642};
	private static final double[] volumeLitre = {1000.0, 100.0, 1.0, 33.81, 2.113, 0.2642};
	private static final double[] volumeOunce = {29.57, 2.957, 0.02957, 1.0, 0.0625, 0.007813};
	private static final double[] volumePint = {473.2, 47.32, 0.4732, 16.0, 1.0, 0.125};
	private static final double[] volumeGallon = {3785.0, 378.5, 3.785, 128, 8, 1.0};
	private static final double[][] volumeTable = {volumeML, volumeCL, volumeLitre, volumeOunce, volumePint, volumeGallon};

	public VolumeConversion(String from, String to, double val)
	{
		this.fromUnit = from.toLowerCase(); // need to do a method to find out what the String belongs to what array
		this.toUnit = to.toLowerCase(); // need to do a method to confirm the other String is correct
		this.value = val;
	}

	public static int FindFromUnit(String[] volumeConversion, String fromUnit)
	{
		for(int i = 0; i <= volumeConversion.length -1; i++)
		{
			if(fromUnit.contains(volumeConversion[i]))
			{
				return i;
			}
		}
		return -1;
	}
	
	public static int FindToUnit(String[] volumeConversion, String toUnit)
	{
		for(int i = 0; i <= volumeConversion.length -1; i++)
		{
			if(toUnit.contains(volumeConversion[i]) )
			{
				return i;
			}
		}
		return -1;
	}

	public static String FindSymbolFromUnit(String[] volumeConversion, String fromUnit)
	{
		if(FindFromUnit(volumeConversion, fromUnit) != -1)
		{
			volumeSymbol = volumeSymbols[FindFromUnit(volumeConversion, fromUnit)];
		}
			return volumeSymbol;
	}
	public static String FindSymbolToUnit(String[] volumeConversion, String toUnit)
	{
		if(FindToUnit(volumeConversion, toUnit) != -1)
		{
			volumeSymbol = volumeSymbols[FindToUnit(volumeConversion, toUnit)];
		}
		return volumeSymbol;
	}
	
	public static String convert(double conversionRate, double value)
	{
		double total = conversionRate * value;
		return String.format("%.02f", total);
		// return "" + (conversionRate * value);
	}

	public static String convertVolume(String[] volumeConversion, String fromUnit, String toUnit, double value)
	{		
		return "" + convert(volumeTable[FindFromUnit(volumeConversion, fromUnit)][FindToUnit(volumeConversion, toUnit)],
				value) + "(" + FindSymbolToUnit(volumeConversion, toUnit) + ").";
	}

//	public static void main(String[] args)
//	{
//		// create a Scanner to obtain input from the command window
//		Scanner input = new Scanner(System.in);
//		
//		System.out.println("This application will carry out mostly-used volume conversions of metric to US standard and vice versa.");
//		System.out.println("Your word options are:");
//		for(int i = 0 ; i <= volumeConversion.length - 1; i++)
//		System.out.print(volumeConversion[i]+ ", ");
//		System.out.println();
//
//		System.out.println("Convert from: ");
//		String fromUnit = input.nextLine();
//		if(FindFromUnit(volumeConversion, fromUnit) == -1)
//		{
//			System.out.println("You have entered a wrong term.\nPlease try again.");
//			fromUnit = input.nextLine();
//		}
//
//		System.out.println("Convert to: ");
//		String toUnit = input.nextLine();
//		if(FindFromUnit(volumeConversion, toUnit) == -1)
//		{
//			System.out.println("You have entered a wrong term.\nPlease try again.");
//			toUnit = input.nextLine();
//		}
//		System.out.println("Value = ");
//		double value = input.nextDouble();
//		if(value < 0 || value >= 100000)
//		{
//			System.out.println("The value you have entered cannot be less that 0 (zero) or more than 100,000.\nPlease try again.");
//			value = input.nextDouble();
//		}
//		
//		System.out.println("Version 1");
//		System.out.printf("The question is: You want to convert %.02f %s to %s."
//				+ "%nThe answer is: %.02f %s is equal to %s%n", value, fromUnit, toUnit, value, fromUnit,
//				convertVolume(volumeConversion, fromUnit, toUnit, value) );
//		System.out.println("Version 2");
//		System.out.printf("You want to convert %.02f %s(%s) to %s(%s)."
//				+ "%nThe answer is: %.02f(%s) = %s%n", value, fromUnit,
//				FindSymbolFromUnit(volumeConversion, fromUnit), toUnit, FindSymbolToUnit(volumeConversion, toUnit),
//				value, FindSymbolFromUnit(volumeConversion, fromUnit), convertVolume(volumeConversion, fromUnit, toUnit, value) );
//		} // end method main

	public String toString()
	{
		return String.format("You want to convert %.02f %s(%s) to %s(%s)."
				+ "%nThe answer is: %.02f(%s) = %s%n", value, fromUnit,
				FindSymbolFromUnit(volumeConversion, fromUnit), toUnit, FindSymbolToUnit(volumeConversion, toUnit),
				value, FindSymbolFromUnit(volumeConversion, fromUnit), convertVolume(volumeConversion, fromUnit, toUnit, value) );
	}
	
	// Original lines
//	//Volume table
//	private final String[] strVolumeMenu = {"Millilitre","Centilitre","Litre","Fluid Ounce","Pint","Gallon"};
//	private final String[] strVolumeSymbol = {"ml","cl","l","Foz","p","g"};
//	private final double[] volumeML = {1.0, 0.1, 0.001, 0.03381, 0.002113, 0.0003642};
//	private final double[] volumeCL = {10.0, 1.0, 0.01, 0.3381, 0.02113, 0.002642};
//	private final double[] volumeLitre = {1000.0, 100.0, 1.0, 33.81, 2.113, 0.2642};
//	private final double[] volumeOunce = {29.57, 2.957, 0.02957, 1.0, 0.0625, 0.007813};
//	private final double[] volumePint = {473.2, 47.32, 0.4732, 16.0, 1.0, 0.125};
//	private final double[] volumeGallon = {3785.0, 378.5, 3.785, 128, 8, 1.0};
//	private final double[][] volumeTable = {volumeML, volumeCL, volumeLitre, volumeOunce, volumePint, volumeGallon};
//
//	private String convert(double conversionRate, double unit)
//	{
//		return "Answer: " + (conversionRate * unit);
//	}
//
//	public String convertVolume(int sourceIndex, int desIndex, double unit)
//	{		
//		return "" + convert(volumeTable[sourceIndex][desIndex], unit) + strVolumeSymbol[desIndex];
//	}

} // end class VolumeConversion
