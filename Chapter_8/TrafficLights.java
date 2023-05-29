// Exercise 8.10
/* Write an enum type TrafficLight,
 * whose constants (RED, GREEN, YELLOW)
 * take one parameter—the duration of the light.
 * Write a program to test the TrafficLight enum
 * so that it displays the enum constants and their durations.
 */

public class TrafficLights
{
	public enum TrafficLight
	// declare constants of enum type
	{RED(30),
		GREEN(30),
		YELLOW(5);

		// instance field
		public final int duration; // duration of the light

		// enum constructor	
		TrafficLight(int durationSeconds)
		{
			this.duration = durationSeconds;
		}

		// accessor for field duration
		public int getDuration()
		{
			return duration;
		}
	} // end enum

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// initializing variables

		System.out.println("This application will test the enum TrafficLights.");

		for(TrafficLight light : TrafficLight.values())
		{
			System.out.printf( "%s\t%d%n", light, light.getDuration() );
		}
		System.out.println();

		System.out.println("Now let's see the intersection lights work for one revolution!");
		for(TrafficLight light : TrafficLight.values())
		{
			for( int i = light.getDuration(); i > 0 ; i--)
			{
				System.out.printf("%s \t(countdown %d)%n", light, i);
			}
		}

	System.out.printf("%s%n", TrafficLight.values());

	} // end method main

} // end class
