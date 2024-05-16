// Exercise 7.22 Part C Solution: Knight2.java
// Knight's Tour - heuristic version
import java.util.Random;

public class Knight2
{
	private static final Random randomNumbers = new Random();

	private static int[][] access = 
		{{2, 3, 4, 4, 4, 4, 3, 2},
				{3, 4, 6, 6, 6, 6, 4, 3},
				{4, 6, 8, 8, 8, 8, 6, 4},
				{4, 6, 8, 8, 8, 8, 6, 4},
				{4, 6, 8, 8, 8, 8, 6, 4},
				{4, 6, 8, 8, 8, 8, 6, 4},
				{3, 4, 6, 6, 6, 6, 4, 3},
				{2, 3, 4, 4, 4, 4, 3, 2}};

	private static int[][] board; // gameboard
	private static int accessNumber; // the current access number

	// moves
	private static int[] horizontal = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private static int[] vertical = { -1, -2, -2, -1, 1, 2, 2, 1 };

	// initialize applet
	public static void main(String[] args)
	{
		int moveNumber = 0; // the current move number

		int minRow = -1; // row position of move with minimum access
		int minColumn = -1; // row position of move with minimum access

		board = new int[8][8];

		// randomize initial board position
		int currentRow = randomNumbers.nextInt(8);
		int currentColumn = randomNumbers.nextInt(8);

		board[currentRow][currentColumn] = ++moveNumber;
		boolean done = false;

		// continue touring until finished traversing
		while (!done)
		{
			accessNumber = 99;

			// try all possible moves
			for (int moveType = 0; moveType < board.length; moveType++)
			{
				// new position of hypothetical moves
				int testRow = currentRow + vertical[moveType];
				int testColumn = currentColumn + horizontal[moveType];

				if (validMove(testRow, testColumn))
				{
					// obtain access number
					if (access[testRow][testColumn] < accessNumber)
					{
						// if this is the lowest access number thus far,
						// then set this move to be our next move
						accessNumber = access[testRow][testColumn];

						minRow = testRow;
						minColumn = testColumn;
					}

					// position access number tried
					--access[testRow][testColumn];
				}
			}

			// traversing done
			if (accessNumber == 99) // no valid moves
			{
				done = true;
			}
			else // make move
			{
				currentRow = minRow;
				currentColumn = minColumn;
				board[currentRow][currentColumn] = ++moveNumber;
			}
		}

		System.out.printf("The tour ended with %d moves.\n", moveNumber);

		if (moveNumber == 64)
		{
			System.out.println(" This was a full tour!");
		}
		else
		{
			System.out.println(" This was not a full tour.");
		}

		printTour();
	}

	// checks for valid move
	public static boolean validMove(int row, int column)
	{
		// returns false if the move is off the chessboard, or if
		// the knight has already visited that position
		// NOTE: This test stops as soon as it becomes false
		return (row >= 0 && row < 8 && column >= 0 && column < 8
				&& board[row][column] == 0);
	}

	// display Knight's tour path
	public static void printTour()
	{
		// display numbers for column
		for (int k = 0; k < 8; k++)
		{
			System.out.printf("\t%d", k);
		}

		System.out.print("\n\n");

		for (int row = 0; row < board.length; row++)
		{
			System.out.print (row);

			for (int column = 0; column < board[row].length; column++)
			{
				System.out.printf("\t%d", board[row][column]);
			}

			System.out.println();
		}
	}
}


/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
