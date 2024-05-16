// Exercise 7.19
/* (Airline Reservations System) A small airline has just purchased a computer
 * for its new automated reservations system.
 * You’ve been asked to develop the new system.
 * You’re to write an application to assign seats on each flight of the airline’s only plane (capacity: 10 seats).
Your application should display the following alternatives:
Please type 1 for First Class and
Please type 2 for Economy.
If the user types 1, your application should assign a seat in the first-class section (seats 1–5).
If the user types 2, your application should assign a seat in the economy section (seats 6–10).
Your application should then display a boarding pass indicating
the person’s seat number and
whether it’s in the first-class or economy section of the plane.
Use a one-dimensional array of primitive type boolean to represent the seating chart of the plane.
Initialize all the elements of the array to false to indicate that all the seats are empty.
As each seat is assigned, set the corresponding element of the array to true to indicate that the seat is no longer available.
Your application should never assign a seat that has already been assigned.
When the economy section is full, your application should ask the person if it’s acceptable to be placed in the first-class section (and vice versa).
If yes, make the appropriate seat assignment.
If no, display the message 1"Next flight leaves in 3 hours."
 */

import java.util.Scanner;

public class AirlineResSyst
{
	public static void main(String[] args)
	{
		// initializing variables
		int choice = 0; // verify first or Economy class
		int full = 0; // used to see if plane is full
		boolean seatchart[] = new boolean[11]; // for seating capacity, default value is false
		for(int i = 0; i < seatchart.length; i++) //set all seats to false
		{
			seatchart[i] = false;
		}

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		while(choice != 99)
		{
			// Main menu
			System.out.println("Welcome to the Airline Reservation System.");
			System.out.println("Select 1 for First Class"); //select 1 for first class
			System.out.println("Select 2 for Economy");//select 2 for economy
			System.out.println("Select 99 to quit");
			System.out.print("option: ");
			choice = input.nextInt(); // read airline class option

			switch (choice)
			{
			case 1:
			{
				// first class
				FirstClass(seatchart, full); // method FirstClass
				break;
			}
			case 2:
			{
				// Economy class
				EconomyClass(seatchart, full); // method EconomyClass
				break;
			}
			case 99:
			{
				System.out.println("Thank you for using the Airline Reservation System");
				System.out.println("Good bye");
				break;
			}
			default:
			{
				System.out.println("You have entered incorrectly, please try again...");
				System.out.print("option: ");
				choice = input.nextInt(); // read airline class option
			}
			} //end switch
		}// end while for main menu
		
		

	} // end method main

	
	public static void FirstClass(boolean[] seatchart, int full)
	{
		int option = 0; // menu options
		int firstClass;
		int seat;
		int maxseat1st = 0; // max seat in First class

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to First Class.");
		// First Class Menu
		while(option != 99)
		{
			System.out.println("Here are the following options:");
			System.out.println("(1) to verify First Class seat availability");
			System.out.println("(2) to book (add) a First Class seat");
			System.out.println("(3) to unbook (remove) a First Class seat");
			System.out.println("(99) to exit this menu");
			option = input.nextInt(); // choosing next option in submenu
			
			switch (option)
			{
			case 1:
			{
				// verifying First class seat availability
				if (maxseat1st <= 0)
				{
					System.out.println("The First class booking is empty!!");
				}
				else
				{
					// method SeatCheck (check available)
					for (firstClass = 1; firstClass <= 5; firstClass ++)
					{
						// check to see if seats are available method
						System.out.printf("Seat #%d is %s%n", firstClass, SeatCheck(firstClass, seatchart) );
					}
				}
				break;
			}
			case 2:
			{
				// add booking
				if(maxseat1st != 5)
				{
					System.out.println("Which First class seat (1 - 5) would you like to book?");
					seat = input.nextInt(); // choosing seat
					if(seat > 0 && seat < 6)
					{
						if(seatchart[seat]== true)
						{
							System.out.println("This seat is already booked.");
						}
						else
						{
							// method AddBooking
							AddBooking (seat, seatchart);
							if(seatchart[seat] = true)
							{
								System.out.printf("First Class Seat # %d is now booked.%n", seat);
								maxseat1st++;
								full++;
							}
							else
							{
								System.out.println("Something went wrong. Please try again.");
							}
						}
					}
					else
					{
						System.out.println("You have entered a wrong seat number.");
						System.out.println("Please try again.");
					}
					// to see if first class is full
					if (maxseat1st == 5)
					{
						System.out.println("********************************");
						System.out.println("The First Class booking is full!!");
						System.out.println("********************************");
						// Checking to see if plane is full
						if( (maxseat1st + full) == 15)
						{
							System.out.println("********************");
							System.out.println("THE PLANE IS FULL!!!");
							System.out.println("********************");
						}
					}
					else
					{}
				}
				else
				{
					System.out.println("You are attempting to overbook First Class.");
					System.out.println("Do you wish to book into Economy Class?");
					System.out.println("Press (4) for Yes");
					System.out.println("Press (5) for No");
					option = input.nextInt(); // choosing next option in submenu
					if(option < 4 || option > 5)
					{
						System.out.println("You have entered a wrong option.");
						System.out.println("Please try again.");
					}
					else
					{
						if(option == 4)
						{
							EconomyClass(seatchart, full);
						}
						else
						{
							System.out.println("This program will not allow overbooking");
							System.out.println("Next flight leaves in 3 hours.");
						}
					}
				}
				break;
			}
			case 3:
			{
				// method removebooking
				System.out.println("Which First Class seat (1 - 5) would you like to remove from booking?");
				seat = input.nextInt(); // choosing seat
				if(seat > 0 && seat < 6)
				{
					// method RemoveBooking(int seat, seatchart)
					RemoveBooking (seat, seatchart);
					if(seatchart[seat] = false)
					{
						System.out.println("Something went wrong. Please try again.");
					}
					else
					{
						System.out.println("The seat is now free to book.");
						maxseat1st--;
					}
				}
				else
				{
					System.out.println("You have entered a wrong seat number.");
					System.out.println("Please try again.");
				}
				if (maxseat1st <= 0)
				{
					System.out.println("The First class booking is empty!!");
				}
				break;
			}
			case 99:
			{
				System.out.println("Return to Main menu...");
				break;
			}
			default:
			{
				System.out.println("You have entered incorrectly, please try again...");
				System.out.print("option: ");
			}
			} //end switch
		} // end while
	} // end method First Class


