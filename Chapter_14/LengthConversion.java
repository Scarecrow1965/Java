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

public class LengthConversion
{
	// Initializing variables
	protected static double factor; // this will be used for all formulas
	public static double value; // this will be used for all formulas
	protected static double result = 0; // this will be used for all formulas
	protected static String lengthSymbol;
	public static String toUnit = "";
	public static String fromUnit = "";

	// protected static final String[] lengthStandard = {"inches", "feet", "yards", "miles", "nautical_miles"};
	// protected static final String[] lengthMetric = {"millimeters", "centimeters", "meters", "kilometers"};
	protected static final String[] lengthConversion = {"millimeters", "centimeters", "meters", "kilometers", "inches", "feet", "yards", "miles", "nautical_miles"};
	// lengthConversion[0] = millimeters	lengthConversion[1] = centimeters
	// lengthConversion[2] = meters			lengthConversion[3] = kilometers
	// lengthConversion[4] = inches			lengthConversion[5] = feet
	// lengthConversion[6] = yards			lengthConversion[7] = miles
	// lengthConversion[8] = nautical_miles
	protected static final String[] lengthSymbols = {"mm", "cm", "m", "km", "in", "ft", "yd", "mi", "nm"};
	// Metric Conversion
	private static final double mmtom = 0.001; // millimeters to meters
	private static final double cmtom = 0.01; // centimeters to meters
	private static final double kmtom = 1000; // kilometers to meters
	// millimetres to inches IAW https://www.mathsisfun.com/metric-imperial-conversion-charts.html#length
	private static final double mmtoin = 0.03937; // millimeters to inches
	// millimeters to feet IAW https://www.mathsisfun.com/metric-imperial-conversion-charts.html#length
	// private final double mmtoft = mmtoin / 12;
	// centimeters to inches IAW https://www.mathsisfun.com/metric-imperial-conversion-charts.html#length 
	protected static final double cmtoin = 0.3937;
	// meters to feet IAW https://www.mathsisfun.com/metric-imperial-conversion-charts.html#length
	protected static final double mtomi = .00062137; // meters to miles
	protected static final double mtoft = 3.2808; // meters to feet
	protected static final double mtoin = mtoft * 12; // meters to inches
	protected static final double cmtoft = mtoft * kmtom; // centimeters to feet
	// meter to yard IAW https://www.mathsisfun.com/metric-imperial-conversion-charts.html#length
	protected static final double mtoyd = 1.0936;
	// kilometers to miles IAW https://www.mathsisfun.com/metric-imperial-conversion-charts.html#length
	protected static final double kmtoft = 3280.83;
	protected static final double kmtomi = 0.6214;
	// private final double kmtonm = 1.852; // kilometers to nautical_miles // repeat of nmtokm variable

	// Standard Conversion
	protected static final double intomm = 25.4;// inches to millimeters
	// inches to centimeters IAW https://www.mathsisfun.com/metric-imperial-conversion-charts.html#length
	protected static final double intocm = 2.54;
	protected static final double intom = intocm * cmtom; //inches to meters IAW https://www.instructables.com/How-to-Create-a-Java-Unit-Converter/
	// feet to meters IAW https://www.mathsisfun.com/metric-imperial-conversion-charts.html#length
	protected static final double fttom = 0.3048;
	protected static final double fttocm = fttom / cmtom; // feet to centimeters
	// yards to meters IAW https://www.mathsisfun.com/metric-imperial-conversion-charts.html#length
	protected static final double ydtom = 0.9144;
	protected static final double ydtokm = ydtom / kmtom;
	// miles to kilometers IAW https://www.mathsisfun.com/metric-imperial-conversion-charts.html#length
	protected static final double mitokm = 1.6093;
	// nautical_miles to kilometers IAW https://www.mathsisfun.com/metric-imperial-conversion-charts.html#length
	protected static final double mitom = 1609.344; // miles to meters IAW https://www.instructables.com/How-to-Create-a-Java-Unit-Converter/
	protected static final double nmtokm = 1.852;

