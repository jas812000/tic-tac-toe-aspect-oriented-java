package tictactoe;

import java.util.Scanner;

/**
 * Validates player move input for the TicTacToe game.
 * <p>
 * This class prompts the current player for a row and column, validates
 * numeric input and board boundaries, ensures the selected cell is available,
 * and supports exiting the application from either input prompt.
 *
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public class InputValidator {

    /**
     * Prompts the current player until a valid move is entered.
     * <p>
     * Row and column values are entered using the user-facing range
     * {@code 1-3} and converted to zero-based indexes before being returned.
     * Entering {@code exit} at either prompt terminates the application.
     *
     * @param board the current game board
     * @return an array containing the zero-based row and column indexes
     */
    public static int[] getValidMove(Board board) {
        Scanner scanner = InputHandler.scanner;

        while (true) {
            System.out.println("\n" + TicTacToe.currentPlayer.getName()
                    + " (Player '" + TicTacToe.currentPlayer.getSymbol() + "')");

            System.out.print("Row (1-3) or type 'exit': ");
            String rowInput = scanner.nextLine().trim();

            if (rowInput.equalsIgnoreCase("exit")) {
                exitGame();
            }

            Integer row = parsePosition(rowInput);

            if (row == null) {
                continue;
            }

            System.out.print("Column (1-3) or type 'exit': ");
            String colInput = scanner.nextLine().trim();

            if (colInput.equalsIgnoreCase("exit")) {
                exitGame();
            }

            Integer col = parsePosition(colInput);

            if (col == null) {
                continue;
            }

            if (board.getCell(row, col) != ' ') {
                System.out.println("Invalid move. Cell already taken. Try again.");
                continue;
            }

            return new int[]{row, col};
        }
    }

    /**
     * Converts a user-entered board position to a zero-based index.
     *
     * @param input the user-entered position
     * @return the zero-based index, or {@code null} if the input is invalid
     */
    private static Integer parsePosition(String input) {
        try {
            int position = Integer.parseInt(input);

            if (position < 1 || position > 3) {
                System.out.println("Invalid entry. Please enter a number between 1 and 3.");
                return null;
            }

            return position - 1;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a numeric value between 1 and 3.");
            return null;
        }
    }

    /**
     * Displays the exit message and terminates the application.
     */
    private static void exitGame() {
        System.out.println("\nExiting TicTacToe. Goodbye!");
        System.exit(0);
    }
}
