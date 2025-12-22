package tictactoe;

import java.util.Scanner;

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
 * Provides validation for player move input in the TicTacToe game.
 *
 * Responsibilities include:
 * - Prompting the current player for move coordinates
 * - Validating numeric input and board boundaries
 * - Ensuring the selected cell is not already occupied
 *
 * Called by {@code InputAspect} to keep validation logic modular and reusable.
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public class InputValidator {

	/**
	 * Prompts the current player for input until a valid move is entered.
	 *
	 * This method handles:
	 * - Numeric input validation
	 * - Bounds checking (1–3, converted to 0-based)
	 * - Cell occupancy checks
	 *
	 * @param board the current game board
	 * @return an integer array containing the valid row and column (0-based)
	 */
    public static int[] getValidMove(Board board) {

        // Use the shared scanner from InputHandler
        Scanner scanner = InputHandler.scanner;

        int row = -1, col = -1;

        while (true) {
            try {
                // Display the current player's name and symbol
                System.out.println("\n" + TicTacToe.currentPlayer.getName()
                    + " (Player '" + TicTacToe.currentPlayer.getSymbol() + "')");

                // Prompt the user for row and column input (1–3)
                System.out.println("Enter row and column (1-3) separated by a space (e.g., 2 3) or type 'exit':");
                System.out.print("> ");
                String line = scanner.nextLine().trim();

                if (line.equalsIgnoreCase("exit")) {
                    System.out.println("\nExiting TicTacToe. Goodbye!");
                    System.exit(0);
                }

                String[] parts = line.split("\\s+");
                if (parts.length != 2) {
                    System.out.println("Invalid input. Please enter two numbers like: 2 3");
                    continue;
                }

                try {
                    row = Integer.parseInt(parts[0]);
                    col = Integer.parseInt(parts[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter numeric values only.");
                    continue;
                }
// Convert from 1-based to 0-based indexing
                row--;
                col--;

                // Validate row and column bounds
                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    System.out.println("Invalid entry. Row and column must be between 1 and 3.");
                    continue;
                }

                // Check if the chosen cell is already occupied
                if (board.getGrid()[row][col] != ' ') {
                    System.out.println("Invalid move. Cell already taken. Try again.");
                    continue;
                }

                // Valid move found
                return new int[] { row, col };

            } catch (Exception e) {
                // Handle non-numeric input and clear invalid input from buffer
                System.out.println("Invalid input. Please enter numeric values only.");
                scanner.nextLine(); // Clear buffer
            }
        }
    }
}

