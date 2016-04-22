package tdt4240.chess.Models.Chessmen;

import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Models.Utility.ChessmanColor;
import tdt4240.chess.Models.Utility.StateContext;
import tdt4240.chess.Models.Utility.States.PawnState;

public class Pawn extends Chessman {

    public Pawn(int x, int y, ChessmanColor chessmanColor) {
        super(chessmanColor);
        this.setBounds(x, y, 1, 1);

        context = new StateContext();
        context.setState(new PawnState(), this);
        context.setMoves(this);
    }
}
