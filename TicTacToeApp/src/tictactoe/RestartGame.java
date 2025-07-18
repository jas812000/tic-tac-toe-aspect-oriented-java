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
 * Utility class responsible for prompting the user to restart or exit the game.
 *
 * This class uses the shared {@code Scanner} instance from {@code InputHandler} 
 * to maintain consistent input handling throughout the application.
 *
 * Prompts the user until a valid input is received.
 * Valid responses include "y", "yes", "n", and "no" (case-insensitive).
 *
 * If the user confirms, a new game session is launched;
 * otherwise, the program terminates gracefully.
 * 
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public class RestartGame {

	/**
	 * Prompts the user to restart or exit the game.
	 *
	 * Responsibilities:
	 * - Clears leftover input from previous operations.
	 * - Accepts "y", "yes", "n", or "no" (case-insensitive).
	 * - Repeats prompt until valid input is received.
	 *
	 * If the user opts to restart, a new game instance is launched.
	 * Otherwise, the application exits cleanly.
	 */
    public void promptRestart() {

        // Use the shared scanner from InputHandler to avoid multiple instances
        Scanner scanner = InputHandler.scanner;

        // Clear any leftover newline from previous nextInt() inputs
        if (scanner.hasNextLine()) scanner.nextLine();

        // Prompt user until valid response is given
        while (true) {
            System.out.print("\nWould you like to play again? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("y") || response.equals("yes")) {
                new TicTacToe().startGame();
                break; // Exit current method (new game started)
            } else if (response.equals("n") || response.equals("no")) {
                System.out.println("\nThank you for playing TicTacToe. Goodbye!");
                System.exit(0);
            } else {
                System.out.println("Invalid response. Please enter 'y' or 'n'.");
            }
        }
    }
}




