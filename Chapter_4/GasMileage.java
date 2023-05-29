// Exercise 4.17
/* Drivers are concerned with the mileage their automobiles get.
 * One driver has kept track of several trips by recording the miles driven
 * and gallons used for each tankful.
 * Develop a Java application that will input the miles driven and gallons used
 * (both as integers) for each trip.
 * The program should calculate and display the miles per gallon obtained for each
 * trip and print the combined miles per gallon obtained for all trips up to this point.
 * All averaging calculations should produce floating-point results.
 * Use class Scanner and sentinel-controlled iteration to obtain the data from the user. */

public class GasMileage
{
	//initializing variables
	int milesdriven_total;
	int milesdriven;
	int gallonsused_total;
	int gallonsused;
	float milesgallons;
	float milesgallons_total;
	int trip = 0;
	int trip_total = 0;
		
	// set constructor for setup
	public GasMileage(int trip, int trip_total, int milesdriven, int milesdriven_total, int gallonsused, int gallonsused_total, float milesgallons)
	{
		this.trip = trip;
		this.trip_total = trip_total;
		this.milesdriven = milesdriven;
		this.milesdriven_total = milesdriven_total;
		this.gallonsused = gallonsused;
		this.gallonsused_total = gallonsused_total;
		this.milesgallons = milesgallons;
	} // end constructor Exercise4_17

	// method for setTrip
	public void setTrip(int trip)
	{
		this.trip = trip;
		++trip_total;
	} //end method setTrip
	
	// method for getTrip 
	public int getTrip ()
	{
		return trip;
	}//end method getTrip
	
	// method for getTripTotal
	public int getTripTotal()
	{
		return trip_total;
	} // end method getTripTotal
	
	// method SetMilesDriven 
	public void setMilesDriven(int milesdriven)
	{
		this.milesdriven = milesdriven;
		milesdriven_total += milesdriven;
	} //end method setMilesDriven
	
	// method for getMilesDriven
	public int getMilesDriven()
	{
		return milesdriven;
	} // end method getMilesDriven
	
	// method for getTotalMiles
	public int getTotalMiles()
	{
		return milesdriven_total;
	} // end method getTotalMiles
	
	// method for setGallonsUsed
	public void setGallonsUsed(int gallonsused)
	{
		this.gallonsused = gallonsused;
		gallonsused_total += gallonsused;
	} //end method setGFallonsUsed
		
	// method for getGallonsUsed
	public int getGallonsUsed()
	{
		return gallonsused;
	} // end method getGallonsUsed
		
	// method to calculate averages
	public float CalTripAverage()
	{
		milesgallons_total = milesdriven_total / gallonsused_total;
		return milesgallons_total;
	} // end method CalTripAverage 
		
} //end class GasMileage
