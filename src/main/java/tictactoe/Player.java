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
 * Represents a player in the TicTacToe game.
 *
 * Each player has:
 * - A name, provided at the start of the game
 * - A symbol ('X' or 'O'), assigned randomly during setup
 *
 * This class provides accessors for both fields and a method to assign the symbol.
 * Used by the game controller to manage turn order and player-specific data.
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public class Player {

    private String name;           // Player's name
    private char symbol = ' ';     // Player's symbol ('X' or 'O'), set after initialization

    /**
     * Constructs a player with the specified name.
     *
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Returns the player's name.
     *
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the player's symbol.
     *
     * @return the symbol ('X' or 'O') assigned to the player
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Assigns a symbol ('X' or 'O') to the player.
     *
     * @param symbol the character representing the player on the board
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
