// Exercise 7.18
/* (Game of Craps)
 * Write an application that runs 1,000,000 games of craps (Fig.6.8 ) and answers the following questions:
1.	How many games are won on the first roll, second roll, ..., twentieth roll and after the twentieth roll?
2.	How many games are lost on the first roll, second roll, ..., twentieth roll and after the twentieth roll?
3.	What are the chances of winning at craps?
[Note: You should discover that craps is one of the fairest casino games. What do you suppose this means?]
4.	What is the average length of a game of craps?
5.	Do the chances of winning improve with the length of the game? */

/* //Fig. 6.8: Craps.java
// Craps class simulates the dice game craps.
import java.security.SecureRandom;

public class Craps
{
	// create secure random number generator for use in method rollDice
	private static final SecureRandom randomNumbers = new SecureRandom();

	// enum type with constants that represent the game status
	private enum Status {CONTINUE, WON, LOST};

	// constants that represent common rolls of the dice
	private static final int SNAKE_EYES = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_LEVEN = 11;
	private static final int BOX_CARS = 12;

	// plays one game of craps
	public static void main(String[] args)
	{
		int myPoint = 0; // point if no win or loss on first roll
		Status gameStatus; // can contain CONTINUE, WON or LOST

		int sumOfDice = rollDice(); // first roll of the dice

		// determine game status and point based on first roll 
		switch (sumOfDice)
		{
		case SEVEN: // win with 7 on first roll    
		case YO_LEVEN: // win with 11 on first roll
			gameStatus = Status.WON;
			break;
		case SNAKE_EYES: // lose with 2 on first roll
		case TREY: // lose with 3 on first roll      
		case BOX_CARS: // lose with 12 on first roll 
			gameStatus = Status.LOST;
			break;
		default: // did not win or lose, so remember point  
			gameStatus = Status.CONTINUE; // game is not over
			myPoint = sumOfDice; // remember the point       
			System.out.printf("Point is %d%n", myPoint);
			break; 
		} // end switch

		// while game is not complete
		while (gameStatus == Status.CONTINUE) // not WON or LOST
		{
			sumOfDice = rollDice(); // roll dice again

			// determine game status
			if (sumOfDice == myPoint) // win by making point
			{
				gameStatus = Status.WON;
			}
			else
			{
				if (sumOfDice == SEVEN) // lose by rolling 7 before point
				{
					gameStatus = Status.LOST;
				}
			}
		} // end while

		// display won or lost message
		if (gameStatus == Status.WON)
		{
			System.out.println("Player wins");
		}
		else
		{
			System.out.println("Player loses");
		}
	} // end method main

	// roll dice, calculate sum and display results
	public static int rollDice()
	{
		// pick random die values
		int die1 = 1 + randomNumbers.nextInt(6); // first die roll
		int die2 = 1 + randomNumbers.nextInt(6); // second die roll

		int sum = die1 + die2; // sum of die values

		// display results of this roll
		System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);

		return sum; 
	} // end method rollDive

} // end class Craps
*/

import java.security.SecureRandom;

public class GameofCraps
{
	// create secure random number generator for use in method rollDice
	private static final SecureRandom randomNumbers = new SecureRandom();

	// enum type with constants that represent the game status
	private enum Status {CONTINUE, WON, LOST}; // enum = 0, 1, 2

	// constants that represent common rolls of the dice
	private static final int SNAKE_EYES = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_LEVEN = 11;
	private static final int BOX_CARS = 12;

