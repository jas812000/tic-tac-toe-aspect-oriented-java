package game_aspects;

import tictactoe.Board;
import tictactoe.Referee;

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
 * Aspect: RefereeAspect
 *
 * Handles post-move game evaluation and board rendering.
 *
 * This aspect intercepts calls to {@code Board.setMove(...)} and, after each move:
 * - Displays the updated board state
 * - Checks for win or draw conditions via the {@code Referee} class
 *
 * By modularizing this logic, the core game controller remains focused on flow control,
 * while endgame responsibilities are delegated cleanly.
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public aspect RefereeAspect {

    // Single instance of Referee to evaluate game state
    private Referee referee = new Referee();

    /**
     * Pointcut: Captures any call to Board.setMove(...) and
     * binds the target Board instance to the 'board' parameter.
     */
    pointcut moveMade(Board board): 
        call(boolean Board.setMove(int, int, char)) && target(board);

    /**
     * After advice: Executes after each call to {@code Board.setMove(...)}.
     *
     * Responsibilities:
     * - Displays the updated board to the console
     * - Delegates win/draw evaluation to the {@code Referee}
     *
     * @param board the board instance that was modified
     */
    after(Board board): moveMade(board) {
        board.display();                  // Show updated board
        referee.checkGameOver(board);    // Evaluate win/draw conditions
    }
}
