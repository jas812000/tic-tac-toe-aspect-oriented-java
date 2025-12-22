package tictactoe;

import java.util.Scanner;

/**
 * Handles prompting the user to restart or exit the game after it ends.
 */
public class RestartGame {

    /**
     * Prompts the user to restart the game or exit.
     * On restart, throws RestartRequested to unwind the current game loop.
     */
    public void promptRestart() {
        Scanner scanner = InputHandler.scanner;

        while (true) {
            System.out.print("\nWould you like to play again? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("y")) {
                System.out.println();
                throw new RestartRequested();
            }

            if (response.equals("n")) {
                System.out.println("\nThank you for playing TicTacToe. Goodbye!");
                System.exit(0);
            }

            System.out.println("Please enter 'y' or 'n'.");
        }
    }
}
