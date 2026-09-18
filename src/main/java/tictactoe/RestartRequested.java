package tictactoe;

/**
 * Signals that the current game should end and a new game should begin.
 * <p>
 * This exception is used for application control flow rather than to
 * represent an error. It allows the restart request to unwind the current
 * game loop and return control to the main application loop.
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public class RestartRequested extends RuntimeException {

    /**
     * Creates a new restart request.
     */
    public RestartRequested() {
        super();
    }
}
