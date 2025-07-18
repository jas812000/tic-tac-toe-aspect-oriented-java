package tictactoe;

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
 * Handles game-end logic by checking the board for win or draw conditions.
 *
 * This class is invoked automatically after each move via {@code RefereeAspect},
 * and is responsible for detecting:
 * - Wins: horizontal, vertical, or diagonal
 * - Draws: full board with no winner
 *
 * If a game-ending condition is met, it prints the result and prompts the user to restart.
 *
 * This logic is modularized and decoupled from the main game loop using Aspect-Oriented Programming (AOP).
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public class Referee {
	
	private final RestartGame restartGame = new RestartGame(); // Handles restart prompt and logic

	/**
	 * Evaluates the current board to determine if a win or draw has occurred.
	 * 
	 * Called automatically after each move via AOP (RefereeAspect).
	 *
	 * @param board the current game board
	 */
    public void checkGameOver(Board board) {
        char[][] g = board.getGrid();  // Retrieve the current board state

        // Check each row and column for a winning line
        for (int i = 0; i < 3; i++) {
            if (g[i][0] != ' ' && g[i][0] == g[i][1] && g[i][1] == g[i][2]) {
                announceWinner(g[i][0]);  // Horizontal win
            }
            if (g[0][i] != ' ' && g[0][i] == g[1][i] && g[1][i] == g[2][i]) {
                announceWinner(g[0][i]);  // Vertical win
            }
        }

        // Check diagonals for a win
        if (g[0][0] != ' ' && g[0][0] == g[1][1] && g[1][1] == g[2][2]) {
            announceWinner(g[0][0]);  // Diagonal from top-left
        }
        if (g[0][2] != ' ' && g[0][2] == g[1][1] && g[1][1] == g[2][0]) {
            announceWinner(g[0][2]);  // Diagonal from top-right
        }

        // Check for a full board (draw)
        boolean full = true;
        for (char[] row : g) {
            for (char c : row) {
                if (c == ' ') {
                    full = false;
                    break;
                }
            }
            if (!full) break;
        }

        if (full) {
            System.out.println("\nGame is a draw!");
            restartGame.promptRestart();  	// Offer to restart the game
        }
    }

    /**
     * Announces the winner based on the symbol and restarts or ends the game.
     *
     * @param playerSymbol the symbol ('X' or 'O') of the winning player
     */
    private void announceWinner(char playerSymbol) {
        String winnerName = (TicTacToe.currentPlayer.getSymbol() == playerSymbol)
                ? TicTacToe.currentPlayer.getName()
                : TicTacToe.otherPlayer.getName();

        System.out.println("\n" + winnerName + " (Player '" + playerSymbol + "') wins!");
        restartGame.promptRestart();  	// Offer to restart the game
    }
}

