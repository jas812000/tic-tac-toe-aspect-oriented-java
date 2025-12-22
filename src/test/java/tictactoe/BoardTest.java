package tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void newBoard_hasAllEmptyCells() {
        Board b = new Board();
        char[][] g = b.getGrid();

        assertEquals(3, g.length);
        assertEquals(3, g[0].length);

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                assertEquals(' ', g[r][c], "Expected empty cell at [" + r + "][" + c + "]");
            }
        }
    }

    @Test
    void setMove_placesSymbolOnEmptyCell_returnsTrue() {
        Board b = new Board();
        boolean applied = b.setMove(1, 1, 'X');

        assertTrue(applied);
        assertEquals('X', b.getGrid()[1][1]);
    }

    @Test
    void setMove_onOccupiedCell_returnsFalseAndDoesNotOverwrite() {
        Board b = new Board();

        assertTrue(b.setMove(0, 0, 'X'));
        assertFalse(b.setMove(0, 0, 'O'));
        assertEquals('X', b.getGrid()[0][0], "Cell should not be overwritten");
    }

    @Test
    void setMove_doesNotModifyOtherCells() {
        Board b = new Board();
        b.setMove(2, 2, 'O');

        char[][] g = b.getGrid();
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (r == 2 && c == 2) {
                    assertEquals('O', g[r][c]);
                } else {
                    assertEquals(' ', g[r][c], "Unexpected modification at [" + r + "][" + c + "]");
                }
            }
        }
    }
}
