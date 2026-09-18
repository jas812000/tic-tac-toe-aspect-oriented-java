package tictactoe;

/*
 * Licensed under the MIT License.
 * See LICENSE file in the project root for full license information.
 */

/**
 * Handles game-end logic by checking the board for win and draw conditions.
 * <p>
 * This class is invoked automatically after each successful move via
 * {@code RefereeAspect}. It is responsible for detecting and announcing
 * a winner or identifying a draw.
 * <p>
 * When a game-ending condition is detected, the result is displayed and
 * the user is prompted to restart or exit the game.
 * <p>
 * This logic is kept separate from the main game loop through
 * Aspect-Oriented Programming (AOP).
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public class Referee {

    private final RestartGame restartGame = new RestartGame(); // Handles restart prompt and logic

    /**
     * Evaluates the current board to determine whether a win or draw has occurred.
     * <p>
     * Called automatically after each successful move through
     * {@code RefereeAspect}.
     *
     * @param board the current game board
     */
    public void checkGameOver(Board board) {
        char[][] g = board.getGrid();

        var winner = GameRules.winner(g);
        if (winner.isPresent()) {
            announceWinner(winner.get());
            return;
        }

        if (GameRules.isDraw(g)) {
            System.out.println("\nGame is a draw!");
            restartGame.promptRestart();
        }
    }

    /**
     * Announces the winning player and prompts the user to restart or exit.
     *
     * @param playerSymbol the symbol ({@code 'X'} or {@code 'O'}) of the winning player
     */
    private void announceWinner(char playerSymbol) {
        String winnerName = (TicTacToe.currentPlayer.getSymbol() == playerSymbol)
                ? TicTacToe.currentPlayer.getName()
                : TicTacToe.otherPlayer.getName();

        System.out.println("\n" + winnerName + " (Player '" + playerSymbol + "') wins!");
        restartGame.promptRestart();
    }
}
