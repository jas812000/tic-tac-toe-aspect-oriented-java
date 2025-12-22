package game_aspects;

import tictactoe.Player;
import tictactoe.TicTacToe;

/*
 * Author: James Stevens
 * Date: 01 July 2025
 * Course: SWEN 656 - Advanced Software Design and Implementation
 * 
 * Copyright (c) 2025 James Stevens
 * This file is part of the TicTacToe project and may not be used, copied,
 * modified, or distributed without permission.
 */

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


