package tictactoe;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GameRulesTest {

    private static char[][] empty() {
        return new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
    }

    @Test
    void winner_emptyBoard_isEmpty() {
        assertEquals(Optional.empty(), GameRules.winner(empty()));
    }

    @Test
    void winner_rowWin_detectsWinner() {
        char[][] g = empty();
        g[1][0] = 'X';
        g[1][1] = 'X';
        g[1][2] = 'X';

        assertEquals(Optional.of('X'), GameRules.winner(g));
    }

    @Test
    void winner_columnWin_detectsWinner() {
        char[][] g = empty();
        g[0][2] = 'O';
        g[1][2] = 'O';
        g[2][2] = 'O';

        assertEquals(Optional.of('O'), GameRules.winner(g));
    }

    @Test
    void winner_diagonalTopLeft_detectsWinner() {
        char[][] g = empty();
        g[0][0] = 'X';
        g[1][1] = 'X';
        g[2][2] = 'X';

        assertEquals(Optional.of('X'), GameRules.winner(g));
    }

    @Test
    void winner_diagonalTopRight_detectsWinner() {
        char[][] g = empty();
        g[0][2] = 'O';
        g[1][1] = 'O';
        g[2][0] = 'O';

        assertEquals(Optional.of('O'), GameRules.winner(g));
    }

    @Test
    void isDraw_fullBoardNoWinner_isTrue() {
        // A known draw position (no three-in-a-row)
        char[][] g = new char[][]{
                {'X', 'O', 'X'},
                {'X', 'O', 'O'},
                {'O', 'X', 'X'}
        };

        assertTrue(GameRules.isDraw(g));
        assertEquals(Optional.empty(), GameRules.winner(g));
    }

    @Test
    void isDraw_notFull_isFalse() {
        char[][] g = empty();
        g[0][0] = 'X';

        assertFalse(GameRules.isDraw(g));
    }

    @Test
    void isDraw_winnerPresent_isFalseEvenIfBoardFull() {
        char[][] g = new char[][]{
                {'X', 'X', 'X'}, // winner row
                {'O', 'O', 'X'},
                {'O', 'X', 'O'}
        };

        assertFalse(GameRules.isDraw(g));
        assertEquals(Optional.of('X'), GameRules.winner(g));
    }
}
