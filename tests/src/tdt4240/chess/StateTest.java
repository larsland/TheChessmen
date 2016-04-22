package tdt4240.chess;

import org.junit.Test;
import org.junit.runner.RunWith;

import tdt4240.chess.AssetClasses.GraphicsAssets;
import tdt4240.chess.Controllers.ChessmanController;
import tdt4240.chess.Models.Chessmen.Pawn;
import tdt4240.chess.Models.Utility.ChessmanColor;
import tdt4240.chess.Models.Utility.States.QueenState;

import static org.junit.Assert.assertTrue;


@RunWith(GdxTestRunner.class)
public class StateTest {

    @Test
    public void stateTest_PawnInitialLegalMovesTest() {
        Pawn pawn = new Pawn(1, 1, ChessmanColor.BLACK);
        assertTrue(pawn.getLegalMoves().size() == 2);
    }

    @Test
    public void stateTest_PawnSpriteTest() {
        Pawn pawn = new Pawn(1, 1, ChessmanColor.BLACK);
        assertTrue(pawn.getSprite() == GraphicsAssets.chessmenCollection[0]);
    }

    @Test
    public void stateTest_PawnBecomesQueenTest() {
        ChessmanController cc = new ChessmanController();
        Pawn pawn = new Pawn(0, 0, ChessmanColor.BLACK);
        cc.moved(pawn);
        assertTrue(pawn.getContext().getState().getClass().equals(QueenState.class));

    }
}
