package game_aspects;

import tictactoe.Board;
import tictactoe.InputValidator;

/**
 * Redirects player move requests to centralized input validation.
 * <p>
 * This aspect intercepts calls to
 * {@code InputHandler.getPlayerMove(Board)} and delegates input collection
 * and validation to {@link InputValidator}.
 * <p>
 * Keeping this behavior in an aspect separates input-validation concerns
 * from the main game controller and demonstrates Aspect-Oriented Programming
 * through an explicit interception point.
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public aspect InputAspect {

    /**
     * Matches calls to {@code InputHandler.getPlayerMove(Board)} and binds
     * the board argument used for move validation.
     *
     * @param board the current game board
     */
    pointcut inputCall(Board board):
            call(int[] tictactoe.InputHandler.getPlayerMove(Board))
                    && args(board);

    /**
     * Replaces the intercepted input request with validated console input.
     *
     * @param board the current game board used for move validation
     * @return an array containing the zero-based row and column indexes
     */
    int[] around(Board board): inputCall(board) {
        return InputValidator.getValidMove(board);
    }
}
