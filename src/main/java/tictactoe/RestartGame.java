package tictactoe;

import java.util.Scanner;

/**
 * Handles prompting the user to restart or exit the game after it ends.
 */
public class RestartGame {

    public void promptRestart() {
        Scanner scanner = InputHandler.scanner;

        while (true) {
            System.out.print("\nWould you like to play again? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("y")) {
                if (PlayerSession.hasPlayers()) {
                    while (true) {
                        System.out.print("Same players (" + PlayerSession.player1() + " vs " + PlayerSession.player2() + ")? (y/n): ");
                        String same = scanner.nextLine().trim().toLowerCase();
                        if (same.equals("y")) {
                            PlayerSession.reuseOnNextGame(true);
                            break;
                        }
                        if (same.equals("n")) {
                            PlayerSession.reuseOnNextGame(false);
                            break;
                        }
                        System.out.println("Please enter 'y' or 'n'.");
                    }
                }

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
