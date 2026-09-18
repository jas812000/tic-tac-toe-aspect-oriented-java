package tictactoe;

/*
 * Licensed under the MIT License.
 * See LICENSE file in the project root for full license information.
 */

/**
 * Represents and manages the 3x3 TicTacToe game board.
 * <p>
 * This class initializes the board, displays its current state, places valid
 * moves, and provides read-only access to board data for validation and
 * rule evaluation.
 * <p>
 * The internal grid is encapsulated so callers cannot modify the board
 * without using {@link #setMove(int, int, char)}.
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public class Board {

	private final char[][] grid = new char[3][3];

	/**
	 * Creates an empty 3x3 game board.
	 */
	public Board() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				grid[row][col] = ' ';
			}
		}
	}

	/**
	 * Displays the current board state as a formatted 3x3 grid.
	 */
	public void display() {
		System.out.println("-------------");

		for (int row = 0; row < 3; row++) {
			System.out.print("| ");

			for (int col = 0; col < 3; col++) {
				System.out.print(grid[row][col] + " | ");
			}

			System.out.println("\n-------------");
		}
	}

	/**
	 * Attempts to place a player's symbol at the specified board position.
	 *
	 * @param row          the zero-based row index
	 * @param col          the zero-based column index
	 * @param playerSymbol the player's symbol
	 * @return {@code true} if the symbol was placed; {@code false} if the
	 *         selected cell was already occupied
	 */
	public boolean setMove(int row, int col, char playerSymbol) {
		if (grid[row][col] == ' ') {
			grid[row][col] = playerSymbol;
			return true;
		}

		return false;
	}

	/**
	 * Returns a defensive copy of the current board state.
	 * <p>
	 * Changes made to the returned array do not affect the board's internal
	 * grid.
	 *
	 * @return a copy of the current 3x3 board
	 */
	public char[][] getGrid() {
		char[][] copy = new char[grid.length][];

		for (int row = 0; row < grid.length; row++) {
			copy[row] = grid[row].clone();
		}

		return copy;
	}

	/**
	 * Returns the symbol stored at the specified board position.
	 *
	 * @param row the zero-based row index
	 * @param col the zero-based column index
	 * @return the symbol at the specified position, or a space if the cell
	 *         is empty
	 */
	public char getCell(int row, int col) {
		return grid[row][col];
	}
}
