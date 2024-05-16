// Exercise 7.22
/* (Knight’s Tour)
3.	After attempting to write and run a Knight’s Tour application, you’ve probably developed some valuable insights.
We’ll use these insights to develop a heuristic (i.e., a common-sense rule) for moving the knight.
Heuristics do not guarantee success, but a carefully developed heuristic greatly improves the chance of success.
You may have observed that the outer squares are more troublesome than the squares nearer the center of the board.
In fact, the most troublesome or inaccessible squares are the four corners.
Intuition may suggest that you should attempt to move the knight to the most troublesome squares first and leave open those that are easiest to get to,
so that when the board gets congested near the end of the tour, there will be a greater chance of success.
We could develop an “accessibility heuristic” by classifying each of the squares according to how accessible it is and always moving the knight
(using the knight’s L-shaped moves) to the most inaccessible square.
We label a two-dimensional array accessibility with numbers indicating from how many squares each particular square is accessible.
On a blank chessboard, each of the 16 squares nearest the center is rated as 8, each corner square is rated as 2,
and the other squares have accessibility numbers of 3, 4 or 6 as follows:
2  3  4  4  4  4  3  2
3  4  6  6  6  6  4  3
4  6  8  8  8  8  6  4
4  6  8  8  8  8  6  4
4  6  8  8  8  8  6  4
4  6  8  8  8  8  6  4
3  4  6  6  6  6  4  3
2  3  4  4  4  4  3  2
Write a new version of the Knight’s Tour, using the accessibility heuristic.
The knight should always move to the square with the lowest accessibility number.
In case of a tie, the knight may move to any of the tied squares.
Therefore, the tour may begin in any of the four corners.
[Note: As the knight moves around the chessboard, your application should reduce the accessibility numbers as more squares become occupied.
In this way, at any given time during the tour, each available square’s accessibility number will remain equal to precisely the number of squares
from which that square may be reached.]
Run this version of your application.
Did you get a full tour? Modify the application to run 64 tours, one starting from each square of the chessboard.
How many full tours did you get?

4.	Write a version of the Knight’s Tour application that, when encountering a tie between two or more squares,
decides what square to choose by looking ahead to those squares reachable from the “tied” squares.
Your application should move to the tied square for which the next move would arrive at a square with the lowest accessibility number.
 */

import java.util.Random; // uses Random

public class KnightTourC
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

	// new to Part 3
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
				done = true; // time to quit
				System.out.println("Knight's Tour is complete!!!");
			}
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
					System.out.printf("%2d ", chessboard[i][j]); // display chess board
				}
				System.out.printf("%s %2d",columns, i); 
				System.out.println(""); // creates new line between rows
			}
		}
		System.out.printf("%s%n", rows);
		System.out.printf("%s%n", rowheader);
	} // end method ChessBoard

} // end class KnightTourC
