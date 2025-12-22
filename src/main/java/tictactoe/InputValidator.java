package tictactoe;

import java.util.Scanner;

/**
 * Provides validation for player move input in the TicTacToe game.
 *
 * - Prompts for row then column (1–3)
 * - Validates numeric input and board boundaries
 * - Ensures the selected cell is not already occupied
 * - Supports typing 'exit' (case-insensitive) to quit at any prompt
 */
public class InputValidator {

    /**
     * Prompts the current player for input until a valid move is entered.
     *
     * @param board the current game board
     * @return an integer array containing the valid row and column (0-based)
     */
    public static int[] getValidMove(Board board) {
        Scanner scanner = InputHandler.scanner;

        while (true) {
            System.out.println("\n" + TicTacToe.currentPlayer.getName()
                    + " (Player '" + TicTacToe.currentPlayer.getSymbol() + "')");

            // Read row
            System.out.print("Row (1-3) or type 'exit': ");
            String rowInput = scanner.nextLine().trim();
            if (rowInput.equalsIgnoreCase("exit")) {
                System.out.println("\nExiting TicTacToe. Goodbye!");
                System.exit(0);
            }

            // Read column
            System.out.print("Column (1-3) or type 'exit': ");
            String colInput = scanner.nextLine().trim();
            if (colInput.equalsIgnoreCase("exit")) {
                System.out.println("\nExiting TicTacToe. Goodbye!");
                System.exit(0);
            }

            int row;
            int col;
            try {
                row = Integer.parseInt(rowInput) - 1;
                col = Integer.parseInt(colInput) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numeric values only.");
                continue;
            }

            // Bounds check
            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid entry. Row and column must be between 1 and 3.");
                continue;
            }

            // Occupancy check
            if (board.getGrid()[row][col] != ' ') {
                System.out.println("Invalid move. Cell already taken. Try again.");
                continue;
            }

            return new int[] { row, col };
        }
    }
}
