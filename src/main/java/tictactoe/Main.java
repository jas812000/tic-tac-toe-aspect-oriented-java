package tictactoe;

/**
 * Entry point for the TicTacToe application.
 */
public class Main {

    public static void main(String[] args) {
        while (true) {
            try {
                new TicTacToe().startGame();
                return; // normal exit path (e.g., user chose not to restart)
            } catch (RestartRequested e) {
                // Start a fresh game loop
            }
        }
    }
}
