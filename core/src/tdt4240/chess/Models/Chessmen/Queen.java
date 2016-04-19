package tdt4240.chess.Models.Chessmen;

import tdt4240.chess.Models.Chessman;
import tdt4240.chess.Utility.ChessmanColor;
import tdt4240.chess.Utility.StateContext;
import tdt4240.chess.Utility.States.QueenState;

public class Queen extends Chessman {

    public Queen(int x, int y, ChessmanColor chessmanColor) {
        super(chessmanColor);
        this.setBounds(x, y, 1, 1);

        context = new StateContext();
        context.setState(new QueenState(), this);
        context.setMoves(this);
    }


}
