package tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for {@link Board}.
 */
class BoardTest {

    @Test
    void newBoard_hasAllEmptyCells() {
        Board board = new Board();
        char[][] grid = board.getGrid();

        assertEquals(3, grid.length);
        assertEquals(3, grid[0].length);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                assertEquals(
                        ' ',
                        grid[row][col],
                        "Expected empty cell at [" + row + "][" + col + "]"
                );
            }
        }
    }

    @Test
    void setMove_placesSymbolOnEmptyCell_returnsTrue() {
        Board board = new Board();

        boolean applied = board.setMove(1, 1, 'X');

        assertTrue(applied);
        assertEquals('X', board.getCell(1, 1));
    }

    @Test
    void setMove_onOccupiedCell_returnsFalseAndDoesNotOverwrite() {
        Board board = new Board();

        assertTrue(board.setMove(0, 0, 'X'));
        assertFalse(board.setMove(0, 0, 'O'));
        assertEquals(
                'X',
                board.getCell(0, 0),
                "Cell should not be overwritten"
        );
    }

    @Test
    void setMove_doesNotModifyOtherCells() {
        Board board = new Board();

        board.setMove(2, 2, 'O');

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (row == 2 && col == 2) {
                    assertEquals('O', board.getCell(row, col));
                } else {
                    assertEquals(
                            ' ',
                            board.getCell(row, col),
                            "Unexpected modification at [" + row + "][" + col + "]"
                    );
                }
            }
        }
    }

    @Test
    void getGrid_returnsDefensiveCopy() {
        Board board = new Board();
        board.setMove(0, 0, 'X');

        char[][] gridCopy = board.getGrid();
        gridCopy[0][0] = 'O';

        assertEquals('X', board.getCell(0, 0));
    }
}
