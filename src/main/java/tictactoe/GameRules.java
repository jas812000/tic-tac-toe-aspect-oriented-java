package tictactoe;

import java.util.Optional;

/**
 * Provides pure rule evaluation for the TicTacToe game.
 * <p>
 * This class contains no input/output operations or application state,
 * allowing game rules to be evaluated independently and tested directly.
 * It is used by {@link Referee} to determine whether a game has been won
 * or ended in a draw.
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public final class GameRules {

    /**
     * Prevents instantiation of this utility class.
     */
    private GameRules() {
    }

    /**
     * Determines whether the board contains a winning row, column, or diagonal.
     *
     * @param grid the current board state
     * @return an {@link Optional} containing the winning symbol if a winner
     *         exists; otherwise an empty {@code Optional}
     */
    public static Optional<Character> winner(char[][] grid) {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] != ' '
                    && grid[i][0] == grid[i][1]
                    && grid[i][1] == grid[i][2]) {
                return Optional.of(grid[i][0]);
            }

            if (grid[0][i] != ' '
                    && grid[0][i] == grid[1][i]
                    && grid[1][i] == grid[2][i]) {
                return Optional.of(grid[0][i]);
            }
        }

        if (grid[0][0] != ' '
                && grid[0][0] == grid[1][1]
                && grid[1][1] == grid[2][2]) {
            return Optional.of(grid[0][0]);
        }

        if (grid[0][2] != ' '
                && grid[0][2] == grid[1][1]
                && grid[1][1] == grid[2][0]) {
            return Optional.of(grid[0][2]);
        }

        return Optional.empty();
    }

    /**
     * Determines whether the game has ended in a draw.
     * <p>
     * A draw occurs when every board position is occupied and no winning
     * combination exists.
     *
     * @param grid the current board state
     * @return {@code true} if the board is full and has no winner;
     *         otherwise {@code false}
     */
    public static boolean isDraw(char[][] grid) {
        if (winner(grid).isPresent()) {
            return false;
        }

        for (char[] row : grid) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }

        return true;
    }
}
