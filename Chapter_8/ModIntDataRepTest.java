
public class ModIntDataRepTest
{

	public static void main(String[] args)
	{
		ModIntDataRep t1 = new ModIntDataRep(); // 00:00:00
		ModIntDataRep t2 = new ModIntDataRep(2); // 02:00:00
		ModIntDataRep t3 = new ModIntDataRep(21, 34); // 21:34:00
		ModIntDataRep t4 = new ModIntDataRep(12, 25, 42); // 12:25:42
		ModIntDataRep t5 = new ModIntDataRep(t4); // 12:25:42

		System.out.println("Constructed with:");
		displayTime("t1: all default arguments", t1);
		// System.out.printf("total seconds: %d%n", t1.getTotalSeconds());
		displayTime("t2: hour specified; default minute and second", t2);
		// System.out.printf("total seconds: %d%n", t2.getTotalSeconds());
		displayTime("t3: hour and minute specified; default second", t3);
		// System.out.printf("total seconds: %d%n", t3.getTotalSeconds());
		displayTime("t4: hour, minute and second specified", t4);
		// System.out.printf("total seconds: %d%n", t4.getTotalSeconds());
		displayTime("t5: ModIntDataRep object t4 specified", t5);
		// System.out.printf("total seconds: %d%n", t5.getTotalSeconds());

		// attempt to initialize t6 with invalid values
		try
		{
			ModIntDataRep t6 = new ModIntDataRep(27, 74, 99); // invalid values
		}
		catch (IllegalArgumentException e)
		{
			System.out.printf("%nException while initializing t6: %s%n", e.getMessage());
		}
	}

	// displays a Time2 object in 24-hour and 12-hour formats
	private static void displayTime(String header, ModIntDataRep t)
	{
		System.out.printf("%s%n   %s%n   %s%n", header, t.toUniversalString(), t.toString());
	}
}
