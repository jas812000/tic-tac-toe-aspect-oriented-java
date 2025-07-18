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
 * Entry point for the TicTacToe application.
 *
 * This class contains the {@code main} method, which instantiates the
 * {@link TicTacToe} game and starts the main game loop.
 *
 * Core gameplay logic is managed within the {@code TicTacToe} class and 
 * modularized through aspect-oriented programming (AOP).
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public class Main {

    /**
     * Starts the game by creating and launching a TicTacToe instance.
     *
     * @param args Command-line arguments (unused)
     */
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();  // Create game instance
        game.startGame();                  // Start the game
    }
}
