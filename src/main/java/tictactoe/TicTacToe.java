package tictactoe;

import java.util.Random;
import java.util.Scanner;

/**
 * The core game controller for TicTacToe.
 * 
 * This class handles player setup, board creation, and the main game loop.
 * It prompts for player names (letters only), assigns player symbols,
 * randomly selects who goes first, and delegates move handling to InputHandler.
 * 
 * Game logic such as validating moves, detecting win/draw conditions,
 * and switching turns is modularized via Aspect-Oriented Programming (AOP).
 * 
 * @author James Stevens
 * @version 1.0
 * @since 2025-07-01
 */
public class TicTacToe {

    public static Player currentPlayer;      // The player whose turn it is
    public static Player otherPlayer;        // The player waiting

    private Board board = new Board();       // The game board instance
    private Scanner scanner = new Scanner(System.in); // Scanner for player name input

    /**
     * Starts the game by initializing players, displaying rules, and launching the main game loop.
     * 
     * Responsibilities:
     * - Displays game introduction and rules
     * - Accepts player names (letters only)
     * - Randomly selects which player goes first
     * - Assigns symbols ('X' and 'O')
     * - Displays the initial empty board
     * - Begins game loop, delegating input and move processing to aspects
     */
    public void startGame() {

        // --- Game Introduction ---
        System.out.println("=================================");
        System.out.println("   Welcome to Tic-Tac-Toe!");
        System.out.println("=================================");
        System.out.println("Rules:");
        System.out.println("1. This is a 2-player game.");
        System.out.println("2. The board is a 3x3 grid. Players take turns placing their symbol (X or O).");
        System.out.println("3. Enter row and column numbers from 1 to 3.");
        System.out.println("4. A player wins by lining up 3 of their symbols in a row, column, or diagonal.");
        System.out.println("5. If the board is full and no one has won, it's a draw.");
        System.out.println("---------------------------------\n");

        // --- Player Setup ---
        String name1;
        String name2;

        if (PlayerSession.consumeReuseFlag() && PlayerSession.hasPlayers()) {
            name1 = PlayerSession.player1();
            name2 = PlayerSession.player2();
            System.out.println("Using same players: " + name1 + " vs " + name2);
        } else {
            while (true) {
                System.out.print("Enter name for Player 1 (letters only) or type 'exit': ");
                name1 = scanner.nextLine().trim();
                if (name1.equalsIgnoreCase("exit")) {
                    System.out.println("\nExiting TicTacToe. Goodbye!");
                    System.exit(0);
                }
                if (name1.matches("[a-zA-Z]+")) break;
                System.out.println("Invalid name. Please use letters only (no numbers or symbols).");
            }

            while (true) {
                System.out.print("Enter name for Player 2 (letters only) or type 'exit': ");
                name2 = scanner.nextLine().trim();
                if (name2.equalsIgnoreCase("exit")) {
                    System.out.println("\nExiting TicTacToe. Goodbye!");
                    System.exit(0);
                }
                if (name2.matches("[a-zA-Z]+")) break;
                System.out.println("Invalid name. Please use letters only (no numbers or symbols).");
            }

            PlayerSession.remember(name1, name2);
        }

        // Create Player objects using valid names
        Player player1 = new Player(name1);
        Player player2 = new Player(name2);

        // --- Random First Player Selection ---
        if (new Random().nextBoolean()) {
            currentPlayer = player1;
            otherPlayer = player2;
        } else {
            currentPlayer = player2;
            otherPlayer = player1;
        }

        // --- Symbol Assignment ---
        currentPlayer.setSymbol('X');
        otherPlayer.setSymbol('O');

        System.out.println("\n" + currentPlayer.getName()
                + " goes first and is '"
                + currentPlayer.getSymbol() + "'.");

        // --- Initial Board Display ---
        board.display();

        // --- Main Game Loop ---
        // Repeats indefinitely. InputHandler.getPlayerMove is intercepted by an aspect,
        // which delegates to InputValidator. After move is applied, RefereeAspect checks for win/draw.
        while (true) {
            int[] move = InputHandler.getPlayerMove(board); // Intercepted by InputAspect
            int row = move[0];
            int col = move[1];

            // Apply the move. This call triggers RefereeAspect to update board and check for game over.
            board.setMove(row, col, currentPlayer.getSymbol());
        }
    }
}