	public static void EconomyClass(boolean[] seatchart, int full)
	{
		int option = 0; // menu options
		int economyClass;
		int seat;
		int maxseatecono = 0;

		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		// Economy Class Menu
		while(option != 99)
		{
			System.out.println("Welcome to Economy Class.");
			System.out.println("Here are the following options:");
			System.out.println("(1) to verify Economy Class seat availability");
			System.out.println("(2) to book (add) an Economy Class seat");
			System.out.println("(3) to unbook (remove) an Economy Class seat");
			System.out.println("(99) to exit this menu");
			option = input.nextInt(); // choosing next option in submenu

			switch (option)
			{
			case 1:
			{
				// verifying economy seat availability
				if (maxseatecono <= 0)
				{
					System.out.println("The Economy class booking is empty!!");
				}
				else
				{
					// method SeatCheck (check available)
					for (economyClass = 6; economyClass <= 10; economyClass ++)
					{
						// check to see if seats are available method
						System.out.printf("Seat #%d is %s%n", economyClass, SeatCheck(economyClass, seatchart) );
					}
				}
				break;
			}
			case 2:
			{
				if(maxseatecono != 5)
				{
					System.out.println("Which Economy Class seat (6 - 10) would you like to book?");
					seat = input.nextInt(); // choosing seat
					//checking if the seat is already taken
					if(seatchart[seat] == true)
					{
						System.out.println("This seat is already taken!!");
						System.out.println("Please choose another");
					}
					else
					{
						if(seat > 5 && seat < 11)
						{
							// method AddBooking (seat, seatchart);
							AddBooking (seat, seatchart);
							if(seatchart[seat] = true)
							{
								System.out.printf("Economy Seat # %d is now booked.%n", seat);
								maxseatecono++;
								full++;
							}
							else
							{
								System.out.println("Something went wrong. Please try again.");
							}
						}
						else
						{
							System.out.println("You have entered a wrong seat number.");
							System.out.println("Please try again.");
						}
					}
					// to see if first class is full
					if (maxseatecono == 5)
					{
						System.out.println("***********************************");
						System.out.println("The Economy Class booking is full!!");
						System.out.println("***********************************");
						// Checking to see if plane is full
						if( (maxseatecono + full) == 15)
						{
							System.out.println("********************");
							System.out.println("THE PLANE IS FULL!!!");
							System.out.println("********************");
						}
					}
				}
				else
				{
					System.out.println("You are attempting to overbook Economy Class.");
					System.out.println("Do you wish to book into First Class?");
					System.out.println("Press (4) for Yes");
					System.out.println("Press (5) for No");
					option = input.nextInt(); // choosing next option in submenu
					if(option < 4 || option > 5)
					{
						System.out.println("You have entered a wrong option.");
						System.out.println("Please try again.");
					}
					else
					{
						if(option == 4)
						{
							FirstClass(seatchart, full);
						}
						else
						{
							System.out.println("This program will not allow overbooking");
							System.out.println("Next flight leaves in 3 hours.");
						}
					}
				}
				break;
			}
			case 3:
			{
				System.out.println("Which seat would you like to remove from booking?");
				seat = input.nextInt(); // choosing seat
				if(seat > 5 && seat < 11)
				{
					// method RemoveBooking (seat, seatchart);
					RemoveBooking (seat, seatchart);
					if(seatchart[seat] = false)
					{
						System.out.println("The seat is now free to book.");
						maxseatecono--;
					}
					else
					{
						System.out.println("Something went wrong. Please try again.");
					}
				}
				else
				{
					System.out.println("You have entered a wrong seat number.");
					System.out.println("Please try again.");
				}
				if (maxseatecono <= 0)
				{
					System.out.println("The Economy class booking is empty!!");
				}
				break;
			}
			case 99:
			{
				System.out.println("Returning to Main Menu");
				break;
			}
			default:
			{
				System.out.println("You have entered incorrectly, please try again...");
				System.out.print("option: ");
			}
			} //end switch
		} // end while
	} // end method EconomyClass


	// check seat available method
	public static String SeatCheck(int seat, boolean[] seatchart)
	{
		String seatcheck = " ";
		if (seatchart[seat] == false)
		{
			seatcheck = "FREE.";
		}
		else
		{
			seatcheck = "TAKEN!";
		}
		return seatcheck;
	}

	// booking method
	public static boolean AddBooking(int seat, boolean[] seatchart)
	{
		Boolean addbooking = true;
		if(seatchart[seat] = false)
		{
			seatchart[seat] = addbooking; //when seat is taken then set to true
			return seatchart[seat];
		}
		else
		{
			return seatchart[seat];
		}
	}

	public static boolean RemoveBooking(int seat, boolean[] seatchart)
	{
		Boolean rembooking = false;
		if(seatchart[seat] = true)
		{
			seatchart[seat] = rembooking; //when seat is free then set to false
			return seatchart[seat];
		}
		else
		{
			return seatchart[seat];
		}
	}

} // end class AirlineResSyst
