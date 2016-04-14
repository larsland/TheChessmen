package tdt4240.chess;

import org.junit.Test;
import org.junit.runner.RunWith;

import tdt4240.chess.Models.Board;

import static org.junit.Assert.assertTrue;

/**
 * Created by iver on 14/04/16.
 */

@RunWith(GdxTestRunner.class)
public class BoardTest {

    @Test
    public void board_CorrectNumberOfTiles() {
        Board board = new Board();
        assertTrue(board.getTiles().length == 8);
    }
}
