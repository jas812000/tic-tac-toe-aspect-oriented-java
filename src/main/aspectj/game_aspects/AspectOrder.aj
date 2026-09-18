package game_aspects;

/*
 * Licensed under the MIT License.
 * See LICENSE file in the project root for full license information.
 */

/**
 * Defines execution precedence for aspects that advise the same move operation.
 * <p>
 * {@code RefereeAspect} must evaluate the board before {@code TurnAspect}
 * switches the active player. This ordering ensures that a winning move is
 * evaluated while the player who made that move is still represented by
 * {@code TicTacToe.currentPlayer}.
 * <p>
 * The declared precedence therefore preserves correct winner identification
 * and turn-management behavior.
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public aspect AspectOrder {

    /**
     * Ensures {@code RefereeAspect} executes before {@code TurnAspect} when
     * both aspects advise the same join point.
     */
    declare precedence: RefereeAspect, TurnAspect;
}
