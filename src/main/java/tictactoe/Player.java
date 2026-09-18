package tictactoe;

/*
 * Licensed under the MIT License.
 * See LICENSE file in the project root for full license information.
 */

/**
 * Represents a player in the TicTacToe game.
 * <p>
 * Each player has a name provided during game setup and a symbol
 * ({@code 'X'} or {@code 'O'}) assigned before play begins.
 * The player's name remains unchanged for the lifetime of the object,
 * while the symbol is assigned during game initialization.
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public class Player {

    private final String name;
    private char symbol = ' ';

    /**
     * Constructs a player with the specified name.
     *
     * @param name the player's name
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Returns the player's name.
     *
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the player's assigned symbol.
     *
     * @return the player's symbol, or a space if a symbol has not yet been assigned
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Assigns the player's game symbol.
     *
     * @param symbol the symbol to assign
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
