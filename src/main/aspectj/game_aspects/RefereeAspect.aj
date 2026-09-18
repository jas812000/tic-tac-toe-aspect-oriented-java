package game_aspects;

import tictactoe.Board;
import tictactoe.Referee;

/**
 * Handles board rendering and game-end evaluation after successful moves.
 * <p>
 * This aspect observes calls to {@code Board.setMove(...)} and, when a move
 * is successfully placed, displays the updated board and delegates win/draw
 * evaluation to {@link Referee}.
 * <p>
 * {@code AspectOrder} ensures this aspect executes before {@code TurnAspect}
 * so the player who made the move remains the current player while the
 * referee evaluates the board and announces a winner.
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public aspect RefereeAspect {

    private final Referee referee = new Referee();

    /**
     * Matches calls to {@code Board.setMove(int, int, char)} and binds the
     * target board instance.
     *
     * @param board the board on which the move is attempted
     */
    pointcut moveMade(Board board):
            call(boolean Board.setMove(int, int, char)) && target(board);

    /**
     * Displays and evaluates the board after a successful move.
     * <p>
     * If the attempted move is rejected, no rendering or game-state
     * evaluation occurs.
     *
     * @param board  the board on which the move was attempted
     * @param result {@code true} if the move was successfully placed
     */
    after(Board board) returning(boolean result): moveMade(board) {
        if (result) {
            board.display();
            referee.checkGameOver(board);
        }
    }
}
