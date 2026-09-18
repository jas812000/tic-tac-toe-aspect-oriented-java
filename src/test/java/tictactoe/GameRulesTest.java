package tictactoe;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for {@link GameRules}.
 */
class GameRulesTest {

    /**
     * Creates an empty 3x3 board for use in individual rule tests.
     *
     * @return a new empty board state
     */
    private static char[][] emptyBoard() {
        return new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
    }

    @Test
    void winner_emptyBoard_isEmpty() {
        assertEquals(Optional.empty(), GameRules.winner(emptyBoard()));
    }

    @Test
    void winner_rowWin_detectsWinner() {
        char[][] grid = emptyBoard();
        grid[1][0] = 'X';
        grid[1][1] = 'X';
        grid[1][2] = 'X';

        assertEquals(Optional.of('X'), GameRules.winner(grid));
    }

    @Test
    void winner_columnWin_detectsWinner() {
        char[][] grid = emptyBoard();
        grid[0][2] = 'O';
        grid[1][2] = 'O';
        grid[2][2] = 'O';

        assertEquals(Optional.of('O'), GameRules.winner(grid));
    }

    @Test
    void winner_diagonalTopLeft_detectsWinner() {
        char[][] grid = emptyBoard();
        grid[0][0] = 'X';
        grid[1][1] = 'X';
        grid[2][2] = 'X';

        assertEquals(Optional.of('X'), GameRules.winner(grid));
    }

    @Test
    void winner_diagonalTopRight_detectsWinner() {
        char[][] grid = emptyBoard();
        grid[0][2] = 'O';
        grid[1][1] = 'O';
        grid[2][0] = 'O';

        assertEquals(Optional.of('O'), GameRules.winner(grid));
    }

    @Test
    void isDraw_fullBoardWithoutWinner_isTrue() {
        char[][] grid = {
                {'X', 'O', 'X'},
                {'X', 'O', 'O'},
                {'O', 'X', 'X'}
        };

        assertTrue(GameRules.isDraw(grid));
        assertEquals(Optional.empty(), GameRules.winner(grid));
    }

    @Test
    void isDraw_incompleteBoard_isFalse() {
        char[][] grid = emptyBoard();
        grid[0][0] = 'X';

        assertFalse(GameRules.isDraw(grid));
    }

    @Test
    void isDraw_fullBoardWithWinner_isFalse() {
        char[][] grid = {
                {'X', 'X', 'X'},
                {'O', 'O', 'X'},
                {'O', 'X', 'O'}
        };

        assertFalse(GameRules.isDraw(grid));
        assertEquals(Optional.of('X'), GameRules.winner(grid));
    }
}