	public LengthConversion(String from, String to, double val)
	{
		this.fromUnit = from.toLowerCase(); // need to do a method to find out what the String belongs to what array
		this.toUnit = to.toLowerCase(); // need to do a method to confirm the other String is correct
		this.value = val;
	}

	public static int FindFromUnit(String[] lengthConversion, String fromUnit)
	{
		for(int i = 0; i <= lengthConversion.length -1; i++)
		{
			if(fromUnit.contains(lengthConversion[i]))
			{
				return i;
			}
		}
		return -1;
	}
	
	public static int FindToUnit(String[] lengthConversion, String toUnit)
	{
		for(int i = 0; i <= lengthConversion.length -1; i++)
		{
			if(toUnit.contains(lengthConversion[i]) )
			{
				return i;
			}
		}
		return -1;
	}

	public static String FindSymbolFromUnit(String[] lengthConversion, String fromUnit)
	{
		if(FindFromUnit(lengthConversion, fromUnit) != -1)
		{
			lengthSymbol = lengthSymbols[FindFromUnit(lengthConversion, fromUnit)];
		}
			return lengthSymbol;
	}
	public static String FindSymbolToUnit(String[] lengthConversion, String toUnit)
	{
		if(FindToUnit(lengthConversion, toUnit) != -1)
		{
			lengthSymbol = lengthSymbols[FindToUnit(lengthConversion, toUnit)];
		}
		return lengthSymbol;
	}
	
