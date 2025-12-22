package tictactoe;

/*
 * Author: James Stevens
 * Date: 01 July 2025
 * Course: SWEN 656 - Advanced Software Design and Implementation
 * 
 * Copyright (c) 2025 James Stevens
 * This file is part of the TicTacToe project and may not be used, copied,
 * modified, or distributed without permission.
 */

/**
 * Manages the 3x3 game board for TicTacToe.
 *
 * This class is responsible for:
 * - Initializing the board with empty cells
 * - Displaying the board to the console
 * - Placing player moves
 * - Providing access to the board state for evaluation
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public class Board {
	private char[][] grid = new char[3][3];  // 3x3 grid representing the game board

	/**
	 * Initializes a new game board by setting all cells to empty.
	 */
	public Board() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				grid[i][j] = ' ';  // Empty cell
			}
		}
	}

	/**
	 * Displays the current state of the board in a formatted 3x3 grid.
	 */
	public void display() {
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(grid[i][j] + " | ");
			}
			System.out.println("\n-------------");
		}
	}

	/**
	 * Attempts to place the specified symbol on the board at the given position.
	 *
	 * @param row the row index (0–2)
	 * @param col the column index (0–2)
	 * @param playerSymbol the player's symbol ('X' or 'O')
	 * @return true if the move is valid and placed; false if the cell is already occupied
	 */
	public boolean setMove(int row, int col, char playerSymbol) {
		if (grid[row][col] == ' ') {
			grid[row][col] = playerSymbol;
			return true;
		}
		return false;
	}

	/**
	 * Returns the internal representation of the game board.
	 *
	 * @return a 2D character array containing the current board state
	 */
	public char[][] getGrid() {
		return grid;
	}
}
