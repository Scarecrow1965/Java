// Exercise 5.29
/* Write an application that uses iteration and switch statements to print
 * the song “The Twelve Days of Christmas.”
 * One switch statement should be used to print the day (“first,” “second,” and so on).
 * A separate switch statement should be used to print the remainder of each verse.
 * Visit the website en.wikipedia.org/wiki/The_Twelve_Days_of_Christmas_(song) for the
 * lyrics of the song.
 * 
 Using:
 On the ______ day of Christmas my true love sent to me
 
 A partridge in a pear tree.
 Two turtle doves,
 Three French hens,
 Four calling birds
 Five gold rings
 Six geese a-laying
 Seven swans a-swimming
 Eight maids a-milking
 Nine ladies dancing
 Ten lords a-leaping
 Eleven pipers piping
 Twelve drummers drumming
 */

public class TwelveDaysXmas
{

	public static void main(String[] args)
	{
		// initializing variables
		int days;


		
		//selecting the days
		for(days = 1; days <= 12; days++)
		{
			// time for the carol
			System.out.print("On the ");
			
			switch(days)
			{
				case 1:
				{
					System.out.print("first");
					break;
				} // end case 1
				case 2:
				{
					System.out.print("second");
					break;
				} // end case 2
				case 3:
				{
					System.out.print("third");
					break;
				}// end case 3
				case 4:
				{
					System.out.print("fourth");
					break;
				}// end case 4
				case 5:
				{
					System.out.print("fifth");
					break;
				}// end case 5
				case 6:
				{
					System.out.print("sixth");
					break;
				}// end case 6
				case 7:
				{
					System.out.print("seventh");
					break;
				}// end case 7
				case 8:
				{
					System.out.print("eighth");
					break;
				}// end case 8
				case 9:
				{
					System.out.print("ninenth");
					break;
				}// end case 9
				case 10:
				{
					System.out.print("tenth");
					break;
				}// end case 10
				case 11:
				{
					System.out.print("eleventh");
					break;
				} // end case 11
				case 12:
				{
					System.out.print("twelveth");
					break;
				} // end case 12
			} //end switch days
			
			System.out.print(" day of Christmas, my true love gave to me, \n");
			
			//selecting the gifts
			switch(days)
			{
				//as per Chap 5.6 case without a break Statement
				case 12:
				{
					System.out.print("Twelve drummers drumming. \n");
				}// end case 12
				case 11:
				{
					System.out.print("Eleven pipers piping, \n");
				}// end case 11
				case 10:
				{
					System.out.print("Ten lords a-leaping, \n");
				}// end case 10
				case 9:
				{
					System.out.print("Nine ladies dancing, \n");
				}// end case 9
				case 8:
				{
					System.out.print("Eight maids a-milking, \n");
				}// end case 8
				case 7:
				{
					System.out.print("Seven swans a-swimming, \n");
				}// end case 7
				case 6:
				{
					System.out.print("Six geese a-laying, \n");
				}// end case 6
				case 5:
				{
					System.out.print("Five gold rings, \n");
				}// end case 5
				case 4:
				{
					System.out.print("Four calling birds, \n");
				}// end case 4
				case 3:
				{
					System.out.print("Three French hens, \n");
				}// end case 3
				case 2:
				{
					System.out.print("Two turtle doves, \n");
					System.out.print("and, ");
				}// end case 2
				case 1:
				{
					System.out.print("A partridge in a pear tree. \n");
				}// end case 1
			} //end switch for gifts
			 
		} // end for
		
	} //end method main

} // end class TwelveDaysXmas