	public static double LengthConverter(String[] lengthConversion, String fromUnit, String toUnit, double value)
	{
		// lengthConversion[0] = millimeters	lengthConversion[1] = centimeters
		// lengthConversion[2] = meters			lengthConversion[3] = kilometers
		// lengthConversion[4] = inches			lengthConversion[5] = feet
		// lengthConversion[6] = yards			lengthConversion[7] = miles
		// lengthConversion[8] = nautical_miles

		if(fromUnit.contains(lengthConversion[4]) && toUnit.contains(lengthConversion[0]) )
		{
			factor = intomm;
			result = factor * value;
		}
		else if(fromUnit.contains(lengthConversion[4]) && toUnit.contains(lengthConversion[1]) )
		{
			factor = intocm;
			result = factor * value;
		}
		else if(fromUnit.contains(lengthConversion[4]) && toUnit.contains(lengthConversion[2]) )
		{
			factor = intom;
			result = factor * value;
		}
		else if (fromUnit.contains(lengthConversion[5]) && toUnit.contains(lengthConversion[1]) )
		{
			factor = fttocm;
			result = factor * value;
		}
		else if (fromUnit.contains(lengthConversion[5]) && toUnit.contains(lengthConversion[2]) )
		{
			factor = fttom;
			result = factor * value;
		}
		else if(fromUnit.contains(lengthConversion[6]) && toUnit.contains(lengthConversion[2]) )
		{
			factor = ydtom;
			result = factor * value;
		}
		else if(fromUnit.contains(lengthConversion[6]) && toUnit.contains(lengthConversion[3]) )
		{
			factor = ydtokm;
			result = factor * value;
		}
		else if(fromUnit.contains(lengthConversion[7]) && toUnit.contains(lengthConversion[2]) )
		{
			factor = mitom;
			result = factor * value;
		}
		else if(fromUnit.contains(lengthConversion[7]) && toUnit.contains(lengthConversion[3]) )
		{
			factor = mitokm;
			result = factor * value;
		}
		else if(fromUnit.contains(lengthConversion[8]) && toUnit.contains(lengthConversion[3]) )
		{
			factor = nmtokm;
			result = factor * value;
		}
		else if(fromUnit.contains(lengthConversion[0]) && toUnit.contains(lengthConversion[4]) )
		{
			factor = mmtoin;
			result = factor * value;
		}
		else if(fromUnit.contains(lengthConversion[0]) && toUnit.contains(lengthConversion[5]) )
		{ // millimeters to feet
			factor = mmtoin;
			result = (factor * value) / 12;
		}
		else if(fromUnit.contains(lengthConversion[1]) && toUnit.contains(lengthConversion[4]) )
		{
			factor = cmtoin;
			result = factor * value;
		}
		else if(fromUnit.contains(lengthConversion[1]) && toUnit.contains(lengthConversion[5]) )
		{
			factor = cmtoft;
			result = factor * value;
		}
		else if(fromUnit.contains(lengthConversion[2]) && toUnit.contains(lengthConversion[4]) )
		{
			factor = mtoin;
			result = factor * value;
		}
		else if(fromUnit.contains(lengthConversion[2]) && toUnit.contains(lengthConversion[5]) )
		{
			factor = mtoft;
			result = factor * value;
		}
		else if(fromUnit.contains(lengthConversion[2]) && toUnit.contains(lengthConversion[6]) )
		{
			factor = mtoyd;
			result = factor * value;
		}
		else if(fromUnit.contains(lengthConversion[2]) && toUnit.contains(lengthConversion[7]) )
		{
			factor = mtomi;
			result = factor * value;
		}
		else if(fromUnit.contains(lengthConversion[3]) && toUnit.contains(lengthConversion[5]) )
		{
			factor = kmtoft;
			result = factor * value;
		}
		else if(fromUnit.contains(lengthConversion[3]) && toUnit.contains(lengthConversion[7]) )
		{
			factor = kmtomi;
			result = factor * value;
		}
		else if(fromUnit.contains(lengthConversion[3]) && toUnit.contains(lengthConversion[8]) )
		{ // kilometers to nautical_miles
			factor = kmtomi;
			result = value / factor;
		}
		return result;
	} // end method LengthConverter

//	public static void main(String[] args)
//	{
//		// create a Scanner to obtain input from the command window
//		Scanner input = new Scanner(System.in);
//		
//		System.out.println("This application will carry out mostly-used length conversions of metric to US standard and vice versa.");
//		System.out.println("Your word options are:");
//		for(int i = 0 ; i <= lengthConversion.length - 1; i++)
//		System.out.print(lengthConversion[i]+ ", ");
//		System.out.println();
//
//		System.out.println("Convert from: ");
//		String fromUnit = input.nextLine();
//		if(FindFromUnit(lengthConversion, fromUnit) == -1)
//		{
//			System.out.println("You have entered a wrong term.\nPlease try again.");
//			fromUnit = input.nextLine();
//		}
//
//		System.out.println("Convert to: ");
//		String toUnit = input.nextLine();
//		if(FindFromUnit(lengthConversion, toUnit) == -1)
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
//				+ "%nThe answer is: %.02f %s is equal to %.02f %s%n", value, fromUnit, toUnit, value, fromUnit,
//				LengthConverter(lengthConversion, fromUnit, toUnit, value), toUnit );
//		System.out.println("Version 2");
//		System.out.printf("You want to convert %.02f %s(%s) to %s(%s)."
//				+ "%nThe answer is: %.02f %s = %.02f %s%n", value, fromUnit,
//				FindSymbolFromUnit(lengthConversion, fromUnit), toUnit, FindSymbolToUnit(lengthConversion, toUnit),
//				value, FindSymbolFromUnit(lengthConversion, fromUnit), LengthConverter(lengthConversion, fromUnit, toUnit, value),
//				FindSymbolToUnit(lengthConversion, toUnit) );
//	} // end method main

