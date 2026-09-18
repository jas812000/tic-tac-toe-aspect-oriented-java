package tictactoe;

/**
 * Entry point for the TicTacToe application.
 * <p>
 * This class manages the application-level game loop. A new
 * {@link TicTacToe} game is started for each session, and a
 * {@link RestartRequested} exception signals that another game should begin.
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public class Main {

    /**
     * Starts the TicTacToe application and manages game restarts.
     *
     * @param args command-line arguments; not used by this application
     */
    public static void main(String[] args) {
        while (true) {
            try {
                new TicTacToe().startGame();
                return;
            } catch (RestartRequested e) {
                // Begin a new game while preserving the requested session state.
            }
        }
    }
}
