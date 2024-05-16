// Exercise 7.22
/* (Knight’s Tour)
An interesting puzzler for chess buffs is the Knight’s Tour problem, originally proposed by the mathematician Euler.
Can the knight piece move around an empty chess-board and touch each of the 64 squares once and only once?
We study this intriguing problem in depth here.
The knight makes only L-shaped moves (two spaces in one direction and one space in a perpendicular direction).
Thus, as shown in Fig.7.30 , from a square near the middle of an empty chessboard, the knight (labeled K)
can make eight different moves (numbered 0 through 7).
Fig. 7.30
// cannot be shown here as it is a graphic
The eight possible moves of the knight.

An 8 by 8 array where the rows and columns are numbered from 0 to 7 each.
The knight is positioned on row 3, column 4.
The eight possible moves for the knight are: possibility 0, row 2, column 6; possibility 1, row 1, column 5;
possibility 2, row 1, column 3; possibility 3, row 2, column 2; possibility 4, row 4, column 2; possibility 5, row 5, column 3;
possibility 6, row 5, column 5; possibility 7, row 4, column 6.

1.	Draw an eight-by-eight chessboard on a sheet of paper, and attempt a Knight’s Tour by hand.
Put a 1 in the starting square, a 2 in the second square, a 3 in the third, and so on.
Before starting the tour, estimate how far you think you’ll get, remembering that a full tour consists of 64 moves.
How far did you get? Was this close to your estimate?

2.	Now let’s develop an application that will move the knight around a chessboard.
The board is represented by an eight-by-eight two-dimensional array board.
Each square is initialized to zero. We describe each of the eight possible moves in terms of its horizontal and vertical components.
For example, a move of type 0, as shown in Fig.7.30 , consists of moving two squares horizontally to the right and one square vertically upward.
A move of type 2 consists of moving one square horizontally to the left and two squares vertically upward.
Horizontal moves to the left and vertical moves upward are indicated with negative numbers.
The eight moves may be described by two one-dimensional arrays, horizontal and vertical, as follows:
horizontal[0] = 2 		vertical[0] = -1
horizontal[1] = 1 		vertical[1] = -2
horizontal[2] = -1 		vertical[2] = -2
horizontal[3] = -2 		vertical[3] = -1
horizontal[4] = -2 		vertical[4] = 1
horizontal[5] = -1 		vertical[5] = 2
horizontal[6] = 1 		vertical[6] = 2
horizontal[7] = 2 		vertical[7] = 1
Let the variables currentRow and currentColumn indicate the row and column, respectively, of the knight’s current position.
To make a move of type moveNumber, where moveNumber is between 0 and 7, your application should use the statements
currentRow += vertical[moveNumber];
currentColumn += horizontal[moveNumber];
Write an application to move the knight around the chessboard.
Keep a counter that varies from 1 to 64. Record the latest count in each square the knight moves to.
Test each potential move to see if the knight has already visited that square.
Test every potential move to ensure that the knight does not land off the chessboard. Run the application. How many moves did the knight make?
*/

import java.util.Random; // uses Random

public class KnightTourB// Part 2 of Exercise 2.22
{
	// Initializing variables for all to see
	public static final Random randomNumbers = new Random(); // setting up for random numbers
	public static int[][] chessboard = new int[8][8]; // chessboard array // initialized to zero
	// knight moves +2 spaces one direction and +/-1 space perpendicular
	// so knight move can only be at:
	public static int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2}; // possible knight moves X horizontal
	public static int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1}; // possible knight moves Y vertical
	public static int currentRow; // current X Position		// position currentRow is the horizontal location
	public static int currentColumn; // current Y Position		// position currentColumn is the vertical position
	public static int moveNumber;
	public static int knightmove = 64; // theoretical max number of knight moves.
	public static int count = 0; // to use as a counter to the chessboard array

	public static boolean ValidMove(int newRow, int newColumn)
	{
		if(newRow >= 0 && newRow < 8 && newColumn >= 0 && newColumn < 8 && chessboard[newRow][newColumn] == 0 )
		{
			return true; // knight move is good
		}
		return false; // knight move is not good
	} // end method ValidMove 

	public static void main(String[] args)
	{
		// initializing variables
		System.out.println("This application will display Chess Board and Knight moving to all places within the Chess Board.");
		// currentRow is the X horizontal position, currentColumn is the Y vertical position
		// 	Is knight starting point is chess board[3][4] or random. Let's try initial random knight position through randomNumbers
		currentRow = randomNumbers.nextInt(8);
		currentColumn = randomNumbers.nextInt(8);

//		// THIS WORKS
//		// printout random knight moves, for testing purposes only.
//		System.out.println("random Knight move:");
//		for(int i = 0; i < 8; i++)
//		{
//			moveNumber = randomNumbers.nextInt(8);
//			System.out.printf("Attempt #%d : %d%n", i, moveNumber);
//		}

		System.out.printf("Chessboard Knight initial position is [%d][%d]%n", currentRow, currentColumn);
		// chessboard (currentRow, currentColumn) = Knight grid array position
		chessboard[currentRow][currentColumn] = ++count; // chessboard[currentRow][currentColumn] = 1; signal that knight has been here
		--knightmove;

		// THIS WORKS
		ChessBoard( chessboard ); // display initial chess board

//		// THIS WORKS
//		//printout chessboard matrix, for testing purposes only
//		for( int i =0; i < 8; i++) // display chessboard matrix
//		{
//			for(int j = 0; j < 8; j++)
//			{
//				System.out.printf("chessboard matrix [%d][%d] = %d%n", i, j, chessboard[i][j]);
//				}
//		}

		while (knightmove > 0)
		{
			for(moveNumber = 0; moveNumber < 8; moveNumber++)
			{
				// ( CurrentRow  + [horizontal], currentColumn + [vertical] )
				int testcurrentRow = currentRow + vertical[moveNumber]; // future knight move in X position
				int testcurrentColumn = currentColumn + horizontal[moveNumber]; // future knight move in Y position
				if(ValidMove( testcurrentRow, testcurrentColumn ))
				{
					currentRow = testcurrentRow;
					currentColumn = testcurrentColumn;
					System.out.printf("Knight new position is [%d][%d]%n", currentRow, currentColumn);
					chessboard[currentRow][currentColumn] = ++count; // signal that knight has been here
					System.out.printf("Knight move #%d%n", 64 - knightmove);
					--knightmove;

					// THIS WORKS
					ChessBoard( chessboard ); // display chess board
				}
			}
		} // end while

	} // end method main

	public static void ChessBoard(int[][] chessboard)
		{
			String columns = "|";
			String rows = "  -----------------------------------------";
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
						System.out.printf("%2d ", chessboard[i][j]); // display chess board
					}
					System.out.printf("%s %2d",columns, i); 
					System.out.println(""); // creates new line between rows
				}
			}
			System.out.printf("%s%n", rows);
			System.out.printf("%s%n", rowheader);
		} // end method ChessBoard

} // end class KnightTourB
