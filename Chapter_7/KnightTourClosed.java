// Exercise 7.26
/* (Knight’s Tour: Closed-Tour Test)
 * In the Knight’s Tour (Exercise 7.22 ), a full tour occurs when the knight makes 64 moves,
 * touching each square of the chessboard once and only once.
 * A closed tour occurs when the 64th move is one move away from the square in which the knight started the tour.
 * Modify the application you wrote in Exercise 7.22 to test for a closed tour if a full tour has occurred.
 */

import java.util.Random; // uses Random

public class KnightTourClosed
{
	// Initializing variables for all to see
	public static final Random randomNumbers = new Random(); // setting up for random numbers
	public static int[][] chessboard = new int[8][8]; // chess board array. initialized to zero
	// knight moves +2 spaces one direction and +/-1 space perpendicular
	// so knight move can only be at:
	public static int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2}; // possible knight moves X horizontal
	public static int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1}; // possible knight moves Y vertical
	public static int currentRow; // current X Position		// position currentRow is the horizontal location
	public static int currentColumn; // current Y Position		// position currentColumn is the vertical position
	public static int newcurrentRow; // current X Position		// position currentRow is the horizontal location
	public static int newcurrentColumn; // current Y Position		// position currentColumn is the vertical position
	public static int moveNumber;
	public static int count = 0; // to use as a counter to the chess board array
	public static boolean done = false; // to see if the knight tour is done (completed run)
	public static int [][] accessibility = 
		{{2, 3, 4, 4, 4, 4, 3, 2},
				{3, 4, 6, 6, 6, 6, 4, 3},
				{4, 6, 8, 8, 8, 8, 6, 4},
				{4, 6, 8, 8, 8, 8, 6, 4},
				{4, 6, 8, 8, 8, 8, 6, 4},
				{4, 6, 8, 8, 8, 8, 6, 4},
				{3, 4, 6, 6, 6, 6, 4, 3},
				{2, 3, 4, 4, 4, 4, 3, 2}};
	public static int stop;

	public static boolean ValidMove(int newRow, int newColumn)
	{
		if(newRow >= 0 && newRow < 8 && newColumn >= 0 && newColumn < 8 && chessboard[newRow][newColumn] == 0 )
		{
			return true; // knight move is good
		}
		return false; // knight move is not good
	} // end method ValidMove 

	static boolean ifFull(int[][] chessboard)
	{
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				if(chessboard[i][j] == 0)
				{
					return false;
				}
			}
		}
		return true;
	}

		public static void main(String[] args)
		{
			System.out.println("This application will display Chess Board and Knight moving to all places within the Chess Board.");
			// currentRow is the X horizontal position, currentColumn is the Y vertical position
			// 	Is knight starting point is chess board[3][4] or random. Let's try initial random knight position through randomNumbers
			currentRow = randomNumbers.nextInt(8);
			currentColumn = randomNumbers.nextInt(8);

			System.out.printf("Chessboard Knight initial position is [%d][%d]%n", currentRow, currentColumn);
			// chessboard (currentRow, currentColumn) = Knight grid array position
			chessboard[currentRow][currentColumn] = ++count; // chessboard[currentRow][currentColumn] = 1; signal that knight has been here

			// THIS WORKS
			ChessBoard( chessboard ); // display initial chess board

			while (!done)
			{
				int stop = 99;

				for(moveNumber = 0; moveNumber < 8; moveNumber++)
				{
					// ( CurrentRow  + [horizontal], currentColumn + [vertical] )
					int testcurrentRow = currentRow + vertical[moveNumber]; // future knight move in X position
					int testcurrentColumn = currentColumn + horizontal[moveNumber]; // future knight move in Y position
					if(ValidMove( testcurrentRow, testcurrentColumn )) // test if current direction is valid
					{
						if(accessibility[testcurrentRow][testcurrentColumn] < stop) // test if wise to go there
						{
							stop = accessibility[testcurrentRow][testcurrentColumn];
							newcurrentRow = testcurrentRow;
							newcurrentColumn = testcurrentColumn;
						}
						--accessibility[testcurrentRow][testcurrentColumn];
					}
				}
				if(stop == 99) // if there is no valid moves left
				{
					//exercise 7.26
					if(ifFull(chessboard))
					{
						System.out.println("Knight's Tour is complete!!!");
						done = true; // time to quit
					}
					else
					{
						System.out.println("Knight's Tour is not complete!!!");
					}
				}
//			}
				else // make the move
				{
					currentRow = newcurrentRow;
					currentColumn = newcurrentColumn;
					System.out.printf("Knight new position is [%d][%d]%n", currentRow, currentColumn);
					System.out.printf("Knight move count is %d%n", count);
					chessboard[currentRow][currentColumn] = ++count; // signal that knight has been here
					// THIS WORKS
					ChessBoard( chessboard ); // display chess board
				}
			} // end while

		} // end method main

		public static void ChessBoard(int[][] chessboard)
		{
			String columns = "|";
			String rows = "   -----------------------------------------";
			String rowheader = "      0    1    2    3    4    5    6    7";
			int spacing = 1;
			
			System.out.printf("%s%n", rowheader);
			for(int i = 0; i < 8; i++) // loop for every 8 row
			{
				System.out.printf("%s%n", rows);
				System.out.printf("%2d ", i);
				for(int l = 0; l < spacing; l++) // loop for each whole line
				{
					for(int j = 0; j < 8; j++) // loop for every 8 column
					{
						System.out.printf("%s ", columns);
						System.out.printf("%02d ", chessboard[i][j]); // display chess board
					}
					System.out.printf("%s %2d",columns, i); 
					System.out.println(""); // creates new line between rows
				}
			}
			System.out.printf("%s%n", rows);
			System.out.printf("%s%n", rowheader);
		} // end method ChessBoard
	
} // end class KnightTourClosed