	// plays one game of craps
	public static void main(String[] args)
	{

		// initializing variables
		int myPoint = 0; // point if no win or loss on first roll
		Status gameStatus; // can contain CONTINUE, WON or LOST
		int counterGAMES;
		int counterWON = 0;
		int counterLOSE = 0;
		int freqWIN [] = new int[21]; // array for frequency of winning rolls		
		int freqLOSE [] = new int[21]; // array for frequency of winning rolls
		int frequency[] = new int[21]; // array for frequency of total rolls

		// start GameCOUNT here
		for (counterGAMES = 1; counterGAMES < 1_000_000; counterGAMES++)
		{
			// start counterROLLS here
			int counterROLLS = 0;
			int sumOfDice = rollDice(); // first roll of the dice
			// add 1 to counterROLLS
			counterROLLS += 1;

			// determine game status and point based on first roll 
			switch (sumOfDice)
			{
			case SEVEN: // win with 7 on first roll
			case YO_LEVEN: // win with 11 on first roll
				gameStatus = Status.WON;
				// add 1 to gamesWON
				counterWON +=1;
				++freqWIN[counterROLLS];
				// need to method for counting rolls into array
				++frequency[counterROLLS];
				// CounterRolls(frequency, counterROLLS);
				break;
			case SNAKE_EYES: // lose with 2 on first roll
			case TREY: // lose with 3 on first roll
			case BOX_CARS: // lose with 12 on first roll
				gameStatus = Status.LOST;
				// add 1 to gamesLOSE
				counterLOSE += 1;
				++freqLOSE[counterROLLS];
				// need to method for counting rolls into array
				++frequency[counterROLLS];
				// CounterRolls(frequency, counterROLLS);
				break;
			default: // did not win or lose, so remember point
				gameStatus = Status.CONTINUE; // game is not over
				myPoint = sumOfDice; // remember the point
				// remove prints of how game goes in order to save time and memory space
				//System.out.printf("Point is %d%n", myPoint);
				break; 
			} // end switch

			// while game is not complete
			while (gameStatus == Status.CONTINUE) // not WON or LOST
			{
				sumOfDice = rollDice(); // roll dice again
				// add 1 to counterROLLS
				counterROLLS += 1;
				// determine game status
				if (sumOfDice == myPoint) // win by making point
				{
					gameStatus = Status.WON;
				}
				else
				{
					if (sumOfDice == SEVEN) // lose by rolling 7 before point
					{
						gameStatus = Status.LOST;
					}
				}
			} // end while

			// display won or lost message
			if (gameStatus == Status.WON)
			{
				// remove prints of how game goes in order to save time and memory space
				// System.out.println("Player wins");
				// method to gamesWON
				counterWON += 1;
				// need to method for counting total rolls into array
				
				// CounterRolls(frequency, counterROLLS);
				if(counterROLLS > 20)
				{
					counterROLLS = 20;
				}
				++freqWIN[counterROLLS];
				++frequency[counterROLLS];
			}
			else
			{
				// remove prints of how game goes in order to save time and memory space
				// System.out.println("Player loses");
				//method to gamesLOSE
				counterLOSE += 1;
				// need to method for counting total rolls into array
				
				// CounterRolls(frequency, counterROLLS);
				if(counterROLLS > 20)
				{
					counterROLLS = 20;
				}
				++freqLOSE[counterROLLS];
				++frequency[counterROLLS];
			}

		} //end for GameCOUNT

		// to display all statistics
		System.out.printf("Here are the statistics for all %d games played.%n", counterGAMES);
		System.out.println();
		// Part 1. How many games are won on the first roll, second roll, ..., twentieth roll and after the twentieth roll?
		System.out.println("Statistic in Winning a Game:");
		for (int j = 0; j < freqWIN.length; j++)
		{
			System.out.printf("%2d times: %6d%n", j + 1, freqWIN[j] );
		}
		System.out.println();
		// Part 2. How many games are lost on the first roll, second roll, ..., twentieth roll and after the twentieth roll?
		System.out.println("Statistic in Losing a Game:");
		for (int j = 0; j < freqLOSE.length; j++)
		{
			System.out.printf("%2d times: %6d%n", j + 1, freqLOSE[j] );
		}
		System.out.println();
		//setting up display tabs
		System.out.printf("You have WON  %d this many games.%n", counterWON);
		System.out.printf("You have LOST %d this many games.%n", counterLOSE);
		System.out.printf("The chances of winning at Craps is: %.02f %s%n", ChancesWinning(counterWON, counterGAMES), "%" );
		
		System.out.println("This displays how many total rolls it took to end a game:");
		System.out.println("Roll: \t How many:");
		for(int count = 0; count < frequency.length; count++)
		{
			System.out.printf("%02d:\t %8d%n" , count + 1, frequency[count] );
		}
		System.out.printf("Based on these numbers, the average length of game is: %.02f %n", getAverage(frequency, counterGAMES) );
		System.out.println();

	} // end method main

	// roll dice, calculate sum and display results
	public static int rollDice()
	{
		// pick random die values
		int die1 = 1 + randomNumbers.nextInt(6); // first die roll
		int die2 = 1 + randomNumbers.nextInt(6); // second die roll

		int sum = die1 + die2; // sum of die values

		// display results of this roll
		// remove prints of how game goes in order to save time and memory space
		// System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);

		return sum; 
	} // end method rollDive

	// method to see chances of winning, Part 3. What are the chances of winning at craps?
	public static float ChancesWinning(int counterWON, int counterGAMES)
	{
		float chancesWINNING;
		chancesWINNING = 100 * counterWON / counterGAMES;
		return chancesWINNING;
	} // end method ChancesWinning
	
	// determine average rolls for this run Part 4. What is the average length of a game of craps?
	public static double getAverage(int frequency[], int counterGAMES)
	{
		int total = 0;
		// sum rolls for one frequency
		for (int rolls : frequency)
		{
			total += rolls;
		}
		// return average of rolls
		return (double) total / counterGAMES;
	}
	
	// method to count rolls
	public static void CounterRolls (int frequency[], int counterROLLS)
	{ 
		switch (counterROLLS)
		{
		case 1:
		{
			frequency[0] += 1;
			break;
		}
		case 2:
		{
			frequency[1] += 1;
			break;
		}
		case 3:
		{
			frequency[2] += 1;
			break;
		}
		case 4:
		{
			frequency[3] += 1;
			break;
		}
		case 5:
		{
			frequency[4] += 1;
			break;
		}
		case 6:
		{
			frequency[5] += 1;
			break;
		}
		case 7:
		{
			frequency[6] += 1;
			break;
		}
		case 8:
		{
			frequency[7] += 1;
			break;
		}
		case 9:
		{
			frequency[8] += 1;
			break;
		}
		case 10:
		{
			frequency[9] += 1;
			break;
		}
		case 11:
		{
			frequency[10] += 1;
			break;
		}
		case 12:
		{
			frequency[11] += 1;
			break;
		}
		case 13:
		{
			frequency[12] += 1;
			break;
		}
		case 14:
		{
			frequency[13] += 1;
			break;
		}
		case 15:
		{
			frequency[14] += 1;
			break;
		}
		case 16:
		{
			frequency[15] += 1;
			break;
		}
		case 17:
		{
			frequency[16] += 1;
			break;
		}
		case 18:
		{
			frequency[17] += 1;
			break;
		}
		case 19:
		{
			frequency[18] += 1;
			break;
		}
		case 20:
		{
			frequency[19] += 1;
			break;
		}
		default:
		{
			frequency[20] += 1;
		}
		} // end switch	
	} //end method CounterROLLS

} // end class GameofCraps
