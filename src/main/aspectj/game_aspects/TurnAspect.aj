package game_aspects;

import tictactoe.Player;
import tictactoe.TicTacToe;

/**
 * Aspect: TurnAspect
 *
 * Manages turn switching between players after successful moves.
 *
 * This aspect intercepts calls to {@code Board.setMove(...)} and,
 * if the move is valid (returns {@code true}), it swaps
 * {@code currentPlayer} and {@code otherPlayer} in the {@code TicTacToe} class.
 *
 * This ensures that turns only alternate when a move has been successfully placed,
 * preserving game integrity.
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public aspect TurnAspect {

    /**
     * Pointcut: Matches any call to Board.setMove(...) that returns a boolean.
     */
    pointcut moveMade(): call(boolean tictactoe.Board.setMove(int, int, char));

    /**
     * After advice: Executes following a successful call to {@code Board.setMove(...)}.
     *
     * If the returned value is {@code true}, the players are swapped to alternate turns.
     *
     * @param result the return value from {@code setMove(...)} indicating if the move was accepted
     */
    after() returning(boolean result): moveMade() {
        if (result) {
            Player temp = TicTacToe.currentPlayer;
            TicTacToe.currentPlayer = TicTacToe.otherPlayer;
            TicTacToe.otherPlayer = temp;
        }
    }
}


