package game_aspects;

import tictactoe.Player;
import tictactoe.TicTacToe;

/**
 * Manages player turn switching after successful moves.
 * <p>
 * This aspect observes calls to {@code Board.setMove(...)} and switches
 * {@code TicTacToe.currentPlayer} and {@code TicTacToe.otherPlayer} only
 * when the move is successfully placed.
 * <p>
 * {@code AspectOrder} ensures that game-end evaluation performed by
 * {@code RefereeAspect} occurs before this aspect switches the active player.
 * This preserves the correct player context when a winning move is evaluated.
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public aspect TurnAspect {

    /**
     * Matches calls to {@code Board.setMove(int, int, char)}.
     */
    pointcut moveMade():
            call(boolean tictactoe.Board.setMove(int, int, char));

    /**
     * Switches the active players after a successful move.
     * <p>
     * A rejected move leaves the current turn unchanged.
     *
     * @param result {@code true} if the move was successfully placed
     */
    after() returning(boolean result): moveMade() {
        if (result) {
            Player temp = TicTacToe.currentPlayer;
            TicTacToe.currentPlayer = TicTacToe.otherPlayer;
            TicTacToe.otherPlayer = temp;
        }
    }
}
