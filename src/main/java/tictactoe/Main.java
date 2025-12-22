package tictactoe;

/*
 * Licensed under the MIT License.
 * See LICENSE file in the project root for full license information.
 */

/**
 * Entry point for the TicTacToe application.
 *
 * This class contains the {@code main} method, which instantiates the
 * {@link TicTacToe} game and starts the main game loop.
 *
 * Core gameplay logic is managed within the {@code TicTacToe} class and 
 * modularized through aspect-oriented programming (AOP).
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public class Main {

    /**
     * Starts the game by creating and launching a TicTacToe instance.
     *
     * @param args Command-line arguments (unused)
     */
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();  // Create game instance
        game.startGame();                  // Start the game
    }
}
