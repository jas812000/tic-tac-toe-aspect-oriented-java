package tictactoe;

/**
 * Control-flow exception used to unwind the current game loop when a restart is requested.
 */
public class RestartRequested extends RuntimeException {
    public RestartRequested() {
        super();
    }
}
