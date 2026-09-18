package tictactoe;

import java.util.Scanner;

/**
 * Provides the AspectJ interception point for player move input.
 * <p>
 * The {@link #getPlayerMove(Board)} method intentionally contains no input
 * implementation. Calls to it are intercepted by {@code InputAspect}, which
 * delegates the actual prompting and validation to {@link InputValidator}.
 * <p>
 * The class also owns the shared console scanner used by the application's
 * input-related classes.
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public class InputHandler {

    /**
     * Shared scanner used for console input throughout the application.
     */
    static final Scanner scanner = new Scanner(System.in);

    /**
     * Provides a symbolic interception point for AspectJ-managed player input.
     * <p>
     * {@code InputAspect} intercepts calls to this method and delegates input
     * collection and validation to {@link InputValidator}. If AspectJ weaving
     * is not active, this method throws an exception rather than silently
     * bypassing the required input behavior.
     *
     * @param board the current game board used during move validation
     * @return an array containing the zero-based row and column indexes
     * @throws IllegalStateException if the call is not intercepted by
     *                               {@code InputAspect}
     */
    public static int[] getPlayerMove(Board board) {
        throw new IllegalStateException(
                "InputHandler.getPlayerMove must be intercepted by InputAspect"
        );
    }
}
