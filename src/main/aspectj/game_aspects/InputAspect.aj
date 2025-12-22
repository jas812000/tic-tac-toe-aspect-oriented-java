package game_aspects;

import tictactoe.Board;
import tictactoe.InputValidator;

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
 * Aspect: InputAspect
 *
 * Redirects player input calls to a centralized validation method.
 *
 * This aspect intercepts calls to {@code InputHandler.getPlayerMove(Board)} and
 * reroutes them to {@code InputValidator.getValidMove(Board)} to enforce input validation
 * uniformly across the application.
 *
 * This decouples input validation from the core logic, aligning with AOP principles.
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public aspect InputAspect {

    /**
     * Pointcut: Matches any call to InputHandler.getPlayerMove(Board)
     */
    pointcut inputCall(Board board): 
        call(int[] tictactoe.InputHandler.getPlayerMove(Board)) && args(board);

    /**
     * Around advice: Redirects calls to {@code InputHandler.getPlayerMove(Board)}
     * so that all input is handled by {@code InputValidator.getValidMove(Board)}.
     *
     * @param board the current game board used for move validation
     * @return a validated move as an integer array: [0] = row, [1] = column
     */
    int[] around(Board board): inputCall(board) {
        return InputValidator.getValidMove(board);
    }
}