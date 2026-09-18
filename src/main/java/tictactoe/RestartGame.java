package tictactoe;

import java.util.Scanner;

/**
 * Handles the post-game workflow for restarting or exiting the application.
 * <p>
 * When a restart is requested, the user may choose to reuse the previous
 * player names or enter new names for the next game.
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public class RestartGame {

    /**
     * Prompts the user to restart or exit after the current game ends.
     * <p>
     * If the user chooses to restart, the player-name reuse preference is
     * stored in {@link PlayerSession}, and a {@link RestartRequested}
     * exception signals the application loop to begin a new game.
     * <p>
     * Invalid responses are rejected until the user enters {@code y} or
     * {@code n}. Choosing not to restart terminates the application.
     *
     * @throws RestartRequested when the user chooses to start another game
     */
    public void promptRestart() {
        Scanner scanner = InputHandler.scanner;

        while (true) {
            System.out.print("\nWould you like to play again? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("y")) {
                if (PlayerSession.hasPlayers()) {
                    while (true) {
                        System.out.print(
                                "Same players (" + PlayerSession.player1()
                                        + " vs " + PlayerSession.player2()
                                        + ")? (y/n): "
                        );

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