	public String toString()
	{
		return String.format("You want to convert %.02f %s(%s) to %s(%s)."
				+ "%nThe answer is: %.02f %s = %.02f %s%n", value, fromUnit,
				FindSymbolFromUnit(lengthConversion, fromUnit), toUnit, FindSymbolToUnit(lengthConversion, toUnit),
				value, FindSymbolFromUnit(lengthConversion, fromUnit), LengthConverter(lengthConversion, fromUnit, toUnit, value),
				FindSymbolToUnit(lengthConversion, toUnit) );
	}
//	//a method to convert kilometers to miles.
//	public double kmtomi(double km)
//	{
//		double mi;
//		mi = (km * 0.621371192);
//		return mi;
//	}
//	//a method to convert miles to kilometers. 
//	public double mitokm(double mi)
//	{
//		double km;
//		km = (mi * 1.609344);
//		return km;
//	}
//	//a method to convert feet to meters.
//	public double fttom(double ft)
//	{
//		double m;
//		m = (ft * 0.3048);
//		return m;
//	}
//	// a method to convert meters to feet.
//	public double mtoft(double m)
//	{
//		double ft;
//		ft = (m * 3.2808399);
//		return ft;
//	}
//	//a method to convert milimeters to inches.
//	public double mmtoin(double mm)
//	{
//		double in;
//		in = (mm * 0.03937);
//		return in;
//	}
//	//a method to convert inches to milimeters.
//	public double intomm(double in)
//	{
//		double mm;
//		mm = (in * 25.4);
//		return mm;
//	}
//	//a method to convert centimeters to inches.
//	public double cmtoin(double cm)
//	{
//		double in;
//		in = (cm * 0.3937);
//		return in;
//	}
//	//a method to convert inches to centimeters.
//	public double intocm(double in)
//	{
//		double cm;
//		cm = (in * 2.54);
//		return cm;
//	}
	
