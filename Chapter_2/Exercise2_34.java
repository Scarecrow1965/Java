// Exercise 2.34
// Search the Internet to determine the current world population and the annual world
// population growth rate. Write an application that inputs these values, then displays
// the estimated world population after one, two, three, four and five years.

public class Exercise2_34 {
	// main method begins execution of Java application
    public static void main (String [] args) {
    	// initialization of information
        double year = 1;
        
        // from https://calculator.academy/population-growth-calculator/ 
        // The following formula is used to calculate a population size after a certain number of years. 
        // x(t) = x0 * (1 + r)t -(where t is superscripted)
        //	Where x(t) is the final population after time t
        //	x0 is the initial population
        //	r is the rate of growth 
        //	and t is the total time (number of years)
        
        // from https://countrymeters.info/en/World, the current world population is 7,956,675,476
        System.out.println("Current World Population is 7,956,675,476 or approx 8 Billion");
        double currentPop = 8.0;
        // from https://en.wikipedia.org/wiki/World_population, the annual world population growth rate is 1.05%
        System.out.println("Current Growth Rate is 1.05%");
        double growthRate = 0.0105;
        
        double finalGrowth1 = (1 + growthRate);
        System.out.printf("The estimated population after %.0f year is: %f Billion\n" , year, currentPop * finalGrowth1);
        double finalGrowth2 = ((1 + growthRate) * (1 + growthRate));
        System.out.printf("The estimated population after %.0f years is: %f Billion\n" , year + 1, currentPop * finalGrowth2);
        double finalGrowth3 = ((1 + growthRate) * (1 + growthRate) * (1 + growthRate));
        System.out.printf("The estimated population after %.0f years is: %f Billion\n" , year + 2, currentPop * finalGrowth3);
        double finalGrowth4 = ((1 + growthRate) * (1 + growthRate) * (1 + growthRate) * (1 + growthRate));
        System.out.printf("The estimated population after %.0f years is: %f Billion\n" , year + 3, currentPop * finalGrowth4);
        double finalGrowth5 = ((1 + growthRate) * (1 + growthRate) * (1 + growthRate) * (1 + growthRate) * (1 + growthRate));
        System.out.printf("The estimated population after %.0f years is: %f Billion\n" , year + 4, currentPop * finalGrowth5);
 
    } // end method main
    
} // end class Exercise2_34