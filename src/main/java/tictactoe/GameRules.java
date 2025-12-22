package tictactoe;

import java.util.Optional;

/**
 * Pure, testable TicTacToe rule evaluation (no I/O, no static game state).
 * Used for unit tests and can be called by Referee.
 */
public final class GameRules {

    private GameRules() {}

    /**
     * @return Optional winner symbol ('X' or 'O') if a winner exists, otherwise empty.
     */
    public static Optional<Character> winner(char[][] g) {
        // rows + cols
        for (int i = 0; i < 3; i++) {
            if (g[i][0] != ' ' && g[i][0] == g[i][1] && g[i][1] == g[i][2]) return Optional.of(g[i][0]);
            if (g[0][i] != ' ' && g[0][i] == g[1][i] && g[1][i] == g[2][i]) return Optional.of(g[0][i]);
        }

        // diagonals
        if (g[0][0] != ' ' && g[0][0] == g[1][1] && g[1][1] == g[2][2]) return Optional.of(g[0][0]);
        if (g[0][2] != ' ' && g[0][2] == g[1][1] && g[1][1] == g[2][0]) return Optional.of(g[0][2]);

        return Optional.empty();
    }

    /**
     * Draw = board full AND no winner.
     */
    public static boolean isDraw(char[][] g) {
        if (winner(g).isPresent()) return false;

        for (char[] row : g) {
            for (char c : row) {
                if (c == ' ') return false;
            }
        }
        return true;
    }
}