	// from http://freesourcecode.net/javaprojects/73852/Metric-imperial-converter-in-java#.YmAm_tPMKHs
//	public class objConvert
//	{
//		//The String arrays store all the supported conversions. If you add/remove items in the array make sure you
//		//change the double arrays with the conversions, as the programme uses the String array indexes to corrospond
//		//with the double array indexes.
//		//These string arrays store the symbols to be used with the answers. Keep them in the same order as the menu String arrays
//		private final String[] strTemperatureMenu = {"Centigrade","Fahrenheit"};
//		private final String[] strTemperatureSymbol = {"*C","*F"};
//
//		//Conversion tables, make sure you keep them in the same order as the labels in the String arrays
//		//They are named as <type><unit> e.g. distanceMM means you are converting FROM Millimetres into....
//		//Distance table
//		private final String[] strDistanceMenu = {"Millimetre","Centimetre","Metre","Kilometre","Inch","Foot","Yard","Mile"};
//		private final String[] strDistanceSymbol = {"mm","cm","m","km","in","ft","yd","m"};
//		private final double[] distanceMM = {1.0, 0.1, 0.001, 0.000001, 0.03937, 0.003281, 0.001094, 0.00000062};
//		private final double[] distanceCM = {10.0, 1.0, 0.01, 0.00001, 0.3937, 0.0328, 0.01093, 0.0000062};
//		private final double[] distanceM = {1000.0, 100.0, 1.0, 0.001, 39.37, 3.28, 1.093, 0.00062};
//		private final double[] distanceKM = {1000000.0, 100000.0, 1000.0, 1.0, 39370.0, 3280.0, 1093.0, 0.6213};
//		private final double[] distanceInch = {25.4, 2.54, 0.0254, 0.0000254, 1.0, 0.083, 0.027, 0.0000157};
//		private final double[] distanceFoot = {304.8, 30.48, 0.3048, 0.0003048, 12.0, 1.0, 0.33, 0.000189};
//		private final double[] distanceYard = {914.4, 91.44, 0.9144, 0.0009144, 36.0, 3.0, 1.0, 0.000568};
//		private final double[] distanceMile = {1609344.0, 160934.4, 1609.344, 1.609344, 63360.0, 5280.0, 1760.0, 1.0};
//		private final double[][] distanceTable = {distanceMM, distanceCM, distanceM, distanceKM, distanceInch, distanceFoot, distanceYard, distanceMile};
//
//		//Weight table
//		private final String[] strWeightMenu = {"Milligram","Gram","Kilogram","Ounce","Pound","Stone"};
//		private final String[] strWeightSymbol = {"mg","g","kg","oz","lb","st"};
//		private final double[] weightMG = {1.0, 0.001, 0.000001, 0.00003527, 0.000002205, 0.0000001575};
//		private final double[] weightG = {1000.0, 1.0, 0.001, 0.03527, 0.002205, 0.0001575};
//		private final double[] weightKG = {1000000.0, 1000.0, 1.0, 35.27, 2.205, 0.1575};
//		private final double[] weightOunce = {28350.0, 28.35, 0.02835, 1.0, 0.0625, 0.004464};
//		private final double[] weightPound = {453600.0, 453.6, 0.4536, 16.0, 1.0, 0.07143};
//		private final double[] weightStone = {6350000.0, 6350.0, 6.35, 224.0, 14.0, 1.0};
//		private final double[][] weightTable = {weightMG, weightG, weightKG, weightOunce, weightPound, weightStone};
//
//		//Volume table
//		private final String[] strVolumeMenu = {"Millilitre","Centilitre","Litre","Fluid Ounce","Pint","Gallon"};
//		private final String[] strVolumeSymbol = {"ml","cl","l","Foz","p","g"};
//		private final double[] volumeML = {1.0, 0.1, 0.001, 0.03381, 0.002113, 0.0003642};
//		private final double[] volumeCL = {10.0, 1.0, 0.01, 0.3381, 0.02113, 0.002642};
//		private final double[] volumeLitre = {1000.0, 100.0, 1.0, 33.81, 2.113, 0.2642};
//		private final double[] volumeOunce = {29.57, 2.957, 0.02957, 1.0, 0.0625, 0.007813};
//		private final double[] volumePint = {473.2, 47.32, 0.4732, 16.0, 1.0, 0.125};
//		private final double[] volumeGallon = {3785.0, 378.5, 3.785, 128, 8, 1.0};
//		private final double[][] volumeTable = {volumeML, volumeCL, volumeLitre, volumeOunce, volumePint, volumeGallon};
//
//		public objConvert()
//		{
//		}
//
//		private String convert(double conversionRate, double unit)
//		{
//			return "Answer: " + (conversionRate * unit);
//		}
//
//		public String convertDistance(int sourceIndex, int desIndex, double unit)
//		{
//			//Sends the cell reference of the 2D array to the convert method (same for distance, weight and volume)
//			//Adds the symbol to the end of the answer
//			return "" + convert(distanceTable[sourceIndex][desIndex], unit) + strDistanceSymbol[desIndex];
//		}
//
//		public String convertWeight(int sourceIndex, int desIndex, double unit)
//		{		
//			return "" + convert(weightTable[sourceIndex][desIndex], unit) + strWeightSymbol[desIndex];
//		}
//
//		public String convertVolume(int sourceIndex, int desIndex, double unit)
//		{		
//			return "" + convert(volumeTable[sourceIndex][desIndex], unit) + strVolumeSymbol[desIndex];
//		}
//
//		public String convertTemperature(int sourceIndex, int desIndex, double unit)
//		{
//			double answer = 0.0;
//			if (sourceIndex == desIndex)
//			{
//				answer = unit;
//			}
//			else if (sourceIndex == 0)
//			{
//				answer = unit * 9/5 + 32;
//			}
//			else
//			{
//				answer = (unit - 32) * 5/9;
//			}
//			return "Answer: " + answer + strTemperatureSymbol[desIndex];
//		}
//
//		public String[] getDistanceMenu()
//		{
//			return strDistanceMenu;
//		}
//
//		public String[] getWeightMenu()
//		{
//			return strWeightMenu;
//		}
//
//		public String[] getVolumeMenu()
//		{
//			return strVolumeMenu;
//		}
//
//		public String[] getTemperatureMenu()
//		{
//			return strTemperatureMenu;
//		}
//
//	}

} // end class LengthConversion
