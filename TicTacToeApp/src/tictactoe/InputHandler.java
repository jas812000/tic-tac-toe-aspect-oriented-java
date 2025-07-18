package tictactoe;

import java.util.Scanner;

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
 * Handles input requests from the current player.
 *
 * This class serves as a symbolic entry point for AspectJ-based input validation.
 * The actual input logic is injected at runtime via {@code InputAspect}.
 *
 * This design promotes separation of concerns by keeping validation logic modular
 * and reusable across the system.
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public class InputHandler {

    // Shared scanner instance for reading input from the console
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * Placeholder method intercepted by {@code InputAspect} to handle player input.
     *
     * The injected aspect is responsible for:
     * - Prompting the player for input
     * - Validating board boundaries (1–3)
     * - Ensuring the selected cell is empty
     *
     * @param board the current game board (used during validation)
     * @return an int array containing the selected row and column (0-based)
     */
    public static int[] getPlayerMove(Board board) {
        // This method will be intercepted by the InputAspect at runtime
        return new int[] { -1, -1 }; // Default placeholder; never actually used
    } 
}


